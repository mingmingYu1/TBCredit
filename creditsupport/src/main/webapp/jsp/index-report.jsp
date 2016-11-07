<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="col-xs-12 marginLeft marginTop">
  <p class="sumTitle"><a href="company-manage.jsp" class="returnIndex">企业管理</a> > 评分报告</p>
</div>
<div class="col-xs-12 marginLeft">
  <div class="basicContainer">
    <div>
      <div class="overflow">
        <p class="link marginTopSmall pull-left">
          <a href="./company-manage.jsp" class="returnIndex">< 返回企业列表</a>
        </p>
        <div class="pull-right marginTopSmall">
          <label>算法类型：</label>
          <select class="form-control" id="algorithmType"></select>
        </div>
      </div>
      <div class="text-center scoreReportTitle" id="score-title" style="margin-top: -15px;"><%=request.getParameter("compName")%>评分报告</div>
      <div class="overflow" style="border-bottom: 1px solid #e3ebf3;margin-top: -5px;">
        <div class="pull-left">
          <a class="pdf_btn" href='/creditsupport/js/pdfjs/generic/web/viewer.html?file=/creditsupport/indicator-score/createOneInfo' id="viewScore1" title="预览/打印">
            <span class="icon-eye-open" ></span>
          </a>
          <a target="_blank" href="/creditsupport/indicator-score/createOneInfo" id="downloadScore1" style="padding-left: 5px;" title="下载PDF">
            <span class="icon-file-alt"></span>
          </a>
        </div>
        <div id="scoreReportBtn1" class="text-right titleBtns pull-right">
          <mrp:p rId="2131">
            <a href="/creditsupport/company-figure/queryCompScore" class="btn marginTopSmall load active">企业画像</a>
          </mrp:p>
          <mrp:p rId="2132">
            <a href="javascript:void(0)" class="btn marginTopSmall">指标评分</a>  <!-- ./index-report.jsp -->
          </mrp:p>
          <mrp:p rId="2133">
            <a href="./index-report-attr.jsp" class="btn marginTopSmall load active">行业属性分类</a>
          </mrp:p>
        </div>
      </div>
      <div id="scoreReportShow">
        <div>
          <div class="row tables">
            <div style="padding: 0 15px;">
              <table id="indexReportTable"  data-cache="false" data-pagination="false" data-side-pagination="server"
                     class="table table-striped" data-ajax = "tabelAjax">
                <thead>
                <tr>
                  <th  data-field="id" data-visible= false>主键</th>
                  <th data-field="secondLevelUrl" data-visible= false>URL</th>
                  <th data-class="tableColor reportBig" data-field="topLevel" data-width='15%' data-align="left" >指标大类</th>
                  <th data-class="tableColor reportsmall" data-field="firstLevel" data-width='15%' data-align="left">指标小类</th>
                  <th data-field="secondLevelName" data-width='30%' data-align="left">指标名称</th>
                  <th data-field="indAttr" data-width='10%' data-class="tdBgColor	" data-align="left">行业属性</th>
                  <th data-field="secondLevelWeight" data-width='8%' data-align="left">权重</th>
                  <th data-field="secondLevelScore" data-width='12%' data-align="left">得分</th>
                  <th data-field="6" data-width='10%' data-align="right" data-formatter="indexReportFormatter" data-events="indexReportEvents">统计展示</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
        </div>
        <div class="marginTop">
          <span style="color:red;font-weight: bold;">备注</span>
          <ol class="marginTopSmall" id="indexReportOl" style="margin-left: -15px;"></ol>
          </div>
        </div>
      </div>
    </div>
  </div>
<a href="#top" class="btn top" title="回到顶部">
  <span class="icon-angle-up"></span>
</a>
<a href="#bottom" class="btn bottom" title="回到底部">
  <span class="icon-angle-down"></span>
</a>

