<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <title>个人管理</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link href="${pageContext.request.contextPath}/favicon.ico" rel="Shortcut icon"/>
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/xcConfirm.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/compangy-manage/index.css" rel="stylesheet">
  <!--[if lt IE 9]>
  <script src="../js/html5shiv.min.js"></script>
  <script src="../js/respond.min.js"></script>
  <![endif]-->
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/highcharts/highcharts.js"></script>
  <script src="${pageContext.request.contextPath}/js/highcharts/drilldown.js"></script>
  <script src="${pageContext.request.contextPath}/js/overwrite-jquery.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.formautofill.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/xcConfirm.js"></script>
</head>
<body>
<div class="warpper">
  <div id="header" class="container-fluid"></div>
  <div class="container-fluid" id="content1">
    <div class="row">
      <div class="col-xs-12 marginLeft marginTop">
        <p class="sumTitle"><a href="person-manage.jsp">个人信息管理</a> > 个人列表</p>
      </div>
      <div class="col-xs-12 marginLeft">
        <div class="input2">
          <div class="pull-left">
            <label>身份证号：</label>
            <input class="form-control firmInquiry" type="text" name="cardId" placeholder="请输入身份证号"/>
          </div>
          <div class="pull-left">
            <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名：</label>
            <input class="form-control firmInquiry" type="text" name="cardName" placeholder="请输入个人姓名"/>
          </div>
          <div class="pull-left">
            <button class="btn" id="searchEnterpriseBtn">搜索</button>
            <button class="btn" id="resetEnterpriseBtn">重置</button>
          </div>
        </div>
      </div>
      <div class="col-xs-12 marginLeft marginTop">
      <button class="btn" data-toggle="modal" data-target="#AgentModal" onclick="toaddAgentModal()">
		<span class="icon-plus"></span>&nbsp;&nbsp; 新增
	  </button>
	  
        <div class="pull-right">
          <%-- <mrp:p rId="211"><button class="btn" id="basic">基本信息</button></mrp:p> --%>
          <mrp:p rId="212"><button class="btn" id="score" disabled="disabled">评分报告</button></mrp:p>
          <mrp:p rId="213"><button class="btn" id="credit">征信报告</button></mrp:p>
         <!--  <form action="http://tag.yodata.com.cn:8090/tag/macro" id="credit_label_form" method="post" style="display: inline-block;" accept-charset="utf-8">
	          <input type="hidden" name="view"  id="label_view" value="1">
	          <input type="hidden" name="agent" id="label_agent">
	          <button type="button" class="btn" id="label_submit" disabled="disabled">标签工场</button>
          </form> -->
        </div>
      </div>
      <div class="col-xs-12 marginLeft">
        <div class="tableContainer">
          <div>
            <table id="tableList" data-toggle="table" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url="/creditsupport/person/query"
                   data-query-params="paginationParam" class="table table-striped">
              <thead>
              <tr>
                <th data-field="number" data-width='5%' data-formatter="operateFormatterNumber">序号</th>
                <th data-field="cardId" data-width='18%' data-align="left">身份证号</th>
                <th data-field="cardName" data-title-tooltip="" data-width='10%' data-align="left">姓名</th>
                <th data-field="createTime" data-width='20%' data-align="left" data-sortable=true  data-order="asc">录入时间</th>
                <th data-field="updateTimeFull"  data-width='20%' data-align="left" data-sortable=true  data-order="asc">更新时间</th>
                <th data-field="indScore" data-width='8%' data-sortable=true data-align="left">最近得分</th>
                <th data-field="algorName" data-title-tooltip="" data-width='10%' data-sortable=true data-align="left">算法描述</th>
                 <th data-field="7" data-width='8%' data-align="right" data-formatter="operateFormatterUpdate" data-events="operateEventsUpdate">操作</th>
                 <th data-field="8" data-width='8%' data-align="right" data-formatter="operateFormatterDept" data-events="operateEventsDept">操作</th>
              </tr>
              </thead>
            </table>
          </div>	
        </div>
      </div>
    </div>
  </div>
  <div class="container-fluid" id="content" style="display:none;"></div>
</div>
<div class="footer autoHeight" id="bottom">
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

<!-- 新增、修改页面 -->
<div class="modal fade" id="AgentModal" tabindex="-1" role="dialog" aria-labelledby="scoreLevelModal" aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="addScoreLevelTitle"></h4>
      </div>
      <div class="modal-body">
          <input type="button" class="single1 btn btnSubmit active" value="单条提交" />&nbsp;&nbsp;&nbsp;
          <!-- <input type="button" class="single2 btn btnSubmit" value="批量提交" disabled="disabled"/>&nbsp;&nbsp;&nbsp; -->
          
          <div id="isAsingle1" class="isAsingle1">
	          
          </div>
      </div>

    </div>
  </div>
