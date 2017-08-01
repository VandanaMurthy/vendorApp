package org.accion;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.accion.entity.Vendor;
import org.accion.repository.VendorRepository;
import org.accion.service.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

//Unit Testing with @MockBean
public class TestMethod2 extends  VendorManagementApplicationTests{
	
	@TestConfiguration
    static class VendorServiceImplTestContextConfiguration {
  
        @Bean
        public VendorService vendorService() {
            return new VendorService();
        }
    }
	@Autowired
	private VendorService vendorService;
	
	@MockBean
	private VendorRepository vendorRepository;
	@Before
	public void setUp() {
	    Vendor vendor = new Vendor(3000,"MSA","Data Sources",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
	 
	    Mockito.when(vendorRepository.findByName(vendor.getName()))
	      .thenReturn(vendor);
	}
	@Test
	public void whenValidName_thenVendor() {
	    String expected = "MSA";
	    Vendor ven = vendorService.findVendorByName(expected);
	  
	     assertThat(ven.getName())
	      .isEqualTo(expected);
	 }
	@Before
	public void setUpCategory() {
	    Vendor vendor = new Vendor(5000,"ABC","Data",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
	 
	    Mockito.when(vendorRepository.findByCategory(vendor.getCategory()))
	      .thenReturn(vendor);
	}
	@Test
	public void whenValidCategory_thenVendor() {
	    String category = "Data";
	    Vendor ven = vendorService.findByCategory(category);
	  
	     assertThat(ven.getCategory())
	      .isEqualTo(category);
	 }
	@Before
	public void setUpId() {
	    Vendor vendor = new Vendor(5000,"XYZ","Services",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
	 
	    Mockito.when(vendorRepository.findById(vendor.getId()))
	      .thenReturn(vendor);
	}
	@Test
	public void whenValidId_thenVendor() {
	    int id = 5000;
	    Vendor ven = vendorService.findById(id);
	  
	     assertThat(ven.getId())
	      .isEqualTo(id);
	 }
	@Before
	public void setUpVendors(){
		List<Vendor> vendors=new ArrayList<Vendor>();
		Vendor v1=new Vendor(100,"ABC","XYZ",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
		Vendor v2=new Vendor(200,"DEF","UVW",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
		vendors.add(v1);
		vendors.add(v2);
		 Mockito.when(vendorRepository.findAll())
	      .thenReturn((ArrayList<Vendor>) vendors);
		}
	@Test
	public void whenFindAll_thenVendors() {
	    List<Vendor> ven=new ArrayList<Vendor>();
	    Vendor v3=new Vendor(100,"ABC","XYZ",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
		Vendor v4=new Vendor(200,"DEF","UVW",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
		ven.add(v3);
		ven.add(v4);
	     List<Vendor> ven1 = vendorService.findAll();
	     
	  
	     assertThat(ven1)
	      .isEqualTo(ven1);
	 }
	
	
}
