package com.barclays.cron;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.barclays.entity.Trade;
import com.barclays.repo.TradeRepo;

public class TradeCron {

	@Autowired
	TradeRepo tradeRepo;
	
	 @Scheduled(cron = "0 12 * * ?")
	   public void cronJobSch() {
		 List<Trade> tradeList = tradeRepo.findAll();
		 tradeList.forEach(trade -> {
			 if(LocalDateTime.now().compareTo(trade.getMaturityDate()) > 0) {
				 trade.setExpired("N");
				 tradeRepo.save(trade);
			 }
		 });
	   }	
	 
	 
	
}
