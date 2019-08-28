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
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	//获取公司列表
	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies() {
		return ResponseEntity.ok(companyService.queryAllCompanies());
	}
	
	//获取某个特定的公司
	@GetMapping("/{id}")
	public ResponseEntity<Company> queryCompanyById(@PathVariable int id) {
		Company company = companyService.queryCompanyById(id);
		return ResponseEntity.ok(company);
	}
	
	//获取某个公司下的所有员工
	@GetMapping("/{id}/employees")
	public ResponseEntity<List<Employee>> getEmployeesByCompanyId(@PathVariable int id) {
		List<Employee> employees = companyService.getEmployeesById(id);
		return ResponseEntity.ok(employees);
	}
	
	//分页查询
	
	//添加一个公司
	@PostMapping("")
	public ResponseEntity<List<Company>> createCompany(@RequestBody Company company){
		List<Company> companies = companyService.createCompany(company);
		return ResponseEntity.ok(companies);
	}
	
	//更新一个公司的基本信息
	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable int id){
		Company newCompany = companyService.updateCompany(company,id);
		return ResponseEntity.ok(newCompany);
	}
	
	//删除某个特定的公司
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Company>> deleteCompany(@PathVariable int id){
		return ResponseEntity.ok(companyService.deleteCompanyById(id));
	}
	
	
}
