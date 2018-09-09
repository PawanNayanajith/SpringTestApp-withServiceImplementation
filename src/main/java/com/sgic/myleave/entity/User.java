package com.sgic.myleave.entity;

import javax.validation.constraints.NotEmpty;

public class User {

	int empId;
	@NotEmpty(message = "Name Cannot be Null")
	String name;
	@NotEmpty(message = "Designation Cannot be Null")
	String designation;

	public User(int empId, String name, String designation) {
		this.empId = empId;
		this.name = name;
		this.designation = designation;
	}

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
