<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style type="text/css">
	#search_dept_btn {
		margin-left: 100px;
	}
</style>
<div class="row" id="deptManage">
	<div class="col-xs-12 overflow" style="padding-left: 0;">
		<div class="hideBtn">
			<button class="btn closeLeft">
				<i class="icon-angle-left"></i>     <!--   icon-angle-right  -->
			</button>
		</div>
		<div class="oneHeader">
			<p class="sumTitle"><a href="./system.jsp">系统管理</a> > 部门管理</p>
		</div>
	</div>
	<div class="col-xs-12 marginLeft">
		<div class="marginTop">
			<mrp:p rId="421">
				<button class="btn" data-toggle="modal" data-target="#deptModal" onclick="javascript:toaddDept();">
					<span class="icon-plus"></span>&nbsp;&nbsp;新增
				</button>
			</mrp:p>
		</div>
		<div class="tableContainer">
			<div>
				<table id="cimc_dept" data-toggle="table" data-cache="false" data-pagination="true" data-side-pagination="server"
							 data-url="/creditsupport/dept/query" class="table table-striped">
					<thead>
					<tr>
						<th data-field="id" data-visible=false>主键</th>
						<th data-field="rolename" data-width='45%' data-align="left">部门名称</th>
						<th data-field="deptPName" data-width='25%' data-align="left">上级部门</th>
						<th data-field="operate_dept" data-width='30%' data-align="right" data-formatter="operateFormatterDept" data-events="operateEventsDept">操作</th>
					</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- 部门添加页面 -->
<div class="modal fade" data-backdrop="static" id="deptModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 660px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="modalLabel">添加部门</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="dept_form" action="/creditsupport/dept/adddept" method="post">
					<div class="modalInput">
						<div>
							<label for="add_deptname"><span>*</span>部门名称：</label>
						</div>
						<div>
							<input type="text" class="form-control" id="add_deptname" maxlength=20 name="deptName" placeholder="不可含有除点以外的特殊字符且长度不可超过20位">
							<input type="text" class="form-control" style="display: none;"/>
						</div>
					</div>
					<div class="modalInput">
						<div>
							<label for="add_dept_pid"><span>*</span>上级部门：</label>
						</div>
						<div>
							<div>
								<select class="form-control" id="add_dept_pid" name="parentId" >
									<option value="-1">请选择</option>
								</select>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button id="save_dept_btn" type="button" class="btn">创建</button>
				<button type="button" class="btn" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>

<!-- 部门编辑页面 -->
<div class="modal fade" data-backdrop="static" id="deptEditModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 660px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="">编辑部门</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="edit_dept_form" action="/creditsupport/dept/updateDept" method="post">
					<div class="modalInput">
						<input type="hidden" class="form-control" id="editid" name="deptId">
						<div>
							<label for="editdeptname"><span>*</span>部门名称：</label>
						</div>
						<div>
							<input type="text" class="form-control" id="editdeptname" maxlength=20 name="deptName" placeholder="不可含有除点以外的特殊字符且长度不可超过20位">
							<input type="text" class="form-control" style="display: none;"/>
						</div>
					</div>
					<div class="modalInput">
						<div>
							<label for="editpid"><span>*</span>上级部门：</label>
						</div>
						<div>
							<select class="form-control" id="editpid" name="parentId" >
								<option value="-1">请选择</option>
							</select>
						</div>
					</div>
				</form>
			
			</div>
			<div class="modal-footer">
				<button id="edit_dept_btn" type="button" class="btn">保存</button>
				<button type="button" class="btn" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<script type="text/javascript">
