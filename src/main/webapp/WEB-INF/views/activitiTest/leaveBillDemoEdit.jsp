<%@ page contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<body>
<div class="easyui-panel" border=false style="padding: 10px 20px">
    <f:form id="fid"  method="post" commandName="vo"
            data-options="novalidate:true" action="${ctx}/leaveBillDemo/save.do">
        <input type="hidden" name="id" value="${vo.id}"/>
        <input type="hidden" name="state" value="${vo.state}"/>
        <input type="hidden" name="userId" value="${vo.userId}"/>

        <div class="unit">
                   <span>
                       <label style="width:60px">申请人：</label>
                       <input class="easyui-textbox" type="text"
                              name="loginName" value="${vo.loginName}"
                              data-options=" width:'200px'"></input>
                    </span>&nbsp;&nbsp;&nbsp;&nbsp;
				   <span>
				      <label style="width:60px">职务：</label>
				      <input class="easyui-textbox" type="text"
                             name="postName" value="${vo.postName}"
                             data-options=" width:'200px'"></input>
                   </span>
        </div>
        <div class="unit">
            <span>
            <label style="width:60px">请假天数：</label>
            <input class="easyui-textbox" type="text"
                   name="day" value="${vo.day}"
                   data-options=" width:'200px',required:true"></input>
            </span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span>
            <label style="width:60px">假期类型：</label>
            <f:select path="leaveType" items="${leaveTypeMap}" class="easyui-combobox"/>
            </span>
        </div>

        <div class="unit">
            <span>
            <label style="width:60px">开始时间：</label>
            <input class="easyui-datetimebox"
                   name="startTime" value="<fmt:formatDate value='${vo.startTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"
                   data-options=" width:'200px',required:true"></input>
            </span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span>
            <label style="width:60px">结束时间：</label>
            <input class="easyui-datetimebox"  data-options="required:true,width:'200px'"
                   name="endTime" value="<fmt:formatDate value='${vo.endTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"></input>
            </span>
        </div>

        <div class="unit">
            <label style="width:60px">请假理由：</label>
            <input class="easyui-textbox" type="text"
                   name="content" value="${vo.content}"
                   data-options="multiline:true" style="width:560px;height:80px"></input>
        </div>
    </f:form>
    <div style="text-align: center; padding: 10px">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           iconCls="icon-save" onclick="submitForm('fid','dg','win')">提交</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            iconCls="icon-cancel" onclick="clearForm('win')">取消</a>
    </div>
</div>

</body>

