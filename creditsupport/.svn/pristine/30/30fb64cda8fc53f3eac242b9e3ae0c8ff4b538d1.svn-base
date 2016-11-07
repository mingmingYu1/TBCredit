
var sessionTimeOutTxt = "用户已失效，请重新登陆。";
var loginPage = "/creditsupport/jsp/login.jsp";
$.ajaxSetup({ 
	cache:"false",
	data: {sessionUserName: sessionUserName ? sessionUserName : ''},
	success: function(XMLHttpRequest, textStatus) {
		var result = XMLHttpRequest;
		if(result!=null && typeof(result)=="string"){
			if(result.indexOf("<html>") != -1 && result.indexOf("<title>登陆</title>") != -1) {
				var option = {
					closeBtn:false,
					btn: parseInt("0001",2),
					onOk: function(){
						window.location.href= loginPage;
					},
					onClose:function(){
						window.location.href= loginPage;
					}
				}
				window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
				return false;
			}
		}
	},
	error: function(jqXHR, textStatus, errorThrown){
		var text = jqXHR.responseText;
		if(text!=null && typeof(text)=="string" && text.indexOf("<html>")!=-1 && text.indexOf("<title>登陆</title>")!=-1){
			var option = {
				closeBtn:false,
				btn: parseInt("0001",2),
				onOk: function(){
					window.location.href = loginPage;
				},
				onClose:function(){
					window.location.href = loginPage;
				}
			}
			window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
			return;
		}
		switch (jqXHR.status){
			case(502):
				window.wxc.xcConfirm("网络异常,请稍后再试", window.wxc.xcConfirm.typeEnum.info);
				break;
			case(500):
				window.wxc.xcConfirm("服务器系统内部错误", window.wxc.xcConfirm.typeEnum.info);
				break;
			case(401):
				var option = {
					closeBtn:false,
					btn: parseInt("0001",2),
					onOk: function(){
						window.location.href= loginPage;
					},
					onClose:function(){
						window.location.href= loginPage;
					}
				}
				window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
				break;
			case(403):
				window.wxc.xcConfirm("无权限执行此操作", window.wxc.xcConfirm.typeEnum.info);
				break;
			case(408):
				window.wxc.xcConfirm("请求超时", window.wxc.xcConfirm.typeEnum.info);
				break;
			default:
				window.wxc.xcConfirm("请求未成功发送", window.wxc.xcConfirm.typeEnum.info);
		}
	}
});

$(document).keydown(function(e){
	var obj = e.srcElement ? e.srcElement : e.target; 
	if(obj.nodeName !== "TEXTAREA" && obj.nodeName != 'INPUT') {
		if(e.keyCode === 13){
		    if($('.xcConfirm').length == 0){
			   e.preventDefault();
			}
		} else if(e.keyCode === 32){
		   e.preventDefault();
		}
	}
});
//将表单转成json
$.fn.serializeObject = function(){
   var o = {};
   var a = this.serializeArray();
   $.each(a, function() {
       if (o[this.name]) {
           if (!o[this.name].push) {
               o[this.name] = [o[this.name]];
           }
           o[this.name].push(this.value || '');
       } else {
           o[this.name] = this.value || '';
       }
   });
   return o;
};
//初始化日期控件
function initDate(selector){
	$(selector).datepicker({
		language: 'zh-CN',
		autoclose: true,
		todayHighlight: true,
		format:"yyyy-mm-dd"
	});
}

function checkSeesionTimeOut(text,status ){
	if(text!=null && typeof(text)=="string" && text.indexOf("<html>")!=-1 && text.indexOf("<title>登陆</title>")){
		var option = {
			closeBtn:false,
			btn: parseInt("0001",2),
			onOk: function(){
				window.location.href= loginPage; 
			},
			onClose:function(){
				window.location.href= loginPage; 
			}
		}
		window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
		return "cimc-break";
	}
	switch (status){
		case(502):
			window.wxc.xcConfirm("网络异常,请稍后再试", window.wxc.xcConfirm.typeEnum.info);
			break;
		case(500):
			window.wxc.xcConfirm("服务器系统内部错误", window.wxc.xcConfirm.typeEnum.info);
			break;
		case(401):
			var option = {
				closeBtn:false,
				btn: parseInt("0001",2),
				onOk: function(){
					window.location.href= loginPage;
				},
				onClose:function(){
					window.location.href= loginPage;
				}
			}
			window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
			break;
		case(403):
			window.wxc.xcConfirm("无权限执行此操作", window.wxc.xcConfirm.typeEnum.info);
			break;
		case(408):
			window.wxc.xcConfirm("请求超时", window.wxc.xcConfirm.typeEnum.info);
			break;
		default:
			window.wxc.xcConfirm("请求未成功发送", window.wxc.xcConfirm.typeEnum.info);
	}
}

