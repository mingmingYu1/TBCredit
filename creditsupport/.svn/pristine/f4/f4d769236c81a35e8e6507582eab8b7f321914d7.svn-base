package com.yodata.creditsupport.service.imp;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import com.yodata.core.domain.Page;
import com.yodata.creditsupport.dao.UserDao;
import com.yodata.creditsupport.dao.UserRoleDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.DeptEntity;
import com.yodata.creditsupport.orm.entity.UserEntity;
import com.yodata.creditsupport.orm.entity.UserRoleEntity;
import com.yodata.creditsupport.orm.vo.User;
import com.yodata.creditsupport.service.IUserService;
import com.yodata.creditsupport.util.MD5;
import com.yodata.creditsupport.util.Validator;

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
 * 用户管理实现类
 * @author zhang
 *
 */
@Service
@Transactional
public class UserServiceImp implements IUserService{
    private final Log log= LogFactory.getLog(UserServiceImp.class);
   
    @Resource
    private UserDao userDao;
    @Resource
    private UserRoleDao userRoleDao;
    
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
    public Integer adduser(UserEntity userEntity){
    	
    	Integer pk =  (Integer) userDao.saveReturnPk(userEntity);
        return pk;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateuser(UserEntity user) throws BusinessException{
        //更新用户，不更新所有列，只更新部分
        UserEntity oldUser = userDao.get(user.getUserId());
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
            
            userDao.update(oldUser);
        }
    }
    
	@Override
    @Transactional(propagation = Propagation.SUPPORTS)
	public void deleteuser(Integer id) throws BusinessException {
	    UserEntity user = userDao.get(id);
        if(user == null){
            BusinessException be = new BusinessException("用户不存在,无法进行操作");
            log.error("用户不存在,无法进行操作", be);
            throw be;
        } else {
            userDao.delete(id);
        }
		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addUserRole(List<UserRoleEntity> list) {
		userDao.addUserRole(list);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page<User> queryAllUser(HttpServletRequest request,Page<User> page) {
	    try {
	    	String condition = request.getParameter("query_type");
	    	String values = request.getParameter("condition");
	    	if(values != null) {
	    		values = URLDecoder.decode(values, "UTF-8");
	    	}
            page = userDao.getPageUsers(condition, values, page);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
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
	public List<UserEntity> findByName(String username) {
		List<UserEntity> uList = userDao.findBy("userName", username);
		return uList;
	}


	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public UserEntity findUserEntity(UserEntity user) {
	    return userDao.findUserEntity(user);
	}
	
	@Override
	public void resetPword(Integer userId, String pwd) throws BusinessException {
	    //更新用户密码
		if(userId == 1) {
			throw new BusinessException("不能重置管理员用户密码");
		}
        UserEntity oldUser = userDao.get(userId);
        if(oldUser == null){
            BusinessException be = new BusinessException("用户不存在,无法进行操作");
            log.error(be);
            throw be;
        } else {
            oldUser.setPassword(MD5.digest(pwd));
            oldUser.setErrCount(0);
            oldUser.setStatus("1");
        }
	}

    @Override
    public void updatePassword(Integer userId, String oldPassword, String newPassword)
            throws BusinessException {
        if(oldPassword == null || "".equals(oldPassword)) {
            throw new BusinessException("原始密码不能为空");
        }
        if(newPassword == null || !Validator.isPassword(newPassword)) {
            throw new BusinessException("新密码必须为数字和字母的组合,8-16位");
        }
        if(oldPassword.equals(newPassword)) {
            throw new BusinessException("新密码不能与旧密码一样");
        }
        UserEntity user = userDao.get(userId);
        if(!user.getPassword().equals(MD5.digest(oldPassword))) {
            throw new BusinessException("原始密码不正确");
        }
        user.setPassword(MD5.digest(newPassword));
    }

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Integer> queryRoleByUserId(Integer uid) {
	    try {
            return userDao.queryRoleByUserId(uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
	    return null;
	}

	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public UserEntity findUserEntityById(String uid) {
		
	    List<UserEntity> list =  userDao.findBy("userId", uid);
		if(list.size()>0)
			return list.get(0);
		else
			return new UserEntity();
	}


	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public UserEntity findUserEntityByName(String username) {
		
		List<UserEntity> list =  userDao.findBy("userName", username);
		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
	

	@Override
	public void addErrorcount(String username) {
		UserEntity user = this.findUserEntityByName(username);
		if(user == null){
            BusinessException be = new BusinessException("用户不存在,无法进行操作");
            log.error("用户不存在,无法进行操作", be);
        } else {
            user.setErrCount(user.getErrCount() + 1);
            userDao.update(user);
        }
	}


	@Override
	public void updateuser2(UserEntity loginUser) {
		userDao.update(loginUser);
	}
	
	@Override
	public void blockUserEntity(String username) {
	    UserEntity user = this.findUserEntityByName(username);
        if(user == null){
            BusinessException be = new BusinessException("用户不存在,无法进行操作");
            log.error("用户不存在,无法进行操作", be);
        } else {
            user.setErrCount(user.getErrCount() + 1);
            user.setStatus("0");
            userDao.update(user);
        }
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int selectUserCountByDeptId(Integer deptId) {
        Criteria criterions = userDao.createCriteria(Restrictions.eq("deptId", deptId));
        criterions.add(Restrictions.eq("status", "1"));
        List<DeptEntity> list = criterions.list();
        int num = list == null ? 0 : list.size();
        return num;
    }
}