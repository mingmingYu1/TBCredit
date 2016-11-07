<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="${pageContext.request.contextPath}/css/cmxform.css"	rel="stylesheet">
<div class="row" id="indicatorManage">
	<div class="col-xs-12 overflow nonePaddingLeft">
		<div class="hideBtn">
			<button class="btn closeLeft">
				<i class="icon-angle-left"></i>     <!--   icon-angle-right  -->
			</button>
		</div>
		<div class="oneHeader">
			<p class="sumTitle"><a href="./person-score-manage.jsp">评分模型</a> > 指标体系</p>
		</div>
	</div>
	<div class="col-xs-12 marginLeft">
		<div class="searchInput overflow">
			<div class="pull-left">
				<label for="indicatorCode_condition">指标编号：</label>
				<input type="text" class="form-control" id="indicatorCode_condition" placeholder="请输入编号">
			</div>
			<div class="pull-left" style="margin-left: 200px;">
				<label for="indicatorName_condition">指标名称：</label>
				<input type="text" class="form-control" id="indicatorName_condition" placeholder="请输入名称">
			</div>
			<div class="pull-left marginTop">
				<label for="indicatorType_condition">指标类型：</label>
				<select class="form-control" id="indicatorType_condition">
                    <option value="">全部</option>
                </select>
				<button id="search_indicator_btn" class="btn">搜索</button>
				<button id="reset_indicator_btn" class="btn">重置</button>
			</div>
		</div>
		<div class="marginTop">
			<button class="btn" data-toggle="modal"	data-target="#indicatorModal" onclick="toaddIndicator()">
				<span class="icon-plus"></span>&nbsp;&nbsp; 新增
			</button>
		</div>
		<div class="tableContainer" id="controlOverflow">
			<div  class="table-responsive">
				<table id="indicator_table" data-toggle="table" data-cache="false" data-pagination=true data-side-pagination="server"
							 data-url="/creditsupport/indicator/query" class="table table-striped"
							 data-query-params="paginationParam">
					<thead>
					<tr>
						<th data-field="id" data-visible=false>主键</th>
						<th data-field="number" data-formatter="operateFormatterNumber" data-width='4%'>序号</th>
						<th data-field="indCode" data-sortable=true data-order="asc" data-align="left">指标编号</th>
						<th data-field="indName"  data-width='15%' data-title-tooltip="" data-align="left">指标名称</th>
						<th data-field="level1" data-sortable=true data-order="asc" data-align="left">lev1</th>
						<th data-field="level2" data-align="left">lev2</th>
						<th data-field="level3" data-align="left">lev3</th>
						<th data-field="level4" data-align="left">lev4</th>
						<th data-field="level5" data-align="left">lev5</th>
						<th data-field="level6" data-align="left">lev6</th>
						<th data-field="indDesc" data-title-tooltip="" data-align="left">指标描述</th>
						<th data-field="indAttrValue" data-title-tooltip="" data-align="left">行业属性</th>
						<th data-field="calaRegu" data-title-tooltip="" data-align="left">计算规则</th>
						<th data-field="statValue" data-align="left">定性/定量</th>
						<th data-field="calCycleValue" data-align="left">计算周期</th>
						<th data-field="operate_user" data-align="right"	data-formatter="operateFormatterIndicator"	data-events="operateEventsIndicator">操作</th>
					</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>


