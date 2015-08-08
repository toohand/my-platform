<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/common/meta.jsp" %>
</head>
<body>
<div id="toolbar-attachment" style="padding: 10px;">
    <form id="sform">
        <input name="keyword" class="easyui-textbox" type="text" data-options="prompt:'请输入关键字....'" style="width: 100px">
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
        <div style="float: right">
            <a id="add-btn" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
            <a id="del-btn" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        </div>
    </form>
</div>
<table id="datagrid-attachment" style="width: 100%;height: 100%;"></table>
<div id="dialog-attachment" style="width: 450px;height: 270px;padding:50px 70px 50px 70px;"></div>
</body>
<%@include file="/common/script.jsp" %>
<script type="text/javascript" src="${ctx}/js/lib/jquery-fileupload/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery-fileupload/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery-fileupload/jquery.fileupload.js"></script>
<script type="text/javascript" src="${ctx}/js/attachment/list.js"></script>

<script type="text/template" id="ADD_NODE_TMP">
    <div style="margin-bottom:20px">
        <div>文件:</div><br>
        <input type="file" id="fileupload" name="files[]" multiple>
        <div id="progressbar-attachment" style="width:100%;"></div>
    </div>
    <%--<div>
        <a href="#" id="attachment-upload" class="easyui-linkbutton" style="width:100%">上传</a>
    </div>--%>
</script>
</html>

