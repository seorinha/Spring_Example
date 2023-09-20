package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") //메소드에 붙은 주소 mapping보다 먼저 적용된다
@Controller //Spring 객체임을 등록 = Spring bean(콩)을 등록한다
public class Lesson01Ex01Controller {

	// String 출력하기
	// 요청 url : http://localhost:8080/lesson01/ex01/1
	@RequestMapping("/1") // 주소 mapping 
	@ResponseBody //return되는 String이 Response body에 담겨서 내려간다
	public String ex01_1() {
		return "<h1>문자열을 response body로 보내는 예제</h1>";
	}
	
	
	// Map 출력하기 -> map을 json string으로 출력하기
	// 요청 url : http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 5);
		map.put("복숭아", 12);
		map.put("자두", 8);
		map.put("체리", 20);
		
		// map을 return하면 JSON으로 변경되어 출력된다
		// Web starter에 Jackson이라는 라이브러리가 포함되어있기 때문
		return map;
	}
	
}
