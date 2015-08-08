<%@ page contentType="text/html;charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/meta.jsp"%>
<%@include file="/common/script.jsp"%>
<body>
	<div class="easyui-panel" border=false style="padding: 10px 20px">
		<form id="fid" class="easyui-form" method="post" data-options="novalidate:true" action="${ctx}/api/activitiBusiness/delegationTask.do">
            <input type="hidden" name="taskId" value="${taskId}">
            <input type="hidden" name="olduserId" value="${oldUserId}">
            <div class="unit">
                <label style="width:60px" >原办理人：</label>
                <label >${oldUserId}</label>
            </div>
            <div class="unit">
                <label style="width:60px" >代理人：</label>
                <input class="easyui-combobox" name="userId" data-options="
                    url:'${ctx}/api/activitiManage/queryUsers.do?rows=1&page=1000',
                    method:'get',
                    valueField:'id',
                    textField:'firstName',
                    panelHeight:'auto'">
            </div>
            <div class="unit">
                <div style="text-align: center; padding: 1px">
                    <a href="javascript:void(0)" class="easyui-linkbutton"
                           iconCls="icon-save" onclick="submitForm('fid','table','win')">提交</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton"
                       iconCls="icon-cancel" onclick="clearForm('win')">关闭</a>
                </div>
            </div>
		</form>
	</div>
</body>

