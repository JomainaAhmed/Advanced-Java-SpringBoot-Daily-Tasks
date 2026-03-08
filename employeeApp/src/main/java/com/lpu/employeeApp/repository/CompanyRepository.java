package com.lpu.employeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import com.lpu.employeeApp.entity.Company;
	
	public interface CompanyRepository extends JpaRepository<Company, Integer> {
		
	}
	
