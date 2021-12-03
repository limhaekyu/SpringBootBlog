<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JBlog 블로그 메인</title>
	<Link rel="stylesheet" href="css/theme.css">
</head>

<body background="images/kubrickbgcolor.jpg">
<center>
<table background="images/kubrickheader.jpg" width="760" height="200" border="0" cellpadding="0" cellspacing="0">
<tr><td height="60">&nbsp;</td></tr>
<!-- 블로그 제목과 태그 시작 -->
<tr><td height="60" class="blogtitle">${blog.title }</td></tr>
<tr><td height="20" class="blogtag">${blog.tag }</td></tr>
<!-- 블로그 제목과 태그 끝 -->      

<tr><td height="60">&nbsp;</td></tr>
</table>

<table background="images/kubrickbg.jpg" width="760" height="300" border="0" cellpadding="0" cellspacing="0">
<tr><td height="10">&nbsp;</td></tr>
<tr>
	<td width="20">&nbsp;</td>
	<td width="530" valign="top">
	<!-- 포스트 목록 시작 -->
	<table height="10" width="450" border="0" cellpadding="0" cellspacing="0">
	<c:forEach var="post" items="${postList }">
    	<tr><td class="posttitle">${post.title }</td><td align="right">
    	<c:if test="${user.userId == blog.blogId }">  
    	<a href="adminPostView.do?blogId=${post.blogId }&postId=${post.postId }">EDIT</a> / <a href="deletePost.do?blogId=${post.blogId }&postId=${post.postId }<c:if test="${category.categoryId!=null}">&categoryId=${category.categoryId}</c:if>">DEL</a>
    	</c:if>
    	</td></tr>    	
    	<tr><td class="postdate" colspan="2">${post.createdDate }</td></tr>
    	<c:if test="${category.displayType=='MIXED' || category.displayType==null }">
    	<tr><td class="postcontent" colspan="2">${post.content }</td></tr>
    	</c:if>
    	<tr><td height="5" colspan="2">&nbsp;</td></tr>
    	<tr><td class="postwriter" colspan="2">posted by ${user.id }</td></tr>
    	<tr><td class="postdate" colspan="2"></td></tr>	
	</c:forEach>
	</table>
   	<!-- 포스트 목록 끝-->       	  	
	</td>
	<td width="20">&nbsp;</td>
	<td width="190" valign="top">
    
	<!-- 로그인, 관리자 메뉴, 로고, 카테고리 시작 -->
	<table cellpadding="0" cellspacing="0">
	<tr>
    		<td>
    		<c:if test="${user == null }">
     		<a href="loginView.do">로그인</a>&nbsp;&nbsp;
     		</c:if>
     		<c:if test="${user != null }">
     		<a href="logout.do">로그아웃</a>&nbsp;&nbsp;  
     			<c:if test="${user.userId == blog.blogId }">   	
     			<a href="adminBlogView.do">블로그 관리</a>
     			</c:if>
     		</c:if>
		</td>
	</tr>	
	<tr><td height="5">&nbsp;</td></tr>
	<tr><td><img height="80" src="images/j2eelogo.jpg" border="0"></td></tr>
	<tr><td height="5">&nbsp;</td></tr>
	<tr><td class="categorytitle">카테고리</td></tr>
     	
	<tr>
     	<td class="categoryitem">
     	<a class="title" href="blogmainView.do?blogId=${blog.blogId }">전체 보기</a><br>
		<c:forEach var="category" items="${categoryList }">
		<a class="title" href="blogmainView.do?blogId=${category.blogId }&categoryId=${category.categoryId }">${category.categoryName }</a><br>
		</c:forEach>
	</td>
     	</tr>
     	
	<tr><td height="5">&nbsp;</td></tr>
	<tr><td align="center"><a href="#"><img width="80" src="images/logo.jpg" border="0"></a></td></tr>
	</table>
	<!-- 로그인, 관리자 메뉴, 로고, 카테고리 끝 -->
	</td>
	</tr>
</table>

<table background="images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
<tr>
	<td class="blogfooter">SPRING Stories is powered by JBlog</td>
</tr>
</table>
</center>
   	
</body>
</html>