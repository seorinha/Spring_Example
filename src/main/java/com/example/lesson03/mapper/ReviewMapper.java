package com.example.lesson03.mapper;

import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {

	//input()
	//output(controller에게 주는 것) : Review(단건)
	public Review selectReview() {
		return ;
	}
}
