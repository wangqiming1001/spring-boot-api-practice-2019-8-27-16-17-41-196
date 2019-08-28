package com.tw.apistackbase.service;

import java.util.ArrayList;
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
	
	public Employee getEmployeeById(int id) {
		List<Employee> Employees = dataBase.getEmployees();
		Employee employeer = new Employee();
		for(Employee employee : Employees) {
			if(employee.getId() == id) {
				employeer = employee;
			}
		}
		return employeer;
	}
	
	public List<Employee> getEmployeesByGender(String gender) {
		List<Employee> result = new ArrayList<Employee>();
		List<Employee> Employees = dataBase.getEmployees();
		for (int i = 0; i < Employees.size(); i++) {
			if(gender.equals(Employees.get(i).getGender())) {
				result.add(Employees.get(i));
			}
		}
		return result;
	}
	
	public List<Employee> createEmployee(Employee employee){
		dataBase.getEmployees().add(employee);
		List<Employee> employeeList = dataBase.getEmployees();
		return employeeList;
	}
	
	public Employee updateEmployee(Employee employee,int id){
		Employee result = new Employee();
		for(Employee e : dataBase.getEmployees()) {
			if(e.getId() == id) {
				e.setAge(employee.getAge());
				e.setName(employee.getName());
				e.setGender(employee.getGender());
				e.setSalary(employee.getSalary());
				result = e;
			}
		}
		return result;
	}
	
	public List<Employee> deleteEmployee(int id){
		List<Employee> employeeList = dataBase.getEmployees();
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getId() == id) {
				employeeList.remove(i);
			}
		}
		return employeeList;
	}
	
}
