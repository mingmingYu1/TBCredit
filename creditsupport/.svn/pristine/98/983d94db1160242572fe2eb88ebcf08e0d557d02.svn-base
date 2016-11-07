package com.yodata.creditsupport.dao;

import java.util.List;

import com.yodata.core.dao.SimpleHibernateDao;
import com.yodata.creditsupport.orm.entity.DictEntity;

import org.springframework.stereotype.Component;

@Component
public class DictDao extends SimpleHibernateDao<DictEntity,java.lang.Integer>{
	
    /**
     * 根据大类查询
     * @param category
     * @return
     */
	public List<DictEntity> getDictsByCategory(String category){
		return this.findBy("category", category);
	}

}