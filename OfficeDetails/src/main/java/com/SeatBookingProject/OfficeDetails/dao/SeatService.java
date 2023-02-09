package com.SeatBookingProject.OfficeDetails.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SeatBookingProject.OfficeDetails.model.Seat;
@Service
public class SeatService {
	@Autowired
	SeatDAO seatDAOImpl;

	public void add(Seat s) {
		 seatDAOImpl.bookSeat(s);
		
	}
	public Seat find(int id) {
		return seatDAOImpl.searchSeat(id);
	}
	public List<Seat> findAll(){
		return seatDAOImpl.findAllSeat();
	}
	public boolean update(Seat s) {
		return seatDAOImpl.updateSeat(s);
	}
	public boolean delete(int id) {
		return seatDAOImpl.deleteSeat(id);

}
	public void cancel(Seat s) {
		seatDAOImpl.cancelSeat(s);
	}
	public void swap(Seat s) {
		seatDAOImpl.swapSeat(s);
	}


}
