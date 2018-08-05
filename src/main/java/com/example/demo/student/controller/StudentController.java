package com.example.demo.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.model.Student;
import com.example.demo.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/health")
	public String checkHealth(){
		
		return "health ok..";
	}
	
	@RequestMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping("/students/{StudentId}")
	public Student getStudent(@PathVariable("StudentId") int id) {
		return studentService.getStudent(id);
	}

	@RequestMapping(method= RequestMethod.POST,value="/students")
	public String addStudents(@RequestBody Student student){
		int success= studentService.addStudent(student);
		if(success==1) {
			return "success";
		}
		else {
			return "failure";
		}
	}
}
