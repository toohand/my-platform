<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="UTF-8">
<title>代码生成器Demo</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/script.jsp"%>
</head>
<body>
	<div id="tb" style="padding: 10px;">
		 <form id="sform">
			   查询条件
			      名称:<input name="w.name"  class="easyui-textbox" type="text"
				   data-options="prompt:'请输入名称....'"
				   style="width: 100px"></input>
			      描述:<input name="w.remark"  class="easyui-textbox" type="text"
				   data-options="prompt:'请输入描述....'"
				   style="width: 100px"></input>
			      创建人:<input name="w.cdp"  class="easyui-textbox" type="text"
				   data-options="prompt:'请输入创建人....'"
				   style="width: 100px"></input>
	      <a href="#" class="easyui-linkbutton" onclick="doSearch()" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
			<div style="float: right">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add"
					plain="true" onclick="showWin('win','${ctx}/bdCodeDemo/show.do')">新增</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
					onclick="edit('dg','win','${ctx}/bdCodeDemo/show.do')">修改</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del('dg','${ctx}/bdCodeDemo/delete.do')">删除</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-bdel" plain="true" onclick="batchDel('dg','${ctx}/bdCodeDemo/deleteBatch.do')">批量删除</a>
			</div>
		</form>
	</div>
	<div id="win" class="easyui-window" title="代码生成器Demo"
		data-options="iconCls:'${icon}',minimizable:true,modal:true,closed:true"
		style="width: 550px; height: 350px; padding: 10px;"></div>
	<table class="easyui-datagrid" id="dg" title="   代码生成器Demo"
		iconCls='${icon}' style="width: 100%; height: 100%; padding: 0px;"
		data-options="
		        border:false,
                rownumbers:true,
                singleSelect:false,
                autoRowHeight:false,
                pagination:true,
                toolbar:'#tb',
                url:'${ctx}/bdCodeDemo/query.do',
                pageSize:20">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
                <th field="id" hidden=true>id</th>
                     <th  field="name" width="100">名称</th>
                     <th  field="remark" width="100">描述</th>
                     <th  field="sex" width="100">性别</th>
                     <th  field="hobby" width="100">爱好</th>
                     <th  field="classes" width="100">班级</th>
                     <th  field="cdt" width="100">创建日期</th>
                     <th  field="cdp" width="100">创建人</th>
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

