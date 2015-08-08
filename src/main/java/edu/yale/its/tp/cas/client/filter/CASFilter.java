/*  Copyright (c) 2000-2004 Yale University. All rights reserved.
 *  See full notice at end.
 */

package edu.yale.its.tp.cas.client.filter;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.yale.its.tp.cas.client.CASAuthenticationException;
import edu.yale.its.tp.cas.client.CASReceipt;
import edu.yale.its.tp.cas.client.ProxyTicketValidator;
import edu.yale.its.tp.cas.client.Util;

/**
 * <p>
 * Protects web-accessible resources with CAS.
 * </p>
 *
 * <p>
 * The following filter initialization parameters are declared in
 * <code>web.xml</code>:
 * </p>
 *
 * <ul>
 * <li><code>edu.yale.its.tp.cas.client.filter.loginUrl</code>: URL to login
 * page on CAS server. (Required)</li>
 * <li><code>edu.yale.its.tp.cas.client.filter.validateUrl</code>: URL to
 * validation URL on CAS server. (Required)</li>
 * <li><code>edu.yale.its.tp.cas.client.filter.serviceUrl</code>: URL of this
 * service. (Required if <code>serverName</code> is not specified)</li>
 * <li><code>edu.yale.its.tp.cas.client.filter.serverName</code>: full hostname
 * with port number (e.g. <code>www.foo.com:8080</code>). Port number isn't
 * required if it is standard (80 for HTTP, 443 for HTTPS). (Required if
 * <code>serviceUrl</code> is not specified)</li>
 * <li><code>edu.yale.its.tp.cas.client.filter.authorizedProxy</code>:
 * whitespace-delimited list of valid proxies through which authentication may
 * have proceeded. One one proxy must match. (Optional. If nothing is specified,
 * the filter will only accept service tickets &#150; not proxy tickets.)</li>
 * <li><code>edu.yale.its.tp.cas.client.filter.proxyCallbackUrl</code>: URL of
 * local proxy callback listener used to acquire PGT/PGTIOU. (Optional.)</li>
 * <li><code>edu.yale.its.tp.cas.client.filter.renew</code>: value of CAS
 * "renew" parameter. Bypasses single sign-on and requires user to provide CAS
 * with his/her credentials again. (Optional. If nothing is specified, this
 * defaults to false.)</li>
 * <li><code>edu.yale.its.tp.cas.client.filter.gateway</code>: value of CAS
 * "gateway" parameter. Redirects initial call through CAS and if the user has
 * logged in, validates the ticket on return. If the user has not logged in,
 * returns to the web application without setting the
 * <code>CAS_FILTER_USER</code> variable. Note that once a redirect through CAS
 * has occurred, the filter will not automatically try again to log the user in.
 * You can then either provide an explicit CAS login link (
 * <code>https://cas-server/cas/login?service=http://your-app</code>) or set up
 * two instances of the filter mapped to different paths. One instance would
 * have gateway=true, the other wouldn't. When you need the user to be logged
 * in, direct him/her to the path of the other filter.</li>
 * <li><code>edu.yale.its.tp.cas.client.filter.wrapRequest</code>: wrap the
 * <code>HttpServletRequest</code> object, overriding the
 * <code>getRemoteUser()</code> method. When set to "true",
 * <code>request.getRemoteUser()</code> will return the username of the
 * currently logged-in CAS user. (Optional. If nothing is specified, this
 * defaults to false.)</li>
 * </ul>
 *
 * <p>
 * The logged-in username is set in the session attribute defined by the value
 * of <code>CAS_FILTER_USER</code> and may be accessed from within your
 * application either by setting <code>wrapRequest</code> and calling
 * <code>request.getRemoteUser()</code>, or by calling
 * <code>session.getAttribute(CASFilter.CAS_FILTER_USER)</code>.
 * </p>
 *
 * <p>
 * If <code>proxyCallbackUrl</code> is set, the URL will be passed to CAS upon
 * validation. If the callback URL is valid, it will receive a CAS PGT and a
 * PGTIOU. The PGTIOU will be returned to this filter and will be accessible
 * through the session attribute, <code>CASFilter.CAS_FILTER_PGTIOU</code>. You
 * may then acquire proxy tickets to other services by calling
 * <code>edu.yale.its.tp.cas.proxy.ProxyTicketReceptor.getProxyTicket(pgtIou, targetService)</code>.
 *
 * @author Shawn Bayern
 * @author Drew Mazurek
 * @author andrew.petro@yale.edu
 */
public class CASFilter implements Filter {

    private ServletContext servletContext;

    private static Log log = LogFactory.getLog(CASFilter.class);

    // Filter initialization parameters

    /**
     * The name of the filter initialization parameter the value of which should
     * be the https: address of the CAS Login servlet. Optional parameter, but
     * required for successful redirection of unauthenticated requests to
     * authentication.
     */
    public final static String LOGIN_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.loginUrl";

    public final static String LOGOUT_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.logoutUrl";

    /**
     * The name of the filter initialization parameter the value of which must
     * be the https: address of the CAS Validate servlet. Must be a CAS 2.0
     * validate servlet (CAS 1.0 non-XML won't suffice). Required parameter.
     */
    public final static String VALIDATE_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.validateUrl";

