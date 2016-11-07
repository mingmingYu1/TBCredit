package com.yodata.creditsupport.service.imp;

import java.util.List;

import com.yodata.core.domain.Page;
import com.yodata.creditsupport.dao.PerUserDao;
import com.yodata.creditsupport.dao.UserRoleDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.DeptEntity;
import com.yodata.creditsupport.orm.entity.UserRoleEntity;
import com.yodata.creditsupport.orm.person.entity.PerUserEntity;
import com.yodata.creditsupport.orm.vo.User;
import com.yodata.creditsupport.service.IPersonUserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
/**
 * 
* @Description: 用户管理实现类
* @author Jason
* @date 2016年7月18日 下午4:16:25
*
 */
@Service
@Transactional
public class PersonUserServiceImp implements IPersonUserService{
    private final Log log= LogFactory.getLog(PersonUserServiceImp.class);
   
    @Resource
    private PerUserDao perUserDao;
    @Resource
    private UserRoleDao userRoleDao;
    
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
    public Integer adduser(PerUserEntity userEntity){
    	
    	Integer pk =  (Integer) perUserDao.saveReturnPk(userEntity);
        return pk;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateuser(PerUserEntity user) throws BusinessException{
        //更新用户，不更新所有列，只更新部分
    	PerUserEntity oldUser = perUserDao.get(user.getUserId());
        if(oldUser == null){
            BusinessException be = new BusinessException("用户不存在,无法进行操作");
            log.error("用户不存在,无法进行操作", be);
            throw be;
        } else {
            oldUser.setRealName(user.getRealName());
            oldUser.setDeptId(user.getDeptId());
            oldUser.setCreateTime(user.getCreateTime());
            oldUser.setStatus(user.getStatus());
            oldUser.setErrCount(user.getErrCount());
            
            perUserDao.update(oldUser);
        }
    }
    
	@Override
    @Transactional(propagation = Propagation.SUPPORTS)
	public void deleteuser(Integer id) throws BusinessException {
		PerUserEntity user = perUserDao.get(id);
        if(user == null){
            BusinessException be = new BusinessException("用户不存在,无法进行操作");
            log.error("用户不存在,无法进行操作", be);
            throw be;
        } else {
            perUserDao.delete(id);
        }
		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addUserRole(List<UserRoleEntity> list) {
		perUserDao.addUserRole(list);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page<User> queryAllUser(HttpServletRequest request,Page<User> page) {
	    String condition = request.getParameter("query_type");
        String values = request.getParameter("condition");
	    try {
            page = perUserDao.getPageUsers(condition, values, page);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		
		return page;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public int deleteUserRole(Integer uid) {
	    try {
            return userRoleDao.deleteUserRole(uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
	    return 0;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int findByName(String username) {
		List<PerUserEntity> uList = perUserDao.findBy("peruserName", username);
		int num = uList == null ? 0 : uList.size();
		return num;
	}


	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public PerUserEntity findUserEntity(PerUserEntity user) {
	    return perUserDao.findUserEntity(user);
	}
	
	@Override
	public void resetPword(PerUserEntity user) throws BusinessException {
	    
	    //更新用户密码
		PerUserEntity oldUser = perUserDao.get(user.getUserId());
        if(oldUser == null){
            BusinessException be = new BusinessException("用户不存在,无法进行操作");
            log.error("用户不存在,无法进行操作", be);
            throw be;
        } else {
            oldUser.setPerpassword(user.getPerpassword());
            perUserDao.update(oldUser);
        }
	    
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Integer> queryRoleByUserId(Integer uid) {
		
	    try {
            return perUserDao.queryRoleByUserId(uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
	    
	    return null;
	}

	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public PerUserEntity findUserEntityById(String uid) {
		
	    List<PerUserEntity> list =  perUserDao.findBy("userId", uid);
		if(list.size()>0)
			return list.get(0);
		else
			return new PerUserEntity();
	}


	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public PerUserEntity findUserEntityByName(String username) {
		
		List<PerUserEntity> list =  perUserDao.findBy("peruserName", username);
		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
	

	@Override
	public void addErrorcount(String username) {
		PerUserEntity user = this.findUserEntityByName(username);
		if(user == null){
            BusinessException be = new BusinessException("用户不存在,无法进行操作");
            log.error("用户不存在,无法进行操作", be);
        } else {
            user.setErrCount(user.getErrCount() + 1);
            perUserDao.update(user);
        }
	}


	@Override
	public void updateuser2(PerUserEntity loginUser) {
		perUserDao.update(loginUser);
	}
	
	
	@Override
	public void blockUserEntity(String username) {
	    PerUserEntity user = this.findUserEntityByName(username);
        if(user == null){
            BusinessException be = new BusinessException("用户不存在,无法进行操作");
            log.error("用户不存在,无法进行操作", be);
        } else {
            user.setErrCount(user.getErrCount() + 1);
            user.setStatus("0");
            perUserDao.update(user);
        }
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int selectUserCountByDeptId(Integer deptId) {
        Criteria criterions = perUserDao.createCriteria(Restrictions.eq("deptId", deptId));
        criterions.add(Restrictions.eq("status", "1"));
        List<DeptEntity> list = criterions.list();
        int num = list == null ? 0 : list.size();
        return num;
    }



}