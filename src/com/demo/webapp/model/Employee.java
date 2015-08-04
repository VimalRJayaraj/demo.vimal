package com.demo.webapp.model;

public class Employee {

	private String name;
	private int id;
	private String designation;
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", designation="
				+ designation + ", location=" + location + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int id, String designation, String location) {
		super();
		this.name = name;
		this.id = id;
		this.designation = designation;
		this.location = location;
	}
}
