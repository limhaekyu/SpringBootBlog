package com.fastcampus.jblog.biz.category;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface CategoryService {

	void insertCategory(CategoryVO vo);

	void updateCategory(CategoryVO vo);

	void deleteCategory(CategoryVO vo);

	CategoryVO getCategory(CategoryVO vo);

	List<CategoryVO> getCategoryList(CategoryVO vo);

}