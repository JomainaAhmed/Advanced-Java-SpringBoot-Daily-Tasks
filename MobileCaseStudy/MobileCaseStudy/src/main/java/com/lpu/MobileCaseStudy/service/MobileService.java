package com.lpu.MobileCaseStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.MobileCaseStudy.dto.MobileDTO;
import com.lpu.MobileCaseStudy.entity.Mobile;
import com.lpu.MobileCaseStudy.exception.ResourceNotFoundException;
import com.lpu.MobileCaseStudy.repository.MobileRepository;

@Service
public class MobileService {

    @Autowired
    private MobileRepository mobileRepo;

    public Mobile saveMobile(MobileDTO dto) {
        Mobile mobile = new Mobile();
        mobile.setBrandName(dto.getBrandName());
        mobile.setModelName(dto.getModelName());
        mobile.setPrice(dto.getPrice());
        return mobileRepo.save(mobile);
    }

    public List<Mobile> getAllMobiles() {
        return mobileRepo.findAll();
    }

    public Mobile getMobileById(int id) {
        return mobileRepo.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Mobile not found with id: " + id));
    }

    public Mobile updateMobile(int id, MobileDTO dto) {

        Mobile existing = getMobileById(id);

        existing.setBrandName(dto.getBrandName());
        existing.setModelName(dto.getModelName());
        existing.setPrice(dto.getPrice());

        return mobileRepo.save(existing);
    }

    public void deleteMobile(int id) {
        Mobile existing = getMobileById(id);
        mobileRepo.delete(existing);
    }

    public List<Mobile> searchByBrand(String brandName) {
        return mobileRepo.findByBrandNameIgnoreCase(brandName);
    }
}