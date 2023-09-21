package com.example.lesson03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //이걸 쓰기 때문에 json을 볼 수있다
public class Lesson03Ex01RestController {

	//요청 url : http://localhost/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review ex01() {
		return ;
	}
}
