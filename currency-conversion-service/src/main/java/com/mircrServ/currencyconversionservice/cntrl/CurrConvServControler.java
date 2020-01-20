package com.mircrServ.currencyconversionservice.cntrl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mircrServ.currencyconversionservice.dto.CurrConversionDTO;
import com.mircrServ.currencyconversionservice.proxy.CurrencyExchangeServProxy;

@RestController
public class CurrConvServControler {
	
	@Autowired
	private org.springframework.core.env.Environment environment;
	
	@Autowired
	private CurrencyExchangeServProxy currExchgServProxy;
	
	private Logger logger=org.slf4j.LoggerFactory.getLogger(this.getClass());
	

	@GetMapping("/CurrConverter/from/{from}/to/{to}/quanitiy/{quanitiy}")
	public CurrConversionDTO ConverionService(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quanitiy) {
		
		Map<String,String> uriVariable=new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		
		ResponseEntity<CurrConversionDTO> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/Curr-Excg-Serv/from/{from}/to/{to}", CurrConversionDTO.class,uriVariable);
		CurrConversionDTO response = responseEntity.getBody();
		
		
		CurrConversionDTO conversionDTO=new CurrConversionDTO(response.getId(),from,to,quanitiy,quanitiy.multiply(response.getConversionVal()),
				Integer.parseInt(environment.getProperty("local.server.port")),response.getConversionVal());
		
		return conversionDTO;
	}
	
	
	@GetMapping("/CurrConverter-feign/from/{from}/to/{to}/quanitiy/{quanitiy}")
	public CurrConversionDTO ConverionServiceFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quanitiy) {

		CurrConversionDTO response = currExchgServProxy.retriveExchangeVal(from, to);
		
		logger.info("{}",response);
		CurrConversionDTO conversionDTO=new CurrConversionDTO(response.getId(),from,to,quanitiy,quanitiy.multiply(response.getConversionVal()),
				response.getPort(),response.getConversionVal());
		
		System.out.println("Load Balancer Port::: "+response.getPort());
		logger.info("{}",response.getPort());
		
		return conversionDTO;
	}
	
	
}
