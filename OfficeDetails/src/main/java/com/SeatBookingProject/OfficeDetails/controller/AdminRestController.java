package com.SeatBookingProject.OfficeDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SeatBookingProject.OfficeDetails.dao.AdminService;
import com.SeatBookingProject.OfficeDetails.model.Admin;
import com.SeatBookingProject.OfficeDetails.model.Office;

@RestController
public class AdminRestController {
	
	@Autowired
	AdminService service;
	
	@GetMapping("/addcredentials")
	public ResponseEntity<?> add(@RequestBody Admin admin) throws AddCredentialsException
	{
		if(admin==null)
		{
			throw new AddCredentialsException();
			
		}
		service.add(admin);
		return ResponseEntity.ok("credentilas added");
	}
	@GetMapping("/findcredentials")
	public ResponseEntity<?> find(@RequestBody Admin admin) throws FindCredentialsException
	{
		String kameswari;
		String password = null;
		if(password!="kameswari@123")
		{
			throw new FindCredentialsException();
		}
		service.find(password);
		return ResponseEntity.ok("welcome to homepage");
	}
	@DeleteMapping("/deleteadmin/{adminName}")
	public ResponseEntity<?> delete(@PathVariable String adminName) throws DeleteCredentialsException
	{
		Admin admin=service.find(adminName);
		if(admin==null)
		{
			throw new DeleteOfficeException(adminName);
			
		}
		service.delete(adminName);
		return ResponseEntity.ok("details deleted successfully");
	}
	@PatchMapping("/updateadmin")
	public ResponseEntity<?> updatedetails(@RequestBody Admin admin)throws UpdateCredentialsException
	{
		if(admin==null)
		{
			throw new UpdateCredentialsException();
		}
		service.update(admin);
		return ResponseEntity.ok("updated successfully");
		
	}

}
