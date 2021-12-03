<%@page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>블로그 관리</title>
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
		<b>기본설정</b>&nbsp;&nbsp;
		<a class="title" href="adminCategoryView.do"><b>카테고리</b></a>&nbsp;&nbsp;
		<a class="title" href="adminPostView.do"><b>글작성</b></a>&nbsp;&nbsp;		
		
	</td> 
</tr>
<tr><td height="5">&nbsp;</td></tr>

<tr>
	<td height="10">&nbsp;</td>
	<td>
	<!-- 상세 화면  시작 -->  
	<form action="updateBlog.do" method="post">      	
	<input name="blogId" value="${blog.blogId}" type="hidden">
	<table width="720"  border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="150" class="inputlabel">블로그 제목 :</td>
			<td><input class="inputtext" type="text" size="40" name="title" value="${blog.title }"></td>
		</tr>
		<tr>
			<td width="150" class="inputlabel">블로그 태그 :</td>
			<td><input class="inputtext" type="text" size="50" name="tag" value="${blog.tag }"></td>
		</tr>
		<tr>
			<td width="150" class="inputlabel">메인페이지 포스트  :</td>
			<td><input class="inputtext" type="text" size="4" name="cntDisplayPost" value="${blog.cntDisplayPost }"></td>      			
  		</tr>
  		<tr>
  			<td width="150" class="inputlabel">로고이미지  :</td>
  			<td>&nbsp;<img height="80" src="images/j2eelogo.jpg" border="0"></td>      			
  		</tr>   
      	<tr>
   	    	<td height="40" colspan="10" align="center">
   	    		<input type="submit" value="확인">
			</td>
   		</tr>               		
	</table>
  	</form>   
  	<!-- 상세 화면  끝 -->           	      	
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