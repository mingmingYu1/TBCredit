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
          <a class="pdf_btn" href="/creditsupport/js/pdfjs/generic/web/viewer.html?file=/creditsupport/indicator-score/createTwoInfo" id="viewScore2" target="_blank" title="预览/打印">
            <span class="icon-eye-open" ></span>
          </a>
          <a target="_blank" href="/creditsupport/indicator-score/createTwoInfo" id="downloadScore2" title="下载PDF" style="padding-left: 5px;">
            <span class="icon-file-alt"></span>
          </a>
        </div>
        <div id="scoreReportBtn1" class="text-right titleBtns">
          <mrp:p rId="2131">
            <a href="/creditsupport/company-figure/queryCompScore" class="btn load active marginTopSmall">企业画像</a>
          </mrp:p>
          <mrp:p rId="2132">
            <a href="./index-report.jsp" class="btn load active marginTopSmall">指标评分</a>  <!-- ./index-report.jsp -->
          </mrp:p>
          <mrp:p rId="2133">
            <a href="javascript:void(0)" class="btn marginTopSmall">行业属性分类</a>
          </mrp:p>
        </div>
      </div>
      <div class="col-xs-12 text-center marginTopSmall" id= "lastTitle">
        <div>
          <span class="dengFen">
            <span>
              <span class="icon-inbox"></span> <span>总权重</span>
            </span>
            <span class="zhi" id="allWeight">
            </span>
          </span>
          <span class="dengFen">
            <span>
              <span class="icon-credit-card"></span> <span>总得分</span>
            </span>
            <span class="zhi" id="scoreAll"></span>
          </span>
        </div>
      </div>
      <div id="scoreReportShow">
        <div>
          <div class="row tables">
            <div class="titleDiv">
              <span class="reportTitle">通用类指标</span>
            </div>
            <div style="padding: 0 15px;">
              <table id="indexReportAttrTable1" class="table table-striped"></table>
            </div>
          </div>
        </div>
        <div class="marginTopSmall">
          <div class="row tables">
            <div class="titleDiv">
              <span class="reportTitle">行业类指标</span>
            </div>
            <div style="padding: 0 15px;">
              <table id="indexReportAttrTable2" class="table table-striped"></table>
            </div>
          </div>
        </div>  
      </div>
      <div class="marginTop">
         <span style="color:red;font-weight: bold;">备注</span>
         <ol class="marginTopSmall" id="indexReportAttrOl" style="margin-left: -15px;"></ol>
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

  $("#downloadScore2").on("click", function(e){
    e.preventDefault()
    var _self = this
    $.ajax({
      url: "/creditsupport/login/checkSession?_time"+new Date().getTime(),
      type:"post",
      async: false,
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
        } else {
          var p = "/" + regId + "/" + algorithmType;
          var scoreHref2 = $(_self).attr('href');
          var url = scoreHref2 + p;
          newWin(url, 'newScoreHref2')
        }
      }
    });
  });
  $("#viewScore2").on("click", function(e){
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
          var viewHref2 = $(_self).attr('href');
          var url = viewHref2 + p;
          newWin(url, 'newViewHref2')
        }
      }
    });
  });
  var score = [];
  var weight = -1;
  function setTable1(o, url, type) {
    $(o).bootstrapTable({
      columns: [{
        field: 'id',
        title: '主键',
        visible: false
      },{
        field: 'secondLevelUrl',
        title: 'URL',
        visible: false
      },{
        field: 'topLevel',
        title: '指标大类',
        align: "left",
        width: "15%",
        class: "tableColor reportBig"
      }, {
        field: 'firstLevel',
        title: '指标小类',
        align: "left",
        width: "15%",
        class: "tableColor reportsmall"
      }, {
        field: 'secondLevelName',
        title: '指标名称',
        align: "left",
        width: "30%"
      }, {
        field: 'secondLevelWeight',
        title: '权重',
        align: "left",
        width: "8%",
        formatter: function (value, row, index) {
          if (index === 1) {
            if(weight >= 0) {
              value = 100 - weight;
              weight = -1;
            } else {
              value = (Math.round(value * 10000)/100).toFixed(0);
              weight = value;
            }
            return value + "%";
          }
          return value;
        }
      }, {
        field: 'secondLevelScore',
        title: '得分',
        align: "left",
        width: "12%",
        formatter: function (value, row, index) {
          if (index === 1) {
            score.push(value)
          }
          return value;
        }
      }, {
        title: '统计展示',
        align: "right",
        width: "12%",
        formatter: function(value,row,index){
          if(row.secondLevelUrl) {
            var url = row.secondLevelUrl;
            var id
            if(row.secondLevelName === "近6个月平均出票增长率") {
              return '<mrp:p rId="21333"><a href='+url+' class="indexReportLook" title="查看分析详情">查看分析详情</a></mrp:p>'
            } else if (row.secondLevelName === "近6个月平均退废票率") {
              return '<mrp:p rId="21334"><a href='+url+' class="indexReportLook" title="查看分析详情">查看分析详情</a></mrp:p>'
            } else if(row.secondLevelName === "毛利率") {
              return '<mrp:p rId="21335"><a href='+url+' class="indexReportLook" title="查看分析详情">查看分析详情</a></mrp:p>'
            }
            
          } else {
            return ""
          }
        },
        events: 'tablesEvents'
      }],
      cache: false,
      pagination: false,
      sidePagination: 'server',
      pageNumber: 1,
      pageSize: 46,
      pageList: [5, 10, 20],
      queryParams: function (params) {
        return {
          regId: regId,
          compName: compName,
          algorithmType: algorithmType,
          type: type
        }
      },
      url: url
    });
  }
</script>
<script src="${pageContext.request.contextPath}/js/indexReportAttr.js"></script>