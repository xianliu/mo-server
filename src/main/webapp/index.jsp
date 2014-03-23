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
		<form class="form-horizontal" action="userAction.action" method="post" role="form">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">用戶名：</label>
		    <div class="col-sm-10">
		      <input class="form-control" name="user.username" type="text" id="username" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" name="user.password" type="password" id="password" >
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">登录</button>
		      <a class="btn btn-default" href="shop!list.action">shopList</a>
		    </div>
		  </div>
		</form>
	</div>
</body>
</html>