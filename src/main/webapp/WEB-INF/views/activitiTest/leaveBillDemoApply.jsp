<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
    <title>请假流程Demo</title>
    <%@include file="/common/meta.jsp" %>
    <%@include file="/common/script.jsp" %>

</head>
<body style="">
<div class="easyui-panel" border=false style="padding: 10px 150px;">
    <f:form id="fid" method="post" commandName="vo"
            data-options="novalidate:true" action="${ctx}/leaveBillDemo/submit.do">
        <input type="hidden" name="id" value="${vo.id}"/>
        <input type="hidden" name="state" value="${vo.state}"/>
        <input type="hidden" name="userId" value="${vo.userId}"/>

        <div class="unit"><span style="text-align: center;width:650px;font-size: x-large"> 人员请假<span></div>
        <hr class="hr" style="width:650px;padding:2 "/>
        <div class="unit">
                   <span>
                       <label style="width:60px">申请人：</label>
                       <input class="easyui-textbox" type="text"
                              name="loginName" value="${vo.loginName}"
                              data-options=" width:'200px',editable:false"></input>
                    </span>&nbsp;&nbsp;&nbsp;&nbsp;
				   <span>
				      <label style="width:60px">职务：</label>
				      <input class="easyui-textbox" type="text"
                             name="postName" value="${vo.postName}"
                             data-options=" width:'200px',editable:${fromWrite}"></input>
                   </span>
        </div>
        <div class="unit">
            <span>
            <label style="width:60px">请假天数：</label>
            <input class="easyui-textbox" type="text"
                   name="day" value="${vo.day}"
                   data-options=" width:'200px',required:true,editable:${fromWrite}"></input>
            </span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span>
            <label style="width:60px">假期类型：</label>
            <f:select path="leaveType" items="${leaveTypeMap}" class="easyui-combobox"
                      data-options=" width:'200px',required:true,editable:${fromWrite}"/>
            </span>
        </div>

        <div class="unit">
            <span>
            <label style="width:60px">开始时间：</label>
            <input class="easyui-datetimebox"
                   name="startTime" value="<fmt:formatDate value='${vo.startTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"
                   data-options=" width:'200px',required:true,editable:${fromWrite}"></input>
            </span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span>
            <label style="width:60px">结束时间：</label>
            <input class="easyui-datetimebox" data-options=" width:'200px',required:true,editable:${fromWrite}"
                   name="endTime" value="<fmt:formatDate value='${vo.endTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"></input>
            </span>
        </div>
        <c:if test="${opt == 'transact'}">
            <div class="unit">
                <label style="width:60px">请假理由：</label>
                <input class="easyui-textbox" type="text"
                       name="content" value="${vo.content}"
                       data-options="multiline:true,editable:${fromWrite}" style="width:560px;height:80px"></input>
            </div>
            <input type="hidden" name="act.taskId" value="${taskId}"/>
            <c:if test="${taskId != null }">
                <div id="hismsg" class="easyui-window" title="请假流程Demo"
                     data-options="iconCls:'',minimizable:true,modal:true,closed:true"
                     style="width: 600px; height: 300px; padding: 2px;"></div>
                <table width="650px" style="font-size: inherit">
                    <tr>
                        <td colspan="3" style="text-align: right;height: 40px">
                            <a  href="javascript:void(0)" onclick="showWin('hismsg','${ctx}/activitiPage/findHisComment.do?taskId=${taskId}')" class="easyui-linkbutton" iconCls="icon-edit" plain="true" style="width:80px">历史批注</a>
                        </td>
                    </tr>
                    <tr>
                        <td style="width:60px">批注:</td>
                        <td colspan="2"><input class="easyui-textbox" type="text"
                                               name="act.comment" value=""
                                               data-options="multiline:true" style="width:560px;height:80px"></input>
                        </td>
                    </tr>
                    <c:forEach var="item" items="${links}" varStatus="status">
                        <c:if test="${status.index==0}">
                            <td style="width:60px" rowspan=10>流向：</td>
                        </c:if>
                        <td height="30px">
                            <c:choose>
                                <c:when test="${status.index==0}">
                                    <input class="easyui-validatebox" data-options="required:true" type="radio"
                                           name="act.activityId" checked="true"
                                           value="${item.activityId}">${item.OptName}(${item.activityName})</input>
                                </c:when>
                                <c:when test="${status.index>0}">
                                    <input class="easyui-validatebox" data-options="required:true" type="radio"
                                           name="act.activityId"
                                           value="${item.activityId}">${item.OptName}(${item.activityName})</input>
                                </c:when>
                            </c:choose>
                        </td>
                        <td> &nbsp;&nbsp;&nbsp;&nbsp; </td>

                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </c:if>
    </f:form>
    <div style="text-align: center; padding-top: 10px">
        <c:if test="${opt == 'transact'}">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               iconCls="icon-save" onclick="submitForm('fid','dg','')">提交</a>
        </c:if>
        <a href="javascript:void(0)" class="easyui-linkbutton"
           iconCls="icon-cancel" onclick="javascript:history.go(-1)">返回</a>
    </div>
</div>

</body>

