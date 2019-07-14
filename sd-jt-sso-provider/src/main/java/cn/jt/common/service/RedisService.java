package cn.jt.common.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/*
 * 设置保护模式为no，就无需输入用户名和密码
 * 127.0.0.1:6379> config set protected-mode no
 */

@Service
public class RedisService {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	//设置值
	public void set(String key, String val){
		redisTemplate.opsForValue().set(key,val);
	}
	
	//设置值，及过期时间
	public void set(String key, String val, Integer seconds){
		redisTemplate.opsForValue().set(key,val);
		redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
	}
	
	//过期时间
	public void expire(String key, Integer seconds){
		redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
	}
	
	//获取值
	public String get(String key){
		return redisTemplate.opsForValue().get(key).toString();
	}
}
