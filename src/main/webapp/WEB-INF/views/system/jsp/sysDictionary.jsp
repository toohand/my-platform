<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
    <title>数据字典管理</title>
    <%@include file="/common/meta.jsp" %>
    <%@include file="/common/script.jsp" %>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery-easyui/jquery.edatagrid.js"></script>
</head>
<body>
<div id="tb" style="padding: 10px;">
    <f:form id="sform" commandName="vo">
        字典分类：<input name="typeId" id="typeId" data-options="valueField: 'id',textField: 'text',url:'${ctx}/sysDictionary/loadDtyType.do'"
        class="easyui-combobox" style="width:200px;"/>
        名称：<input name="dtyName" class="easyui-textbox" type="text" data-options="prompt:'请输入名称....'" style="width: 200px"></input>
        <a href="#" class="easyui-linkbutton" onclick="doSearch()" data-options="iconCls:'icon-search'"
           style="width:80px">查询</a>

        <div style="float: right">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add"
               plain="true" onclick="addRow()">新增</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
               onclick="deleteRow('dg','${ctx}/sysDictionary/delete.do')">删除</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"
               onclick="save()">保存</a>
        </div>
    </f:form>
</div>
<div id="win" class="easyui-window" title="数据字典管理"
     data-options="iconCls:'${icon}',minimizable:true,modal:true,closed:true"
     style="width: 550px; height: 350px; padding: 10px;"></div>
<table id="dg" title="   数据字典管理"
       iconCls='${icon}' style="width: 100%; height: 100%; padding: 0px;"
       data-options="
		        border:false,
                rownumbers:true,
                singleSelect:true,
                pagination:true,
                autoSave:false,
                saveUrl: '${ctx}/sysDictionary/save.do',
    			updateUrl: '${ctx}/sysDictionary/save.do',
                toolbar:'#tb',
                pageSize:20">
    <thead>
    <tr>
        <th field="id" hidden=true>id</th>
        <th field="typeId" hidden=true>分类ID</th>
        <th field="typeName" width="15%">分类</th>
        <th field="dtyName" width="20%" data-options="editor:{type:'textbox',options:{required:true}}">名称</th>
        <th field="sortCode" width="5%" data-options="editor:{type:'numberbox',options:{required:true}}">排序码</th>
        <th field="remark" width="20%" data-options="editor:'textbox'">描述</th>
        <th field="state" width="5%" data-options="editor:{type:'checkbox',options:{on:1,off:0}}" formatter=formatState>状态</th>
        <th field="cdt" width="15%">创建时间</th>
        <th field="cdp" width="15%">创建人</th>
    </tr>
    </thead>
</table>
</body>
<script>
    $(function () {
        $('#dg').edatagrid({
            onSuccess:function (index ,row){
                if (row.statuscode == "1" ){
                    showMsg('提示', "["+row.dtyName+"]保存成功!");
                    if(row.id == "" || row.id == null){
                        $('#dg').datagrid({
                            queryParams: $('#sform').serializeObject()
                        });
                    }
                } else {
                    showMsg('提示',"["+row.dtyName+"]"+row.message);
                }

            },
            onError: function(index,row){
                alert("保存失败，错误信息："+row.message);
            }
        });
        $('#typeId').combobox({
            onSelect: function () {
                $('#dg').datagrid({
                    queryParams: $('#sform').serializeObject()
                });
            },
            onLoadSuccess:function(){
                $('#dg').datagrid({
                    url:'${ctx}/sysDictionary/query.do',
                    queryParams: $('#sform').serializeObject()
                });
            }
        });
    });
    function save(){
        $('#dg').edatagrid('saveRow',{});
    }
    function doSearch() {
        $('#dg').datagrid({
            queryParams: $('#sform').serializeObject()
        });
    }
    function deleteRow(dg,url) {
        $.messager.alert('警告', '该字典类型是系统保设置，不能新增和删除！');
        return ;
        del(dg,url);
    }
    function addRow() {
        var typeValue = $('#typeId').combobox("getValue");
       /* if (typeValue>=1000 && typeValue<=1999 ){
            $.messager.alert('警告', '该字典类型是系统保设置，不能新增和删除！');
            return ;
        }*/
        var options = $('#dg').datagrid('getPager').data("pagination").options;
        var totalRowNum = options.total
        $('#dg').edatagrid('addRow', {
            index: 0,
            row: {
                typeId: $('#typeId').combobox('getValue'),
                typeName: $('#typeId').combobox('getText'),
                sortCode:totalRowNum+1,
                state: 1
            }
        });
    }

    function  formatState(val, row){
        if (val == 0)
           return "停用";
        else
           return "启用";
    }
</script>

