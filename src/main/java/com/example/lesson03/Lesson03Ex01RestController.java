package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController //이걸 쓰기 때문에 json을 볼 수있다
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	//요청 url : http://localhost/lesson03/ex01
	//요청 url : http://localhost/lesson03/ex01?id=5
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id //필수 parameter
			//@RequestParam(value="id") int id //필수 parameter로 받는 방법
			//@RequestParam(value="id", required=true) int id //필수 parameter로 받는 방법
			//@RequestParam(value="id", required=false) Integer id //비필수 parameter
			//@RequestParam(value="id", defaultValue="1") int id //비필수 parameter, 디폴트 값 = 1
			) {
		return reviewBO.getReview(id); //response body에는 json이 내려간다
	}
}
