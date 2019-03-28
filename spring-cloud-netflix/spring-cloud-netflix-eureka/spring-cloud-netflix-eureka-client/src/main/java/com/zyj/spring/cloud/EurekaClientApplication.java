package com.zyj.spring.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @EnableEurekaClient与@EnableDiscoveryClient
 * 这个两个注解都可以实现服务发现的功能
 * 在spring cloud中discoveryservice有许多种实现（eureka、consul、zookeeper等等）
 * 
 * @EnableEurekaClient基于spring-cloud-netflix，服务采用eureka作为注册中心，使用场景较为单一。
 * 
 * @EnableDiscoveryClient基于spring-cloud-commons， 服务采用其他注册中心。
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

}
