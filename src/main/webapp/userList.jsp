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
	<script type="text/javascript" src="js/mo-userList.js"></script>
	
	<title>菜品</title>
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
	    		<th>用户名</th>
	    		<th>角色</th>
	    		<th>操作</th>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${userList}" varStatus="status" var="item" >
		    		<tr>
		    			<td>${status.index + 1}</td>
		    			<td>${item.username}</td>
		    			<td>${item.role}</td>
		    			<td>
		    				<a class="user-edit" user-id="${item.id}" ><span class="glyphicon glyphicon-edit"></span></a>
		    				<a href="user!remove.action?id=${item.id}"><span class="glyphicon glyphicon-trash"></span></a>
		    			</td>
		    		</tr>
	    		</c:forEach>
	    	</tbody>	
		</table>
		
		<button id="add-user" class="btn btn-default" >添加用户</button>
		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">添加用户</h4>
		      </div>
		      <form id="user-form" role="form" action="user!add.action" method="post">
		      	  <input name="id" type="hidden" id="id" />
			      <div class="modal-body">
					  <div class="form-group">
					    <label>用户名：</label>
					    <input name="username" type="text" class="form-control" id="username" >
					  </div>
					  <div class="form-group">
					    <label>密码：</label>
					    <input name="password" type="password" class="form-control" id="password" >
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">角色：</label>
					    <select name="role" class="form-control" id="role">
						  <option value="normal" >普通用户</option>
						  <option value="admin" >超级管理员</option>
						</select>
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