</div>
<!-- 新增企业分组 -->
<div class="modal fade" id="tableAddModal" tabindex="-1" role="dialog" aria-labelledby="scoreLevelModal" aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="AddtableModaltitle">新增企业</h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal" role="form" id="scoreLevel_form" action="/creditsupport/person/addAgent" method="post"> 
         <div class="modalInput">
         <input type="hidden" id= "infoId"/>
         <input type="hidden" id= "infoIndex"/>
          <div>
            <label for="">身份证号：</label>
          </div>
          <div>
            <input class="form-control" type="text" id="infoCardCode" name="" placeholder="请输入身份证号">
          </div>
        </div>
        <div class="modalInput">
          <div>
            <label for="">姓名：</label>
          </div>
          <div>
            <input class="form-control" type="text" id="infoName" name="" placeholder="请输入姓名">
          </div>
        </div>
       </form>
      </div>
      <div class="modal-footer">
       <button id="submit_scoreLevel_form" type="button" class="btn" onclick="addOneAgentInfo()">提交</button>
       <button type="button" class="btn" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	//企业类型字典查询下拉列表
	createSelectByDict();
	function createSelectByDict() {
	    $.ajax({
	        url : "/creditsupport/dict/query",
	        type : "post",
	        dataType : "json",
	        data : {
	            category : '100001'
	        },
	        cache : "false",
	        success : function(responseText) {
	        	$("#statusSel").html('');
	        	$("#statusSel").append("<option value='全部'>全部</option>")
	            var result = responseText;
	            if (result.length > 0) {
	                for (var i = 0; i < result.length; i++) {
	                    var name = result[i].name;
	                    $("#statusSel").append("<option value='"+name+"'>" + name+ "</option>");
	                }
	            }
	        }
	    });
	}
  $('#header').load("${pageContext.request.contextPath}/jsp/person/personHeader.jsp?time="+new Date().getMilliseconds(),function(){
    $(".navUl li").eq(0).addClass("active");
  });
  var indexParams = {};
  function operateFormatterDept(value, row, index) {
        return '<a href="javascript:void(0)" class="remove" title="删除">删除</a>';
  }
  function operateFormatterUpdate(value, row, index) {
      return '<a href="javascript:void(0)" class="updatePerson" title="更新">更新</a>';
}
  function operateFormatterNumber(value, row, index) {
    return index+1;
  }
  window.operateEventsDept = {
    //删除企业
    'click .remove': function (e, value, row, index) {
      var txt="您确定删除'"+row.cardName+"'全部信息吗?";
      var option = {
        btn: parseInt("0011",2),
        onOk: function(){
          $.ajax({
            url: "/creditsupport/person/delete/"+row.cardId,
            type:"delete",
            dataType:"json",
            cache:"false",
            success: function(responseText){
              if(1==responseText){
                setTimeout("inquiry()",300);
                var txt="删除成功 !";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
              }else{
                var txt="删除出现异常 !";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
              }
            }
          });
        }
      };
      window.wxc.xcConfirm(txt, "custom", option);
    }
  };
  
  
		  var submitTime = undefined;//提交抓取任务时间
	      var updateTime = undefined;//数据最后更新时间
	      var updateCardId = undefined;//单个提交任务（身份证号）
	      var updateCardIds = undefined;//批量提交任务列表（身份证号）
	      var intervalId = undefined;//轮询ID
          window.operateEventsUpdate = {
		    //更新企业
		    'click .updatePerson': function (e, value, row, index) {
		      var txt="您确定要更新'"+row.cardName+"'信息吗?";
		      var code={'infoCardCode':row.cardId,'infoName':row.cardName};
		      $("#loadingIndex").show();//显示遮罩层
		      var option = {
		        btn: parseInt("0011",2),
		        onOk: function(){
		          $.ajax({
		            url: "/creditsupport/person/updatePerson",
		            type:"POST",
		            data:JSON.stringify(code),
		            dataType:"json",
			        contentType:"application/json",//提交数据类型
			        success: function (responseText) {                        
			            if (0 < responseText ) {   
			            	submitTime = new Date().getTime()/1000;//提交抓取任务时间
			                intervalId = setInterval("updatePersonInquiry()",1500);//5秒刷一次
			            	updateCardId = row.cardId;
			            }else {
			                var txt="更新失败！";
			                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			            }
			        }
		          });
		        },
		        onCancel:function(){
		        	submitTime = undefined;
		            updateCardId = undefined;
		            updateCardIds = undefined;
		            $("#loadingIndex").hide();//关闭遮罩层
                }
		      };
		      window.wxc.xcConfirm(txt, "custom", option);
		    }
		  }; 
  
  //查询
  var inputs = $(".firmInquiry");
  inputs.eq(0).on('change', function () {
    var regNo = inputs.eq(0).val();
    var validate = true;
    validate = checkData(validate, regNo, "营业执照号", checkNum);
    validate = checkData(validate, regNo, "营业执照号", checkLength, 15);
    if(!validate){
        inputs.eq(0).val("");
    }
  });
  inputs.eq(1).on('change', function () {
      var compName = inputs.eq(1).val();
      var validate = true;
      validate = checkData(validate, compName, "姓名", checkLength, 100);
      if(!validate){
          inputs.eq(1).val("");
      }
  });
  inputs.eq(2).on('change', function () {
      var lpName = inputs.eq(2).val();
      var validate = true;
      validate = checkData(validate, lpName, "法人姓名", checkLength, 25);
      if(!validate){
          inputs.eq(2).val("");
      }
  });
  //查询方法
  var inquiry = function () {
	var cardId = inputs.eq(0).val();
    var cardName = inputs.eq(1).val();
    var status = $("#statusSel").find("option:selected").text();
    var params = {cardId: cardId,cardName: cardName,sort:"modTime",order: "desc"};
    $.ajax({
      url: "/creditsupport/person/query",
      type:"post",
      dataType:"json",
      cache:"false",
      data:params,
      success: function(responseText){
        if (responseText.code == 0) {
          var txt = responseText.message;
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
          return false;
        }
    	if (responseText.rows.length == 0){
    		$('#tableList').bootstrapTable('load', responseText);
    		return;
    	}
   		$('#tableList').bootstrapTable('load', responseText);
      }
    });
  };
  //抓取查询方法
  var crowlerInquiry = function () {
	inputs.eq(0).val("");//清空营业执照
	inputs.eq(1).val("");//清空企业名称
	$('#statusSel option:first').attr('selected','true');//状态为全部
	inputs.eq(2).val("");//清空法人姓名
    var params = {sort:"modTime",order: "desc"};
    $.ajax({
      url: "/creditsupport/person/query",
      type:"post",
      dataType:"json",
      cache:"false",
      data:params,
      success: function(responseText){
          //无返回数据
        if (responseText.code == 0) {
          $("#loadingIndex").hide();
          var txt = responseText.message;
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
          return;
        }
        //提交任务后有更新的所有信息
        var updateRows = [];
    	if(!updateTime){
          updateTime = responseText.rows[0].updateTimeFull;//第一次轮询得到最新时间
          return;//第一次轮询直接退出
    	}else{
	    	$(responseText.rows).each(function(idx,val){
	    	    if(updateTime <= val.updateTimeFull){
	    	        updateRows.push(val);
	    	    }
	    	});
    	}
        if(updateRows.length > 0){
            $(updateRows).each(function(idx,val){
	    	    if(updateCardId){
	    	       if(updateCardId == val.cardId){
			    	   $("#loadingIndex").hide();//关闭遮罩层
			    	   updateTime = undefined;//重置更新时间
			    	   updateCardId = undefined;//重置（身份证号）
			    	   clearInterval(intervalId);//终止轮询
			    	   $('#tableList').bootstrapTable('load', responseText);
	    	       }else{
		    	     return;
	    	       }
	    	    }else if(updateCardIds){
	    	        $(updateCardIds).each(function(idx_1,val_1){
	    	            if(val_1.infoCardCode == val.cardId){
	    	               $("#loadingIndex").hide();//关闭遮罩层
    			    	   updateTime = undefined;//重置更新时间
    			    	   updateCardIds = undefined;//重置抓取任务列表（元素包含名称或者工商号）
    			    	   clearInterval(intervalId);//终止轮询
    			    	   $('#tableList').bootstrapTable('load', responseText); 
	    	            }
	    	        });
	    	    }
	    	});
    	 }
    	  //抓取任务超过2分半钟则提示是否继续等待
    	  if((new Date().getTime()/1000 - submitTime) > 30){
		      clearInterval(intervalId);//终止轮询
    		 // var txt="数据未返回，是否继续等待？";
		      var txt="未查询到该人的个人信息！";
    		 /*  var option = {
    		        btn: parseInt("0011",2),
    		        onOk: function(){
    		            submitTime = new Date().getTime()/1000;
    		        	intervalId = setInterval("crowlerInquiry()", 1500); 
    		        },
    		        onCancel:function(){
    		        	submitTime = undefined;
    		            updateCardId = undefined;
    		            updateCardIds = undefined;
			            $("#loadingIndex").hide();//关闭遮罩层
	                } 
    		    };
    		   window.wxc.xcConfirm(txt, "custom", option); */
	          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    		  submitTime = undefined;
	           updateCardId = undefined;
	           updateCardIds = undefined;
	           $("#loadingIndex").hide();//关闭遮罩层
	          return;
    	  }
      }
    });
  };
  //更新企业查询
  var updatePersonInquiry = function () {
	inputs.eq(0).val("");//清空营业执照
	inputs.eq(1).val("");//清空企业名称
	$('#statusSel option:first').attr('selected','true');//状态为全部
	inputs.eq(2).val("");//清空法人姓名
    var params = {sort:"modTime",order: "desc"};
    $.ajax({
      url: "/creditsupport/person/query",
      type:"post",
      dataType:"json",
      cache:"false",
      data:params,
      success: function(responseText){
          //无返回数据
        if (responseText.code == 0) {
          $("#loadingIndex").hide();
          var txt = responseText.message;
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
          return;
        }
        //提交任务后有更新的所有企业
        var updateRows = [];
    	if(!updateTime){
          updateTime = responseText.rows[0].updateTimeFull;//第一次轮询得到最新时间
          return;//第一次轮询直接退出
    	}else{
	    	$(responseText.rows).each(function(idx,val){
	    	    if(updateTime <= val.updateTimeFull){
	    	        updateRows.push(val);
	    	    }
	    	});
    	}
        if(updateRows.length > 0){
            $(updateRows).each(function(idx,val){
	    	    if(updateCardId){
	    	       if(updateCardId == val.cardId){
			    	   $("#loadingIndex").hide();//关闭遮罩层
			    	   updateTime = undefined;//重置更新时间
			    	   updateCardId = undefined;//重置抓取任务（名称或者工商号）
			    	   clearInterval(intervalId);//终止轮询
			    	   $('#tableList').bootstrapTable('load', responseText);
			    	   var txt="更新个人信息成功 !";
		               window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	    	       }else{
		    	     return;
	    	       }
	    	    }
	    	});
    	 }
    	  //抓取任务超过30秒则提示是否继续等待
    	  if((new Date().getTime()/1000 - submitTime) > 30){
		      clearInterval(intervalId);//终止轮询
    		  var txt="个人信息未更新，是否继续等待？";
    		  var option = {
    		        btn: parseInt("0011",2),
    		        onOk: function(){
    		        	submitTime = new Date().getTime()/1000;
    		        	intervalId = setInterval("updatePersonInquiry()", 1500);
    		        },
    		        onCancel:function(){
    		        	submitTime = undefined;
    		            updateCardId = undefined;
    		            updateCardIds = undefined;
			            $("#loadingIndex").hide();//关闭遮罩层
	                }
    		    };
    		   window.wxc.xcConfirm(txt, "custom", option);
    	  }
      }
    });
  };
  //table请求数据前调该方法获取参数
  function paginationParam(params) {
	var cardId = inputs.eq(0).val();
    var cardName = inputs.eq(1).val();
    var status = $("#statusSel").find("option:selected").text();
    return {
      cardId: cardId,
      cardName: cardName,
      sort: params.sort,
      order: params.order,
      limit: params.limit,
      offset: params.offset,
      pageNumber: $('#listTable').bootstrapTable('getOptions').pageNumber
    };
 
  }
  //搜索
  $("#searchEnterpriseBtn").on("click", function () {
	var cardId = inputs.eq(0).val();
	var cardName = inputs.eq(1).val();
	var status = $("#statusSel").find("option:selected").text();
	$('#tableList').bootstrapTable('refresh', {
		url: "/creditsupport/person/query",
		cardId: cardId,
		cardName: cardName,
		sort:"modTime",
		order: "desc"
	});
  });
  //  重置
  $("#resetEnterpriseBtn").on("click", function () {
    inputs.eq(0).val("");
    inputs.eq(1).val("");
    $('#statusSel option:first').attr('selected','true');//状态为全部
    $('#tableList').bootstrapTable('refresh',{url: "/creditsupport/person/query"});
  });
  
  //   返回
  $("#content").on("click", ".returnIndex", function (e) {
	 e.preventDefault();
	 $("#content1").css("display", "block");
	 $("#content").css("display", "none").html("");
  })
  //  基本信息
  $("#basic").on("click", function () {
      if (indexParams.id) {
    	  $("#content1").css("display", "none");
	      $("#content").css("display", "block")
          $("#content").load('/creditsupport/creditReport/querycompInfo', {id:indexParams.id}, function () {
          })
        } else {
          var txt="您未选择任何一条信息，不可进行此操作 !";
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        }
  });

  //  评分报告
  $("#score").on("click", function () {
    if (indexParams.id) {
      $("#content1").css("display", "none");
      $("#content").css("display", "block");
      $("#content").load('./score-report.jsp', {cardId: indexParams.id, compName: indexParams.compName, algorithmType: indexParams.algorithmType}, function () {
      });
    } else {
      var txt="您未选择任何一条信息，不可进行此操作 !";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    }
  });
  //征信报告
  $("#credit").on("click", function () {
    if (indexParams.id) {
	      $("#content1").css("display", "none");
	      $("#content").css("display", "block")
	      $("#content").load("./person-credit-report.jsp", indexParams, function () {
	      })
	    } else {
	      var txt="您未选择任何一条信息，不可进行此操作 !";
	      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	    }
  });
  //宏观画像
  function trimStr(str){return str.replace(/(^\s*)|(\s*$)/g,"");}
  $("#label_submit").on("click", function () {
	var compName = indexParams.compName;
	if (compName) {
		$.ajax({
			url: "/creditsupport/person/agentLabelIsUsable",
			type:"post",
			dataType:"text",
			cache:"false",
			data:{compName:compName},
			success: function(rs){
				if(rs == "1") {
					document.charset='utf-8';
					$("#label_agent").val(trimStr(compName));
					$("#credit_label_form").submit();
				} else {
					var txt="这家代理商还没有标签信息，是否切换腾邦视图!";
					var option = {
				        btn: parseInt("0011",2),
				        onOk: function(){
				        	$("#label_view").val(0);
				        	$("#credit_label_form").submit();
				        }
			        };
			    	window.wxc.xcConfirm(txt, "custom", option);
				}
				
			}
		});
	} else {
	  var txt="您未选择任何一条信息，不可进行此操作 !";
	  window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	}
 });
  //  判断选择的tr的id
   $("#tableList").bootstrapTable().on("click-row.bs.table", function (e, row, $element) {
	   var id = row.cardId;
       indexParams = {id: id, cardName: row.cardName, algorithmType: row.algorCode};
      $("#tableList").find("tr").removeClass('active');
      $element.addClass("active");
  });
  //新增按钮
