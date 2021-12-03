package com.fastcampus.jblog.biz.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.fastcampus.jblog.biz.category.CategoryVO;

public interface PostService {

	void insertPost(PostVO pvo);

	void updatePost(PostVO vo);

	void deletePost(PostVO vo);

	PostVO getPost(PostVO vo);

	List<PostVO> getPostList(PostVO vo);

}