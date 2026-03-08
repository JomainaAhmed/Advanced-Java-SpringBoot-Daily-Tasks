package com.lpu.MobileCaseStudy.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public class MobileDTO {
	
	private int id;
	@NotBlank(message = "name should not be blank")
	private String brandName;
	@NotBlank(message = "name should not be blank")
	private String modelName;
	@Min(value = 0, message = "Price must be above 0")
	private int price;
	private int ram;
	private int storage;
	private String colour;
	
	public MobileDTO() {
		
	}
	
	public int getId() {
		return id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
