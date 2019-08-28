package com.tw.apistackbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.model.Company;
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
	
}
