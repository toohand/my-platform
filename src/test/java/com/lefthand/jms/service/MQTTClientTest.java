package com.lefthand.jms.service;

import org.fusesource.hawtbuf.*;
import org.fusesource.mqtt.client.*;

import java.io.ObjectInputStream;

/**
 * MQTT客户端测试
 * Created by wangmz on 2015/7/13.
 */
public class MQTTClientTest {
    public static void main(String []args) throws Exception {

        String user = env("ACTIVEMQ_USER", "admin");
        String password = env("ACTIVEMQ_PASSWORD", "password");
        String host = env("ACTIVEMQ_HOST", "hugeinfo123.xicp.net");
        int port = Integer.parseInt(env("ACTIVEMQ_PORT", "1883"));
        final String destination = arg(args, 0, "通知");


        MQTT mqtt = new MQTT();
        mqtt.setHost(host, port);
        mqtt.setUserName(user);
        mqtt.setPassword(password);


        final CallbackConnection connection = mqtt.callbackConnection();
        //监听
        connection.listener(new org.fusesource.mqtt.client.Listener() {
            long count = 0;
            long start = System.currentTimeMillis();
            //监听成功
            public void onConnected() {
            }
            //监听失效
            public void onDisconnected() {
            }
            //监听失败
            public void onFailure(Throwable value) {
                value.printStackTrace();
                System.exit(-2);
            }
            //接收订阅话题发布的消息
            public void onPublish(UTF8Buffer topic, Buffer msg, Runnable ack) {
                /*Message message = null;
                try {
                    //对象流转换为实体
                    ObjectInputStream objectInputStream = new ObjectInputStream(msg.utf8().in());
                     message= (Message)objectInputStream.readObject();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String body = message==null?"message is null.":message.toString();*/
                String body = msg.utf8().toString();
                //如果消息内容包含 SHUTDOWN 则断开连接
                if( "SHUTDOWN".equals(body)) {
                    long diff = System.currentTimeMillis() - start;
                    System.out.println(String.format("Received %d in %.2f seconds", count, (1.0*diff/1000.0)));
                    //主动断开连接
                    connection.disconnect(new Callback<Void>() {
                        @Override
                        public void onSuccess(Void value) {
                            System.exit(0);
                        }
                        @Override
                        public void onFailure(Throwable value) {
                            value.printStackTrace();
                            System.exit(-2);
                        }
                    });
                } else {
                    System.out.println(String.format("Received messages:%s", body));
                }
                ack.run();
            }
        });
        //连接
        connection.connect(new Callback<Void>() {
            //连接成功回调
            @Override
            public void onSuccess(Void value) {
                Topic[] topics = {new Topic(destination, QoS.AT_LEAST_ONCE)};
                //订阅主题
                connection.subscribe(topics, new Callback<byte[]>() {
                    //订阅成功回调
                    public void onSuccess(byte[] qoses) {
                    }
                    //订阅失败回调
                    public void onFailure(Throwable value) {
                        value.printStackTrace();
                        System.exit(-2);
                    }
                });
            }
            //连接失败回调
            @Override
            public void onFailure(Throwable value) {
                value.printStackTrace();
                System.exit(-2);
            }
        });

        // Wait forever..
        synchronized (Listener.class) {
            while(true)
                Listener.class.wait();
        }
    }

    private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if( rc== null )
            return defaultValue;
        return rc;
    }

    private static String arg(String []args, int index, String defaultValue) {
        if( index < args.length )
            return args[index];
        else
            return defaultValue;
    }
}
