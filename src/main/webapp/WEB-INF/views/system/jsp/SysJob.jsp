<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="UTF-8">
<title>定时任务管理</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/script.jsp"%>
</head>
<body>
	<div id="tb" style="padding: 10px;">
		<form id="sform">
			请输入查询条件<input name="w.conditions"  class="easyui-searchbox"
				data-options="prompt:'请输入任务名称、分组、类名....',searcher:doSearch"
				style="width: 300px"></input>
			<div style="float: right">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add"
					plain="true" onclick="showWin('win','${ctx}/sysJob/show.do')">新增</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
					onclick="edit('dg','win','${ctx}/sysJob/show.do')">修改</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del('dg','${ctx}/sysJob/delete.do')">删除</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-bdel" plain="true" onclick="batchDel('dg','${ctx}/sysJob/deleteBatch.do')">批量删除</a>
			</div>
		</form>
	</div>
	<div id="win" class="easyui-window" title="定时任务信息"
		data-options="iconCls:'${icon}',minimizable:true,modal:true,closed:true"
		style="width: 550px; height: 350px; padding: 10px;"></div>
	<table class="easyui-datagrid" id="dg" title="   定时任务管理"
		iconCls='${icon}' style="width: 100%; height: 100%; padding: 0px;"
		data-options="
		        border:false,
                rownumbers:true,
                singleSelect:false,
                autoRowHeight:false,
                pagination:true,
                toolbar:'#tb',
                url:'${ctx}/sysJob/query.do',
                pageSize:20">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th field="id" hidden=true>id</th>
				<th field="jobName" width="20%">任务名称</th>
				<th field="jobGroup" width="20%">分组</th>
				<th field="taskClass" width=15% >类名</th>
				<th field="cronExpression" width="15%" align="right">表达式</th>
				<th field="createDate" width="20%">创建时间</th>
			</tr>
		</thead>
	</table>
</body>
<script>
function doSearch(value,name) {
    $('#dg').datagrid({
        queryParams : $('#sform').serializeObject()
    });
}
</script>

