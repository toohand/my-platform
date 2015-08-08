package com.lefthand.log.webservice.rest;

import com.google.common.collect.Maps;
import com.lefthand.log.domain.entity.Log;
import com.lefthand.log.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

/**
 * 日志RESTful控制器
 * Created by wangmz on 2015/7/2.
 */
@RestController
@RequestMapping(value = "/api/v1/log")
public class LogRestController {

    private static Logger logger = LoggerFactory.getLogger(LogRestController.class);

    @Autowired
    private LogService logService;

    /**
     * 根据条件，分页获取附件
     * <p/>
     * url: {ctx}/api/v1/log/query
     * method: GET
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Log> query(@RequestParam(value = "rows") int pageSize,
                           @RequestParam(value = "page") int pageNumber,
                           @RequestParam(value = "collection") String collection,
                           HttpServletRequest request) {
        try {
            Map<String, Object> terms = Maps.newHashMap();
            terms.put("level", request.getParameter("level"));
            terms.put("message", request.getParameter("message"));

            PageRequest pageRequest = new PageRequest(pageNumber-1, pageSize);
            Page<Log> page = logService.query(pageRequest, terms, collection);
            return page;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 获取所有日志库
     * <p/>
     * url: {ctx}/api/v1/log/getCollectionNames
     * method: GET
     */
    @RequestMapping(value = "/getCollectionNames", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Set<String> getCollectionNames(){
        try {
            return logService.getCollectionNames();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 根据集合名，删除日志库
     * <p/>
     * url: {ctx}/api/v1/log/deleteLogHouse?collection=xxx
     * method: GET
     */
    @RequestMapping(value = "/deleteLogHouse", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteLogHouse(@RequestParam(value = "collection") String collection) {
        try {
            logService.dropCollection(collection);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }
}
