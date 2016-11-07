package com.yodata.creditsupport.service.imp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yodata.creditsupport.dao.DimModelDao;
import com.yodata.creditsupport.orm.entity.DimModelEntity;
import com.yodata.creditsupport.service.IDimModelService;
@Service
@Transactional
public class DimModelServiceImpl implements IDimModelService{
	@Autowired
	private DimModelDao dimModelDao;
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<DimModelEntity> getByDate(Date date) {
		Criteria criteria = dimModelDao.createCriteria();
		DateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = fm.parse(fm.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		criteria.add(Restrictions.eq("createTime", date));
		criteria.addOrder(Order.desc("createTime"));
//		criteria.setFirstResult((page-1)*size);  
//		criteria.setMaxResults(page*size);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<DimModelEntity>)criteria.list();
	}
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<DimModelEntity> getByModelCodeLatest(String modelCode) {
		//第一步：获取该算法的最新日期date
		Criteria dateCriteria = dimModelDao.createCriteria().setProjection(Projections.projectionList().add(Projections.max("createTime"),"createTime"));
		dateCriteria.add(Restrictions.eq("type", modelCode));
		List<Date> dates = (List<Date>)dateCriteria.list();
		//第二步：按最新日期获取维度值
		Criteria criteria = dimModelDao.createCriteria();
		DateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = fm.parse(fm.format(dates.get(0)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		criteria.add(Restrictions.eq("createTime", date));
		criteria.add(Restrictions.eq("type", modelCode));
		return (List<DimModelEntity>)criteria.list();
	}
}
