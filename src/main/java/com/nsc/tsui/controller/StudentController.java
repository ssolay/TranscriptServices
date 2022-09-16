package com.nsc.tsui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsc.tsui.model.Student;
import com.nsc.tsui.util.MockUtil;
/**
 * 
 * @author sgundlapally
 *
 */
@RestController
public class StudentController {
	
	@GetMapping(path="/student/{access_token}")
	public ResponseEntity<Student> getStudentAccessToken(@PathVariable("access_token") String access_token) {
		return new ResponseEntity<Student>(new Student(), HttpStatus.OK);
	}
	
	@PostMapping(path="/student/check", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getStudentCheck(@RequestBody String student){
		return MockUtil.STUDENT_BY_CHECK; 
	}
	
	
	
}
