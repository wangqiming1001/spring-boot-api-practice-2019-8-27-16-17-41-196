package com.tw.apistackbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//获取员工名单
	@GetMapping
	public ResponseEntity<List<Employee>> queryEmployees(){
		return ResponseEntity.ok(employeeService.queryEmployees());
	}
	
	//获得某个特定员工
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	//分页查询
	
	//查询所有男性员工
	@GetMapping("/gender")
	public ResponseEntity<List<Employee>> getEmployeesByGender(@RequestParam("gender") String gender) {
		List<Employee> maleEmployeeList = employeeService.getEmployeesByGender(gender);
		return ResponseEntity.ok(maleEmployeeList);
	}
	
	//添加一名员工
	@PostMapping("")
	public ResponseEntity<List<Employee>> createEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.createEmployee(employee));
	}
	
	//update一名员工
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id){
		Employee newEmployee = employeeService.updateEmployee(employee, id);
		return ResponseEntity.ok(newEmployee);
	}
	
	//delete一名员工
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable int id){
		List<Employee> employee = employeeService.deleteEmployee(id);
		return ResponseEntity.ok(employee);
	}
	
}