<!-- 新增、修改页面 -->
<div class="modal fade" id="indicatorModal" tabindex="-1" role="dialog"	aria-labelledby="indicatorModal" aria-hidden="true">
	<div class="modal-dialog"  style="width: 870px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="addIndicatorTitle">指标新增</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="indicator_form"	action="/creditsupport/indicator/update" method="post">
					<input type="hidden" id="indicator_id_manage" name="id" />
					<div class="modalOne overflow">
						<div>
							<label for="indicatorCode_manage"><span>*</span>指标编号：</label>
							<input class="form-control" type="text" id="indicatorCode_manage" name="indCode" placeholder="请输入指标编号" />
						</div>
						<div>
							<label for="indicatorName_manage"><span>*</span>指标名称：</label>
							<input class="form-control" type="text" id="indicatorName_manage"	name="indName" placeholder="请输入指标名称" />
						</div>
					</div>
					<div class="modalTwo overflow">
						<div>
							<input type="hidden" id="level1_manage" name="level1" />
							<label for="addIndicator-tree"><span>*</span>上级指标：</label>
						</div>
						<div class="ztreeContainer">
							<div class="ztree" id="addIndicator-tree"></div>
						</div>
					</div>
					<div class="modalThree overflow">
						<div>
							<label for="qualiQuanti_manage" style="padding-left:5px;">定性/定量：</label>
							<select class="form-control" id="qualiQuanti_manage" name="stat">
								<option value="0">定性</option>
								<option value="1">定量</option>
							</select>
						</div>
						<div>
							<label for="calculCycle_manage" style="padding-left:10px;">计算周期：</label>
							<select class="form-control" id="calculCycle_manage" name="calCycle"></select>
						</div>
					</div>
					<div class="modalThree overflow">
                        <div>
                            <label for="indTarget_manage" style="padding-left:5px;">&nbsp;对&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;象：</label>
                            <select class="form-control" id="indTarget_manage" name="indTarget">
                            </select>
                        </div>
                        <div>
                            <label for="indAttr_manage" style="padding-left:10px;">行业属性：</label>
                            <select class="form-control" id="indAttr_manage" name="indAttr"></select>
                        </div>
                    </div>
                    <div class="modalThree overflow">
                        <div>
                            <label for="ifEval_manage" style="padding-left:5px;">&nbsp;是否评分：</label>
                            <select class="form-control" id="ifEval_manage" name="ifEval">
                                <option value="0">是</option>
                                <option value="1">否</option>
                            </select>
                        </div>
                        <div>
                            <label for="unit_manage" style="padding-left:10px;">单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：</label>
                            <input class="form-control" id="unit_manage" name="unit" />
                        </div>
                    </div>
					<div class="modalFour overflow">
						<div>
							<label for="indicatorDesc_manage" style="padding-left: 10px;">指标描述：</label>
						</div>
						<div>
							<textarea class="form-control" id="indicatorDesc_manage" 	name="indDesc"></textarea>
						</div>
					</div>
					<div class="modalFive overflow">
						<div>
							<label for="calculRule_manage" style="padding-left: 10px; padding-top: 7px;">计算规则：</label>
						</div>
						<div>
							<textarea class="form-control" id="calculRule_manage"	name="calaRegu" placeholder="例如：（本月销量-上月销量）/本月销量*100"></textarea>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button id="submit_indicator_form"  type="button" class="btn" >创建</button>
				<button type="button"	class="btn" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>
