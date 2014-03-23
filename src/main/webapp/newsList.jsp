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
	<script type="text/javascript" src="js/mo-newsList.js"></script>
	<title>新闻公告</title>
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
	    		<th>标题</th>
	    		<th>操作</th>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${newsList}" varStatus="status" var="item" >
	    		   <tr>
		    			<td>${status.index + 1}</td>
		    			<td>${item.title}</td>
		    			<td>
		    				<a class="news-edit" news-id="${item.id}" ><span class="glyphicon glyphicon-edit"></span></a>
		    				<a href="news!remove.action?id=${item.id}"><span class="glyphicon glyphicon-trash"></span></a>
		    			</td>
		    		</tr>
	    		</c:forEach>
	    	</tbody>	
		</table>
		
		<button id="add-news" class="btn btn-default">添加新闻公告</button>
		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">添加新闻公告</h4>
		      </div>
		      <form id="news-form" role="form" action="news!add.action" method="post">
		      	  <input name="id" type="hidden" id="id" />
			      <div class="modal-body">
					  <div class="form-group">
					    <label for="">标题：</label>
					    <input name="title" type="text" class="form-control" id="title" >
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">内容：</label>
					    <textarea name="content" type="text" class="form-control" id="content" ></textarea>
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