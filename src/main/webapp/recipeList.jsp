<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.form.min.js"></script>
	<script type="text/javascript" src="js/mo-recipeList.js"></script>
	<title>订单</title>
</head>
<body class="dishList">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">点餐平台</a>
			</div>
			
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">菜品</a></li>
				</ul>
			</div>
			
		</div>
	</nav>
	
	<div class="container">
		<table class="table table-hover table-striped">
	    	<thead>
	    		<th>#</th>
	    		<th>商店</th>
	    		<th>总价</th>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${recipeList}" varStatus="status" var="item" >
		    		<tr>
		    			<td>${status.index + 1}</td>
		    			<td>${item.shopId}</td>
		    			<td>${item.price}</td>
		    		</tr>
	    		</c:forEach>
	    	</tbody>	
		</table>
		
	</div>
</body>
</html>