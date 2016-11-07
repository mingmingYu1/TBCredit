<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<div class="row" id="scoreModelManage">
  <div class="col-xs-12 overflow" style="padding-left: 0;">
    <div class="hideBtn">
      <button class="btn closeLeft">
        <i class="icon-angle-left"></i>     <!--   icon-angle-right  -->
      </button>
    </div>
    <div class="oneHeader">
      <p class="sumTitle"><a href="./person-score-manage.jsp">评分模型</a>  > 评分模型管理</p>
    </div>
  </div>
  <div class="col-xs-12 marginLeft">
    <div class="overflow" style="margin-top: 20px;">
      <button class="btn pull-left" data-toggle="modal" data-target="#scoreModelModal" onclick="toaddScoreModel()">
	  	  <span class="icon-plus"></span>&nbsp;&nbsp; 新增
	    </button>
      <button id="lookWeight" class="btn pull-right">查看权重</button>
    </div>
    <div class="tableContainer">
      <div>
        <table id="score_model_table" data-toggle="table" data-cache="false" data-pagination="true"
               data-side-pagination="server" data-url="/creditsupport/scoreModel/query" class="table table-striped">
          <thead>
          <tr>
            <th data-field="modelId" data-visible=false></th>
            <th data-field="number" data-width='8%' data-formatter="operateFormatterNumber">序号</th>
            <th data-field="modelCode"  data-width='15%' >评分模型编码</th>
            <th data-field="modelName" data-width='15%' data-align="left">评分模型名称</th>
            <th data-field="updateTime" data-title-tooltip="" data-width='15%' data-align="left">更新时间</th>
            <th data-field="modelDesc"  data-title-tooltip="" data-width='15%' data-align="left">评分模型描述</th>
            <th data-field="algorithmDesc"  data-title-tooltip="" data-width='15%' data-align="left">算法描述</th>
            <th data-field="scene"  data-title-tooltip="" data-width='15%' data-align="left">模型应用场景</th>
            <th data-field="status" data-width='15%' data-formatter="operateFormatterStarts" data-events="operateEventsStarts" data-align="left">状态</th>
            <th data-field="operate_user" data-width='20%' data-align="right" data-formatter="operateFormatterScoreModel" data-events="operateEventsScoreModel">操作</th>
          </tr>
          </thead>
        </table>
      </div>
    </div>
  </div>
</div>
                                                
<!-- 新增、修改页面 -->
<div class="modal fade" id="scoreModelModal" tabindex="-1" role="dialog" aria-labelledby="scoreModelModal" aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="addScoreModelTitle">新增</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="scoreModel_form" action="/creditsupport/scoreModel/update" method="post">
          <input type="hidden" id="model_id_manage" name="modelId" />
          <input type="hidden" id="modelCode_edit_manage" name="modelCode" />
          <input type="hidden" id="status_edit_manage" name="status" />
          <div class="modalInput">
            <div>
              <label for="modelCode_manage"> <span>*</span>评分模型编码：</label>
            </div>
            <div>
              <input class="form-control" type="text" id="modelCode_manage" name="modelCode"  placeholder="请输入评分模型编码"/>
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="modelName_manage"> <span>*</span>评分模型名称：</label>
            </div>
            <div>
              <input class="form-control"  type="text" id="modelName_manage" name="modelName"  placeholder="请输入评分模型名称"/>
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="modelScene">模型应用场景：</label>
            </div>
            <div>
              <select class="form-control" id="modelScene" name="scene">
                <option value="授信">授信</option>
                <option value="贷款">贷款</option>
                <option value="交易">交易</option>
              </select>
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="modelDesc_manage">评分模型描述：</label>
            </div>
            <div>
              <textarea class="form-control" id="modelDesc_manage" name="modelDesc"></textarea>
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="algorithmDesc_manage">算法描述：</label>
            </div>
            <div>
              <textarea class="form-control" id="algorithmDesc_manage" name="algorithmDesc"></textarea>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button id="submit_scoreModel_form" type="button" class="btn">创建</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">
if($("#leftNav").css("display") === "none") {
  checkHeight("#scoreModelManage");
}
  
var $table = $('#score_model_table');

