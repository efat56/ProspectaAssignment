package com.prospecta.exception;

public class InvalidEntryException extends Exception {
	
	public InvalidEntryException( ){
		
	}
	
	public  InvalidEntryException(String msg) {
		super(msg);
	}

}