<script>
  var compName = '<%=request.getParameter("compName")%>';
  var regId = '<%=request.getParameter("regId")%>';
  var algorithmType = '<%=request.getParameter("algorithmType")%>';
  var params = {regId: regId,compName: compName, algorithmType: algorithmType};
  var isIndexReport = "indexReport"; //   图形返回的的标识

  //算法类型下拉列表
  $.ajax({
    url : "/creditsupport/scoreModel/queryAlgorithmType",
    type : "post",
    dataType : "json",
    cache : "false",
    success : function(responseText) {
      $("#algorithmType").html('');
      var result = responseText;
      if (result.length > 0) {
        for (var i = 0; i < result.length; i++) {
          var value = result[i].value;
          var name = result[i].name;
          if(value == algorithmType){
            $("#algorithmType").append("<option selected value='"+value+"'>" + name+ "</option>");
          } else {
            $("#algorithmType").append("<option value='"+value+"'>" + name+ "</option>");
          }
        }
      }
    }
  });

  $("#algorithmType").on('change', function () {
	  var old = algorithmType;
	    algorithmType = $("#algorithmType").val();
	    //判断是否已生成评分报告，如果未生成，给出提示，否则，保存企业算法关联关系
	    $.ajax({
	        url : "/creditsupport/company-figure/checkAgentAlgor",
	        type : "post",
	        data: {
	            regId: params.regId,
	            algorithmType: algorithmType
	        },
	        dataType : "json",
	        cache : "false",
	        success : function(responseText) {
	          var result = responseText;
	          //选择的算法尚未生成评分报告，是否确定选择此算法
	          if (result.code == 1) {
	              var option = {
	                closeBtn:false,
	                btn: parseInt("0011",2),
	                onOk: function(){
	                    saveAgentAlgor(params.regId, algorithmType);
	                    params = {regId: regId,compName: regId, algorithmType: algorithmType};
	                    tabelAjax();
	                },
	                onCancel:function(){
	                    $("#algorithmType").val(old);
	                    algorithmType = old;
	                }
	              }
	              window.wxc.xcConfirm(result.message, "custom", option);
	            
	          } else if (result.code == 2){
	            //保存关联关系  
	            saveAgentAlgor(params.regId, algorithmType)
	            //有算法时显示新的算法结果
	            params = {regId: regId,compName: regId, algorithmType: algorithmType};
	            tabelAjax();
	          } else {
	            //提示异常信息
	            window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.info);
	          }
	        }
	      });
  });
  
//保存新的算法企业关联关系
  function saveAgentAlgor(regId, algorithmType){
    $.ajax({
      url : "/creditsupport/company-figure/saveAgentAlgor",
      type : "post",
        data: {
            regId: regId,
            algorithmType: algorithmType
        },
        dataType : "json",
        cache : "false",
        success : function(responseText) {
            var result = responseText;
            if (result.code == 0) {
                window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.info);     
            }
        }
    });
  }


  $("#downloadScore1").on("click", function(e){
    e.preventDefault()
    var _self = this
    $.ajax({
      url: "/creditsupport/login/checkSession?_time"+new Date().getTime(),
      type:"post",
      dataType:"json",
      async: false,
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
        } else {
          var p = "/" + regId + "/" + algorithmType;
          var scoreHref = $(_self).attr('href');
          var url = scoreHref + p
          newWin(url, 'newScoreHref')
        }
      }
    });
  });
  $("#viewScore1").on("click", function(e){
    e.preventDefault()
    var _self = this
    $.ajax({
      url: "/creditsupport/login/checkSession?_time"+new Date().getTime(),
      type:"post",
      dataType:"json",
      async: false,
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
        } else {
          var p = "/" + regId + "/" + algorithmType;
          var viewHref = $(_self).attr('href');
          var url = viewHref + p
          newWin(url, 'newViewScore1')
        }
      }
    });
  });
  var titleBtn = $("#scoreReportBtn1").find(".btn.load");
  titleBtn.on("click", function (e) {
    e.preventDefault();
    var href = $(this).attr("href");
    $("#score-report").load(href,{regId: regId, compName: compName, algorithmType: algorithmType});
  });


  function indexReportFormatter(value, row, index) {
    if(row.secondLevelUrl){
      var url = row.secondLevelUrl;
      if(row.secondLevelName === "近6个月平均出票增长率") {
        return '<mrp:p rId="21323"><a href='+url+' class="indexReportLook" title="查看分析详情">查看分析详情</a></mrp:p>'
      } else if (row.secondLevelName === "近6个月平均退废票率") {
        return '<mrp:p rId="21324"><a href='+url+' class="indexReportLook" title="查看分析详情">查看分析详情</a></mrp:p>'
      } else if(row.secondLevelName === "毛利率") {
    	return '<mrp:p rId="21325"><a href='+url+' class="indexReportLook" title="查看分析详情">查看分析详情</a></mrp:p>'
      }
    } else {
      return ""
    }
  }
  window.indexReportEvents = {
    'click .indexReportLook': function (e, value, row, index) {
      e.preventDefault();
      var href = $(this).attr("href");
      $("#score-report").load(href, {id: regId, compName: compName, algorithmType: algorithmType, isIndexReport: isIndexReport});
    }
  };

  //   分数处理
