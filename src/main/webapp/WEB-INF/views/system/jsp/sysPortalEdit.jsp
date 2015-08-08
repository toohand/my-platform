<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
    <div class="easyui-panel" border=false style="padding: 10px 20px">
        <f:form id="fid" class="easyui-form"  method="post" commandName="vo"
            data-options="novalidate:true" action="${ctx}/sysPortal/save.do">
		 	    <input type="hidden" name="id" value="${vo.id}"/>
		 	   <div class="unit" >
		           <label style="width:60px">标题：</label>
		           <input class="easyui-textbox" type="text"
                    name="title" value="${vo.title}"
                    data-options=" width:'300px'"></input>
	           </div>

		 	   <div class="unit" >
		           <label style="width:60px">链接：</label>
		           <input class="easyui-textbox" type="text"
                    name="url" value="${vo.url}"
                    data-options=" width:'300px'"></input>
	           </div>
		 	   <div class="unit" >
		           <label style="width:60px">配置：</label>
		           <input class="easyui-textbox" type="text"
                    name="cfg" value="${vo.cfg}"
                    data-options="multiline:true" style="width:300px;height:100px"></input>
	           </div>
		 	   <div class="unit" >
		           <label style="width:60px">系统标示：</label>
		           <input class="easyui-textbox" type="text"
                    name="flag" value="${vo.flag}"
                    data-options=" width:'300px'"></input>
	           </div>
		 	   <div class="unit">
		           <label style="width:60px">是否启用：</label>
				   <div style="">
				   <f:radiobuttons path="state" items="${stateMap}" delimiter=""/>
				   </div>
	           </div>
			 <div class="unit" >
				<label style="width:60px">描述：</label>
				<input class="easyui-textbox" type="text"
					   name="remark" value="${vo.remark}"
					   data-options=" width:'300px'"></input>
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

