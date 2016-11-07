<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<div class="row" id="scoreLevelManage">
  <div class="col-xs-12 overflow" style="padding-left: 0;">
    <div class="hideBtn">
      <button class="btn closeLeft">
        <i class="icon-angle-left"></i>     <!--   icon-angle-right  -->
      </button>
    </div>
    <div class="oneHeader">
      <p class="sumTitle"><a href="./person-score-manage.jsp">评分模型</a><a class="returnJi" href="./scoreLevelVersion-manage.jsp"> > 评分版本管理</a> > 评分列表管理</p>
    </div>
  </div>
  <div class="col-xs-12 marginLeft">
    <div class="marginTop">
      <button class="btn" data-toggle="modal" data-target="#scoreLevelModal" onclick="toaddScoreLevel()">
		<span class="icon-plus"></span>&nbsp;&nbsp; 新增
	  </button>
    </div>
    <div class="tableContainer">
      <div>
        <table id="score_level_table" class="table table-striped">
        </table>
      </div>
    </div>
  </div>
</div>
                                                
<!-- 新增、修改页面 -->
<div class="modal fade" id="scoreLevelModal" tabindex="-1" role="dialog" aria-labelledby="scoreLevelModal" aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="addScoreLevelTitle">评分等级新增</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="scoreLevel_form" action="/creditsupport/personScoreLevel/update" method="post">
          <input type="hidden" id="id_manage" name="id" />
          <input type="hidden" id="levelCode_manage" name="levelCode" />
          <input type="hidden" id="levelVersion" name="levelVersion"/>
          <div class="modalInput">
            <div>
              <label for="levelScoreMin_manage"><span>*</span>评分区间：</label>
            </div>
            <div>
              <input class="form-control" style="width:200px;" type="text" id="levelScoreMin_manage" name="levelScoreMin"  placeholder="请输入最低评分(整数)"/>
               ~&nbsp;<input class="form-control" style="width:200px;" type="text" id="levelScoreMax_manage" name="levelScoreMax"  placeholder="请输入最高评分(整数)"/>
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="levelName_manage"> <span>*</span>等级：</label>
            </div>
            <div>
              <input class="form-control"  type="text" id="levelName_manage" name="levelName"  placeholder="请输入等级"/>
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="levelDesc_manage">信用评定：</label>
            </div>
            <div>
              <input class="form-control"  type="text" id="levelDesc_manage" name="levelDesc"  placeholder="请输入信用评定"/>
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="remark_manage">信用评定建议：</label>
            </div>
            <div>
              <textarea class="form-control" id="remark_manage" name="remark"></textarea>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button id="submit_scoreLevel_form" type="button" class="btn">创建</button>
        <button type="button" class="btn" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
var $table= $('#score_level_table');
$table.bootstrapTable({
  columns: [{
    field: 'index',
    title: '序号',
    width: "6%",
    formatter: function (value, row, index) {
  	  return index+1
    }
  },{
    field: 'levelVersion',
    title: '版本Id',
    visible: false
  },{
    field: 'id',
    title: '主键',
    visible: false
  },{
    field: 'levelCode',
    title: 'code',
    visible: false
  },{
    field: 'levelScore',
    title: '评分区间',
    align: "left"
  },{
    field: 'levelName',
    title: '等级',
    align: "left"
   },{
    field: 'levelDesc',
    title: '信用评定',
    align: "left"
   },{
    field: 'remark',
    title: '信用评分建议',
    width: "40%",
    titleTooltip: function (value,row,index) {
     return value;
    },
    align: "left"
    },{
    field: 'operation',
    title: '操作',
    align: "right",
    formatter: function(value,row,index){
      return  [
        '<a href="javascript:void(0)"  class="scoreLevel_edit" title="编辑">编辑</a>',
        '&nbsp;&nbsp;<a href="javascript:void(0)"  class="scoreLevel_remove" title="删除">删除</a>'
      ].join("");
    },
    events: 'operateEventsScoreLevel'
  }],
  sortName: 'index',
  pagination: true,
  sidePagination: 'server',
  pageNumber: 1,
  pageSize: 10,
  cache: false,
  pageList: [5, 10, 20],
  queryParams: function (params) {
    return {
      versionId:<%=request.getParameter("id")%>,
      limit: params.limit,
      offset: params.offset,
      order: params.order,
      sort: params.sort,
    }
  },
  url: '/creditsupport/personScoreLevel/query'
});
});

if($("#leftNav").css("display") === "none") {
  checkHeight("#scoreLevelManage");
}

//  隐藏按钮
$("#scoreLevelManage").find(".closeLeft").on("click", function () {
  hideLeft();
  checkHeight("#scoreLevelManage");
});


