package com.SeatBookingProject.OfficeDetails.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class SeatRestExceptionController {
	@ExceptionHandler(DeleteSeatException.class)
    public ResponseEntity<?> handleDeleteException(DeleteSeatException e,WebRequest req)
    {
	
		
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		
    }
	@ExceptionHandler(SearchSeatException.class)
    public ResponseEntity<?> handleFindException(SearchSeatException e,WebRequest req)
    {
	
		
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		
    }
	@ExceptionHandler(BookSeatException.class)
    public ResponseEntity<?> handleBookSeatException(BookSeatException e,WebRequest req)
    {
	
		
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		
    }
	@ExceptionHandler(BookCancelException.class)
    public ResponseEntity<?> handleBookCancelException(BookCancelException e,WebRequest req)
    {
	
		
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		
    }
	@ExceptionHandler(UpdateSeatException.class)
    public ResponseEntity<?> handleUpdateSeatException(UpdateSeatException e,WebRequest req)
    {
	
		
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		
    }
	@ExceptionHandler(SwapSeatRequestException.class)
    public ResponseEntity<?> handleSwapSeatRequestException(SwapSeatRequestException e,WebRequest req)
    {
	
		
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		
    }


}
