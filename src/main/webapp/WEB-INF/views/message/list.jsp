<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/common/meta.jsp" %>
    <style type="text/css">
        .dialog-tr{
            display:block;
            margin-bottom: 10px;
        }
        .dialog-td{
            margin-right: 10px;
        }
    </style>
</head>
<body>
<div id="toolbar-message" style="padding: 10px;">
    <form id="sform">
        <input name="keyword" class="easyui-textbox" type="text" data-options="prompt:'请输入关键字....'" style="width: 100px"/>
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
        <div style="float: right">
            <a id="add-btn" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
            <a id="del-btn" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
            <a id="client-btn" href="${ctx}/message/client" class="easyui-linkbutton" iconCls="icon-man" plain="true" target="_blank">新客户端</a>
        </div>
    </form>
</div>
<table id="datagrid-message" style="width: 100%;height: 100%;"></table>
<div id="dialog-message" style="width: 500px;height: 350px;padding: 50px ;"></div>
</body>
<%@include file="/common/script.jsp" %>
<script type="text/javascript" src="${ctx}/js/message/list.js"></script>

<script type="text/template" id="ADD_NODE_TMP">
        <form id="form-message" method="post">
            <table cellpadding="5">
                <tr class="dialog-tr">
                    <td class="dialog-td">消息标题:</td>
                    <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width:300px"/></td>
                </tr>
                <tr class="dialog-tr">
                    <td class="dialog-td">消息内容:</td>
                    <td><input class="easyui-textbox" name="content" data-options="multiline:true,required:true" style="width:300px;height:60px"/></td>
                </tr>
                <tr class="dialog-tr">
                    <td class="dialog-td">消息类型:</td>
                    <td>
                        <select class="easyui-combobox" name="messageType" data-options="required:true,editable:false" style="width:300px">
                            <option value="1001">待办</option>
                            <option value="1002" selected>通知</option>
                        </select>
                    </td>
                </tr>
            </table>
        </form>
</script>
</html>

