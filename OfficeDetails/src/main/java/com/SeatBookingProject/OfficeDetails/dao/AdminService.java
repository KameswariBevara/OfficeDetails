package com.SeatBookingProject.OfficeDetails.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SeatBookingProject.OfficeDetails.model.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminDAO adminDAOImpl;

	public void add(Admin admin) {
		adminDAOImpl.addAdmin(admin);
		
	}
	public Admin find(String adminName) {
		return adminDAOImpl.findAdmin( adminName);
	}
	
	public boolean update(Admin admin) {
		return adminDAOImpl.updateAdmin(admin);
	}
	public boolean delete(String adminName) {
		return adminDAOImpl.deleteAdmin(adminName);
	}

}
