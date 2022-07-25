package com.boardK.user.service;

import java.util.HashMap;

import com.boardK.user.vo.UserVo;

public interface UserService {
	
	//회원가입
	void newUser(HashMap<String, Object> map);
	//계정찾기
	UserVo findUser(HashMap<String, Object> map);

}
