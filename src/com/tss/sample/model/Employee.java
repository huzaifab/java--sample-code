package com.tss.sample.model;

import java.time.OffsetDateTime;

public class Employee {
	private int id;
	private String name;
	private String department;
	private OffsetDateTime joinDate;
	public Employee(int id, String name, String department, OffsetDateTime joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.joinDate = joinDate;
	}
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public OffsetDateTime getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(OffsetDateTime joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", joinDate=" + joinDate + "]";
	}
	
}