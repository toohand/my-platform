<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="UTF-8">
<title>portal管理</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/script.jsp"%>
</head>
<body>
	<div id="tb" style="padding: 10px;">
		 <form id="sform">
			   查询条件
			      标题:<input name="w.title"  class="easyui-textbox" type="text"
				   data-options="prompt:'请输入标题....'"
				   style="width: 200px"></input>
			      描述:<input name="w.remark"  class="easyui-textbox" type="text"
				   data-options="prompt:'请输入描述....'"
				   style="width: 300px"></input>
	      <a href="#" class="easyui-linkbutton" onclick="doSearch()" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
			<div style="float: right">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add"
					plain="true" onclick="showWin('win','${ctx}/sysPortal/show.do')">新增</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
					onclick="edit('dg','win','${ctx}/sysPortal/show.do')">修改</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del('dg','${ctx}/sysPortal/delete.do')">删除</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-bdel" plain="true" onclick="batchDel('dg','${ctx}/sysPortal/deleteBatch.do')">批量删除</a>
			</div>
		</form>
	</div>
	<div id="win" class="easyui-window" title="portal管理"
		data-options="iconCls:'${icon}',minimizable:true,modal:true,closed:true"
		style="width: 600px; height: 400px; padding: 10px;"></div>
	<table class="easyui-datagrid" id="dg" title="   portal管理"
		iconCls='${icon}' style="width: 100%; height: 100%; padding: 0px;"
		data-options="
		        border:false,
                rownumbers:true,
                singleSelect:false,
                autoRowHeight:false,
                pagination:true,
                toolbar:'#tb',
                url:'${ctx}/sysPortal/query.do',
                pageSize:20">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
                <th field="id" hidden=true>id</th>
				<th  field="title" width="20%">标题</th>
				<th  field="remark" width="30%">描述</th>
				<th  field="cdt" width="20%">创建时间</th>
				<th  field="cdp" width="20%">创建人</th>
				<th  field="state" width="5%" formatter=formatState>状态</th>
			</tr>
		</thead>
	</table>
</body>
<script>
	var stateMap = ${stateMap};

	function doSearch() {
		$('#dg').datagrid({
        	queryParams : $('#sform').serializeObject()
    	});
	}
	function  formatState(val, row){
		return stateMap[val];
	}
</script>

