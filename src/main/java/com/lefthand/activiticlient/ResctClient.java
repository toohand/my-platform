package com.lefthand.activiticlient;

import com.lefthand.base.comm.Constant;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Title: 工作流rest接口
 * Description: 业务调用工作流reset接口
 * Company: hugeinfo
 * author: hp
 * time:2015-07-15 16:29:44
 * version 1.0
 */
@Component
public class ResctClient {
    private static org.slf4j.Logger log = LoggerFactory.getLogger(ResctClient.class);
    @Autowired(required=false)
    private RestTemplate restTemplate ;

    @Value("${activiti.rest.url}")
    private String url;

    /**
     * 根据任务Id获取业务key
     * @param taskId  任务ID
     * @return
     */
    public String getBussKey(String taskId) {
        try {
            return restTemplate.getForObject(url + "/api/activitiBusiness/getBussKey/{taskId}", String.class, taskId);
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            return "";
        }
    }

    /**
     * 根据taskId获取业务任务对外链接参数
     * @param taskId 任务ID
     * @return
     */
    public JSONArray findOutComeList(String taskId) {
        try {
            JSONArray array= restTemplate.getForObject(url + "/api/activitiBusiness/findOutComeList/{taskId}", JSONArray.class, taskId);
            return array;
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            return null;
        }
    }

    /**
     * 根据taskId获取业务任务对外链接参数
     * @param taskId  任务id
     * @param spix    变量前缀  一般设置值用s.开始，字段控制f.开始
     * @return
     */
    public JSONArray findFormProperties(String taskId,String spix) {
        try {
            JSONArray array= restTemplate.getForObject(url + "/api/activitiBusiness/findFormProperties/{taskId}/{spix}", JSONArray.class, taskId,spix);
            return array;
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            return null;
        }
    }

    /** 启动流程
     * @param bmpName 流程标示
     * @param bussKey 业务key
     * @param vars    流程变量
     * @return {}
     */
    public JSONObject startProcess(String bmpName,String bussKey, Map vars) {
        JSONObject result  = null;
        try {
            result= restTemplate.postForObject(url + "/api/activitiBusiness/startProcess/{bmpName}/{bussKey}", vars, JSONObject.class,bmpName,bussKey);

        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result = new JSONObject();
            result.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            result.put(Constant.STATUS_MESSAGE, "流程启动错误，错误信息：" + ex.getMessage());
        }
        return result;
    }

    /**
     * 完成任务
     * @param taskId     任务Id
     * @param comment    意见
     * @param userId     处理任务人员
     * @param outcome    默认流程节点名
     * @param vars       传变量值
     * @return  {}
     */
    public JSONObject completeTask(String taskId,String comment,String userId,String outcome,Map vars) {
        JSONObject result =null;
        try {
            vars.put("comment",comment);
            vars.put("outcome",outcome);
            vars.put("userId",userId);
            result= restTemplate.postForObject(url + "/api/activitiBusiness/completeTask/{taskId}",vars, JSONObject.class,taskId);
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result = new JSONObject();
            result.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
            result.put(Constant.STATUS_MESSAGE, "任务办理错误，错误信息："+ex.getMessage());
        }
        return result;
    }

}
