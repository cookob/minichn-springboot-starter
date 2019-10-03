package com.minichn.controller;

import com.minichn.pojo.MinichnJSONResult;
import com.minichn.pojo.SysUser;
import com.minichn.service.SysUserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sysuser")
public class SysUserCRUDController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public MinichnJSONResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("Minichn" + new Date());
		user.setNickname("Minichn" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());

		sysUserService.saveUser(user);
		
		return MinichnJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public MinichnJSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("1001");
		user.setUsername("1001-updated" + new Date());
		user.setNickname("1001-updated" + new Date());
		user.setPassword("1001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());

		sysUserService.updateUser(user);
		
		return MinichnJSONResult.ok("Update成功");
	}
	
	@RequestMapping("/deleteUser")
	public MinichnJSONResult deleteUser(String userId) {

		sysUserService.deleteUser(userId);
		
		return MinichnJSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public MinichnJSONResult queryUserById(String userId) {
		
		return MinichnJSONResult.ok(sysUserService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public MinichnJSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("Minichn");
		user.setNickname("cmini");
		
		List<SysUser> userList = sysUserService.queryUserList(user);
		
		return MinichnJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public MinichnJSONResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 10;
		
		SysUser user = new SysUser();
//		user.setNickname("cmini");
		
		List<SysUser> userList = sysUserService.queryUserListPaged(user, page, pageSize);
		
		return MinichnJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public MinichnJSONResult queryUserByIdCustom(String userId) {
		
		return MinichnJSONResult.ok(sysUserService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public MinichnJSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("cmini" + new Date());
		user.setNickname("cmini" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());

		sysUserService.saveUserTransactional(user);
		
		return MinichnJSONResult.ok("保存成功");
	}
}
