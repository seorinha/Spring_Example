package com.example.lesson03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson03Ex03RestController {

	//url: http://localhost/lesson03/ex03?id=24&review=도미노피자는맛잇다
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id")int id,
			@RequestParam("review") String review) {
		
	}
	
}
