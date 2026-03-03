package com.lpu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.College;
import com.lpu.demo.service.CollegeService;



@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService service;

    @PostMapping
    public College saveCollege(@RequestBody College college) {
        return service.saveCollege(college);
    }
}