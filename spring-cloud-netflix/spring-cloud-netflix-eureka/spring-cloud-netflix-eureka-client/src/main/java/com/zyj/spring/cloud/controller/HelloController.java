package com.zyj.spring.cloud.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String index() {
		String serviceId = "eureka-client";
		List<ServiceInstance> instanceList = client.getInstances(serviceId);
		logger.info(
				"hello, host:" + instanceList.get(0).getHost() + ", service_id:" + instanceList.get(0).getServiceId());
		return "Hello World";

	}

}
