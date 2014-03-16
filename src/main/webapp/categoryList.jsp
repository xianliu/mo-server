<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<title>登录</title>
</head>
<body class="categoryList">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">点餐平台</a>
			</div>
			
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">菜品分类</a></li>
				</ul>
			</div>
			
		</div>
	</nav>
	
	<div class="container">
		<table class="table table-hover table-striped">
	    	<thead>
	    		<th>#</th>
	    		<th>菜品种类</th>
	    		<th>操作</th>
	    	</thead>
	    	<tbody>
	    		<tr>
	    			<td>1</td>
	    			<td>汤菜</td>
	    			<td><span class="glyphicon glyphicon-trash"></span></td>
	    		</tr>
	    		<tr>
	    			<td>2</td>
	    			<td>炒菜</td>
	    			<td><span class="glyphicon glyphicon-trash"></span></td>
	    		</tr>
	    	</tbody>	
		</table>
		
	</div>
</body>
</html>