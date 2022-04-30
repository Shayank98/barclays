package com.barclays.exception;

import lombok.Data;

@Data
public class MyException extends Exception{

	String msg;
	public MyException(String msg) {
		this.msg = msg;
	}
	
}
