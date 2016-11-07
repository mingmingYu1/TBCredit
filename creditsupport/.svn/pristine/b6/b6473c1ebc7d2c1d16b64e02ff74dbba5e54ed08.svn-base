$(document).ready(function () {
	

  
  
 
  window.tablesEvents = {
    "click .indexReportLook": function (e, value, row, index) {
    	e.preventDefault();
        var href = $(this).attr("href");
        $("#score-report").load(href, {id: regId, compName: compName, algorithmType: algorithmType});
    }
  }
  setTable1("#indexReportAttrTable1", '/creditsupport/indicator-score/queryOneInfo', 1)
  setTable1("#indexReportAttrTable2", '/creditsupport/indicator-score/queryOneInfo', 2)
  mergeCells("#indexReportAttrTable1");
  mergeCells("#indexReportAttrTable2");

  function mergeCells(o) {
	$(o).bootstrapTable().on("post-body.bs.table", function () {
		if (score.length >= 2) {
		  var scoreAll = (+score[0])+(+score[1]);
		  $("#scoreAll").html(Math.round(scoreAll));
		  $("#allWeight").html("100%");
		  score = [];
		}
	  var data = $(o).bootstrapTable('getOptions').data;
	  if(data !== null && data.length > 0) {
		  var checkTopLevel = [];
          var checkFirstLevel = [];
          var isTrue = true;
          var cellsParmas = [];
          var rows = data;
          $(rows).each(function (index, dom){
            if (dom.topLevelcount > 1) {
              if (checkTopLevel.length > 0) {
                var obj = {index: index, field: "topLevel", rowspan: dom.topLevelcount};
                var topLevelCode = dom.topLevel;
                for (var i = 0; i < checkTopLevel.length; i++){
                  if (checkTopLevel[i] === topLevelCode) {
                    isTrue = false;
                    break;
                  }else {
                    isTrue = true;
                  }
                }
                if(isTrue) {
                  $(o).bootstrapTable('mergeCells',obj);
                  cellsParmas.push(obj);
                  checkTopLevel.push(topLevelCode);
                }
              } else {
                cellsParmas.push({index: index, field: "topLevel", rowspan: dom.topLevelcount});
                $(o).bootstrapTable('mergeCells',{index: index, field: "topLevel", rowspan: dom.topLevelcount});
                checkTopLevel.push(dom.topLevel);
              }
            }
            if(dom.firstLevelcount > 1) {
              if (checkFirstLevel.length > 0) {
                var obj1 = {index: index, field: "firstLevel", rowspan: dom.firstLevelcount};
                var firstLevelCode = dom.firstLevel;
                for (var j = 0; j < checkFirstLevel.length; j++){
                  if (checkFirstLevel[j] === firstLevelCode) {
                    isTrue = false;
                    break;
                  }else {
                    isTrue = true;
                  }
                }
                if(isTrue) {
                  $(o).bootstrapTable('mergeCells',obj1);
                  cellsParmas.push(obj1);
                  checkFirstLevel.push(firstLevelCode);
                }
              } else {
                cellsParmas.push({index: index, field: "firstLevel", rowspan: dom.firstLevelcount});
                $(o).bootstrapTable('mergeCells',{index: index, field: "firstLevel", rowspan: dom.firstLevelcount});
                checkFirstLevel.push(dom.firstLevel);
              }
            }
          });
	  } 
   })
  }
	//算法类型下拉列表
	$.ajax({
		url : "/creditsupport/scoreModel/queryAlgorithmType",
		type : "post",
		dataType : "json",
		cache : "false",
		success : function(responseText) {
			$("#algorithmType").html('');
			var result = responseText;
			if (result.length > 0) {
				for (var i = 0; i < result.length; i++) {
					var value = result[i].value;
					var name = result[i].name;
					if(value == algorithmType){
						$("#algorithmType").append("<option selected value='"+value+"'>" + name+ "</option>");
					} else {
						$("#algorithmType").append("<option value='"+value+"'>" + name+ "</option>");
					}
				}
			}
		}
	});
    
	function loadTable (o, url, params) {
	  $(o).bootstrapTable("showLoading");
	  $.ajax({
		 url: url,
         data: params,
         type: "POST",
         dataType: 'json',
         success: function (data) {
          $(o).bootstrapTable("hideLoading");
          $(o).bootstrapTable('load', data);
         }
	  })
	}
	$("#algorithmType").on('change', function () {
		var old = algorithmType;
		algorithmType = $("#algorithmType").val();
		//判断是否已生成评分报告，如果未生成，给出提示，否则，保存企业算法关联关系
		$.ajax({
			url : "/creditsupport/company-figure/checkAgentAlgor",
			type : "post",
			data: {
				regId: params.regId,
				algorithmType: algorithmType
			},
			dataType : "json",
			cache : "false",
			success : function(responseText) {
				var result = responseText;
				//选择的算法尚未生成评分报告，是否确定选择此算法
				if (result.code == 1) {
					var option = {
						closeBtn:false,
						btn: parseInt("0011",2),
						onOk: function(){
							saveAgentAlgor(params.regId, algorithmType);
							params = {regId: regId,compName: regId, algorithmType: algorithmType};
							$("#indexReportAttrTable1").bootstrapTable('load', {total:0, rows:[]});
							$("#indexReportAttrTable2").bootstrapTable('load', {total:0, rows:[]});
							$("#scoreAll").html("");
							$("#allWeight").html("");
						},
						onCancel:function(){
							$("#algorithmType").val(old);
							algorithmType = old;
						}
					};
					window.wxc.xcConfirm(result.message, "custom", option);

				} else if (result.code == 2){
					//保存关联关系
					saveAgentAlgor(params.regId, algorithmType)
					//有算法时显示新的算法结果
					params = {regId: regId,compName: regId, algorithmType: algorithmType, type: 1};
					loadTable("#indexReportAttrTable1", '/creditsupport/indicator-score/queryOneInfo', params)
					params.type = 2;
					loadTable("#indexReportAttrTable2", '/creditsupport/indicator-score/queryOneInfo', params)
				} else {
					//提示异常信息
					window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.info);
				}
			}
		});
	});

//保存新的算法企业关联关系
	function saveAgentAlgor(regId, algorithmType){
		$.ajax({
			url : "/creditsupport/company-figure/saveAgentAlgor",
			type : "post",
			data: {
				regId: regId,
				algorithmType: algorithmType
			},
			dataType : "json",
			cache : "false",
			success : function(responseText) {
				var result = responseText;
				if (result.code == 0) {
					window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.info);
				}
			}
		});
	}

	var titleBtn = $("#scoreReportBtn1").find(".btn.load");

	titleBtn.on("click", function (e) {
		e.preventDefault();
		var href = $(this).attr("href");
		$("#score-report").load(href, {regId: regId, compName: compName, algorithmType: algorithmType});
	});
	
	//  加载备注说明
	$.ajax({
        url: "/creditsupport/scoreLevel/queryScoeLevel",
        dataType: "json",
        success: function (data) {
          if(data !== null && data.rows.length > 0)
            var rows = data.rows;
            var ol = $("#indexReportAttrOl")
            $(rows).each(function (index, dom) {
              ol.append("<li>"+dom+"</li>")
            })
          }
       })

});




