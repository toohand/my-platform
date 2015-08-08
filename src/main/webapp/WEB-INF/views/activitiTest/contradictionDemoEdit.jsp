<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
    <div class="easyui-panel" border=false style="padding: 10px 20px">
		<f:form id="fid" class="easyui-form" method="post" commandName="vo"
            data-options="novalidate:true" action="${ctx}/contradictionDemo/save.do">
		 	    <input type="hidden" name="id" value="${vo.id}"/>
		 	   <div class="unit" >
		           <label style="width:60px">上报人：</label>
		           <input class="easyui-textbox" type="text"
                    name="cdp" value="${vo.cdp}"
                    data-options=" width:'200px'"></input>
	           </div>
		 	   <div class="unit" >
		           <label style="width:60px">岗位：</label>
		           <input class="easyui-textbox" type="text"
                    name="post" value="${vo.post}"
                    data-options=" width:'200px'"></input>
	           </div>
		 	   <div class="unit" >
		           <label style="width:60px">摘要：</label>
		           <input class="easyui-textbox" type="text"
                    name="summary" value="${vo.summary}"
                    data-options=" width:'200px'"></input>
	           </div>
		 	   <div class="unit" >
		           <label style="width:60px">详细描述：</label>
		           <input class="easyui-textbox" type="text"
                    name="remark" value="${vo.remark}"
                    data-options=" width:'200px'"></input>
	           </div>
		 	   <div class="unit" >
		           <label style="width:60px">上报时间：</label>
		           <input class="easyui-textbox" type="text"
                    name="cdt" value="${vo.cdt}"
                    data-options=" width:'200px'"></input>
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

