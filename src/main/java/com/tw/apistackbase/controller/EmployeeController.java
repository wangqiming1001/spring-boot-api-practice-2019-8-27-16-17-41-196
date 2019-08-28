package com.tw.apistackbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}

