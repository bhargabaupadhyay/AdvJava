package com.cutm.Hibernate1.model;

import java.io.Serializable;

public class Employee implements Serializable{
	private int empId;	

	private String name;

	private String address;	  

	private String mobile;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [empId=").append(empId).append(", name=").append(name).append(", address=")
				.append(address).append(", mobile=").append(mobile).append("]");
		return builder.toString();
	}
	
	
}
