package com.barclays.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.barclays.entity.Trade;

@EnableJpaRepositories
@Repository
public interface TradeRepo extends JpaRepository<Trade, String>{
	
	public boolean existsByVersionLessThan(int version);
	
	@Query(value = "Select Count(*) from trade", nativeQuery= true)
	public int findCount();
	
	public List<Trade> findAll();

}
