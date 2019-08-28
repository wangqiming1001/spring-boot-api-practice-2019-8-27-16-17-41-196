package com.tw.apistackbase.model;

import java.util.List;

public class Company {
	private int id;
	private String companyName;
	private List<Employee> employees;
	
	public Company() {
		super();
	}
	public Company(int id, String companyName, List<Employee> employees) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.employees = employees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
