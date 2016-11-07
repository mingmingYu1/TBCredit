<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ztree.all-3.5.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
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
			<button class="btn" data-toggle="modal" data-target="#addroleModal" onclick="toaddRole()">
				<span class="icon-plus"></span>&nbsp;&nbsp;新增
			</button>
		</div>
		<div class="tableContainer">
			<div>
				<table id="cimc_role" data-toggle="table" data-cache="false" data-pagination="true" data-pagination=true data-side-pagination="server"
							 data-url="/creditsupport/personRole/query" class="table table-striped templatemo-user-table">
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
<div class="modal fade" id="addroleModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true" >
	<div class="modal-dialog" style="width: 660px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">添加角色</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" method="post" id="addrole_form" action="/creditsupport/personRole/addRole">
					<div class="modalInput">
						<div>
							<label for="rolename">角色名称：</label>
						</div>
						<div>
							<input type="text" class="form-control" id="addrolename" maxlength=20 name="roleName" placeholder="请输入角色名称">
							<input type="text" class="form-control" style="display: none;"/>
						</div>
					</div>
					<div class="modalInput">
						<div>
							<label>权限：</label>
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
<div class="modal fade" id="roleModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true" >
	<div class="modal-dialog" style="width: 660px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="modalLabel">编辑角色</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" method="post" id="role_form" action="/creditsupport/personRole/updateRole">
					<input type="hidden" class="form-control" id="id" name="roleId">
					<div class="modalInput">
						<div>
							<label for="rolename" >角色名称：</label>
						</div>
						<div>
							<input type="text" class="form-control" id="rolename" maxlength=20 name="roleName" placeholder="请输入角色名称">
							<input type="text" class="form-control" style="display: none;"/>
						</div>
					</div>
					<div class="modalInput">
						<input type="hidden" id="editRoleRight" name="right" value=""/>
						<div>
							<label>权限：</label>
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

function operateFormatterRole(value, row, index) {
	return [
	    '<a href="javascript:void(0)" class="role_edit _edit" title="编辑">编辑',
	    '</a>&nbsp&nbsp',
	    '<a href="javascript:void(0)" class="role_remove _remove" title="删除">删除',
	    '</a>'
	].join('');
}
  
window.operateEventsRole = {
	'click .role_edit': function (e, value, row, index) {
		document.getElementById("role_form").reset();
		$("#role_form").autofill(row);
		jQuery("#edit-resource-tree").empty();
		var params = {"roleId":row.roleId};
		//角色
		$.ajax({ 
			url: "/creditsupport/personRole/toupdateRole", 
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
					if(menuList.length>0){
						citynodes =[];
						var markpid="";
						for(var i=0;i<menuList.length;i++){
							var id = menuList[i].menuId;
							var menuName = menuList[i].menuName;
							var pid = menuList[i].parentId;
							var isSelected = menuList[i].isSelected;
							
							citynodes.push({
								id:id,
								pId : pid,
								name : menuName
							});
							if(1==isSelected){
								arrays = arrays+","+id;
							}
						}
					};
					zTree = $.fn.zTree.init($("#edit-resource-tree"),setting, citynodes);
					arrays = arrays.substring(1);
					var ids = arrays.split(",");
					for(var i=0;i<ids.length;i++){
						var node = zTree.getNodeByParam("id", ids[i]);
						if(!node.isParent){
							zTree.checkNode(node,true,true);
						}
					}
				};
				
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
		var txt="您确定删除 ?";
		var option = {
			btn: parseInt("0011",2),
			onOk: function(){
					var id = row.roleId;
					var params = {'roleId':id};
					$.ajax({ 
						url: "/creditsupport/personRole/delRole", 
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
							var num = responseText.num;
							if(0==num){
								var txt="管理员不可删除!";
								window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
								return false;
							}
							if(1==num){
								var txt="该角色已被用户绑定,不允许删除!";
								window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
								return false;
							}
							if(1==result){
								var txt="删除角色成功!";
								window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
								setTimeout("findrole()",500);
							}else{;
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
		url: "/creditsupport/personRole/query", 
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
				$('#cimc_role').bootstrapTable('getOptions').pageNumber=1;
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
  		chkboxType: {"Y":"ps","N":"ps"}
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

//  添加角色方法

//     前端检验方法
function web_add_role() {

	$("#addrole_form").valid();
	
	if($("#addrolename").val()==""){
		var txt="请输入角色名称!";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
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
}

function add_role() {
	//提交
	$("#addrole_form").ajaxSubmit(function (result) {
		
		if(-2==result){
			window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
			return false;
		}
		if(0==result.num){
			var txt="角色名称不能为空!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		if(5==result.num){
			var txt="角色权限不能为空!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		if(7==result.num){
			var txt="角色名称不能大于20位!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(1==result.num){
			var txt="角色名重复!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		if(1==result.result){
			var txt="保存角色成功!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			$("#addroleModal").modal("hide");
			setTimeout("findrole()",500);
			return false;
		}
		if(1==result.result){
			var txt="保存角色出现异常!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}	
	});
}

//    编辑角色的方法

//  前端校验
function web_edit_role() {
	
}
function edit_role() {
	//提交
	$("#role_form").ajaxSubmit(function (result) {
		
		if(-2==result){
			window.location.href='${pageContext.request.contextPath}/jsp/login.jsp';
			return false;
		}
		if(2==result.num){
			var txt="管理员角色不允许修改!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(0==result.num){
			var txt="角色名称不能为空!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(5==result.num){
			var txt="角色权限不能为空!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if(7==result.num){
			var txt="角色名称不能大于20位!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		if(1==result.num){
			var txt="角色名重复!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		if(1==result.result){
			var txt="保存角色成功!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			$("#roleModal").modal("hide");
			setTimeout("findrole()",500);
			return false;
		}
		if(1==result.result){
			var txt="保存角色出现异常!";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		}	
	});
}

//提交创建角色  
$("#save_role_btn").on('click',function(){
	$("#addrole_form").valid();
	
	if($("#addrolename").val()==""){
		var txt="请输入角色名称!";
		window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
		return false;
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
	$("#role_form").valid();
	
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
		url: "/creditsupport/personRole/toaddRole", 
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
				};
				zTree = $.fn.zTree.init($("#resource-tree"),setting, citynodes);
			};
			
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
