package com.yodata.creditsupport.service.imp;

import java.util.List;

import com.yodata.creditsupport.dao.MenuDao;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.entity.MenuEntity;
import com.yodata.creditsupport.orm.entity.RoleMenuEntity;
import com.yodata.creditsupport.orm.vo.Menu;
import com.yodata.creditsupport.service.IMenuService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 菜单管理实现类
 * @author zhang
 *
 */
@Service
@Transactional
public class MenuServiceImp implements IMenuService{
    private final Log log= LogFactory.getLog(MenuServiceImp.class);
    @Resource
    private MenuDao menuDao;

	@Override
	public void createRolePermission(List<RoleMenuEntity> list) {
	    if(list != null && !list.isEmpty()){
	        menuDao.createRolePermission(list);
	    }
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<MenuEntity> queryMenuAll() {
		return menuDao.findBy("status", "1");
	}

	@Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Menu> getMenuByRoleId(Integer roleId) {
	    try {
            return menuDao.getMenuByRoleId(roleId);
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return null;
        }
	}

	@Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Menu> getMenuByUserId(Integer userId) {
	    try {
            return menuDao.getMenuByUserId(userId);
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return null;
        }
	}

	@Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Menu> getMenuByPerUserId(Integer userId) {
		// TODO Auto-generated method stub
		 try {
	            return menuDao.getMenuByPerUserId(userId);
	        } catch (DataAccessException e) {
	            log.error(e.getMessage(), e);
	            e.printStackTrace();
	            return null;
	        }
	}
	
}