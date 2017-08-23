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
    <title>添加课程</title>
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
  	<%@ include file="../nav.jsp" %>
	<div class="container">
		<div class="jumbotron" style="padding-left: 20px; padding-top: 1px;background-image: url(<c:url value="/img/context.jpg"/>);background-size: 100% 100%;">
			<h2>添加课程-课程管理</h2>
		</div>
		
		<form class="form-horizontal" action="<c:url value="/course/editorCourse.action"/>" method="post">
			<div class="form-group">
				<label for="inputTitle" class="col-sm-2 control-label">所属学科</label>
				<input type="hidden" name="id" value="${course.id }">
				<div class="col-sm-10">
					<select name="subjectId" class="form-control" id="inputSubject">
						<option value="">请选择所属学科</option>
						<c:forEach items="${subjectList }" var="subject">
							<option value="${subject.id }" ${subject.id eq course.subjectId ? "selected" : "" }>${subject.subjectName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputVideoTime"  class="col-sm-2 control-label">标题</label>
				<div class="col-sm-10">
					<input type="text" name="courseName" class="form-control" id="inputVideoTime" value="${course.courseName }" placeholder="课程标题">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="courseDescr" rows="3" style="resize: none;">${course.courseDescr }</textarea>
					<button type="submit" class="btn btn-primary" style="margin-top: 10px;">保存</button>
					<a href="javascript:history.go(-1)" class="btn btn-default" style="margin-top: 10px;">返回列表</a>
				</div>
			</div>
		</form>
		<%@ include file="../footer.jsp" %>
  	</div>
  </body>
</html>