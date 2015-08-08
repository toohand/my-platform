<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/common/meta.jsp" %>
</head>
<body>

<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west'" title="日志库" style="width:20%;">
        <ul id="tree-log"></ul>
    </div>
    <div data-options="region:'center',border:false" title="日志列表">
        <div id="toolbar-log" style="padding: 10px;">
            <form id="sform">
                <input name="keyword" class="easyui-textbox" type="text" data-options="prompt:'请输入关键字....'" style="width: 100px"/>
                <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
                <div style="float: right">
                    <a id="del-btn" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除日志库</a>
                </div>
            </form>
        </div>
        <table id="datagrid-log" style="width: 100%;height: 100%;"></table>
    </div>
</div>

</body>
<%@include file="/common/script.jsp" %>
<script type="text/javascript" src="${ctx}/js/log/list.js"></script>

</html>

