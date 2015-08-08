$(function () {

    if( !window.WebSocket) {
        $("body").html("\
        <h1>浏览器需要升级!</h1>\
        <p>\
        你的浏览器不支持 WebSockets. 客户端不能运行.<br>\
        请使用支持 WebSockets 的浏览器 (WebKit or Google Chrome).\
        </p>\
    ");
    } else {

        var client, destination;

        //连接按钮
        $('#connect-btn').click(function() {
            var host = 'hugeinfo123.xicp.net';
            var port = '61614';
            var clientId = 'clientId-'+(Math.floor(Math.random() * 100000));
            var user = 'admin';
            var password = 'password';

            destination = '通知';


            client = new Messaging.Client(host, Number(port), clientId);

            client.onConnect = onConnect;

            client.onMessageArrived = onMessageArrived;
            client.onConnectionLost = onConnectionLost;

            client.connect({
                userName:user,
                password:password,
                onSuccess:onConnect,
                onFailure:onFailure
            });
            return false;
        });

        // the client is notified when it is connected to the server.
        var onConnect = function(frame) {
            debug("连接服务成功...");
            client.subscribe(destination);
        };

        // this allows to display debug logs directly on the web page
        var debug = function(str) {
            $("#panel-message").append('<p style="font-size:14px">'+str+'</p>');
        };

        //断开按钮
        $('#disconnect-btn').click(function() {
            client.disconnect();
            debug("已经断开连接...");
            return false;
        });

        function onFailure(failure) {
            debug("连接服务失败...");
            debug(failure.errorMessage);
        }

        function onMessageArrived(message) {
            var message = eval('('+message.payloadString+')');
            debug(moment(message.createTime).format("YYYY-MM-DD HH:mm")+'  ['+message.title+']  '+message.content);
        }

        function onConnectionLost(responseObject) {
            if (responseObject.errorCode !== 0) {
                debug(client.clientId + ": " + responseObject.errorCode + "\n");
            }
        }

        //关闭或者刷新当前页面时关闭连接
        window.onbeforeunload = function(){
            client.disconnect();
        };
    }
});