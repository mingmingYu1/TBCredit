<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>服务繁忙</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath}/favicon.ico" rel="Shortcut icon"/>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
  </head>
  <body style="min-height:400px;">
    <div class="container-fluid" style="min-height:400px;min-width:1000px;">
    	<div class="row">
    		<div class="col-xs-12">
    			<form id="form1" runat="server">
    				<p class="error1" ><i class="icon-warning-sign"></i></p>
        			<p class="error2" >服务器现在繁忙!</p> 
        			<p class="error3" ><span id="dd">5</span> 秒后 将自动跳转至上一页 <p>       
    			</form>
    		</div>
    	</div>
    </div>
  </body>
</html>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
 	function run() {
		var s = document.getElementById("dd");
		if (s.innerHTML == 0) {
			history.back();
			return false;
		}
		s.innerHTML = s.innerHTML * 1 - 1;
	}
	window.setInterval("run();", 1000);
	function topHeight(){
		var marTop;
		if($(window).height()>=400){
			marTop=($(window).height()-$("#form1").height())/2-40;
			$("#form1").css({"marginTop":marTop+"px"})
		}else{
				$("#form1").css({"marginTop":"100px"})
			}
	}
	topHeight();
	$(window).on("resize",function(){
		topHeight();
	})
 </script>