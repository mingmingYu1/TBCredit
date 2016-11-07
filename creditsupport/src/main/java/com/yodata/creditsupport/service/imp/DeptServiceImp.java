package com.yodata.creditsupport.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yodata.core.domain.Page;
import com.yodata.creditsupport.dao.DeptDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.DeptEntity;
import com.yodata.creditsupport.orm.vo.Dept;
import com.yodata.creditsupport.service.IDeptService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

@Service
@Transactional
public class DeptServiceImp implements IDeptService{
    private final Log log= LogFactory.getLog(DeptServiceImp.class);
    @Resource
    private DeptDao deptDao;
    
    @Override
    public void add(DeptEntity entity){
        deptDao.save(entity);
    }

    @Override
    public int update(DeptEntity entity) throws BusinessException{
        //只修改部门名称、父级ID及创建修改时间
        int num = 0;
        DeptEntity oldDept = deptDao.get(entity.getDeptId());
        if (oldDept == null) {
            BusinessException be = new BusinessException("部门不存在,无法进行操作");
            log.error("部门不存在,无法进行操作", be);
            throw be;
        } else {
            oldDept.setDeptName(entity.getDeptName());
            oldDept.setParentId(entity.getParentId());
            oldDept.setCreateTime(entity.getCreateTime());
            deptDao.update(oldDept);
            num = 1;
        }
        return num;
    }

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<DeptEntity> deptshow() {
		List<DeptEntity> deptList = deptDao.findBy("status", "1");
		return deptList;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<DeptEntity> findByName(String deptName) {
		return deptDao.findBy("deptName", deptName);
	}

	@Override
	public int deleteEntity(Integer deptId) throws BusinessException {
	    DeptEntity oldDept = deptDao.get(deptId);
      if(oldDept == null){
          BusinessException be = new BusinessException("部门不存在,无法进行操作");
          log.error("部门不存在,无法进行操作", be);
          throw be;
      } else {
          deptDao.delete(deptId);
      }
		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page<Dept> queryAllDept(HttpServletRequest request, Page<Dept> page) {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("condition", request.getParameter("query_type"));
	    params.put("values", request.getParameter("condition"));
		try {
            return deptDao.getPageDepts(params, page);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return page;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int queryDeptByName(DeptEntity deptEntity) {
		
		Integer id = deptEntity.getDeptId();
		String deptName = deptEntity.getDeptName();
		
		Criteria criterions = deptDao.createCriteria(Restrictions.eq("deptName", deptName));
        criterions.add(Restrictions.eq("status", "1"));
        criterions.add(Restrictions.ne("deptId", id));
        List<DeptEntity> list = criterions.list();
        int num = list == null ? 0 : list.size();
        return num;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int selectSonByDeptId(Integer deptId) {
		
        List<DeptEntity> list = this.getSonDeptByParentId(deptId);
        int num = list == null ? 0 : list.size();
        return num;
	}

    @Override
    public List<DeptEntity> getSonDeptByParentId(Integer parentId) {
        Criteria criterions = deptDao.createCriteria(Restrictions.eq("parentId", parentId));
        criterions.add(Restrictions.eq("status", "1"));
        List<DeptEntity> list = criterions.list();
        return list;
    }
	
}