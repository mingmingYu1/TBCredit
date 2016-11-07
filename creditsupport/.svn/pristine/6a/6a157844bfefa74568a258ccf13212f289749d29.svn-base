<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ztree.all-3.5.min.js"></script>
<link href="${pageContext.request.contextPath}/css/cmxform.css" rel="stylesheet">
<style>
	.modalInput .ztreeContainer {
		width: 420px;
		height: 400px;
		margin-left: 0;
	}
	.ztree {
		padding: 10px 20px;
	}
</style>
<div class="row" id="roleManage">
	<div class="col-xs-12 overflow" style="padding-left: 0;">
		<div class="hideBtn">
			<button class="btn closeLeft">
				<i class="icon-angle-left"></i>     <!--   icon-angle-right  -->
			</button>
		</div>
		<div class="oneHeader">
			<p class="sumTitle"><a href="./system.jsp">系统管理</a> > 角色管理</p>
		</div>
	</div>
	<div class="col-xs-12 marginLeft">
		<div class="marginTop">
			<mrp:p rId="431">
				<button class="btn" data-toggle="modal" data-target="#addroleModal" onclick="toaddRole()">
					<span class="icon-plus"></span>&nbsp;&nbsp;新增
				</button>
			</mrp:p>
		</div>
		<div class="tableContainer">
			<div>
				<table id="cimc_role" data-toggle="table" data-cache="false" data-pagination="true" data-pagination=true data-side-pagination="server"
							 data-url="/creditsupport/role/query" class="table table-striped templatemo-user-table">
					<thead>
					<tr style="vertical-align: middle;">
						<th data-field="roleId" data-visible=false>主键 </th>
						<th data-field="roleName" data-width='25%' data-align="left">角色名称</th>
						<th data-field="menuName" data-title-tooltip="" data-width='50%' data-align="left">拥有权限</th>
						<th data-field="operate_role" data-width='25%' data-align="right" data-formatter="operateFormatterRole" data-events="operateEventsRole">操作</th>
					</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- 角色添加页面 -->
<div class="modal fade" data-backdrop="static" id="addroleModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true" >
	<div class="modal-dialog" style="width: 660px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">添加角色</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" method="post" id="addrole_form" action="/creditsupport/role/addRole">
					<div class="modalInput">
						<div>
							<label for="rolename"><span>*</span>角色名称：</label>
						</div>
						<div>
							<input type="text" class="form-control" id="addrolename" maxLength=20 name="roleName" placeholder="不可含有除点以外的特殊字符且长度不可超过20位">
							<input type="text" class="form-control" style="display: none;"/>
						</div>
					</div>
					<div class="modalInput">
						<div>
							<label><span>*</span>权限：</label>
						</div>
						<div class="ztreeContainer">
							<input type="hidden" id="addRoleRight" name="right" value=""/>
							<div class="ztree" id="resource-tree"></div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button id="save_role_btn" type="button" class="btn">创建</button>
				<button type="button" class="btn" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>

<!-- 角色编辑页面 -->
<div class="modal fade" data-backdrop="static" id="roleModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true" >
	<div class="modal-dialog" style="width: 660px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="modalLabel">编辑角色</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" method="post" id="role_form" action="/creditsupport/role/updateRole">
					<input type="hidden" class="form-control" id="id" name="roleId">
					<div class="modalInput">
						<div>
							<label for="rolename" ><span>*</span>角色名称：</label>
						</div>
						<div>
							<input type="text" class="form-control" id="rolename" maxlength=20 name="roleName" placeholder="不可含有除点以外的特殊字符且长度不可超过20位">
							<input type="text" class="form-control" style="display: none;"/>
						</div>
					</div>
					<div class="modalInput">
						<input type="hidden" id="editRoleRight" name="right" value=""/>
						<div>
							<label><span>*</span>权限：</label>
						</div>
						<div class="ztreeContainer">
							<div class="ztree" id="edit-resource-tree"></div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button id="edit_role_btn" type="button" class="btn">保存</button>
				<button type="button" class="btn" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

