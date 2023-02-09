package com.SeatBookingProject.OfficeDetails.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SeatBookingProject.OfficeDetails.model.Office;
@Component
public class OfficeDAOImpl implements OfficeDAO {
	
	@Autowired
	SessionFactory sessionfactory; 

	@Override
	public void addOffice(Office office) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.getTransaction().begin();
		session.save(office);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Office findOffice(String emailId) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Office office=session.find(Office.class,emailId);
		
		return office;
	}

	@Override
	public List<Office> findAllOffice() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		List<Office> office=session.createQuery("select i from Office i").list();
		return office;
	}

	@Override
	public boolean updateOffice(Office office) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.getTransaction().begin();
		session.update(office);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteOffice(String emailId) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Office office=session.find(Office.class, emailId);
		session.getTransaction().begin();
		session.delete(office);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
