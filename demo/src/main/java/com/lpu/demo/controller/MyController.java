package com.lpu.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;

@RestController
public class MyController {
	
	@GetMapping("/hi")
	public String takeRequest() {
			return "byee";
		}
	//MT -> GET
	//URL -> http://localhost:8080/takeData?id=108&name=raju
	@GetMapping("/takeData")
	public String takeData(@RequestParam int id, @RequestParam String name) {
		return "ID"+id+"NAME="+name;
	}
	
	@GetMapping("/takeData1")
	public String takeData1(@RequestParam int id, @RequestParam String name, @RequestParam String location) {
		return "ID = "+id+" NAME = "+name+" LOCATION = "+location;
	}
	
	//URL -> http://localhost:8080/takeData2/108/jomaina
	@GetMapping("/takeData2/{id}/{name}")
	public String takeData2(@PathVariable int id, @PathVariable String name) {
		return "ID="+id+" NAME="+name;
	}
	
	//URL -> http://localhost:8080/student/55/college/88
	@GetMapping("/student/{sId}/college/{cId}")
		public String takeData3(@PathVariable int sId, @PathVariable int cId) {
			return "SId="+sId+" CId="+cId;
		}
	
	//URL -> http://localhost:8080/takeData4
	@GetMapping("/takeData4") //Give input 
	public String takeData4(@RequestHeader int id, @RequestHeader String name) {
		return "Id="+id+" Name="+name;
	}
	
	//URL - http://localhost:8080/takeData4
	// header , key =id , value=555
	// header , key = name , value=XYZ
	@GetMapping("/takeData5")
	public String takeData5(@RequestHeader int id, @RequestHeader String name) {
		return "ID="+id+" Name="+name;
	}
	
	@GetMapping("/student1")
	public String getStudent(@RequestBody Student s) {
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getPhone());
		return s.getName()+" is received";
	}
	
	@GetMapping("/student2")
	public Student getStudent2(@RequestBody Student s) {
		return s;
//		System.out.println(s.getId());
//		System.out.println(s.getName());
//		System.out.println(s.getPhone());
//		return s.getName()+" is received";
	}
	
}
