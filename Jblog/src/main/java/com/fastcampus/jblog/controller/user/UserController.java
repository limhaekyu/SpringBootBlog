package com.fastcampus.jblog.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.blog.BlogService;
import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.user.UserService;
import com.fastcampus.jblog.biz.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/loginView.do")
	public String loginView() {
		return "bloglogin";
	}

	@RequestMapping("/login.do")
	public String login(UserVO vo, BlogVO bvo,HttpSession session) {
		UserVO user = userService.getUser(vo);
		
		if(user != null) {
			// 로그인 성공한 경우 세션에 사용자 정보를 저장한다.
			session.setAttribute("user", user);
			// TO DO : 로그인 성공한 사용자가 블로그를 소유한 사용자인지 조회하여 세션에 등록한다.
			bvo.setBlogId(user.getUserId());
			BlogVO blog = blogService.getBlog(bvo);
			session.setAttribute("blog", blog);
			
		}
		// 인덱스 페이지로 이동한다.
		return "redirect:/";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
	



}