function toaddAgentModal(){
  $("#addScoreLevelTitle").html("新增分组");
  $("#submit_scoreLevel_form").html("提交");
    //初始化单条提交
	$(".isAsingle1").html(single1);
}

  var bankArr = [];
  var phoneArr = [];
  
 
	function getBankList() 
	{
		$("#bankList tr").each(function() {
			var bankValue = $(this).children().eq(1).text().trim();
			if(bankValue != null && bankValue != "")
				bankArr.push(bankValue);
		});
	}
	function getPhonList() {
		$("#phoneList tr").each(function() {
			var phoneValue = $(this).children().eq(1).text().trim();
			if(phoneValue != null && phoneValue != "")
				phoneArr.push(phoneValue);
		});
	}

	function submits() {
		getBankList();
		getPhonList();
		var param = {};
		param.infoCardCode = $("#card_code").val().trim();
		param.infoName = $("#card_name").val().trim();
		//校验不通过
		if (!validations(param)) {
			return;
		}
		var arr = $("#modalTable").bootstrapTable("getSelections");
		var code = {
			'infoCardCode' : param.infoCardCode,
			'infoName' : param.infoName,
			'bankList' : bankArr,
			'phoneList': phoneArr
		};
		$("#loadingIndex").show();//显示遮罩层
		$.ajax({
			type : "POST",
			url : "/creditsupport/person/addPerson",
			data : JSON.stringify(code),
			dataType : "json",
			contentType : "application/json",//提交数据类型
			success : function(data) {
				if (data != null) {
					$("#AgentModal").modal("hide");//关闭弹窗表单
					submitTime = new Date().getTime() / 1000;//提交抓取任务时间
					intervalId = setInterval("crowlerInquiry()", 1500);//5秒刷一次
					updateCardId = param.infoCardCode;//记录用户的身份证号
				} else {
					var txt = "提交任务失败！";
					window.wxc.xcConfirm(txt,
							window.wxc.xcConfirm.typeEnum.info);
				}
			}
		});
	}
	//  选中当前条的id
	var getSelect = {};
	function submitMany() {
		if (!getSelect.id) {
			var txt = "请选择一条！";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		} else {
			var code = {
				groupId : getSelect.id,
				groupName : getSelect.groupName
			};
			$("#loadingIndex").show();
			$.ajax({
				type : "POST",
				url : "/creditsupport/person/submitGroupId",
				data : JSON.stringify(code),
				dataType : "json",
				contentType : "application/json",//提交数据类型
				success : function(data) {
					if (data == 1) {
						$("#AgentModal").modal("hide");//关闭弹窗表单
						intervalId = setInterval("crowlerInquiry()", 1500);//5秒刷一次
						submitTime = new Date().getTime() / 1000;//记录提交任务时间
						//将本组的企业存到updateCardIds，用于比对抓取结果
						$.ajax({
							type : "GET",
							url : "/creditsupport/person/findAgent",
							data : {
								groupId : code.groupId
							},
							dataType : "json",
							contentType : "application/json",//提交数据类型
							success : function(data) {
								if (data && data.rows.length > 0) {
									updateCardIds = data.rows;//记录抓取关键字
								} else {
									updateCardIds = undefined;
								}
							}
						})
					} else {
						var txt = "提交任务失败！";
						window.wxc.xcConfirm(txt,
								window.wxc.xcConfirm.typeEnum.info);
					}

				}
			});
		}
	}

	var single3 = '';
	var single2 = '';
	var single1 = '';
	$(function() {
		single1 = '<div class="modalInput">'
				+ '<div>'
				+ '<label for="levelScoreMin_manage">身份证号：</label>'
				+ '</div>'
				+ '<div>'
				+ '<input class="form-control"  type="text" id="card_code" name="levelScoreMin"  placeholder="请输入身份证号"/>'
				+ '</div>'
				+ '</div>'
				+ '<div class="modalInput">'
				+ '<div>'
				+ '<label for="levelName_manage">姓名：</label>'
				+ '</div>'
				+ '<div>'
				+ '<input class="form-control"  type="text" id="card_name" name="levelName"  placeholder="请输入姓名"/>'
				+ '</div>'
				+ '</div>'
				+ '<div class="modal-footer">'
				+ '<button type="button" class="btn"  style="display:none"></button>'
				+ '<button id="btn_bankNo" type="button" class="btn" onclick="inputBankNo()">银行卡号</button>'
				+ '</div>'
				+ '<div class="modalInput" id="inputBankDiv" style="display:none">'
				+ '<div>'
				+ '<label for="levelName_manage"></label>'
				+ '</div>'
				+ '<div>'
				+ '<input class="form-control"  type="text" id="bankNo" name="levelName"  placeholder="请输入银行卡号"/>'
				+ '</div>'
				+ '</div>'
				+ '<div class="modal-footer" id="inputBankDiv2" style="display:none">'
				+ '<div>'
				+ '<button type="button" class="btn" style="display:none"></span></button>'
				+ '<button type="button" class="btn" onclick="addBank()"><span class="icon-plus"></span></button>'
				+ '<button type="button" class="btn" onclick="delBank()">-</button>'
				+ '</div>'
				+ '<div style="text-align:center;overflow-x: auto; overflow-y: auto; height: 120px; width:600px;">'
				+ '<table id="bankList" class="table table-striped">'
				+ '</table>'
				+ '</div>'
				+ '</div>'
				+ '<div class="modal-footer">'
				+ '<button type="button" class="btn" style="display:none"></button>'
				+ '<button id="btn_phoneNo" type="button" class="btn" onclick="inputPhoneNo()">手机号</button>'
				+ '</div>'
				+ '<div class="modalInput" id="inputPhoneDiv" style="display:none">'
				+ '<div>'
				+ '<label for="levelName_manage"></label>'
				+ '</div>'
				+ '<div>'
				+ '<input class="form-control"  type="text" id="phoneNo" name="levelName"  placeholder="请输入手机号"/>'
				+ '</div>'
				+ '</div>'
				+ '<div class="modal-footer" id="inputPhoneDiv2" style="display:none">'
				+ '<div>'
				+ '<button type="button" class="btn" style="display:none"></span></button>'
				+ '<button type="button" class="btn" onclick="addPhone()"><span class="icon-plus"></span></button>'
				+ '<button type="button" class="btn" onclick="delPhone()">-</button>'
				+ '</div>'
				+ '<div style="text-align:center;overflow-x: auto; overflow-y: auto; height: 120px; width:600px;">'
				+ '<table id="phoneList" class="table table-striped">'
				+ '</table>'
				+ '</div>'
				+ '</div>'
				+ '<div class="modal-footer">'
				+ '<button id="submit_scoreLevel_form" type="button" class="btn" onclick="submits()">提交</button>'
				+ '<button class="btn" data-dismiss="modal">取消</button>'
				+ '</div>';
		single2 = '<div class="changeSingle3">'
				+ '<button class="btn ok marginTop" onclick="single3Add()">新增分组</button>'
				+ '<div  class="tableslists"  >'
				+ '<div>'
				+ '<table id="modalTable" class="table table-striped">'
				+ '</table>'
				+ '</div >'
				+ '<div class="modal-footer">'
				+ '<button id="submit_scoreLevel_form" type="button" class="btn" onclick="submitMany()">提交</button>'
				+ '<div>' + '</div>' + '</div>';
		single3 = '<div class="marginTopSmall">'
				+ '<button class="btn" data-toggle="modal" data-target="" onclick="ontableAddModal()">新增</button>'
				+ '<div class="marginTop"><label>分组名称：</label><input class="form-control" id="agentnames"><input class="form-control" type="hidden" id="agentnamesid"></div>'
				+ '<div><table id="tableAdd" class="table table-striped"></table></div>'
				+ '<div class="modal-footer">' + '</div>' + '</div>';
		//点击批量提交
		$(".single2").click(function() {
			setTable();
			$(".single1").removeClass("active")
			$(this).addClass("active");
		});

		//点击单条(刚好与批量相反)
		$(".single1").click(function() {
			$(".isAsingle1").html(single1);
			$(".single3").hide();
			$(".single2").removeClass("active");
			$(".single1").addClass("active");
		});
	});
	//点击新增
	function single3Add() {
		$(".changeSingle3").html(single3);
		tableAdd();
	}

	function tableAdd() {
		$("#tableAdd")
				.bootstrapTable(
						{
							columns : [
									{
										field : 'index',
										title : '序号',
										width : "15%",
										align : "left",
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										field : 'infoCardCode',
										title : '身份证号',
										width : "25%",
										align : "left"
									},
									{
										field : 'infoName',
										title : '姓名',
										width : "35%",
										align : "left",
									},
									{
										field : 'operation',
										title : '操作',
										width : '15%',
										align : "right",
										formatter : function(value, row, index) {
											return [
													'<a href="javascript:void(0)"  class="tableAddEdit" title="编辑">编辑</a>&nbsp',
													'<a href="javascript:void(0)" class="tableAddRemove" title="删除">删除</a>' ]
													.join('');
										},
										events : 'tabelAddEvents'
									} ],
							height : 150,
							cache : false
						});
	}

	window.tabelAddEvents = {
		"click .tableAddEdit" : function(e, value, row, index) {
			var id = row.id;
			$("#AddtableModaltitle").html("编辑企业");
			$("#tableAddModal").modal("show");
			$("#infoId").val(row.infoId);
			$("#infoIndex").val(index);
			$("#infoCardCode").val(row.infoCardCode);
			$("#infoName").val(row.infoName);
		},
		"click .tableAddRemove" : function(e, value, row, index) {

			var id = row.infoId;
			var indexs = [];
			$($("#tableAdd").bootstrapTable('getOptions').data).each(
					function(index) {
						indexs.push(index);
					})

			var txt = "您确定删除吗?";
			var option = {
				btn : parseInt("0011", 2),
				onOk : function() {

					$.ajax({
						type : "post",
						url : "/creditsupport/person/deleteAgent",
						data : JSON.stringify({
							groupId : $("#agentnamesid").val(),
							agentinfos : [ {
								infoId : row.infoId
							} ]
						}),
						dataType : "json",
						contentType : "application/json",//提交数据类型
						success : function(data) {
							if (data == 1) {
								var txt = "删除成功!";
								window.wxc.xcConfirm(txt,
										window.wxc.xcConfirm.typeEnum.info);

								var id = $("#agentnamesid").val();
								$.ajax({
									type : "GET",
									url : "/creditsupport/person/findAgent",
									data : {
										groupId : id
									},
									dataType : "json",
									contentType : "application/json",//提交数据类型
									success : function(data) {
										$("#tableAdd").bootstrapTable('load',
												data.rows);
										$("#agentnamesid").val(id);
									}
								})

							} else {
								var txt = "删除失败!";
								window.wxc.xcConfirm(txt,
										window.wxc.xcConfirm.typeEnum.info);
							}
						}

					});

				}
			};
			window.wxc.xcConfirm(txt, "custom", option);
		}
	}
	function setTable() {
		$(".isAsingle1").html(single2);
		$("#modalTable")
				.bootstrapTable(
						{
							columns : [
									{
										field : 'number',
										title : '序号',
										width : "35%",
										align : "left",
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										field : 'groupName',
										title : '分组名称',
										width : "45%",
										align : "left",
									},
									{
										field : 'operation',
										title : '操作',
										width : '20%',
										align : "right",
										formatter : function(value, row, index) {
											return [
													'<a href="javascript:void(0)"  class="modalEdit" title="编辑">编辑</a>&nbsp',
													'<a href="javascript:void(0)" class="modalRemove" title="删除">删除</a>' ]
													.join('');
										},
										events : 'modalEventsDept'
									} ],
							height : 300,
							pagination : false,
							sidePagination : 'server',
							pageNumber : 1,
							pageSize : 10,
							cache : false,
							pageList : [ 5, 10, 20 ],
							url : '/creditsupport/person/findGroup'
						});
		$("#modalTable").bootstrapTable().on("click-row.bs.table",
				function(e, row, $element) {
					var id = row.groupId;
					var groupName = row.groupName;
					getSelect = {
						id : id,
						groupName : groupName
					};
					$("#modalTable").find("tr").removeClass('active');
					$element.addClass("active");
				})
	}

	$(function() {
		addtr();
		del();
	});

	//计算批量新增的序号
	function addtr() {
		$(".addtr").each(function(i) {
			$(".addtr").eq(i).html(i + 1);
		});
	}

	//删除一行
	function del() {

		$("#isAsingle1").on("click", ".dels", function() {
			$(this).parent().remove();
			addtr();
		})
	}

	var str = '<div class="marginTopSmall rmeoveS">'
			+ '<span class="titleNumber addtr"></span>'
			+ '<input class="infoId" type="hidden"/>'
			+ '<input class="form-control infoCardCode addInput" type="text"/>'
			+ '<input class="form-control infoName addInput" type="text"/>'
			+ '<a class="operating dels" href="javascript:void(0)">删除</a>'
			+ '</div>';
	//新增一行
	function addtd() {

		$("#table100").append(str);
		addtr();
		del();
	}

	window.modalEventsDept = {
		'click .modalEdit' : function(e, value, row, index) {
			var id = row.groupId;
			$(".isAsingle1").html(single3);
			$("#agentnames").val(row.groupName);
			$("#agentnamesid").val(row.groupId);
			tableAdd();
			$.ajax({
				type : "GET",
				url : "/creditsupport/person/findAgent",
				data : {
					groupId : id
				},
				dataType : "json",
				contentType : "application/json",//提交数据类型
				success : function(data) {
					$("#tableAdd").bootstrapTable('load', data.rows);
				}
			})

		},
		"click .modalRemove" : function(e, value, row, index) {
			var id = row.groupId;
			var txt = "您确定删除吗?";

			var option = {
				btn : parseInt("0011", 2),
				onOk : function() {
					$.ajax({
						type : "post",
						url : "/creditsupport/person/deleteGroup",
						data : JSON.stringify({
							groupId : row.groupId,
							groupName : row.groupName
						}),
						dataType : "json",
						contentType : "application/json",//提交数据类型
						success : function(data) {
							if (data == 1) {
								var txt = "删除成功!";
								window.wxc.xcConfirm(txt,
										window.wxc.xcConfirm.typeEnum.info);
								setTable();
							} else {
								var txt = "删除失败!";
								window.wxc.xcConfirm(txt,
										window.wxc.xcConfirm.typeEnum.info);
							}
						}

					});
				}
			};
			window.wxc.xcConfirm(txt, "custom", option);
		}
	}

	function onblu(val) {
		$.ajax({
			type : "GET",
			url : "/creditsupport/person/isAgent",
			data : {
				compname : val
			},
			dataType : "json",
			contentType : "application/json",//提交数据类型
			success : function(data) {
				if (data.status == 1) {
					var txt = "分组名称已存在！";
					window.wxc.xcConfirm(txt,
							window.wxc.xcConfirm.typeEnum.info);
					$("#agentnames").val("");
				}

			}
		})
	}

	function cancelok() {
		setTable();
	}

	//验证
	function validations(data) {
		var validate = true;

		if (!data.infoCardCode) {
			var txt = "身份证号不能为空!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		} else if (!data.infoName) {
			var txt = "姓名不能为空!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		} else {
			if (data.infoCardCode.length != 18) {
				var txt = "身份证号长度大于18位或者小于18位！";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				return false;
			}
			/* if (data.infoName) {
				validate = checkData(validate, data.infoName, "姓名",checkLength, 10);
			} */
			if (!validate) {
				return false;
			}
		}
		return true;
	}

	function addOneAgentInfo() {
		var data = {};
		data.infoCardCode = $("#infoCardCode").val().trim();
		data.infoName = $("#infoName").val().trim();

		if (!validations(data)) {
			return;
		}

		var infoId = $("#infoId").val().trim();
		var agentinfos = {
			infoCardCode : data.infoCardCode,
			infoName : data.infoName,
			infoId : infoId ? infoId : null
		};
		$.ajax({
			type : "post",
			url : "/creditsupport/person/EditAgent",
			data : JSON.stringify({
				groupId : $("#agentnamesid").val() ? $("#agentnamesid").val()
						: null,
				groupName : $("#agentnames").val(),
				agentinfos : [ agentinfos ]
			}),
			dataType : "json",
			contentType : "application/json",//提交数据类型
			success : function(data) {
				if (data.status == 1) {
					var txt = "编辑成功!";
					window.wxc.xcConfirm(txt,
							window.wxc.xcConfirm.typeEnum.info);

					var id = data.id;
					$("#agentnamesid").val(id);
					$.ajax({
						type : "GET",
						url : "/creditsupport/person/findAgent",
						data : {
							groupId : id
						},
						dataType : "json",
						contentType : "application/json",//提交数据类型
						success : function(data) {
							$("#tableAdd").bootstrapTable('load', data.rows);
						}
					})

				} else if (data.status == 3) {
					var txt = "分组名称已存在！";
					window.wxc.xcConfirm(txt,
							window.wxc.xcConfirm.typeEnum.info);
					$("#agentnames").val("");
				} else {
					var txt = "编辑失败!";
					window.wxc.xcConfirm(txt,
							window.wxc.xcConfirm.typeEnum.info);

				}
			}

		});
		$("#tableAddModal").modal("hide");
		$("#infoCardCode").val("");
		$("#infoName").val("");
	}

	function ontableAddModal() {
		if ($("#agentnames").val() == "") {
			var txt = "分组名称不能为空！";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		} else {

			$("#infoId").val("");
			$("#infoIndex").val("");
			$("#infoCardCode").val("");
			$("#infoName").val("");
			$("#AddtableModaltitle").html("新增企业");
			$("#tableAddModal").modal("show");
		}
	}

	$(".modal.fade").modal({
		show : false,
		keyboard : false
	});

	function inputBankNo() {
		if (checkInputIdAndName()) {
			if ($("#inputBankDiv").css('display') == 'none') {
				$("#inputBankDiv").show();
				$("#inputBankDiv2").show();
			} else {
				$("#inputBankDiv").hide();
				$("#inputBankDiv2").hide();
			}
		}
	}

	function inputPhoneNo() {
		if (checkInputIdAndName()) {
			if ($("#inputPhoneDiv").css('display') == 'none') {
				$("#inputPhoneDiv").show();
				$("#inputPhoneDiv2").show();
			} else {
				$("#inputPhoneDiv").hide();
				$("#inputPhoneDiv2").hide();
			}
		}
	}

	//添加银行卡号
	function addBank() {
		var inputBank = $("#bankNo").val().trim();
		if (inputBank != "") {
			if (!checkNum(inputBank)) {
				txt = "输入的银行卡号存在非整数！";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				return;
			}
			if (checkBankRepeat(inputBank)) {
				txt = "输入的银行卡号已经存在！";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				return;
			}
			$("#bankList").append(
					'<tr><td width="5%"><input type="checkbox" name="delBank"></td><td>'
							+ inputBank + '</td></tr>');
			$("#bankNo").val("");
		}
	}

	function checkBankRepeat(inputBank) {
		var result = false;
		$("#bankList tr").each(function() {
			var bankValue = $(this).children().eq(1).text().trim();
			if (bankValue == inputBank) {
				result = true;
				return;
			}
		});
		return result;
	}

	//删除银行卡号
	function delBank() {
		$("input[name='delBank']:checked").each(function() { // 遍历选中的checkbox
			n = $(this).parents("tr").index(); // 获取checkbox所在行的顺序
			$("table#bankList").find("tr:eq(" + n + ")").remove();
		});
	}

	//添加手机号
	function addPhone() {
		if ($("#phoneNo").val().trim() != "") {
			var txt = "";
			var inputPhone = $("#phoneNo").val().trim();
			if (inputPhone.length != 11) {
				txt = "手机号码大于11位或者小于11位！";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				return;
			}
			if (!checkNum(inputPhone)) {
				txt = "输入的手机号码存在非整数！";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				return;
			}
			if (checkPhoneRepeat(inputPhone)) {
				txt = "输入的手机号已经存在！";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				return;
			}
			$("#phoneList").append(
					'<tr><td width="5%"><input type="checkbox" name="delPhone"></td><td>'
							+ inputPhone + '</td></tr>');
			$("#phoneNo").val("");

		}
	}

	//判断手机号是否已存在
	function checkPhoneRepeat(inputPhone) {
		var result = false;
		$("#phoneList tr").each(function() {
			var phoneValue = $(this).children().eq(1).text().trim();
			if (phoneValue == inputPhone) {
				result = true;
				return;
			}
		});
		return result;
	}

	//删除手机号
	function delPhone() {
		$("input[name='delPhone']:checked").each(function() { // 遍历选中的checkbox
			n = $(this).parents("tr").index(); // 获取checkbox所在行的顺序
			$("table#phoneList").find("tr:eq(" + n + ")").remove();
		});
	}

	//输入银行卡号和手机号时，必须先输入身份证号和姓名
	function checkInputIdAndName() {
		var cardId = $("#card_code").val().trim();
		var cardName = $("#card_name").val().trim();
		var txt = "";
		if (cardId == "" || cardName == "") {
			txt = "姓名或身份证不能为空！";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if (cardId.length != 18) {
			txt = "身份证号码大于18为或小于18位！";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		return true;
	}

	//检测是否为正整数的数字
	function checkNum(val) {
		var ex = /^(\+|-)?\d+$/;
		var result = ex.test(val);
		return result;
	}
</script>
</body>
</html>