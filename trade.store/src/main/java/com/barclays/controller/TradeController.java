package com.barclays.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.exception.MyException;
import com.barclays.service.TradeService;

@RestController
public class TradeController {

	@Autowired
	TradeService tradeService;
	
	@GetMapping("/addTrade")
	public String  addTrade(@RequestParam("tradeId") String tradeId, @RequestParam("version") String version ,
			@RequestParam("counterPartyId") String counterPartyId,
			@RequestParam("bookId") String bookId,
			@RequestParam("maturityDate") String maturityDate, @RequestParam("expired") String expired) throws ParseException, NumberFormatException, MyException 
	{

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateTime = LocalDate.parse(maturityDate, formatter);

		String output = tradeService.addTrade(tradeId, Integer.parseInt(version), counterPartyId, bookId,dateTime ,LocalDateTime.now(), expired);
		return output;
	}
}
