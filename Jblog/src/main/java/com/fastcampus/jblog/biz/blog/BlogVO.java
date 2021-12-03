package com.fastcampus.jblog.biz.blog;

import lombok.Data;

@Data
public class BlogVO {
	private int blogId;
	private String title;
	private String tag;
	private int cntDisplayPost;
	private String status;
	private int userId;
	
	private String userName;
	private String searchCondition;
	private String searchKeyword;
}
