package com.lefthand.system.controller;

import com.lefthand.base.comm.Constant;
import com.lefthand.base.comm.JSONUtil;
import com.lefthand.system.domain.SysJob;
import com.lefthand.system.service.SysJobServiceable;
import com.lefthand.comm.web.Servlets;
import net.sf.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统定时任务控制层
 */
@Controller
@RequestMapping(value = "/sysJob")
public class SysJobController {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(SysJobController.class);
    @Autowired
    private SysJobServiceable sysJobService;

    //加载浏览页面
    @RequestMapping(value = "/load.do")
    public String load(ModelMap model) {
        return "/system/jsp/SysJob" ;
    }
    //加载新增或编辑页面
    @RequestMapping(value = "/show.do")
    public String show(Long id ,ModelMap model) {
        if ( id != null && id != 0){
            SysJob vo = sysJobService.fetch(id);
            model.put("vo",vo);
        }
        return "/system/jsp/SysJobEdit" ;
    }

    @RequestMapping(value = "/query.do")
    @ResponseBody
    public String query(int page, int rows, HttpServletRequest request) {
        SysJob job = new SysJob();
        List<SysJob> list = null;
        try {
            Map m = Servlets.getParametersStartingWith(request, "w.");
            PageRequest p = new PageRequest(page-1, rows, null);
            long total = sysJobService.count(m);
            list = sysJobService.page(m, p);
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
    public String save(SysJob vo) {
        JSONObject json = new JSONObject();
        try {
            if (vo.getId() == null ||  0 == vo.getId()) {
                vo.setJobState(0);
                vo.setCreateDate(Calendar.getInstance().getTime());
                sysJobService.insert(vo);
            } else {
                sysJobService.update(vo);
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
            if (id != null &&  id != 0) {
                sysJobService.delete(id);
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
                sysJobService.deleteBatch(params);
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
