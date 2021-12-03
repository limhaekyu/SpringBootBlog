<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>블로그 생성</title>
<Link rel="stylesheet" href="css/theme.css">
</head>
<body>
<form action="/createBlog.do" method="post">
<table width="100%" height=320 border="0" cellpadding="0" cellspacing="0">
<tr>
	<td height=40 colspan="10">&nbsp;</td>
</tr>
<tr>
	<td width="100%" height="120" colspan="10" align="center">
	<img src="images/logo.jpg" border="0"></td>
</tr>
<tr>
	<td height="20" colspan="10" align="center" class="tdcontent">
		블로그 제목 : <input type="text" name="title" size="30">&nbsp;&nbsp;
	<input type="submit" value="블로그 생성"></td>
</tr>

<tr>
	<td align="center">
		<a href="/">인덱스 페이지로 이동</a>
	</td>
</tr>
</table>
</form>
</body>
</html>