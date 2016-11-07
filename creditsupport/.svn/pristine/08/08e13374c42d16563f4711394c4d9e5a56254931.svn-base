<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>评分模型</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link href="${pageContext.request.contextPath}/favicon.ico" rel="Shortcut icon"/>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/xcConfirm.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/zTreeStyle.css"	rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/compangy-manage/index.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/score-manage/index.css" rel="stylesheet">
	<!--[if lt IE 9]>
      <script src="../js/html5shiv.min.js"></script>
      <script src="../js/respond.min.js"></script>
  	<![endif]-->
  	<script>
      var sessionUserName = '${sessionUser.userName}';
    </script>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/highcharts/highcharts.js"></script>
	<script src="${pageContext.request.contextPath}/js/overwrite-jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.formautofill.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="../js/xcConfirm.js"></script>
	<style type="text/css">
		html, body {
			-ms-overflow-style: scrollbar;
			}
	</style>
</head>
<body>
<div id="header" class="container-fluid" style="min-width:1100px;" ></div>
<div class="container-fluid" id="scoreManage" style="min-width:1100px;">
	<div class="row">
		<div class="col-xs-2" id="leftNav">
			<ul class="leftNav">
				<mrp:p rId="31">
					<li><a href="${pageContext.request.contextPath}/jsp/indicator-manage.jsp">指标体系管理</a></li>
				</mrp:p>
				<mrp:p rId="32">
					<li><a href="${pageContext.request.contextPath}/jsp/scoreLevelVersion-manage.jsp">评分版本管理</a></li>
				</mrp:p>
				<mrp:p rId="33">
					<li><a href="${pageContext.request.contextPath}/jsp/scoreModel-manage.jsp">评分模型管理</a></li> 
				</mrp:p>
				<mrp:p rId="34">
					<li><a href="${pageContext.request.contextPath}/jsp/creditReport-model.jsp">征信报告模板</a></li><!--<span class="hotSpan">HOT</span>-->
				</mrp:p>
			</ul>
		</div>
		<div id="" class="col-xs-10">
			<div id="content"></div>
		</div>
	</div>
</div>
<div class="footer">
	Copyright © 2016 All rights reserved. 前海云游版权所有
</div>
<div id="loadingIndex" style="display: none">
	<div class="spinner">
	  <div class="spinner-container container1">
	    <div class="circle1"></div>
	    <div class="circle2"></div>
	    <div class="circle3"></div>
	    <div class="circle4"></div>
	  </div>
	  <div class="spinner-container container2">
	    <div class="circle1"></div>
	    <div class="circle2"></div>
	    <div class="circle3"></div>
	    <div class="circle4"></div>
	  </div>
	  <div class="spinner-container container3">
	    <div class="circle1"></div>
	    <div class="circle2"></div>
	    <div class="circle3"></div>
	    <div class="circle4"></div>
	  </div>
	</div>
  </div>
<script type="text/javascript">
$('#header').load("${pageContext.request.contextPath}/jsp/header.jsp?time="+new Date().getTime(), {name: '22'}, function(){
	activeHtml('评分模型')
});
var leftAs = $("#leftNav").find("a");

if(leftAs.length > 0) {
	$('#content').load(leftAs.eq(0).attr("href"));
	leftAs.eq(0).parent().addClass("active");
	$(leftAs).on("click",function(e){
		e.preventDefault();
		if(leftAs !== null && leftAs.length > 0) {
			var href = $(this).attr("href");
			$("#content").load(href);
			$('.leftNav .active').removeClass("active");
			$(this).parent().addClass("active");
		}
	});
} else {
	var $scoreManage = $("#scoreManage")
	$scoreManage.height(0);
	var docHeight = $(document).height()-60-30;
	$scoreManage.css("height",docHeight);
	$scoreManage.html('<div class="noPermissions">您无权限访问此页面!</div>')
}
pageHeight();
$(window).on("resize",function(){
	pageHeight();
});

</script>
</body>
</html>