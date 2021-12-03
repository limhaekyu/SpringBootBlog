package com.fastcampus;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastcampus.jblog.biz.common.JDBCUtil;

@SpringBootTest
class ConnectionTest {

	@Test
	void contextLoads() {
		Connection conn = JDBCUtil.getConnection();
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
