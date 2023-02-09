package com.SeatBookingProject.OfficeDetails.controller;
import com.SeatBookingProject.OfficeDetails.model.Seat;

public class BookCancelException extends RuntimeException {
	private static int id;
	private Object seatNo=null;
	
	public BookCancelException(Seat s) {
		
		
		super("seatType not available");
		this.seatNo=seatNo;
		
	
		
	}

	@Override
	public String toString() {
		return  "Cancellation Request sent to Admin";
	}


}
