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

import com.SeatBookingProject.OfficeDetails.dao.SeatService;
import com.SeatBookingProject.OfficeDetails.model.*;

@RestController
public class SeatRestController {
	
	@Autowired
	SeatService service;
	
	
	 @GetMapping("/findAll/")
	   public List<Seat> getAllSeat()
	   
	   {
		  
		   return service.findAll();
	   }
	 @GetMapping("/findAll/{id}")
	 public ResponseEntity<?> findAllSeat(@PathVariable int id) 
	   
	   { 
		 Seat s1=service.find(id);
		  if(s1==null) {
			  throw new SearchSeatException(id);
		  }
		  
		    service.findAll();
		    return ResponseEntity.ok("Seat is available");
	   }
	 
	 @PostMapping("/bookSeat")
	   public ResponseEntity<?> bookSeat(@RequestBody Seat s) 
	   {
		     float duration;
			int id=0;
			Seat s1=service.find(id);
		     if(s.getDuration()>12)
		     {
				 throw new BookSeatException(s);
					
				}
		     
		
		service.add(s);
		return ResponseEntity.status(HttpStatus.OK).body("Seat Booked Successfully for " +s.getDuration()+ "Hrs");
		
	   }
	
	 @DeleteMapping("/deleteSeat/{id}")
	   public ResponseEntity<?> deleteSeat(@PathVariable int id)throws DeleteSeatException 
	   {
		   Seat s=service.find(id);
		   if(s==null)
		   {
			   
			    throw new DeleteSeatException(id);
		   }
		
		     	   service.delete(id);   
		      return ResponseEntity.ok("Seat deleted successfully");
	   }
	 
	  @GetMapping("/searchSeat/{id}")
	  public ResponseEntity<?> searchSeat(@PathVariable int id)throws SearchSeatException
	  {
		  Seat s1=service.find(id);
		  if(s1==null) {
			  throw new SearchSeatException(id);
		  }
		  service.find(s1.getSeatId());
		  return ResponseEntity.ok("Seat  for the office "+ " "+s1.getOffice()+" and for the floor "+s1.getFloor()+" "+ " and for the location "+"  "+s1.getLocation()+" "+ "is available");
	  }
	  
	  
	  @PostMapping("/cancelSeat")
	  public ResponseEntity<?> cancelSeat(@RequestBody Seat s) 
	   {
		    
			int id=0;
			Seat s1=service.find(id);
		     if(s.getSeatNo()>500)
		     {
				 throw new BookCancelException(s);
					
				}     
		     
		    
		    service.add(s);
		     
			return ResponseEntity.ok("Cancellation request  not sent" );
		     
		     }
	 @PatchMapping("/updateSeat")
	 public ResponseEntity<?> updateSeat(@RequestBody Seat s) 
	   {
		    
			
			Seat s1=service.find(s.getSeatId());
			if(s1==null) {
				
				throw new UpdateSeatException();
				
			}
		service.update(s);
		return ResponseEntity.ok("  Seat Updated  Successfully ");
		
	   }
	 
	/* @PatchMapping("/swapSeat")
	   public ResponseEntity<?> swapSeat(@RequestBody Seat s){
		Seat s1=service.find(s.getSeatNo());
		if(s.getSeatNo()==0) {
			throw new SwapSeatRequestException();
		}
		service.swap(s);
	  return ResponseEntity.ok("  Swap Request sent  Successfully ");
		 
	 }*/


}
