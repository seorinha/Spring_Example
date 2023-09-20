package com.example.lesson02.BO;

import org.springframework.stereotype.Service;

@Service //spring bean
public class UsedGoodsBO {

	//input(controller로 부터 요청 받음) : parameter없음
	//output(controller에게 돌려줌) : controller가 필요로 하는것(List<UsedGoods>)을 돌려준다
	public List<UsedGoods> getUsedGoodsList() {
		
	}
	
}
