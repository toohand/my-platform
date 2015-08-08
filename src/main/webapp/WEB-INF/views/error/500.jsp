<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%response.setStatus(200);%>

<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Throwable) request.getAttribute("javax.servlet.error.exception");

	//记录日志
	Logger logger = LoggerFactory.getLogger("500.jsp");
	logger.error(ex.getMessage(), ex);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>广州人大信息门户</title>
	<%@ include file="/common/taglibs.jsp"%>
	<style>
		html,body{ height:100%; margin:0; padding:0; width:100%;}
		body{ background:#F8F8F8 url(${ctx}/skin/default/img/sorryBg.png) no-repeat center 40%;}
		.sorryTitle{ bottom:60%; color:#B31900; font-size:30px; font-weight:bold; 
			font-family:"黑体"; margin-bottom:-21px; text-align:center; position:absolute; width:100%;}
		.sorryTitle .sorryFont{ font-size:48px;}
		.sorryTitle p{ margin:0; margin-top:10px;}
		.sorryReturn{ bottom:60%; margin-bottom:-71px; text-align:center; position:absolute; width:100%;}
		.sorryReturn a{ color:#0000EE; font-size:14px; text-decoration:underline;}
		.sorryReturn a:hover{ color:#f60;}
	</style>
</head>

<body>
	<div class="sorryTitle">
		<p class="sorryFont">Sorry!</p>
    	<p><%=ex.getMessage()%></p>
    </div>
    <div class="sorryReturn"><a href="javascript:history.go(-1);">返回</a></div>
</body>
</html>
