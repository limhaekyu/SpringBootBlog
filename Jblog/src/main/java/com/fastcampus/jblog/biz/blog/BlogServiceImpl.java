package com.fastcampus.jblog.biz.blog;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.jblog.biz.user.UserVO;


public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDAOJdbc blogDAO;
	
	@Override
	public void createBlog(BlogVO vo, HttpSession session) {
		blogDAO.createBlog(vo, session);
	}

	@Override
	public void updateBlog(BlogVO vo) {
		blogDAO.updateBlog(vo);
		
	}

	@Override
	public void deleteBlog(BlogVO vo) {
		blogDAO.deleteBlog(vo);

	}

	@Override
	public BlogVO getBlog(BlogVO vo) {
		return blogDAO.getBlog(vo);	
	}

	@Override
	public List<BlogVO> getBlogList(BlogVO vo) {
		return blogDAO.getBlogList(vo);
	}

}
