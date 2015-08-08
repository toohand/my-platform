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
    <title>已完成任务</title>
</head>
<body>
        <table id="table" class="easyui-datagrid" title="已完成任务" style="width:100%;height: 100%"
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
                url:'${ctx}/api/activitiManage/queryHisTask.do',
                queryParams:{
                   categorys:'${actCategorys}',
                   'w.userId':'${userId}',
                   'w.state':'1'
                },
                toolbar:'#tb',
                <%--//行号--%>
                rownumbers: true,
                <%--//设置分页段落--%>
                pagination: true"
                >
            <thead>
            <tr>
                <th data-options="field:'id',width:150,align:'center',hidden:'true'">任务ID</th>
                <th data-options="field:'name',width:'10%',align:'center'">任务名称</th>
                <th data-options="field:'summary',width:'30%',align:'center'">摘要</th>
                <th data-options="field:'assignee',width:'10%',align:'center'">办理人</th>
                <th data-options="field:'createTime',width:'15%',align:'center'">开始时间</th>
                <th data-options="field:'endTime',width:'15%',align:'center'">结束时间</th>
                <th data-options="field:'duraction',width:'10%',align:'center',formatter:duratTime">任务耗时</th>
                <th data-options="field:'state',width:'5%',align:'center',styler:stateStyler">状态</th>
            </tr>
            </thead>
        </table>
        <div id="tb" style="padding:4px 24px;">
            <form id="sform">
                <input type="hidden" name="categorys" value="${actCategorys}"/>
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
                    <a href="javascript:void(0)" iconCls="icon-track" class="easyui-linkbutton" onclick="openDetail()">跟踪</a>
                </div>
            </form>
        </div>
        <div id="detailWin" class="easyui-window" title="流程跟踪" data-options="modal:true,closed:true,iconCls:'',collapsible:false,maximized:false,maximized:true" style="width:800px;height:400px;">

        </div>
    <script type="text/javascript">
        //根据条件搜索
        function doSearch(){
            $('#table').datagrid({
                queryParams: $('#'+form).serializeObject()
            });
        };

        function duratTime(value, row, index) {
            var result = value / 1000 / 60;
            return result.toFixed(2);
        }
        function stateStyler(value,row,index){
            if (value =="未完成"){
                return 'background-color:#E5EFFF;color:red;';
            }else{
                return 'color:blue;';
            }
        }
        function openDetail(){
            var row = $('#table').datagrid('getSelected');
            if (row == null) {
                $.messager.alert("提示", "请选择要<span style='color: red'>查看</span>的数据行！", "info");
            } else {
                $('#detailWin').window('refresh', '${ctx}/activitiPage/findProinstanceTask.do?instanceId=' + row.processInstanceId);
                $('#detailWin').window('open');
            }
        }
    </script>
</body>
</html>
