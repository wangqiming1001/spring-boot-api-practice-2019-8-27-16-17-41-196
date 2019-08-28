package com.tw.apistackbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
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
	
	public List<Employee> getEmployeesById(@PathVariable int id) {
		for(Company company : dataBase.getCompanies()) {
			if(company.getId() == id) {
				List<Employee> employees =  company.getEmployees();
				return employees;
			}
		}
		return null;
	}
	
	public List<Company> createCompany(Company company){
		dataBase.getCompanies().add(company);
		List<Company> companies = dataBase.getCompanies();
		return companies;
	}
	
	public Company updateCompany(Company company,int id){
		for(Company c : dataBase.getCompanies()) {
			if(c.getId() == id) {
				c.setCompanyName(company.getCompanyName());
				c.setEmployees(company.getEmployees());
				return company;
			}
		}
		return null;
	}
	
	public List<Company> deleteCompanyById(int id){
		List<Company> companyList = dataBase.getCompanies();
		for (int i = 0; i < companyList.size(); i++) {
			if (companyList.get(i).getId() == id) {
				companyList.remove(i);
			}
		}
		return companyList;
	}
}
