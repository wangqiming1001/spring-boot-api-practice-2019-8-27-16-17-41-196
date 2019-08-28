package com.tw.apistackbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.util.DataBase;

@Service
public class CompanyService {

	@Autowired
	private DataBase dataBase;
	
	public List<Company> queryAllCompanies() {
		List<Company> companyList = dataBase.getCompanies();
		return companyList;
	}
	
	public Company queryCompanyById(@PathVariable int id) {
		for(Company company : dataBase.getCompanies()) {
			if(company.getId() == id) {
				return company;
			}
		}
		return null;
	}
}
