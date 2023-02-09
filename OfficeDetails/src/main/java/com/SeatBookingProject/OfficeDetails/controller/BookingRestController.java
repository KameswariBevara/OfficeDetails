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

import com.SeatBookingProject.OfficeDetails.dao.BookingService;
import com.SeatBookingProject.OfficeDetails.model.BookingDetails;
import com.SeatBookingProject.OfficeDetails.model.Office;

@RestController
public class BookingRestController {
	
	@Autowired
	BookingService service;
	
	@GetMapping("/getbooking")
	public List<BookingDetails> getAllBookings()
	{
		return service.findAll();
	}
	@PostMapping("/addbooking")
	public ResponseEntity<?> addtickets(@RequestBody BookingDetails booking) throws AddBookingException 	{
		if(booking==null) {
			throw new AddOfficeException();
		}
		service.add(booking);
		return ResponseEntity.status(HttpStatus.OK).body("Entity office details added successfully");
	}
	@DeleteMapping("/deletebooking/{BookingId}")
	public ResponseEntity<?> deletebooking(@PathVariable int BookingId) throws DeleteBookingException
	{
		BookingDetails booking=service.find(BookingId);
		if(booking==null)
		{
			throw new DeleteBookingException(BookingId);
			
		}
		service.delete(BookingId);
		return ResponseEntity.ok("details deleted successfully");
	}
	@PatchMapping("/updatebooking")
	public ResponseEntity<?> updatebooking(@RequestBody BookingDetails booking)throws UpdateBookingException
	{
		if(booking==null)
		{
			throw new UpdateBookingException();
		}
		service.update(booking);
		return ResponseEntity.ok("updated successfully");
		
	}

}
