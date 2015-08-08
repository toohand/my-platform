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
    <title>我的任务</title>
</head>
<body>
<div id="tb1" style="padding: 10px;">
    <form id="sform1">
        <input type="hidden" name="categorys" value="${actCategorys}"/>
        <input type="hidden" name="userId" value="${userId}"/>
        任务名称：<input name="w.name" class="easyui-textbox"
                    data-options="prompt:'任务名称...'"
                    style="width: 200px"></input>
        摘要： <input name="w.summary" class="easyui-textbox"
                   data-options="prompt:'摘要....'"
                   style="width: 200px"></input>
        从： <input name="w.fdate" class="easyui-datebox"
                  style="width: 150px"></input>
        到： <input name="w.edate" class="easyui-datebox"
                  style="width: 150px"></input>
        <a href="#" class="easyui-linkbutton" onclick="doSearch('table1','sform1')" data-options="iconCls:'icon-search'"
           style="width:80px">查询</a>
    </form>
</div>
<div id="tb" style="padding: 10px;">
    <form id="sform">
        <input type="hidden" name="categorys" value="${actCategorys}"/>
        <input type="hidden" name="userId" value="${userId}"/>
        任务名称：<input name="w.name" class="easyui-textbox"
                    data-options="prompt:'任务名称...'"
                    style="width: 200px"></input>
        摘要： <input name="w.summary" class="easyui-textbox"
                   data-options="prompt:'摘要....'"
                   style="width: 200px"></input>
        从： <input name="w.fdate" class="easyui-datebox"
                  style="width: 150px"></input>
        到： <input name="w.edate" class="easyui-datebox"
                  style="width: 150px"></input>
        <a href="#" class="easyui-linkbutton" onclick="doSearch('table','sform')" data-options="iconCls:'icon-search'"
           style="width:80px">查询</a>

        <div style="float: right">
            <a href="#" class="easyui-linkbutton" iconCls="icon-sign"
               plain="true" onclick="claimedTaskClik('table','${ctx}//api/activitiBusiness/claimedTask.do')">认领</a>
        </div>
    </form>
</div>
<div class="easyui-tabs" id="tab" style="width:100%;height:100%">
    <div title="待办任务"  style="width:100%;height:100%">
        <table id="table1" class="easyui-datagrid" style="width:100%;height:96%"
               data-options="
                border:false,
            <%--// 是否禁止文字自动换行--%>
                nowrap: false,
                <%--//是否带条纹--%>
                striped: true,
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
                url:'${ctx}/api/activitiManage/queryUndoTask.do',
                method:'post',
                toolbar:'#tb1',
                <%--//行号--%>
                rownumbers: true,
                queryParams:{
                   categorys:'${actCategorys}',
                   userId:'${userId}'
                },
                <%--//设置分页段落--%>
                pagination: true"
                >
            <thead>
            <tr>
                <th data-options="field:'id',width:150,align:'center',hidden:'true'">任务ID</th>
                <th data-options="field:'name',width:'20%',align:'center'">任务名称</th>
                <th data-options="field:'summary',width:'40%',align:'center'">摘要</th>
                <th data-options="field:'assignee',width:'8%',align:'center'">办理人</th>
                <th data-options="field:'createTime',width:'15%',align:'center'">创建时间</th>
                <th data-options="field:'state',width:'5%',align:'center',styler:stateStyler">状态</th>
                <th data-options="field:'formKey',width:'5%',align:'center',formatter:view">查看</th>
                <th data-options="field:'formKey1',width:'5%',align:'center',formatter:done">办理</th>
            </tr>
            </thead>
        </table>
    </div>
    <div title="待认领任务" id="tab1"  style="width:100%;height:100%">
        <table id="table" class="easyui-datagrid" style="width:100%;height:96%"
               data-options="
                border:false,
            <%--// 是否禁止文字自动换行--%>
                nowrap: false,
                <%--//是否带条纹--%>
                striped: true,
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
                url:'${ctx}/api/activitiManage/queryUnclaimedTaskByGroup.do',
                method:'post',
                toolbar:'#tb',
                <%--//行号--%>
                rownumbers: true,
                queryParams:{
                   categorys:'${actCategorys}',
                   groups:'${groups}'
                },
                <%--//设置分页段落--%>
                pagination: true"
                >
            <thead>
            <tr>
                <th data-options="field:'id',width:150,align:'center',hidden:'true'">任务ID</th>
                <th data-options="field:'name',width:'20%',align:'center'">任务名称</th>
                <th data-options="field:'summary',width:'40%',align:'center'">摘要</th>
                <th data-options="field:'assignee',width:'8%',align:'center'">办理人</th>
                <th data-options="field:'createTime',width:'15%',align:'center'">创建时间</th>
                <th data-options="field:'state',width:'5%',align:'center',styler:stateStyler">状态</th>
                <th data-options="field:'formKey',width:'5%',align:'center',formatter:view">查看</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<div id="win" class="easyui-window" title="组任务管理-管理员"
     data-options="iconCls:'${icon}',minimizable:true,modal:true,closed:true"
     style="width:350px; height:200px; padding: 10px;">
</div>

</div>
</body>
<script>
    $("#table1").datagrid({
        onLoadSuccess: function (data) {
            var tab1 =  $("#tab").tabs("getTab",0);
            $('#tab').tabs('update', {
                tab: tab1,
                options: {
                    title: "待办任务(<span style='color: red'>" + data.total + "</span>)"
                }
            });
        }
    });
    $("#table").datagrid({
        onLoadSuccess: function (data) {
            var tab1 =  $("#tab").tabs("getTab",1);
            $('#tab').tabs('update', {
                tab: tab1,
                options: {
                    title: "待认领任务(<span style='color: red'>" + data.total + "</span>)"
                }
            });
        }
    });
    function doSearch(dg, form) {
        $('#' + dg).datagrid({
            queryParams: $('#' + form).serializeObject()
        });
    }
    function stateStyler(value, row, index) {
        if (value == "挂起") {
            return 'background-color:#E5EFFF;color:red;';
        } else {
            return 'color:blue;';
        }
    }
    function view(value, row, index) {
        return " <a target='center'  href=${ctx}" + value + "?opt=view&taskId=" + row.id +
                "> <img align='middle' src='${ctx}/Frame/images/view.png'/> </a>"
    }
    function done(value, row, index) {
        return " <a target='center'  href=${ctx}" + row.formKey + "?opt=transact&taskId=" + row.id +
                "> <img align='middle' src='${ctx}/Frame/images/transact.png'/></a>"
    }
    function claimedTaskClik(gid, url) {
        var row = $('#' + gid).datagrid('getSelected');
        $.messager.confirm('确认', "确认认领改任务吗？", function (r) {
            if (r) {
                $.ajax({
                    type: 'get',
                    url: url,
                    data: {
                        "taskId": row.id
                    },
                    success: function (data) {
                        var data = eval('(' + data + ')');
                        if (data) {
                            if (data.statuscode == "1") {
                                showMsg('提示', data.message);
                                    $('#table1').datagrid({});
                                    $('#table').datagrid({});
                            } else {
                                showMsg('提示', data.message);
                            }
                        } else {
                            showMsg('提示', '任务认领失败！');
                        }
                    }
                })
            }
        })
    }

</script>
</html>