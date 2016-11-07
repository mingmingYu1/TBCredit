<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<div class="row" id="creditReport">
  <div class="col-xs-12 marginLeft marginTop">
    <p class="sumTitle"><a href="company-manage.jsp" class="returnIndex">企业管理</a> > 征信报告列表</p>
  </div>
  <div class="col-xs-12 marginLeft">
    <p class="link">
      <a href="./company-manage.jsp" class="returnIndex">< 返回企业列表</a>
    </p>
    <div class="marginTop">
      <label>报告编号：</label>
      <input id="creditReportSelect" class="form-control" type="text" name="" placeholder="请输入报告编号"/>
      <button class="btn" id="search" style="margin-left:20px">搜索</button>
			<mrp:p rId="2122">
				<button class="btn" style="float: right" id="createpdf" data-toggle="modal" data-target="#selectTempletModal"> 生成征信报告</button>
			</mrp:p>
    </div>
    <div class="tableContaine marginTop">
      <div>
        <table id="creditReportTable" class="table table-striped"></table>
      </div>
    </div>
    
    <div class="modal fade" data-backdrop="static" id="selectTempletModal" tabindex="-1" role="dialog" aria-labelledby="creditReportModelModal" aria-hidden="true">
	<div class="modal-dialog " style="width: 600px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="addScoreModelTitle">选择征信报告模板</h4>
			</div>
			<div class="modal-body">
				<table id="templetList" class="table table-striped"></table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn" data-dismiss="modal">关闭</button>
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
var regId = '<%=request.getParameter("id")%>';
var algorCode = '<%=request.getParameter("algorithmType")%>';
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
		sorOrder: "desc"
	},{
		field: 'agentName',
		title: '企业名称',
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
		/*formatter: function (value, row, index) {
		 if(value !== null) {
		 var date = new Date(value);
		 return date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate() + " "
		 + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() ;
		 }
		 },*/
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
			return  '<mrp:p rId="2123"><a href="javascript:void(0)"  class="creditReportLook" title="查看">查看</a></mrp:p>'
		},
		events: 'creditReportEvents'
	}],
	sortName: 'create_time',
	sortOrder: "desc",
	pagination: true,
	sidePagination: 'server',
	pageNumber: 1,
	pageSize: 10,
	cache: false,
	pageList: [5, 10, 20],
	queryParams: function (params) {
		return {
			id : regId,
			limit: params.limit,
			offset: params.offset,
			order: params.order,
			sort: params.sort
		}
	},
	url: '/creditsupport/creditReport/query'
});
</script>
<script src="${pageContext.request.contextPath}/js/credit-report.js"></script>