    /**
     * The name of the filter initialization parameter the value of which must
     * be the address of the service this filter is filtering. The filter will
     * use this as the service parameter for CAS login and validation. Either
     * this parameter or SERVERNAME_INIT_PARAM must be set.
     */
    public final static String SERVICE_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.serviceUrl";

    /**
     * The name of the filter initialization parameter the vlaue of which must
     * be the server name, e.g. www.yale.edu , of the service this filter is
     * filtering. The filter will construct from this name and the request the
     * full service parameter for CAS login and validation.
     */
    public final static String SERVERNAME_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.serverName";

    /**
     * The name of the filter initialization parameter the value of which must
     * be the String that should be sent as the "renew" parameter on the request
     * for login and validation. This should either be "true" or not be set. It
     * is mutually exclusive with GATEWAY.
     */
    public final static String RENEW_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.renew";

    /**
     * The name of the filter initialization parameter the value of which must
     * be a whitespace delimited list of services (ProxyTicketReceptors)
     * authorized to proxy authentication to the service filtered by this
     * Filter. These must be https: URLs. This parameter is optional - not
     * setting it results in no proxy tickets being acceptable.
     */
    public final static String AUTHORIZED_PROXY_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.authorizedProxy";

    /**
     * The name of the filter initialization parameter the value of which must
     * be the https: URL to which CAS should send Proxy Granting Tickets when
     * this filter validates tickets.
     */
    public final static String PROXY_CALLBACK_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.proxyCallbackUrl";

    /**
     * The name of the filter initialization parameter the value of which
     * indicates whether this filter should wrap requests to expose the
     * authenticated username.
     */
    public final static String WRAP_REQUESTS_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.wrapRequest";

    /**
     * The name of the filter initialization parameter the value of which is the
     * value the Filter should send for the gateway parameter on the CAS login
     * request.
     */
    public final static String GATEWAY_INIT_PARAM = "edu.yale.its.tp.cas.client.filter.gateway";

    // Session attributes used by this filter

    /**
     * <p>
     * Session attribute in which the username is stored.
     * </p>
     */
    public final static String CAS_FILTER_USER = "edu.yale.its.tp.cas.client.filter.user";

    /**
     * Session attribute in which the CASReceipt is stored.
     */
    public final static String CAS_FILTER_RECEIPT = "edu.yale.its.tp.cas.client.filter.receipt";

    /**
     * Session attribute in which internally used gateway attribute is stored.
     */
    private static final String CAS_FILTER_GATEWAYED = "edu.yale.its.tp.cas.client.filter.didGateway";

    /**
     * 海口Opus的登录地址, 不合法的登录全部转向这里
     */
    private static final String HAIKOU_OPUS_HOMEPAGE_PARAM = "haikouOpsHomePage";

    // *********************************************************************
    // Configuration state

    /** Secure URL whereat CAS offers its login service. */
    private String casLogin;

    public static String CAS_LOGOUT_URL;

    /** Secure URL whereat CAS offers its CAS 2.0 validate service */
    private String casValidate;

    /** Filtered service URL for use as service parameter to login and validate */
    private String casServiceUrl;

    /**
     * Name of server, for use in assembling service URL for use as service
     * parameter to login and validate.
     */
    private String casServerName;

    public static String CAS_SERVER_NAME;
    /**
     * Secure URL whereto this filter should ask CAS to send Proxy Granting
     * Tickets.
     */
    private String casProxyCallbackUrl;

    /** True if renew parameter should be set on login and validate */
    private boolean casRenew;

    /**
     * True if this filter should wrap requests to expose authenticated user as
     * getRemoteUser();
     */
    private boolean wrapRequest;

    /** True if this filter should set gateway=true on login redirect */
    private boolean casGateway = false;

    /**
     * List of ProxyTicketReceptor URLs of services authorized to proxy to the
     * path behind this filter.
     */
    private List authorizedProxies = new ArrayList();

    /**
     * 海口OPUS的地址
     */
    private static String haikouOpusHomePage;

    // *********************************************************************
    // Initialization

