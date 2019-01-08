package com.zyj.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

	@Autowired
	private Environment env;

	@Value("${from}")
	private String from;

	@RequestMapping("/from")
	public String from() {
		System.out.println(env.getProperty("from", "undefined"));
		return this.from;
	}

}
