package com.fastcampus.jblog.controllerCategory;

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
import com.fastcampus.jblog.biz.post.PostVO;

@Controller
public class PostController {


	@Autowired
	private PostService postService;
	@Autowired
	private CategoryService categoryService;


	
	@RequestMapping("/adminPostView.do")
	public String adminPost(PostVO postVO, CategoryVO categoryVO, Model model, HttpSession session) {
		String postFlag = "insertPost";
		
		model.addAttribute("postFlag", "insertPost");
		if(categoryVO.getBlogId() == 0) {
			BlogVO blog = (BlogVO) session.getAttribute("blog");
			categoryVO.setBlogId(blog.getBlogId());
		}	
	
		List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
		model.addAttribute("categoryList", categoryList);
		
		if(postVO.getPostId() != 0) {
			postFlag = "updatePost";
			
			PostVO post = postService.getPost(postVO);
			model.addAttribute("post", post);				
		}
			
		model.addAttribute("postFlag", postFlag);
		
		return "adminPost";
	}
	@RequestMapping("/deletePost.do")
	public String postDelete(PostVO vo ) {
		postService.deletePost(vo);
		return "redirect:blogmainView.do";
	}

	@RequestMapping("/updatePost.do")
	public String updatePost(PostVO vo, Model model) {
		postService.updatePost(vo);
		return "forward:/blogmainView.do";
	}

	
	@RequestMapping("/insertPost.do")
	public String insertPost(PostVO pvo,  Model model) {
		postService.insertPost(pvo);
		return "redirect:/blogmainView.do";
	}
}
