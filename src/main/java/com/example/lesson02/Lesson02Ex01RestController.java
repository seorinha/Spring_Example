package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.BO.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController //@Controller + @ResponseBody
public class Lesson02Ex01RestController {

	@Autowired // DI(spring bean을 주입한다)
	private UsedGoodsBO usedGoodsBO;
	
	//요청 url:http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		return usedGoodsList; //json으로 출력된다 = json의 responsebody에 담긴다
	}
	
	
	
}
