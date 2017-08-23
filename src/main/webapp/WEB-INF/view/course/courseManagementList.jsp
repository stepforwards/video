<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<!--引入模板-->
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>课程管理</title>
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
    <script type="text/javascript">
	    function delcfm(url) {
			$('#url').val(url); //给会话中的隐藏属性URL赋值
			$('#deleteModal').modal();
		}
	
		function urlSubmit() {
			var url = $.trim($("#url").val()); //获取会话中的隐藏属性URL
			window.location.href = url;
		}
    </script>
  </head>
  
  <body>
  	<%@ include file="../nav.jsp" %>
	<div class="container">
	   
		<div class="jumbotron" style="padding-left: 20px; padding-top: 1px;background-image: url(<c:url value="/img/context.jpg"/>);background-size: 100% 100%;">
			<h2>课程列表-课程管理</h2>
		</div>
		
		<form class="form-inline">
			<a href="<c:url value="/course/addCourse.action"/>" class="btn btn-primary">添加课程</a>
		</form>
		
		<div class="bs-example" data-example-id="hoverable-table">
		    <table class="table table-hover">
		      <thead>
		        <tr>
		          <th>序号</th>
		          <th class="col-md-1">标题</th>
		          <th class="col-md-1">学科</th>
		          <th class="col-md-10">简介</th>
		          <th>编辑</th>
		          <th>删除</th>
		        </tr>
		      </thead>
		      <c:forEach items="${courseList }" var="course" varStatus="status">
			      <tbody>
			        <tr>
			          <th scope="row">${status.count+(page.page-1)*5 }</th>
			          <td>${course.courseName }</td>
			          <td>${course.subjectName }</td>
			          <td>${course.courseDescr }</td>
			          <td><a href="<c:url value="/course/editorCourse.action?id=${course.id }" />" class="glyphicon glyphicon-edit"></a></td>
			          <td>
			          	<input type="hidden" id="url" value=""/>
			          	<a href="#" onclick="delcfm('<c:url value="/course/deleteCourseById.action?id=${course.id }"/>')" class="glyphicon glyphicon-trash"></a>
			          </td>
			        </tr>
			      </tbody>
		      </c:forEach>
		    </table>
 		</div>
 		<div style="float: right;">
		 	<page:page url="${pageContext.request.contextPath }/course/courseManagementList.action"></page:page>
		</div>
 		<%@ include file="../footer.jsp" %>
  	</div>
  	<%@ include file="../modalBox.jsp" %>
  </body>
</html>