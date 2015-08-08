<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>请假流程Demo</title>
    <%@include file="/common/meta.jsp" %>
    <%@include file="/common/script.jsp" %>
</head>
<body>
<div id="tb" style="padding: 10px;">
    <form id="sform">
        查询条件
        申请人:<input name="w.loginName" class="easyui-textbox" type="text"
                   data-options="prompt:'请输入申请人....'"
                   style="width: 100px"></input>
        状态:<input name="w.state" class="easyui-textbox" type="text"
                  data-options="prompt:'请输入状态....'"
                  style="width: 100px"></input>
        <a href="#" class="easyui-linkbutton" onclick="doSearch()" data-options="iconCls:'icon-search'"
           style="width:80px">查询</a>

        <div style="float: right">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add"
               plain="true" onclick="showWin('win','${ctx}/leaveBillDemo/show.do')">新增</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
               onclick="edit('dg','win','${ctx}/leaveBillDemo/show.do')">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
               onclick="del('dg','${ctx}/leaveBillDemo/delete.do')">删除</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-bdel" plain="true"
               onclick="batchDel('dg','${ctx}/leaveBillDemo/deleteBatch.do')">批量删除</a>
        </div>
    </form>
</div>
<div id="win" class="easyui-window" title="请假流程Demo"
     data-options="iconCls:'${icon}',minimizable:true,modal:true,closed:true"
     style="width: 800px; height: 450px; padding: 10px;"></div>
<table class="easyui-datagrid" id="dg" title="   请假流程Demo"
       iconCls='${icon}' style="width: 100%; height: 100%; padding: 0px;"
       data-options="
		        border:false,
                rownumbers:true,
                singleSelect:false,
                autoRowHeight:false,
                pagination:true,
                toolbar:'#tb',
                url:'${ctx}/leaveBillDemo/query.do',
                pageSize:20">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th field="id" hidden=true>id</th>
        <th field="loginName" width=15%>申请人</th>
        <th field="day" width=15%>请假天数</th>
        <th field="leaveType" width=10% formatter=formatLeaveType>假期类型</th>
        <th field="state" width=10% formatter=formatLeaveState>状态</th>
        <th field="startTime" width=20%>开始时间</th>
        <th field="endTime" width=20%>结束时间</th>
    </tr>
    </thead>
</table>
</body>
<script>
    var leaveType = ${leaveTypeJson};
    var leaveState = ${leaveStateJson};
    function formatLeaveType(val, row) {
        return leaveType[val];
    }
    function formatLeaveState(val, row) {
        return leaveState[val];
    }
    function doSearch() {
        $('#dg').datagrid({
            queryParams: $('#sform').serializeObject()
        });
    }
</script>

