package com.fastcampus.jblog.controllerPost;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.category.CategoryService;
import com.fastcampus.jblog.biz.category.CategoryVO;
import com.fastcampus.jblog.biz.post.PostService;

@Controller
public class CategoryController {


	@Autowired
	private PostService postService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/adminCategoryView.do")
	public String categoryAdminView(CategoryVO cvo,HttpSession session ,Model model) {
		if(cvo.getBlogId()==0) {
			BlogVO blog = (BlogVO) session.getAttribute("blog");
			cvo.setBlogId(blog.getBlogId());
		}
		
		List<CategoryVO> categoryList = categoryService.getCategoryList(cvo);
		model.addAttribute("categoryList", categoryList);
		
		model.addAttribute("categoryFlag", "insertCategory");
		return "adminCategory";
	}
	

	@RequestMapping("/insertCategory.do")
	public String insertCategory(CategoryVO cvo, Model model) {
		
		categoryService.insertCategory(cvo);
		
		model.addAttribute("categoryFlag", "insertCategory");
					
		return "forward:/adminCategoryView.do";
		
	}
	
	@RequestMapping("updateCategoryView.do") 
	public String updateCategoryView(CategoryVO cvo, Model model) {
		// 카테고리 목록 가져오기
		List<CategoryVO> categoryList = categoryService.getCategoryList(cvo);
		model.addAttribute("categoryList", categoryList);
	
		// 사용자가 클릭한 카테고리 하나를 조회하여 Model에 등록한다.
		CategoryVO category = categoryService.getCategory(cvo);
		model.addAttribute("category", category);		
		
		// 카테고리 목록화면에서 수정
		model.addAttribute("categoryFlag", "updateCategory");
			
		return "adminCategory";	
	}
	
	
	@RequestMapping("updateCategory.do")
	public String updateCategory(CategoryVO cvo, Model model) {
		// 1. 카테고리 업데이트
		categoryService.updateCategory(cvo);	
		
		//  카테고리 플래그 변경
		model.addAttribute("categoryFlag", "insertCategory");
		return "forward:/adminCategory.do";
		
	}
	
	@RequestMapping("deleteCategory.do")
	public String deleteCategory(CategoryVO cvo) {
		categoryService.deleteCategory(cvo);
		return "forward:/adminCategoryView.do";
	}
	
}
