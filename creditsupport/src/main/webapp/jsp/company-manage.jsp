<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <title>企业管理</title>
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
  <script>
    var sessionUserName = '${sessionUser.userName}';
  </script>
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/highcharts/highcharts.js"></script>
  <script src="${pageContext.request.contextPath}/js/highcharts/drilldown.js"></script>
  <script src="${pageContext.request.contextPath}/js/overwrite-jquery.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.formautofill.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
  <script src="${pageContext.request.contextPath}/js/xcConfirm.js"></script>
</head>
<body>
<div class="warpper">
  <div id="header" class="container-fluid"></div>
  <div class="container-fluid" id="content1">
    <div class="row">
      <div class="col-xs-12 marginLeft marginTop">
        <p class="sumTitle"><a href="company-manage.jsp">企业管理</a> > 企业列表</p>
      </div>
      <div class="col-xs-12 marginLeft">
        <div class="inputs">
          <div class="pull-left">
            <label>营业执照号：</label>
            <input class="form-control firmInquiry" type="text" name="regId" placeholder="请输入营业执照号"/>
          </div>
          <div class="pull-left">
            <label>企业名称：</label>
            <input class="form-control firmInquiry" type="text" name="compName" placeholder="请输入企业名称"/>
          </div>
          <div class="pull-left">
            <label for="statusSel">企业状态：</label>
            <select class="form-control" name="status" id="statusSel">
            </select>
          </div>
        </div>
      </div>
      <div class="col-xs-12 marginLeft">
        <div class="input2">
          <label>&nbsp;&nbsp;&nbsp;法人姓名：</label>
          <input class="form-control firmInquiry" type="text" name="lperName" placeholder="请输入法人姓名"/>
          <button class="btn" id="searchEnterpriseBtn">搜索</button>
          <button class="btn" id="resetEnterpriseBtn">重置</button>
        </div>
      </div>
      <div class="col-xs-12 marginLeft marginTop">
        <mrp:p rId="214">
          <button class="btn" data-toggle="modal" data-target="#AgentModal" onclick="toaddAgentModal()">
            <span class="icon-plus"></span>&nbsp;&nbsp; 新增
          </button>
        </mrp:p>

        <div class="pull-right">
          <mrp:p rId="211"><button class="btn" id="basicXX">基本信息</button></mrp:p>
          <mrp:p rId="213"><button class="btn" id="scoreBG" >评分报告</button></mrp:p>
          <mrp:p rId="212"><button class="btn" id="credit">征信报告</button></mrp:p>
          <!-- <form action="http://tag.yodata.com.cn:8090/tag/macro" id="credit_label_form" method="post" style="display: inline-block;" accept-charset="utf-8">
	          <input type="hidden" name="view"  id="label_view" value="1">
	          <input type="hidden" name="agent" id="label_agent">
	          <button type="button" class="btn" id="label_submit">标签工场</button>
          </form> -->
        </div>
      </div>
      <div class="col-xs-12 marginLeft">
        <div class="tableContainer">
          <div>
            <table id="tableList" data-toggle="table" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url="/creditsupport/company/query"
                   data-query-params="paginationParam" class="table table-striped">
              <thead>
              <tr>
                <th data-field="number" data-width='7%' data-formatter="operateFormatterNumber">序号</th>
                <th data-field="regId" data-width='18%' data-align="left">营业执照号</th>
                <th data-field="compName" data-title-tooltip="" data-width='20%' data-align="left">企业名称</th>
                <th data-field="lperName" data-title-tooltip="" data-width='10%' data-align="left">法人姓名</th>
                <th data-field="createTime" data-width='20%' data-align="left" data-sortable=true  data-order="asc">录入时间</th>
                <th data-field="updateTime" data-width='20%' data-align="left" data-sortable=true  data-order="asc">更新时间</th>
                <th data-field="updateTimeFull" data-visible=false>更新时间</th>
                <th data-field="statusName" data-title-tooltip="" data-width='10%' data-align="left">企业状态</th>
                <th data-field="indScore" data-width='12%' data-sortable=true data-align="left">最近得分</th>
                <th data-field="algorName" data-title-tooltip="" data-width='14%' data-sortable=true data-align="left">算法描述</th>
                <!--<th data-field="7" data-width='8%' data-align="right" data-formatter="operateFormatterUpdate" data-events="operateEventsUpdate"></th>-->
                <th data-field="8" data-width='12%' data-align="right" data-formatter="operateFormatterDept" data-events="operateEventsDept">操作</th>
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
<div class="modal fade" data-backdrop="static" id="AgentModal" tabindex="-1" role="dialog" aria-labelledby="scoreLevelModal" aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="addScoreLevelTitle"></h4>
      </div>
      <div class="modal-body">
        <input type="button" class="single1 btn btnSubmit active" value="单条提交" />&nbsp;&nbsp;&nbsp;
        <input type="button" class="single2 btn btnSubmit" value="批量提交" disabled="disabled"/>&nbsp;&nbsp;&nbsp;
        <div id="isAsingle1" class="isAsingle1">
          <div class="modalInput">
            <input class="form-control"  type="hidden" id="org_code" name="levelScoreMin"  placeholder="请输入工商注册号"/>
          </div>
          <div class="modalInput">
            <div>
              <label for="comp_name">企业名称：</label>
            </div>
            <div>
              <input class="form-control"  type="text" id="comp_name" name="levelName"  placeholder="以中英文或+-()空格符组成且以中英文开头,长度不超过50位"/>
            </div>
          </div>
          <div class="modal-footer">
            <button id="submit_scoreLevel_form" type="button" class="btn" onclick="submits()">提交</button>
            <button class="btn" data-dismiss="modal">取消</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- 新增企业分组
