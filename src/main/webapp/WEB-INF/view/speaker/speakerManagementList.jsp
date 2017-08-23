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
			<h2>主讲人管理列表-主讲人管理</h2>
		</div>
		
		<form class="form-inline">
			<a href="<c:url value="/speaker/addSpeaker.action"/>" class="btn btn-primary">添加主讲人</a>
			<div style="float: right;">
				<div class="form-group">
					<label for="exampleInputName">名称</label>
					<input type="text" name="speakerName" class="form-control" id="exampleInputName" placeholder="主讲人名称">
				</div>
				<div class="form-group">
					<label for="exampleInputPlace">职位</label>
					<input type="text" name="speakerJob" class="form-control" id="exampleInputPlace" placeholder="主讲人职位">
				</div>
					<button type="submit" class="btn btn-primary">查询</button>
			</div>
		</form>
		
		<div class="bs-example" data-example-id="hoverable-table">
		    <table class="table table-hover">
		      <thead>
		        <tr>
		          <th>序号</th>
		          <th>名称</th>
		          <th>职位</th>
		          <th class="col-md-12">简介</th>
		          <th>编辑</th>
		          <th>删除</th>
		        </tr>
		      </thead>
		      <c:forEach items="${speakerList }" var="speaker" varStatus="status">
			      <tbody>
			        <tr>
			          <th scope="row">${status.count+(page.page-1)*5 }</th>
			          <td>${speaker.speakerName }</td>
			          <td>${speaker.speakerJob }</td>
			          <td>${speaker.speakerDescr }</td>
			          <td><a href="<c:url value="/speaker/editorSpeaker.action?id=${speaker.id }"/>" class="glyphicon glyphicon-edit"></a></td>
			          <td>
			          	<input type="hidden" id="url" value=""/>
			          	<a onclick="delcfm('<c:url value="/speaker/deleteSpeakerById.action?id=${speaker.id }"/>')" class="glyphicon glyphicon-trash"></a>
			          </td>
			        </tr>
			      </tbody>
		      </c:forEach>
		    </table>
 		</div>
 		<div style="float: right;">
		 		<page:page url="${pageContext.request.contextPath }/speaker/speakerManagementList.action"></page:page>
		</div>
 		<%@ include file="../footer.jsp" %>
  	</div>
  	<%@ include file="../modalBox.jsp" %>
  </body>
</html>