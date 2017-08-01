package org.accion.entity;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendors_list")
public class Vendor {
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}

	public double getBillRate() {
		return billRate;
	}

	public void setBillRate(double billRate) {
		this.billRate = billRate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Id
	@Column(name="vendor_id")
	private int id;
	
	@Column(name="vendor_name")
	private String name;
	
	@Column(name="vendor_category")
	private String category;
	 
	@Column(name="start_date")
	private  Date startDate;
	
	@Column(name="end_date")
	private  Date endDate;
	
	@Column(name="resource_count")
	private  int resourceCount;
	
	@Column(name="bill_rate")
	private  double billRate;
	
	@Column(name="status")
	private  String status;
	
	@Column(name="address")
	private  String address;
	
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

	
	

	public Vendor(int id, String name, String category, Date startDate, Date endDate, int resourceCount,
			double billRate, String status, String address) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resourceCount = resourceCount;
		this.billRate = billRate;
		this.status = status;
		this.address = address;
	}

	public Vendor(){
		
	}
	 
}

