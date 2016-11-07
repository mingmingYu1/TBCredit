<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<div class="row" id="creditReport">
  <div class="col-xs-12 marginLeft marginTop">
    <p class="sumTitle"><a href="person-manage.jsp" class="returnIndex">个人管理</a> > 征信报告列表</p>
  </div>
  <div class="col-xs-12 marginLeft">
    <p class="link">
      <a href="./person-manage.jsp" class="returnIndex">&lt; 返回个人列表</a>
    </p>
    <div class="marginTop">
      <label>报告编号：</label>
      <input id="creditReportSelect" class="form-control" type="text" name="" placeholder="请输入报告编号"/>
      <button class="btn" id="search" style="margin-left:20px">搜索</button>
      <button class="btn" style="float: right" id="createpdf" data-toggle="modal" data-target="#selectTempletModal">
	            生成征信报告
	  </button>
    </div>	
    <div class="tableContaine marginTop">
      <div>
        <table id="creditReportTable" class="table table-striped"></table>
      </div>
    </div>
    
    <div class="modal fade" id="selectTempletModal" tabindex="-1" role="dialog" aria-labelledby="creditReportModelModal" aria-hidden="true">
	<div class="modal-dialog " style="width: 600px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="addScoreModelTitle">选择征信报告模板</h4>
			</div>
			<div class="modal-body">
				<table id="templetList" class="table table-striped"></table>
			</div>
		</div>
	</div>
	</div>
    
  </div>
</div>
<div id="loading" style="display: none">
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
<script>
var cardId = '<%=request.getParameter("id")%>';
var algorCode = '<%=request.getParameter("algorithmType")%>';
</script>
<script src="${pageContext.request.contextPath}/js/person/person-credit-report.js"></script>