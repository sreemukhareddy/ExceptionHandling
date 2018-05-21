package com.nisum.DemoExceptionHandling;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeNotFoundException extends Exception{
	
	String message;
	int id;

	public EmployeeNotFoundException(String message,int id) {
		//super(message,id);
		this.id=id;
		this.message = message;
	}
	
	public String toString() {
		return "hey Y0u've entered wrong details mate " + id;
	}
	
	

}
