package com.fastcampus.jblog.biz.category;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.common.JDBCUtil;
import com.fastcampus.jblog.biz.user.UserVO;

@Repository
public class CategoryDAO implements CategoryService {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	private final String CATEGORY_INSERT = "insert into category(blog_id, category_id, category_name, display_type ,cnt_display_post, description, created_date, modified_date) values (?, (select nvl(max(category_id), 0) + 1 from category), ?, ?, ?, ?, now(), now())";
	private final String CATEGORY_UPDATE = "update category set category_name = ?, display_type = ?, cnt_display_post = ?, description = ?, modified_date = now() where category_id = ?";
	private final String CATEGORY_DELETE = "delete category where category_id = ?";
	private final String CATEGORY_GET = "select * from category where category_id = ?";
	private final String CATEGORY_LIST = "select * from category where blog_id = ? order by category_id asc";
	
	public void insertCategory(CategoryVO vo) {
		try {	
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_INSERT);
			stmt.setInt(1, vo.getBlogId());
			stmt.setString(2, vo.getCategoryName());
			stmt.setString(3, vo.getDisplayType());
			stmt.setInt(4, vo.getCntDisplayPost());
			stmt.setString(5, vo.getDescription());

			stmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// JDBC 5단계 : Connection 종료
			JDBCUtil.close(stmt, conn);
		}
	}
	public void updateCategory(CategoryVO vo) {

		try {	
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_UPDATE);
			stmt.setString(1, vo.getCategoryName());
			stmt.setString(2, vo.getDisplayType());
			stmt.setInt(3, vo.getCntDisplayPost());
			stmt.setString(4, vo.getDescription());
			stmt.setInt(5, vo.getCategoryId());
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// JDBC 5단계 : Connection 종료
			JDBCUtil.close(stmt, conn);
		}
	}
	public void deleteCategory(CategoryVO vo) {
		try {	
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_DELETE);
			stmt.setInt(1, vo.getCategoryId());
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// JDBC 5단계 : Connection 종료
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public CategoryVO getCategory(CategoryVO vo) {
		CategoryVO category = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_GET);
			stmt.setInt(1, vo.getCategoryId());
			rs = stmt.executeQuery();
			if(rs.next()) {
				category = new CategoryVO();
				category.setCategoryName(rs.getString("CATEGORY_NAME"));
				category.setDisplayType(rs.getString("DISPLAY_TYPE"));
				category.setCntDisplayPost(rs.getInt("CNT_DISPLAY_POST"));
				category.setDescription(rs.getString("DESCRIPTION"));				
				category.setModifiedDate(rs.getDate("MODIFIED_DATE"));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return category;
	}
	
	public List<CategoryVO> getCategoryList(CategoryVO vo) {
		List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CATEGORY_LIST);
			
			stmt.setInt(1, vo.getBlogId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				CategoryVO category = new CategoryVO();
				category.setBlogId(rs.getInt("BLOG_ID"));
				category.setCategoryId(rs.getInt("CATEGORY_ID"));
				category.setCategoryName(rs.getString("CATEGORY_NAME"));
				category.setDisplayType(rs.getString("DISPLAY_TYPE"));
				category.setCntDisplayPost(rs.getInt("CNT_DISPLAY_POST"));	
				category.setDescription(rs.getString("DESCRIPTION"));
				
				categoryList.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return categoryList;
	}
	
}
