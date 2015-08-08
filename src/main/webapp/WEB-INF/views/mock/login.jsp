<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file = "/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统模拟登录入口</title>

    <style type="text/css">
        div {
            margin: 10px;
        }
    </style>

    <script type="text/javascript">
        function postForm(loginName, postId) {
            form = document.getElementById('loginForm');
            form.loginName.value = loginName;
            form.postId.value = postId;
            form.submit();
        }
    </script>
</head>
<body>
    <h2>模拟用户登录入口</h2>
    <br/>

    <form id="loginForm" action="${ctx}/mock/login" method="post">
        <input type="hidden" name="loginName" />
        <input type="hidden" name="postId" />

        <p>
            <c:forEach items="${map}" var="unit">
                <h3>${unit.key}</h3>
                <hr>
                <c:forEach items="${unit.value}" var="post">
                    <div><a href="javascript:postForm('${post.account}', ${post.id});">${post.username} [${post.department}] [${post.name}]</a></div>
                </c:forEach>
            </c:forEach>
        </p>
    </form>

</body>
</html>