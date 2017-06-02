package org.accion.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendors_list")
public class Vendor {
	@Id
	@Column(name="vendor_id")
	private int id;
	
	@Column(name="vendor_name")
	private String name;
	
	@Column(name="vendor_category")
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Vendor(int id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
	public Vendor(){
		
	}
	

}
