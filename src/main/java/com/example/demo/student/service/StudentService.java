package com.example.demo.student.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.student.model.Student;

@Service
public class StudentService {

	List<Student> mylist= new ArrayList<Student>(Arrays.asList(new Student(3, "a"),
			new Student(2, "b")));
	
	public List<Student> getAllStudents(){
		return mylist;
	}
	
	public Student getStudent(int id) {
		return mylist.stream().filter(t->t.getId()==id).findFirst().get();
	}
	
	public int addStudent(Student student) {
		int count= mylist.size();
		mylist.add(student);
		if(mylist.size()==count+1) {
			return 1;
		}
		return 0;
	}
}