var roles = []
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
			roles = data.data.roles || []
		}
	}
});
function operateFormatterRole(value, row, index) {
	var bol = false
	$(roles).each(function(i, num) {
		if(num === row.roleId) {
			bol = true
			return false
		}
	})
	var arrHtml
	if(row.roleId === 1) {
		arrHtml = [
			'<mrp:p rId="432"><span class="disabledColor">编辑</span></mrp:p>',
			'<mrp:p rId="433"><span class="disabledColor">&nbsp;&nbsp;删除</span></mrp:p>'
		]
	} else if (!bol) {
		arrHtml = [
			'<mrp:p rId="432"><a href="javascript:void(0)" class="role_edit _edit" title="编辑">编辑</a></mrp:p>',
			'<mrp:p rId="433"><a href="javascript:void(0)" class="role_remove _remove" title="删除">&nbsp;&nbsp;删除</a></mrp:p>'
		]
	} else {
		arrHtml = [
			'<mrp:p rId="432"><span class="disabledColor">编辑</span></mrp:p>',
			'<mrp:p rId="433"><span class="disabledColor">&nbsp;&nbsp;删除</span></mrp:p>'
		]
	}
	return arrHtml.join('');
}
window.operateEventsRole = {
	'click .role_edit': function (e, value, row, index) {
		document.getElementById("role_form").reset();
		$("#role_form").autofill(row);
		$("#rolename").val(htmlDecode(row.roleName));
		jQuery("#edit-resource-tree").empty();
		var params = {"roleId":row.roleId};
			//角色
		$.ajax({
			url: "/creditsupport/role/toupdateRole",
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
					var menuList = responseText.menuList;
					var arrays="";
					if(menuList.length > 0){
						citynodes = [];
						var markpid = "";
						for(var i = 0; i < menuList.length; i++){
							var id = menuList[i].menuId;
							var menuName = menuList[i].menuName;
							var pid = menuList[i].parentId;
							var isSelected = menuList[i].isSelected;
							citynodes.push({
								id:id,
								pId : pid,
								name : menuName
							});
							if(1 == isSelected){
								arrays = arrays+","+id;
							}
						}
					};
					zTree = $.fn.zTree.init($("#edit-resource-tree"),setting, citynodes);
					arrays = arrays.substring(1);
					var ids = arrays.split(",");
					for(var i = 0; i < ids.length; i++){
						var node = zTree.getNodeByParam("id", ids[i]);
						zTree.checkNode(node,true,true);
					}
					/*var nodes = zTree.getNodes();
					if (nodes.length > 0) {
						$(nodes).each(function(i, item) {
							zTree.expandNode(item, true, false, true);
						})
					} */
				}
				if(-1==result){
					var txt="权限查询出现错误 !";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				}
				return false;
			}
		});
		$("#roleModal").modal("show");
	},
	'click .role_remove': function (e, value, row, index) {
		var txt="您确定删除角色“" + row.roleName + "”吗?";
		var option = {
			btn: parseInt("0011",2),
			onOk: function(){
				var id = row.roleId;
				var params = {'roleId':id};
				$.ajax({
					url: "/creditsupport/role/delRole",
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
							var txt="删除角色成功!";
							window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
							setTimeout("findrole()",500);
							return false;
						}
						if(-1 == result){
							window.wxc.xcConfirm(responseText.message, window.wxc.xcConfirm.typeEnum.info);
						} else {
							var txt="删除出现异常!";
							window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
						}
						return false;
					}
				});
			}
		}
		window.wxc.xcConfirm(txt, "custom", option);
	}
};




//查询
$("#search_role_btn").on("click",function(){
	findrole();
});
$("#role_condition").keydown(function(e){
		if($("#role_condition").val()!==""){
			if (e.keyCode === 13) {
				e.preventDefault();
				findrole();	
			}
		}
});	
function findrole(){
	var query_type = $("#role_query_type").val();
	var condition = $("#role_condition").val();
	var params = {query_type:query_type,condition:condition};
	$.ajax({ 
		url: "/creditsupport/role/query", 
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
			if(-1==result){
				var txt="角色查询出现异常!";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				return false;
			}
			if(1==result){
				$('#cimc_role').bootstrapTable('getOptions').pageNumber = 1;
				$('#cimc_role').bootstrapTable('load', responseText);
			}
		//	
			return false;
    	}
    });
}
$("#reset_role_btn").on("click",function(){
	$("#role_condition").val("");
	findrole();
});
var setting = {
 	check: {
		enable: true,
		chkboxType: {"Y":"p","N":"s"}
 	},
 	view: {                                  
		showIcon:true,
		showLine:true,
		showTitle:true,
		selectedMuti:true,
		expandSpeed:"fast",
		dblClickExpand:true
 	},                          
 	data: {                                  
  		simpleData: {   //简单的数据源，一般开发中都是从数据库里读取，API有介绍，这里只是本地的                         
   			enable: true,
   			idKey: "id",  //id和pid，这里不用多说了吧，树的目录级别
   			pIdKey: "pId",
   			rootPId: 0   //根节点
  		}                          
	},
	callback: {
		onClick: function(event, treeId, treeNode){
			var treeObj = $.fn.zTree.getZTreeObj(treeId);
			treeObj.checkNode(treeNode,!treeNode.checked,true,true);
		}
	}
};
//var zTree = $.fn.zTree.init($("#resource-tree"),setting, citynodes);
var zTree;

