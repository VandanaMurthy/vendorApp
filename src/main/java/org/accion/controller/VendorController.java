package org.accion.controller;

import java.util.Arrays;
import java.util.List;
import org.accion.entity.Vendor;
import org.accion.service.VendorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	final static Logger logger = Logger.getLogger(VendorController.class);
	@Autowired
	private VendorService vs;
	

	
	@RequestMapping(value="/add",method=RequestMethod.POST,headers = {"content-type=application/json"})
	public ResponseEntity<Vendor> add(@RequestBody Vendor ven){
			vs.save(ven);
			logger.debug("Added: " + ven);
			return new ResponseEntity<Vendor>(ven,HttpStatus.CREATED);
			
		}
	
	
	
	@RequestMapping(value="/updateById/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Void> updateVendorById(@RequestBody Vendor ven,@PathVariable("id")int id){
	Vendor vendor=vs.findById(ven.getId());
	if(vendor == null){
		logger.debug("Vendor with id " + ven.getId() + " does not exists");
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	else{
		vs.save(ven);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	}
	
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vendor> getVendorById(@PathVariable("id") int id) {
		Vendor ven = vs.findById(id);
		if (ven == null) {
			logger.debug("Vendor with id " + id + " does not exists");
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Vendor:: " + ven);
		return new ResponseEntity<Vendor>(ven, HttpStatus.OK);
	}

	@RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<Vendor> getVendorByName(@PathVariable("name") String name) {
		Vendor ven1 = vs.findVendorByName(name);
		if (ven1 == null) {
			logger.debug("Vendor with name " + name + " does not exists");
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Vendor:: " + ven1);
		return new ResponseEntity<Vendor>(ven1, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getByCategory/{category}", method = RequestMethod.GET)
	public ResponseEntity<Vendor> getVendorByCategory(@PathVariable("category") String category) {
		Vendor ven2 = vs.findByCategory(category);
		if (ven2 == null) {
			logger.debug("Vendor associated with category  " + category + " does not exists");
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Vendor:: " + ven2);
		return new ResponseEntity<Vendor>(ven2, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllVendors",method = RequestMethod.GET)
	public ResponseEntity<List<Vendor>> getAllVendors() {
		List<Vendor> vendors = vs.findAll();
		if (vendors.isEmpty()) {
			logger.debug("Vendors does not exists");
			return new ResponseEntity<List<Vendor>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + vendors.size() + " vendors");
		logger.debug(vendors);
		logger.debug(Arrays.toString(vendors.toArray()));
		return new ResponseEntity<List<Vendor>>(vendors, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVendor(@PathVariable("id") int id) {
		Vendor v1 = vs.findById(id);
		if (v1 == null) {
			logger.debug("Vendor with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			vs.delete(id);
			logger.debug("Vendor with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