var id = <%=request.getParameter("id")%>
var version = <%=request.getParameter("version")%>
//设置分页查询条件
function queryId(params) {

return {
  id:id,
  sort: params.sort,
  order: params.order,
  limit: params.limit,
  offset: params.offset//,
};
}
    //新增按钮
function toaddScoreLevel(){
  $("#addScoreLevelTitle").html("评分等级新增");
  $("#submit_scoreLevel_form").html("创建");
  $("#id_manage").val('');
  $("#levelCode_manage").val('');
  $("#levelScoreMin_manage").val('');
  $("#levelScoreMax_manage").val('');
  $("#levelName_manage").val('');
  $("#levelDesc_manage").val('');
  $("#remark_manage").val('');
  $("#levelVersion").val(id);
}
    
//修改 、删除  逻辑
window.operateEventsScoreLevel = {
  'click .scoreLevel_edit': function (e, value, row, index) {
    $("#addScoreLevelTitle").html("评分等级编辑");
    $("#submit_scoreLevel_form").html("保存");
    $("#id_manage").val(row.id);
    $("#levelCode_manage").val(row.levelCode);
//     $("#levelScore_manage").val(row.levelScore);
    $("#levelScoreMin_manage").val(row.levelScoreMin);
    $("#levelScoreMax_manage").val(row.levelScoreMax);
    $("#levelName_manage").val(row.levelName);
    $("#levelDesc_manage").val(row.levelDesc);
    $("#remark_manage").val(row.remark);
    $("#levelVersion").val(row.levelVersion);
    $("#scoreLevelModal").modal("show");
  },
   //删除按钮
  'click .scoreLevel_remove': function (e, value, row, index) {     
  	var txt="您确定删除吗 ?";
		  var option = {
			btn: parseInt("0011",2),
			onOk: function(){
        var id = row.id;
        var params = {'id':id};
				$.ajax({ 
					url: "/creditsupport/personScoreLevel/delete",
					type:"post",
					dataType:"json",
					cache:"false",
					data:params, 
					success: function(responseText){
						if(responseText.code == 0) {
			                $('#score_level_table').bootstrapTable('refresh', {url: "/creditsupport/personScoreLevel/query"});
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

$("#submit_scoreLevel_form").on('click', function () {
    if (scoreLevelCheck() == false) {
      return false;
    }
    $("#scoreLevel_form").ajaxSubmit({
        type: 'post', success: function (result) {
          

          if (0 == result.code) {
            $("#scoreLevelModal").modal("hide");
            $('#score_level_table').bootstrapTable('refresh', {url: "/creditsupport/personScoreLevel/query"});
          }
          var txt = result.message;
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        }
    });
});
//校验
function scoreLevelCheck(){
	var validate = true;
	//评分区间最低分
	var levelScoreMin = parseInt($("#levelScoreMin_manage").val());
	validate = checkData(validate, levelScoreMin, "评分区间最低评分", checkNull);
	validate = checkData(validate, levelScoreMin, "评分区间最低评分", checkNum);
	if(validate && (levelScoreMin<0 || levelScoreMin>100)){
		window.wxc.xcConfirm("评分区间最低评分必须在0-100之间!", window.wxc.xcConfirm.typeEnum.info);
		validate = false;
	}
	//评分区间最高分
    var levelScoreMax = parseInt($("#levelScoreMax_manage").val());
    validate = checkData(validate, levelScoreMax, "评分区间最高评分", checkNull);
    validate = checkData(validate, levelScoreMax, "评分区间最高评分", checkNum);
    if(validate && (levelScoreMax<0 || levelScoreMax>100)){
        window.wxc.xcConfirm("评分区间必须在0-100之间!", window.wxc.xcConfirm.typeEnum.info);
        validate = false;
    }
    if(validate && levelScoreMax < levelScoreMin){
    	window.wxc.xcConfirm("评分区间最低评分必须低于最高分!", window.wxc.xcConfirm.typeEnum.info);
        validate = false;
    }
	
	//等级
    var levelName = $("#levelName_manage").val();
    validate = checkData(validate, levelName, "评分等级", checkNull);
    validate = checkData(validate, levelName, "评分等级", checkLength, 10);
    
    //信用评定
    var levelDesc =  $("#levelDesc_manage").val();
    validate = checkData(validate, levelDesc, "评分等级", checkLength, 30);
    
    //信用评定建议
    var remark = $("#remark_manage").val();
    validate = checkData(validate, levelDesc, "评分等级", checkLength, 160);
    
    return validate;
}

$('#score_level_table').bootstrapTable().on('post-body.bs.table',function(){
	pageHeight();
});

$(".modal.fade").modal({show:false,keyboard:false});

$(".returnJi").on("click", function (e) {
  e.preventDefault();
  var href = $(this).attr("href");
  $("#content").load(href);
})
</script>
