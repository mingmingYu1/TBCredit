package com.yodata.creditsupport.service.imp;

import java.util.List;

import com.yodata.core.domain.Page;
import com.yodata.creditsupport.dao.RoleDao;
import com.yodata.creditsupport.dao.UserRoleDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.RoleEntity;
import com.yodata.creditsupport.orm.entity.UserRoleEntity;
import com.yodata.creditsupport.orm.vo.Role;
import com.yodata.creditsupport.service.IRoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * 角色管理实现类
 * @author zhang
 *
 */
@Service
@Transactional
public class RoleServiceImp implements IRoleService{
    private final Log log= LogFactory.getLog(RoleServiceImp.class);
    @Resource
    private RoleDao roleDao;
    @Resource
    private UserRoleDao userRoleDao;
    
    @Override
    public Integer addrole(RoleEntity entityName){
    	Integer pk =  (Integer) roleDao.saveReturnPk(entityName);
        return pk;
    }

    @Override
    public void deleterole(Integer id){
        roleDao.delete(id);
    }

    @Override
    public void updaterole(RoleEntity role) throws BusinessException{
        //更新role的部分属性
        RoleEntity oldRole = roleDao.get(role.getRoleId());
        if(oldRole == null){
            BusinessException be = new BusinessException("角色不存在,无法进行操作");
            log.error("角色不存在,无法进行操作", be);
            throw be;
        } else {
            oldRole.setRoleName(role.getRoleName());
            oldRole.setCreateTime(role.getCreateTime());
            
            roleDao.update(oldRole);
        }
    }

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<RoleEntity> roleshow() {
	    return roleDao.findBy("status", "1");
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int queryUserCountByRoleId(Integer roleId) {
	    List<UserRoleEntity> list = userRoleDao.findBy("roleId", roleId);
		int count = list == null ? 0 : list.size();
		return count;
	}

	@Override
	public int deleteRoleMenu(Integer roleId) {
		try {
            return roleDao.deleteRoleMenu(roleId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
		return 0;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<RoleEntity> queryRoleListByRoleName(String rolename) {
        return roleDao.findBy("roleName", rolename);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int queryRoleCountByRoleName(String roleName, Integer id) {
	    
	    Criteria criteria = roleDao.createCriteria(Restrictions.eq("roleName", roleName));
	    criteria.add(Restrictions.ne("roleId", id));
        criteria.add(Restrictions.eq("status", "1"));
        
        @SuppressWarnings("unchecked")
        List<RoleEntity> list = criteria.list();
        
        int num = list == null ? 0 : list.size();
        return num;
	
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page<Role> showRoleByName( String rolename,Page<Role> page) {
	    
	    try {
            return roleDao.getPageRoles(rolename, page);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
	    
	    return page;

	}

	@Override
	public void deleteRoleAndMenu(Integer roleId) {
		deleteRoleMenu(roleId);
		deleterole(roleId);
	}
}