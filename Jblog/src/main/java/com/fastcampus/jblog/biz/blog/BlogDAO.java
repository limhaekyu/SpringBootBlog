package com.fastcampus.jblog.biz.blog;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface BlogDAO {

	void createBlog(BlogVO vo, HttpSession session);

	void updateBlog(BlogVO vo);

	void deleteBlog(BlogVO vo);

	BlogVO getBlog(BlogVO vo);

	List<BlogVO> getBlogList(BlogVO vo);



}