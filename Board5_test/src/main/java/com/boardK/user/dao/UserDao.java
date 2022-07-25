package com.boardK.user.dao;

import java.util.HashMap;

import com.boardK.user.vo.UserVo;

public interface UserDao {
	// 회원가입
	void newUser(HashMap<String, Object> map);
	// 계정찾기
	UserVo findUser(HashMap<String, Object> map);

}
