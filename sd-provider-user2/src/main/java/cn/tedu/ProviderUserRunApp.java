package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fhy
 * time:2019/7/11
 * Eureka的客户端，启动程序需要在需要扫描的包的上一层，比如cn.tedu是所有子包的父包
 */
@EnableEurekaClient
@SpringBootApplication
public class ProviderUserRunApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderUserRunApp.class, args);
	}
}
