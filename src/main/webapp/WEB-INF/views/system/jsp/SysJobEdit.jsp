<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
	<div class="easyui-panel" border=false style="padding: 10px 20px">
		<form id="fid" class="easyui-form" method="post"
			data-options="novalidate:true" action="${ctx}/sysJob/save.do">
			<input type="hidden" name="id" value="${vo.id}" />
			<div class="unit">
				<label>任务名称:</label> <input class="easyui-textbox" type="text"
					name="jobName" value="${vo.jobName}"
					data-options="required:true, width:'300px'"></input>					
			</div>
			<div class="unit">
				<label>任务分组:</label> <input class="easyui-textbox" type="text"
					name="jobGroup" value="${vo.jobGroup}"
					data-options="width:'300px'"></input>
			</div>
			<div class="unit">
				<label>任务类:</label><input class="easyui-textbox" type="text"
				      name="taskClass" value="${vo.taskClass}"
				      data-options="required:true, width:'300px'"></input>
			</div>
			<div class="unit">
				<label>表达式:</label> <input class="easyui-textbox" type="text"
					name="cronExpression" value="${vo.cronExpression}"></input>
			</div>
		</form>
		<div style="text-align: center; padding: 10px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-save" onclick="submitForm('fid','dg','win')">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="clearForm('win')">取消</a>
		</div>
	</div>
</body>

