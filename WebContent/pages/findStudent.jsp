<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学员信息</title>
</head>

<style>
	*{
	
	}
	td{
	width:80px;
	text-align:center;
	border: 1px solid black;
	}
	table tr:nth-child(odd) {
	background-color: lightyellow;
	}
	table tr:nth-child(even) {
	background-color: lightblue;
	}

</style>
<body>
<div style="margin-top: 100px;margin-left: 530px;">

<table cellpadding="0" cellspacing="0">
	<tr style="background-color: lightgreen;">
		<td>学员编号</td>
		<td>名字</td>
		<td>性别</td>
		<td>年龄</td>
		<td>家庭地址</td>
		<td>邮箱</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list }" var="i">
		<tr>
			<td>${i.id }</td>
			<td><a href="${pageContext.request.contextPath }/StudentServlet?status=findStudent&id=${i.id}">${i.name }</a></td>
			<td>${i.sex }</td>
			<td>${i.age }</td>
			<td>${i.adress }</td>
			<td>${i.email }</td>
			<td><a href="${pageContext.request.contextPath }/StudentServlet?status=deleteStudent&id=${i.id}">删除</a></td>
		</tr>
	</c:forEach>
</table>

</div>


</body>
</html>