function checkSession(){
	$.ajax({ 
		url: "/creditsupport/login/checkSession?_time"+new Date().getTime(), 
		type:"post",
		dataType:"json",
		cache:"false",
		success: function(responseText){
			if(responseText.code==-1){
				var option = {
					closeBtn: false,
					btn: parseInt("0001",2),
					onOk: function(){
						window.location.href = loginPage;
					},
					onClose:function(){
						window.location.href = loginPage;
					}
				};
				window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
				return false;
			}
		}
	});
}

/** 校验字符长度 */
function checkInputGBKLength(inputStr, length){
	var returnValue = true;
	var byteValLen = 0;
	for (var i = 0; i < inputStr.length; i++) {
//		if (inputStr[i].match(/[^\x00-\xff]/ig) != null) {
//			byteValLen += 2;
//		} else {
//			byteValLen += 1;
//		}
		byteValLen += 1;
		if (byteValLen > length) {
			returnValue = false;
			break;
		}
	}
    return returnValue;
}

/** 校验字符串是否存在汉字 */
function isExistGBK(inputStr){
	var returnValue = false;
	for (var i = 0; i < inputStr.length; i++) {
		if (inputStr[i].match(/[^\x00-\xff]/ig) != null) {
			returnValue = true;
			break;
		}
	}
	return returnValue;
}

function setEChartYAxis(minValue, maxValue){
	minValue = Math.floor(minValue);
	maxValue = Math.ceil(maxValue);

	if(minValue >= 0 && maxValue >= 0){
        while(!((maxValue % 6) === 0 && (maxValue % 5) === 0)) {
          maxValue += 1;
        }
        minValue = 0;
    }
    if(minValue < 0 && maxValue >= 0) {
    	while(!(-minValue % 5 === 0)) {
	        minValue -= 1;
	    }
        while(!((maxValue - minValue) % 6 === 0 && (maxValue % 5 === 0))) {
          maxValue += 1;
        }
    }
    if(minValue < 0 && maxValue <= 0) {
        while(!(-minValue % 5 === 0)) {
          minValue -= 1;
        }
        while(!((-maxValue + -minValue) % 6 === 0 && -maxValue % 5 === 0)) {
          maxValue -= 1;
        }
    }
    var arr = [];
    arr[0] = minValue;
    arr[1] = maxValue;
    arr[2] = (maxValue - minValue)/6;
    return arr;
}