var deptId
$.ajax({
	url: "/creditsupport/login/getUserInfos",
	dataType: "json",
	async: false,
	cache: "false",
	success: function (data) {
		if (-2 == data.result) {
			window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
			return false;
		}
		if (-1 == data.result) {
			window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(data.result === 1) {
			deptId = data.data.deptId
		}
	}
});
window.operateFormatterDept = function (value, row, index) {
	var arrHtml
	if(!row.deptPName || row.id === deptId) {
		arrHtml = [
			'<mrp:p rId="422"><span class="disabledColor">编辑</span></mrp:p >',
			'<mrp:p rId="423"><span class="disabledColor">&nbsp;&nbsp;删除</span></mrp:p>'
		]
	} else {
		arrHtml = [
			'<mrp:p rId="422"><a href="javascript:void(0)"  class="_edit" title="编辑">编辑</a></mrp:p>',
			'<mrp:p rId="423"><a href="javascript:void(0)" class="_remove" title="删除">&nbsp;&nbsp;删除</a></mrp:p>'
		]
	}
	return arrHtml.join('');
}
var editObject = {};
window.operateEventsDept = {
	//编辑部门
	'click ._edit': function (e, value, row, index) {
		jQuery("#editpid").empty();
		jQuery("#editdeptname").val(htmlDecode(row.rolename));
		editObject.deptPName = row.deptPName;
		editObject.rolename = row.rolename
		var id = row.id;
		var deptPName = row.deptPName;
		var params = {"id":id};
		
		jQuery("#editid").val(id);
		
		$.ajax({ 
		url: "/creditsupport/user/deptshow", 
		type:"post",
		dataType:"json",
		cache:"false",
		data:params, 
		success: function(responseText){
		
			var result = responseText.result;
			if(-2 == result){
				window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
				return false;
			}
			if(1 == result){
				jQuery("#editpid").append("<option value='-1'>请选择</option>");
				var deptList = responseText.deptList;
				if(deptList.length>0){
					for(var i = 0; i < deptList.length; i++){
						if(deptPName == deptList[i].deptName){
							jQuery("#editpid").append("<option  selected = 'selected' value='"
									+ deptList[i].deptId+"'>" + deptList[i].deptName + "</option>");
						}else{
							jQuery("#editpid").append("<option value='" + deptList[i].deptId
									+ "'>" + deptList[i].deptName + "</option>");
						}
					}
				}
			}
			if(-1==result){
				jQuery("#editpid").append("<option value='-1'>请选择</option>");
			}
			return false;
    	}
    });
	    $("#deptEditModal").modal("show");
	},
	
	//删除部门
	'click ._remove': function (e, value, row, index) {
		var txt="您确定删除部门“"+row.rolename+"”吗?";
		var option = {
			btn: parseInt("0011",2),
			onOk: function(){
					var id = row.id;
					var params = {'deptId':id};
					$.ajax({ 
						url: "/creditsupport/dept/deldept", 
						type:"post",
						dataType:"json",
						cache:"false",
						data:params, 
						success: function(responseText){				
							var result = responseText.result;
							if(-2==result){
								window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
								return false;
							}
							/* if(3==num){
								var txt="该部门为公司根部门,不能删除 !";
								window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
								return false;
							}
							if(0==num){
								var txt="该部门下有员工,不能删除 !";
								window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
								return false;
							}
							if(1==num){
								var txt="该部门下有子部门,请先解除绑定关系 !";
								window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
								return false;
							} */
							if(1==result){
								var txt="删除部门成功 !";
								window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
								setTimeout("finddept()",500);
							} else if(-1==result){
								window.wxc.xcConfirm(responseText.message, window.wxc.xcConfirm.typeEnum.info);
								setTimeout("finddept()",500);
							}else{
								var txt="删除出现异常 !";
								window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
							}
					
							return false;
					//$('#cimc_user').bootstrapTable('load', responseText);
				
		    			}
		   			 });
				}
			};
		window.wxc.xcConfirm(txt, "custom", option);
	}
};
//   编辑部门方法
function edit_dept() {
	$("#edit_dept_form").ajaxSubmit(function (data) {
		var result = data.result;
		if(-2==result){
			window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
			return false;
		}
		if(-1==result){
			window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(1==result){
			$("#deptEditModal").modal("hide");
			var txt="编辑部门成功 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			setTimeout("finddept()",500);
		} else {
			var txt="编辑部门出现异常 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		}
		return false;
	});
}
//   添加部门的方法
function add_deptname(){
	$("#dept_form").ajaxSubmit(function (data) {
		var result = data.result;
		
		if(-2==result){
			window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
			return false;
		}

		if(-1==result){
			window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		if(1==result){
			$("#deptModal").modal("hide");
			var txt="添加部门成功 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			setTimeout("finddept()",500);
		} else {
			var txt="添加部门出现异常 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		}
		return false;
	});
}
//编辑部门  
$("#edit_dept_btn").on('click',function(){
    if(!editObject.deptPName) {
      var txt = editObject.rolename + "为顶级部门不允许编辑!";
	  window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	  return false;
    }
	if($("#editdeptname").val()==""){
		var txt="部门名称不允许为空 !";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if($("#editdeptname").val().length > 20){
		var txt="部门名称长度不可超过20位！";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	if(!checkNameString($("#editdeptname").val(), '部门名称')) {
	  return false
	}
	if($("#editpid").val() == -1){
	  var txt="上级部门不允许为空 !";
	  window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	  return false;
	}
	edit_dept()
});

//添加部门  
$("#save_dept_btn").on('click',function(){
	if($("#add_deptname").val() == ""){
	  var txt="部门名称不允许为空 !";
	  window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
	}
	if($("#add_deptname").val().length > 20){
	  var txt="部门名称长度不可超过20位！";
	  window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
	  return false;
	}
	if(!checkNameString($("#add_deptname").val(), '部门名称')) {
	  return false
	}
	if($("#add_dept_pid").val() == -1){
	  var txt="上级部门不允许为空 !";
	  window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
	}
	add_deptname()
});
//展示
$("#search_dept_btn").on("click",function(){
	finddept();
});
$("#dept_condition").keydown(function(e){
		if($("#dept_condition").val()!==""){
			if (e.keyCode === 13) {
				e.preventDefault();
				finddept();	
			}
		}
});
function finddept(){
	
	var query_type = $("#dept_query_type").val();
	var condition = $("#dept_condition").val();
	var params = {query_type:query_type,condition:condition};
	$.ajax({ 
		url: "/creditsupport/dept/query", 
		type:"post",
		dataType:"json",
		cache:"false",
		data:params, 
		success: function(responseText){
		
			var result = responseText.result;
			if(-2==result){
				window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
				return false;
			}			
			if(1==result){
				$('#cimc_dept').bootstrapTable('getOptions').pageNumber=1;
				$('#cimc_dept').bootstrapTable('load', responseText);
			};
			
			if(-1==result){
				var txt="查询部门出现异常 !";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				return false;	
			}
			
			return false;
    	}
    });
}


$("#reset_dept_btn").on("click",function(){
	$("#dept_condition").val("");
	finddept();
});

function toaddDept(){
	
	$("#add_deptname").val("");
	//$("#add_deptname").attr("placeholder","部门名称");
	jQuery("#add_dept_pid").empty();
	jQuery("#add_dept_pid").append("<option value='-1'>请选择</option>");
	$.ajax({ 
		url: "/creditsupport/user/deptshow", 
		type:"post",
		dataType:"json",
		cache:"false",
		success: function(responseText){
		
			var result = responseText.result;
			if(-2==result){
				window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
				return false;
			}			
			
			if(1==result){
				
				var deptList = responseText.deptList;
				
				if(deptList.length>0){
					for(var i=0;i<deptList.length;i++){
						var id = deptList[i].deptId;
						var deptname = deptList[i].deptName;
						jQuery("#add_dept_pid").append("<option value='"+id+"'>"+deptname+"</option>");
					}
				};
				
			};
			
			if(-1==result){
				jQuery("#add_dept_pid").empty();
				jQuery("#add_dept_pid").append("<option value='-1'>请选择</option>");
			}
			return false;
    	}
    });
}

$('#cimc_dept').bootstrapTable().on('post-body.bs.table',function(){
	pageHeight();
});

$(".modal.fade").modal({show:false,keyboard:false});

//  左侧按钮
$(".btn.closeLeft").on("click", function () {
	hideLeft();
	checkHeight("#deptManage")
});

</script>