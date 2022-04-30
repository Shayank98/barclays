package com.barclays.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.entity.Trade;
import com.barclays.exception.MyException;
import com.barclays.repo.TradeRepo;
import com.barclays.service.TradeService;

@Component
public class TradeServiceImpl implements TradeService{

	@Autowired
	TradeRepo tradeRepo;

	
	@Override
	public String addTrade(String tradeId, int version, String counterPartyId, String bookId, LocalDate maturityDate, LocalDateTime createdAt,String expired) throws MyException {
		// TODO Auto-generated method stub
		Trade flag = null;
		
		//If this is the first row then we will not check version
		if(tradeRepo.findCount() == 0) {
			if(LocalDate.now().compareTo(maturityDate) > 0) {
				throw new MyException("Maturity date is lesser then today's date");
			}
			else {
				Trade trade = new Trade();
				trade.setBookId(bookId);
				trade.setTradeId(tradeId);
				trade.setVersion(version);
				trade.setCounterPartyId(counterPartyId);
				trade.setMaturityDate(maturityDate);
//				trade.setCreatedDate(createdDate);
				trade.setExpired(expired);
				flag = tradeRepo.save(trade);
			}
		}
		else if((tradeRepo.existsByVersionLessThan(version))) {
			if(LocalDate.now().compareTo(maturityDate) > 0) {
				throw new MyException("Maturity date is lesser then today's date");
			}
			else {
				Trade trade = new Trade();
				trade.setBookId(bookId);
				trade.setTradeId(tradeId);
				trade.setVersion(version);
				trade.setCounterPartyId(counterPartyId);
				trade.setMaturityDate(maturityDate);
//				trade.setCreatedDate(createdDate);
				trade.setExpired(expired);
				flag = tradeRepo.save(trade);
			}
		}
		else {
			throw new MyException("Version i outdated");
		}
		if(flag != null)
			return "success";
//			boolean output = tradeRepo.existsByVersionLessThan(version,1);
		return "failed";
	}

}
