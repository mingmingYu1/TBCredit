package com.yodata.creditsupport.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yodata.creditsupport.dao.CompanyDao;
import com.yodata.creditsupport.dao.PersonDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.AgentInfoEntity;
import com.yodata.creditsupport.orm.entity.PersonAddInfo;
import com.yodata.creditsupport.orm.person.entity.OdsPersonInfoEntity;
import com.yodata.creditsupport.service.IPersonService;
import com.yodata.creditsupport.util.ConstantBean;
import com.yodata.creditsupport.util.QueryParam;

import cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWS;
import cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWSServiceLocator;
import cn.com.yodata.creditdataweb.webservice.PersonDTO;



@Service
@Transactional
public class PersonServiceImpl implements IPersonService{

	private final Log log= LogFactory.getLog(PersonServiceImpl.class);
	 
	@Resource
    private PersonDao personDao;
	@Autowired
    private ConstantBean constant;
	
	//新增个人信息
	@Override
	public int addPerson(PersonAddInfo personInfos) {

		if(doPersonService(personInfos))
			return 1;
		else
			return 0;
	}

	private boolean doPersonService(PersonAddInfo personInfos) {
		try {
			IPersonCreditDataWSServiceLocator service = new IPersonCreditDataWSServiceLocator();
			String StrPortAddress = constant.getAddPersonServiceAdd();
			service.setIPersonCreditDataWSPortEndpointAddress(StrPortAddress);
			// 得到客户端服务

			// 得到客户端stub
			IPersonCreditDataWS port = service.getIPersonCreditDataWSPort();
//			// 测试服务方法
			String[] bankArr = (String[])personInfos.getBankList().toArray(new String[personInfos.getBankList().size()]);
			String[] phoneArr = (String[])personInfos.getPhoneList().toArray(new String[personInfos.getPhoneList().size()]);
			PersonDTO person = new PersonDTO(bankArr,personInfos.getInfoCardCode(), personInfos.getInfoName(), phoneArr);
			String resultStr = port.getPersonCredit(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//查询个人信息
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getPagePerson(QueryParam queryParam) {
		 try {
	           return personDao.getPagePersons(queryParam);
	        } catch (DataAccessException e) {
	            log.error(e.getMessage());
	            return null;
	        }
	}

	@Override
	public boolean delete(String cardId) {
		 OdsPersonInfoEntity personInfo = getByCardId(cardId);// 先加载后级联删除
	        if (personInfo != null) {
	            personDao.delete(personInfo);
	        }
	        return true;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public OdsPersonInfoEntity getByCardId(String cardId) {
		List<OdsPersonInfoEntity> list = personDao.findBy("cardId", cardId);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
	
}
