package com.SeatBookingProject.OfficeDetails.controller;
public class SwapSeatRequestException  extends RuntimeException{
	
	public SwapSeatRequestException() {
		super("Swap Request Cannot be sent");	
		}

		@Override
		public String toString() {
			return "Swap Request Cannot  be sent";
		}

}
