<%@page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>내 블로그</title>
<Link rel="stylesheet" href="css/theme.css">

</head>
<body background="images/kubrickbgcolor.jpg">
<center>
<table background="images/kubrickheader.jpg" width="760" height="200" border="0" cellpadding="0" cellspacing="0">
<tr><td height="60">&nbsp;</td></tr>

<!-- 블로그 제목과 태그 -->
<tr><td height="60" class="blogtitle">${blog.title }</td></tr>
<tr><td height="20" class="blogtag">${blog.tag }</td></tr>
 
<tr>
	<td align="right" height="60">
		<a href="logout.do">로그아웃</a>&nbsp;&nbsp;<a href="blogmainView.do">내 블로그 메인</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
</tr>
</table>

<table background="images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
<tr><td height="10" colspan="10">&nbsp;</td></tr>
<tr>
	<td height="10" width="20">&nbsp;</td>
   	<td width="530" valign="top" class="tdcontent">
     	<!-- 메뉴 -->     
     	<a class="title" href="adminBlogView.do"><b>기본설정</b></a>&nbsp;&nbsp; 
     	<a class="title" href="adminCategoryView.do"><b>카테고리</b></a>&nbsp;&nbsp;
     	<b>글작성</b>&nbsp;&nbsp;
     	
	</td>
</tr>
<tr><td height="5">&nbsp;</td></tr>
<tr>
	<td height="10">&nbsp;</td>
	<td>
	
	<!-- 수정 화면 -->  
	<c:if test="${postFlag =='updatePost'}">
	<form action="updatePost.do" method="post">  
	<input name="postId" value="${post.postId }" type="hidden" > 	
	<table width="720"  border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="50" class="inputlabel">제목 :</td>
		<td width="390"><input class="inputtext" type="text" size="56" name="title" value="${post.title }"></td>
		<td width="300">
		<select class="inputtextarea" name="categoryId">
				<c:forEach var="category" items="${categoryList }">
					<option value="${category.categoryId}" <c:if test="${category.categoryId == post.categoryId}"> selected="selected"</c:if>>${category.categoryName }</option>
				</c:forEach>				
			</select>
      	</td>
 	</tr>
	<tr>
		<td width="50" class="inputlabel">내용 :</td>
		<td colspan="10"><textarea name="content" class="inputtextarea" rows="10" cols="69" >${post.content }</textarea></td>
	</tr>
	<tr><td height="5">&nbsp;</td></tr>
	<tr>
		<td colspan="10" align="center">&nbsp;<input type="submit" value="수정하기"></td>
	</tr>
	</table>
	</form> 
	</c:if>
	
	<!-- 등록 화면-->
	<c:if test="${postFlag =='insertPost'}">
	<form action="insertPost.do" method="post">       
	<input name="blogId" value="${blog.blogId}" type="hidden"> 
	<table width="720"  border="0" cellpadding="0" cellspacing="0">
 	<tr>
		<td width="50" class="inputlabel">제목 :</td>
		<td width="390"><input class="inputtext" type="text" size="56" name="title"></td>
		<td width="300">
			<select class="inputtextarea" name="categoryId">
				<c:forEach var="category" items="${categoryList }">
					<option value="${category.categoryId}" >${category.categoryName }</option>
				</c:forEach>				
			</select>
		</td>
	</tr>
	<tr>
		<td width="50" class="inputlabel">내용 :</td>
		<td colspan="10"><textarea name="content" class="inputtextarea" rows="10" cols="69"></textarea></td>
	</tr>
	<tr><td height="5">&nbsp;</td></tr>
	<tr>
		<td colspan="10" align="center">&nbsp;<input type="submit" value="확인"></td>
	</tr>
	</table>
	</form>
	</c:if>
	</td>
</tr>
<tr><td height="10" colspan="10">&nbsp;</td></tr>
</table>

<table background="images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
<tr>
	<td class="blogfooter">SPRING Stories is powered by JBlog</td>
</tr>
</table>
</center>   	
</body>
</html>