<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>管理平台</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/script.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Frame/js/theme.js"></script>
</head>
<body class="easyui-layout">
	<%--<div data-options="region:'north',border:false"
		style="height: 70px; padding: 0px; overflow: hidden">
		<div class="head">
            <div class="head_01">
                <h1>
                    <a href="#"></a>
                </h1>
            </div>
            <div class="head_02">
                <div class="userinfo">
                    <span> ${pageContext.request.getSession().getAttribute("loginName")}，你好!
					</span>
                </div>
                <div class="themeList" id="themeList">
                    <a target="center" href="${ctx}/sysPortal/indexPortal.do" class="easyui-linkbutton" plain="true"
                        data-options="menu:'#mm',iconCls:'icon-first'">首页</a>
                    <a href="javascript:void(0)" id="mb" class="easyui-menubutton"
                        data-options="menu:'#mm',iconCls:'icon-theme'">更换主题</a>
                    <div id="mm" class="easyui-menu" data-options="onClick:menuHandler"
                        style="width: 120px;">
                        <div data-options="name:'default',iconCls:'icon-default'">默认</div>
                        <div data-options="name:'gray' ,iconCls:'icon-default'">银灰色</div>
                        <div data-options="name:'metro-blue',iconCls:'icon-blue'">蓝色</div>
                        <div data-options="name:'metro-red',iconCls:'icon-red'">红色</div>
                        <div data-options="name:'metro-green',iconCls:'icon-green'">绿色</div>
                        <div data-options="name:'metro-orange',iconCls:'icon-orange'">橙色</div>
                    </div>
                </div>
                <div class="btn">
                    <a href="#" class="easyui-linkbutton" plain="true"
                        data-options="iconCls:'icon-large-exit',size:'large',iconAlign:'top'"
                        onclick="closeLog();">退出</a>
                </div>
            </div>
        </div>
	</div>--%>
	<div class="easyui-panel"
		data-options="region:'west',split:true,title:'&nbsp;&nbsp;&nbsp;&nbsp;系统功能',iconCls:'icon-system'"
		style="width: 180px; overflow: hidden;">
		<div class="easyui-accordion"
			 style="width: 100%; height: 100%; border: 0px;">
			<div title="&nbsp;&nbsp;&nbsp;&nbsp;任务管理"
				 data-options="iconCls:'icon-common'"
				 style="text-align: center;">
				<div class="nav-item">
					<a target="center"
					   href="${ctx}/activitiPage/myTaskManage.do"
					   class="easyui-linkbutton" style="width: 90%"
					   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;待办任务</a>
				</div>
				<div class="nav-item">
					<a target="center"
					   href="${ctx}/activitiPage/myCompleteTask.do"
					   class="easyui-linkbutton" style="width: 90%"
					   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;已办任务</a>
				</div>
			</div>
		<div title="&nbsp;&nbsp;&nbsp;&nbsp;工作流"
			 data-options="iconCls:'icon-common'"
			 style="text-align: center;">
			<div class="nav-item">
				<a target="center"
				   href="${ctx}/activitiPage/processModel.do"
				   class="easyui-linkbutton" style="width: 90%"
				   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;流程管理</a>
			</div>
			<div class="nav-item">
				<a target="center"
				   href="${ctx}/activitiPage/processManage.do"
				   class="easyui-linkbutton" style="width: 90%"
				   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;流程发布管理</a>
			</div>
			<div class="nav-item">
				<a target="center"
				   href="${ctx}/activitiPage/instanceManage.do"
				   class="easyui-linkbutton" style="width: 90%"
				   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;实例管理</a>
			</div>
            <div class="nav-item">
                <a target="center"
                   href="${ctx}/activitiPage/taskManage.do"
                   class="easyui-linkbutton" style="width: 90%"
                   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;任务管理</a>
            </div>
            <div class="nav-item">
                <a target="center"
                   href="${ctx}/activitiPage/historyProcinstManage.do"
                   class="easyui-linkbutton" style="width: 90%"
                   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;历史实例管理</a>
            </div>
            <div class="nav-item">
                <a target="center"
                   href="${ctx}/activitiPage/historyTaskManage.do"
                   class="easyui-linkbutton" style="width: 90%"
                   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;历史任务管理</a>
            </div>
            <div class="nav-item">
                <a target="center"
                   href="${ctx}/leaveBillDemo/load.do"
                   class="easyui-linkbutton" style="width: 90%"
                   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;请假流程</a>
            </div>
			<div class="nav-item">
				<a target="center"
				   href="${ctx}/leaveBillDemo/apply.do?opt=transact"
				   class="easyui-linkbutton" style="width: 90%"
				   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;我要请假</a>
			</div>
	<%--		<div class="nav-item">
				<a target="center"
				   href="${ctx}/contradictionDemo/load.do"
				   class="easyui-linkbutton" style="width: 90%"
				   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;矛盾上報流程</a>
			</div>--%>
			<div class="nav-item">
				<a target="center"
				   href="${ctx}/contradictionDemo/report.do?opt=transact"
				   class="easyui-linkbutton" style="width: 90%"
				   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;上報矛盾</a>
			</div>
            <%--<div class="nav-item">--%>
                <%--<a target="center"--%>
                   <%--href="${ctx}/login/leaveManage.do"--%>
                   <%--class="easyui-linkbutton" style="width: 90%"--%>
                   <%--data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;模拟待办</a>--%>
            <%--</div>--%>
		</div>
		<div title="&nbsp;&nbsp;&nbsp;&nbsp;系统管理"
			 data-options="iconCls:'icon-common'"
			 style="text-align: center;">
			<div class="nav-item">
				<a target="center"
				   href="${ctx}/bdCodeDemo/load.do"
				   class="easyui-linkbutton" style="width: 90%"
				   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;生成器实例</a>
			</div>
			<div class="nav-item">
				<a target="center"
				   href="${ctx}/sysPortal/load.do"
				   class="easyui-linkbutton" style="width: 90%"
				   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;系统Portal管理</a>
			</div>
			<div class="nav-item">
				<a target="center"
				   href="${ctx}/sysDictionary/load.do"
				   class="easyui-linkbutton" style="width: 90%"
				   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;数据字典管理</a>
			</div>
            <div class="nav-item">
                <a target="center"
                   href="${ctx}/attachment/list"
                   class="easyui-linkbutton" style="width: 90%"
                   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;附件管理</a>
            </div>
            <div class="nav-item">
                <a target="center"
                   href="${ctx}/log/list"
                   class="easyui-linkbutton" style="width: 90%"
                   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;日志管理</a>
            </div>
            <div class="nav-item">
                <a target="center"
                   href="${ctx}/message/list"
                   class="easyui-linkbutton" style="width: 90%"
                   data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;消息管理</a>
            </div>
		</div>
		</div>
		<!--
		<div class="easyui-accordion"
			style="width: 100%; height: 100%; border: 0px;">
			<c:forEach var="item" items="${userMenu}">
				<div title="&nbsp;&nbsp;&nbsp;&nbsp;${item.menu.name}"
					data-options="iconCls:'${item.menu.menuIcon}'"
					style="text-align: center;">
					<c:forEach var="sub" items="${item.subMenus}">
						<c:choose>
							<c:when test="${empty sub.menuIcon}">
								<div class="nav-item">
									<a target="center"
										href="${sub.pageUrl}?menuId=${sub.id}&flag=${sub.pageFlag}${sub.param}"
										class="easyui-linkbutton" style="width: 90%"
										data-options="plain:true,iconCls:'icon-common'">&nbsp;&nbsp;${sub.name}</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="nav-item">
									<a target="center"
										href="${sub.pageUrl}?menuId=${sub.id}&flag=${sub.pageFlag}${sub.param}&icon=${sub.menuIcon}"
										class="easyui-linkbutton" style="width: 90%"
										data-options="plain:true,iconCls:'${sub.menuIcon}'">&nbsp;&nbsp;${sub.name}</a>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
			</c:forEach>
		</div>-->
	</div>
	<div data-options="region:'center',title:''" style="padding: 0px; overflow: hidden">
		<iframe src="${ctx}/sysPortal/indexPortal.do" scrolling="no" frameborder="0" name="center"
			id="center" noresize="noresize" width="100%" height="99.5%"></iframe>
	</div>
	<div data-options="region:'south',border:false"
		style="height: 30px; padding: 10px; text-align: center;">
		恒巨科技copyright@2015~2020</div>
	<!-- <div data-options="region:'east',split:true,collapsed:true,title:''" style="width:100px;padding:10px;">
	  <iframe src="" scrolling="yes" frameborder="0" name="right" id="right" noresize="noresize"width="100%" height="100%"></iframe>
	</div> -->
</body>
</html>