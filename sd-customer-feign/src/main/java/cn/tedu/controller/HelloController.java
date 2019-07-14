package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.feign.HelloFeign;

@RestController
public class HelloController {

	@Autowired
	private HelloFeign helloFeign;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name){
		return helloFeign.hello(name);
	}
}
