package com.mircrServ.currencyconversionservice.cntrl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mircrServ.currencyconversionservice.dto.CurrConversionDTO;

@RestController
public class CurrConvServControler {
	
	@Autowired
	private org.springframework.core.env.Environment environment;
	

	@GetMapping("/CurrConverter")
	public CurrConversionDTO ConverionService() {
//		CurrConversionDTO conversionDTO=new CurrConversionDTO();
//		conversionDTO.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return new CurrConversionDTO((long) 100,"USD","INR",BigDecimal.valueOf(10),BigDecimal.valueOf(650),
				Integer.parseInt(environment.getProperty("local.server.port")),BigDecimal.valueOf(65));
	}
}
