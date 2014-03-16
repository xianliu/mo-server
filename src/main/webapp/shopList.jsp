<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/mo-shopList.js"></script>
	<title>店铺</title>
</head>
<body class="shopList">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">点餐平台</a>
			</div>
			
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">店铺</a></li>
				</ul>
			</div>
			
		</div>
	</nav>
	
	<div class="container">
		<table class="table table-hover table-striped">
	    	<thead>
	    		<th>#</th>
	    		<th>店铺名</th>
	    		<th>店铺地址</th>
	    		<th>拥有者</th>
	    		<th>操作</th>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${shopList}" varStatus="status" var="item" >
	    		   <tr>
		    			<td class="shop-edit" id="${item.id}">${status.index + 1}</td>
		    			<td>${item.name}</td>
		    			<td>${item.location}</td>
		    			<td>${item.owner}</td>
		    			<td><a href="shop!remove.action?id=${item.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
		    		</tr>
	    		</c:forEach>
	    	</tbody>	
		</table>
		
		<button type="submit" class="btn btn-default" data-toggle="modal" data-target="#myModal">添加店铺</button>
		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">添加店铺</h4>
		      </div>
		      <form id="shop-form" role="form" action="shop!add.action" method="post">
		      	  <input name="id" type="hidden" id="id" />
			      <div class="modal-body">
					  <div class="form-group">
					    <label for="exampleInputEmail1">店铺名：</label>
					    <input name="name" type="text" class="form-control" id="name" >
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">店铺地址：</label>
					    <input name="location" type="text" class="form-control" id="location" >
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">拥有者：</label>
					    <input name="owner" type="text" class="form-control" id="owner" >
					  </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			        <button id="submit" type="submit" class="btn btn-primary">添加</button>
			      </div>
		      </form>
		    </div>
		  </div>
		</div>
		
	</div>
</body>
</html>