package com.lefthand.log.listener;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.LoggingEventVO;
import com.lefthand.log.domain.entity.Log;
import com.lefthand.log.service.LogService;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * 日志监听器
 * Created by wangmz on 2015/7/1.
 */
@Component
public class LogMessageListener implements MessageListener {

    private static Logger logger = LoggerFactory.getLogger(LogMessageListener.class);

    @Autowired
    private LogService logService;

    /**
     * 消息监听和处理
     * @param message 消息
     */
    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage om = (ObjectMessage) message;
            LoggingEventVO vo = (LoggingEventVO)om.getObject();
            ActiveMQQueue queue = (ActiveMQQueue)om.getJMSDestination();
            logService.save(this.getLog(vo), queue.getPhysicalName());
//            logger.debug("读取队列：",queue.getPhysicalName());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取日志
     * @param vo 日志事件
     * @return 日志
     */
    private Log getLog(LoggingEventVO vo){
        Log log = new Log();
        log.setId(com.lefthand.comm.utils.Identities.uuid2());
        log.setLogger(vo.getLoggerName());
        PatternLayout patternLayout = new PatternLayout();
        log.setDetail(patternLayout.doLayout(vo));
        log.setMessage(vo.getMessage());
        log.setLevel(vo.getLevel().toString());
        log.setCreateTime(new Date(vo.getTimeStamp()));
        try {
            log.setIp(InetAddress.getLocalHost().getHostAddress());
            log.setHost(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return log;
    }

}