    @Override
    public void init(FilterConfig config) throws ServletException {

        servletContext = config.getServletContext();
        haikouOpusHomePage = config
                .getInitParameter(HAIKOU_OPUS_HOMEPAGE_PARAM);

        casLogin = config.getInitParameter(LOGIN_INIT_PARAM);
        CAS_LOGOUT_URL = config.getInitParameter(LOGOUT_INIT_PARAM);
        casValidate = config.getInitParameter(VALIDATE_INIT_PARAM);
        casServiceUrl = config.getInitParameter(SERVICE_INIT_PARAM);
        String casAuthorizedProxy = config
                .getInitParameter(AUTHORIZED_PROXY_INIT_PARAM);
        casRenew = Boolean.valueOf(config.getInitParameter(RENEW_INIT_PARAM))
                .booleanValue();
        casServerName = config.getInitParameter(SERVERNAME_INIT_PARAM);
        CAS_SERVER_NAME = casServerName;
        casProxyCallbackUrl = config
                .getInitParameter(PROXY_CALLBACK_INIT_PARAM);
        wrapRequest = Boolean.valueOf(
                config.getInitParameter(WRAP_REQUESTS_INIT_PARAM))
                .booleanValue();
        casGateway = Boolean.valueOf(
                config.getInitParameter(GATEWAY_INIT_PARAM)).booleanValue();

        if (casGateway && Boolean.valueOf(casRenew).booleanValue()) {
            throw new ServletException(
                    "gateway and renew cannot both be true in filter configuration");
        }
        if (casServerName != null && casServiceUrl != null) {
            throw new ServletException(
                    "serverName and serviceUrl cannot both be set: choose one.");
        }
        if (casServerName == null && casServiceUrl == null) {
            throw new ServletException(
                    "one of serverName or serviceUrl must be set.");
        }
        if (casServiceUrl != null) {
            if (!(casServiceUrl.startsWith("https://") || (casServiceUrl
                    .startsWith("http://")))) {
                throw new ServletException(
                        "service URL must start with http:// or https://; its current value is ["
                                + casServiceUrl + "]");
            }
        }

        if (casValidate == null) {
            throw new ServletException("validateUrl parameter must be set.");
        }
        if (!(casValidate.startsWith("https://") || (casValidate
                .startsWith("http://")))) {
            throw new ServletException(
                    "validateUrl must start with http:// or https://, its current value is ["
                            + casValidate + "]");
        }

        if (casAuthorizedProxy != null) {

            // parse and remember authorized proxies
            StringTokenizer casProxies = new StringTokenizer(casAuthorizedProxy);
            while (casProxies.hasMoreTokens()) {
                String anAuthorizedProxy = casProxies.nextToken();
                if (!anAuthorizedProxy.startsWith("https://")) {
                    throw new ServletException(
                            "CASFilter initialization parameter for authorized proxies "
                                    + "must be a whitespace delimited list of authorized proxies.  "
                                    + "Authorized proxies must be secure (https) addresses.  This one wasn't: ["
                                    + anAuthorizedProxy + "]");
                }
                this.authorizedProxies.add(anAuthorizedProxy);
            }
        }

        if (log.isDebugEnabled()) {
            log.debug(("CASFilter initialized as: [" + toString() + "]"));
        }
    }

    // *********************************************************************
    // Filter processing

