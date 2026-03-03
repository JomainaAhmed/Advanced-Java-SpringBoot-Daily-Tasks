package com.lpu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.demo.entity.College;

public interface CollegeRepository extends JpaRepository<College, Integer> {
}