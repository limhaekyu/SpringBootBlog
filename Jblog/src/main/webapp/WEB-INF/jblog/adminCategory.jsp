<%@page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ī�װ� ����</title>
<Link rel="stylesheet" href="css/theme.css">

</head>
<body background="images/kubrickbgcolor.jpg">
<center>
<table background="images/kubrickheader.jpg" width="760" height="200" border="0" cellpadding="0" cellspacing="0">
<tr><td height="60">&nbsp;</td></tr>
 
<!-- ��α� ����� �±�-->
<tr><td height="60" class="blogtitle">${blog.title }</td></tr>
<tr><td height="20" class="blogtag">${blog.tag }</td></tr>

<tr>
	<td align="right" height="60">
    	<a href="logout.do">�α׾ƿ�</a>&nbsp;&nbsp;<a href="blogmainView.do">�� ��α� ����</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
</tr>
</table>

<table background="images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
<tr><td height="10" colspan="10">&nbsp;</td></tr>
<tr>
	<td height="10" width="20">&nbsp;</td>
	<td width="530" valign="top" class="tdcontent">
		<!-- �޴� -->     
		<a class="title" href="adminBlogView.do"><b>�⺻����</b></a>&nbsp;&nbsp;
		<b>ī�װ�</b>&nbsp;&nbsp;
		<a class="title" href="adminPostView.do"><b>���ۼ�</b></a>&nbsp;&nbsp;
		
	</td>
</tr>
<tr><td height="5">&nbsp;</td></tr>
<tr>
	<td height="10">&nbsp;</td>
    <td>
    <!-- �۾� ȭ��--> 
    <c:if test="${categoryList != null}">        	     	
    <table width="720"  border="1" cellpadding="0" cellspacing="0">
    <tr>
		<td width="50" class="tablelabel">��ȣ</td>
		<td width="150" class="tablelabel">ī�װ���</td>
		<td width="80" class="tablelabel">���̱� ����</td>
		<td width="70" class="tablelabel">����Ʈ ��</td>
		<td width="280" class="tablelabel">����</td>
		<td width="70" class="tablelabel">����</td>      			
	</tr>

	<!-- �̺з� ī�װ� ���� �Ұ� -->
	<c:forEach var="category" items="${categoryList}">
	<tr>
		<td class="tablecontent" align="center">${category.categoryId }</td>
		<td class="tablecontent"><a href="updateCategoryView.do?categoryId=${category.categoryId }&blogId=${category.blogId}">${category.categoryName }</a></td>
		<c:if test="${category.displayType=='TITLE' }">
		<td class="tablecontent" align="center">����</td>
		</c:if>
		<c:if test="${category.displayType=='MIXED' }">
		<td class="tablecontent" align="center">����+����</td>
		</c:if>
		<td class="tablecontent" align="center">${category.cntDisplayPost }</td>
		<td class="tablecontent">${category.description }</td>
	
		<td class="tablecontent" align="center">&nbsp;
		<c:if test="${category.categoryName == '�̺з�' }">
		�����Ұ�
		</c:if>
		
		<c:if test="${category.categoryName != '�̺з�' }">
		<a href="deleteCategory.do?categoryId=${category.categoryId }"><img height="9" src="images/delete.jpg" border="0"></a>
		</c:if>
		</td>
		
	</tr>  
	</c:forEach>  		    					
    </table>
   	</c:if>
	
	<!-- ī�װ� ���-->
	<c:if test="${categoryFlag =='insertCategory'}">
    <form action="insertCategory.do" method="post">  
    <input name="blogId" value="${blog.blogId}" type="hidden"/> 
    <table width="720"  border="0" cellpadding="0" cellspacing="0">
		<tr><td height="5">&nbsp;</td></tr>
		<tr><td height="5">&nbsp;</td></tr>
		<tr><td class="tdcontent" height="5"><b>ī�װ� �߰�</b></td></tr>
		<tr><td height="5">&nbsp;</td></tr>      		
		<tr>
			<td width="150" class="inputlabel">ī�װ��� :</td>
			<td><input class="inputtext" type="text" size="40" name="categoryName"></td>
		</tr>
		<tr>
			<td width="150" class="inputlabel">���̱� ���� :</td>
			<td class="tdcontent">
 				<input type="radio" name="displayType" value="TITLE" checked>����&nbsp;&nbsp;
				<input type="radio" name="displayType" value="MIXED">����+����&nbsp;&nbsp;
			</td>      			
		</tr>
		<tr>
			<td width="150" class="inputlabel">����Ʈ �� :</td>
			<td class="tdcontent"><input class="inputtext" type="text" size="4" name="cntDisplayPost">��(1~20)</td>      			
      	</tr>
		<tr>
			<td width="150" class="inputlabel">���� :</td>
			<td><input class="inputtext" type="text" size="50" name="description"></td>
		</tr>
		<tr><td height="5">&nbsp;</td></tr>
		<tr>
			<td colspan="10" align="center">&nbsp;<input type="submit" value="ī�װ� �߰�"></td>
		</tr>      		      		
	</table>    
	</form> 
	</c:if>
      	
	<!-- ī�װ� ���� -->
	<c:if test="${categoryFlag =='updateCategory'}">
	<form action="updateCategory.do" method="post">   
    <input type="hidden" name="categoryId" value="${category.categoryId }"/>
    <table width="720"  border="0" cellpadding="0" cellspacing="0">
	    <tr><td height="5">&nbsp;</td></tr>
	    <tr><td height="5">&nbsp;</td></tr>
	    <tr><td class="tdcontent" height="5"><b>ī�װ� ����</b></td></tr>
	    <tr><td height="5">&nbsp;</td></tr>      		
	    <tr>
	    	<td width="150" class="inputlabel">ī�װ��� :</td>
	    	<td><input class="inputtext" type="text" size="40" name="categoryName" value="${category.categoryName }" ></td>
	    </tr>
	    <tr>
	    	<td width="150" class="inputlabel">���̱� ���� :</td>
	      	<td class="tdcontent">
	      		<input type="radio" name="displayType" value="TITLE"  <c:if test="${category.displayType == 'TITLE' }">checked</c:if>>����&nbsp;&nbsp;
	      		<input type="radio" name="displayType" value="MIXED" <c:if test="${category.displayType == 'MIXED' }">checked</c:if>>����+����&nbsp;&nbsp;
	      	</td>      			
		</tr>
		<tr>
			<td width="150" class="inputlabel">����Ʈ �� :</td>
			<td class="tdcontent"><input class="inputtext" type="text" size="4" name="cntDisplayPost" value="${category.cntDisplayPost }">��(1~20)</td>      			
		</tr>
		<tr>
			<td width="150" class="inputlabel">���� :</td>
			<td><input class="inputtext" type="text" size="50" name="description" value="${category.description }"></td>
		</tr>
		<tr><td height="5">&nbsp;</td></tr>
		<tr>
			<td colspan="10" align="center">&nbsp;<input type="submit" value="ī�װ� ����"></td>
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