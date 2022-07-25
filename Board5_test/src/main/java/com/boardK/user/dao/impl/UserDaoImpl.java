package com.boardK.user.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boardK.user.dao.UserDao;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;
	//회원가입
	@Override
	public void newUser(HashMap<String, Object> map) {
		
		map.put("phonenum", (String) map.get("phonenum1") + "-" + map.get("phonenum2") + map.get("phonenum3"));
		map.put("address", (String) map.get("address3") + map.get("address1") + "," + map.get("address2") + "," + map.get("postNum"));
		/*
		map.remove("phonenum1");
		map.remove("phonenum2");
		map.remove("phonenum3");
		map.remove("postNum");
		map.remove("address1");
		map.remove("address2");
		map.remove("address3");
		map.remove("password2");
		*/
		
		sqlSession.insert("User.newUser", map);

	}

}
