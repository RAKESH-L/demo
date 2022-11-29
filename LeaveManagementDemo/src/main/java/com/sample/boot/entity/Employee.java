package com.sample.boot.entity;

public class Employee {
	private int empId;
	private String empName;
	private String email;
	private String contact;
	private String doj;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, String email, String contact, String doj) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.contact = contact;
		this.doj = doj;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + ", contact=" + contact
				+ ", doj=" + doj + "]";
	}
	
	
}
