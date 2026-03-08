package com.lpu.MobileCaseStudy.cache;

import com.lpu.MobileCaseStudy.exception.ResourceNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lpu.MobileCaseStudy.entity.Mobile;
import com.lpu.MobileCaseStudy.repository.MobileRepository;

@Service
public class MobileServiceCache {
	
	@Autowired
	private MobileRepository mobilerepo;
	
	@Cacheable(value = "mobile", key = "#result.id")
	public Mobile getMobileById(int id) {
		System.err.println("Fetching from DB....");
		return mobilerepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mobile Not Found"));
	}
	
	//When adding/updating mobile, update cache
	@CachePut(value = "mobile", key = "#result.id")
	public Mobile addMobile(Mobile newmobile) {
		return mobilerepo.save(newmobile);
		
	}
	
	@CachePut(value = "students", key = "#id")
	public Mobile updateMobile(int id, Mobile mobile) {
	Mobile existing = getMobileById(id);
		   
			existing.setBrandName(mobile.getBrandName());
			existing.setModelName(mobile.getModelName());
			existing.setPrice(mobile.getPrice());
			existing.setRam(mobile.getRam());
			existing.setStorage(mobile.getStorage());
			existing.setColour(mobile.getColour());
			
			return mobilerepo.save(existing);
		}
		
	// #result.id - means use the returned student object's id after saving
		
		//Remove cache when deleting
		@CacheEvict(value = "mobile", key = "#id")
		public void deleteMobile(int id) {
			mobilerepo.deleteById(id);
		}
	

}
