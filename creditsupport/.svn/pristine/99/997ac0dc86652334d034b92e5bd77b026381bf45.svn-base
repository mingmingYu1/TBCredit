package com.yodata.creditsupport.service.imp;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yodata.creditsupport.dao.PersonReportTempletDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.person.entity.PersonReportTempletEntity;
import com.yodata.creditsupport.service.IPersonReportTempletService;
import com.yodata.creditsupport.util.QueryParam;

@Service
@Transactional
public class PersonReportTempletServiceImp implements IPersonReportTempletService{

	@Resource
	private PersonReportTempletDao personReportTempletDao;
	
	
	@Override
	public void add(PersonReportTempletEntity entity) {
		// TODO Auto-generated method stub
		personReportTempletDao.save(entity);
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		personReportTempletDao.setDisabled(id);
	}

	@Override
	public void update(PersonReportTempletEntity entity) {
		// TODO Auto-generated method stub
		personReportTempletDao.update(entity);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getPageTemplet(QueryParam queryParam) throws Exception {
		// TODO Auto-generated method stub
		return  personReportTempletDao.getPageTemplet(queryParam);
	}

	@Override
	public void saveOrUpdateEntity(PersonReportTempletEntity reportTempletEntity) throws Exception {
		// TODO Auto-generated method stub
		personReportTempletDao.saveOrUpdateEntity(reportTempletEntity);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public PersonReportTempletEntity getReportTempletEntityByID(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return personReportTempletDao.getReportTempletEntityByID(id);
	}

	
	
}
