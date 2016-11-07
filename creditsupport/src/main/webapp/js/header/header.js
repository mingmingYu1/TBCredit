//修改密码
var regPassword = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$/;
function updatePassword(evt) {
	document.getElementById("pwdForm").reset();
	$.ajax({
		url: "/creditsupport/login/checkSession?_time"+new Date().getTime(),
		type:"post",
		dataType:"json",
		cache:"false",
		success: function(responseText){
			if(responseText.code == -1){
				var option = {
					closeBtn: false,
					btn: parseInt("0001",2),
					onOk: function(){
						window.location.href = "/creditsupport/jsp/login.jsp";
					},
					onClose:function(){
						window.location.href = "/creditsupport/jsp/login.jsp";
					}
				};
				window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
				return false;
			}
		}
	});
}
//验证并提交密码
function submitPassword() {
	if ($("#oldPassword").val() == '') {
		var txt = "请输入原始密码!";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	var newpwd = $("#newPassword").val();
	if (newpwd == '' || !regPassword.test(newpwd)) {
		var txt = "请输入8到16位字母和数字组合的新密码!";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	var newpwd2 = $("#newPassword2").val();
	//if (newpwd2 == '' || !regPassword.test(newpwd2)) {
	//	var txt = "请输入8到16位字母和数字组合的确认密码!";
	//	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	//	return false;
	//}
	if (newpwd2 == '') {
		var txt = "确认密码不可为空";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if (newpwd !== newpwd2) {
		var txt = "新密码和确认密码输入不一致!";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	$("#pwdForm").ajaxSubmit(function(result) {
		if (1 == result.result) {
			window.wxc.xcConfirm(result.message,window.wxc.xcConfirm.typeEnum.info);
			$("#updatePassword").modal("hide");
			document.getElementById("pwdForm").reset();
			return false;
		}
		if (-1 == result.result) {
			window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if (-2 == result.result) {
			window.location.href = global + '/jsp/login.jsp';
			return false;
		}
	});
}
$("document").ready(function() {
	//  退出方法
	function logout() {
		var txt = "确定退出吗 ?";
		//	var logoutPage = "http://172.16.13.178:8088/CAS/logout?service=http://localhost:80/creditsupport";
		var logoutPage = global + "/jsp/login.jsp";
		var option = {
			btn : parseInt("0011", 2),
			onOk : function() {
				$.ajax({
					url : "/creditsupport/login/logout",
					type : "post",
					dataType : "json",
					cache : "false",
					success : function(responseText) {
						window.location.href = logoutPage;
					},
					error : function() {
						window.location.href = logoutPage;
					}
				});
			}
		};
		window.wxc.xcConfirm(txt, "custom", option);
	}
	$(".logout").on("click", function() {
		logout();
	});

	var headerA  = $('.navUl > ul > li > a')
	headerA.on('click', function (e) {
		e.preventDefault();
		var _self = this
		$.ajax({
			url: "/creditsupport/login/checkSession?_time"+new Date().getTime(),
			type:"post",
			dataType:"json",
			cache:"false",
			success: function(responseText){
				if(responseText.code == -1){
					var option = {
						closeBtn: false,
						btn: parseInt("0001",2),
						onOk: function(){
							window.location.href = "/creditsupport/jsp/login.jsp";
						},
						onClose:function(){
							window.location.href = "/creditsupport/jsp/login.jsp";
						}
					};
					window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
					return false;
				}
				var href = $(_self).attr('href')
				window.location.href = global+'/jsp/'+href
			}
		});
	})
});