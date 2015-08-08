<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2015/6/10
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="/common/meta.jsp" %>
    <%@include file="/common/script.jsp" %>
    <title>流程管理</title>
</head>
<body>
<table id="table" class="easyui-datagrid" title="流程管理" style="width:100%;height:100%"
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
                url:'${ctx}/api/activitiManage/queryProcessModel.do',
                method:'get',
                toolbar:'#tb',
                <%--//行号--%>
                rownumbers: true,
                <%--//设置分页段落--%>
                pagination: true"
        >
    <thead>
    <tr>
        <th data-options="field:'id',width:1,align:'center',hidden:'true'">流程图ID</th>
        <th data-options="field:'name',width:'30%'">名称</th>
        <th data-options="field:'category',width:'15%'">业务命名空间</th>
        <th data-options="field:'version',width:'5%',align:'center'">版本</th>
        <th data-options="field:'createTime',width:'15%'">创建时间</th>
        <th data-options="field:'lastUpdateTime',width:'15%',align:'center'">修改时间</th>
        <th data-options="field:'xsf',width:'10%',align:'center',formatter:editModel">编辑流程</th>
    </tr>
    </thead>
</table>
<div id="tb" style="padding:10px 24px;">
    <form id="wform">
        条件：<input class="easyui-textbox" type="text" name="w.condition" style="width:300px" prompt="请输入名称、key......">
        <a class="easyui-linkbutton" src="javascript:void(0)" plain="true" onclick="doSearch('table','wform')"
           iconCls="icon-search">搜索</a>
        <div style="float: right">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="addModel()">新增模板</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-deploy" onclick="deployed()">发布版本</a>
        </div>
    </form>
</div>
</div>
<div id="w" class="easyui-window" title="新增流程模板" data-options="modal:true,closed:true,iconCls:'icon-save',collapsible:false" style="width:500px;height:300px;padding:10px;">
    <form id="actform" action="${ctx}/api/activitiManage/addModel.do" method="post" enctype="multipart/form-data">
        <table width="100%" height="200px" style="font-size: inherit">
            <tr style="height: 30px">
                <td>名称:</td>
                <td><input name="name" required="true" missingMessage="请填写名称..." class="easyui-textbox" data-options="width:'250px'"/></td>
            </tr>
            <tr style="height: 30px">
                <td>业务命名:</td>
                <td><input name="category" required="true" missingMessage="请填写业务命名空间..." class="easyui-textbox" data-options="width:'250px'"/></td>
            </tr>
            <tr style="height: 90px">
                <td>描述:</td>
                <td><input class="easyui-textbox" type="text" name="remark"
                      data-options="multiline:true" style="width:250px;height:80px"></input></td>
            </tr>
            <tr>
                <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; padding: 10px">
                    <a href="javascript:void(0)" class="easyui-linkbutton"
                       iconCls="icon-save" onclick="submitForm('actform','tabel','w')">提交</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton"
                       iconCls="icon-cancel" onclick="clearForm('w')">取消</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    function doSearch(dg ,form) {
        $('#'+dg).datagrid({
            queryParams: $('#'+form).serializeObject()
        });
    }
    function editModel(value, row, index){
        return " <a target='_Blank'  href=${editUrl}?modelId=" + row.id +
                "> <img align='middle' src='${ctx}/Frame/images/transact.png'/> </a>";
    }
    function deployed() {
        var row = $('#table').datagrid('getSelected');
        if (row == null) {
            $.messager.alert("提示", "请选择要<span style='color: red'>发布</span>的流程！", "info");
        }
        if (row) {
            $.messager.confirm("操作提示", "您确定要执行<span style='color: red'>发布</span>操作吗？<br>流程:" + row.name, function (data) {
                if (data) {
                    $.ajax({
                        type: 'get',
                        url: window.ctx + '/api/activitiManage/deployed.do?modelId=' + row.id,
                        success: function (data) {
                            var data = eval('(' + data + ')');
                            if (data) {
                                if (data.statuscode == "1") {
                                    showMsg('提示', data.message);
                                    if (gid && gid != '') {
                                        $('#' + gid).datagrid({});
                                    }
                                } else {
                                    showMsg('提示', data.message);
                                }
                            } else {
                                showMsg('提示', '发布失败！');
                            }
                        },
                        error: function (data) {
                            $.messager.show({
                                title: '系统提示',
                                msg: '亲，挂起失败...',
                                showType: 'fade',
                                timeout: 2000,
                                style: {
                                    right: '',
                                    bottom: ''
                                }
                            });
                        }
                    })
                }
                else {
                    //取消操作
                }
            });

        }
    };
    function addModel(){
        $('#w').window('open');
    }
</script>
</body>
</html>