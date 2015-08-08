<%--
  Created by IntelliJ IDEA.
  User: 潘锦发
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
    <%--<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/metro/easyui.css">--%>
    <title>流程实例管理</title>
</head>
<body>
<table id="table" class="easyui-datagrid" title="流程实例管理" style="width:100%;height:100%"
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
                url:'${ctx}/api/activitiManage/queryInstanceManage.do',
                method:'get',
                toolbar:'#tb',
                <%--//行号--%>
                rownumbers: true,
                <%--//设置分页段落--%>
                pagination: true"
        >
    <thead>
    <tr>
        <th data-options="field:'id',width:1,align:'center',hidden:'true'">流程实例ID</th>
        <th data-options="field:'summary',width:'30%'">摘要</th>
        <th data-options="field:'DefinitionName',width:'15%'">流程名称</th>
        <th data-options="field:'DefinitionVersion',width:'5%',align:'center'">版本</th>
        <th data-options="field:'ActivityId',width:'10%'">活动节点</th>
        <th data-options="field:'cdp',width:'10%',align:'center'">创建人</th>
        <th data-options="field:'cdt',width:'15%',align:'center'">创建时间</th>
        <th data-options="field:'state',width:'5%',align:'center',styler:stateStyler">状态</th>
    </tr>
    </thead>
</table>
<div id="tb" style="padding:10px 24px;">
    <form id="wform">
        条件：<input class="easyui-textbox" type="text" name="w.condition" style="width:300px" prompt="请输入摘要、创建人......">
        从： <input name="w.fdate" class="easyui-datebox"
                  style="width: 150px"></input>
        到： <input name="w.edate" class="easyui-datebox"
                  style="width: 150px"></input>
        <a class="easyui-linkbutton" src="javascript:void(0)" plain="true" onclick="doSearch('table','wform')"
           iconCls="icon-search">搜索</a>
        <div style="float: right">
            <a href="javascript:void(0)" iconCls="icon-track" class="easyui-linkbutton" onclick="openDetail()">查看</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="getSuspend()">挂起</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="getActivate()">激活</a>
        </div>
    </form>
</div>
</div>
    <div id="detailWin" class="easyui-window" title="查看明细" data-options="modal:true,closed:true,iconCls:'',collapsible:false,maximized:false,maximized:true" style="width:800px;height:400px;">

    </div>
<script type="text/javascript">
    function doSearch(dg ,form) {
        $('#'+dg).datagrid({
            queryParams: $('#'+form).serializeObject()
        });
    }
    function getSuspend() {
        var row = $('#table').datagrid('getSelected');
        if (row == null) {
            $.messager.alert("提示", "请选择要<span style='color: red'>挂起</span>的数据行！", "info");
        }
        if (row) {
            $.messager.confirm("操作提示", "您确定要执行<span style='color: red'>挂起</span>操作吗？<br>流程实例Id:" + row.ProcessInstanceId, function (data) {
                if (data) {
                    $.ajax({
                        type: 'get',
                        url: window.ctx + '/api/activitiManage/suspendProcessInstance.do/' + row.ProcessInstanceId,
                        success: function (data) {
                            $.messager.show({
                                title: '温馨提示',
                                msg: data,
                                showType: 'fade',
                                timeout: 2000,
                                style: {
                                    right: '',
                                    bottom: ''
                                }
                            });
                            $('#table').datagrid('reload');
                        },
                        error: function (data) {
                            $.messager.show({
                                title: '温馨提示',
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
    }
    ;
    function getActivate() {
        var row = $('#table').datagrid('getSelected');
        if (row == null) {
            $.messager.alert("提示", "请选择要<span style='color: red'>激活</span>的数据行！", "info");
        }
        if (row) {
            $.messager.confirm("操作提示", "您确定要执行<span style='color: red'>激活</span>操作吗？<br>流程实例Id:" + row.ProcessInstanceId, function (data) {
                if (data) {
                    $.ajax({
                        type: 'get',
                        url: window.ctx + '/api/activitiManage/activateProcessInstance.do/' + row.ProcessInstanceId,
                        success: function (data) {
                            $.messager.show({
                                title: '温馨提示',
                                msg: data,
                                showType: 'fade',
                                timeout: 2000,
                                style: {
                                    right: '',
                                    bottom: ''
                                }
                            });
                            $('#table').datagrid('reload');
                        },
                        error: function (data) {
                            $.messager.show({
                                title: '温馨提示',
                                msg: '亲，激活失败...',
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
    }
    ;
    function stateStyler(value, row, index) {
        if (value == "挂起") {
            return 'background-color:#E5EFFF;color:red;';
        } else {
            return 'color:blue;';
        }
    }
    function openDetail(){
        var row = $('#table').datagrid('getSelected');
        if (row == null) {
            $.messager.alert("提示", "请选择要<span style='color: red'>查看</span>的数据行！", "info");
        } else {
            $('#detailWin').window('refresh', '${ctx}/activitiPage/findProinstanceTask.do?instanceId=' + row.id);
            $('#detailWin').window('open');
        }
    }
</script>
</body>
</html>