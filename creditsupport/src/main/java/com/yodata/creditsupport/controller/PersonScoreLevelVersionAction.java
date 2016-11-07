package com.yodata.creditsupport.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.creditsupport.orm.entity.ScoreLevelEntity;
import com.yodata.creditsupport.orm.entity.ScoreLevelVersionEntity;
import com.yodata.creditsupport.orm.entity.UserEntity;
import com.yodata.creditsupport.service.IScoreLevelService;
import com.yodata.creditsupport.service.IScoreLevelVersionService;
import com.yodata.creditsupport.util.QueryParam;

@Controller
@RequestMapping("/personScoreLevelVersion")
public class PersonScoreLevelVersionAction  extends BasicAction{

	private final Log log= LogFactory.getLog(PersonScoreLevelVersionAction.class);
	
	@Resource
	private IScoreLevelVersionService scoreLevelVersionService;
	
	@Resource
	private IScoreLevelService scoreLevelService;
	/**
     * 查询
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> query(@RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit){
        Map<String, Object> object = new HashMap<String, Object>();
        
        //查询分页条件
        String condition = request.getParameter("condition");
    	QueryParam queryParam = new QueryParam();
    	queryParam.setCondition(condition);
        queryParam.setOffset(offset==null?0:offset);
        queryParam.setLimit(limit==null?10:limit);
        try {
        	Map<String, Object> map = scoreLevelVersionService.getPageScoreLevelVersions(queryParam);
        	if(map != null && !map.isEmpty()){
        		Integer count = (Integer) map.get("count");
        		List<ScoreLevelVersionEntity> list = (List<ScoreLevelVersionEntity>) map.get("data");
        		object.put("code", 0);
        		object.put("total", count);
        		object.put("rows", list);
        	}
		} catch (Exception e) {
			e.printStackTrace();
			object.put("code", 0);
			object.put("message", "程序执行出错");
			log.error("程序执行出错", e);
		}
        return object;
    }
    
    
    /**
     * 查询
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value="/listVersion",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> query(){
        Map<String, Object> object = new HashMap<String, Object>();
        
        //查询分页条件 查询条件暂时不需要
//        String condition = request.getParameter("condition");
    	QueryParam queryParam = new QueryParam();
        try {
        	Map<String, Object> map = scoreLevelVersionService.getPageScoreLevelVersions(queryParam);
        	if(map != null && !map.isEmpty()){
        		Integer count = (Integer) map.get("count");
        		List<ScoreLevelVersionEntity> list = (List<ScoreLevelVersionEntity>) map.get("data");
        		object.put("code", 0);
        		object.put("total", count);
        		object.put("rows", list);
        	}
		} catch (Exception e) {
			e.printStackTrace();
			object.put("code", 0);
			object.put("message", "程序执行出错");
			log.error("程序执行出错", e);
		}
        return object;
    }
    
    
    
    /**
     * 保存评分等级信息
     * @param ScoreLevelEntity
     * @return
     */
    @RequestMapping(value="/add",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> addScoreLevelVersion(ScoreLevelVersionEntity scoreLevelVersionEntity){
    	Map<String, Object> obj = new HashMap<String, Object>();
        try {
            Integer id = scoreLevelVersionEntity.getId();

            ScoreLevelVersionEntity lastOne = scoreLevelVersionService.getlastVersion();
            List<ScoreLevelEntity> list = new ArrayList<ScoreLevelEntity>();
            // 如果id不为空,说明是通过其他模板拷贝过来的。
            if (id != null) {
                list = scoreLevelService.getScoreLevelEntityByVersionID(id);
            }
            // 拷贝过来的版本id不为null,但是新增的版本id为null，添加成功后由数据库自增
            scoreLevelVersionEntity.setId(null);
            scoreLevelVersionEntity.setStatus(0);
            scoreLevelVersionEntity.setCreate_time(new Date());
            scoreLevelVersionEntity
                    .setCreate_user(((UserEntity) request.getSession().getAttribute("sessionUser")).getUserName());
            // 每添加一个版本，版本号在最高版本基础上新增0.1
            BigDecimal b = new BigDecimal(Float.parseFloat(lastOne.getVersion()) + 0.1);
            float version = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            scoreLevelVersionEntity.setVersion(version + "");
            scoreLevelVersionService.copy(scoreLevelVersionEntity, list);
            obj.put("code", 0);
            obj.put("message", "保存成功");
            log.info("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            obj.put("code", 1);
            obj.put("message", "保存失败");
            log.error(e.getMessage(), e);
        }
        return obj;
    }
    
    
    /**
     * 保存评分等级信息
     * @param ScoreLevelEntity
     * @return
     */
    @RequestMapping(value="/update",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateScoreLevelVersion(ScoreLevelVersionEntity scoreLevelVersionEntity) {
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            int status = scoreLevelVersionEntity.getStatus();
            if (status == 1) {
                if (scoreLevelVersionService.getScoreLevelVersionEntityByStatus(1).size() != 0) {
                    obj.put("code", 1);
                    obj.put("message", "请先关闭已经启动的模板");
                    return obj;
                }
                // 启用模板的时候要判断scoreLevel里面的总分加起来是不是100，用的事区间相减，再求和，因为从0开始，所以和为101，如50-0+1,55-51+1,65-56+1,75-66+1,85-76+1,100-86+1,再相加和101比较
                int i = scoreLevelVersionService.getScoreSumByID(scoreLevelVersionEntity.getId());
                if (i != 101) {
                    obj.put("code", 1);
                    obj.put("message", "评分区间各评分之和不为100");
                    return obj;
                }
            }
            scoreLevelVersionEntity = scoreLevelVersionService
                    .getScoreLevelVersionEntityByID(scoreLevelVersionEntity.getId());
            scoreLevelVersionEntity.setStatus(status);
            scoreLevelVersionEntity.setCreate_time(new Date());
            scoreLevelVersionEntity
                    .setCreate_user(((UserEntity) request.getSession().getAttribute("sessionUser")).getUserName());
            scoreLevelVersionService.saveOrUpdateEntity(scoreLevelVersionEntity);
            obj.put("code", 0);
            obj.put("message", "操作成功");
            log.info(obj.get("message"));
        } catch (Exception e) {
            e.printStackTrace();
            obj.put("code", 1);
            obj.put("message", "操作失败");
            log.error(e.getMessage(), e);
        }
        return obj;
    }
    
    /**
     * 生成征信报告时判断是否有可用评分版本
     * @return
     */
    @RequestMapping(value="/hasAvailableVersion",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> hasAvailableVersion() {
    	boolean isOk = scoreLevelVersionService.hasAvailableVersion();
    	Map<String, String> rs = new HashMap<>();
    	rs.put("code", isOk ? "1" : "0");
    	return rs;
    }
}
