package com.boardK.user.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardK.user.dao.UserDao;
import com.boardK.user.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	//회원가입
	@Override
	public void newUser(HashMap<String, Object> map) {
		
		userDao.newUser( map );

	}

}
