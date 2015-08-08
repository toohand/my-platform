<%--
  Created by IntelliJ IDEA.
  User: PanjinF
  Date: 2015/6/19
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/script.jsp"%>
    <title></title>
</head>
<body>
<div class="easyui-panel" border=false style="padding: 10px 20px">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th width="20%">ID</th>
            <th width="20%">候选人</th>
            <th width="20%">任务ID</th>
            <th width="20%">类型</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${link!=null || fn:length(link)!=0}">
            <c:forEach var="link" items="${link}">
                <tr>
                    <td style="text-align: center">${link.id}</td>
                    <td style="text-align: center">${link.userId}</td>
                    <td style="text-align: center">${link.taskId}</td>
                    <td style="text-align: center">${link.type}</td>
                    <%--<td style="text-align: center">${link.processInstanceId}</td>--%>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
</body>
</html>
