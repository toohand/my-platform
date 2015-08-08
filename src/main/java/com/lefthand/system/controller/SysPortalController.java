package com.lefthand.system.controller;

import com.lefthand.base.comm.Constant;
import com.lefthand.base.comm.JSONUtil;
import com.lefthand.comm.web.Servlets;
import com.lefthand.system.service.SysPortalService;
import net.sf.json.JSONObject;
import org.json.JSONArray;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lefthand.base.controller.BaseController;
import com.lefthand.system.domain.SysPortal;

/**
 * Title: portal管理  SpringMVC控制类
 * Description: portal新增、删除、修改
 * Company: hugeinfo
 * author: codeBuilder
 * time:2015-06-24 15:13:45
 * version 1.0
 */
@Controller
@RequestMapping(value = "/sysPortal")
public class SysPortalController extends BaseController {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(SysPortalController.class);
    @Autowired
    private SysPortalService fService;
    @Resource(name="enabledMap")
    private Map enabledMap;

    @RequestMapping(value = "/indexPortal.do")
    public String initPortal(ModelMap model) {
        try {
            Map  wmap = new HashMap();
            wmap.put("state",1);
            List<SysPortal> list = fService.list(wmap, null);
            if (list.size() > 0) {
                JSONArray js = new JSONArray();
                for(int i=0;i<list.size();i++){
                    SysPortal p = list.get(i);
                    JSONObject obj = null ;
                    if (p.getCfg() != null && !p.getCfg().isEmpty()){
                        obj = JSONObject.fromObject(p.getCfg());
                    } else
                        obj = JSONObject.fromObject("{}");
                    obj.put("id", "p"+p.getId());
                    obj.put("title", p.getTitle());
                    obj.put("href", p.getUrl());
                    js.put(obj);
                }
                model.put("potals", js.toString());
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "system/jsp/indexPortal" ;
    }
    //加载浏览页面
    @RequestMapping(value = "/load.do")
    public String load(ModelMap model) {
        model.put("stateMap", JSONUtil.map2JsonStr(enabledMap, ""));
        return "system/jsp/sysPortal" ;
    }
    //加载新增或编辑页面
    @RequestMapping(value = "/show.do")
    public String show(Long id ,ModelMap model) {
        model.put("stateMap", enabledMap);
        if ( id != null && id != 0){
            SysPortal vo = fService.fetch(id);
            model.put("vo", vo);
        } else{
            SysPortal vo = new SysPortal();
            vo.setState(1);
            model.put("vo", vo);
        }
        return "system/jsp/sysPortalEdit" ;
    }

    @RequestMapping(value = "/query.do")
    @ResponseBody
    public String query(int page, int rows, HttpServletRequest request) {
        SysPortal vo = new SysPortal();
        try {
            Map m = Servlets.getParametersStartingWith(request, "w.");
            PageRequest p = new PageRequest(page-1, rows, null);
            long total = fService.count(m);
            List<SysPortal> list = fService.page(m, p);
            Map data = new HashMap();
            data.put("total",total);
            data.put("rows", list);
            return JSONUtil.map2JsonStr(data,null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "" ;
    }

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public String save(SysPortal vo) {
        JSONObject json = new JSONObject();
        try {
            if (null == vo.getId() || 0 == vo.getId()) {
                vo.setCdt(Calendar.getInstance().getTime());
                fService.insert(vo);
            } else {
                fService.update(vo);
            }
            json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
            json.put(Constant.STATUS_MESSAGE, "保存成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
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
