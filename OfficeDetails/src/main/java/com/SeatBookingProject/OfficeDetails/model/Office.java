package com.SeatBookingProject.OfficeDetails.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Office {
	
	@Id
	@Email()
	private String adminemailId;
	@NotNull()
	private String adminName;
	@Size(min=10,max=300)
	private String location;
	@NotNull
	private int floorDeatils;
	@Max(50)
	@Min(1)
	private int  seatingCapacity;
	private int availableSpaces;
	private String password;
	
	public Office()
	{
		
	}

	public String getAdminemailId() {
		return adminemailId;
	}

	public void setAdminemailId(String adminemailId) {
		this.adminemailId = adminemailId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public int getFloorDeatils() {
		return floorDeatils;
	}

	public void setFloorDeatils(int floorDeatils) {
		this.floorDeatils = floorDeatils;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public int getAvailableSpaces() {
		return availableSpaces;
	}

	public void setAvailableSpaces(int availableSpaces) {
		this.availableSpaces = availableSpaces;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
