package cn.tedu.service;

import java.util.List;

import cn.tedu.pojo.User;

public interface UserService {
	//查询所有
	public List<User> find();

	//查询单个User
	public User findUserById(Integer id);

	//插入一个User
	public void insert(User user);

	//更新用户
	public void update(User user);

}
