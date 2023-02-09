package com.SeatBookingProject.OfficeDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SeatBookingProject.OfficeDetails.dao.OfficeService;
import com.SeatBookingProject.OfficeDetails.model.Office;

@RestController
public class OfficeRestController {
	
	@Autowired
	OfficeService service;
	
	@GetMapping("/getoffice")
	public List<Office> getAllOffice()
	{
		return service.findAll();
	}
	@PostMapping("/addoffice")
	public ResponseEntity<?> addOffice(@RequestBody Office office) throws AddOfficeException
	{
		if(office==null) {
			throw new AddOfficeException();
		}
		service.add(office);
		return ResponseEntity.status(HttpStatus.OK).body("Entity office details added successfully");
	}
	@DeleteMapping("/deleteoffice/{adminemailId}")
	public ResponseEntity<?> deleteOffice(@PathVariable String adminemailId) throws DeleteOfficeException
	{
		Office office=service.find(adminemailId);
		if(office==null)
		{
			throw new DeleteOfficeException(adminemailId);
			
		}
		service.delete(adminemailId);
		return ResponseEntity.ok("details deleted successfully");
	}
	@PatchMapping("/updateoffice")
	public ResponseEntity<?> updatedetails(@RequestBody Office office)throws UpdateOfficeException
	{
		if(office==null)
		{
			throw new UpdateOfficeException();
		}
		service.update(office);
		return ResponseEntity.ok("updated successfully");
		
	}
	
		
		
}
