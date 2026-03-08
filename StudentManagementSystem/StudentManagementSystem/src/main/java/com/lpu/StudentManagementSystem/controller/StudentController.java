package com.lpu.StudentManagementSystem.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import com.lpu.StudentManagementSystem.Repository.StudentRepository;
import com.lpu.StudentManagementSystem.entity.Student;
import com.lpu.StudentManagementSystem.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    
    @GetMapping("/page/{pageNo}/{pageSize}")
    public Page<Student> getStudents(@PathVariable int pageNo,
                                     @PathVariable int pageSize) {

        return service.getStudents(pageNo, pageSize);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
    
    @PostMapping("/upload/{id}")
    public String uploadFiles(@PathVariable int id,
                              @RequestParam("profileImage") MultipartFile image,
                              @RequestParam("assignmentFile") MultipartFile file) throws IOException {

    	Student student = service.getStudentById(id);

        student.setProfileImage(image.getBytes());
        student.setAssignmentFile(file.getBytes());

        service.createStudent(student);

        return "Profile Image and Assignment Uploaded Successfully";
    }
    
    @GetMapping("/download/image/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable int id) {

        Student student = service.getStudentById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=profileImage")
                .body(student.getProfileImage());
    }
    
    @GetMapping("/download/file/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable int id) {

        Student student = service.getStudentById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=assignmentFile")
                .body(student.getAssignmentFile());
    }
}