//   邮箱
var CheckMail= function(value, name, length) {
	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (reg.test(value)) {
		return true
	} else {
		var txt = name+"您的电子邮件格式不正确";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false
	}
	return true;
};
//  必须数字和字母组合
var checkNumAndW = function (value, name, length) {
	var reg = /^(?!\d+$)(?![a-zA-Z]+$)[0-9A-Za-z]+$/;
	if(reg.test(value)) {
		return true;
	}else {
		var txt = name+"必须为数字和字母的组合";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
};
//  数字或者字母
var checkNumOrW = function (value, name, length) {
	var reg = /^[0-9A-Za-z]+$/;
	if(reg.test(value)) {
		return true;
	}else {
		var txt = name+"必须为数字或字母";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
};
//  数字
var checkNum = function (value, name, length) {
	var regNum = /[0-9]+$/;   //  数字
	if(regNum.test(Number(value))) {
		return true
	} else{
		var txt = name+"必须全为数字";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
};

//  子母
var checkW = function (value, name, length) {
	var regW = /[a-zA-Z]+$/;    //  字母
	if(regW.test(value)) {
		return true;
	} else {
		var txt = name+"必须全为字母";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
};

//  非汉字
var checkU = function (value, name, length) {
	
	for (var i = 0; i < value.length; i++) {
		if (value[i].match(/[^\x00-\xff]/ig) != null) {
			var txt = name+"不可含有汉字";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
			break;
		}
	}
	return true;
};

//  字符长度
var checkLength = function (value, name, length) {
	var byteValLen = 0;
	for (var i = 0; i < value.length; i++) {
//		if (value[i].match(/[^\x00-\xff]/ig) != null) {
//			byteValLen += 2;
//		} else {
//			byteValLen += 1;
//		}
		//mysql5以上的数据库一个中文也为一个字符
		byteValLen += 1;
	}
	if(byteValLen > length ) {
		var txt = name+"的字符长度不可超过"+length+"个";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
};
//固定长度
var checkLengthFixed = function(value, name, length){
	var byteValLen = 0;
	for (var i = 0; i < value.length; i++) {
//		if (value[i].match(/[^\x00-\xff]/ig) != null) {
//			byteValLen += 2;
//		} else {
//			byteValLen += 1;
//		}
		//mysql5以上的数据库一个中文也为一个字符
		byteValLen += 1;
	}
	if(byteValLen !== length ) {
		var txt = name+"的字符长度必须为"+length+"个";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
}
//工商注册号：13或者15位数字
var checkRegId = function(value, name){
	if(value != ""){
		if(value.length == 13 && value.length != 15) {
		}else if(value.length != 13 && value.length == 15){
		}else{
				var txt = name+"的字符长度必须为13或者15位";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				return false;
		}
	}
//	var byteValLen = 0;
//	for (var i = 0; i < value.length; i++) {
//		if (value[i].match(/[^\x00-\xff]/ig) != null) {
//			byteValLen += 2;
//		} else {
//			byteValLen += 1;
//		}
//	}
	return true;
}

//企业名称规则为：中文、英文及部分符号 : + - ( ) 空格符 
var checkCompName = function (value, name) {
  var w = /^[\u4E00-\u9FFFa-zA-Z]+[ \\(\\)（）\u4E00-\u9FFFa-zA-Z\\+-]*$/;
  if(!w.test(value)) {
    var txt = name + "以中英文或+-()空格符组成且以中英文开头";
    window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    return false;
  }
  return true
}

//社会信用代码/组织机构代码
var checkOrgCode = function(value, name, length){
	var flag = false;
	if(value&&value.length===18){
		flag = true;
	}
	var reg = /[0-9|A-H|J-N|P-R|T|U|W-Y]{2}$/;    //第1-2位是数字或者大写字母，且I/O/S/V/Z除外
	if(flag && reg.test(value.substring(0,2))) {
		flag = true;
	}
	reg = /[0-9]{6}$/;    //第3-8位是数字
	if(flag && reg.test(value.substring(2,8))){
		flag = true;
	}else{
		flag = false;
	}
	reg = /[0-9|A-H|J-N|P-R|T|U|W-Y]{9}$/;    //第9-17位是数字或者大写字母，且I/O/S/V/Z除外
	if(flag && reg.test(value.substring(8,17))){
		flag = true;
	}else{
		flag = false;
	}
	reg = /[0-9|A-H|J-N|P-R|T|U|W-Y]{1}$/;    //第18位是数字或者大写字母，且I/O/S/V/Z除外
	if(flag && reg.test(value.substring(17,18))) {
		flag = true;
	}else{
		flag = false;
	}
	if(!flag){
		var txt = name+"不正确";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
}
//  空
var checkNull = function (value, name, length) {
	if(value === ""){
		var txt = name+"不可为空";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
};

//  电话号码
var checkPhone = function (value, name, length) {
	var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/;
	var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}$/;
	if (value.length > 9) {
		if (phoneRegWithArea.test(value)) {
			return true;
		} else {
			var txt = name+"您输入的电话号码格式不正确!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
	} else {
		if (phoneRegNoArea.test(value)) {
			return true;
		} else {
			var txt = name+"您输入的电话号码格式不正确!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
	}
	return true;
};

//   名称不可含有特殊字符
var checkNameString = function (value, name) {
  var w = /^([\u4E00-\u9FFF]|[\w]|[\.])+$/
  if(!w.test(value)) {
    var txt = name+"不可含有除点以外的特殊字符!";
    window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    return false;
  }
  return true
}

//   只能存在数字，字母，_
var checkNumber = function (value, name) {
	var reg = /^\w{1,20}$/
	if(!reg.test(value)) {
		var txt = name+"必须为数字或字母或“_”且长度不超过20位";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true
};

//  总方法
var checkData = function (isValidate, value,  name, functionName, length) {
	if(isValidate){
		if(functionName(value, name, length) === false) {
			return false;
		} else {
			return true;
		}
	} else {
		return isValidate;
	}
};

//  判断颜色
var checkColor = function (value, dom) {
	var $zhi = $(dom);
	if(value === "A" || value === "B") {
		$zhi.css("color", "#119E5A");
		return
	}
	if(value === "C" || value === "D") {
		$zhi.css("color", "#FFCE43");
		return
	}
	if(value === "E" || value === "F") {
		$zhi.css("color", "#DE5347");
	}
};

//   设置没有左侧导航时的高度
var checkHeight = function (dom) {
	var domHeight = $(dom).height();
	var docHeight = $(document).height()-$("#header").height()-$(".footer").height();
	var lastHeight = domHeight > docHeight ? domHeight : docHeight;
	$(dom).css("height", lastHeight);
};

var hideLeft = function () {
	var leftNav = $("#leftNav");
	if(leftNav.css("display") === "none"){
		leftNav.show();
		$(".btn.closeLeft").html('<i class="icon-angle-left"></i>');
		leftNav.next().removeClass().addClass("col-xs-10");
	}else {
		leftNav.hide();
		$(".btn.closeLeft").html('<i class="icon-angle-right"></i>');
		leftNav.next().removeClass().addClass("col-xs-12");
	}
};

function pageHeight(){
	$("#leftNav").height(0);
	var docHeight = $(document).height()-60-30;
	$("#leftNav").css("height",docHeight);
}

//   添加千位符以及补全两位两位小数
function formatDecimal(num) {
	if(!/^(\+|-)?(\d+)(\.\d+)?$/.test(num)){
		return num
	}
	var a = RegExp.$1, b = RegExp.$2, c = RegExp.$3;
	var result = ''
	while (b.length > 3) {
		result = ',' + b.slice(-3) + result
		b = b.slice(0, b.length - 3)
	}
	b = b + result
	if (c && c.length < 3) {
		c = c + "0"
	}
	if (!c) {
		c = c + ".00"
	}
	return a +""+ b +""+ c
}

//转义  元素的html内容即为转义后的字符
function htmlEncode(str) {  
    return $('<span/>').text(str).html();  
}   
//解析  text为解析后的字符
function htmlDecode(str) {  
    return $('<span/>').html(str).text();  
}


//   头部根据字体选中
function activeHtml(str) {
	var header = $(".navUl").find("a");
	header.each(function(i, dom) {
		if($(this).html() === str) {
			$(this).parent().addClass('active')
			return false
		}
	})
}

function checkError(data,info){
	var text = data.responseText;
	var code = data.status
	if((text!=null && typeof(text)=="string" && text.indexOf("<html>")!=-1 && text.indexOf("<title>登陆</title>")!=-1) || (code == 401)){
		var option = {
			closeBtn:false,
			btn: parseInt("0001",2),
			onOk: function(){
				window.location.href = loginPage;
			},
			onClose:function(){
				window.location.href = loginPage;
			}
		}
		window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
		return false;
	} else {
		window.wxc.xcConfirm(info, window.wxc.xcConfirm.typeEnum.info);
	}
}


function newWin(url, id) {
	var a = document.createElement('a');
	a.setAttribute('href', url);
	a.setAttribute('target', '_blank');
	a.setAttribute('id', id);
	// 防止反复添加
	if(!document.getElementById(id)) {
		document.body.appendChild(a);
	}
	a.click();
}