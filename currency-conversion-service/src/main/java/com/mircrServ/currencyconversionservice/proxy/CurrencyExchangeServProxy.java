package com.mircrServ.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mircrServ.currencyconversionservice.dto.CurrConversionDTO;

@FeignClient(name="currency-exchange-service",url="localhost:8000")
public interface CurrencyExchangeServProxy {

	@GetMapping("/Curr-Excg-Serv/from/{from}/to/{to}")
	public CurrConversionDTO retriveExchangeVal(@PathVariable("from") String from,@PathVariable("to") String to);
}
