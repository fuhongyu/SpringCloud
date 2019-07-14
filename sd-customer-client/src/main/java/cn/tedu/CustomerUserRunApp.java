package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class CustomerUserRunApp {
	//创建RestTemplate对象实例
	@Bean
	@LoadBalanced //负载均衡 ribbon，默认就有了
	public RestTemplate restTemplate(){
		return new RestTemplate();//创建实例
	}
	public static void main(String[] args) {
		SpringApplication.run(CustomerUserRunApp.class, args);
		
	}
}