<script src="../js/jquery.formautofill.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<script	src="${pageContext.request.contextPath}/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">

	function operateFormatterIndicator(value, row, index) {
		return  '<a href="javascript:void(0)"  class="indicator_remove _remove" title="删除">删除</a>';

	}
	function operateFormatterNumber(value, row, index) {
		return index+1;
	}


	//指标类型
	$.ajax({
		url : "/creditsupport/indicator/queryIndicatorType",
		type : "post",
		dataType : "json",
		cache : "false",
		success : function(responseText) {
			if (responseText != null && responseText != "") {
				var indicators = responseText;
				if (indicators.length > 0) {
					for (var i = 0; i < indicators.length; i++) {
						var id = indicators[i].id;
						var indiName = indicators[i].indiName;
						jQuery("#indicatorType_condition").append("<option value='"+id+"'>" + indiName+ "</option>");
					}
				}
			}
			return false;
		}
	});

	//搜索
	$("#search_indicator_btn").on("click", function() {
		search_indicator();
	});

	function search_indicator() {
		var indicatorCode = $("#indicatorCode_condition").val();
		var indicatorName = $("#indicatorName_condition").val();
		var level1 = $("#indicatorType_condition").val();
		var params = {
			indicatorCode : indicatorCode,
			indicatorName : indicatorName,
			level1 : level1
		};
		$.ajax({
			url : "/creditsupport/indicator/query",
			dataType : "json",
			cache : "false",
			type : "POST",
			data : params,
			success : function(responseText) {
				$('#indicator_table').bootstrapTable('load', responseText);
			}
		});
	}
	
	//设置分页查询条件
	function paginationParam(params) {
    var indCode = $("#indicatorCode_condition").val();
    var indName = $("#indicatorName_condition").val();
    var level1 = $("#indicatorType_condition").val();
    return {
      indicatorCode: indCode,
      indicatorName: indName,
      level1: level1,
      sort: params.sort,
      order: params.order,
      limit: params.limit,
      offset: params.offset//,
//       pageNumber: $('#listTable').bootstrapTable('getOptions').pageNumber
    };
  }
	
	//Enter键事件
	$("#indicatorName_condition").keydown(function(e) {
		if ($("#indicatorName_condition").val() !== "") {
			if (e.keyCode === 13) {
				e.preventDefault();
				search_indicator();
			}
		}
	});
	$("#indicatorCode_condition").on("change", function(e) {
		var value = $("#indicatorCode_condition").val();
        if (value !== "") {
        	var isValidate = true;
        	isValidate = checkData(isValidate, value, "指标编号", checkU);
        	isValidate = checkData(isValidate, value, "指标编号", checkLength, 10);
        	if(!isValidate){
        		$("#indicatorCode_condition").val('');
        	}
        }
    });
	$("#indicatorName_condition").on("change", function(e) {
        var value = $("#indicatorName_condition").val();
        if (value !== "") {
            var isValidate = true;
            isValidate = checkData(isValidate, value, "指标名称", checkLength, 100);
            if(!isValidate){
                $("#indicatorName_condition").val('');
            }
        }
    });
	$("#indicatorCode_condition").keydown(function(e) {
		if ($("#indicatorCode_condition").val() !== "") {
			if (e.keyCode === 13) {
				e.preventDefault();
				search_indicator();
			}
		}
	});
	$("#indicatorType_condition").keydown(function(e) {
		if ($("#indicatorType_condition").val() !== "") {
			if (e.keyCode === 13) {
				e.preventDefault();
				search_indicator();
			}
		}
	});

	//重置按钮
	$("#reset_indicator_btn").on("click", function() {
		$("#indicatorCode_condition").val("");
		$("#indicatorName_condition").val("");
		$("#indicatorType_condition").val("");
		$('#indicator_table').bootstrapTable('refresh', {url : "/creditsupport/indicator/query"});
	});

	//新增按钮
	function toaddIndicator() {
		$("#addIndicatorTitle").html("指标新增");
		$("#indicator_id_manage").val('');
		$("#indicatorCode_manage").val('');
		$("#indicatorName_manage").val('');
		$("#qualiQuanti_manage").val(0);
		$("#ifEval_manage").val(0);
		$("#unit_manage").val('');
		$("#indicatorDesc_manage").val('');
		$("#calculRule_manage").val('');
		createCateTree();
		createSelectByDict($("#calculCycle_manage"), '100002', '');
		createSelectByDict($("#indAttr_manage"), '100004', '');
		createSelectByDict($("#indTarget_manage"), '100003', '');
	}

	//新增、编辑页面树
	function createCateTree(id, level) {
		$.ajax({
			url : "/creditsupport/indicator/indicatorTree",
			type : "post",
			dataType : "json",
			data : {
				id : id
			},
			cache : "false",
			success : function(responseText) {
				zTree = $.fn.zTree.init($("#addIndicator-tree"), setting, responseText.treenodes);
				zTree.expandAll(true);
			}
		});
	}

	//ztree 设置
	var zTree;
	var setting = {
		check : {
			enable : true,
			chkStyle: "radio",
			radioType: "all"
		},
		view : {
			showIcon : true,
			showLine : true,
			showTitle : true,
			selectedMuti : true,
			expandSpeed : "fast",
			dblClickExpand : true
		},
		data : {
			simpleData : { //简单的数据源，一般开发中都是从数据库里读取，API有介绍，这里只是本地的
				enable : true,
				idKey : "id", //id和pid，这里不用多说了吧，树的目录级别
				pIdKey : "pid",
				rootPId : 0
			//根节点
			}
		},
		callback : {
			beforeClick : beforeClick,
			onCheck : onCheck,
			onClick : function(event, treeId, treeNode) {
				
				if(treeNode.level >= 6 && treeNode.nocheck){
					window.wxc.xcConfirm("不能选择第六级指标为上级指标",
                            window.wxc.xcConfirm.typeEnum.info);
                    return false;
				}
				if(treeNode.nocheck){
                    window.wxc.xcConfirm("不能选择指标本身为上级指标",
                            window.wxc.xcConfirm.typeEnum.info);
                    return false;
                }
				var treeObj = $.fn.zTree.getZTreeObj(treeId);
				treeObj.checkNode(treeNode, !treeNode.checked, true, true);
			}
		}
	};

	function beforeClick(treeId, treeNode) {
		//alert("beforeClick");
	}
	function onCheck(e, treeId, treeNode) {
	}
	//字典查询下拉列表
	function createSelectByDict(obj, category,selectValue) {
		obj.html('');
        //计算周期
        $.ajax({
            url : "/creditsupport/dict/query",
            type : "post",
            dataType : "json",
            data : {
                category : category
            },
            cache : "false",
            success : function(responseText) {
                var result = responseText;
                if (result.length > 0) {
                    for (var i = 0; i < result.length; i++) {
                        var value = result[i].value;
                        var name = result[i].name;
                        if (value == selectValue) {
                            obj.append("<option selected value='"+value+"'>"+ name + "</option>");
                        } else {
                            obj.append("<option value='"+value+"'>" + name+ "</option>");
                        }
                    }
                }
            }
        });
    }
	
	//  修改 、删除  逻辑
	window.operateEventsIndicator = {
		'click .indicator_edit' : function(e, value, row, index) {
			$("#addIndicatorTitle").html("评分模型编辑");
			$("#indicator_id_manage").val(row.id);
			$("#indicatorCode_manage").val(row.indCode);
			$("#indicatorName_manage").val(row.indName);
			$("#qualiQuanti_manage").val(row.stat);
			$("#indicatorDesc_manage").val(row.indDesc);
			$("#calculRule_manage").val(row.calaRegu);
			$("#ifEval_manage").val(row.ifEval);
	        $("#unit_manage").val(row.unit);
			createSelectByDict($("#calculCycle_manage"), '100002', row.calculCycle);
			createSelectByDict($("#indAttr_manage"), '100004', row.indAttr);
			createSelectByDict($("#indTarget_manage"), '100003', row.indTarget);
			createCateTree(row.id);
			$("#indicatorModal").modal("show");
		},
		//删除按钮
		'click .indicator_remove' : function(e, value, row, index) {
			var txt = "您确定删除吗 ?";
			var option = {
				btn : parseInt("0011", 2),
				onOk : function() {
					var id = row.id;
					var params = {
						'id' : id
					};
					$.ajax({
						url : "/creditsupport/indicator/delete",
						type : "post",
						dataType : "json",
						cache : "false",
						data : params,
						success : function(responseText) {
							if (responseText.code == 0) {
								$('#indicator_table').bootstrapTable('refresh',{url : "/creditsupport/indicator/query"});
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

	$("#submit_indicator_form").on('click', function() {
		if (indicatorCheck() == false) {
			return false;
		}
		$("#indicator_form").ajaxSubmit({
			type : 'post',
			success : function(result) {
				
				if (0 == result.code) {
					$("#indicatorModal").modal("hide");
					$('#indicator_table').bootstrapTable('refresh', {url : "/creditsupport/indicator/query"});
				}
				var txt = result.message;
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			}
		});
	});
	//校验
	function indicatorCheck() {
		//指标编号非空、非汉字及字段长度校验
		var indicatorName = $("#indicatorCode_manage").val();
		if (indicatorName == "") {
			window.wxc.xcConfirm("指标编号不可为空!", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if (isExistGBK(indicatorName)) {
			window.wxc.xcConfirm("指标编号不能含有汉字", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		if (!checkInputGBKLength(indicatorName, 10)) {
			window.wxc.xcConfirm("指标编号长度不可超过10个字符",	window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		//指标名称非空和字段长度校验
		var indicatorName = $("#indicatorName_manage").val();
		if (indicatorName == "") {
			window.wxc.xcConfirm("指标名称不可为空!",	window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if (!checkInputGBKLength(indicatorName, 100)) {
			window.wxc.xcConfirm("指标名称长度不可超过100个字符（中文为两个字符）", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		//上级指标
		var nodes = zTree.getCheckedNodes();
		if (nodes == null || nodes.length == 0) {
			var txt = "上级指标不可为空 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		} else if (nodes.length > 1){
			var txt = "只能选择一个上级指标 !";
			window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			return false;
		} else {
			$("#level1_manage").val(nodes[0].id);
		}
	    
		//单位长度校验
        var unit = $("#unit_manage").val();
        if (!checkInputGBKLength(unit, 16)) {
            window.wxc.xcConfirm("指标名称长度不可超过16个字符（中文为两个字符）",
                    window.wxc.xcConfirm.typeEnum.info);
            return false;
        }
		
		//指标描述长度校验
		var indicatorDesc = $("#indicatorDesc_manage").val();
		if (!checkInputGBKLength(indicatorDesc, 160)) {
			window.wxc.xcConfirm("指标名称长度不可超过160个字符（中文为两个字符）",
					window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		//计算规则长度校验	
		var calculRule = $("#calculRule_manage").val();
		if (!checkInputGBKLength(calculRule, 160)) {
			window.wxc.xcConfirm("指标名称长度不可超过160个字符（中文为两个字符）",	window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
	}

	$('#indicator_table').bootstrapTable().on('post-body.bs.table', function() {
		pageHeight();
	});

	$(".modal.fade").modal({
		show : false,
		keyboard : false
	});
//   左侧按钮
$(".btn.closeLeft").on("click", function () {
	hideLeft();
	checkHeight("#indicatorManage");
});
</script>
