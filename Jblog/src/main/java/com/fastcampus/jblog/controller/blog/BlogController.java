package com.fastcampus.jblog.controller.blog;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.blog.BlogService;
import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.category.CategoryService;
import com.fastcampus.jblog.biz.category.CategoryVO;
import com.fastcampus.jblog.biz.post.PostService;
import com.fastcampus.jblog.biz.post.PostVO;
import com.fastcampus.jblog.biz.user.UserVO;


@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostService postService;
	
	// 인덱스 페이지에 대한 요청 처리
	@RequestMapping("/")
	public String index() {
		return "forward:/index.jsp";
	}
	
	@RequestMapping("/blogmainView.do")
	public String blogmainView(BlogVO bvo, CategoryVO cvo, PostVO pvo, HttpSession session, Model model) {
		// 내블로그 가기
		if(bvo.getBlogId() == 0) {
			BlogVO blog = (BlogVO) session.getAttribute("blog");
			bvo.setBlogId(blog.getBlogId());
			cvo.setBlogId(blog.getBlogId());
			pvo.setBlogId(blog.getBlogId());
		}
		// 블로그 정보 Model에 등록
		BlogVO blog = blogService.getBlog(bvo);
		model.addAttribute("blog",blog);

		if(pvo.getTitle() != null) {
			pvo.setCategoryId(0);
			cvo.setCategoryId(0);
		}
		
		if(cvo.getCategoryId() != 0) {
			pvo.setCategoryId(cvo.getCategoryId());
		}	
		// 포스트 목록 Model에 등록
		List<PostVO> postList = postService.getPostList(pvo);
		model.addAttribute("postList", postList);

		// 카테고리목록 Model에 등록
		List<CategoryVO> categoryList = categoryService.getCategoryList(cvo);
		model.addAttribute("categoryList", categoryList);
		
		CategoryVO category = categoryService.getCategory(cvo);
		model.addAttribute("category", category);
		
		return "blogmain";
	}
	
	@RequestMapping("/adminBlogView.do")
	public String blogAdminView() {
		return "adminBlog";
	}
	

	
	
	@RequestMapping("/createBlogView.do")
	public String blogcreateView() {
		return "blogcreate";
	}
	
	@RequestMapping("/createBlog.do")
	public String blogcreate(BlogVO bvo, UserVO vo, HttpSession session) {
		
		blogService.createBlog(bvo,session);
		// 로직 처리 후, 이동할 화면을 문자열로 리턴하면 자동으로 forwarding된다.
		
		session.setAttribute("userBlog", vo);
		
		return "forward:/";
	}
	

	
	@RequestMapping("/deleteBlog.do")
	public String deleteBlog(BlogVO vo) {
		blogService.deleteBlog(vo);
		return "forward:/";
	}
	
	@RequestMapping("/deleteBlogRequest.do")
	public String deleteBlogReq(BlogVO vo) {
		return "forward:/getBlogList.do";
	}
	
	@RequestMapping("/updateBlog.do")
	public String updateBlog(BlogVO vo, HttpSession session) {
	
			blogService.updateBlog(vo);		
			BlogVO blog = blogService.getBlog(vo);
			session.setAttribute("blog", blog);	
		
			return "redirect:/blogmainView.do";
	}
	
	@RequestMapping("/getBlog.do")
	public String getBlog(BlogVO vo) {
		return null;
	}
	
	@RequestMapping("/getBlogList.do")
	public String getBlogList(BlogVO vo, Model model) {
		
		
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		model.addAttribute("blogList", blogService.getBlogList(vo));
		model.addAttribute("search",vo);
		return "forward:/";
	}
	
	
}
