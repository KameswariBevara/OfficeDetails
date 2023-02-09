package com.SeatBookingProject.OfficeDetails.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SeatBookingProject.OfficeDetails.model.BookingDetails;

import java.util.*;

@Component

public class BookingDAOImpl implements BookingDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addBooking(BookingDetails booking) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(booking);
		session.flush();
		session.getTransaction().commit();
		

	}

	@Override
	public BookingDetails findBooking(int BookingId) {
		Session session=sessionFactory.openSession();
		BookingDetails booking=session.find(BookingDetails.class, BookingId);
		
		return booking;
	}

	@Override
	public List<BookingDetails> findAllBooking() {
		Session session=sessionFactory.openSession();
		List<BookingDetails> bookinglist=session.createQuery("select i from BookingDetails i").list();
		
		return bookinglist;
	}

	@Override
	public boolean updateBooking(BookingDetails booking) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(booking);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteBooking(int BookingId) {
		Session session=sessionFactory.openSession();
		BookingDetails booking=session.find(BookingDetails.class, BookingId);
		session.getTransaction().begin();
		session.delete(booking);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return true;
	}


}
