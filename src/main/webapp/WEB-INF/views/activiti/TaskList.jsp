<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>流程任务办理情况</title>
    <%@include file="/common/meta.jsp" %>
    <%@include file="/common/script.jsp" %>
</head>
<body>
<div style="height:60%;width:85%;">
    <img id="activitiImage"
         src="${ctx}/api/activitiManage/imageTask.do/${instanceId}"/>
</div>
<div style="width:100%;height:40%">
    <table id="table" class="easyui-datagrid" title="" style="width:100%;height:100%"
           data-options="
                border:false,
            <%--// 是否禁止文字自动换行--%>
                nowrap: false,
                <%--//是否带条纹--%>
                striped: true,
                <%--//是否折叠窗口--%>
                collapsible: false,
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
                url:'${ctx}/api/activitiManage/findProinstanceTaskList/${instanceId}',
                method:'get',
                <%--//行号--%>
                rownumbers: true">
        <thead>
        <tr>
            <th data-options="field:'id',width:1,align:'center',hidden:'true'">ID</th>
            <th data-options="field:'name',width:'20%'">任务名</th>
            <th data-options="field:'assignee',width:'10%'">办理人</th>
            <th data-options="field:'startTime',width:'20%',align:'center'">开始时间</th>
            <th data-options="field:'endTime',width:'20%'">结束时间</th>
            <th data-options="field:'durationInMillis',width:'10%',formatter:duratTime">耗时(分)</th>

            <th data-options="field:'deleteReason',width:'15%',align:'center'">办理情况</th>
        </tr>
        </thead>
    </table>
</div>

<script>
    function duratTime(value, row, index) {
        var result = value / 1000 / 60;
        return result.toFixed(2);
    }
</script>
</body>
</html>

