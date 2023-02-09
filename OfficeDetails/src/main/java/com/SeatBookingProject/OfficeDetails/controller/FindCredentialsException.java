package com.SeatBookingProject.OfficeDetails.controller;

public class FindCredentialsException extends RuntimeException{
	
	public FindCredentialsException() {
		super("incorrect username and password");
	}

	@Override
	public String toString() {
		return "FindCredentialsException";
	}
	
	
	

}
