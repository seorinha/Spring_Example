package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex02RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// 요청 url: http://localhost/lesson03/ex02/1
	@RequestMapping("/lesson03/ex02/1")
	public String ex02_1() {
		Review review = new Review(); //일반 자바 bean
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("사자고양이");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 좋아요");
		
		int rowCount = reviewBO.addReview(review);
		
		return "성공된 행의 개수: " + rowCount;
	}
	
	
	// 요청 url: http://localhost/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		//컬럼 하나하나를 parameter로 따로 보내는 방법
		int rowCount = reviewBO.addReviewAsField(4, "콤비네이션R", "김바다", 5.0, "역시 맛잇다!!!");
		
		return "성공한 행의 개수" + rowCount;
		
	}
	
	
}
