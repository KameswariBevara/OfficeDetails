package com.SeatBookingProject.OfficeDetails.dao;

import org.springframework.stereotype.Repository;

import com.SeatBookingProject.OfficeDetails.model.Admin;

@Repository
public interface AdminDAO {
	 public void addAdmin(Admin admin);
	 public Admin findAdmin(String adminName);
	 public boolean updateAdmin(Admin admin);
	 public boolean deleteAdmin(String adminName);
	 
	 

}
