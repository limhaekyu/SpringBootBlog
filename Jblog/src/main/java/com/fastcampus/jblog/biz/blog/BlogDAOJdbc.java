package com.fastcampus.jblog.biz.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.fastcampus.jblog.biz.common.JDBCUtil;
import com.fastcampus.jblog.biz.user.UserVO;

@Repository
public class BlogDAOJdbc implements BlogService {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	private final String BLOG_INSERT = "insert into blog(blog_id, title, tag, cnt_display_post, status, user_id) values (?, ?, ?, ?, ?, ?)";
	private final String BLOG_UPDATE = "update blog set title = ?, tag = ?, cnt_display_post = ? where blog_id = ?";
	private final String BLOG_DELETE = "delete blog where blog_id = ?";
	private final String BLOG_STATUS_CHANGE 	= "update blog set status='삭제요청' where blog_id=?";
	private final String BLOG_GET = "select * from blog where blog_id = ?";
	private final String BLOG_LIST_TI = "select TITLE, USER_NAME, STATUS, TAG from  BLOG_USER u, BLOG b where u.USER_ID = b.USER_ID and title like '%'||?||'%' order by title";
	private final String BLOG_LIST_TG = "select TITLE, USER_NAME, STATUS,TAG from  BLOG_USER u, BLOG b where u.USER_ID = b.USER_ID and tag like '%'||?||'%' order by tag";
	private final String BLOG_LIST_BG = "select TITLE, USER_NAME, STATUS, TAG from  BLOG_USER u, BLOG b where u.USER_ID = b.USER_ID and user_name like '%'||?||'%' order by user_name";
	
	public void createBlog(BlogVO vo, HttpSession session) {
		
		UserVO user = (UserVO)session.getAttribute("user");
		try {	
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_INSERT);
			stmt.setInt(1, user.getUserId());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, "Tag");
			stmt.setInt(4, 0);
			stmt.setString(5, "운영중");
			stmt.setInt(6, user.getUserId());
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// JDBC 5단계 : Connection 종료
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateBlog(BlogVO vo) {
		try {	
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getTag());
			stmt.setInt(3, vo.getCntDisplayPost());
			stmt.setInt(4, vo.getBlogId());
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// JDBC 5단계 : Connection 종료
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void DeleteBlogReq(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_STATUS_CHANGE);
			stmt.setInt(1, vo.getBlogId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}	
	}
	
	public void deleteBlog(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_DELETE);
			stmt.setInt(1, vo.getBlogId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public BlogVO getBlog(BlogVO vo) {
		BlogVO blog = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_GET);
			stmt.setInt(1, vo.getBlogId());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				blog = new BlogVO();
				blog.setBlogId(rs.getInt("BLOG_ID"));
				blog.setTitle(rs.getString("TITLE"));
				blog.setTag(rs.getString("TAG"));
				blog.setCntDisplayPost(rs.getInt("CNT_DISPLAY_POST"));
				blog.setStatus(rs.getString("STATUS"));
				blog.setUserId(rs.getInt("USER_ID"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			 JDBCUtil.close(rs,stmt,conn);
		}
		return blog;
	}
	
	public List<BlogVO> getBlogList(BlogVO vo) {
		List<BlogVO> blogList = new ArrayList<BlogVO>();
		try { 
			conn = JDBCUtil.getConnection();
			if(vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BLOG_LIST_TI);
			} else if(vo.getSearchCondition().equals("TAG")) {
				stmt = conn.prepareStatement(BLOG_LIST_TG);
			} else if(vo.getSearchCondition().equals("BLOGGER")) {
				stmt = conn.prepareStatement(BLOG_LIST_BG);
			}
			stmt.setString(1,  vo.getSearchKeyword());
			rs = stmt.executeQuery();
			while(rs.next()) {
				BlogVO blog = new BlogVO();
				blog.setTitle(rs.getString("TITLE"));
				blog.setUserName(rs.getString("USER_NAME"));
				blog.setStatus(rs.getString("STATUS"));
				blogList.add(blog);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			 JDBCUtil.close(rs, stmt, conn);
		}
		return blogList;
	}

	
	
}
