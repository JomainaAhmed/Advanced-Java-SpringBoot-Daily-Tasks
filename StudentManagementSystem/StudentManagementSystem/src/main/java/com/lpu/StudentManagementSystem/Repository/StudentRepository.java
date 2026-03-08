package com.lpu.StudentManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.StudentManagementSystem.entity.*;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}