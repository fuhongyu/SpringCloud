package util;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.andrewoma.dexx.collection.Map;

import cn.jt.pojo.User;

public class TestJson {
	//引入jackson
	private ObjectMapper MAPPER = new ObjectMapper();
	
	public static void main(String[] args) throws Exception {
		//把Java对象转成json字符串
		User user = new User();
		user.setId(1);
		user.setUsername("tony");
		user.setPhone("123123123123");
		user.setEmail("chenzs@tedu.cn");
		user.setCreated(new Date());
		user.setUpdated(new Date());
		
		TestJson tj = new TestJson();
		String userJson = tj.MAPPER.writeValueAsString(user);
		System.out.println(userJson);
		
		//{"id":1,"username":"tony","password":null,"phone":"123123123123","email":"chenzs@tedu.cn","created":1562922024446,"updated":1562922024446}
		
		String json = "{\"id\":1,\"username\":\"tony\",\"password\":null,\"phone\":\"123123123123\",\"email\":\"chenzs@tedu.cn\",\"created\":1562922024446,\"updated\":1562922024446}";
		//反序列化，把json变成java对象
		User u = tj.MAPPER.readValue(json, User.class);
		System.out.println(u);
	}
}







