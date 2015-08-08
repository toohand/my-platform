<%--
  Created by IntelliJ IDEA.
  User: 潘锦发
  Date: 2015/6/10
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="/common/meta.jsp" %>
    <%@include file="/common/script.jsp" %>
    <title>历史实例管理</title>
</head>
<body>
<table id="table" class="easyui-datagrid" title="历史实例管理" style="width: 100%; height: 100%; padding: 0px;"
       data-options="
               border:false,
                <%--// 是否禁止文字自动换行--%>
                nowrap: false,
                <%--//是否带条纹--%>
                striped: true,
                <%--//是否折叠窗口--%>
                collapsible: true,
                <%--//是否显示加载组状态--%>
                loading: true,
                <%--//允许表格自动缩放,以适应父容器--%>
                fitColumns: true,
                <%--//设置load的中文--%>
                <%--//是否远程排序--%>
                remoteSort: false,
                <%--//是否多层排序--%>
                multiSort: true,
                <%--//是否单选--%>
                singleSelect: true,
                pageSize: 20,
                <%--//每页显示的记录条数，默认为10--%>
                pageoutlist: [20, 30, 40, 50],
                <%--//可以设置每页记录条数的列表--%>
                loadMsg: '数据加载中......',
                <%--//url返回标准的json数据--%>
                url:'${ctx}/api/activitiManage/queryHistoryProcinstManage.do',
                queryParams:{
                   categorys:'${actCategorys}'
                },
                method:'get',
                toolbar:'#tb',
                <%--//行号--%>
                rownumbers: true,
                <%--//设置分页段落--%>
                pagination: true"
        >
    <thead>
    <tr>
        <th data-options="field:'DefinitionId',width:'15%'">流程信息</th>
        <th data-options="field:'summary',width:'35%'">摘要</th>
        <th data-options="field:'cdp',width:'10%'">创建人</th>
        <th data-options="field:'startTime',width:'15%',align:'center'">开始时间</th>
        <th data-options="field:'endTime',width:'15%',align:'center'">结束时间</th>
        <th data-options="field:'state',width:'5%',align:'center',styler:stateStyler">状态</th>
    </tr>
    </thead>
</table>
<div id="tb" style="padding:10px">
    <form id="wform">
        条件：<input class="easyui-textbox" type="text" name="w.condition" style="width:300px" prompt="请输入摘要、创建人......">
        从： <input name="w.fdate" class="easyui-datebox"
                  style="width: 150px"></input>
        到： <input name="w.edate" class="easyui-datebox"
                  style="width: 150px"></input>
        <a class="easyui-linkbutton" src="javascript:void(0)" plain="true" onclick="doSearch('table','wform')" iconCls="icon-search">搜索</a>

        <div style="float: right">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="openDetail()">查看</a>
        </div>
    </form>
</div>
<div id="detailWin" class="easyui-window" title="查看审批明细" data-options="modal:true,closed:true,iconCls:'icon-save',collapsible:false,maximized:true" style="width:800px;height:400px;">

</div>
<script type="text/javascript">
    function ClearQuery() {
        $("#tb").find("input").val("");
    }
    ;
    function doSearch(dg, form) {
        $('#' + dg).datagrid({
            queryParams: $('#' + form).serializeObject()
        });
    }
    function openDetail() {
        var row = $('#table').datagrid('getSelected');
        if (row == null) {
            $.messager.alert("提示", "请选择要<span style='color: red'>查看</span>的数据行！", "info");
        } else {
            $('#detailWin').window('refresh', '${ctx}/activitiPage/findProinstanceTask.do?instanceId=' + row.id);
            $('#detailWin').window('open');
        }
    }
    function stateStyler(value,row,index){
        if (value =="进行中"){
            return 'background-color:#E5EFFF;color:red;';
        }else{
            return 'color:blue;';
        }
    }
</script>
</body>
</html>
