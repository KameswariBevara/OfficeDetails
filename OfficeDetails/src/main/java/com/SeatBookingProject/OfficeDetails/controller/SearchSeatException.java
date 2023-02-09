package com.SeatBookingProject.OfficeDetails.controller;
public class SearchSeatException  extends RuntimeException{
	private int id;
	public SearchSeatException(int id) {
		
		super("id "+id+" not found");
		this.id=id;
	}

	@Override
	public String toString() {
		return "Seat "+ "is" +" not available";
	}


}
