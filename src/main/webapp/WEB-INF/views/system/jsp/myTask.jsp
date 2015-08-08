<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<body>
<script>
	function doSearch() {
		$('#dg').datagrid({
			queryParams : $('#sform').serializeObject()
		});
	}
</script>
	<div id="tb" style="padding: 10px;">
		 <form id="sform">
			 请输入条件<input name="w.conditions"  class="easyui-searchbox"
						   data-options="prompt:'请输入任务名称....',searcher:doSearch"
						   style="width: 300px"></input>
		</form>
	</div>
	<table class="easyui-datagrid" id="dg" title=""
		iconCls='${icon}' style="width: 100%; height: 100%; padding: 0px;"
		data-options="
		        border:false,
                rownumbers:true,
                singleSelect:false,
                autoRowHeight:false,
                pagination:true,
                toolbar:'#tb',
                url:'',
                pageSize:20">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
                <th field="id" hidden=true>id</th>
				<th  field="title" width="20%">任务标题</th>
				<th  field="remark" width="30%">任务描述</th>
				<th  field="cdt" width="20%">发送时间</th>
				<th  field="cdp" width="15%">发送人</th>
				<th  field="state" width="5%">状态</th>
			</tr>
		</thead>
	</table>
</body>


