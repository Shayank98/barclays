package com.barclays.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.barclays.entity.Trade;
import com.barclays.exception.MyException;

@Component
public interface TradeService {
	public String addTrade(String tradeId, int version, String counterPartyId,
	String bookId, LocalDate maturityDate,LocalDateTime createdAt,  String expired) throws MyException;
}
