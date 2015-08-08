<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/common/meta.jsp" %>
</head>
<body>
<h2>MQTT客户端</h2>
<p>利用websocket，实现mqtt协议客户端接收消息。</p>
<div style="margin:20px 0 10px 0;">
    <a id="connect-btn" href="javascript:void(0);" class="easyui-linkbutton">连接</a>
    <a id="disconnect-btn" href="javascript:void(0);" class="easyui-linkbutton">断开</a>
</div>
<div id="panel-message" class="easyui-panel" title="消息面板" style="width:700px;height:200px;padding:10px;">

</div>
</body>
<%@include file="/common/script.jsp" %>
<script type="text/javascript" src="${ctx}/js/lib/mqttws31.js"></script>
<script type="text/javascript" src="${ctx}/js/message/client.js"></script>
</html>

