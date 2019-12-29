package com.mircrServ.currencyexchangeservice.controler;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mircrServ.currencyexchangeservice.Repo.CurrExchgRepository;
import com.mircrServ.currencyexchangeservice.dto.CurrExchangeVal;

@RestController
public class CurrencyExchangeServiceCntrl {
	
	@Autowired
	private org.springframework.core.env.Environment environment;
	
	@Autowired
	private CurrExchgRepository currReposiotry;
	
	@GetMapping("/Curr-Excg-Serv/from/{from}/to/{to}")
	public CurrExchangeVal retriveExchangeVal(@PathVariable String from,@PathVariable String to) {
		CurrExchangeVal exchgVal=new CurrExchangeVal(100L,from,to,BigDecimal.valueOf(65));
		exchgVal=currReposiotry.findByFromAndTo(from,to);
		exchgVal.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchgVal;
	}

}
