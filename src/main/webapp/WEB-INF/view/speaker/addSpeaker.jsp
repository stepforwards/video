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
    <title>主讲人管理</title>
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
  	<jsp:include page="/WEB-INF/view/nav.jsp">
	  	<jsp:param value="speaker" name="fromJsp"/>
  	</jsp:include>
	<div class="container">
		<div class="jumbotron" style="padding-left: 20px; padding-top: 1px;background-image: url(<c:url value="/img/context.jpg"/>); background-size: 100% 100%;">
			<h2>添加主讲人-主讲人管理</h2>
		</div>
		
		<form class="form-horizontal" action="<c:url value="/speaker/addSpeaker.action"/>" method="post">
			<div class="form-group">
				<label for="inputTitle" class="col-sm-2 control-label">名字</label>
				<div class="col-sm-10">
					<input type="text" name="speakerName" class="form-control" id="inputTitle" placeholder="主讲人姓名">
				</div>
			</div>
			<div class="form-group">
				<label for="inputVideoTime" class="col-sm-2 control-label">职业</label>
				<div class="col-sm-10">
					<input type="text" name="speakerJob" class="form-control" id="inputVideoTime" placeholder="主讲人职业">
				</div>
			</div>
			<div class="form-group">
				<label for="inputImage" class="col-sm-2 control-label">头像图片</label>
				<div class="col-sm-10">
					<input type="text" name="speakerHeadUrl" class="form-control" id="inputImage" placeholder="主讲人头像地址，网络图片">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="speakerDescr" rows="3" style="resize: none;"></textarea>
					<button type="submit" class="btn btn-primary" style="margin-top: 10px;">保存</button>
					<a href="javascript:history.go(-1)" class="btn btn-default" style="margin-top: 10px;">返回列表</a>
				</div>
			</div>
		</form>
		<%@ include file="../footer.jsp" %>
  	</div>
  </body>
</html>