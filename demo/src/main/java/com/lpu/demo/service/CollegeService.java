package com.lpu.demo.service;

//import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.College;
import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.CollegeRepository;

@Service
public class CollegeService {
	
	@Autowired
	private CollegeRepository repository;
	
	public College saveCollege(College college) {
		for (Student student : college.getStudents()) {
			student.setCollege(college);
		}
		
		return repository.save(college);
		
	}	

}
