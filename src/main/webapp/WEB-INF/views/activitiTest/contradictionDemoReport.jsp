<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
    <title>矛盾上报Demo</title>
    <%@include file="/common/meta.jsp" %>
    <%@include file="/common/script.jsp" %>

</head>
<body style="">
<div class="easyui-panel" border=false style="padding: 10px 150px;">
    <f:form id="fid" method="post" commandName="vo"
            data-options="novalidate:true" action="${ctx}/contradictionDemo/submit.do">
        <input type="hidden" name="id" value="${vo.id}"/>

        <div class="unit"><span style="text-align: center;width:650px;font-size: x-large"> 矛盾上报<span></div>
        <hr class="hr" style="width:650px;padding:2 "/>
        <div class="unit">
                   <span>
                       <label style="width:60px">上报人：</label>
                       <input class="easyui-textbox" type="text"
                              name="loginName" value="${vo.cdp}"
                              data-options=" width:'200px',editable:false"></input>
                    </span>&nbsp;&nbsp;&nbsp;&nbsp;
				   <span>
				      <label style="width:60px">职务：</label>
				      <input class="easyui-textbox" type="text"
                             name="post" value="${vo.post}"
                             data-options=" width:'200px'"></input>
                   </span>
        </div>
        <div class="unit">
            <label style="width:60px">摘要：</label>
            <input class="easyui-textbox" type="text"
                   name="summary" value="${vo.summary}"
                   data-options=" width:'560px',required:true"></input>
            </span>

        </div>
        <div class="unit">
            <label style="width:60px">描述：</label>
            <input class="easyui-textbox" type="text"
                   name="remark" value="${vo.remark}"
                   data-options="multiline:true" style="width:560px;height:80px"></input>
        </div>

        <c:if test="${opt == 'transact'}">

            <input type="hidden" name="act.taskId" value="${taskId}"/>
            <c:if test="${taskId != null }">
                <div id="hismsg" class="easyui-window" title="历史批注"
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

