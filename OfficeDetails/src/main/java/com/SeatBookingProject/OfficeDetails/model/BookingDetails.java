package com.SeatBookingProject.OfficeDetails.model;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Entity

public class BookingDetails {
	@Id
	@GeneratedValue
	private int BookingId;
	@NotNull
	private int BookingDate;
	private int Seatnumber;
	@Max(1000)
	@Min(100)
	private int Seatcost;
	private String Seattype;
	@NotNull
	private String Seatcolour;
	
    public BookingDetails() {
		
	}
    
    public int getBookingId() {
    	return BookingId;
    }
    
    public void setBookingId(int BookingId) {
    	this.BookingId=BookingId;
    }
    
    public int getBookingDate() {
    	return BookingDate;
    }
    
    public void setBookingDate(int BookingDate) {
    	this.BookingDate=BookingDate;
    }

	public int getSeatnumber() {
		return Seatnumber;
	}

	public void setSeatnumber(int Seatnumber) {
		this.Seatnumber = Seatnumber;
	}

	public int getSeatcost() {
		return Seatcost;
	}

	public void setSeatcost(int Seatcost) {
		this.Seatcost = Seatcost;
	}

	public String getSeattype() {
		return Seattype;
	}

	public void setSeattype(String Seattype) {
		this.Seattype = Seattype;
	}
	
	public String getSeatcolour() {
		return Seatcolour;
	}
	
	public void setSeatcolour(String Seatcolour) {
		this.Seatcolour = Seatcolour;
	}



}
