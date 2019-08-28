package com.tw.apistackbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.util.DataBase;

@Service
public class EmployeeService {

	@Autowired
	private DataBase dataBase;
	
	public List<Employee> queryEmployees(){
		List<Employee> employee = dataBase.getEmployees();
		return employee;
	}
	
}
