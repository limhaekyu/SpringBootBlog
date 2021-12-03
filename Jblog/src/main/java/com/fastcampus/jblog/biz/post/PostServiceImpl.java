package com.fastcampus.jblog.biz.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.fastcampus.jblog.biz.category.CategoryVO;

public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO postDAO;
	
	@Override
	public void insertPost(PostVO pvo) {
		postDAO.insertPost(pvo);
	}

	@Override
	public void updatePost(PostVO vo) {
		postDAO.updatePost(vo);
	}

	@Override
	public void deletePost(PostVO vo) {
		postDAO.deletePost(vo);
	}

	@Override
	public PostVO getPost(PostVO vo) {
		return postDAO.getPost(vo);
	}

	@Override
	public List<PostVO> getPostList(PostVO vo) {
		return postDAO.getPostList(vo);
	}

}
