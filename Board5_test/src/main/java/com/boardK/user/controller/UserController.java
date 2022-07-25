package com.boardK.user.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boardK.user.service.UserService;
import com.boardK.user.vo.UserVo;

@RequestMapping("User")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 로그인
	@RequestMapping("/Login")
	public ModelAndView login() {

		ModelAndView mv = new ModelAndView();

		return mv;
	}

	// 회원가입 FORM
	@RequestMapping("/NewForm")
	public String create_userForm() {

		return 	"user/createUser";
	}

	// 회원가입
	@RequestMapping("/New")
	public ModelAndView create_user(@RequestParam HashMap<String, Object> map) {

		userService.newUser(map);

		ModelAndView mv = new ModelAndView();

		mv.setViewName("home"); // 회원가입하면 로그인화면(Home)으로

		return mv;
	}

	// 계정찾기 Form
	@RequestMapping("/FindForm")
	public String find_userForm() {

		return "user/find";
	}
	// 계정찾기
	@RequestMapping("Find")
	public ModelAndView find_user(@RequestParam HashMap<String, Object> map) {

		map.put("phonenum", (String) map.get("phonenum1") + map.get("phonenum2") + map.get("phonenum3"));
		
		UserVo viewUser = userService.findUser( map );
		
		ModelAndView mv = new ModelAndView();
		
		
		
		return mv;
	}

}
