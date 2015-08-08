<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2015/6/10
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/script.jsp"%>
    <title>任务管理</title>
</head>
<body>
        <table id="table" class="easyui-datagrid" title="任务管理...." style="width:100%;height:100%"
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
                url:'${ctx}/api/activitiManage/queryUndoTask.do?userId=admin',
                 queryParams:{
                   categorys:'${actCategorys}'
                },
                method:'post',
                toolbar:'#tb',
                <%--//行号--%>
                rownumbers: true,
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
                <%--<th data-options="field:'formKey',width:'5%',align:'center',formatter:view">查看</th>--%>
            </tr>
            </thead>
        </table>
        <div id="tb" style="padding:10px 24px;">
            <form id="sform">
                <input type="hidden" name="categorys" value="${actCategorys}"/>
                名称：<input name="w.name" class="easyui-textbox"
                            data-options="prompt:'任务名称...'"
                            style="width: 120px"></input>
                摘要： <input name="w.summary" class="easyui-textbox"
                           data-options="prompt:'摘要....'"
                           style="width: 120px"></input>
                办理人： <input name="w.userName" class="easyui-textbox"
                           data-options="prompt:'办理人....'"
                           style="width: 100px"></input>
                从： <input name="w.fdate" class="easyui-datebox"
                          style="width: 120px"></input>
                到： <input name="w.edate" class="easyui-datebox"
                          style="width: 120px"></input>
                <a href="#" class="easyui-linkbutton" onclick="doSearch('table','sform')" data-options="iconCls:'icon-search'"
                   style="width:60px">查询</a>

                <div style="float: right">
                    <a href="javascript:void(0)" class="easyui-linkbutton" style="width:60px" data-options="iconCls:'icon-assign'" onclick="delegation('table','win')">委托</a>
                    <a href="javascript:void(0)"  class="easyui-linkbutton" style="width:60px" data-options="iconCls:'icon-replace'" onclick="replaceDispose('table','win','${ctx}/api/activitiManage/getRdTask.do')">代办</a>
                </div>
            </form>

        </div>
        <div id="win" class="easyui-window" title="代办任务处理-管理员"
             data-options="iconCls:'${icon}',minimizable:true,modal:true,closed:true"
             style="width:600px; height:300px; padding: 10px;">
        </div>
    <script type="text/javascript">

        function delegation(gid, wid) {
            var row = $('#' + gid).datagrid('getSelected');
            if (row != null) {
                $('#' + wid).window('open');
                $('#' + wid).window('refresh', '${ctx}/activitiPage/delegationTask.do?taskId=' + row.id+'&oldUserId='+row.assignee);
            } else {
                $.messager.alert('警告', '请选择要委托办理的数据！');
            }
        }
        function replaceDispose(gid, wid, url) {
            var row = $('#' + gid).datagrid('getSelected');
            if (row != null) {
                $('#' + wid).window('open');
                $('#' + wid).window('refresh', url + '/' + row.id+'/'+row.assignee);
            } else {
                $.messager.alert('警告', '请选择要代办的数据！');
            }
        }
        function opt(val, row){
          return  " <a target='center' href=${ctx}"+val+"?opt=transact&taskId="+row.Id+"&processInstanceId="+row.ProcessInstanceId+
                  " class='easyui-linkbutton' data-options='plain:true'>办理</a>"
        }
        function view(value, row, index) {
            return " <a target='center'  href=${ctx}" + value + "?opt=view&taskId=" + row.id +
                    "> <img align='middle' src='${ctx}/Frame/images/view.png'/> </a>"
        }
        //根据条件搜索
        function doSearch(dg ,form) {
            $('#'+dg).datagrid({
                queryParams: $('#'+form).serializeObject()
            });
        }


        //中止
        function getEnd(){
            var row = $('#table').datagrid('getSelected');
            if (row == null){
                $.messager.alert("提示", "请选择要<span style='color: rgba(255, 0, 0, 0.01)'>中止</span>的数据行！", "info");
            }
            if(row){
                $.messager.confirm("操作提示", "您确定要执行<span style='color: red'>中止</span>操作吗？<br><br>中止任务名称:"+row.Name, function (data) {
                    if (data) {
                        $.ajax({
                            type : 'get',
                            url:window.ctx+'/api/activitiManage/endProcessTask.do/'+row.id,
                            success:function(data){
                                $.messager.show({
                                    shadow:false,
                                    title:'系统提示',
                                    timeout : 2000,
                                    msg:data,
                                    showType:'fade',
                                    style:{
                                        right:'',
                                        bottom:''
                                    }
                                });
                                $('#table').datagrid('reload');
                            },
                            error:function(data){
                                $.messager.show({
                                    title:'系统提示',
                                    msg:'终止失败...',
                                    timeout : 2000,
                                    showType:'fade',
                                    style:{
                                        right:'',
                                        bottom:''
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
        function getActivate(){
            var row = $('#table').datagrid('getSelected');
            if (row == null){
                $.messager.alert("提示", "请选择要<span style='color: red'>激活</span>的数据行！", "info");
            }
            if(row){
                $.messager.confirm("操作提示", "您确定要执行<span style='color: red'>激活</span>操作吗？<br><br>挂起任务名称:"+row.Name, function (data) {
                    if (data) {
                        $.ajax({
                            type : 'get',
                            url:window.ctx+'/api/activitiManage/activateProcessDefinition.do/'+row.ProcessInstanceId,
                            success:function(data){
                                $.messager.show({
                                    title:'温馨提示',
                                    msg:data,
                                    showType:'fade',
                                    timeout : 2000,
                                    style:{
                                        right:'',
                                        bottom:''
                                    }
                                });
                                $('#table').datagrid('reload');
                            },
                            error:function(data){
                                $.messager.show({
                                    title:'温馨提示',
                                    msg:'亲，激活失败...',
                                    showType:'fade',
                                    timeout : 2000,
                                    style:{
                                        right:'',
                                        bottom:''
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
        function stateStyler(value,row,index){
            if (value =="挂起"){
                return 'background-color:#E5EFFF;color:red;';
            }else{
                return 'color:blue;';
            }
        }
    </script>
</body>
</html>
