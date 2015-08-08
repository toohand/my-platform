package com.lefthand.system.controller;

import com.lefthand.base.comm.Constant;
import com.lefthand.base.comm.JSONUtil;
import com.lefthand.comm.utils.JsonMapper;
import com.lefthand.comm.web.Servlets;
import com.lefthand.system.domain.SysDictionary;
import com.lefthand.system.service.SysDictionaryService;
import net.sf.json.JSONObject;
import org.json.JSONArray;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

import com.lefthand.base.controller.BaseController;

/**
 * Title: 数据字典管理  SpringMVC控制类
 * Description: portal新增、删除、修改
 * Company: hugeinfo
 * author: codeBuilder
 * time:2015-07-06 11:39:00
 * version 1.0
 */
@Controller
@RequestMapping(value = "/sysDictionary")
public class SysDictionaryController extends BaseController {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(SysDictionaryController.class);
    @Autowired
    private SysDictionaryService fService;
    @Resource(name="dtyType")
    private Map dtyType ;
    private static JsonMapper jsonMapper = new JsonMapper();

    @RequestMapping(value = "/loadDtyType.do")
    @ResponseBody
    public String loadDtyType() {
        JSONArray jsons = new JSONArray();
        for (Iterator iterator = dtyType.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            JSONObject json = new JSONObject();
            json.put("id",entry.getKey());
            json.put("text", entry.getValue());
            if (jsons.length() == 0)
                json.put("selected",true);
            jsons.put(json);
        }
        return jsons.toString();
    }
    //加载浏览页面
    @RequestMapping(value = "/load.do")
    public String load(ModelMap model) {
        model.put("dtyType",dtyType);
        return "system/jsp/sysDictionary" ;
    }
    //加载新增或编辑页面
    @RequestMapping(value = "/show.do")
    public String show(Long id ,ModelMap model) {
        try{
           if ( id != null && id != 0){
               SysDictionary vo = fService.fetch(id);
               model.put("vo",vo);
            }
            return "system/jsp/sysDictionaryEdit" ;
        }catch(Exception e){
            log.error(e.getMessage(), e);
            model.put("ex",e);
            return "error/500.jsp";
        }
    }

    @RequestMapping(value = "/query.do")
    @ResponseBody
    public String query(int page, int rows, HttpServletRequest request) {
        SysDictionary vo = new SysDictionary();
        try {
            Map m = Servlets.getParametersStartingWith(request, "");
            Sort sort = new Sort(Sort.Direction.DESC,"sort_code");
            PageRequest p = new PageRequest(page-1, rows, sort);
            long total = fService.count(m);
            List<SysDictionary> list = fService.page(m, p);
            Map data = new HashMap();
            data.put("total",total);
            data.put("rows", list);
            return JSONUtil.map2JsonStr(data, null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "" ;
    }

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public String save(SysDictionary vo) {
        JSONObject json = new JSONObject();
        try {
            if (null == vo.getId() || 0 == vo.getId()) {
               // vo.setCdp(SecurityContextHolder.getHandler().getName());
                vo.setCdt(Calendar.getInstance().getTime());
                fService.insert(vo);
            } else {
                fService.update(vo);
            }
            json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            json.put(Constant.STATUS_MESSAGE, "保存成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "保存失败");
        }
        return json.toString();
    }

    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public String delete(Long id) {
        JSONObject json = new JSONObject();
        try {
            if ( id != 0) {
                fService.delete(id);
                json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
                json.put(Constant.STATUS_MESSAGE, "删除成功");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "删除成功");
        }
        return json.toString();
    }

    @RequestMapping(value = "/deleteBatch.do")
    @ResponseBody
    public String delete(String  ids) {
        JSONObject json = new JSONObject();
        try {
            if (!"".equals(ids) ) {
                String[] params = ids.split(",");
                fService.deleteBatch(params);
                json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
                json.put(Constant.STATUS_MESSAGE, "删除成功");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            json.put(Constant.STATUS_MESSAGE, "删除成功");
        }
        return json.toString();
    }

}
