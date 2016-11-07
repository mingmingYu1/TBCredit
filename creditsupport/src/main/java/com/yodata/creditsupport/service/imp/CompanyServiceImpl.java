package com.yodata.creditsupport.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.yodata.core.domain.Page;
import com.yodata.creditsupport.dao.AgentAlgorDao;
import com.yodata.creditsupport.dao.AgentGroupDao;
import com.yodata.creditsupport.dao.AgentInfosDao;
import com.yodata.creditsupport.dao.CompanyDao;
import com.yodata.creditsupport.dao.InfoGroupDao;
import com.yodata.creditsupport.dao.crawler.CreditLabelDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.CrawlerAgentGroupEntity;
import com.yodata.creditsupport.orm.entity.AgentAlgorEntity;
import com.yodata.creditsupport.orm.entity.AgentInfoEntity;
import com.yodata.creditsupport.orm.entity.CrawlerAgentInfoEntity;
import com.yodata.creditsupport.orm.entity.EntAttrInfoEntity;
import com.yodata.creditsupport.orm.entity.CrawlerAgetngroupAgentinfoEntity;
import com.yodata.creditsupport.orm.entity.LegPerInfoEntity;
import com.yodata.creditsupport.orm.entity.OthEntInvestsInfoEntity;
import com.yodata.creditsupport.orm.entity.SpecialInfoEntity;
import com.yodata.creditsupport.orm.entity.StockholderInfoEntity;
import com.yodata.creditsupport.orm.entity.TopManagerInfoEntity;
import com.yodata.creditsupport.orm.vo.AgentGroup;
import com.yodata.creditsupport.service.ICompanyService;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.HttpClientUtil;
import com.yodata.creditsupport.util.QueryParam;

import cn.com.yodata.creditdataweb.webservice.ICreditDataWSLocator;
import cn.com.yodata.creditdataweb.webservice.ICreditDataWSPortType;


@Service
@Transactional
public class CompanyServiceImpl implements ICompanyService {

    private final Log log= LogFactory.getLog(CompanyServiceImpl.class);
    
