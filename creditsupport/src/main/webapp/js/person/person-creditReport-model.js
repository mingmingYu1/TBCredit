$(document).ready(function() {
  var $table= $('#modelTable');
  $table.bootstrapTable({
    columns: [{
      field: 'index',
      title: '序号',
      width: '6%',
      formatter: function (value, row, index) {
    	return index+1
      }		
    },{
      field: 'id',
      title: '主键',
      visible: false
    },{
      field: 'number',
      title: '模板编号',
      align: "left"
    },{
      field: 'name',
      title: '模板名称',
      align: "left"
    },{
        field: 'type',
        title: '报告类别',
        align: "left",
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
      },{
      field: 'declare',
      title: '声明',
      visible: false
      },{
      field: 'createTime',
      title: '生成模板时间',
      align: "left",
      sortable: true,
      sortOrder: "desc",
      formatter: function (value, row, index) {
        if(value !== null) {
          var date = new Date(value);
          return date.getFullYear() + "-" + (date.getMonth()+1)+ "-" + date.getDate();
        }
      }
    },{
      field: 'operation',
      title: '操作',
      align: "right",
      formatter: function(value,row,index){
        return  [
          '<a href="javascript:void(0)"  class="modelEdit" title="编辑">编辑</a>',
          '&nbsp;&nbsp;<a href="javascript:void(0)"  class="modelRemove" title="删除">删除</a>'
        ].join("");
      },
      events: 'creditReportEvents'
    }],
    sortOrder: "desc",
    sortName: 'create_time',
    pagination: true,
    sidePagination: 'server',
    pageNumber: 1,
    pageSize: 10,
    cache: false,
    pageList: [5, 10, 20],
    queryParams: function (params) {
      return {
        limit: params.limit,
        offset: params.offset,
        order: params.order,
        sort: params.sort,
        name: $("#modelName").val(),
        number: $("#modelNumber").val()
      }
    },
    url: '/creditsupport/personReportTemplet/query'
  });
  
  //选择
  var divs = $(".isShow");
  $(".controlShow").each(function (i) {
    this.index = i;
  }).on("change", function () {
	  var nums=$("input[type=checkbox]");
	  var tempChecked=0;//用于给选中的checkbox对应的模块赋值
	  for(var i=0;i<divs.length;i++){
		  if($(nums[i]).is(":checked")){
		   var temp=$(".pull-left",divs.eq(i));
		   var tempWords=temp.html().substring((tempChecked<9?2:3),temp.html().length);//由于编号是和后面的内容写在同一个标签里面的，所以我使用了截取。
		   temp.html(++tempChecked+"、"+tempWords);//如果被选中，就把tempChecked增加1,来改变编号，后面的文字不变
		   console.log(tempWords);
		  }
	  }
      if($(this).is(":checked")){
        divs.eq(this.index+1).show();
      }else {
        divs.eq(this.index+1).hide();
      }
  });
  
  var radioGroup = $("#creditReportModelModal input:radio[name=type]"); // 报告类别单选按钮组
  window.creditReportEvents = {
    //   编辑
    'click .modelEdit': function (e, value, row, index) {
      $("input[type=checkbox]").prop("checked",false);
      var module_list=row.module_list;
      module_list=module_list.substring(1,module_list.length-1).split(",");
      var tempChecked=0;
      debugger;
      for(var i=0;i<module_list.length;i++){
    	  var kv=module_list[i].split(":");
    	  var mid = kv[0].replace(/\"/g,"");
    	  if(kv[1]==0){
    		  $("input[name="+kv[0]+"]").prop("checked",false);
    		  $("#"+mid).hide();
    	  } else if(kv[1]==1) {
    		  $("input[name="+kv[0]+"]").prop("checked",true);
    		  var s = $("#"+mid);
    		  var temp=$(".pull-left",s);
    		  console.log(tempChecked);
   		   	  var tempWords=temp.html().substring((tempChecked<9?2:3),temp.html().length);//由于编号是和后面的内容写在同一个标签里面的，所以我使用了截取。
   		   	  temp.html(++tempChecked+"、"+tempWords);
    		  s.show();
    		 
    	  }
      }
      $("#addScoreModelTitle").html("编辑");
      $("#subModel").html("保存")
      $("#creditReportModelModal").modal("show");
      $("#modelId").val(row.id);
      radioGroup.eq(parseInt(row.type)-1).prop("checked",true); // 初始化选中
      $("#creditReportModelModal input[name=modelName]").val(row.name);
	  $("#creditReportModelModal input[name=modelNumber]").val(row.number);
	  $("#creditReportModelModal textarea[name=declare]").val(row.declare);
    },

    //删除
    'click .modelRemove': function (e, value, row, index) {
      var id = row.id;
      var txt="您确定删除吗 ?";
	  var option = {
	  btn: parseInt("0011",2),
	  onOk: function(){
      var id = row.id;
      var params = {'id':id};
			$.ajax({ 
				url: "/creditsupport/personReportTemplet/delete",
				type:"post",
				dataType:"json",
				cache:"false",
				data:params, 
				success: function(responseText){
					if(responseText.code == 0) {
		                $('#modelTable').bootstrapTable('refresh', {url: "/creditsupport/reportTemplet/query"});
		                window.wxc.xcConfirm(responseText.message, window.wxc.xcConfirm.typeEnum.info);
		            } else {
		            	window.wxc.xcConfirm(responseText.message, window.wxc.xcConfirm.typeEnum.info);
		            }
            	}
            });
		  }
	  };
	  window.wxc.xcConfirm(txt, "custom", option);
    }
  };
  

  
  $("#basic input, #basic textarea").attr("readonly", "readonly");

  $("#special input, #special textarea").attr("readonly", "readonly");
  
  $("#office6 input, #office6 textarea").attr("readonly", "readonly");
  
  $("#Investment7 input, #office6 textarea").attr("readonly", "readonly");
  

  $("#addModel").on("click", function () {

    addmodel()
  });
  
  function addmodel() {
	$("#addScoreModelTitle").html("新增");
	$("#modelId").val("");
	radioGroup.prop("checked",false);	// 取消选中 用户必须亲自选一个
	$("#creditReportModelModal input[name=modelName]").val("");
	$("#creditReportModelModal input[name=modelNumber]").val("");
	$("#creditReportModelModal textarea[name=declare]").val("");
	$(".creditReportListTitle input[type=checkbox]").prop("checked",true);
	
	$(".isShow").show();
	divs.each(function (index) {
	    var nums=$("input[type=checkbox]");
	    var tempChecked=0;//用于给选中的checkbox对应的模块赋值
	    for(var i=0;i<divs.length;i++){
	    	
	    	var temp=$(".pull-left",divs.eq(i));
	    	var tempWords=temp.html().substring((tempChecked<9?2:3),temp.html().length);//由于编号是和后面的内容写在同一个标签里面的，所以我使用了截取。
	    	temp.html(++tempChecked+"、"+tempWords);//如果被选中，就把tempChecked增加1,来改变编号，后面的文字不变
	    	console.log(tempWords);
	    }
	}).show();
  }
  $("#creditReportModelModal").on("shown.bs.modal", function () {
  	$("#creditReportModelModal input[name=modelNumber]").focus()
  });
  $table.bootstrapTable().on('post-body.bs.table',function(){
    pageHeight();
  });

  //  隐藏按钮
  $("#modelContainer").find(".btn.closeLeft").on("click", function () {
    hideLeft();
    checkHeight("#modelContainer");
  });
});


function clearSearch(){
    $("#modelName").val("");
    $("#modelNumber").val("");
    $('#modelTable').bootstrapTable('refresh',{url: "/creditsupport/reportTemplet/query"});
}
//查询
function creditReportModelSelect() {
  var modelName=$("#modelName").val();
  var modelNumber=$("#modelNumber").val();
  var params = {"name":modelName,"number":modelNumber};
  $.ajax({
    url: "/creditsupport/personReportTemplet/query",
    type:"post",
    dataType:"json",
    cache:"false",
    data:params,
    success: function(responseText){
   	 $('#modelTable').bootstrapTable('load', responseText);
    }
  });
};


//新增、编辑页面树
function createReportModel() {
	var checkboxs=$(".creditReportListTitle input[type=checkbox]");
	var module_list="";
	for(var i=0;i<checkboxs.length;i++){
		if(checkboxs[i].checked==true){
			module_list+="\""+checkboxs[i].name+"\""+":1,";
		}else{
			module_list+="\""+checkboxs[i].name+"\""+":0,"
		}
	}
	module_list="{"+module_list.substring(0,module_list.length-1)+"}";
	var modelName=$.trim($("#creditReportModelModal input[name=modelName]").val());
	var modelNumber=$.trim($("#creditReportModelModal input[name=modelNumber]").val());
	var declare=$.trim($("#creditReportModelModal textarea[name=declare]").val());
	var radioType = $('#creditReportModelModal input:radio[name="type"]:checked').val();
	if(!radioType) {
		window.wxc.xcConfirm("报告类别不能为空！", window.wxc.xcConfirm.typeEnum.info);
		return;
	}
	if(modelName==""){
       window.wxc.xcConfirm("模板名不能为空", window.wxc.xcConfirm.typeEnum.info);
       return;
	}
	if(modelNumber==""){
       window.wxc.xcConfirm("模板编号不能为空", window.wxc.xcConfirm.typeEnum.info);
       return
	}
	if(declare==""){
       window.wxc.xcConfirm("重要声明不能为空", window.wxc.xcConfirm.typeEnum.info);
       return;
	}
	$.ajax({
		url : "/creditsupport/personReportTemplet/update",
		type : "post",
		dataType : "json",
		data : {
			"moduleList" : module_list,
			"name":modelName,
			"number":modelNumber,
			"declare":declare,
			"id":$("#modelId").val(),
			"type": radioType
		},
		cache : "false",
		success : function(responseText) {
			if(responseText.code == 0) {
			 $("#creditReportModelModal").modal("hide");
			 $('#modelTable').bootstrapTable('refresh', "/creditsupport/reportTemplet/query");
			 window.wxc.xcConfirm(responseText.message, window.wxc.xcConfirm.typeEnum.info);		 
			} else {
            	window.wxc.xcConfirm(responseText.message, window.wxc.xcConfirm.typeEnum.info);
            }
		}
	});
}

