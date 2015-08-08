<%--
  Created by IntelliJ IDEA.
  User: 潘锦发
  Date: 2015/6/10
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/script.jsp"%>
    <%--<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/metro/easyui.css">--%>
    <title>流程发布管理</title>
</head>
<body>
    <table id="dg" class="easyui-datagrid" title="流程发布管理" style="width:100%;height:100%"
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
                url:'${ctx}/api/activitiManage/queryProcessManage.do',
                method:'get',
                toolbar:'#tb',
                <%--//行号--%>
                rownumbers: true,
                <%--//设置分页段落--%>
                pagination: true"
            >
        <thead>
        <tr>
            <th data-options="field:'deploymentName',width:'10%',align:'center'">部署名称</th>
            <th data-options="field:'name',width:'10%',align:'center'">定义名称</th>
            <th data-options="field:'key',width:'10%',align:'center'">流程定义的Key</th>
            <th data-options="field:'category',width:'20%',align:'center'">业务命名空间</th>
            <th data-options="field:'version',width:'5%',align:'center'">版本</th>
            <th data-options="field:'resourceName',width:'10%',align:'center'">文件名称</th>
            <th data-options="field:'diagramResourceName',width:'10%',align:'center'">图片名称</th>
            <th data-options="field:'createTime',width:'10%',align:'center'">部署时间</th>
            <th data-options="field:'state',width:'10%',align:'center',styler:stateStyler">状态</th>
        </tr>
        </thead>
    </table>
    <div id="tb" style="padding:10px 24px;">
        <input class="easyui-textbox" type="text" id="key" style="width:100px" prompt="流程定义Key..">
        日期: <input class="easyui-datebox" type="text" id="startTime" name="startTime" style="width:100px">
        到: <input class="easyui-datebox"   type="text" id="endTime"  name="endTime" style="width:100px">
        <a class="easyui-linkbutton"  src="javascript:void(0)"  plain="true" onclick="doSearch()" iconCls="icon-search">搜索</a>
            <div style="float: right">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="$('#w').window('open')">添加</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" onclick="getdelete()">删除</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="getSuspend()">挂起</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="getActivate()">激活</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-track" onclick="getImage()">查看流程图</a>
            </div>
    </div>
    <div id="w" class="easyui-window" title="上传部署文件" data-options="modal:true,closed:true,iconCls:'icon-save',collapsible:false" style="width:500px;height:250px;padding:20px;">
        <form id="actform" action="${ctx}/api/activitiManage/deployUpload.do" method="post" enctype="multipart/form-data">
            <table width="100%" height="80%" style="font-size: inherit">
                <tr>
                    <td>部署名称:</td>
                    <td><input name="fileName" required="true" missingMessage="请填写部署名称..." class="easyui-textbox" data-options="width:'250px'"/></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td>Zip压缩包:</td>
                    <td><input name="file" required="true" class="easyui-filebox" data-options="width:'250px'"/></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; padding: 10px">
                        <a href="javascript:void(0)" class="easyui-linkbutton"
                           iconCls="icon-save" onclick="submitForm('actform','dg','w')">提交</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton"
                           iconCls="icon-cancel" onclick="clearForm('w')">取消</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="imageWin" class="easyui-window" title="流程查看" style="width:80%;height:200px;padding:10px;" data-options="modal:true,closed:true,maximized:true,maximizable:false,collapsible:false">
        <img id="activitiImage" style='position: absolute;margin-left:5px;margin-top:5px' src=""/>
    </div>
    <script type="text/javascript">
        //清除查询条件
        function ClearQuery() {
            $("#tb").find("input").val("");
        };
        //根据条件搜索
        function doSearch(){
            $('#dg').datagrid('reload',{
                key: $('#key').val(),
                startTime: $('input[name="startTime"]').val(),
                endTime: $('input[name="endTime"]').val()
            });
        };
        //删除
        function getdelete(){
            var row = $('#dg').datagrid('getSelected');
            if (row == null){
                $.messager.alert("提示", "请选择要<span style='color:#0000ff'>删除</span>的数据行！", "info");
            }
            if(row){
                $.messager.confirm("操作提示", "您确定要执行<span style='color:#0000ff'>删除</span>操作吗？<br>部署Id:"+row.deploymentId, function (data) {
                    if (data) {
                        $.ajax({
                            type : 'get',
                            url:window.ctx+'/api/activitiManage/deleteDeployment.do/'+row.deploymentId,
                            success:function(data){
                                $.messager.show({
                                    title:'温馨提示',
                                    msg:data,
                                    showType:'fade',
                                    style:{
                                        right:'',
                                        bottom:''
                                    }
                                });
                                $('#dg').datagrid('reload');
                            },
                            error:function(data){
                                $.messager.show({
                                    title:'系统提示',
                                    msg:'删除失败...',
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
        //挂起操作
        function getSuspend(){
            var row = $('#dg').datagrid('getSelected');
            if (row == null){
                $.messager.alert("提示", "请选择要<span style='color: red'>挂起</span>的数据行！", "info");
            }
            if(row){
                $.messager.confirm("操作提示", "您确定要执行<span style='color: red'>挂起</span>操作吗？<br>部署Id:"+row.deploymentId, function (data) {
                    if (data) {
                        $.ajax({
                            type : 'get',
                            url:window.ctx+'/api/activitiManage/suspendProcessDefinitionBykey.do/'+row.key+'/'+row.deploymentId,
                            success:function(data){
                                $.messager.show({
                                    title:'温馨提示',
                                    msg:data,
                                    showType:'fade',
                                    style:{
                                        right:'',
                                        bottom:''
                                    }
                                });
                                $('#dg').datagrid('reload');
                            },
                            error:function(data){
                                $.messager.show({
                                    title:'温馨提示',
                                    msg:'亲，挂起失败...',
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
        //激活操作
        function getActivate(){
            var row = $('#dg').datagrid('getSelected');
            if (row == null){
                $.messager.alert("提示", "请选择要<span style='color: red'>激活</span>的数据行！", "info");
            }
            if(row){
                $.messager.confirm("操作提示", "您确定要执行<span style='color: red'>激活</span>操作吗？<br>部署Id:"+row.deploymentId, function (data) {
                    if (data) {
                        $.ajax({
                            type : 'get',
                            url:window.ctx+'/api/activitiManage/activateProcessDefinition.do/'+row.key+'/'+row.deploymentId,
                            success:function(data){
                                $.messager.show({
                                    title:'温馨提示',
                                    timeout : 2000,
                                    msg:data,
                                    showType:'fade',
                                    style:{
                                        right:'',
                                        bottom:''
                                    }
                                });
                                $('#dg').datagrid('reload');
                            },
                            error:function(data){
                                $.messager.show({
                                    title:'温馨提示',
                                    msg:'亲，激活失败...',
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
        //查看图片
        function getImage(){
            var row = $('#dg').datagrid('getSelected');
            if (row == null){
                $.messager.alert("提示", "请选择要<span style='color: red'>查看流程图</span>的数据行！", "info");
            }
            if(row){
                var url = '${ctx}/api/activitiManage/imageDeployment.do/'+row.diagramResourceName+'/'+row.deploymentId;
                $('#activitiImage').attr("src",url);
                $('#imageWin').window('open');
                /*$.messager.show({
                    title:'查看流程图',
                    msg:"<img style='position: absolute;margin-left:-11px;margin-top:-11px' src='${ctx}/api/activitiManage/imageDeployment.do/"+row.diagramResourceName+"/"+row.deploymentId+"'>",
                    showType:'slide',
                    style:{
                        width:'95%',
                        height:'100%',
                        right:'',
                        top:'10px',
                        left:'10px',
                        bottom:-document.body.scrollTop-document.documentElement.scrollTop
                    }
                });*/
            }
        };
        //选择条件
        function stateStyler(value,row,index){
            if (value =="挂起"){
                return 'background-color:#E5EFFF;color:red;';
            }else{
                return 'color:blue;';
            }
        }
        //发送表单数据
        $(function(){
            $('#ff').form({
                success:function(data){
                    $('#w').window('close')
                    $('#dg').datagrid('reload');
                    $.messager.show({
                        title:'温馨提示',
                        msg:data,
                        showType:'fade',
                        style:{
                            right:'',
                            bottom:''
                        }
                    });
                },
                error:function(data){
                    $('#w').window('close')
                    $.messager.show({
                        title:'温馨提示',
                        msg:data,
                        showType:'fade',
                        style:{
                            right:'',
                            bottom:''
                        }
                    });
                }
            });
        });
    </script>
</body>
</html>
