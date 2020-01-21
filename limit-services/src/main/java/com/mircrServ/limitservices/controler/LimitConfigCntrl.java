package com.mircrServ.limitservices.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mircrServ.limitservices.configs.PropsConfigurations;
import com.mircrServ.limitservices.dto.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitConfigCntrl {

	@Autowired
	private PropsConfigurations config;

	@GetMapping("/Limits")
	public LimitConfiguration retriveLimit() {
		return new LimitConfiguration(100,1);
	}

//	@GetMapping("/fault-tolerance-limits")
//	@HystrixCommand(fallbackMethod="fallbackRetriveConfig")
//	public LimitConfiguration retriveLimiFaultTol() {
//		throw new RuntimeException("Unavailable");
//	}
//	
//	public LimitConfiguration fallbackRetriveConfig() {
//		return new LimitConfiguration(9999,88);
//	}
	
	@GetMapping("/ConifigLimits")
	public LimitConfiguration retriveLimitFromConfig() {
		return new LimitConfiguration(config.getMaximum(),config.getMinimum());
	}
	
}
