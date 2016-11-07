$(document).ready(function () {
	
  $("#basicdetail input,textarea").attr("readonly", "readonly");
  
  function ajaxFindInfo(path, data, func) {
	$.ajax({
	  url: global+"/creditReport/" + path,
	  type:"post",
	  dataType: "json",
	  cache: "false",
	  data: data,
	  success: func
    });
  }
  
  $(function(){
	  
	// 企业基本信息->联系地址
	ajaxFindInfo("entAttrInfo", {regId : id}, function(response){
	  $('#basicTable1').bootstrapTable({data: response.data});
	});
	 
	// 企业基本信息->股东信息
	ajaxFindInfo("stockholderInfo", {regId : id}, function(responseText){
	  $('#basicTable2').bootstrapTable({data: responseText.data});
	});
	 
	// 企业基本信息->高管信息Manager
	ajaxFindInfo("topManagerInfo", {regId : id}, function(responseText){
	  $('#basicTable3').bootstrapTable({data: responseText.data});
	});
	 
	// 企业基本信息->对外股权投资信息
	ajaxFindInfo("othEntInvestsInfo", {regId : id}, function(responseText){
	 $('#basicTable4').bootstrapTable({data: responseText.data});
	});
	
	// 企业基本信息->法定代表人在其机构任职信息	0	法定代表人股权投资信息	1	
	ajaxFindInfo("legPerInfo", {regId : id}, function(responseText){
	  $('#basicTable5').bootstrapTable({data: responseText.legPerInfo1});
	  $('#basicTable6').bootstrapTable({data: responseText.legPerInfo2});
	  $('#basicTable7').bootstrapTable({data: responseText.legPerInfo2});
	});
	
	
	
	//企业变更信息
	ajaxFindInfo("agentChangeInfo", {regId : id}, function(responseText){
		  $('#detailTableQybgBasic').bootstrapTable({data: responseText.data});
		});
	
	//清算信息
	ajaxFindInfo("agentLiquidationInfo", {regId : id}, function(responseText){
		  $('#detailTableQingsuanBasic').bootstrapTable({data: responseText.data});
		});
	
	//动产抵押物信息
	ajaxFindInfo("mortgageItemInfo", {regId : id}, function(responseText){
		  $('#detailTableDcdywBasic').bootstrapTable({data: responseText.data});
		});
	
	//动产抵押物信息
	ajaxFindInfo("agentSharesImpawnInfo", {regId : id}, function(responseText){
		  $('#detailTableGqczlsBasic').bootstrapTable({data: responseText.data});
		});
  });

  $(".basicText span").on('click', function (e) {
	  
    var btn = $(e.target);
    var div = btn.parent().next();
    
    if(div.css("display") === "none") {
      div.css('display','block');
      btn.html('收起 >>')
    } else{
      div.css('display','none');
      btn.html('展开 >>')
    }
    
    var isShow = $(".isShow");
    var num = isShow.length;
    var i = 0;
    
    isShow.each(function () {
      if($(this).css("display") === 'none') {
        i++;
      }
    });
    
    if( i >= (num/2)) {
      $("#iconBtn").find('span').removeClass().addClass("icon-double-angle-up");
    }else {
      $("#iconBtn").find('span').removeClass().addClass("icon-double-angle-down");
    }
  });

  $(".as a").on('click', function () {
    var href = $(this).attr("href");
    $(href).children().eq(1).css('display','block');
    $(href).children().eq(0).children().eq(1).html("收起 >>");
  });

  $("#iconBtn").on("click", function () {
    var isShow = $(".isShow")
    var num = isShow.length;
    var i = 0;
    isShow.each(function () {
      if($(this).css("display") === 'none') {
        i++;
      }
    });
    
    if( i >= (num/2)) {
      isShow.css("display",'block');
      $(this).find('span').removeClass().addClass("icon-double-angle-down");
      $(".basicText span").html("收起 >>")
    }else {
      isShow.css("display",'none');
      $(this).find('span').removeClass().addClass("icon-double-angle-up");
      $(".basicText span").html("展开 >>")
    }
  });
});