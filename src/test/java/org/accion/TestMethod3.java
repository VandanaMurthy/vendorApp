package org.accion;

import static org.hamcrest.Matchers.*;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;

import org.accion.controller.VendorController;
import org.accion.entity.Vendor;
import org.accion.service.VendorService;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
@RunWith(SpringRunner.class)
@WebMvcTest(VendorController.class)

//Unit Testing with @WebMvcTest(With Mock objects)
public class TestMethod3 {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private VendorService vendorService;

	@Test
	public void givenVendors_whenGetVendors_thenReturnJsonArray()
	  throws Exception {
	     
	    Vendor vendor1 = new Vendor(3000,"Rackspace","Produts",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
	    Vendor vendor2 = new Vendor(7000,"Infoglen","Services",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
	 
	    ArrayList<Vendor> allVendors = new ArrayList<Vendor>();
	    allVendors.add(vendor1);
	    allVendors.add(vendor2);
	 
	    when(vendorService.findAll()).thenReturn((ArrayList<Vendor>) allVendors);
	 
	    mvc.perform(get("/vendor/getAllVendors")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(2)))
	      .andExpect(jsonPath("$[1].name", is(vendor2.getName())));
	 
}
	@Test
	public void givenVendor_whenGetById_thenReturnVendor()
	  throws Exception{
		 Vendor vendor1 = new Vendor(3000,"Rackspace","Produts",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
		 when(vendorService.findById(3000)).thenReturn(vendor1);
		 mvc.perform(get("/vendor/getById/{id}",3000)
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.id", is(3000)))
			      .andExpect(jsonPath("$.name", is("Rackspace")));
		 
	}
	@Test
	public void givenVendor_whenGetByName_thenReturnVendor()
	  throws Exception{
		 Vendor vendor1 = new Vendor(3000,"Rackspace","Produts",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
		 when(vendorService.findVendorByName("Rackspace")).thenReturn(vendor1);
		 mvc.perform(get("/vendor/getByName/{name}","Rackspace")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.id", is(3000)))
			      .andExpect(jsonPath("$.name", is("Rackspace")));
		 
	}
	@Test
	public void givenVendor_whenGetByCategory_thenReturnVendor()
	  throws Exception{
		 Vendor vendor1 = new Vendor(7000,"Revive","Health Care",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
		 when(vendorService.findByCategory("Health Care")).thenReturn(vendor1);
		 mvc.perform(get("/vendor/getByCategory/{category}","Health Care")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.id", is(7000)))
			      .andExpect(jsonPath("$.category", is("Health Care")));
		 
	}
	@Test
	public void givenVendor_CreateVendor()
	  throws Exception{
		 Vendor vendor1 = new Vendor(7000,"Revive","Health Care",new Date(2010, 02, 11),new Date(2011,05,11),25,1000.00,"Inactive","Bangalore");
		 ObjectMapper mapperObj = new ObjectMapper();
         
		 when(vendorService.save(vendor1)).thenReturn(vendor1);
		 mvc.perform(post("/vendor/add")
			      .contentType(MediaType.APPLICATION_JSON)
			      .content(mapperObj.writeValueAsString(vendor1)))
			      .andExpect(status().isCreated());
			  }
	
	
}
