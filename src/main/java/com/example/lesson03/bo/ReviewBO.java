package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper;
	
	//ex01
	//input() : id
	//output(controller에게 주는 것) : Review(단건)
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	//ex02/1
	//input:controller가 Review(단건)
	//output: int(성공된 행의 개수)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	
	//ex02/2
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);  //mapper에 요청한 값을 return한다
	}
	
}
