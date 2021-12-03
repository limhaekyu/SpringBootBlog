package com.fastcampus.jblog.biz.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastcampus.jblog.biz.common.JDBCUtil;
import com.fastcampus.jblog.biz.user.UserVO;

@Repository
public class BlogDAOMybatis implements BlogDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void createBlog(BlogVO vo, HttpSession session) {
		
		
	}
	
	public void updateBlog(BlogVO vo) {
		
	}
	
	public void DeleteBlogReq(BlogVO vo) {
		
	}
	
	public void deleteBlog(BlogVO vo) {
		
	}
	
	public BlogVO getBlog(BlogVO vo) {
		
		return blog;
	}
	
	public List<BlogVO> getBlogList(BlogVO vo) {
		
		return blogList;
	}

	
	
}
