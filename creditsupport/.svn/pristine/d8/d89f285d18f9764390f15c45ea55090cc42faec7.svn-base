package com.yodata.creditsupport.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yodata.creditsupport.dao.DictDao;
import com.yodata.creditsupport.orm.entity.DictEntity;
import com.yodata.creditsupport.service.IDictService;

import javax.annotation.Resource;

/**
 * 字典表查询实现类
 * @author Anna
 *
 */
@Service
@Transactional
public class DictServiceImpl implements IDictService{
    @Resource
    private DictDao dictDao;
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<DictEntity> getDictsByCategory(String category) {
        return dictDao.getDictsByCategory(category);
    }
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public DictEntity getCateEntityById(Integer id) {
        return dictDao.get(id);
    }
    
}