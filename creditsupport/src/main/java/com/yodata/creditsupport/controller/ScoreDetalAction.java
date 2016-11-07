package com.yodata.creditsupport.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.yodata.creditsupport.orm.vo.GrossProfit;
import com.yodata.creditsupport.service.IScoreDetalService;

/**
 * 评分报告 图表详情
 *
 */
@Controller
@RequestMapping("/ticketDetal")
public class ScoreDetalAction extends BasicAction  {

	private final Log log= LogFactory.getLog(ScoreDetalAction.class);
	
	@Resource
	private IScoreDetalService scoreDetalService;
	
    /**
     * 查询注册资金信息
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value="/queryCapitalGrowth",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> queryIndiScoreWeight(@RequestParam(required=true) String regId){
	    Map<String, Object> obj = new HashMap<String, Object>();
	    try {
	        //查询注册资金值及增长率
            List<GrossProfit> list = scoreDetalService.getCapitalGrowthList(regId);
            if(list != null && !list.isEmpty()){
                //创建两个数组供前台页面展示
                //注册资金
                List<Map<String, Object>> capitals = new ArrayList<>();
                //注册资金增长率
                List<Map<String, Object>> growths = new ArrayList<>();
                Map<String, Object> capObj = null;
                Map<String, Object> growObj = null;
                GrossProfit cg = null;
                GrossProfit bf = null;
                double amount = 0.0d;
                //数据库查询最近6个月的记录，按时间倒叙排列，为方便前台显示，将顺序反转过来
                for(int i = list.size() - 1; i >= 0; i--){
                    cg = list.get(i);
                    //注册资金
                    capObj = new HashMap<String, Object>();
                    capObj.put("name", cg.getYear() + "年");
                    capObj.put("y", (double)cg.getAmount());
                    capitals.add(capObj);
                    //增长率
                    growObj = new HashMap<String, Object>();
                    growObj.put("name", cg.getYear() + "年");
                    if(bf == null) {
                    	growObj.put("y", 0);
                    } else {
                    	amount = bf.getAmount();
                    	if(amount == 0.0d) {
                    		growObj.put("y", cg.getAmount() == 0.0d ? 0 : 1);
                    	} else {
                    		growObj.put("y", 1.0d - amount/cg.getAmount());
                    	}
                    }
                    bf = cg;	// 保留去年信息
                    growths.add(growObj);
                }
                obj.put("code", 1);
                obj.put("capital", capitals);
                obj.put("growth", growths);
            } else {
                obj.put("code", 0);
                obj.put("message", "注册资金信息不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("IndicatorScoreAction 执行出错");
            obj.put("code", 0);
            obj.put("message", "程序内部错误，请联系管理员");
        }
	    
	    return obj;
	
	}
	
	// 毛利额-增长率
	@RequestMapping(value="/grossProfit",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String, Object> getGrossProfit(@RequestParam String id) {
		Map<String, Object> obj = new HashMap<String, Object>();
	    try {
	        //查询毛利额及增长率
	    	List<GrossProfit> list = scoreDetalService.getGrossProfit(id);
	    	if(list != null && !list.isEmpty()){
                List<Map<String, Object>> mOutList = new ArrayList<>();
    			List<Map<String, Object>> mGrowthList = new ArrayList<>();
    	    	Map<String, Object> mOut, mGrowth;
    			GrossProfit gp = null;
    			String date;
    	    	for(int i = 0, len = list.size(); i < len; i++){
    	    		mOut = new HashMap<>();
    	    		mGrowth = new HashMap<>();
    	    		gp = list.get(i);	
    	    		date = gp.getYear() + "年";
    	    		// 毛利额
    	    		mOut.put("name", date);
    	    		mOut.put("y", new BigDecimal(gp.getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP));
    	    		mOutList.add(mOut);
    	    		// 毛利额-增长率
    	    		mGrowth.put("name", date);
    	    		mGrowth.put("y", gp.getGrowth());
    	    		mGrowthList.add(mGrowth);
    	    	}
                obj.put("code", 1);
                obj.put("capital", mOutList);
                obj.put("growth", mGrowthList);
            } else {
                obj.put("code", 0);
                obj.put("message", "毛利额信息不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("IndexScoreAction 执行出错");
            obj.put("code", 0);
            obj.put("message", "程序内部错误，请联系管理员");
        }
		return obj;
	}
	
	@RequestMapping(value="ticketGrowth",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String, Object> getGrowth(@RequestParam String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, List<GrossProfit>> rs = scoreDetalService.getTicketGrowth(id);
			// 月订单出票数
			List<GrossProfit> mList = rs.get("mOrderNum");
			// 日订单出票数
			List<GrossProfit> dList = rs.get("dOrderNum");
			List<Map<String, Object>> mOutList = new ArrayList<>();
			List<Map<String, Object>> mGrowthList = new ArrayList<>();
	    	Map<String, Object> mOut, mGrowth;
			GrossProfit gp = null;
	    	for(int i = 0; i < 6; i++){
	    		mOut = new HashMap<>();
	    		mGrowth = new HashMap<>();
	    		
	    		gp = mList.get(i);	// 月订单出票数
	    		mOut.put("name", gp.getDateStr());
	    		mOut.put("y", gp.getAmount());
	    		mOut.put("drilldown", "dOut" + i);
	    		mOutList.add(mOut);
	    		// 月订单出票数增长率
	    		mGrowth.put("name", gp.getDateStr());
	    		mGrowth.put("y", gp.getGrowth());
//	    		mGrowth.put("drilldown", "mGrowth" + i);
	    		mGrowthList.add(mGrowth);
	    	}
	    	Map<String, List<Object[]>> dMap = new HashMap<>();
	    	List<Object[]> dOutList = new ArrayList<>();
	    	Object[] dOut;
	    	gp = null;
	    	int monthCount = 0;	// 月计数
	    	int curMonth = dList.get(0).getMonth();
	    	String year = dList.get(0).getYear() + "年";
	    	for(int i = 0, length = dList.size(); i < length; i++){
	    		dOut = new Object[2];
	    		gp = dList.get(i);	// 日订单出票数
	    		if(curMonth != gp.getMonth()) {
	    			curMonth = gp.getMonth();
	    			// 把上个月的信息存起来
	    			dMap.put("dOut" + monthCount, dOutList);
	    			dOutList = new ArrayList<>();
	    	    	++monthCount;
	    	    	dOut[0] = gp.getYear() + "年" + gp.getMonth() + "月" + gp.getDay() + "日";
	    		} else {
	    			dOut[0] = year + gp.getMonth() + "月" + gp.getDay() + "日";
	    			year = "";
	    		}
	    		dOut[1] = gp.getAmount();
	    		dOutList.add(dOut);
	    		
	    		if(i == length-1) {
	    			dMap.put("dOut" + monthCount, dOutList);
	    			break;
	    		}
	    	}
	    	result.put("code", 1);
	    	result.put("mOutList", mOutList);
	    	result.put("mGrowthList", mGrowthList);
	    	result.put("dMap", dMap);
		} catch (Exception e) {
			e.printStackTrace();
            log.error("IndexScoreAction 执行出错");
            result.put("code", 0);
            result.put("message", "程序内部错误，请联系管理员");
		}
		return result;
	}
	
	@RequestMapping(value="/retirement",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public Map<String, Object> getRetirement(@RequestParam String id, @RequestParam(required=false) Integer index) {
		Map<String, Object> obj = new HashMap<String, Object>();
	    try {
	    	Map<String, List<GrossProfit>> rs = scoreDetalService.getRetirementTicket(id);
	    	// 月退废票数
			List<GrossProfit> mList1 = rs.get("mBackNum");
			// 月订单出票数
			List<GrossProfit> mList2 = rs.get("mOrderNum");
			// 日退废票数
			List<GrossProfit> dList1 = rs.get("dBackNum");
			// 日订单出票数
			List<GrossProfit> dList2 = rs.get("dOrderNum");
	    	List<Map<String, Object>> mOutList = new ArrayList<>();
	    	List<Map<String, Object>> mBackList = new ArrayList<>();
	    	List<Map<String, Object>> mPercentList = new ArrayList<>();
	    	Map<String, Object> mOut, mBack, mPercent;
	    	
	    	GrossProfit gp = null;
	    	for(int i = 0; i < 6; i++){
	    		mOut = new HashMap<>();
	    		mBack = new HashMap<>();
	    		mPercent = new HashMap<>();
	    		
	    		gp = mList1.get(i);	// 月退废票数
	    		mBack.put("name", gp.getDateStr());
	    		mBack.put("y", gp.getAmount());
	    		mBack.put("drilldown", "dBack" + i);
	    		mBackList.add(mBack);
	    		
	    		gp = mList2.get(i);	// 月订单出票数
	    		mOut.put("name", gp.getDateStr());
	    		mOut.put("y", gp.getAmount());
	    		mOut.put("drilldown", "dOut" + i);
	    		mOutList.add(mOut);
	    		
	    		mPercent.put("name", gp.getDateStr());
	    		mPercent.put("y", gp.getGrowth());
//	    		mPercent.put("drilldown", "mPercent" + i);
	    		mPercentList.add(mPercent);
	    	}
	    	Map<String, List<Object[]>> dMap = new HashMap<>();
	    	List<Object[]> dOutList = new ArrayList<>();
	    	List<Object[]> dBackList = new ArrayList<>();
	    	Object[] dOut, dBack;
	    	gp = null;
	    	int monthCount = 0;	// 月计数
	    	int curMonth = dList1.get(0).getMonth();
	    	String year = dList1.get(0).getYear() + "年";
	    	for(int i = 0, length = dList1.size(); i < length; i++){
	    		dOut = new Object[2];
	    		dBack = new Object[2];
	    		gp = dList1.get(i);	// 日退废票数
	    		if(curMonth != gp.getMonth()) {
	    			curMonth = gp.getMonth();
	    			// 把上个月的信息存起来
	    			dMap.put("dOut" + monthCount, dOutList);
	    			dMap.put("dBack" + monthCount, dBackList);
	    			dOutList = new ArrayList<>();
	    	    	dBackList = new ArrayList<>();
	    	    	++monthCount;
	    	    	dBack[0] = gp.getYear() + "年" + gp.getMonth() + "月" + gp.getDay() + "日";
	    	    	dBack[1] = gp.getAmount();
	    	    	dBackList.add(dBack);
	    	    	
	    	    	gp = dList2.get(i);	// 日订单出票数
	    	    	dOut[0] = gp.getYear() + "年" + gp.getMonth() + "月" + gp.getDay() + "日";
	    	    	dOut[1] = gp.getAmount();
	    	    	dOutList.add(dOut);
	    		} else {
	    	    	dBack[0] = year + gp.getMonth() + "月" + gp.getDay() + "日";
	    	    	dBack[1] = gp.getAmount();
	    	    	dBackList.add(dBack);
	    	    	gp = dList2.get(i);	// 日订单出票数
	    	    	dOut[0] = year + gp.getMonth() + "月" + gp.getDay() + "日";
	    	    	dOut[1] = gp.getAmount();
	    	    	dOutList.add(dOut);
	    	    	year = "";
	    		}
	    		if(i == length-1) {
	    			dMap.put("dOut" + monthCount, dOutList);
	    			dMap.put("dBack" + monthCount, dBackList);
	    			break;
	    		}
	    	}
	    	obj.put("code", 1);
	    	obj.put("mOutList", mOutList);
	    	obj.put("mBackList", mBackList);
	    	obj.put("mPercentList", mPercentList);
	    	obj.put("dMap", dMap);
        } catch (Exception e){
            e.printStackTrace();
            log.error("IndexScoreAction 执行出错");
            obj.put("code", 0);
            obj.put("message", "程序内部错误，请联系管理员");
        }
		return obj;
	}
}
