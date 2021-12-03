package com.fastcampus.jblog.biz.post;

import java.util.Date;

import lombok.Data;

@Data
public class PostVO {
	private int postId;
	private int blogId;
	private int categoryId;
	private String title;
	private String content;
	private Date createdDate;
	

	private int cntDisplayPost;
	
	
}
