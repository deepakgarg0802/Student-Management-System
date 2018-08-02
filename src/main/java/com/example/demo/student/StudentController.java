package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
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