var params = {};

function operateFormatterScoreModel(value, row, index) {
	return [
	    '<a href="javascript:void(0)"  class="scoreModel_code  _edit" title="计分">计分</a>&nbsp&nbsp',
	    '<a href="javascript:void(0)"  class="scoreModel_edit _edit" title="编辑">编辑</a>&nbsp&nbsp',
	    '<a href="javascript:void(0)"  class="scoreModel_remove _remove" title="删除">删除</a>',
	].join('');
}

function operateFormatterStarts(value, row, index) {
  if(row.status == 1) {
    return '<a href="javascript:void(0)" class="startStop" title="更新">更新</a>'
  } else if (row.status == 2) {
    return '<span>不允许更新</span>'
  }else {
    return '<span>正在更新</span>'
  }
}

window.operateEventsStarts = {
  "click .startStop": function (e, value, row, index) {
    var txt = "您确定要更新吗 ?";
    var modelCode = row.modelCode;
    var option = {
      btn: parseInt("0011", 2),
      onOk: function () {
        var modelId = row.modelId;
        $.ajax({
          url: "/creditsupport/scoreModel/runAlgorithm?_time=" + new Date().getTime(),
          dataType: "json",
          type: "post",
          data: {modelCode: modelCode},
          success: function (data) {
            if (1 == data) {
              row.status = 0;
              $('#score_model_table').bootstrapTable('updateRow', {index: index, row: row});
            }else{
            	
            }
          },
          error: function () {
            var txt = "更新失败！！";
            window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
          }
        });
      }
    };
    window.wxc.xcConfirm(txt, "custom", option);
  }
};

//  隐藏按钮
$("#scoreModelManage").find(".btn.closeLeft").on("click", function () {
  hideLeft();
  checkHeight("#scoreModelManage");
});

    //新增按钮
function toaddScoreModel(){
  $("#addScoreModelTitle").html("评分模型新增");
  $("#submit_scoreModel_form").html("创建");
  $("#model_id_manage").val('');
  $("#modelCode_edit_manage").attr('disabled', 'disabled');
  $("#modelCode_edit_manage").val('');
  $("#status_edit_manage").val(1);//新增状态为1
  $("#modelCode_manage").val('');
  $("#modelCode_manage").removeAttr('disabled');
  $("#modelDesc_manage").val('');
  $("#algorithmDesc_manage").val('');
  $("#modelName_manage").val('');
}

