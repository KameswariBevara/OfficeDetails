package com.SeatBookingProject.OfficeDetails.dao;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.SeatBookingProject.OfficeDetails.model.BookingDetails;

@Repository
public interface BookingDAO {
	 public void addBooking(BookingDetails booking);
	 public BookingDetails findBooking(int BookingId);
	 public List<BookingDetails> findAllBooking();
	 public boolean updateBooking(BookingDetails booking);
	 public boolean deleteBooking(int BookingId);

	

}
