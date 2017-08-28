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
    <title>视频管理</title>
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
    <script>
    	
    	var num = 0;
    	function checkAll(v){
    		
    		var box = document.getElementsByName("checkbox");
    		for(var i = 0;i < box.length;i++ ){
    			box[i].checked = v;
    		}
    		if(v){
    			num = box.length;
    			$("#deleteNum").text(num);
    		}else{
    			num = 0;
    			$("#deleteNum").text(num);
    		}
    	}
    	function check(v){
    		if(v){
    			num++;
    			if(num == document.getElementsByName("checkbox").length){
    				$("#checkAll")[0].checked=true;
    			}
    		}else{
    			num--;
    			$("#checkAll")[0].checked=false;
    		}
    		$("#deleteNum").text(num);
    	}
    	function deleteByQuery(){
	  		if(num != 0){
	    		var box = document.getElementsByName("checkbox");
	    		var idString = "";
	    		for(var i = 0;i < box.length;i++ ){
	    			if(box[i].checked === true)
	    				idString += "&id="+box[i].id;
	    		}
	    		$('#url').val("${pageContext.request.contextPath}/video/deleteVideoByQuery.action?"+idString.substr(1));
	    		$('#deleteModal').modal();
	 		}
    	} 
    	
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
  	<jsp:include page="/WEB-INF/view/nav.jsp">
	  	<jsp:param value="video" name="fromJsp"/>
  	</jsp:include>
  	
	<div class="container">
		<!--巨幕-->
		<div class="jumbotron" style="padding-left: 20px; padding-top: 1px; background-image: url(<c:url value="/img/context.jpg"/>);background-size: 100% 100%;">
			<h2>视频列表-视频管理</h2>
		</div>
		
			
		<form class="form-inline" action="<c:url value="/video/videoManagementList.action"/>" method="post">
			<a href="<c:url value="/video/addVideo.action"/>" class="btn btn-primary">添加视频</a>
			<a href="#" class="btn btn-primary" onclick="deleteByQuery()" >批量删除<span id="deleteNum" class="badge">0</span></a>
			<div style="float: right;">
				<div class="form-group">
					<input type="text" name="videoTitle" class="form-control" placeholder="视频标题" value="${kvo.videoTitle }">
				</div>
				<div class="btn-group">
					<select name="speaker" class="form-control">
						<option value="">请选择主讲人</option>
						<c:forEach items="${speakerList }" var="speaker">
							<option value="${speaker.id }" ${speaker.id eq kvo.speaker ? "selected" : "" }>${speaker.speakerName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<select name="course" class="form-control">
						<option value="">请选择课程</option>
						<c:forEach items="${courseList }" var="course">
							<option value="${course.id }" ${course.id eq kvo.course ? "selected" : "" }>${course.courseName }</option>
						</c:forEach>
					</select>
				</div>
				<button type="submit" class="btn btn-primary">查询</button>
			</div>
		</form>
		
		<div class="bs-example" data-example-id="hoverable-table">
		    <table class="table table-hover" >
		      <thead>
		        <tr>
		          <th><input type="checkbox" name="" onclick="checkAll(this.checked)" id="checkAll" value="" /></th>
		          <th>序号</th>
		          <th class="col-md-1">名称</th>
		          <th class="col-md-10">介绍</th>
		          <th>讲师</th>
		          <th class="col-md-1">课程</th>
		          <th>时长（秒）</th>
		          <th>播放次数</th>
		          <th>编辑</th>
		          <th>删除</th>
		        </tr>
		      </thead>
		      <c:forEach items="${videoList }" var="video" varStatus="status">
			      <tbody>
			        <tr>
			          <th><input type="checkbox" onclick="check(this.checked)" name="checkbox" id="${video.id }" value="" /></th>
			          <th scope="row">${status.count+(page.page-1)*5 }</th>
			          <td>${video.videoTitle }</td>
			          <td>${video.videoDescr }</td>
			          <td>${video.speakerName }</td>
			          <td>${video.courseName }</td>
			          <td>${video.videoLength }</td>
			          <td>${video.videoPlayTimes }</td>
			          <td><a href="<c:url value="/video/editorVideoById.action?id=${video.id }"/>" onclick="delcfm('123')" class="glyphicon glyphicon-edit"title="编辑"></a></td>
			          <td>
			         	<input type="hidden" id="url" value=""/>
			          	<a onclick="delcfm('<c:url value="/video/deleteVideoById.action?id=${video.id }"/>')" href="#" class="glyphicon glyphicon-trash" title="删除"></a>
			          </td>
			        </tr>
			      </tbody>
		      </c:forEach>
			  </tbody>
			</table>
			<div style="float: right;">
		 		<page:page url="${pageContext.request.contextPath }/video/videoManagementList.action"></page:page>
			</div>
	 		<%@ include file="../footer.jsp" %>
 		</div>
  	</div>
  	<%@ include file="../modalBox.jsp" %>
  </body>
</html>