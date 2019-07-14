package cn.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.pojo.User;
import cn.tedu.service.UserService;

@RestController  //返回值变成json格式，支持RESTFUL格式
public class UserController {

	@Autowired
	private UserService userService;
	
	//查询所有
	//浏览器：http://localhost:8060/user/find
	@RequestMapping("/user/find")
	public List<User> find(){
		return userService.find();
		
	}
	
	@RequestMapping("/find/{id}")
	public User findUserById(@PathVariable Integer id){
		return userService.findUserById(id);
	}
	
	@RequestMapping("/insert/{name}/{birthday}/{address}")
	public String insertUser(User user){
		userService.insert(user);
		return "新增用户成功！";
	}
	
	@RequestMapping("/update/{name}/{birthday}/{address}/{id}")
	public String updateUser(User user){
		userService.update(user);
		return "更新成功";
	}
	
}
