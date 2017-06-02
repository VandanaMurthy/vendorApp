package org.accion.service;

import org.accion.entity.Vendor;
import org.accion.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
	@Autowired
	private VendorRepository venResp;
	
	public Object findAll(){
		return venResp.findAll();
	}
	
	public Vendor findById(int id){
		return venResp.findOne(id);
	}
	 public Vendor save(Vendor ven){
		 return venResp.save(ven);
	 }
	 public void delete(Vendor ven){
		 venResp.delete(ven);
		 return;
	 }
	public Vendor findByName(String name){
		return null;
	}

}
