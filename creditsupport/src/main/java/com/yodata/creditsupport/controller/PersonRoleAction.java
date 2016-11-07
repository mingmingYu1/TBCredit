package com.yodata.creditsupport.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodata.core.control.BasicAction;
import com.yodata.core.domain.Page;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.entity.MenuEntity;
import com.yodata.creditsupport.orm.entity.RoleEntity;
import com.yodata.creditsupport.orm.entity.RoleMenuEntity;
import com.yodata.creditsupport.orm.person.entity.PerUserEntity;
import com.yodata.creditsupport.orm.vo.Menu;
import com.yodata.creditsupport.orm.vo.Role;
import com.yodata.creditsupport.service.IMenuService;
import com.yodata.creditsupport.service.IRoleService;

@Controller
@RequestMapping("/personRole")
public class PersonRoleAction extends BasicAction{
    private final Log log= LogFactory.getLog(RoleAction.class);
    @Resource
    private IRoleService roleService;
    @Resource
    private IMenuService menuService;

    /**
     * 添加角色
     * @param roleEntity
     * @return
     */
    @RequestMapping(value="/addRole",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> addrole(RoleEntity roleEntity,String right,
    		HttpServletRequest request, HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("utf-8");	
    	Map<String, Object> object = new HashMap<String, Object>();
    	
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		log.info("当前登录用户不能为空");
    		return object;
    	}
		
    	//角色名称不能为空
		String roelname = roleEntity.getRoleName();
		if(roelname==null || "".equals(roelname)){
			log.info("角色名称不能为空>>>>>>>>>>>>>");
			object.put("num", 0);
			return object;
		}
		
		if(right==null 
				|| "".equals(right) 
				|| right.split(",").length==0){
			log.info("权限不能为空>>>>>>>>>>>>>");
			object.put("num", 5);
			return object;
		}
		
		if(roelname.length()>20){
			log.info("角色名称不能大于20位>>>>>>>>>>>>>");
			object.put("num", 7);
			return object;
		}
		
		//角色名重复
		List<RoleEntity> rList = roleService.queryRoleListByRoleName(roelname);
		if(rList != null && !rList.isEmpty()){
			log.info("角色名称"+roelname+"已经存在>>>>>>>>>>>>>");
			object.put("num", 1);
			return object;
		}
		
		try {
			roleEntity.setCreateUser(loaduser.getRealName());
			//获取当前系统时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ts = df.format(System.currentTimeMillis());  	
			
			roleEntity.setCreateTime(Timestamp.valueOf(ts));
			roleEntity.setStatus("1");
			roleEntity.setSort(0);
			
			Integer rid = roleService.addrole(roleEntity);//创建角色
			
			String []perIds=right.split(",");//权限编号
			List<RoleMenuEntity> list=new ArrayList<>();
			for (int i = 0; i < perIds.length; i++) {
				
				RoleMenuEntity rm = new RoleMenuEntity();
				rm.setRoleId(rid);
				rm.setMenuId(Integer.valueOf(perIds[i]));
				list.add(rm);
			}
			
			menuService.createRolePermission(list);//绑定权限
			
			object.put("result", 1);
			log.info("创建新的角色'"+roelname+"'成功>>>>>>>>>>>>>>>>>");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("创建新的角色信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>");
			object.put("result", -1);
			
		}
		
		long end = System.currentTimeMillis();
		log.info("===================创建角色'"+roelname+"'耗时"+(end-start)+"ms=======================");
		
		return object;
    }

    /**
     * 删除角色
     * @param RoleEntity
     * @return 
     */
    @RequestMapping(value="/delRole",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> deleterole(HttpServletRequest request,HttpServletResponse response){
        
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}		
    	
		Integer roleId = Integer.valueOf(request.getParameter("roleId"));
		if (roleId==1) {
			object.put("num", 0);
			log.info("管理员不可删除>>>>>>>>>>>>>>>>>>");
			return object;
		}
		
		try {
			//该角色已被用户绑定,不允许删除!
			int count=roleService.queryUserCountByRoleId(roleId);
			if(count>0){
				object.put("num",1);
				log.info("该角色已被用户绑定,不允许删除>>>>>>>>>>>>>>");
				return object;
			}
			
			//删除角色和角色关联表
			roleService.deleteRoleAndMenu(roleId);
			object.put("result", 1);
			log.info("删除角色成功>>>>>>>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除角色信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>");
			object.put("result", -1);
		}
		
		long end = System.currentTimeMillis();
		log.info("===================删除角色耗时"+(end-start)+"ms=======================");
		
		return object;
    }

