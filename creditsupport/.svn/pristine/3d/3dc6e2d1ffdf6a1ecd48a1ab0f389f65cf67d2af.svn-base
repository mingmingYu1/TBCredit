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
      <p class="sumTitle"><a href="./person-score-manage.jsp">评分模型</a> > 评分版本管理</p>
    </div>
  </div>
  <div class="col-xs-12 marginLeft">
    <div style="margin-top: 20px;">
      <button class="btn" data-toggle="modal" data-target="#scoreLevelVersionModal" onclick="addScoreLevelVersion()">
		<span class="icon-plus"></span>&nbsp;&nbsp; 新增
	  </button>
    </div>
    <div class="tableContainer">
      <div>
        <table id="score_levelVersion_table" data-toggle="table" data-cache="false" data-pagination="true" data-side-pagination="server" data-url="/creditsupport/personScoreLevelVersion/query"
               class="table table-striped">
          <thead>
            <tr>
              <th data-field="id" data-visible=false  data-align="left" data-sortable=true  data-order="asc">id</th>
              <th data-field="version"  data-width='8%' data-formatter="versionFormatter">版本号</th>
              <th data-field="create_time" data-width='25%' data-align="left" data-formatter="dateFormatter">创建时间</th>
              <th data-field="create_user" data-width='25%' data-align="left">创建人</th>
              <th data-field="status" data-width='20%' data-align="left" data-formatter="creditReportStatusFormatter">状态</th>
              <th data-field="5" data-width='15%' data-align="right" data-formatter="creditReportFormatter" data-events="creditReportEvents">详情</th>
            </tr>
          </thead>
        </table>
      </div>
    </div>
  </div>
</div>
                                                
<!-- 新增、修改页面 -->
<div class="modal fade" id="scoreLevelVersionModal" tabindex="-1" role="dialog" aria-labelledby="scoreLevelVersionModal" aria-hidden="true">
  <div class="modal-dialog" style="width: 500px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="addScoreLevelTitle">评分等级新增</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="scoreLevelVersion_form" action="/creditsupport/personScoreLevelVersion//add" method="post">
	        <div class="modalInput">
	          <div>
	            <label><span>*</span>版本号：</label>
	          </div>
	          <div>
	            <select class="form-control" id="level_historyVersion"  name='id' style="width: 240px;">
	              <option value="">全部</option>
	            </select>
	          </div>
	        </div>
        </form>
      </div>
      <div class="modal-footer">
        <button id="selectScoreVersion" type="button" class="btn">创建</button>
        <button type="button" class="btn" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">

function versionFormatter(value, row, index) {
	return 'V' + value;
}
function dateFormatter(value, row, index){
	 if(value !== null) {
         var date = new Date(value);
         return date.getFullYear() + "-" + (date.getMonth()+1)+ "-" + date.getDate();
    }
} 

function creditReportFormatter(value, row, index) {
  return  '<a href="javascript:void(0)"  class="scoreLevelLook" title="基本信息">查看</a>'
}

function creditReportStatusFormatter(value,row,index){
	if(row.status==1){
		return '<a name="status"  href="javascript:void(0)" id=level_version'+row.id+' onclick="closeStatus('+row.id+')" style="color:green;"  title="状态">关闭</a>';
	}else{
		return '<a name="status"  href="javascript:void(0)" id=level_version'+row.id+' onclick="openStatus('+row.id+')" style="color:red;"  title="状态">启动</a>';
	}
}

function closeStatus(id){
	$.post("/creditsupport/personScoreLevelVersion/update",{"id":id,"status":0},function(data){
		if(data.code==0){
			$("#level_version"+id).css("color","red");
			$("#level_version"+id).text("启动");
			 $('#score_levelVersion_table').bootstrapTable('refresh', {url: "/creditsupport/personScoreLevelVersion/query"});
		}
         window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
	},"json");
}

function openStatus(id){
	$.post("/creditsupport/personScoreLevelVersion/update",{"id":id,"status":1},function(data){
		if(data.code==0){
			$("#level_version"+id).css("color","green");
			$("#level_version"+id).text("关闭");
			 $('#score_levelVersion_table').bootstrapTable('refresh', {url: "/creditsupport/personScoreLevelVersion/query"});
		}
        window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
	},"json");
}

window.creditReportEvents = {
    'click .scoreLevelLook': function (e, value, row, index) {
      var id = row.id;
      var version = row.version
      $("#content").load('/creditsupport/jsp/person/scoreLevel-manage.jsp'+"?id="+id+"&version="+version, {id: id, version: version}, function () {
          //alert(id);
        });
    }
  };

if($("#leftNav").css("display") === "none") {
  checkHeight("#scoreLevelManage");
}

//  隐藏按钮
$("#scoreLevelManage").find(".closeLeft").on("click", function () {
  hideLeft();
  checkHeight("#scoreLevelManage");
});


  
    //新增按钮
function addScoreLevelVersion(){
  $("#addScoreLevelTitle").html("评分等级新增");
  $("#submit_scoreLevel_form").html("创建");
  loadVersion();
} 
    
function loadVersion(){
	$.ajax({
		url : "/creditsupport/personScoreLevelVersion/listVersion",
		type : "post",
		dataType : "json",
		cache : "false",
		success : function(responseText) {
			$("#level_historyVersion").html("<option value=''>全部</option>");
			if (responseText != null && responseText != "") {
				if (responseText.rows.length > 0) {
					for (var i = 0; i < responseText.rows.length; i++) {
						$("#level_historyVersion").append("<option value='"+responseText.rows[i].id+"'>" + responseText.rows[i].version+ "</option>");
					}
				}
			}
			return false;
		}
	});
}    

$("#selectScoreVersion").on('click', function () {
    $("#scoreLevelVersion_form").ajaxSubmit({
        type: 'post', success: function (result) {
          
          if (0 == result.code) {
            $("#scoreLevelVersionModal").modal("hide");
            $('#score_levelVersion_table').bootstrapTable('refresh', {url: "/creditsupport/personScoreLevelVersion/query"});
          }
          var txt = result.message;
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        }
    });
});


$('#score_levelVersion_table').bootstrapTable().on('post-body.bs.table',function(){
	pageHeight();
});

$(".modal.fade").modal({show:false,keyboard:false});
</script>
