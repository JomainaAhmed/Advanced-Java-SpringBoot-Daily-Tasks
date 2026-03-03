//package com.lpu.demo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.lpu.demo.entity.Student;
//
//public interface StudentRepository extends JpaRepository<Student, int> {
//
//    // No need to write CRUD methods.
//    // JpaRepository already provides:
//    // save(), findById(), findAll(), deleteById(), etc.
//}
package com.lpu.demo.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lpu.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	//DB CRUD methods for Students
	
	//custom method
	List<Student> findByName(String name);
	Student findByNameAndPhone(String name, long phone);
	
	//custom query
	@Query("select s from Student s where s.name=:name")
	List<Student> getStudentByName(String name);
	
	@Query(nativeQuery = true, value = "select * from student")
	List<Student> getAllStudents();
	

}