<div class="modal fade" id="tableAddModal" tabindex="-1" role="dialog" aria-labelledby="scoreLevelModal" aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="AddtableModaltitle">新增企业</h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal" role="form" id="scoreLevel_form" action="/creditsupport/company/addAgent" method="post"> 
         <div class="modalInput">
         <input type="hidden" id= "infoId"/>
         <input type="hidden" id= "infoIndex"/>
          <div>
            <label for="">工商注册号：</label>
          </div>
          <div>
            <input class="form-control" type="text" id="infoCreditcode" name="" placeholder="请输入工商注册号">
          </div>
        </div>
        <div class="modalInput">
          <div>
            <label for="">企业名称：</label>
          </div>
          <div>
            <input class="form-control" type="text" id="infoName" name="" placeholder="请输入企业名称">
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
</div> -->
<script type="text/javascript">
	//企业类型字典查询下拉列表
	createSelectByDict();
	function createSelectByDict() {
    $.ajax({
      url : "/creditsupport/dict/query",
      type : "post",
      dataType : "json",
      data : { category : '100001'},
      cache : "false",
      success : function(responseText) {
        var $statusSel = $("#statusSel")
        $statusSel.html('');
        $statusSel.append("<option value='全部'>全部</option>")
        var result = responseText;
        if (result.length > 0) {
          for (var i = 0; i < result.length; i++) {
            var name = result[i].name;
            $statusSel.append("<option value='"+name+"'>" + name+ "</option>");
          }
        }
      }
    });
	}
  $('#header').load("${pageContext.request.contextPath}/jsp/header.jsp?time="+new Date().getMilliseconds(),function(){
    $(".navUl li").eq(0).addClass("active");
  });
  var indexParams = {};
  function operateFormatterDept(value, row, index) {
    return[
      '<mrp:p rId="215"><a href="javascript:void(0)" class="updateAgent" title="更新">更新&nbsp;&nbsp;</a></mrp:p>',
      '<mrp:p rId="216"><a href="javascript:void(0)" class="remove" title="删除">删除</a></mrp:p>'
    ].join("")
  }
  function operateFormatterNumber(value, row, index) {
    return index+1;
  }
  window.operateEventsDept = {
    //删除企业
    'click .remove': function (e, value, row, index) {
      var txt="您确定删除企业'"+row.compName+"'全部信息吗?";
      var option = {
        btn: parseInt("0011",2),
        onOk: function(){
          $.ajax({
            url: "/creditsupport/company/delete/"+row.regId,
            type:"post",
            dataType:"json",
            cache:"false",
            success: function(data){
              if(1 == data.code){
                //setTimeout("inquiry()",300);
                $('#tableList').bootstrapTable('refresh', {url: "/creditsupport/company/query"});
                var txt = data.message || "删除企业成功 !";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
                initParamsIndex()
              }
            }
          });
        }
      };
      window.wxc.xcConfirm(txt, "custom", option);
    },
    //更新企业
    'click .updateAgent': function (e, value, row, index) {
      var txt="您确定要更新企业'"+row.compName+"'信息吗?";
      var code={'infocreditcode':row.regId,'infoName':row.compName};
      var option = {
        btn: parseInt("0011",2),
        onOk: function(){
          $("#loadingIndex").show();//显示遮罩层
          $.ajax({
            url: "/creditsupport/company/updateAgentNew",
            type:"POST",
            data:code,
            dataType:"json",
            timeout: 180000,
            success: function (data) {
              $("#loadingIndex").hide()
              if(data.code === -1) {
                window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
                return false
              }
              window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
              $('#tableList').bootstrapTable('refresh', {
                url: "/creditsupport/company/query",
                sort:"updateTime",
                order: "desc"
              });
              initParamsIndex()
            },
            error: function (data) {
              var txt = data.message || '连接失败或服务器内部错误，请稍后再试'
              $("#loadingIndex").hide()
              checkError(data, txt);
            }
          });
        }
      };
      window.wxc.xcConfirm(txt, "custom", option);
    }
  };

  //table请求数据前调该方法获取参数
  function paginationParam(params) {
    var regId = inputs.eq(0).val();
    var compName = encodeURI(inputs.eq(1).val());
    var lpName = encodeURI(inputs.eq(2).val());
    var status = encodeURI($("#statusSel").find("option:selected").text());
    return {
      regId: regId,
      compName: compName,
      lperName: lpName,
      status: status,
      sort: params.sort,
      order: params.order,
      limit: params.limit,
      offset: params.offset,
      pageNumber: $('#listTable').bootstrapTable('getOptions').pageNumber
    };
  }

  var inputs = $(".firmInquiry");
  /* var submitTime = undefined;//提交抓取任务时间
   var updateTime = undefined;//数据最后更新时间
   var updateName = undefined;//单个提交任务（名称或者工商号）
   var updateNames = undefined;//批量提交任务列表（元素包含名称或者工商号）
   var intervalId = undefined;//轮询ID */
  /*抓取查询方法
  var crowlerInquiry = function () {
	  inputs.eq(0).val("");//清空营业执照
	  inputs.eq(1).val("");//清空企业名称
	  $('#statusSel option:first').prop('selected','true');//状态为全部
	  inputs.eq(2).val("");//清空法人姓名
    var params = {sort:"updateTime",order: "desc"};
    $.ajax({
      url: "/creditsupport/company/query",
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
	    	    if(updateName){
              if(updateName == val.compName || updateName == val.regId){
                $("#loadingIndex").hide();//关闭遮罩层
			    	    updateTime = undefined;//重置更新时间
			    	    updateName = undefined;//重置抓取任务（名称或者工商号）
			    	    clearInterval(intervalId);//终止轮询
			    	    $('#tableList').bootstrapTable('load', responseText);
              }else{
		    	      return;
              }
	    	    }else if(updateNames){
              $(updateNames).each(function(idx_1,val_1){
                if(val_1.infoName == val.compName || val_1.infocreditcode == val.regId){
                  $("#loadingIndex").hide();//关闭遮罩层
                  updateTime = undefined;//重置更新时间
                  updateNames = undefined;//重置抓取任务列表（元素包含名称或者工商号）
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
		      var txt="未查询到企业信息，企业名称可能有误.";
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    		  submitTime = undefined;
          updateName = undefined;
          updateNames = undefined;
          $("#loadingIndex").hide();//关闭遮罩层
          return false;
    	  }
      }
    });
  }; */
  /*更新企业查询
  var updateAgentInquiry = function () {
	  inputs.eq(0).val("");//清空营业执照
	  inputs.eq(1).val("");//清空企业名称
	  $('#statusSel option:first').attr('selected','true');//状态为全部
	  inputs.eq(2).val("");//清空法人姓名
    var params = {sort:"updateTime",order: "desc"};
    $.ajax({
      url: "/creditsupport/company/query",
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
	    	    if(updateName){
              if(updateName == val.compName || updateName == val.regId){
                $("#loadingIndex").hide();//关闭遮罩层
			    	    updateTime = undefined;//重置更新时间
			    	    updateName = undefined;//重置抓取任务（名称或者工商号）
			    	    clearInterval(intervalId);//终止轮询
			    	    $('#tableList').bootstrapTable('load', responseText);
			    	    var txt="更新企业成功 !";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
              }else{
		    	      return false;
              }
            }
	    	  });
    	  }
    	  //抓取任务超过30秒则提示是否继续等待
    	  if((new Date().getTime()/1000 - submitTime) > 30){
		      clearInterval(intervalId);//终止轮询
    		  var txt="企业未更新，是否继续等待？";
    		  var option = {
            btn: parseInt("0011",2),
            onOk: function(){
              submitTime = new Date().getTime()/1000;
              intervalId = setInterval("updateAgentInquiry()", 1500);
            },
            onCancel:function(){
              submitTime = undefined;
              updateName = undefined;
              updateNames = undefined;
              $("#loadingIndex").hide();//关闭遮罩层
            }
          };
          window.wxc.xcConfirm(txt, "custom", option);
    	  }
      }
    });
  }; */
  /*查询方法
 var inquiry = function () {
	var regId = inputs.eq(0).val();
    var compName = inputs.eq(1).val();
    var lperName = inputs.eq(2).val();
    var status = $("#statusSel").find("option:selected").text();
    var params = {regId: regId,compName: compName,lperName: lperName, status: status,sort:"updateTime",order: "desc"};
    $.ajax({
      url: "/creditsupport/company/query",
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
  }; */
  //搜索
  $("#searchEnterpriseBtn").on("click", function () {
	  var regId = inputs.eq(0).val();
	  var compName = encodeURI(inputs.eq(1).val());
	  var lperName = encodeURI(inputs.eq(2).val());
	  var status = encodeURI($("#statusSel").find("option:selected").text());
	  $('#tableList').bootstrapTable('refresh', {
		  url: "/creditsupport/company/query",
		  regId: regId,
		  compName: compName,
		  lperName: lperName,
		  status: status,
		  sort:"updateTime",
		  order: "desc"
	  });
    initParamsIndex()
  });
  //  重置
  $("#resetEnterpriseBtn").on("click", function () {
    inputs.eq(0).val("");
    inputs.eq(1).val("");
    inputs.eq(2).val("");
    $('#statusSel option:first').prop('selected','true');//状态为全部
    $('#tableList').bootstrapTable('refresh',{url: "/creditsupport/company/query"});
    initParamsIndex()
  });
  var checkAllRow = {}
  //   返回
  $("#content").on("click", ".returnIndex", function (e) {
	  e.preventDefault();
    returnIndex()
  })
  function returnIndex() {
    $("#content1").css("display", "block");
    $("#content").css("display", "none").html("");
    if (!$.isEmptyObject(checkAllRow)) {
      var regId = checkAllRow.row.regId;
      $.ajax({
        url : "/creditsupport/company/query/"+regId,
        dataType : "json",
        cache : "false",
        success : function(res) {
          if(res.code === 1) {
            var $table = $("#tableList")
            var index = checkAllRow.index
            var row = res.data
            checkAllRow.row = row
            indexParams.algorithmType = row.algorCode
            $table.bootstrapTable('updateRow', {index: index, row: row})
            $table.find("tr").removeClass('active');
            $table.find('tr').eq(Number(index)+1).addClass('active')
          } else {
            window.wxc.xcConfirm(res.message || '查询失败！', window.wxc.xcConfirm.typeEnum.info);
          }
        }
      });
    }
  }
  //  基本信息
  $("#basicXX").on("click", function () {
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
  $("#scoreBG").on("click", function () {
    if (indexParams.id) {
      $("#content1").css("display", "none");
      $("#content").css("display", "block");
      $("#content").load('./score-report.jsp', {regId: indexParams.id, compName: indexParams.compName, algorithmType: indexParams.algorithmType}, function () {
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
      $("#content").load("./credit-report.jsp", indexParams, function () {
      })
    } else {
      var txt="您未选择任何一条信息，不可进行此操作 !";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    }
  });
  /*宏观画像
  function trimStr(str){return str.replace(/(^\s*)|(\s*$)/g,"");}
 $("#label_submit").on("click", function () {
	var compName = indexParams.compName;
	if (compName) {
		$.ajax({
			url: "/creditsupport/company/agentLabelIsUsable",
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
 }); */

  //  判断选择的tr的id
  $("#tableList").bootstrapTable().on("click-row.bs.table", function (e, row, $element) {
    var id = row.regId;
    indexParams = {id: id, compName: row.compName, algorithmType: row.algorCode};
    checkAllRow.row = row;
    checkAllRow.index = $element[0].sectionRowIndex
    $("#tableList").find("tr").removeClass('active');
    $element.addClass("active");
  });

  //  捕捉当前翻页事件page-change.bs.table
  $("#tableList").bootstrapTable().on('page-change.bs.table', function(number, size) {
    initParamsIndex()
  })

  //   初始化封装的参数
  function initParamsIndex() {
    indexParams = {}
    checkAllRow = {}
  }
  //新增按钮
  function toaddAgentModal(){
    $("#addScoreLevelTitle").html("新增企业");
    $("#submit_scoreLevel_form").html("提交");
    $('#comp_name').val("");
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
  function submits(){
    var param = {};
    param.infoCreditcode = $("#org_code").val().trim();
    //  企业名称
    param.infoName = $("#comp_name").val().trim();
    //校验不通过
    if(!validations(param)){
      return;
    }
    var code={'infocreditcode':param.infoCreditcode,'infoName':param.infoName};
    $("#AgentModal").modal("hide")
    $("#loadingIndex").show();//显示遮罩层
    $.ajax({
      type: "POST",
      url: "/creditsupport/company/updateAgentNew",
      data: code,
      dataType: 'json',
      timeout:180000,//超时时间设置为3min，正常情况1min可以返回结果
      success: function (data) {
        $("#loadingIndex").hide()
        //-2代表整个流程有非业务异常抛出，不必重新刷新列表
        if(data.code === -2) {
          window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
          return false;
        }
        if(data.code === -9) {
          window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
          return false;
        }
        window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
        inputs.eq(0).val("");
        inputs.eq(1).val("");
        inputs.eq(2).val("");
        $('#statusSel option:first').prop('selected','true');//状态为全部
        $('#tableList').bootstrapTable('refresh',{url: "/creditsupport/company/query"});
        initParamsIndex()
      },
      error: function(data) {
        $("#loadingIndex").hide()
        var txt = data.message || '连接失败或服务器内部错误，请稍后再试'
        checkError(data, txt)
      }
    })
//  $.ajax({
//    type: "POST",
//    url: "/creditsupport/company/addAgent",
//    data: JSON.stringify(code),
//    dataType: "json",
//    contentType:"application/json",//提交数据类型
//    success: function (data) {
//      if (data != null ) {
//        //$("#AgentModal").modal("hide");//关闭弹窗表单
//        submitTime = new Date().getTime()/1000;//提交抓取任务时间
//        intervalId = setInterval("crowlerInquiry()",1500);//5秒刷一次
//        updateName = data.infoCreditcode ? param.infoCreditcode : param.infoName;//记录抓取关键字
//      }else {
//        var txt="提交任务失败！";
//        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
//      }
//    }
//  });
  }
/* var submitTime = undefined;//提交抓取任务时间
  var updateTime = undefined;//数据最后更新时间
  var updateName = undefined;//单个提交任务（名称或者工商号）
  var updateNames = undefined;//批量提交任务列表（元素包含名称或者工商号）
  var intervalId = undefined;//轮询ID
*/

/*  选中当前条的id
  var getSelect = {};
  function submitMany(){
    if(!getSelect.id){
		var txt="请选择一条！";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    }else{
		var code = {groupId:getSelect.id,groupName:getSelect.groupName};
		  $("#loadingIndex").show();
		  $.ajax({
        type: "POST",
        url: "/creditsupport/company/submitGroupId",
        data: code,
        dataType: "json",
        success: function (data) {
          if (data == 1 ) {
            $("#AgentModal").modal("hide");//关闭弹窗表单
            intervalId = setInterval("crowlerInquiry()",1500);//5秒刷一次
            submitTime = new Date().getTime()/1000;//记录提交任务时间
            //将本组的企业存到updateNames，用于比对抓取结果
            $.ajax({
              type: "GET",
              url: "/creditsupport/company/findAgent",
              data: {groupId: code.groupId},
              dataType:"json",
              contentType:"application/json",//提交数据类型
              success: function (data) {
                if(data && data.rows.length > 0){
                  updateNames = data.rows;//记录抓取关键字
                }else{
                  updateNames = undefined;
                }
              }
            })
          }else {
            var txt="提交任务失败！";
            window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
          }
        }
      });
		}
  }
  var single3 = '';
  var single2 = '';

  $(function(){
	  single1 = /* '<div class="modalInput">'
	     +'<div>'
	     +'<label for="levelScoreMin_manage">工商注册号：</label>'
	     +'</div>'
	     +'<div>'
	     +'<input class="form-control"  type="text" id="org_code" name="levelScoreMin"  placeholder="请输入工商注册号"/>'
	     +'</div>'
	     +'</div>'
	     '<div class="modalInput">'
	     +'<input class="form-control"  type="hidden" id="org_code" name="levelScoreMin"  placeholder="请输入工商注册号"/>'
	     +'</div>'
	     +'<div class="modalInput">'
	     +'<div>'
	     +'<label for="levelName_manage">企业名称：</label>'
	     +'</div>'
	     +'<div>'
	     +'<input class="form-control"  type="text" id="comp_name" name="levelName"  placeholder="请输入完整的企业名称"/>'
	     +'</div>'
	     +'</div>'
	     +'<div class="modal-footer">'
	     +'<button id="submit_scoreLevel_form" type="button" class="btn" onclick="submits()">提交</button>'
	     +'<button class="btn" data-dismiss="modal">取消</button>'
	     +'</div>';
	 single2 = '<div class="changeSingle3">'
         +'<button class="btn ok marginTop" onclick="single3Add()">新增分组</button>'
         +'<div  class="tableslists"  >'
         +'<div>'
         +'<table id="modalTable" class="table table-striped">'
         +'</table>'
         +'</div >'
         +'<div class="modal-footer">'
         +'<button id="submit_scoreLevel_form" type="button" class="btn" onclick="submitMany()">提交</button>'
         +'<div>'
         +'</div>'
         +'</div>';
	single3 = '<div class="marginTopSmall">'
         +
         '<button class="btn" data-toggle="modal" data-target="" onclick="ontableAddModal()">新增</button>'
         +
         '<div class="marginTop"><label>分组名称：</label><input class="form-control" id="agentnames"><input class="form-control" type="hidden" id="agentnamesid"></div>'
         +
         '<div><table id="tableAdd" class="table table-striped"></table></div>'
         +
         '<div class="modal-footer">'
         +
         '</div>'
         +
         '</div>';
    //点击批量提交
    $(".single2").click(function(){
        setTable();
        $(".single1").removeClass("active")
        $(this).addClass("active");
    });
    
    //点击单条(刚好与批量相反)
    $(".single1").click(function(){
    	$(".isAsingle1").html(single1);
    	$(".single3").hide();
    	$(".single2").removeClass("active");
    	$(".single1").addClass("active");
    });
  });
  //点击新增
  function single3Add(){
	$(".changeSingle3").html(single3);
	tableAdd();
  }

/*function tableAdd() {
  $("#tableAdd").bootstrapTable({
	  columns: [{
      field: 'index',
      title: '序号',
      width: "15%",
      align: "left",
      formatter: function (value, row, index) {
        return index+1;
      }
    },{
      field: 'infoCreditcode',
      title: '工商注册号',
      width: "25%",
      align: "left"
    }, {
      field: 'infoName',
      title: '企业名称',
      width: "35%",
      align: "left"
    },{
      field: 'operation',
      title: '操作',
      width: '15%',
      align: "right",
      formatter: function(value, row, index){
        return  [
          '<a href="javascript:void(0)"  class="tableAddEdit" title="编辑">编辑</a>&nbsp',
          '<a href="javascript:void(0)" class="tableAddRemove" title="删除">删除</a>'
        ].join('');
      },
      events: 'tabelAddEvents'
    }],
    height: 150,
    cache: false
  });
}

window.tabelAddEvents = {
  "click .tableAddEdit": function (e, value, row, index) {
    var id = row.id;
	$("#AddtableModaltitle").html("编辑企业");
	$("#tableAddModal").modal("show");
	$("#infoId").val(row.infoId);
	$("#infoIndex").val(index);
	$("#infoCreditcode").val(row.infoCreditcode);
	$("#infoName").val(row.infoName);
  },
  "click .tableAddRemove": function (e, value, row, index) {
	 
    var id = row.infoId;
    var indexs = [];
    $($("#tableAdd").bootstrapTable('getOptions').data).each(function (index) {
    	indexs.push(index);
    })
  
    var txt="您确定删除吗?";
    var option = {
        btn: parseInt("0011",2),
        onOk: function(){
        	$.ajax({
    	        type: "post",                                       
    	        url: "/creditsupport/company/deleteAgent",
    	        data:JSON.stringify({groupId:$("#agentnamesid").val(),agentinfos:[{infoId:row.infoId}]}),
    	        dataType:"json",
    	        success: function (data) {
    	            if(data==1){
    	            	var txt="删除成功!";
    	                 window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    	                 var id = $("#agentnamesid").val();
    		                $.ajax({
    		         	        type: "GET",                                       
    		         	        url: "/creditsupport/company/findAgent",
    		         	        data: {groupId: id},
    		         	        dataType:"json",
    		         	        success: function (data) {
    		         	 	        	 $("#tableAdd").bootstrapTable('load', data.rows);
    		         	 	        	$("#agentnamesid").val(id);
    		         	        }
    		         	    })
    	            }else{
    	            	 var txt="删除失败!";
    	                 window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    	            }
    	        }
    	        
    	    });	
        	
        }
      };
      window.wxc.xcConfirm(txt, "custom", option);
  }
} */
/*function setTable(){
  $(".isAsingle1").html(single2);
  $("#modalTable").bootstrapTable({
    columns: [ {
      field: 'number',
      title: '序号',
      width: "35%",
      align: "left",
      formatter: function (value, row, index) {
        return index+1;
      }
    },{
      field: 'groupName',
      title: '分组名称',
      width: "45%",
      align: "left"
    },{
      field: 'operation',
      title: '操作',
      width: '20%',
      align: "right",
      formatter: function(value, row, index){
        return [
          '<a href="javascript:void(0)"  class="modalEdit" title="编辑">编辑</a>&nbsp',
          '<a href="javascript:void(0)" class="modalRemove" title="删除">删除</a>'
        ].join('');
      },
      events: 'modalEventsDept'
    }],
    height: 300,
    pagination: false,
    sidePagination: 'server',
    pageNumber: 1,
    pageSize: 10,
    cache: false,
    pageList: [5, 10, 20],
    url: '/creditsupport/company/findGroup'
  });
  $("#modalTable").bootstrapTable().on("click-row.bs.table", function (e, row, $element) {
    var id = row.groupId;
    var groupName = row.groupName;
    getSelect = {id: id,groupName: groupName};
    $("#modalTable").find("tr").removeClass('active');
    $element.addClass("active");
  })
}
$(function(){
  addtr();
  del();
});

//计算批量新增的序号
function addtr(){
  $(".addtr").each(function(i){
    $(".addtr").eq(i).html(i+1);
  });
}*/
/*删除一行
function del(){
  $("#isAsingle1").on("click", ".dels", function () {
    $(this).parent().remove();
    addtr();
  })
} */
/*var str =
    '<div class="marginTopSmall rmeoveS">'
    +
      '<span class="titleNumber addtr"></span>'
    +
     '<input class="infoId" type="hidden"/>'
    +
     '<input class="form-control infoCreditcode addInput" type="text"/>'
    +
     '<input class="form-control infoName addInput" type="text"/>'
    +
     '<a class="operating dels" href="javascript:void(0)">删除</a>'
    +
     '</div>'; */
/*新增一行
 function addtd(){
	 
     $("#table100").append(str);
     addtr();
     del();
 }
  window.modalEventsDept = {
    'click .modalEdit': function (e, value, row, index) {
      var id = row.groupId;
     	$(".isAsingle1").html(single3);
     	$("#agentnames").val(row.groupName);
     	$("#agentnamesid").val(row.groupId);
     	tableAdd();
      $.ajax({
	        type: "GET",                                       
	        url: "/creditsupport/company/findAgent",
	        data: {groupId: id},
	        dataType:"json",
	        success: function (data) {
	 	        	 $("#tableAdd").bootstrapTable('load', data.rows);
	        }
	    })
      
    },
    "click .modalRemove": function (e, value, row, index) {
      var id = row.groupId;
      var txt="您确定删除吗?";
     
      var option = {
        btn: parseInt("0011",2),
        onOk: function(){
        	$.ajax({
    	        type: "post",                                       
    	        url: "/creditsupport/company/deleteGroup",
    	        data:JSON.stringify({groupId:row.groupId,groupName:row.groupName}),
    	        dataType:"json",
    	        contentType:"application/json",//提交数据类型
    	        success: function (data) {
    	            if(data==1){
    	            	var txt="删除成功!";
    	                 window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    	            	setTable();
    	            }else{
    	            	 var txt="删除失败!";
    	                 window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    	            }
    	        }
    	        
    	    });	
        }
      };
      window.wxc.xcConfirm(txt, "custom", option);
    }
  } */
/*function onblu(val){
	 $.ajax({
	        type: "GET",                                       
	        url: "/creditsupport/company/isAgent",
	        data: {compname:val},
	        dataType:"json",
	        success: function (data) {
	            if (data.status==1) {
	                var txt="分组名称已存在！";
	                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	                $("#agentnames").val("");
	            } 
	            	 
	        }
	    })
} 

function cancelok(){
	setTable();
} */
/*function addOneAgentInfo(){
   var data = {};
   data.infoCreditcode= $("#infoCreditcode").val().trim();
   data.infoName = $("#infoName").val().trim();

   if(!validations(data)){
   return;
   }


   var infoId = $("#infoId").val().trim();
   var agentinfos = {infocreditcode:data.infoCreditcode,infoName:data.infoName,infoId:infoId?infoId:null};
   $.ajax({
   type: "post",
   url: "/creditsupport/company/EditAgent",
   data:JSON.stringify({groupId:$("#agentnamesid").val()?$("#agentnamesid").val():null,groupName:$("#agentnames").val(),agentinfos:[agentinfos]}),
   dataType:"json",
   contentType:"application/json",//提交数据类型
   success: function (data) {
   if(data.status==1){
   var txt="编辑成功!";
   window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);

   var id = data.id;
   $("#agentnamesid").val(id);
   $.ajax({
   type: "GET",
   url: "/creditsupport/company/findAgent",
   data: {groupId: id},
   dataType:"json",
   contentType:"application/json",//提交数据类型
   success: function (data) {
   $("#tableAdd").bootstrapTable('load', data.rows);
   }
   })

   }else if(data.status==3){
   var txt="分组名称已存在！";
   window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
   $("#agentnames").val("");
   }else{
   var txt="编辑失败!";
   window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);

   }
   }

   });
   $("#tableAddModal").modal("hide");
   $("#infoCreditcode").val("");
   $("#infoName").val("");
   }


   function ontableAddModal(){
   if($("#agentnames").val()==""){
   var txt="分组名称不能为空！";
   window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
   return false;
   } else {

   $("#infoId").val("");
   $("#infoIndex").val("");
   $("#infoCreditcode").val("");
   $("#infoName").val("");
   $("#AddtableModaltitle").html("新增企业");
   $("#tableAddModal").modal("show");
   }
   }
   //   控制输入框
   $("#AgentModal").on("change", ".form-control" , function (){
   var val = $(this).val();
   if (val) {
   $("#AgentModal").find(".form-control").attr("disabled", true);
   $(this).attr("disabled", false);
   } else {
   $("#AgentModal").find(".form-control").attr("disabled", false);
   }
   }) */
//验证新增同时存在企业名称与工商注册号
function validations(data){
  	var validate = true;
	if(!data || !(data.infoCreditcode || data.infoName)){
	    //var txt="必须填一个!";
	    var txt="请输入企业名称或工商注册号!"
	    window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	    return false;
	}else{
		if(data.infoCreditcode){
			validate = checkData(validate, data.infoCreditcode, "工商注册号", checkNum);
			validate = checkData(validate, data.infoCreditcode, "工商注册号", checkRegId);
		}
		if(data.infoName){
	    	validate = checkData(validate, data.infoName, "企业名称", checkLength, 50);
	    	validate = checkData(validate, data.infoName, "企业名称", checkCompName);
		}
	    if(!validate){
	      return false;
	    }
	}
	return true;
}

$(".modal.fade").modal({show:false,keyboard:false});

</script>
</body>
</html>