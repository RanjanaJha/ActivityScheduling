package com.deloitte.digital.away.day.exception;

public class SchedulerException extends RuntimeException{

	private static final long serialVersionUID = 3166300545997771569L;
	
	String message = "";
	
	public SchedulerException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	
}
