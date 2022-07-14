<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin-top: 100px;margin-left: 680px;">
<form action="${pageContext.request.contextPath }/StudentServlet?status=updateStudent&id=${student.id}" method="post">
		名称：<input type="text" name="name" value="${ student.name}"}><br>
		性别：<input type="text" name="sex" value="${student.sex }"><br>
		年龄：<input type="text" name="age" value="${student.age }"><br>
		地址：<input type="text" name="adress" value="${student.adress }"><br>
		邮箱：<input type="text" name="email" value="${student.email }"><br>
		<input type="submit" value="提交">
	</form>
</div>
	
	
</body>
</html>