<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<!--引入模板-->
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/js/jquery-1.12.4.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <link rel="icon" type="image/x-icon" href="<c:url value="/img/favicon.ico"/>" />
    <style type="text/css">
    	body{
    		 background-color: #acacac;
   			 color: black;
   			 text-shadow: 0 0 50px black;
   			 -moz-user-select: none
    	}
    </style>
    
  </head>
  <body>
  	<div class="container">
	  	<form action="<c:url value="/admin/login.action"/>" method="post">
			<div class="form-group" style="width: 309px;margin: 300px auto;">
				<div style="background-image: url(${pageContext.request.contextPath }/img/logo.png); width: 309px; height: 76px ; margin: 10px 0;"></div>
				<input type="text" name="username" class="form-control" placeholder="Username" style="margin: 10px 0;">
				<input type="password" name="password" class="form-control" placeholder="Password" style="margin: 10px 0;">
				<button type="submit" class="btn btn-success" style="width: 309px;">登录</button>
			</div>
		</form>
		<div style="text-align: center;">智游教育 © 豫ICP备17000832号 河南智游臻龙教育科技有限公司</div>
  	</div>
  </body>
</html>