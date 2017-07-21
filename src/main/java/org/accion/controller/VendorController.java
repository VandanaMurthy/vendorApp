package org.accion.controller;

import org.accion.entity.Vendor;
import org.accion.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VendorController {
	@Autowired
	private VendorService vs;
	
	@RequestMapping(value="/allVendors",method=RequestMethod.GET)
	@ResponseBody
	public Object index(){
		return vs.findAll();
	}
	
	@RequestMapping(value="/add",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String add(@RequestBody Vendor ven){
		try{
			vs.save(ven);
		}
		catch(Exception e){
			return "Error adding new vendor: "+e.toString();
		}
		return "Vendor added successfully";
		
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable int id){
		try{
			Vendor v1=vs.findById(id);
			vs.delete(v1);
		}
		catch(Exception ex){
			return "Error in deleting vendor: " + ex.toString();
		}
		return "Vendor deleted";
	}
	
	@RequestMapping("/getByName")
	@ResponseBody
	public String getByName(String name){
		String n1="";
		try{
			Vendor v1=vs.findByName(name);
			n1=String.valueOf(v1.getName());
		}
		catch(Exception exp){
			return "Vendor Not Found";
		}
		return "Vendor Name= "+ n1;
	}
	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateVendor(@RequestBody Vendor ven,@PathVariable int id){
		try{
			ven.setId(id);
			vs.save(ven);
		}
		catch(Exception ex){
			return "Error in updating vendor details";
		}
		return "Vendor details updated successfully";
		
	}
	@RequestMapping("/")
	public String home(){
		return "index";
	}

}
