package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller //jsp로 보낼 때는 @ResponseBody가 없어야 한다 
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	
	//회원가입 페이지
	// http://localhost/lesson04/ex01/sign-up-view
	@RequestMapping(path = "/sign-up-view", method = RequestMethod.GET) //GET방식만 혀용하겠다는 의미
	public String signUpView() {
		return "lesson04/signUp"; //jsp view경로
	}
	
	//회원가입 수행(db에 insert) 후 결과 페이지로 이동
	// http://localhost/lesson04/ex01/sign-up
	@PostMapping("/sign-up") //post만 허용한다는 어노테이션 
	public String signUp(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce) {//비필수
			
		//db insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/signUpResult";
	}

	
	//최신가입자 한면 가져오는 페이지
	//http://localhost/lesson04/ex01/get-latest-user-view
	@GetMapping("/get-latest-user-view")
	public String getLatestUserView(Model model) {
		//db select 조회
		User user = userBO.getLatestUser();
		model.addAttribute("result", user);
		model.addAttribute("title", "최신 유저 정보");
		
		//MVC(Model View Controller) view와 controller사이에 model
		return "lesson04/getLatestUser"; //결과 jsp 경로
	}
	
	
	
	
}