//  角色管理前端校验
function webRolName(id) {
  var value = $(id).val()
  if(value === ""){
  	var txt="角色名称不可为空!";
  	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
  	return false;
  }
  if(value.length > 20){
  	var txt="角色名称长度不可超过20位！";
  	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
  	return false;
  }
  if(!checkNameString(value, '角色名称')) {
  	return false
  }
  return true
}

function add_role() {
	//提交
	$("#addrole_form").ajaxSubmit(function (data) {
		var result = data.result;
		if(-2==result){
			window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
			return false;
		}
		if(1==result){
			var txt="保存角色成功!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			$("#addroleModal").modal("hide");
			setTimeout("findrole()",500);
			return false;
		}
		if(-1==result){
			window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
			return false;
		} else {
			var txt="保存角色出现异常!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
	});
}

//    编辑角色的方法
function edit_role() {
	//提交
	$("#role_form").ajaxSubmit(function (data) {
		var result = data.result;
		if(-2==result){
			window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
			return false;
		}
		if(1==result){
			var txt="保存角色成功!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			$("#roleModal").modal("hide");
			setTimeout("findrole()",500);
			return false;
		}
		if(-1==result){
			window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
			return false;
		} else {
			var txt="保存角色出现异常!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
	});
}

//提交创建角色  
$("#save_role_btn").on('click',function(){
	if(!webRolName("#addrolename")) {
	  return false
	}
	//权限
	var right = "";
	var nodes = zTree.getCheckedNodes();
	for(var i=0;i<nodes.length;i++){
		var node = nodes[i];
		if(i==0){
			right=node.id;
		}else{
			right = right+","+node.id;
		}
	}
	if(right==""){
		window.wxc.xcConfirm("创建的角色赋予的权限不能为空!", window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	$("#addRoleRight").val(right);
	add_role()
});

//提交修改角色  
$("#edit_role_btn").on('click',function(){
	
    if(!webRolName("#rolename")) {
  	  return false
  	}
    
	//权限
	var right = "";
	var nodes = zTree.getCheckedNodes();
	for(var i=0;i<nodes.length;i++){
		var node = nodes[i];
		if(i==0){
			right=node.id;
		}else{
			right = right+","+node.id;
		}
	}
	if(right==""){
		var txt="修改角色赋予的权限不能为空!";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	$("#editRoleRight").val(right);
	edit_role();
});

function toaddRole(){
	document.getElementById("addrole_form").reset();
	jQuery("#resource-tree").empty();
	//角色
	$.ajax({ 
		url: "/creditsupport/role/toaddRole", 
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
				var menuEntitylList = responseText.menuEntitylList;
				if(menuEntitylList.length>0){
					citynodes =[];
					var markpid="";
					for(var i=0;i<menuEntitylList.length;i++){
						var id = menuEntitylList[i].menuId;
						var menuName = menuEntitylList[i].menuName;
						var pid = menuEntitylList[i].parentId;
						citynodes.push({
							id:id,
							pId : pid,
							name : menuName
						});
					}
				}
				zTree = $.fn.zTree.init($("#resource-tree"),setting, citynodes);
				/* var nodes = zTree.getNodes();
				if (nodes.length > 0) {
					$(nodes).each(function(i, item) {
						zTree.expandNode(item, true, false, true);
					})
				} */
			}
			if(-1==result){
				var txt="权限查询出现错误!";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			}
			return false;
    	}
    });
}
$('#cimc_role').bootstrapTable().on('post-body.bs.table',function(){
	pageHeight();
});
//  左侧按钮
$(".btn.closeLeft").on("click", function () {
	hideLeft();
	checkHeight("#roleManage")
});
$(".modal.fade").modal({show:false,keyboard:false});

</script>  
