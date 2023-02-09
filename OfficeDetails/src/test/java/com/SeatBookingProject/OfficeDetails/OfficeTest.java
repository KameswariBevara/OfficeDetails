package com.SeatBookingProject.OfficeDetails;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.SeatBookingProject.OfficeDetails.dao.OfficeService;
import com.SeatBookingProject.OfficeDetails.model.Office;

import junit.framework.Assert;
@SpringBootTest
class OfficeTest {
	@Autowired
	OfficeService service;

	@Test
	void testAdd() {
		 
		Office office=new Office();
		office.setAdminName("vickky");
		office.setAdminemailId("vickky@gmail.com");
		office.setFloorDeatils(5);
		office.setLocation("Bangalore rural");
		office.setAvailableSpaces(5);
		office.setSeatingCapacity(6);
		office.setPassword("vikky@123");
		service.add(office);
		
		Office office_to_be_tested=service.find(office.getAdminemailId());
		Assert.assertEquals("vickky",office_to_be_tested.getAdminName());
		Assert.assertEquals("vickky@gmail.com", office.getAdminemailId());
		Assert.assertEquals(5, office_to_be_tested.getFloorDeatils() );
		Assert.assertEquals("Bangalore rural", office_to_be_tested.getLocation());
		Assert.assertEquals(5, office_to_be_tested.getAvailableSpaces());
		Assert.assertEquals(6, office_to_be_tested.getSeatingCapacity());
		Assert.assertEquals("vikky@123", office_to_be_tested.getPassword());
		
		
		
		
	}

	@Test
	void testFind() {
		Office officedetails=new Office();
		officedetails.setAdminemailId("nhhs@gmail.com");
		try
		{
			service.add(officedetails);
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		Office officedetails1=service.find(officedetails.getAdminemailId());
		Assert.assertNull(officedetails1);
		
	}

	@Test
	void testFindAll() {
		Office office=new Office();
		office.setAdminemailId("abc@gmail.com");
		office.setAdminName("KTM");
		office.setAvailableSpaces(4);
		office.setFloorDeatils(6);
		office.setLocation("hoskote kalkunte");
		office.setPassword("ktm@123");
		office.setSeatingCapacity(6);
		service.add(office);
        
		Office office1=new Office();
		office1.setAdminemailId("ghfh@gmail.com");
		office1.setAdminName("honda");
		office1.setAvailableSpaces(9);
		office1.setFloorDeatils(7);
		office1.setLocation("bangalore north");
		office1.setPassword("honda@123");
		office1.setSeatingCapacity(4);
		service.add(office1);
		
		List<Office> officelist=service.findAll();
		Assert.assertEquals(officelist.get(0).getAdminName(),"vickky" );
		Assert.assertEquals(officelist.get(1).getAdminName(), "KTM");
		Assert.assertEquals(officelist.get(2).getAdminName(), "honda");
	}

	@Test
	void testUpdate() {
		Office office=new Office();
		office.setAdminName("kawasaki");
		office.setAdminemailId("ncnc@gmail.com");
		office.setAvailableSpaces(3);
		office.setFloorDeatils(2);
		office.setLocation("chennai east");
		office.setPassword("bcvc@123");
		office.setSeatingCapacity(8);
        service.add(office);
        office.setAdminemailId("abc@gmail.com");
        service.update(office);
        Assert.assertEquals(true, service.update(office));
	}

    @Test
	void testDelete() {
    	
    	service.delete("ghfh@gmail.com");
    	Office office=service.find("ghfh@gmail.com");
    	Assert.assertNull(office);
	}

}
