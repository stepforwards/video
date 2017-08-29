<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="<c:url value="/img/favicon.ico"/>" />
    <script src="<c:url value="/js/jquery-1.12.4.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript">
    	
    </script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/nav.jsp">
	  	<jsp:param value="statistical" name="fromJsp"/>
  	</jsp:include>
	<div class="container">
	<!--巨幕-->
		<div class="jumbotron" style="padding-left: 20px; padding-top: 1px; background-image: url(<c:url value="/img/context.jpg"/>);background-size: 100% 100%;">
			<h2>统计-统计分析</h2>
		</div>
	
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:600px;"></div>
    
    <!-- ECharts单文件引入 -->
    <script src="<c:url value="/js/echarts.min.js"/>"></script>
    <script type="text/javascript">
                // 基于准备好的dom，初始化echarts图表
                var myChart = echarts.init(document.getElementById('main'));
                var option = {
                	
                	title: {
                		text: '课程平均播放次数',
                		subtext: '数据来源：zhiyou100.com',
                		left:'center'
                	},
                    tooltip: {
                        show: true
                    },
                    legend: {
                            // orient: 'vertical',
                            // top: 'middle',
                            bottom: 10,
                            left: 'center',
                        	data:['平均播放次数']
                    },
                    xAxis : [
                        {
                            type : 'category',
                           	data : ["${courseNames}"]
                        }
                    ],
                    yAxis : [
                        {	
                            type : 'value',
                            "name": ['平均播放次数(times)'],
                        }
                    ],
                    series : [
                        {
                            "name":"平均播放次数",
                            "type":"bar",
                            "data": ["${coursePlays}"]
                        }
                    ]
                };
                // 为echarts对象加载数据 
                myChart.setOption(option); 
    </script>
    </div>
	<%@ include file="../footer.jsp" %>
</body>