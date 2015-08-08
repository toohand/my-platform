<%@ page contentType="text/html;charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/meta.jsp"%>
<%@include file="/common/script.jsp"%>
<body>
	<div class="easyui-panel" border=false style="padding: 10px 20px">
		<form id="fid" class="easyui-form" method="post" data-options="novalidate:true" action="${ctx}/api/activitiBusiness/completeReplaceTask.do">
            <input type="hidden" name="taskId" value="${taskId}">
            <input type="hidden" name="assignee" value="${assignee}">
            <div class="unit">
                <label style="width:60px" >批注:</label>
                <input class="easyui-textbox" type="text"
                       name="comment" value=""
                       data-options="multiline:true" style="width:400px;height:80px"></input>
            </div>
            <div class="unit">
                <label style="width:60px" >走向：</label>
                    <c:forEach var="item" items="${outcome}">
                        <input class="easyui-validatebox"  data-options="required:true" type="radio" name="outcome"
                               value="${item.activityId}">${item.OptName}(${item.activityName})</input>
                    </c:forEach>
            </div>
            <div class="unit">
                <div style="text-align: center; padding: 1px">
                    <a href="javascript:void(0)" class="easyui-linkbutton"
                           iconCls="icon-save" onclick="submitForm('fid','table','win')">提交</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton"
                       iconCls="icon-cancel" onclick="clearForm('win')">关闭</a>
                </div>
            </div>
		</form>
	</div>
<script>
    $(function(){
        $('#fid').form({
            success:function(data){
                $('#win').window('close')
                $('#table').datagrid('reload');
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
            },
            error:function(data){
                $('#win').window('close')
                $.messager.show({
                    title:'温馨提示',
                    msg:data,
                    timeout : 2000,
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

