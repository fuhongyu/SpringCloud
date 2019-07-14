package cn.jt.controller;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils; //md5的包，记住别导错了
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.common.service.RedisService;
import cn.jt.common.util.SysResult;
import cn.jt.pojo.User;
import cn.jt.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
		
	@RequestMapping("/user/check/{param}/{typeVal}")
	public SysResult check(@PathVariable String param, @PathVariable Integer typeVal) {
		Boolean b = userService.check(param, typeVal);
		return SysResult.ok(b);
	}
	
	@RequestMapping("/user/query/{ticket}")
	public SysResult query(@PathVariable String ticket) {
		String userJson = userService.query(ticket);
		return SysResult.ok(userJson);
	}
	
	@RequestMapping("/user/register")
	public SysResult register(@RequestBody User user){//这个请求传递对象，服务提供者必须加@RequestBody 注解
		user.setCreated(new Date());
		user.setUpdated(new Date());
		//密码加密
		String newPwd = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(newPwd);
		String name = userService.register(user);		
		return new SysResult().ok(name);
	}
	
	@RequestMapping("/user/login")
	public SysResult login(@RequestParam("u") String username,@RequestParam("p") String password){
		String ticket = userService.login(username, password);
		return new SysResult().ok(username);
	}
}
