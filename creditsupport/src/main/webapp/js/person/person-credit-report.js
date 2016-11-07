$(document).ready(function () {
	
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
		    url: global + '/personCreditReport/queryReportTemplet'
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
    	    					  $("#content").load(global + '/personCreditReport/createReport', {id:cardId, templetId:row.id, algorithmType:algorCode}, function () {});
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
	
	$('#creditReportTable').bootstrapTable({
	    columns: [{
	        field: 'id',
	        title: '主键',
	        visible: false
	    },{
	        field: 'fileNo',
	        title: '报告编号',
	        align: "left",
	        width: "25%",
	        sortable: true,
	        sorOrder: "asc"
	    },{
	        field: 'name',
	        title: '姓名',
	        width: "25%",
	        align: "left"
	    },{
	        field: 'templetId',
	        title: '模板编号',
	        width: "11%",
	        visible: false
	    }, {
	        field: 'templetName',
	        title: '模板名称',
	        width: "11%",
	        align: "left"
	    }, {
	        field: 'algorithmName',
	        title: '算法类型',
	        align: "left",
	        width: "8%"
	    }, {
	        field: 'scoreVersion',
	        title: '评分版本',
	        align: "left",
	        width: "8%"
	    },  {
	        field: 'createTime',
	        title: '生成报告时间',
	        align: "left",
	        width: "17%",
	        sortable: true,
	        sorOrder: "desc",
	        formatter: function (value, row, index) {
	          if(value !== null) {
	        	var date = new Date(value);
	        	return date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate(); 
	          }
	        },
	        editable: {
	            type: 'text',
	            validate: function(value) {
	                if($.trim(value) == '') {
	                    return '时间不能为空';
	                }else if(!Date.parse(value)){
	                    return '时间设置错误';
	                }
	            }
	        }
	    },{
	        field: 'operation',
	        title: '操作',
	        align: "right",
	        width: "11%",
	        formatter: function(value,row,index){
	        	return  '<a href="javascript:void(0)"  class="creditReportLook" title="基本信息">查看</a>'
	        },
	        events: 'creditReportEvents'
	    }],
	    sortName: 'create_time',
	    pagination: true,
	    sidePagination: 'server',
	    pageNumber: 1,
	    pageSize: 10,
	    cache: false,
	    pageList: [5, 10, 20],
	    queryParams: function (params) {
	        return {
	        	id : cardId,
	        	algorithmType: algorCode,
	            limit: params.limit,
	            offset: params.offset,
	            order: params.order,
	            sort: params.sort
	        }
	    },
	    url: '/creditsupport/personCreditReport/query'
	});
	
  window.creditReportEvents = {
    'click .creditReportLook': function (e, value, row, index) {
    	var algorithmType = row.algorithmType;
    	var templetId = row.templetId;
    	var fileNo = row.fileNo;
    	var filePath = row.path;
    	$("#content").load(global+'/personCreditReport/reportDetail', {id:cardId, fileNo:fileNo, filePath:filePath, templetId:templetId, algorithmType: algorCode}, function () {});
    }
  }
  
  
//查询
  var creditReportSelect = function (value) {
    var params = {id:cardId, fileNo:value, algorithmType:algorCode};
    $.ajax({
      url: "/creditsupport/personCreditReport/query",
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
          var txt="查询出现异常!";
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
          return false;
        }
        if(1 == result){
     	 $('#creditReportTable').bootstrapTable('load', responseText);
        }
        if(2 == result)
        {
        	$("#search").attr("disabled", true); 
        	return true;
        }
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