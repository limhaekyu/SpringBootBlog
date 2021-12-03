package com.fastcampus.jblog.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOMybatis implements UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public UserVO getUser(UserVO vo) {
		
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}

	
}