    /**
     * 修改角色
     * @param RoleEntity
     * @return 
     */
    @RequestMapping(value="/updateRole",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> update(RoleEntity roleEntity,String right,
    		HttpServletRequest request, HttpServletResponse response){
        
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("utf-8");	
    	Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	//管理员角色不允许修改
    	if(1==roleEntity.getRoleId()){
    		object.put("num", 2);
    		log.info("管理员角色不允许修改>>>>>>>>>>>>>>>>>>>");
			return object;
    	}
    	
    	//角色名称不能为空
		String roelname = roleEntity.getRoleName();
		if(roelname==null || "".equals(roelname)){
			object.put("num", 0);
			log.info("角色名称不能为空>>>>>>>>>>>>>>>>>>>>");
			return object;
		}
		
		//权限不能为空
		if(right==null 
				|| "".equals(right) 
				|| right.split(",").length==0){
			log.info("权限不能为空>>>>>>>>>>>>>");
			object.put("num", 5);
			return object;
		}
		
		//角色名称不能大于20位
		if(roelname.length()>20){
			log.info("角色名称不能大于20位>>>>>>>>>>>>>");
			object.put("num", 7);
			return object;
		}
		
		//角色名重复
		List<RoleEntity> rList =roleService.queryRoleListByRoleName(roelname);
		if(rList != null && !rList.isEmpty()){
            for(RoleEntity re : rList){
                if(!re.getRoleId().equals(roleEntity.getRoleId())){
                    object.put("num", 1);
                    log.info("角色名'"+roelname+"'已经存在>>>>>>>>>>>>>>>>>>>>>>>>>");
                    return object;
                }
            }
        }
		
		try {
			Integer id = roleEntity.getRoleId();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ts = df.format(System.currentTimeMillis());
			roleEntity.setCreateTime(Timestamp.valueOf(ts));
			
			String []perIds=right.split(",");//权限编号
			List<RoleMenuEntity> list=new ArrayList<>();
			for (int i = 0; i < perIds.length; i++) {
				
				RoleMenuEntity rm = new RoleMenuEntity();
				rm.setRoleId(roleEntity.getRoleId());
				rm.setMenuId(Integer.valueOf(perIds[i]));
				list.add(rm);
			}
			
			roleService.updaterole(roleEntity);//修改角色
			roleService.deleteRoleMenu(id);//删除该角色权限
			
			menuService.createRolePermission(list);
			
			object.put("result", 1);
			log.info(loaduser.getPeruserName()+"修改角色成功>>>>>>>>>>>>>>>>");
		} catch (BusinessException e) {
            e.printStackTrace();
            log.error("修改角色信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>");
            object.put("result", -1);
        } catch (Exception e) {
			e.printStackTrace();
			log.error("修改角色信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>");
			object.put("result", -1);
		}
		
		long end = System.currentTimeMillis();
		log.info("===================删除角色耗时"+(end-start)+"ms=======================");
		return object;
    }
    
    /**
     * 修改角色之前,先查看角色信息
     * @param request
     */
    @RequestMapping("/toupdateRole")
    @ResponseBody
    public Map<String, Object> toupdaterole(HttpServletRequest request,HttpServletResponse response){
		
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	Integer roleId = Integer.valueOf(request.getParameter("roleId"));
		try {
			List<Menu> menuList = menuService.getMenuByRoleId(roleId);
			
			log.info("根据角色前查看菜单信息成功!>>>>>>>>>>>>>>...");
			object.put("result",1);
			object.put("menuList", menuList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("修改角色前查询信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>");
			object.put("result", -1);
		}
		
		long end = System.currentTimeMillis();
		log.info("===================查询ID为："+roleId+"的角色耗时"+(end-start)+"ms=======================");
		return object;
    }
    /**
     * 查询角色展示
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> showRoleByName(HttpServletRequest request,HttpServletResponse response){
    	
    	long start = System.currentTimeMillis();
    	
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	//用户未登录
    	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
    	if(loaduser==null){
    		object.put("result",-2 );
    		return object;
    	}
    	try {
    		int limit = Integer.valueOf(request.getParameter("limit")==null?"10":request.getParameter("limit"));
    		int offset = Integer.valueOf(request.getParameter("offset")==null?"0":request.getParameter("offset"));
    		
    		Page tempage = getPage();
    		tempage.setCountPerPage(limit);
    		tempage.setCurrent((offset+tempage.getCountPerPage())/limit);
    		
    		String rolename = request.getParameter("condition");//角色名称
    		Page<Role> page = roleService.showRoleByName(rolename,getPage());
    		
    		List<MenuEntity> menuEntitylList = menuService.queryMenuAll();//查询所有菜单
    		
    		
    		final Map<String,String> map = new HashMap<>();
			for(MenuEntity menu: menuEntitylList){
				map.put(menu.getMenuName(),String.valueOf(menu.getMenuId()));
			}
    		Comparator<? super String> c = new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return map.get(o1).compareTo(map.get(o2));
				}
			};
    		
    		List<Role> roleList = page.getDate();
    		List<Role> newRoleList = new ArrayList<>();
    		for(Role role: roleList){
    			String menuName = role.getEnRoleName();
    			String[] menuNames = menuName.split(" \\| ");
    			
    			List<String> menuNameList = new ArrayList<String>();
    			Collections.addAll(menuNameList, menuNames);
				Collections.sort(menuNameList, c);
				
				for (int i = 0; i < menuNameList.size(); i++) {
					if(i==0){
						menuName = menuNameList.get(i);
					}else{
						menuName = menuName+" | "+menuNameList.get(i);
					}
				}
				role.setEnRoleName(menuName);
				newRoleList.add(role);
    		}
    		page.setDate(newRoleList);
    		
    		object.put("result","1" );
	    	object.put("total", page.getCount());
    		
	    	List<Object> array = new ArrayList<>();
	    	List<Role> userList = page.getDate();
	    	
	    	for(int i=0;i<userList.size();i++){
	    		
	    		Role user = userList.get(i);
	    		Map<String, Object> row = new HashMap<String, Object>();
	    		row.put("roleId", user.getRoleId());
	    		row.put("roleName", user.getRoleName());
	    		row.put("menuName", user.getEnRoleName());
	    		array.add(row);
	    	}
	    	object.put("rows", array);
    		
    	}catch (Exception e) {
    		e.printStackTrace();
			log.error("查看角色信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>>>>>.");
			
			object = new HashMap<String, Object>();
			object.put("result","-1" );
		}
    	
    	long end = System.currentTimeMillis();
		log.info("===================展示角色耗时"+(end-start)+"ms=======================");
    	
		return object;
    }
    
    /**
     * 展示所有菜单
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value="/toaddRole",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> toaddRole(HttpServletRequest request,HttpServletResponse response){
    	
		long start = System.currentTimeMillis();
		
    	response.setCharacterEncoding("UTF-8");
    	Map<String, Object> object = new HashMap<String, Object>();
    	try {
        	PerUserEntity loaduser = (PerUserEntity) request.getSession().getAttribute("sessionUser");
        	if(loaduser==null){
        		object.put("result",-2 );
        		return object;
        	}
        	
    		List<MenuEntity> menuEntitylList = menuService.queryMenuAll();
    		object.put("menuEntitylList", menuEntitylList);
    		object.put("result",1);
    		log.error("查看角色信息成功>>>>>>>>>>>>>>>>>");
    		
    	}catch (Exception e) {
    		e.printStackTrace();
			log.error("查看角色信息异常，具体异常信息："+ e.getMessage()+">>>>>>>>>>>>>>>>>");
			
			object.put("result","-1" );
		}
    	
    	long end = System.currentTimeMillis();
		log.info("===================在RoleAction展示菜单耗时"+(end-start)+"ms=======================");
		return object;
    }
    
}