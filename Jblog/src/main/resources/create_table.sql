DROP TABLE POST CASCADE CONSTRAINTS;
DROP TABLE CATEGORY CASCADE CONSTRAINTS;
DROP TABLE BLOG CASCADE CONSTRAINTS;
DROP TABLE BLOG_USER CASCADE CONSTRAINTS;


CREATE TABLE BLOG_USER (
	USER_ID NUMBER(10),
	ID          VARCHAR2(10) NOT NULL,
	USER_NAME        VARCHAR2(100)    	NOT NULL,
	ROLE             VARCHAR2(32)     	NOT NULL,
	PASSWORD         VARCHAR2(28), 
	PRIMARY KEY ( USER_ID ) 
);   


CREATE TABLE BLOG (
	BLOG_ID            NUMBER(10) 	NOT NULL,
	TITLE              VARCHAR2(100) 	NOT NULL,
	TAG                VARCHAR2(500),
	CNT_DISPLAY_POST   NUMBER,
	STATUS             VARCHAR2(20),
	USER_ID            NUMBER(10),
  	CONSTRAINT PK_BLOG PRIMARY KEY (BLOG_ID),
  	CONSTRAINT FK_BLOG_BLOG_ID FOREIGN KEY (USER_ID) REFERENCES BLOG_USER(USER_ID) ON DELETE CASCADE 
);


CREATE TABLE CATEGORY (
	BLOG_ID 			NUMBER(10) 		NOT NULL,
	CATEGORY_ID 		NUMBER(10) 	NOT NULL,
	CATEGORY_NAME 		VARCHAR2(500) NOT NULL,
	DISPLAY_TYPE 		VARCHAR2(10) 	NOT NULL,
	CNT_DISPLAY_POST 	NUMBER 	NOT NULL,
	DESCRIPTION 		VARCHAR2(1000),
	CREATED_DATE 		DATE ,
	MODIFIED_DATE 		DATE,
  	CONSTRAINT PK_CATEGORY PRIMARY KEY (CATEGORY_ID),
  	CONSTRAINT FK_CATEGORY_BLOG_ID  FOREIGN KEY(BLOG_ID) REFERENCES BLOG(BLOG_ID) ON DELETE CASCADE 
);


CREATE TABLE POST (
	POST_ID NUMBER(10) NOT NULL,
	CATEGORY_ID NUMBER(10) NOT NULL,
	TITLE   VARCHAR2(500) NOT NULL,
	CONTENT VARCHAR2(1000),
	CREATED_DATE DATE,
 	CONSTRAINT PK_POST PRIMARY KEY (POST_ID),
 	CONSTRAINT FK_POST_CATEGORY_ID  FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORY(CATEGORY_ID) ON DELETE CASCADE 
);


INSERT INTO BLOG_USER (USER_ID, ID, USER_NAME, ROLE, PASSWORD)
VALUES(1, 'admin','관리자','ADMIN','admin123');

INSERT INTO BLOG_USER (USER_ID, ID, USER_NAME, ROLE, PASSWORD)
VALUES(2, 'user','일반회원','USER','user123');

COMMIT;


