package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	private final StudentServices studentServices;

	@Autowired
	public StudentController(StudentServices studentServices) {
		this.studentServices = studentServices;
	}


	@GetMapping
	public List<Student> getStudents(){
		return studentServices.getStudents();
	}

	@PostMapping
	public void registernewStudent(@RequestBody Student student){
		studentServices.addNewStudent(student);
	}

	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") long studentId){
		studentServices.deleteStudent(studentId);
	}

	@PutMapping(path = "{studentId}")
	public void updateStudent(
		@PathVariable("studentId") Long studentId,
		@RequestParam(required = false) String regno,
		@RequestParam(required = false) String name,
		@RequestParam(required = false) String block,
		@RequestParam(required = false) Integer room,
		@RequestParam(required = false) Long phno
		){
			studentServices.updateStudent(studentId,regno,name,block,room,phno);
		
	}
}
