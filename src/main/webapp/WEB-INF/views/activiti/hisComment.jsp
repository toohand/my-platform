<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
    <meta charset="UTF-8">
    <title>历史批注信息</title>
</head>
<body>
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
                url:'${ctx}/api/activitiManage/findHisComment/${taskId}',
                method:'get',
                <%--//行号--%>
                rownumbers: true">
            <thead>
            <tr>
                <th data-options="field:'id',width:1,align:'center',hidden:'true'">ID</th>
                <th data-options="field:'userId',width:'15%'">办理人</th>
                <th data-options="field:'fullMessage',width:'50%',align:'left'">批注</th>
                <th data-options="field:'time',width:'35%',align:'center'">时间</th>
            </tr>
            </thead>
        </table>

</body>
</html>

