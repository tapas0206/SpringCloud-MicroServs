package com.mircrServ.currencyexchangeservice.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mircrServ.currencyexchangeservice.dto.CurrExchangeVal;

public interface CurrExchgRepository extends JpaRepository<CurrExchangeVal, Long> {

	CurrExchangeVal findByFromAndTo(String from,String to);
}
