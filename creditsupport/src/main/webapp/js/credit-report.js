$(document).ready(function () {
	  $('#createpdf').on('click', function() {
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
		})
	  $("#templetList").bootstrapTable({
		  columns: [{
		        field: 'id',
		        title: '主键',
		        visible: false
		    },{
		        field: 'index',
		        title: '序号',
		        formatter: function (value,row,index) {
		          return index+1;
		        }
		    }, {
		        field: 'number',
		        title: '模板编号'
		    }, {
		        field: 'name',
		        title: '模板名称'
		    }, {
		        field: 'type',
		        title: '报告类别',
		        formatter: function (value,row,index) {
		        	if(value === 1) {
		        		return "授信";
		        	}
		        	if(value === 2) {
		        		return "贷款";
		        	}
		        	if(value === 3) {
		        		return "交易";
		        	}
		        	return "";
		        }
		    }, {
		        title: '操作',
		        align: "right",
		        formatter: function(value,row,index){
		        	return  '<a href="javascript:void(0)" class="templetLook" title="确定模板并生成报告">生成报告</a>'
		        },
		        events: 'templetEvents'
		    }],
		    height: 300,
		    pagination: true,
		    sidePagination: 'server',
		    pageNumber: 1,
		    pageSize: 10,
		    cache: false,
		    pageList: [5, 10, 20],
		    url: global + '/creditReport/queryReportTemplet'
	  });
	  window.templetEvents = {
	    'click .templetLook': function (e, value, row, index) {
	    	$.ajax({
	    	      url: "/creditsupport/scoreLevelVersion/hasAvailableVersion",
	    	      type:"post",
	    	      dataType:"json",
	    	      cache:"false",
	    	      data:{},
	    	      success: function(responseText){
	    	    	  if(responseText.code == 1) {
	    	    		  var option = {
    	    				  btn: parseInt("0011",2),
    	    				  onOk: function(){
    	    					  $("#loading").show();
    	    					  $("#selectTempletModal").modal("hide");
    	    					  $("#content").load(global + '/creditReport/createReport', {id:regId, templetId:row.id, algorithmType:algorCode}, function () {});
    	    				  }
	    	    		  };
	    	    		  window.wxc.xcConfirm("确定用此模板生成报告？", "custom", option);
	    	    	  } else {
	    	    		  var txt="你需要去设置一个评分版本作为标准才能生成报告！";
	    	              window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	    	              return false;
	    	    	  }
	    	      }
	    	});
	    }
	  }
	

	
  window.creditReportEvents = {
    'click .creditReportLook': function (e, value, row, index) {
			$("#loading").show();
    	var algorithmType = row.algorithmType;
    	var templetId = row.templetId;
    	var fileNo = row.fileNo;
    	var filePath = row.path;
    	$("#content").load(global+'/creditReport/reportDetail', 
    			{id:regId, fileNo:fileNo, filePath:filePath, templetId:templetId, algorithmType: algorithmType},
    			function () {});
    }
  }
  
  
//查询
  var creditReportSelect = function (value) {
    var reg = /^[a-zA-Z0-9-]+$/
    if(value) {
      if(!reg.test(value)) {
        var txt="查询条件只允许为字母或数字或‘-’";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
    }
    var params = {id:regId, fileNo:value, algorithmType:algorCode};
    $.ajax({
      url: "/creditsupport/creditReport/query",
      type:"post",
      dataType:"json",
      cache:"false",
      data:params,
      success: function(responseText){
        var result = responseText.code;
        if(-2 == result){
          window.location.href=global+'/jsp/login.jsp';
          return false;
        }
        if(0 == result){
          var txt = responseText.message ? responseText.message : "查询出现异常!";
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
          return false;
        }
        if(1 == result){
     	 $('#creditReportTable').bootstrapTable('load', responseText);
        }
       /* if(2 == result){
          $("#search").attr("disabled", true); 
          return true;
        }*/
        return false;
      }
    });
  };
  
  function trimStr(str){return str.replace(/(^\s*)|(\s*$)/g,"");}
  var inputSearch = $("#creditReportSelect");
  inputSearch.keydown(function (e) {
    if(e.keyCode === 13){
		creditReportSelect(trimStr($(this).val()));
    }
  });
  $("#search").click(function(){
	  creditReportSelect(trimStr(inputSearch.val()));
  });
});