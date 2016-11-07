<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>系统管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link href="${pageContext.request.contextPath}/favicon.ico" rel="Shortcut icon"/>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/xcConfirm.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/zTreeStyle.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
	<!--[if lt IE 9]>
      <script src="../js/html5shiv.min.js"></script>
      <script src="../js/respond.min.js"></script>
  	<![endif]-->
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/overwrite-jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.formautofill.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="../js/xcConfirm.js"></script>
	<script src="../js/reset-pass.js"></script>
	<style type="text/css">
		html, body {
			-ms-overflow-style: scrollbar;
			}
		#system .newSpan,
		#system .hotSpan {
			right: 26.5%;
		}
		.systemContent input {
			width: 250px;
		}
	</style>
</head>
<body>
<div id="header" class="container-fluid" style="min-width:1100px;" ></div>
<div id="system" class="container-fluid" style="min-width:1000px;min-height:400px;">
	<div class="row">
		<div class="col-xs-2" id="leftNav">
			<ul class="leftNav">
				<mrp:p rId="42">
					<li class="active"><a href="${pageContext.request.contextPath}/jsp/person/dept-manage.jsp">部门管理</a></li>
				</mrp:p>
				<mrp:p rId="43">
					<li><a href="${pageContext.request.contextPath}/jsp/person/role-manage.jsp">角色管理 </a></li>   <!--<span class="newSpan">NEW</span>-->
				</mrp:p>
				<mrp:p rId="41">
					<li><a href="${pageContext.request.contextPath}/jsp/person/user-manage.jsp">用户管理</a></li><!--<span class="hotSpan">HOT</span>-->
				</mrp:p>
			</ul>
		</div>
		<div class="col-xs-10">
			<div id="content" style="min-width: 100%;"></div>
		</div>
	</div>
</div>
<div class="footer">
	Copyright © 2016 All rights reserved.前海云游版权所有
</div>
<script type="text/javascript">
$('#header').load("${pageContext.request.contextPath}/jsp/person/personHeader.jsp?time="+new Date().getTime(),function(){
	$(".navUl li").eq(2).addClass("active");
});
var leftAs = $("#leftNav").find("a");
$('#content').load(leftAs.eq(0).attr("href"));

$(leftAs).on("click",function(e){
	e.preventDefault();
	if(leftAs !== null && leftAs.length > 0) {
		var href = $(this).attr("href");
		$("#content").load(href);
		$('.leftNav .active').removeClass("active");
		$(this).parent().addClass("active");
	}
});

//   隐藏左侧



$(window).on("resize",function(){
	pageHeight();
});

$(document).keydown(function(e){
	if(e.keyCode === 13){
		if($('.xcConfirm').length == 0){
			if ($('#deptModal').css('display') === 'block') {
				e.preventDefault();
				if($("#add_deptname").val() == ""){
					var txt="部门名称不允许为空 !";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
				add_deptname()
			}
			if ($('#deptEditModal').css('display') === 'block') {
				e.preventDefault();
				if($("#editdeptname").val()==""){
					var txt="部门名称不允许为空 !";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
				edit_dept()
			}
			if ($('#addroleModal').css('display') === 'block') {
				e.preventDefault();
				$("#addrole_form").valid();
				if($("#addrolename").val()==""){
					var txt="请输入角色名称!";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
				//权限
				var right = "";
				var nodes = zTree.getCheckedNodes();
				for(var i=0;i<nodes.length;i++){
					var node = nodes[i];
					if(i==0){
						right=node.id;
					}else{
						right = right+","+node.id;
					}
				}
				if(right==""){
					window.wxc.xcConfirm("创建的角色赋予的权限不能为空!", window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
				$("#addRoleRight").val(right);
				add_role()
			}
			if ($('#roleModal').css('display') === 'block') {
				$("#role_form").valid();
				//权限
				var right = "";
				var nodes = zTree.getCheckedNodes();
				for(var i=0;i<nodes.length;i++){
					var node = nodes[i];
					if(i==0){
						right=node.id;
					}else{
						right = right+","+node.id;
					}
				}
				if(right==""){
					var txt="修改角色赋予的权限不能为空!";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
				$("#editRoleRight").val(right);
				edit_role();
			}
			if($('#emailModel').css('display') === 'block'){    //    分配邮箱模态对话框
				e.preventDefault();
				if(addEmailCheck() == false){
					return false;
				}
				addEmail();
			}
			if($('#emailManageModel').css('display') === 'block'){    //    填写邮箱名模态对话框
				e.preventDefault();
				if(emailCheck() == false){
					return false;
				}
				addemailAddr();
			}
		}
	}
	if(e.keyCode === 32){
		e.preventDefault();
	}
});
</script>
</body>
</html>