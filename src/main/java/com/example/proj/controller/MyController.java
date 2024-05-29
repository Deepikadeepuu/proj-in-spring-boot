package com.example.proj.controller;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MyController {

	@GetMapping("/")
	public String main(ModelMap map)
	{
		map.put("name", "User");
		return "myfile";
	}
	
	@GetMapping("/{name}")
	public String loadName(@PathVariable String name,ModelMap map)
	{
		map.put("name",name);
		return "myfile";
	}
	
	
	@GetMapping("/time")
	public String time(ModelMap map)
	{
		map.put("msg", "The time is  "+LocalDateTime.now());
		return "myfile";
	}
	
	@GetMapping("/otp")
	public String otp(ModelMap map)
	{
		map.put("msg","The otp is  "+ new Random().nextInt(100000,999999));
		return "myfile";
		}
	

	@PostMapping("/wish")
	public  String wish(ModelMap map,@RequestParam String name)
	{
		map.put("msg"," Happy Birthday !!  "+name);
		return "myfile";
	}
	
	//model Attribute is taken by default (@ModelAttribute object reference variable )-we create on object
	@PostMapping("/student")
	public String name(Student student,ModelMap map) {
		
		map.put("std", "  Name :-    "+ student.getName() +  "  ,  PhoneNumber :-    "+student.getPhno() + "   , Standard :-    "+ student.getStd()+"   , Age :-  "+student.getAge());
		return "myfile";

		
	}
	
	@GetMapping("/number-check")
	public String EnterNumber(@RequestParam int num ,ModelMap map) {
	
		if(num %2  ==0)
	map.put("even","This is even");
	
	else 
		
		map.put("odd","This is odd");
	return "myfile";
	}
	
	@GetMapping("/image-display")
	public String imageDisplay (ModelMap map, @RequestParam String pic ,@RequestParam int height,@RequestParam int width )
	{
		map.put("pic", pic);
		map.put("heigth", height);
		map.put("width",width);
		return "myfile";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello(@RequestParam String name)
	{
		return "Hello"+name;
	}
//	url name=http://localhost/hello?name=saish
}
//myfile.html-html is optional 
//https://www.baeldung.com/thymeleaf-in-spring-mvc
// <!--  -->  we can use commite in html