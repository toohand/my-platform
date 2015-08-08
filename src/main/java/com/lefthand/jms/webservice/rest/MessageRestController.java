package com.lefthand.jms.webservice.rest;

import com.google.common.collect.Maps;
import com.lefthand.jms.domain.Message;
import com.lefthand.jms.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 消息restful控制器
 * Created by wangmz on 2015/7/14.
 */
@RestController
@RequestMapping(value = "/api/v1/message")
public class MessageRestController {

    private static Logger logger = LoggerFactory.getLogger(MessageRestController.class);
    
    private static final String COLLECTION_NAME = "message";//消息表名称

    @Autowired
    private MessageService messageService;

    /**
     * 创建消息
     * <p/>
     * url: {ctx}/api/v1/message/save
     * method: POST
     * body:
     * {
     * "title"      : "标题",
     * "content"    : "内容",
     * "messageType":
     * {
     * "id"  :1001,
     * "desc":'待办'
     * }
     * }
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message save(@RequestBody Message message){
        try {
            message.setId(com.lefthand.comm.utils.Identities.uuid2());
            message.setRead(true);
            message.setCreateTime(new Date());
            messageService.save(message, COLLECTION_NAME);
            return message;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 设置消息为已读状态
     * <p/>
     * url: {ctx}/api/v1/message/isRead/{id}
     * method: GET
     */
    @RequestMapping(value = "/isRead/{id}", method = RequestMethod.GET)
    public boolean isRead(@PathVariable("id") String id){
        try {
            messageService.isRead(id, COLLECTION_NAME);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据条件，分页获取附件
     * <p/>
     * url: {ctx}/api/v1/message/query
     * method: GET
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Message> query(@RequestParam(value = "rows", required = false) int pageSize,
                           @RequestParam(value = "page", required = false) int pageNumber,
                           HttpServletRequest request) {
        try {
            Map<String, Object> terms = Maps.newHashMap();
            terms.put("messageType", request.getParameter("messageType"));
            terms.put("isRead", request.getParameter("isRead"));
            terms.put("keyword", request.getParameter("keyword"));
            terms.put("startTime", request.getParameter("startTime"));
            terms.put("endTime", request.getParameter("endTime"));

            PageRequest pageRequest = new PageRequest(pageNumber-1, pageSize);
            Page<Message> page = messageService.query(pageRequest, terms, COLLECTION_NAME);
            return page;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据查询条件，获取相关消息
     * <p/>
     * url: {ctx}/api/v1/message/findAll
     * method: GET
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Message> findAll(HttpServletRequest request){
        try {
            Map<String, Object> terms = Maps.newHashMap();
            terms.put("messageType", request.getParameter("messageType"));
            terms.put("isRead", request.getParameter("isRead"));
            terms.put("keyword", request.getParameter("keyword"));
            terms.put("startTime", request.getParameter("startTime"));
            terms.put("endTime", request.getParameter("endTime"));

            return messageService.findAll(terms, COLLECTION_NAME);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据编号，删除消息
     * <p/>
     * url: {ctx}/api/v1/message/delete/{id}
     * method: GET
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") String id) {
        try {
            messageService.delete(id, COLLECTION_NAME);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }
}
