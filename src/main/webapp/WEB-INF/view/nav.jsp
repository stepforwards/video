<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="<c:url value="/js/jquery-1.12.4.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<link rel="icon" type="image/x-icon" href="<c:url value="/img/favicon.ico"/>" />
<style type="text/css">
    	body{
    		 background-color: white;
   			 color: black;
   			 text-shadow: 0 0 50px black;
   			 -moz-user-select: none
    	}
</style>
    
<title>导航栏</title>
</head>
<body>
	<div class="container-fluid" style="background-color: #222;">
	  	<div class="container">
	  		<!--导航栏-->
		  	<nav class="navbar navbar-inverse" style="margin-bottom: 0;">
		      <div class="container-fluid">
		        <!-- Brand and toggle get grouped for better mobile display -->
		        <div class="navbar-header">
		          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		          <a class="navbar-brand" href="<c:url value="/video/videoManagementList.action"/>">视频管理系统</a>
		        </div>
		
		        <!-- Collect the nav links, forms, and other content for toggling -->
		        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
		          <ul class="nav navbar-nav">
		            <li ${param.fromJsp eq "video" ? "class='active'" : "" }><a href="<c:url value="/video/videoManagementList.action"/>">视频管理</a></li>
		            <li ${param.fromJsp eq "speaker" ? "class='active'" : "" }><a href="<c:url value="/speaker/speakerManagementList.action"/>">主讲人管理</a></li>
		            <li ${param.fromJsp eq "course" ? "class='active'" : "" }><a href="<c:url value="/course/courseManagementList.action"/>">课程管理</a></li>
		            <li ${param.fromJsp eq "statistical" ? "class='active'" : "" }><a href="<c:url value="/statistical/statisticalAnalysis.action"/>">统计分析</a></li>
		          </ul>
		          <ul class="nav navbar-nav navbar-right">
		          	<li><a href="#">admin</a></li>
		          	<li><a href="login.html" class="glyphicon glyphicon-log-out"></a></li>
		          </ul>
		        </div><!-- /.navbar-collapse -->
		      </div><!-- /.container-fluid -->
		    </nav>
		</div>
	</div>
</body>
</html>