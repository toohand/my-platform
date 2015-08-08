package com.lefthand.attachment.webservice.rest;

import com.google.common.collect.Maps;
import com.lefthand.attachment.AttachmentModule;
import com.lefthand.attachment.domain.entity.Attachment;
import com.lefthand.attachment.domain.entity.AttachmentAssociateType;
import com.lefthand.attachment.service.AttachmentService;
import com.lefthand.comm.exception.ApplicationException;
import com.lefthand.comm.utils.JsonMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 附件RESTful控制器
 */
@RestController
@RequestMapping(value = "/api/v1/attachment")
public class AttachmentRestController {

    private static Logger logger = LoggerFactory.getLogger(AttachmentRestController.class);

    @Autowired
    private AttachmentService service;

    /**
     * WEB端上传附件
     * <p/>
     * url: {ctx}/api/v1/attachment/upload
     * method: POST
     * Content-Type: multipart/form-data
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(MultipartHttpServletRequest request, HttpServletResponse response) {
        LinkedList<Attachment> files = new LinkedList<Attachment>();
        MultipartFile file = null;
        Attachment attachment = null;
        Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
            file = request.getFile(itr.next());
            attachment = service.create(file);
            files.add(attachment);
        }

        JsonMapper mapper = new JsonMapper();

        try {
            response.setContentType("text/plain;charset=utf-8");
            response.getWriter().write(mapper.toJson(files));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(AttachmentModule.ERR_CON_ATTACHMENT_UPLOAD, e);
        }

    }

    /**
     * 移动端上传附件
     * <p/>
     * url: {ctx}/api/v1/attachment/upload4mobile
     * method: POST
     * @param name       文件名称 比如：xxx.doc
     * @param base64str  base64编码的文件流字符串
     */
    @RequestMapping(value = "/upload4mobile", method = RequestMethod.POST)
    public void upload4mobile(@RequestParam String name, @RequestParam String base64str, HttpServletResponse response) {
        try {
            //判断是否base64字符串
            if(Base64.isBase64(base64str)){
                byte[] content = Base64.decodeBase64(base64str);
                MultipartFile file = new MockMultipartFile(name, name, null, content);
                Attachment attachment = service.create(file);

                JsonMapper mapper = new JsonMapper();

                response.setContentType("text/plain;charset=utf-8");
                response.getWriter().write(mapper.toJson(attachment));
            }else{
                response.setContentType("text/plain;charset=utf-8");
                response.getWriter().write("base64str is not encoded by base64.");
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(AttachmentModule.ERR_CON_ATTACHMENT_UPLOAD, e);
        }

    }

    /**
     * 下载附件
     * <p/>
     * url: {ctx}/api/v1/attachment/download/{attachmentId}?online=false
     * method: GET
     * @param online 是否在线打开，可选参数，默认值为false
     *               true：表示在线打开，false：表示下载
     */
    @RequestMapping(value = "/download/{attachmentId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void downLoad(@PathVariable("attachmentId") String attachmentId,
                         @RequestParam(value = "online", defaultValue = "false") boolean online,
                         HttpServletResponse response) {
        Attachment attachment = service.find(attachmentId);
        try {
            //判断是否在线打开
            if(!online){
                response.reset();
                response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition", "attachment;filename=" + new String((attachment.getName() + "." + attachment.getSuffix()).getBytes(), "iso-8859-1"));
                response.addHeader("Content-Length", "" + attachment.getSize());
            }
            OutputStream outputStream = response.getOutputStream();

            InputStream inputStream = service.read(attachment.getPath());//@TODO 获取文件流

            IOUtils.copy(inputStream, outputStream);
            //关闭流
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(AttachmentModule.ERR_CON_ATTACHMENT_DOWNUPLOAD, e);
        }
    }

    /**
     * 更新附件
     * <p/>
     * url: {ctx}/api/v1/attachment/update/{attachmentId}
     * method: POST
     * Content-Type: multipart/form-data
     */
    @RequestMapping(value = "/update/{attachmentId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("attachmentId") String attachmentId, MultipartHttpServletRequest request, HttpServletResponse response) {
        MultipartFile file = request.getFile("attachment");
        Attachment attachment = service.update(attachmentId, file);
        JsonMapper mapper = new JsonMapper();

        try {
            response.setContentType("text/plain;charset=utf-8");
            response.getWriter().write(mapper.toJson(attachment));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(AttachmentModule.ERR_CON_ATTACHMENT_UPLOAD, e);
        }
    }

    /**
     * 根据附件ID，删除附件
     * <p/>
     * url: {ctx}/api/v1/attachment/delete/{id}
     * method: GET
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

    /**
     * 根据业务ID，删除附件
     * <p/>
     * url: {ctx}/api/v1/attachment/deleteByOwner
     * method: GET
     */
    @RequestMapping(value = "/deleteByOwner", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void deleteByOwner(@RequestParam(value = "ownerId") String ownerId,
                              @RequestParam(value = "associateType") int associateType) {
        service.deleteByOwner(ownerId, AttachmentAssociateType.fromTypeId(associateType));
    }

    /**
     * 根据附件ID，获取单个附件
     * <p/>
     * url: {ctx}/api/v1/attachment/find/{id}
     * method: GET
     */
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Attachment find(@PathVariable("id") String id) {
        return service.find(id);
    }

    /**
     * 根据业务ID，获取多个附件
     * <p/>
     * url: {ctx}/api/v1/attachment/findByOwner
     * method: GET
     * @param ownerId 业务ID
     * @param associateType 附件关系类型，参考 AttachmentAssociateType
     */
    @RequestMapping(value = "/findByOwner", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Attachment> finds(@RequestParam(value = "ownerId") String ownerId,
                                  @RequestParam(value = "associateType") int associateType) {
        return service.findByOwnerAndAssociateTypes(ownerId, AttachmentAssociateType.fromTypeId(associateType));
    }

    /**
     * 根据条件，分页获取附件
     * <p/>
     * url: {ctx}/api/v1/attachment/query
     * method: GET
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Attachment> query(@RequestParam(value = "rows") int pageSize,
                            @RequestParam(value = "page") int pageNumber,
                            HttpServletRequest request) {
        try {
            Map<String, Object> terms = Maps.newHashMap();
            terms.put("associate_type", request.getParameter("associateType"));//关系类型
            terms.put("owner_id", request.getParameter("ownerId"));            //业务实体ID
            terms.put("keyword", request.getParameter("keyword"));             //关键字，目前只支持附件名称属性

            PageRequest pageRequest = new PageRequest(pageNumber-1, pageSize);
            Page<Attachment> page = service.query(pageRequest, terms);
            return page;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

}
