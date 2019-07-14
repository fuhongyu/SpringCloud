package cn.tedu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.mapper.UserMapper;
import cn.tedu.pojo.User;
import cn.tedu.service.UserService;

//利用包扫描机制，自动创建这个类对象
@Service
public class UserServiceImpl implements UserService{
	//spring 注入,通过注入方式把Mybatis接口对象注入到service层，直接调用
	@Autowired
	private UserMapper userMapper;

	public List<User> find() {
		
		return userMapper.findAll();
	}

	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(id);
	}

	public void insert(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
		
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

}