//  function scoreFormatter(value, row, index) {
//    return formatDecimal(value)
//  }

  var tableData = null;
  var isTrue = true;
  var cellsParmas = [];
  var $table = $('#indexReportTable');
  function tabelAjax() {
    $table.bootstrapTable("showLoading");
    $.ajax({
      url: '/creditsupport/indicator-score/queryAllInfo',
      data: params,
      type: "POST",
      dataType: 'json',
      success: function (data1) {
        $table.bootstrapTable("hideLoading");
        if(data1 !== null && data1.code !== 0){
          tableData = data1;
          $table.bootstrapTable('load', data1);
        } else {
          $table.bootstrapTable('load', {total:0, rows:[]});
        }
      }
    });
  }
  $table.bootstrapTable().on('post-body.bs.table',function(){
    $(".tdBgColor").each(function () {
      if($(this).text() === "行业类指标") {
        $(this).parent().css("backgroundColor", "#DDF9FD");
      }
    })
    if(tableData !== null) {
      var checkTopLevel = [];
      var checkFirstLevel = [];
      var rows = tableData.rows;
      $(rows).each(function (index, dom){
        if (dom.topLevelcount > 1) {
          if (checkTopLevel.length > 0) {
            var obj = {index: index, field: "topLevel", rowspan: dom.topLevelcount};
            var topLevelCode = dom.topLevel;
            for (var i = 0; i < checkTopLevel.length; i++){
              if (checkTopLevel[i] === topLevelCode) {
                isTrue = false;
                break;
              }else {
                isTrue = true;
              }
            }
            if(isTrue) {
              $table.bootstrapTable('mergeCells',obj);
              cellsParmas.push(obj);
              checkTopLevel.push(topLevelCode);
            }
          } else {
            cellsParmas.push({index: index, field: "topLevel", rowspan: dom.topLevelcount});
            $table.bootstrapTable('mergeCells',{index: index, field: "topLevel", rowspan: dom.topLevelcount});
            checkTopLevel.push(dom.topLevel);
          }
        }
        if(dom.firstLevelcount > 1) {
          if (checkFirstLevel.length > 0) {
            var obj1 = {index: index, field: "firstLevel", rowspan: dom.firstLevelcount};
            var firstLevelCode = dom.firstLevel;
            for (var j = 0; j < checkFirstLevel.length; j++){
              if (checkFirstLevel[j] === firstLevelCode) {
                isTrue = false;
                break;
              }else {
                isTrue = true;
              }
            }
            if(isTrue) {
              $table.bootstrapTable('mergeCells',obj1);
              cellsParmas.push(obj1);
              checkFirstLevel.push(firstLevelCode);
            }
          } else {
            cellsParmas.push({index: index, field: "firstLevel", rowspan: dom.firstLevelcount});
            $table.bootstrapTable('mergeCells',{index: index, field: "firstLevel", rowspan: dom.firstLevelcount});
            checkFirstLevel.push(dom.firstLevel);
          }
        }
      });
    }
  });
  //   加载备注说明
  $.ajax({
    url: "/creditsupport/scoreLevel/queryScoeLevel",
    dataType: "json",
    success: function (data) {
      if(data !== null && data.rows.length > 0) {
        var rows = data.rows;
        var ol = $("#indexReportOl")
        $(rows).each(function (index, dom) {
          ol.append("<li>"+dom+"</li>")
        })
      }
    }
  })
</script>