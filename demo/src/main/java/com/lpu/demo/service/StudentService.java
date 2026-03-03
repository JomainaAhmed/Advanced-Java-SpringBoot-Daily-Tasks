//package com.lpu.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.lpu.demo.entity.Student;
//import com.lpu.demo.repository.StudentRepository;
//
//@Service
//public class StudentService {
//	//business logic
//	@Autowired
//	private StudentRepository repository;
//	
//	public Student saveStudent(Student student) {
//		return repository.save(student);
//	}
//	
//	public Student findStudentById(int id) {
//		Optional<Student> optional=repository.findById(id);
//	}
//	
////	public StudentService() {
////	}
////
////	public StudentService(StudentRepository repository) {
////		this.repository = repository;
////	}
//}
//}
//package com.lpu.demo.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.lpu.demo.entity.Student;
//import com.lpu.demo.repository.StudentRepository;
//
//@Service
//public class StudentService {
//
//    @Autowired
//    private StudentRepository repository;
//
//    // Save single student
//    public Student saveStudent(Student student) {
//        return repository.save(student);
//    }
//    
//    // Save all students
//    public List<Student> saveAllStudent(List<Student> list){
//        return repository.saveAll(list);
//    }
//
//    // Find student by ID
//    public Student findStudentById(int id) {
//        return repository.findById(id).orElse(null);
//    }
//    
//    // Delete by object
//    public void deleteStudent(Student student) {
//        repository.delete(student);
//    }
//    
//    // Delete by ID
//    public void deleteStudentById(int id) {
//        repository.deleteById(id);
//    }
//    
//    // Find all students
//    public List<Student> findAllStudent(){
//        return repository.findAll();
//    }
//}
package com.lpu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    //Save single student
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    //Save all students
    public List<Student> saveAllStudent(List<Student> students) {
        return repository.saveAll(students);
    }

    //Find student by ID
    public Student findStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    //Delete by object
    public void deleteStudent(Student student) {
        repository.delete(student);
    }

    //Delete by ID
    public void deleteStudentById(int id) {
        repository.deleteById(id);
    }

    //Custom query and methods - Find all students
    public List<Student> findAllStudent() {
        return repository.findAll();
    }
    
    public List<Student> findByName(String name){
        return repository.findByName(name);
    }

    public Student findByNameAndPhone(String name, long phone){
        return repository.findByNameAndPhone(name, phone);
    }

    public List<Student> getStudentByName(String name){
        return repository.getStudentByName(name);
    }

    public List<Student> getAllStudentsCustom(){
        return repository.getAllStudents();
    }
}