    @Resource
    private CompanyDao companyDao;
    @Resource
    private AgentInfosDao agentInfosDao;
//    @Resource
//    private NewsListDao newsListDao;
    @Resource
    private AgentGroupDao agentGroupDao;
    @Resource
    private InfoGroupDao infoGroupDao;
    @Resource
    private CreditLabelDao clDao;
    @Resource
    private AgentAlgorDao agentAlgorDao;    //企业算法DAO
    @Autowired
    private ConstantBean constant;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Map<String, Object> getPageCompanys(QueryParam queryParam) {
        try {
            return companyDao.getPageCompanys(queryParam);
        } catch (DataAccessException e) {
            log.error(e.getMessage());
            return null;
        }
    }
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public AgentInfoEntity getByRegId(String regId) throws BusinessException {
		try {
			return companyDao.getCompanyById(regId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            throw new BusinessException("查询企业失败");
		}
    }

//    @Override
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public AgentInfoEntity getByRegId(String regId) {
//        List<AgentInfoEntity> list = companyDao.findBy("regId", regId);
//        return list != null && list.size() > 0 ? list.get(0) : null;
//    }

    @Override
    public String create(AgentInfoEntity agentInfo) {
        companyDao.saveReturnPk(agentInfo);
        // 外键并未自动保存
        List<EntAttrInfoEntity> entAttrInfos = agentInfo.getEntAttrInfos();
        for (EntAttrInfoEntity temp : entAttrInfos) {
            temp.setRegId(agentInfo.getRegId());
        }
        // 地址信息
        List<StockholderInfoEntity> stockholderInfos = agentInfo.getStockholderInfos();
        for (StockholderInfoEntity temp : stockholderInfos) {
            temp.setRegId(agentInfo.getRegId());
        }
        // 高管信息
        List<TopManagerInfoEntity> topManagerInfos = agentInfo.getTopManagerInfos();
        for (TopManagerInfoEntity temp : topManagerInfos) {
            temp.setRegId(agentInfo.getRegId());
        }
        // 对外股权投资信息
        List<OthEntInvestsInfoEntity> othEntInvestsInfos = agentInfo.getOthEntInvestsInfos();
        for (OthEntInvestsInfoEntity temp : othEntInvestsInfos) {
            temp.setRegId(agentInfo.getRegId());
        }
        // 法定代表人在其他机构任职信息
        List<LegPerInfoEntity> legPerInfos1 = agentInfo.getLegPerInfos1();
        for (LegPerInfoEntity temp : legPerInfos1) {
            temp.setRegId(agentInfo.getRegId());
        }
        // 法定代表人股权投资信息
        List<LegPerInfoEntity> legPerInfos2 = agentInfo.getLegPerInfos2();
        for (LegPerInfoEntity temp : legPerInfos2) {
            temp.setRegId(agentInfo.getRegId());
        }
        // 法院被执行信息
        List<SpecialInfoEntity> specialInfos = agentInfo.getSpecialInfos();
        for (SpecialInfoEntity temp : specialInfos) {
            temp.setRegId(agentInfo.getRegId());
        }
        companyDao.update(agentInfo);// 保存外键
        return agentInfo.getRegId();
    }

    @Override
    public boolean delete(String regId) throws BusinessException {
        if(StringUtils.isEmpty(regId)){
            throw new BusinessException("删除企业时，企业的Id不能为空");
        }
        //先加载后级联删除企业信息
        AgentInfoEntity agentInfo = getByRegId(regId);
        if (agentInfo != null) {
            companyDao.delete(agentInfo);
        }
        //删除企业的默认算法
        AgentAlgorEntity agentAlgorEntity = agentAlgorDao.getEntityByRegId(regId);
        if(agentAlgorEntity != null && StringUtils.isNotEmpty(agentAlgorEntity.getRegId())){
            agentAlgorDao.delete(agentAlgorEntity);
        }
        //删除企业的信用得分
        try {
            companyDao.deleteCompScoreByRegId(regId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new BusinessException("删除企业时出现异常");
        }
        return true;
    }

    @Override
    public boolean update(AgentInfoEntity agentInfo) {
        companyDao.update(agentInfo);// 保存全部信息
        return true;
    }

    @Override
    public int addAgent(CrawlerAgentInfoEntity agentInfo) throws BusinessException {
        int result = 0;
        agentInfosDao.saveReturnPk(agentInfo);
        if (agentInfo.getInfoId() > 0) {
            //调用接口，获取企业信息
            int updateResult = processNewsList(agentInfo);
            //判断接口调用状态，并查出新增或更新的企业
            List<AgentInfoEntity> compList = null;
            if (updateResult == 1) {
                // 查询新增的企业列表，并判断是否新增成功
                compList = companyDao.findBy("compName", agentInfo.getInfoName());
                if (compList == null || compList.isEmpty()) {
                    log.info("新增或更新企业失败，您输入的企业名称不正确或不完整，请输入完整的企业名称");
                    result = -9;
                    return result;
                }
            } else {
                log.info("新增或更新企业失败，您输入的企业名称不正确或不完整，请输入完整的企业名称");
                result = -9;
                return result;
            }
            log.info("新增或更新企业成功");
            // 重新计算企业信用得分
            for (AgentInfoEntity agent : compList) {
                // 重新以专家法进行计分，调用存储过程
                try {
                    companyDao.getScoreingByRegId(agent.getRegId(), agent.getCompName());
                } catch (DataAccessException e) {
                    e.printStackTrace();
                    log.error(e.getMessage(), e);
                    throw new BusinessException("企业新增或更新成功，使用专家法计算企业信用得分失败");
                }
                log.info("企业新增或更新成功，使用专家法计算企业信用得分成功");
                // 重新以逻辑回归法进行计分
                result = getLrScore(agent.getRegId());
                log.info("企业新增成功，使用逻辑回归算法计算企业信用得分成功");
            }
        }
        return result;
    }
    
    private int getLrScore(String regId) throws BusinessException{
        int result = 1;
        String host = constant.getAlgorithmHost();      //算法接口的地址
        String modelCode = constant.getAlgorithmLRModelCode();  //行业属性类型
        if(StringUtils.isEmpty(host) || StringUtils.isEmpty(modelCode)){
            throw new BusinessException("企业新增或更新成功，连接算法服务器信息出错！");
        }
        
//      content_one，   {"reg_id":"91320106249698424N", "model_code":"110000"}
//      model_code <string>: 行业模型的代码，默认110000； 依次编码为 110001,110002... 以此类推
        //算法需要的参数
        JSONObject json = new JSONObject();
        json.put("model_code", modelCode);
        json.put("reg_id", regId);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("content_one", json.toJSONString()));
        try {
            String postRs = HttpClientUtil.post(host, params);
            JSONObject rsJson = JSONObject.parseObject(postRs);
            int stateCode = rsJson.getIntValue("state_code");
            if(stateCode == 1){
                result = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("企业新增或更新成功，连接算法服务器连接出错",e);
            throw new BusinessException("企业新增或更新成功，使用逻辑回归算法计算企业信用得分失败");
        }
        return result;
    }

    @Override
    public boolean submitGroupId(Integer groupId) {
        ArrayList<CrawlerAgentInfoEntity> agentInfos = null;
        try {
            agentInfos = companyDao.findAgentBygroupId(groupId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
//        for (CrawlerAgentInfoEntity agentInfos2 : agentInfos) {
//            processNewsList(agentInfos2);
//        }
        return true;
    }
    
    private int processNewsList(CrawlerAgentInfoEntity agentInfos) throws BusinessException {
		try {
			//https访问方式
//			System.setProperty("javax.net.ssl.keytore", System.getProperty("user.dir") + "/SSL/client.keystore");  
//            System.setProperty("javax.net.ssl.keyStorePassword", "yodata");  
//            System.setProperty("javax.net.ssl.trustStore", System.getProperty("user.dir") + "/SSL/client.truststore");  
//            System.setProperty("javax.net.ssl.trustStorePassword",  "yodata");  
			
			ICreditDataWSLocator service = new ICreditDataWSLocator();
//			String StrPortAddress = "http://10.48.1.31:8080/creditdata-web/services/credit";
			service.setICreditDataWSPortEndpointAddress(constant.getAddAgentWebserviceAddr());
			// 得到客户端服务

			// 得到客户端stub
			ICreditDataWSPortType port = service.getICreditDataWSPort();
			// 测试服务方法
			String resultStr = port.getCredit(agentInfos.getInfoName());
			return Integer.parseInt(resultStr);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("连接webservice接口发生异常"); 
		}
    }

   /* private boolean processNewsList(CrawlerAgentInfoEntity agentInfos) {
        String Keywords = "";
        // 优先使用工商注册号
        if ("".equals(agentInfos.getInfoName()) || null == agentInfos.getInfoName()) {
            Keywords = agentInfos.getInfocreditcode();
        } else {
            if (agentInfos.getInfocreditcode() != null && !"".equals(agentInfos.getInfocreditcode())) {
                Keywords = agentInfos.getInfocreditcode();
            } else {
                Keywords = agentInfos.getInfoName();
            }
        }
        NewsListEntity newsList = new NewsListEntity();
        newsList.setCid("teng_bang");// 不可变值：teng_bang
        newsList.setAttachTag("{\"深圳信用\":\"" + Keywords + "\"}");// 附加标签（{“深圳信用”：“工商注册号或者企业名称”}）
        newsList.setChannelName("深圳信用");
        newsList.setKeyword(Keywords);
        newsList.setPageType("tengbanglist");// 不可变值
        try {
            newsList.setUrl("http://www.szcredit.org.cn/web/gspt/newEntlist.aspx?sNameKey=" + URLEncoder.encode(Keywords, "gbk"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        newsList.setCreateTime(new Date());
        newsList.setLastcrawltime(null);
        newsList.setModiTime(new Date());
        newsList.setNextcrawltime(new Date());
        newsList.setIntv(86400);// 抓取间隔
        newsList.setNextPageTime(20);// 最大请求次数
        newsList.setPageIdx(1);
        newsList.setStatus(1);// 状态（0：停用，1：启用，建议测试时设置成0）
        newsList.setWeight(8);// 优先级（固定8）
        return newsListDao.create(newsList);
    }*/

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public boolean isGroup(String compname) {
        try {
            return agentGroupDao.isGroup(compname);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<AgentGroup> findGroup(HttpServletRequest request, Page<AgentGroup> page) {
        Page<CrawlerAgentGroupEntity> groups = agentGroupDao.pageQueryData("from CrawlerAgentGroupEntity", page);
        List<CrawlerAgentGroupEntity> list = groups.getDate();
        List<AgentGroup> gList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (CrawlerAgentGroupEntity agentGroupEntity : list) {
                AgentGroup ag = new AgentGroup();
                ag.setGroupId(agentGroupEntity.getGroupId());
                ag.setGroupName(agentGroupEntity.getGroupName());
                gList.add(ag);
            }
        }
        page.setDate(gList);
        return page;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ArrayList<CrawlerAgentInfoEntity> findAgentBygroupId(Integer parameter) {
        ArrayList<CrawlerAgentInfoEntity> agnetinfo = null;
        try {
            agnetinfo = companyDao.findAgentBygroupId(parameter);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        return agnetinfo;
    }

    @Override
    public boolean EditAgent(CrawlerAgentGroupEntity agentgroup) {
        if (null == agentgroup.getGroupId()) {
            agentGroupDao.saveReturnPk(agentgroup);
            // 外键并未自动保存
            List<CrawlerAgentInfoEntity> agentInfos = agentgroup.getAgentinfos();
            for (CrawlerAgentInfoEntity temp : agentInfos) {
                temp.setInfoId(agentgroup.getGroupId());
                agentInfosDao.saveReturnPk(temp);// 保存企业
                CrawlerAgetngroupAgentinfoEntity item = new CrawlerAgetngroupAgentinfoEntity();
                item.setGroupId(agentgroup.getGroupId());
                item.setInfoId(temp.getInfoId());
                infoGroupDao.save(item);
            }
        } else {
            agentGroupDao.update(agentgroup);
            if (null == agentgroup.getAgentinfos().get(0).getInfoId()) {
                agentInfosDao.save(agentgroup.getAgentinfos().get(0));
                CrawlerAgetngroupAgentinfoEntity item = new CrawlerAgetngroupAgentinfoEntity();
                item.setGroupId(agentgroup.getGroupId());
                item.setInfoId(agentgroup.getAgentinfos().get(0).getInfoId());
                infoGroupDao.save(item);
            } else {
                agentInfosDao.update(agentgroup.getAgentinfos().get(0));// 更新企业
            }
        }
        return true;
    }

    @Override
    public boolean updateAgent(CrawlerAgentGroupEntity agentgroup) {
        agentGroupDao.update(agentgroup);
        List<CrawlerAgentInfoEntity> agentInfos = agentgroup.getAgentinfos();
        for (CrawlerAgentInfoEntity temp : agentInfos) {
            agentInfosDao.update(temp);// 更新企业
            CrawlerAgetngroupAgentinfoEntity item = new CrawlerAgetngroupAgentinfoEntity();
            item.setGroupId(agentgroup.getGroupId());
            item.setInfoId(temp.getInfoId());
            infoGroupDao.update(item);
        }
        return true;
    }

    @Override
    public boolean deleteAgent(CrawlerAgentGroupEntity agentgroup) {
        List<CrawlerAgentInfoEntity> agentInfos = agentgroup.getAgentinfos();
        for (CrawlerAgentInfoEntity temp : agentInfos) {
            CrawlerAgetngroupAgentinfoEntity item = new CrawlerAgetngroupAgentinfoEntity();
            item.setGroupId(agentgroup.getGroupId());
            item.setInfoId(temp.getInfoId());
            infoGroupDao.delete(item);
        }
        return true;
    }

    @Override
    public boolean deleteGroup(CrawlerAgentGroupEntity agentgroup) {
        agentGroupDao.delete(agentgroup);
        Criteria criteria = infoGroupDao.createCriteria();
        criteria.add(Restrictions.eq("groupId", agentgroup.getGroupId()));
        List<CrawlerAgetngroupAgentinfoEntity> list = (List<CrawlerAgetngroupAgentinfoEntity>) criteria.list();
        for (CrawlerAgetngroupAgentinfoEntity ig : list) {
            infoGroupDao.delete(ig);
        }
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public boolean agentIsExistence(String compName) {
        return clDao.isExistence(compName);
    }

    @Override
    public List<AgentInfoEntity> getAgentInfoByName(String compName) throws BusinessException {
        if(StringUtils.isEmpty(compName)){
            throw new BusinessException("企业名称不能为空");
        }
        return  companyDao.findBy("compName", compName);
    }
}