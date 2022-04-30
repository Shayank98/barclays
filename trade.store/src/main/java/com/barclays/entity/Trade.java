package com.barclays.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="trade")
@AllArgsConstructor
@NoArgsConstructor
public class Trade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="trade_id")
	private String tradeId;
	
	@Column(name="version")
	private int version;
	
	@Column(name="counterparty_id")
	private String counterPartyId;
	
	@Column(name="book_id")
	private String bookId;
	
	@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	@Column(name="maturity_date")
	private LocalDate maturityDate;
	
	@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="expired")
	private String expired;
}
