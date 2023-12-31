package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	
	//input : controller가 받아온 4개의 컬럼들
	//output :x
	public void addUser(String name, String yyyymmdd, String email, String introduce) {
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	//input: x
	//output:User(최신가입자1명)
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
	
	//lesson06ex02
	//input: name
	//output: boolean (중복이면 true)
	public boolean existUserByName(String name) {
		return userMapper.existUserByName(name);
	}
}
