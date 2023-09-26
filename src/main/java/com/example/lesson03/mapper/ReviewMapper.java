package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {

	//ex01
	//input()
	//output(controller에게 주는 것) : Review(단건)
	public Review selectReview(int id);
	
	//ex02/1
	//return int (MyBatis가 성공된 행의 개수를 리턴해준다)
	public int insertReview(Review review);
	
	//ex02/2
	//parameter가 2개 이상일 때 map으로 만든다 이 일을 @param이 해준다
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	//ex03/1
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);

	//ex04/1
	public void deleteReviewById(int id);
	
}
