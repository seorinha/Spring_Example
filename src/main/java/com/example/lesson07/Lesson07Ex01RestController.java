package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// C U D
	//C:create, insert
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "하하하";
		String phoneNumber = "010-2222-5555";
		String email = "ss@naver.com";
		String dreamJob = "사장";
		
		//지금 들어간 id값도 바로 꺼낼 수 있다. getId();로.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
		
	}
	
	
}
