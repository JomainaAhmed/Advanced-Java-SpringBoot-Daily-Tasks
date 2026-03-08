package com.lpu.MobileCaseStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.lpu.MobileCaseStudy.dto.MobileDTO;
import com.lpu.MobileCaseStudy.entity.Mobile;
import com.lpu.MobileCaseStudy.service.MobileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/mobiles")
@Validated
public class MobileController {

    @Autowired
    private MobileService service;

    //Save Mobile
    @PostMapping
    public ResponseEntity<Mobile> addMobile(@Valid @RequestBody MobileDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveMobile(dto));
    }

    //Get All Mobiles
    @GetMapping
    public ResponseEntity<List<Mobile>> getAllMobiles() {
        return ResponseEntity.ok(service.getAllMobiles());
    }

    //Get Mobile By ID
    @GetMapping("/{id}")
    public ResponseEntity<Mobile> getMobileById(@PathVariable int id) {
        return ResponseEntity.ok(service.getMobileById(id));
    }

    //Update Mobile
    @PutMapping("/{id}")
    public ResponseEntity<Mobile> updateMobile(
            @PathVariable int id,
            @Valid @RequestBody MobileDTO dto) {

        return ResponseEntity.ok(service.updateMobile(id, dto));
    }

    //Delete Mobile
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMobile(@PathVariable int id) {

        service.deleteMobile(id);
        return ResponseEntity.ok("Mobile deleted successfully");
    }

    //Search By Brand
    @GetMapping("/search")
    public ResponseEntity<List<Mobile>> searchByBrand(
            @RequestParam String brandName) {

        return ResponseEntity.ok(service.searchByBrand(brandName));
    }
}