<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>登陆</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="${pageContext.request.contextPath}/favicon.ico" rel="Shortcut icon"/>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/xcConfirm.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/logo/logo.css" rel="stylesheet">

	<!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
  	<![endif]-->
</head>
<body>
  <div class="container-fluid" style="min-width:1100px;">
    <div class="row navColor">
	    <div class="col-xs-12">
				<div class="pull-left logo"></div>
		    <div class="pull-left navUl">
		      <ul>
		        <li class="active"><a href="javascript:entLogin();">企业征信</a></li>
			      <li><a href="javascript:perLogin();">个人征信</a></li>
		      </ul>
		    </div>
	    </div>
    </div>
  </div>
  <div id="bgImg">
    <div id="imgContainer">
	    <img class="img-responsive" src="${pageContext.request.contextPath}/images/nameAll.png" alt="登录"/>
	  </div>
	<div id="agentForm" >
	  <form class="form-horizontal loginBox" role="form" id="login" method="post" action="/creditsupport/login/login">
		<div class="form-group text-center">
	 	  <div class="col-xs-12">
	 		<label style="color:#7e8183;font-size:16px;">企业用户登录</label>
		  </div>
	    </div>
   		<div class="form-group has-feedback">
				<div class="col-xs-12">
      		<i class="icon-user form-control-feedback formIcon"></i>
         	<input type="text" class="form-control" id="username" name= "userName" maxlength="16"	placeholder="填写用户名">
				</div>
   		</div>
        <div class="form-group has-feedback">
          <div class="col-xs-12">
      	    <span class="icon-lock	 form-control-feedback formIcon"></span>
            <input type="password" class="form-control" id="password" name = "password" maxlength="17"
            placeholder="输入密码">
          </div>
        </div>
        <div class="form-group">
          <div class="col-xs-12	">
            <button id="login_btn" class="btn" onclick="commit();return false;">登录</button>
          </div>
        </div>
	  </form>
	</div>
	<div id="personForm" style="display:none">
	  <form class="form-horizontal loginBox" role="form" method="post" id="perloginForm" action="/creditsupport/login/personLogin">
		  <div class="form-group text-center">
	 		  <div class="col-xs-12">
	 			  <label style="color:#7e8183;font-size:16px;">个人用户登录</label>
			  </div>
		  </div>
			<div class="form-group has-feedback">
				<div class="col-xs-12">
					<i class="icon-user form-control-feedback formIcon"></i>
					<input type="text" class="form-control" id="peruserName" name= "peruserName" maxlength="16"	placeholder="填写用户名">
      	</div>
   		</div>
     <div class="form-group has-feedback">
      <div class="col-xs-12">
				<span class="icon-lock	 form-control-feedback formIcon"></span>
				<input type="password" class="form-control" id="perpassword" name = "perpassword" maxlength="17"  placeholder="输入密码">
      </div>
   </div>
     <div class="form-group">
      <div class="col-xs-12	">
         <button id="per_login_btn"  class="btn" onclick="percommit();return false;">登录</button>
      </div>
   </div>
	</form>
	</div>
	</div>
  <div class="logoFooter">
	  Copyright © 2016 All rights reserved. 前海云游版权所有
  </div>
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
  <script src="${pageContext.request.contextPath}/js/xcConfirm.js"></script>
  <script>
  var sessionUserName = '';
function checkSeesionTimeOut(text){
  return "";
}
function commit(){
	if(valid()==false) {return false;}
	$("#login").ajaxSubmit(function (result) {
		if(0 == result.num){
		  var txt = "用户名不能为空 !";
		  window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			clearInput()
		  return false;
		}
		if(1 == result.num){
			var txt = "密码不能为空 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			clearInput()
			return false;
		}
		if(2 == result.num){
			var txt = "用户名或密码错误 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			clearInput()
			return false;
		}
		if(4 == result.num){
			var txt = "该用户错误次数太多,已经被冻结,请联系管理员 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			clearInput()
			return false;
		}
		if(3 == result.num){
			var txt = "该账户已经被冻结,请联系管理员 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			clearInput()
			return false;
		}
		if(5 == result.num){
			var txt = "此用户没有任何权限,请切换用户登录!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			clearInput()
			return false;
		}
		if(1 == result.result){//登录成功
			var menu = result.menu;
			for( var i = 0; i < menu.length; i++){
			  if(menu[i].menuId == 2){
			    window.location.href='${pageContext.request.contextPath}/jsp/company-manage.jsp';
				  return false;
				}
				if(menu[i].menuId == 3){
				  window.location.href='${pageContext.request.contextPath}/jsp/score-manage.jsp';
				  return false;
			  }
			  if(menu[i].menuId == 4){
				  window.location.href='${pageContext.request.contextPath}/jsp/system.jsp';
				  return false;
			  }
			}
		}
	});
}
var userName = $("#username");
var password = $("#password");
function valid(){
	if(userName.val() === ""){
		var txt="用户名不能为空 !";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if(password.val() === ""){
		var txt="密码不能为空 !";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
}
function checkpwd(obj){
	if(obj.value == "")return false;
	if(obj.value.match(/[^A-Za-z0-9]/ig)){
		var txt="用户名和密码只能为数字和字母 !";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
}
function clearInput() {
	userName.val("");
	password.val("");
}
	//设置当前背景的高度
var pageReset=function(){
	var height = $(window).height();
	$("#bgImg").css("height",height-60-30);
	$("#personBgImg").css("height",height-60-30);
};
pageReset();
$(window).on("resize",function(){
	pageReset();
})
		
//企业征信登录
function entLogin(){
	$(".navUl li:first").addClass("active");
	$(".navUl li:last").removeClass("active");
	$("#personForm").hide();
	$("#agentForm").show();
}
		
//个人征信登录
function perLogin(){
	$(".navUl li:first").removeClass("active");
	$(".navUl li:last").addClass("active");
	$("#agentForm").hide();
	$("#personForm").show();
}
		
var peruserName = $("#peruserName");
var perepassword = $("#perpassword");

function pervalid(){
	if(peruserName.val() === ""){
		var txt="用户名不能为空 !";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if(perepassword.val() === ""){
		var txt="密码不能为空 !";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
}
function percommit(){
	if(pervalid()==false) {return false;}
	$("#perloginForm").ajaxSubmit(function (result) {
		if(0 == result.num){
			var txt = "用户名不能为空 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(1 == result.num){
			var txt = "密码不能为空 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(2 == result.num){
			var txt = "用户名或密码错误 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(4 == result.num){
			var txt = "该用户错误次数太多,已经被冻结,请联系管理员 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(3 == result.num){
			var txt = "该账户已经被冻结,请联系管理员 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(5 == result.num){
			var txt = "此用户没有任何权限,请切换用户登录!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(1 == result.result){//登录成功
			var menu = result.menu;
			for( var i = 0; i < menu.length; i++){
				if(menu[i].menuId == 2){
					window.location.href='${pageContext.request.contextPath}/jsp/person/person-manage.jsp';
					return false;
				}
				if(menu[i].menuId == 3){
					window.location.href='${pageContext.request.contextPath}/jsp/person/person-score-manage.jsp';
					return false;
				}
				if(menu[i].menuId == 4){
					window.location.href='${pageContext.request.contextPath}/jsp/person/person-system.jsp';
					return false;
				}
			}
		}
	});
}
		
	</script>
</body>
</html>