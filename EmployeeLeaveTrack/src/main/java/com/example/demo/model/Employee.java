package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	private String empName;
	private String department;
	private String email;
	private String address;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String empName, String department, String email, String address, Role role) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.email = email;
		this.address = address;
		this.role = role;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", department=" + department + ", email=" + email
				+ ", address=" + address + ", role=" + role + "]";
	}

		
}