	/*
	 * @Override public void doFilter(ServletRequest request, ServletResponse
	 * response, FilterChain fc) throws ServletException, IOException {
	 * HttpServletRequest httpServletRequest = (HttpServletRequest) request; if
	 * (httpServletRequest.getServletPath().indexOf("/cas/cs-login.action") !=
	 * -1 || httpServletRequest.getServletPath().indexOf(
	 * "/cas/cs-tgt-validate.action") != -1 ||
	 * httpServletRequest.getServletPath().indexOf( "/cas/cs-logout.action") !=
	 * -1 || httpServletRequest.getServletPath().indexOf(
	 * "/auth/login!logout.action") != -1 ||
	 * httpServletRequest.getServletPath().indexOf(
	 * "/auth/login!findUserByPinId.action") != -1) { // 允许继续执行
	 * fc.doFilter(request, response); } else { if (log.isTraceEnabled()) {
	 * log.trace("entering doFilter()"); } // make sure we've got an HTTP
	 * request if (!(request instanceof HttpServletRequest) || !(response
	 * instanceof HttpServletResponse)) { log.error(
	 * "doFilter() called on a request or response that was not an HttpServletRequest or response."
	 * ); throw new ServletException( "CASFilter protects only HTTP resources");
	 * }
	 *
	 * // Is this a request for the proxy callback listener? If so, pass // it
	 * through if (casProxyCallbackUrl != null && casProxyCallbackUrl
	 * .endsWith(((HttpServletRequest) request) .getRequestURI()) &&
	 * request.getParameter("pgtId") != null && request.getParameter("pgtIou")
	 * != null) { log.trace(
	 * "passing through what we hope is CAS's request for proxy ticket receptor."
	 * ); fc.doFilter(request, response); return; }
	 *
	 * // Wrap the request if desired if (wrapRequest) {
	 * log.trace("Wrapping request with CASFilterRequestWrapper."); request =
	 * new CASFilterRequestWrapper( (HttpServletRequest) request); }
	 *
	 * String ctx = ((HttpServletRequest) request).getContextPath(); String
	 * requestUri = ((HttpServletRequest) request).getRequestURI();
	 *
	 * HttpSession session = ((HttpServletRequest) request).getSession(); // if
	 * our attribute's already present and valid, pass through the // filter
	 * chain CASReceipt receipt = (CASReceipt) session
	 * .getAttribute(CAS_FILTER_RECEIPT); if (receipt != null &&
	 * isReceiptAcceptable(receipt)) { log.trace(
	 * "CAS_FILTER_RECEIPT attribute was present and acceptable - passing  request through filter.."
	 * ); if (requestUri.equals(ctx + "/") && StringUtils.isNotBlank(request
	 * .getParameter("curPosId"))) { // 针对换岗操作 String newPostId =
	 * request.getParameter("curPosId"); UserCache userCache = (UserCache)
	 * session .getAttribute(Parameters.USER_CONTEXT); if (userCache != null) {
	 * if (!newPostId.equals(userCache.getPost().getPostId())) { PostWsService
	 * postWs = WebApplicationContextUtils .getRequiredWebApplicationContext(
	 * servletContext).getBean( PostWsServiceImpl.class);
	 * if(postWs.checkUserHasPostId(receipt.getUserName(), newPostId)){
	 * userCache = postWs.getUserCacheByNameAndPostId( receipt.getUserName(),
	 * newPostId); session.setAttribute(Parameters.USER_CONTEXT, userCache);
	 * System.out.println("合法的用户换岗操作"); fc.doFilter(request, response); return;
	 * } } } } else { fc.doFilter(request, response); return; } } // otherwise,
	 * we need to authenticate via CAS String ticket =
	 * request.getParameter("ticket"); // no ticket? abort request processing
	 * and redirect if (ticket == null || ticket.equals("")) {
	 * log.trace("CAS ticket was not present on request."); // did we go through
	 * the gateway already? boolean didGateway = Boolean.valueOf( (String)
	 * session.getAttribute(CAS_FILTER_GATEWAYED)) .booleanValue();
	 *
	 * if (casLogin == null) { // TODO: casLogin should probably be ensured to
	 * not be null // at filter initialization. -awp9 log.fatal(
	 * "casLogin was not set, so filter cannot redirect request for authentication."
	 * ); throw new ServletException(
	 * "When CASFilter protects pages that do not receive a 'ticket' " +
	 * "parameter, it needs a edu.yale.its.tp.cas.client.filter.loginUrl " +
	 * "filter parameter"); } if (!didGateway) {
	 * log.trace("Did not previously gateway.  Setting session attribute to true."
	 * ); session.setAttribute(CAS_FILTER_GATEWAYED, "true");
	 * redirectToCAS((HttpServletRequest) request, (HttpServletResponse)
	 * response); // abort chain return; } else {
	 * log.trace("Previously gatewayed."); // if we should be logged in, make
	 * sure validation succeeded if (casGateway ||
	 * session.getAttribute(CAS_FILTER_USER) != null) { log.trace(
	 * "casGateway was true and CAS_FILTER_USER set: passing request along filter chain."
	 * ); // continue processing the request fc.doFilter(request, response);
	 * return; } else { // unknown state... redirect to CAS
	 * session.setAttribute(CAS_FILTER_GATEWAYED, "true");
	 * redirectToCAS((HttpServletRequest) request, (HttpServletResponse)
	 * response); // abort chain return; } } } try { receipt =
	 * getAuthenticatedUser((HttpServletRequest) request);
	 * System.out.println(requestUri + "---" + ctx); } catch
	 * (CASAuthenticationException e) { log.error(e); throw new
	 * ServletException(e); } if (!isReceiptAcceptable(receipt)) { throw new
	 * ServletException(
	 * "Authentication was technically successful but rejected as a matter of policy. ["
	 * + receipt + "]"); } // requestUri.startsWith(ctx + "?curPosId=") if
	 * (requestUri.equals(ctx + "/") &&
	 * StringUtils.isNotBlank(request.getParameter("curPosId"))) { // String
	 * postId = requestUri.get String postId = request.getParameter("curPosId");
	 * PostWsService postWs = WebApplicationContextUtils
	 * .getRequiredWebApplicationContext(servletContext)
	 * .getBean(PostWsServiceImpl.class);
	 * if(postWs.checkUserHasPostId(receipt.getUserName(), postId)) { UserCache
	 * userCache = postWs.getUserCacheByNameAndPostId( receipt.getUserName(),
	 * postId); session.setAttribute(Parameters.USER_CONTEXT, userCache);
	 * System.out.println("合法的用户登录"); } else { return; } } else {
	 * redirectToCAS((HttpServletRequest) request, (HttpServletResponse)
	 * response); return; }
	 *
	 * // Store the authenticated user in the session if (session != null) { //
	 * probably unnecessary session.setAttribute(CAS_FILTER_USER,
	 * receipt.getUserName());
	 * session.setAttribute(CASFilter.CAS_FILTER_RECEIPT, receipt); // don't
	 * store extra unnecessary session state
	 * session.removeAttribute(CAS_FILTER_GATEWAYED); } if
	 * (log.isTraceEnabled()) {
	 * log.trace("validated ticket to get authenticated receipt [" + receipt +
	 * "], now passing request along filter chain."); }
	 *
	 * // //////////////////////////////////////
	 *
	 * // continue processing the request fc.doFilter(request, response);
	 * log.trace("returning from doFilter()"); }
	 *
	 * }
	 */

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     * 说明:
     * 1. 通过单点登录后, 需要传递curPosId传入岗位编号, 然后设置本系统的Session UserCache;
     * 2. 对于还没登录后, 进入本系统的url不是http://localhost:8080/DZGW?curPosId=xxx的形式, 会默认跳转到登录页面haikouOpusHomePage;
     * 3. 对于登录成功后, 还需要校验当前用户名是否拥有当前岗位编号, 防止当前用户登录成功后, 直接在浏览器中改变curPostId;
     * 4. 对于换岗操作, 需要判断当前的curPosId和上次Session UserCache里面的postId是否相等, 然后再验证当前用户名是否拥有此岗位编号
     */
	/*
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws ServletException, IOException {

		HttpSession session = ((HttpServletRequest) request).getSession();

		String ctx = ((HttpServletRequest) request).getContextPath();
		String requestUri = ((HttpServletRequest) request).getRequestURI();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		CASReceipt receipt = (CASReceipt) session.getAttribute(CAS_FILTER_RECEIPT);
		if (httpServletRequest.getServletPath().indexOf("/cas/cs-login.action") != -1
				|| httpServletRequest.getServletPath().indexOf(
						"/cas/cs-tgt-validate.action") != -1
				|| httpServletRequest.getServletPath().indexOf(
						"/cas/cs-logout.action") != -1
				|| httpServletRequest.getServletPath().indexOf(
						"/auth/login!logout.action") != -1
				|| httpServletRequest.getServletPath().indexOf(
						"/auth/login!findUserByPinId.action") != -1) {
			// 允许继续执行
			fc.doFilter(request, response);
		} else if (!(requestUri.equals(ctx + "/") && StringUtils
				.isNotBlank(request.getParameter("curPosId")))) {
			System.out.println("Entry");
			//如果请求的是非登录页面, 并且cas session不存在
			if (receipt == null) {
				System.out.println("Entry1");
				httpServletResponse.sendRedirect(haikouOpusHomePage);
				return;
			} else {
				//如果请求的是非登录页面, 且cas session存在
				if (receipt != null && isReceiptAcceptable(receipt)) {
					fc.doFilter(request, response);
					return;
				}
			}
		} else {
			//如果是正常的登录页面
			if (log.isTraceEnabled()) {
				log.trace("entering doFilter()");
			}
			if (!(request instanceof HttpServletRequest)
					|| !(response instanceof HttpServletResponse)) {
				log.error("doFilter() called on a request or response that was not an HttpServletRequest or response.");
				throw new ServletException(
						"CASFilter protects only HTTP resources");
			}

			// Is this a request for the proxy callback listener? If so, pass
			// it through
			if (casProxyCallbackUrl != null
					&& casProxyCallbackUrl
							.endsWith(((HttpServletRequest) request)
									.getRequestURI())
					&& request.getParameter("pgtId") != null
					&& request.getParameter("pgtIou") != null) {
				log.trace("passing through what we hope is CAS's request for proxy ticket receptor.");
				fc.doFilter(request, response);
				return;
			}

			// Wrap the request if desired
			if (wrapRequest) {
				log.trace("Wrapping request with CASFilterRequestWrapper.");
				request = new CASFilterRequestWrapper(
						(HttpServletRequest) request);
			}

			// if our attribute's already present and valid, pass through the
			// filter chain

			if (receipt != null && isReceiptAcceptable(receipt)) {
				log.trace("CAS_FILTER_RECEIPT attribute was present and acceptable - passing  request through filter..");
				// 针对换岗操作
					String newPostId = request.getParameter("curPosId");
					UserCache userCache = (UserCache) session
							.getAttribute(Parameters.USER_CONTEXT);
					if (userCache != null) {
						if (!newPostId.equals(userCache.getPost().getPostId())) {
							PostWsService postWs = WebApplicationContextUtils
									.getRequiredWebApplicationContext(
											servletContext).getBean(
											PostWsServiceImpl.class);
							if (postWs.checkUserHasPostId(
									receipt.getUserName(), newPostId)) {
								userCache = postWs.getUserCacheByNameAndPostId(
										receipt.getUserName(), newPostId);
								session.setAttribute(Parameters.USER_CONTEXT,
										userCache);
								System.out.println("合法的用户换岗操作");
								fc.doFilter(request, response);
								return;
							} else {
								System.out.println("不合法的换岗操作");
								session.invalidate();
								httpServletResponse.sendRedirect(haikouOpusHomePage);
								return;
							}
						} else {
							System.out.println("没有进行换岗操作, 直接让过滤器跳转");
							fc.doFilter(request, response);
							return;
						}
					} else {
						//本系统会话超时
						session.invalidate();
						httpServletResponse.sendRedirect(haikouOpusHomePage);
						return;
					}
			}
			// otherwise, we need to authenticate via CAS
			String ticket = request.getParameter("ticket");
			// no ticket? abort request processing and redirect
			if (ticket == null || ticket.equals("")) {
				log.trace("CAS ticket was not present on request.");
				// did we go through the gateway already?
				boolean didGateway = Boolean.valueOf(
						(String) session.getAttribute(CAS_FILTER_GATEWAYED))
						.booleanValue();

				if (casLogin == null) {
					// TODO: casLogin should probably be ensured to not be null
					// at filter initialization. -awp9
					log.fatal("casLogin was not set, so filter cannot redirect request for authentication.");
					throw new ServletException(
							"When CASFilter protects pages that do not receive a 'ticket' "
									+ "parameter, it needs a edu.yale.its.tp.cas.client.filter.loginUrl "
									+ "filter parameter");
				}
				if (!didGateway) {
					log.trace("Did not previously gateway.  Setting session attribute to true.");
					session.setAttribute(CAS_FILTER_GATEWAYED, "true");
					redirectToCAS((HttpServletRequest) request,
							(HttpServletResponse) response);
					// abort chain
					return;
				} else {
					log.trace("Previously gatewayed.");
					// if we should be logged in, make sure validation succeeded
					if (casGateway
							|| session.getAttribute(CAS_FILTER_USER) != null) {
						log.trace("casGateway was true and CAS_FILTER_USER set: passing request along filter chain.");
						// continue processing the request
						fc.doFilter(request, response);
						return;
					} else {
						// unknown state... redirect to CAS
						session.setAttribute(CAS_FILTER_GATEWAYED, "true");
						redirectToCAS((HttpServletRequest) request,
								(HttpServletResponse) response);
						// abort chain
						return;
					}
				}
			}
			try {
				receipt = getAuthenticatedUser((HttpServletRequest) request);
			} catch (CASAuthenticationException e) {
				log.error(e);
				throw new ServletException(e);
			}
			if (!isReceiptAcceptable(receipt)) {
				throw new ServletException(
						"Authentication was technically successful but rejected as a matter of policy. ["
								+ receipt + "]");
			}
			// requestUri.startsWith(ctx + "?curPosId=")
			// String postId = requestUri.get
			String postId = request.getParameter("curPosId");
			PostWsService postWs = WebApplicationContextUtils
					.getRequiredWebApplicationContext(servletContext).getBean(
							PostWsServiceImpl.class);
			if (postWs.checkUserHasPostId(receipt.getUserName(), postId)) {
				UserCache userCache = postWs.getUserCacheByNameAndPostId(
						receipt.getUserName(), postId);
				session.setAttribute(Parameters.USER_CONTEXT, userCache);

				System.out.println("合法的用户登录");
			} else {
				session.invalidate();
				httpServletResponse.sendRedirect(haikouOpusHomePage);
				return;
			}
			// Store the authenticated user in the session
			if (session != null) {
				session.setAttribute(CAS_FILTER_USER, receipt.getUserName());
				session.setAttribute(CASFilter.CAS_FILTER_RECEIPT, receipt);
				// don't store extra unnecessary session state
				session.removeAttribute(CAS_FILTER_GATEWAYED);
			}
			if (log.isTraceEnabled()) {
				log.trace("validated ticket to get authenticated receipt ["
						+ receipt
						+ "], now passing request along filter chain.");
			}

			fc.doFilter(request, response);
			log.trace("returning from doFilter()");
		}

	}
	*/
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain fc) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        //下面的代码为适应平板端不进行cas拦截的设置, 683-696
        if(StringUtils.isNotBlank(httpServletRequest.getParameter("android"))) {
            fc.doFilter(request, response);
            return;
        }
        Enumeration headerNames = httpServletRequest.getHeaderNames();
        boolean checkIos = false;
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            if("user-agent".equals(headerName.toLowerCase())) {
                if("android".equals(httpServletRequest.getHeader(headerName).toLowerCase())) {
                    checkIos = true;
                    break;
                }
            }
        }
        if(checkIos) {
            fc.doFilter(request, response);
            return;
        }

        //对webservice服务接口的免验证
        String ctx = httpServletRequest.getContextPath();
        String requestUri = httpServletRequest.getRequestURI();
        if(requestUri.startsWith(ctx + "/ws/")) {
            return;
        }
        if(requestUri.startsWith(ctx + "/dispatching/")) {
            fc.doFilter(request, response);
            return;
        }
        if(requestUri.startsWith(ctx + "/attachment/upload")) {
            fc.doFilter(request, response);
            return;
        }
        if(requestUri.startsWith(ctx + "/dw/")) {
            fc.doFilter(request, response);
            return;
        }

        if(requestUri.startsWith(ctx + "/webservice/")) {
            fc.doFilter(request, response);
            return;
        }

        if(requestUri.startsWith(ctx + "/android/")) {
            fc.doFilter(request, response);
            return;
        }

        if(requestUri.startsWith(ctx + "/api/todo/receive")) {
            fc.doFilter(request, response);
            return;
        }

        if (httpServletRequest.getServletPath().indexOf("/cas/cs-login.action") != -1
                || httpServletRequest.getServletPath().indexOf(
                "/cas/cs-tgt-validate.action") != -1
                || httpServletRequest.getServletPath().indexOf(
                "/cas/cs-logout.action") != -1
                || httpServletRequest.getServletPath().indexOf(
                "/auth/login!logout.action") != -1
                || httpServletRequest.getServletPath().indexOf(
                "/auth/login!findUserByPinId.action") != -1) {
            // 允许继续执行
            fc.doFilter(request, response);
        } else {
            if (log.isTraceEnabled()) {
                log.trace("entering doFilter()");
            }
            // make sure we've got an HTTP request
            if (!(request instanceof HttpServletRequest)
                    || !(response instanceof HttpServletResponse)) {
                log.error("doFilter() called on a request or response that was not an HttpServletRequest or response.");
                throw new ServletException(
                        "CASFilter protects only HTTP resources");
            }

            // Is this a request for the proxy callback listener? If so, pass
            // it through
            if (casProxyCallbackUrl != null
                    && casProxyCallbackUrl
                    .endsWith(((HttpServletRequest) request)
                            .getRequestURI())
                    && request.getParameter("pgtId") != null
                    && request.getParameter("pgtIou") != null) {
                log.trace("passing through what we hope is CAS's request for proxy ticket receptor.");
                fc.doFilter(request, response);
                return;
            }

            // Wrap the request if desired
            if (wrapRequest) {
                log.trace("Wrapping request with CASFilterRequestWrapper.");
                request = new CASFilterRequestWrapper(
                        (HttpServletRequest) request);
            }

            HttpSession session = ((HttpServletRequest) request).getSession();
            // if our attribute's already present and valid, pass through the
            // filter chain
            CASReceipt receipt = (CASReceipt) session
                    .getAttribute(CAS_FILTER_RECEIPT);
            if (receipt != null && isReceiptAcceptable(receipt)) {
                log.trace("CAS_FILTER_RECEIPT attribute was present and acceptable - passing  request through filter..");
                fc.doFilter(request, response);
                return;
            }
            // otherwise, we need to authenticate via CAS
            String ticket = request.getParameter("ticket");
            // no ticket? abort request processing and redirect
            if (ticket == null || ticket.equals("")) {
                log.trace("CAS ticket was not present on request.");
                // did we go through the gateway already?
                boolean didGateway = Boolean.valueOf(
                        (String) session.getAttribute(CAS_FILTER_GATEWAYED))
                        .booleanValue();

                if (casLogin == null) {
                    // TODO: casLogin should probably be ensured to not be null
                    // at filter initialization. -awp9
                    log.fatal("casLogin was not set, so filter cannot redirect request for authentication.");
                    throw new ServletException(
                            "When CASFilter protects pages that do not receive a 'ticket' "
                                    + "parameter, it needs a edu.yale.its.tp.cas.client.filter.loginUrl "
                                    + "filter parameter");
                }
                if (!didGateway) {
                    log.trace("Did not previously gateway.  Setting session attribute to true.");
                    session.setAttribute(CAS_FILTER_GATEWAYED, "true");
                    redirectToCAS((HttpServletRequest) request,
                            (HttpServletResponse) response);
                    // abort chain
                    return;
                } else {
                    log.trace("Previously gatewayed.");
                    // if we should be logged in, make sure validation succeeded
                    if (casGateway
                            || session.getAttribute(CAS_FILTER_USER) != null) {
                        log.trace("casGateway was true and CAS_FILTER_USER set: passing request along filter chain.");
                        // continue processing the request
                        fc.doFilter(request, response);
                        return;
                    } else {
                        // unknown state... redirect to CAS
                        session.setAttribute(CAS_FILTER_GATEWAYED, "true");
                        redirectToCAS((HttpServletRequest) request,
                                (HttpServletResponse) response);
                        // abort chain
                        return;
                    }
                }
            }
            try {
                receipt = getAuthenticatedUser((HttpServletRequest) request);
            } catch (CASAuthenticationException e) {
                log.error(e);
                throw new ServletException(e);
            }
            if (!isReceiptAcceptable(receipt)) {
                throw new ServletException(
                        "Authentication was technically successful but rejected as a matter of policy. ["
                                + receipt + "]");
            }
			/*
			String postId = request.getParameter("curPosId");
			PostWsService postWs = WebApplicationContextUtils
					.getRequiredWebApplicationContext(servletContext).getBean(
							PostWsServiceImpl.class);
			if (postWs.checkUserHasPostId(receipt.getUserName(), postId)) {
				UserCache userCache = postWs.getUserCacheByNameAndPostId(
						receipt.getUserName(), postId);
				session.setAttribute(Parameters.USER_CONTEXT, userCache);

				System.out.println("合法的用户登录");
			} else {
				session.invalidate();
				((HttpServletResponse)response).sendRedirect(haikouOpusHomePage);
				return;
			}
			*/

            // Store the authenticated user in the session
            if (session != null) { // probably unnecessary
                session.setAttribute(CAS_FILTER_USER, receipt.getUserName());
                session.setAttribute(CASFilter.CAS_FILTER_RECEIPT, receipt);
                // don't store extra unnecessary session state
                session.removeAttribute(CAS_FILTER_GATEWAYED);
            }
            if (log.isTraceEnabled()) {
                log.trace("validated ticket to get authenticated receipt ["
                        + receipt
                        + "], now passing request along filter chain.");
            }



            // continue processing the request
            fc.doFilter(request, response);
            log.trace("returning from doFilter()");
        }

    }
    /**
     * Is this receipt acceptable as evidence of authentication by credentials
     * that would have been acceptable to this path? Current implementation
     * checks whether from renew and whether proxy was authorized.
     *
     * @param receipt
     * @return true if acceptable, false otherwise
     */
    private boolean isReceiptAcceptable(CASReceipt receipt) {
        if (receipt == null)
            throw new IllegalArgumentException(
                    "Cannot evaluate a null receipt.");
        if (this.casRenew && !receipt.isPrimaryAuthentication()) {
            return false;
        }
        if (receipt.isProxied()) {
            if (!this.authorizedProxies.contains(receipt.getProxyingService())) {
                return false;
            }
        }
        return true;
    }

    // *********************************************************************
    // Utility methods

    /**
     * Converts a ticket parameter to a CASReceipt, taking into account an
     * optionally configured trusted proxy in the tier immediately in front of
     * us.
     *
     * @throws javax.servlet.ServletException
     *             - when unable to get service for request
     * @throws edu.yale.its.tp.cas.client.CASAuthenticationException
     *             - on authentication failure
     */
    private CASReceipt getAuthenticatedUser(HttpServletRequest request)
            throws ServletException, CASAuthenticationException {
        log.trace("entering getAuthenticatedUser()");
        ProxyTicketValidator pv = null;

        pv = new ProxyTicketValidator();
        pv.setCasValidateUrl(casValidate);
        pv.setServiceTicket(request.getParameter("ticket"));
        pv.setService(getService(request));
        pv.setRenew(Boolean.valueOf(casRenew).booleanValue());
        if (casProxyCallbackUrl != null) {
            pv.setProxyCallbackUrl(casProxyCallbackUrl);
        }
        if (log.isDebugEnabled()) {
            log.debug("about to validate ProxyTicketValidator: [" + pv + "]");
        }

        return CASReceipt.getReceipt(pv);

    }

    /**
     * Returns either the configured service or figures it out for the current
     * request. The returned service is URL-encoded.
     */
    private String getService(HttpServletRequest request)
            throws ServletException {

        log.trace("entering getService()");
        String serviceString;

        // ensure we have a server name or service name
        if (casServerName == null && casServiceUrl == null)
            throw new ServletException(
                    "need one of the following configuration "
                            + "parameters: edu.yale.its.tp.cas.client.filter.serviceUrl or "
                            + "edu.yale.its.tp.cas.client.filter.serverName");

        // use the given string if it's provided
        if (casServiceUrl != null)
            serviceString = URLEncoder.encode(casServiceUrl);
        else
            // otherwise, return our best guess at the service
            serviceString = Util.getService(request, casServerName);
        if (log.isTraceEnabled()) {
            log.trace("returning from getService() with service ["
                    + serviceString + "]");
        }
        return serviceString;
    }

    /**
     * Redirects the user to CAS, determining the service from the request.
     */
    private void redirectToCAS(HttpServletRequest request,
                               HttpServletResponse response) throws IOException, ServletException {
        if (log.isTraceEnabled()) {
            log.trace("entering redirectToCAS()");
        }

        String casLoginString = casLogin + "?service=" + getService(request)
                + ((casRenew) ? "&renew=true" : "")
                + (casGateway ? "&gateway=true" : "");

        if (log.isDebugEnabled()) {
            log.debug("Redirecting browser to [" + casLoginString + ")");
        }
        response.sendRedirect(casLoginString);

        if (log.isTraceEnabled()) {
            log.trace("returning from redirectToCAS()");
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[CASFilter:");
        sb.append(" casGateway=");
        sb.append(this.casGateway);
        sb.append(" wrapRequest=");
        sb.append(this.wrapRequest);

        sb.append(" casAuthorizedProxies=[");
        sb.append(this.authorizedProxies);
        sb.append("]");

        if (this.casLogin != null) {
            sb.append(" casLogin=[");
            sb.append(this.casLogin);
            sb.append("]");
        } else {
            sb.append(" casLogin=NULL!!!!!");
        }

        if (this.casProxyCallbackUrl != null) {
            sb.append(" casProxyCallbackUrl=[");
            sb.append(casProxyCallbackUrl);
            sb.append("]");
        }

        if (this.casRenew) {
            sb.append(" casRenew=true");
        }

        if (this.casServerName != null) {
            sb.append(" casServerName=[");
            sb.append(casServerName);
            sb.append("]");
        }

        if (this.casServiceUrl != null) {
            sb.append(" casServiceUrl=[");
            sb.append(casServiceUrl);
            sb.append("]");
        }

        if (this.casValidate != null) {
            sb.append(" casValidate=[");
            sb.append(casValidate);
            sb.append("]");
        } else {
            sb.append(" casValidate=NULL!!!");
        }

        return sb.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }
}

/*
 * Copyright (c) 2000-2004 Yale University. All rights reserved.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE, ARE EXPRESSLY DISCLAIMED. IN NO EVENT SHALL
 * YALE UNIVERSITY OR ITS EMPLOYEES BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED, THE COSTS OF PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED IN ADVANCE OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Redistribution and use of this software in source or binary forms, with or
 * without modification, are permitted, provided that the following conditions
 * are met:
 *
 * 1. Any redistribution must include the above copyright notice and disclaimer
 * and this list of conditions in any related documentation and, if feasible, in
 * the redistributed software.
 *
 * 2. Any redistribution must include the acknowledgment, "This product includes
 * software developed by Yale University," in any related documentation and, if
 * feasible, in the redistributed software.
 *
 * 3. The names "Yale" and "Yale University" must not be used to endorse or
 * promote products derived from this software.
 */
