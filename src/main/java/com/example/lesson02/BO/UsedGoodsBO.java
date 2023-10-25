package com.example.lesson02.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service //spring bean
public class UsedGoodsBO {
	
	@Autowired //spring bean(객체)을 가져오는 것: DI(Dependency Injection)
	private UsedGoodsMapper usedGoodsMapper;

	//input(controller로 부터 요청 받음) : 요청없음
	//output(controller에게 돌려줌) : controller가 필요로 하는것(List<UsedGoods>)을 돌려준다
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsMapper.selectUsedGoodsList();
	}
	
}
