package com.SeatBookingProject.OfficeDetails.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.SeatBookingProject.OfficeDetails.model.Seat;
@Repository
public interface SeatDAO {
	public void bookSeat(Seat s);
	public Seat searchSeat(int id);
	public List<Seat> findAllSeat();
	public boolean updateSeat(Seat s);
	public boolean deleteSeat(int id);
	public void cancelSeat(Seat s);
	public void swapSeat(Seat s);


}