//计分、编辑、删除
window.operateEventsScoreModel = {
//   计分
"click .scoreModel_code": function (e, value, row, index) {
    var txt = "您确定要对所有企业重新计分吗 ?";
    var option = {
      btn: parseInt("0011", 2),
      onOk: function () {
        $("#loadingIndex").show();
        var modelCode = row.modelCode;
        $.ajax({
          url:"/creditsupport/scoreModel/scoring" ,
          dataType: "json",
          type: "post",
          data: {modelCode: modelCode},
          success: function (data) {
            $("#loadingIndex").hide();
            if (data == 0) {
              var txt = "计分失败！！";
              window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
              return;
            }
        	if (data == 1) {
        	  var txt = "已重新计算得分，请到企业管理查看！";
              window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
              return;
        	}
          }
        });
      }
    }
    window.wxc.xcConfirm(txt, "custom", option);
  },
  //编辑
  'click .scoreModel_edit': function (e, value, row, index) {
      $("#addScoreModelTitle").html("评分模型编辑");
      $("#submit_scoreModel_form").html("保存");
      $("#model_id_manage").val(row.modelId);
      $("#modelCode_edit_manage").val(row.modelCode);
      $("#modelCode_edit_manage").removeAttr('disabled');
      $("#status_edit_manage").val(row.status);
      $("#modelCode_manage").val(row.modelCode);
      $("#modelCode_manage").attr('disabled', 'disabled');
      $("#modelDesc_manage").val(row.modelDesc);
      $("#algorithmDesc_manage").val(row.algorithmDesc);
      $("#modelName_manage").val(row.modelName);
      $("#scoreModelModal").modal("show");
      $("#modelScene").find("option[value='"+row.scene+"']").prop("selected",true);
  },
   //删除按钮
  'click .scoreModel_remove': function (e, value, row, index) {  
  	var txt="您确定删除吗 ?";
		  var option = {
			btn: parseInt("0011",2),
			onOk: function(){
				var modelCode = row.modelCode;
				if(modelCode=="Delphi"||modelCode=="RF"||modelCode=="LR"){
					var text = "该算法正在使用，不允许删除！";
					window.wxc.xcConfirm(text, window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
	        	var id = row.modelId;
	        	var params = {'id':id};
				$.ajax({ 
					url: "/creditsupport/scoreModel/delete",
					type:"post",
					dataType:"json",
					cache:"false",
					data:params, 
					success: function(responseText){
						if(responseText.code == 0) {
			                $('#score_model_table').bootstrapTable('refresh', {url: "/creditsupport/scoreModel/query"});
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

$("#submit_scoreModel_form").on('click', function () {
    if (scoreModelCheck() == false) {
      return false;
    }
    $("#scoreModel_form").ajaxSubmit({
        type: 'post', success: function (result) {
          if (0 == result.code) {
            $("#scoreModelModal").modal("hide");
            $('#score_model_table').bootstrapTable('refresh', {url: "/creditsupport/scoreModel/query"});
          }
          var txt = result.message;
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        }
    });
});
//校验
function scoreModelCheck(){
	var validate = true;
	var modelCode = $("#modelCode_manage").val();
	if(modelName == ""){
		modelCode = $("#modelCode_edit_manage").val();
	}
	validate = checkData(validate, modelCode, "评分模型编码", checkNull);
	validate = checkData(validate, modelCode, "评分模型编码", checkLength, 16);
	validate = checkData(validate, modelCode, "评分模型编码", checkNumOrW);
	if(!validate){
		return validate;
	}
	//评分模型名称
	var modelName = $("#modelName_manage").val();
	if(modelName == ""){
		window.wxc.xcConfirm("评分模型名称不可为空!", window.wxc.xcConfirm.typeEnum.info);
	    return false;
	}
	//校验字段长度
  if(!checkInputGBKLength(modelName, 30)){
		window.wxc.xcConfirm("评分模型名称长度不可超过30个字符（中文为两个字符）", window.wxc.xcConfirm.typeEnum.info);
    return false;
	}
	
  //信用评定
  var modelDesc =  $("#modelDesc_manage").val();
  if(!checkInputGBKLength(modelDesc, 160)){
    window.wxc.xcConfirm("评分模型描述不可超过160个字符（中文为两个字符）", window.wxc.xcConfirm.typeEnum.info);
    return false;
	}
    
  //信用评定建议
  var algorithmDesc = $("#algorithmDesc_manage").val();
  if(!checkInputGBKLength(algorithmDesc, 160)){
    window.wxc.xcConfirm("算法描述不可超过160个字符（中文为两个字符）", window.wxc.xcConfirm.typeEnum.info);
    return false;
	}
}

$table.bootstrapTable().on('post-body.bs.table',function(){
  pageHeight();
});

$(".modal.fade").modal({show:false,keyboard:false});


  $("#lookWeight").on("click", function () {
    if (params.modelCode && params.status != 0) {
      $("#content").load("./scoreModel-weight.jsp", params, function () {
      })
    } else if (params.status == 0){
      $.ajax({ 
			url: "/creditsupport/scoreModel/status",
			type:"post",
			dataType:"json",
			cache:"false",
			data:{modelCode: params.modelCode}, 
			success: function(data){
		      if(data == 0) {
			       var txt="算法更新未结束!";
                   window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			    } else {
			      $("#content").load("./scoreModel-weight.jsp", params, function () {
                  })
			    } 
	          }
	       });
    } else {
      var txt="您未选择任何一条信息，不可进行此操作 !";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
    }
  });


  //判断选择的tr的id
$table.bootstrapTable().on("click-row.bs.table", function (e, row, $element) {
  var modelCode = row.modelCode;
  var modelName = row.modelName;
  var status = row.status;
  params = {modelCode: modelCode, modelName: modelName, status: status};
  $table.find("tr").removeClass('active');
  $element.addClass("active");
})
</script>
