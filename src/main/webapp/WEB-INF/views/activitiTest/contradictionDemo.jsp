<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="UTF-8">
<title>矛盾上报Demo</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/script.jsp"%>
</head>
<body>
	<div id="tb" style="padding: 10px;">
		 <form id="sform">
			   查询条件
			      上报人:<input name="w.cdp"  class="easyui-textbox" type="text"
				   data-options="prompt:'请输入上报人....'"
				   style="width: 100px"></input>
	      <a href="#" class="easyui-linkbutton" onclick="doSearch()" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
			<div style="float: right">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add"
					plain="true" onclick="showWin('win','${ctx}/contradictionDemo/show.do')">新增</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
					onclick="edit('dg','win','${ctx}/contradictionDemo/show.do')">修改</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del('dg','${ctx}/contradictionDemo/delete.do')">删除</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-bdel" plain="true" onclick="batchDel('dg','${ctx}/contradictionDemo/deleteBatch.do')">批量删除</a>
			</div>
		</form>
	</div>
	<div id="win" class="easyui-window" title="矛盾上报Demo"
		data-options="iconCls:'${icon}',minimizable:true,modal:true,closed:true"
		style="width: 550px; height: 350px; padding: 10px;"></div>
	<table class="easyui-datagrid" id="dg" title="   矛盾上报Demo"
		iconCls='${icon}' style="width: 100%; height: 100%; padding: 0px;"
		data-options="
		        border:false,
                rownumbers:true,
                singleSelect:false,
                autoRowHeight:false,
                pagination:true,
                toolbar:'#tb',
                url:'${ctx}/contradictionDemo/query.do',
                pageSize:20">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
                <th field="id" hidden=true>id</th>
                     <th  field="cdp" width="100">上报人</th>
                     <th  field="summary" width="100">摘要</th>
			</tr>
		</thead>
	</table>
</body>
<script>
function doSearch() {
    $('#dg').datagrid({
        queryParams : $('#sform').serializeObject()
    });
}
</script>

