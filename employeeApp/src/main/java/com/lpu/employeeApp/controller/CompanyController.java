package com.lpu.employeeApp.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lpu.employeeApp.entity.Company;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.service.CompanyService;

import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("/company")

public class CompanyController {

    @Autowired
    private CompanyService service;

    //Save Company (with employees)
    //URL: http://localhost:8080/company
    @PostMapping
    public ResponseEntity<Company> saveCompany(@Valid @RequestBody Company company) { //To Alter the HTTP response
    	
    	Company body=service.saveCompany(company);
    	return ResponseEntity.status(HttpStatus.CREATED).body(body);
        //return service.saveCompany(company);
    }
    
    //URL: http://localhost:8080/company/company2
    @PostMapping("/company1")
    public ResponseEntity<Company> saveCompanyWithMapping(@RequestBody Company company) { //To Alter the HTTP response
    	
    	Company body=service.saveCompany(company);
    	return ResponseEntity.status(HttpStatus.CREATED).body(body);
        //return service.saveCompany(company);
    }
    
    //URL: http://localhost:8080/company/company2
//    @PostMapping("/company1")
//    public ResponseEntity<Company> saveCompanyWithMapping(@RequestBody Company company){
//    	
//    	Company body = service.saveCompany(company);
//    	return new ResponseEntity<Company>(body,HttpStatus.CREATED).body(body);
//    }
//    
    
    public ResponseEntity<Company> saveCompany2(@RequestBody Company company) {
    	Company body = service.saveCompany(company);
    	return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
    
    
    //URL: http://localhost:8080/company/company2/1
    @PostMapping("/company2/{cId}")
    public Company saveEmployeeToExistingCompany(
            @PathVariable int cId,
            @RequestBody List<Employee> employees) {
    	
    	//Company body = service.saveEmployeeToExistingCompany(cId, employees))
        return service.saveEmployeeToExistingCompany(cId, employees);
    }
    
    //URL: http://localhost:8080/company/divide/10/5
    @GetMapping("/divide/{n1}/{n2}")
    public String divide(@PathVariable int n1, @PathVariable int n2) {
    	return "result="+n1/n2;
    }
    
    //URL: http://localhost:8080/company/1
    @GetMapping("/{id}")
    public Company findCompanyById(@PathVariable int id) {
        return service.findCompanyById(id);
    }

//    //Get All Companies
//    @GetMapping
//    public List<Company> getAllCompanies() {
//        return service.getAllCompanies();
//    }
//
//    //Get Company By ID
//    @GetMapping("/{id}")
//    public Company getCompanyById(@PathVariable Integer id) {
//        return service.getCompanyById(id);
//    }
//
//    //Update Company
//    @PutMapping("/{id}")
//    public Company updateCompany(@PathVariable Integer id,
//                                 @RequestBody Company company) {
//        return service.updateCompany(id, company);
//    }
//
//    //Delete Company
//    @DeleteMapping("/{id}")
//    public String deleteCompany(@PathVariable Integer id) {
//        service.deleteCompany(id);
//        return "Company deleted successfully!";
//    }
}