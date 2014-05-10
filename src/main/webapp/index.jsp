<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/mo-index.css" />
	<title>登录</title>
</head>
<body class="index">
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="news!list.action">新闻公告</a>
			<a class="navbar-brand" href="#">点餐</a>
		</div>
	</div>
	</nav>
	
	<div class="container">
		<a class="btn btn-default" href="news!list.action">新闻管理</a>
		<a class="btn btn-default" href="shop!list.action">店铺管理</a>
		<a class="btn btn-default" href="recipe!list.action">订单管理</a>
		<% if(request.isUserInRole("admin")) { %>
		<a class="btn btn-default" href="user!list.action">用户管理</a>
		<% } %>
	</div>
</body>
</html>