$(document).ready(function() {



  var divs = $(".isShow");

  //  多选选中方法
  var checked = {
    isShowTitle: function () {
      var checkboxs = $("#checkboxs input[type=checkbox]")
      var checkedArr = []
      $('.isShow').hide();
      checkboxs.each(function() {
        if(this.checked === true) {
          checkedArr.push(this.name)
        }
      })
      $(checkedArr).each(function () {
        $('#'+this).show()
      })
    },
    oneChildren: function (id, clas) {
      var _self = this
      $(id).on('change', function() {
        if($(this).prop('checked')) {
          $(clas).prop('checked', true)
        } else {
          $(clas).prop('checked', false)
        }
        _self.isShowTitle()
      })
      $(clas).on('change', function () {
        var score = 0
        $(clas).each(function (i) {
          if($(this).prop('checked')) {
            score++
          }
        })
        if(score > 0) {
          $(id).prop('checked', true)
        } else {
          $(id).prop('checked', false)
        }
        _self.isShowTitle()
      })
    },
    twoChildren: function (id1, id2, id3) {
      var _self = this
      //  第一个参数为三层中一级的标题id， 后面的参数为所有二级标题的id
      var firstArguments = arguments[0]
      var arrArg = [];
      for(var i =0; i < arguments.length; i++) {
        if(i !== 0) { arrArg.push(arguments[i]) }
      }
      //   给第一层绑定事件处理逻辑
      $(id1).on('change', function() {
        if($(this).prop('checked')) {
          for(var i=0; i<arrArg.length; i++) {
            $(arrArg[i]).prop('checked', true)
            $(arrArg[i]).parent().parent().siblings().find('input').prop('checked', true)
          }
        } else {
          for(var i=0; i<arrArg.length; i++) {
            $(arrArg[i]).prop('checked', false)
            $(arrArg[i]).parent().parent().siblings().find('input').prop('checked', false)
          }
        }
        _self.isShowTitle()
      })

      //  给第二层绑定事件处理逻辑
      for(var i=0; i<arrArg.length; i++) {
        $(arrArg[i]).on('change', function(j) {
          if($(this).prop('checked')) {
            $(firstArguments).prop('checked', true)
            $(this).parent().parent().siblings().find('input').prop('checked', true)
          } else {
            var score = 0;
            $(this).parent().parent().siblings().find('input').prop('checked', false)
            for(var i =0; i < arrArg.length; i++) {
              //  判断所以二级标题是否选中即可确定当前是否有选中，来控制一级标题是否不选中
              if($(arrArg[i]).prop('checked')) {
                score++
              }
            }
            if(score <= 0) {
              $(firstArguments).prop('checked', false)
            }
          }
          _self.isShowTitle()
        })
      }

      //   给第三层绑定事件处理逻辑

      for(var i=0; i<arrArg.length; i++) {
        var $children = $(arrArg[i]).parent().parent().siblings().find('input');
        $children.on('change', function() {
          if($(this).prop('checked')) {
            $(this).parent().parent().parent().find('div').eq(0).find('input').prop('checked', true)
            $(firstArguments).prop('checked', true)
          } else {
            // 判断当前二级标题下是否还有选中的input
            var score = 0
            //   得到当前所以的同辈input的集合
            var $levenTwo = $(this).parent().parent().parent().find('div').eq(0).siblings().find('input')
            //   判断当前一级下面的二级标题是否有选中
            $levenTwo.each(function (i) {
              if($(this).prop('checked')) {
                score++
              }
            })
            if(score <= 0) {
              $(this).parent().parent().parent().find('div').eq(0).find('input').prop('checked', false)
            }
            //     判断当前一级下面的二级标题是否有选中
            var oneScore = 0
            for(var i =0; i < arrArg.length; i++) {
              //  判断所以二级标题是否选中即可确定当前是否有选中，来控制一级标题是否不选中
              if($(arrArg[i]).prop('checked')) {
                oneScore++
              }
            }
            if(oneScore <= 0) {
              $(firstArguments).prop('checked', false)
            }
          }
          _self.isShowTitle()
        })
      }
    }
  }

  //  设置标题title跟动态生成多选框
  function checkAll(titleData) {
    var strContainer = ''
    $(titleData).each(function(i, dom) {
      var str = ''
      str += '<div><div><label class="checkbox-inline"><input id="check'+String(i+1)+'" class="check" type="checkbox" name='+this.key+'>'+this.name+'</label></div><div>'
      $('#'+this.key).children().eq(0).html(this.name)
      if(dom.children) {
        $(dom.children).each(function(j, childDom) {
          if(childDom.children) {
            //  此为有三级
            str += '<div><div><label class="checkbox-inline"><input id="check'+String(i+1)+String(j+1)+'" type="checkbox" name='+this.key+'>'+this.name+'</label></div><div>'
            $('#'+this.key).children().eq(0).html(this.name)
            $(childDom.children).each(function(n, childChildDom) {
              if(dom.children.length === j+1) {
                //   一级的最后一个children
                if(childDom.children.length === n+1) {
                  //   此为一级最后一个children中最后一个children
                  str += '<label class="checkbox-inline"><input class="checkChild" type="checkbox" name='+this.key+'>'+this.name+'</label></div></div></div></div>'
                  $('#'+this.key).children().eq(0).html(this.name)
                } else {
                  str += '<label class="checkbox-inline"><input class="checkChild" type="checkbox" name='+this.key+'>'+this.name+'</label>'
                  $('#'+this.key).children().eq(0).html(this.name)
                }
              } else {
                //  同上
                if(childDom.children.length === n+1) {
                  str += '<label class="checkbox-inline"><input class="checkChild" type="checkbox" name='+this.key+'>'+this.name+'</label></div></div>'
                  $('#'+this.key).children().eq(0).html(this.name)
                } else {
                  str += '<label class="checkbox-inline"><input class="checkChild" type="checkbox" name='+this.key+'>'+this.name+'</label>'
                  $('#'+this.key).children().eq(0).html(this.name)
                }
              }
            })
          } else {
            //    此为只有二级
            if(dom.children.length === j+1) {
              $('#'+this.key).children().eq(0).html(this.name)
              str += '<label class="checkbox-inline"><input class="checkChild'+String(i+1)+'" type="checkbox" name='+this.key+'>'+this.name+'</label></div></div>'
            } else {
              $('#'+this.key).children().eq(0).html(this.name)
              str += '<label class="checkbox-inline"><input class="checkChild'+String(i+1)+'" type="checkbox" name='+this.key+'>'+this.name+'</label>'
            }
          }
        })
      }
      strContainer += str
    })
    $('#checkboxs').append(strContainer)
  }

  // 请求获取标题信息
  $.ajax({
    url: "/creditsupport/reportTemplet/getAllTempletTitle ",
    dataType:"json",
    cache:"false",
    success: function(res){
      if(res.code == 0) {
        checkAll(res.data)
        $('input[name=basic]').prop('checked', true).attr('disabled', true)
        $('input[name=basicInfo]').prop('checked', true).attr('disabled', true)
        //   调用选中方法  ---  每个层级调用一次
        //  一、基本信息
        checked.oneChildren('#check1', '.checkChild1')
        //  二、财务信息
        checked.oneChildren('#check2', '.checkChild2')
        //  三、税务信息
        checked.oneChildren('#check3', '.checkChild3')
        //四、交易信息
        checked.oneChildren('#check4', '.checkChild4')
        //  五、高管商旅信息
        checked.twoChildren('#check5', '#check51', '#check52')
        //  六、特殊事项信息
        checked.twoChildren('#check6', '#check61', '#check62', '#check63', '#check64')
        // 七、法院信息
        checked.oneChildren('#check7', '.checkChild7')
        // 八、评分信息
        checked.oneChildren('#check8', '.checkChild8')
      } else {
        window.wxc.xcConfirm(res.message, window.wxc.xcConfirm.typeEnum.info);
      }
    }
  });

  var radioGroup = []
  //获得报告类别
  $.ajax({
    url: "/creditsupport/dict/query",
    type: "post",
    dataType: "json",
    data: {category: '100020'},
    success: function (data) {
      if(data.length > 0) {
        var $reportCategory = $("#reportCategory")
        var str = ""
        $(data).each(function (i, dom) {
          var s = '<label class="checkbox-inline"><input type="radio" name="type" value="'+dom.value+'"/>'+dom.name+'</label>'
          str += s
        })
        $reportCategory.html(str)
      } else {
        window.wxc.xcConfirm("连接失败或服务器内部错误，请稍后再试！", window.wxc.xcConfirm.typeEnum.info);
      }
      radioGroup = $("#creditReportModelModal input:radio[name=type]"); // 报告类别单选按钮组
    }
  })

  window.creditReportEvents = {
    //   编辑
    'click .modelEdit': function (e, value, row, index) {
      $("input[type=checkbox]").prop("checked", false);
      $('.isShow').hide();
      var modelList = JSON.parse(row.moduleList);
      for(key in modelList) {
        $('#checkboxs input[name='+key+']').prop('checked',true)
        $('#'+key).show()
      }
      //var module_list=row.moduleList;
      //module_list=module_list.substring(1,module_list.length-1).split(",");
      //var tempChecked=0;
      //for(var i=0;i<module_list.length;i++){
    	 // var kv=module_list[i].split(":");
    	 // var mid = kv[0].replace(/\"/g,"");
    	 // if(kv[1]==0){
    		//  $("input[name="+kv[0]+"]").prop("checked",false);
    		//  $("#"+mid).hide();
    	 // } else if(kv[1]==1) {
    		//  $("input[name="+kv[0]+"]").prop("checked",true);
    		//  var s = $("#"+mid);
    		//  var temp=$(".pull-left",s);
   		//   	  var tempWords=temp.html().substring((tempChecked<9?2:3),temp.html().length);//由于编号是和后面的内容写在同一个标签里面的，所以我使用了截取。
   		//   	  temp.html(++tempChecked+"、"+tempWords);
    		//  s.show();
    	 // }
      //}
      $("#addScoreModelTitle").html("编辑");
      $("#subModel").html("保存")
      $("#modelId").val(row.id);
      // 初始化选中
      radioGroup.each(function() {
        if($(this).val() == row.type) {
          $(this).prop('checked', true)
        }
      })
      $("#creditReportModelModal input[name=modelName]").val(htmlDecode(row.name));
	    $("#creditReportModelModal input[name=modelNumber]").val(htmlDecode(row.number));
	    $("#creditReportModelModal textarea[name=declare]").val(htmlDecode(row.declare));
      $("#creditReportModelModal").modal("show");
      $.ajax({
        url: "/creditsupport/login/checkSession?_time"+new Date().getTime(),
        type:"post",
        dataType:"json",
        cache:"false",
        success: function(responseText){
          if(responseText.code == -1){
            var option = {
              closeBtn: false,
              btn: parseInt("0001",2),
              onOk: function(){
                window.location.href = "/creditsupport/jsp/login.jsp";
              },
              onClose:function(){
                window.location.href = "/creditsupport/jsp/login.jsp";
              }
            };
            window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
            return false;
          }
        }
      });
    },

    //删除
    'click .modelRemove': function (e, value, row, index) {
      var id = row.id;
      var txt="您确定删除吗 ?";
	    var option = {
	      btn: parseInt("0011",2),
	      onOk: function(){
        var id = row.id;
        var params = {'id':id};
			  $.ajax({
				  url: "/creditsupport/reportTemplet/delete",
				  type:"post",
				  dataType:"json",
				  cache:"false",
				  data:params,
				  success: function(responseText){
					  if(responseText.code == 0) {
              $('#modelTable').bootstrapTable('refresh', {url: "/creditsupport/reportTemplet/query"});
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

  //    因为做类似表格的时候用input的布局，所以需要禁用input的框
  $("#concentModel input, #concentModel textarea").attr("readonly", "readonly");

  //  新增按钮
  $("#addModel").on("click", function () {
    addmodel()
  });

function addmodel() {
  $("#addScoreModelTitle").html("新增");
  $("#modelId").val("");
  radioGroup.prop("checked",false);	// 取消选中 用户必须亲自选一个
  $("#creditReportModelModal input[name=modelName]").val("");
  $("#creditReportModelModal input[name=modelNumber]").val("");
  $("#creditReportModelModal textarea[name=declare]").val("");
  $("#checkboxs input[type=checkbox]").prop("checked",true);
  $(".isShow").show();
  $.ajax({
    url: "/creditsupport/login/checkSession?_time"+new Date().getTime(),
    type:"post",
    dataType:"json",
    cache:"false",
    success: function(responseText){
      if(responseText.code == -1){
        var option = {
          closeBtn: false,
          btn: parseInt("0001",2),
          onOk: function(){
            window.location.href = "/creditsupport/jsp/login.jsp";
          },
          onClose:function(){
            window.location.href = "/creditsupport/jsp/login.jsp";
          }
        };
        window.wxc.xcConfirm("用户已失效，请重新登陆。", "custom", option);
        return false;
      }
    }
  });
  //divs.each(function (index) {
  //  var nums = $("input[type=checkbox]");
  //var tempChecked=0;//用于给选中的checkbox对应的模块赋值
  //for(var i=0;i<divs.length;i++){
	 // var temp=$(".pull-left",divs.eq(i));
	 // var tempWords=temp.html().substring((tempChecked<9?2:3),temp.html().length);//由于编号是和后面的内容写在同一个标签里面的，所以我使用了截取。
	 // temp.html(++tempChecked+"、"+tempWords);//如果被选中，就把tempChecked增加1,来改变编号，后面的文字不变
	 //}
  //}).show();
}

$("#creditReportModelModal").on("shown.bs.modal", function () {
  $("#creditReportModelModal input[name=modelNumber]").focus()
});

$table.bootstrapTable().on('post-body.bs.table',function(){
  pageHeight();
});

  //  隐藏按钮
$("#modelContainer").find(".btn.closeLeft").on("click", function () {
    hideLeft();
    checkHeight("#modelContainer");
  })
});

function clearSearch(){
  $("#modelName").val("");
  $("#modelNumber").val("");
  $('#modelTable').bootstrapTable('refresh',{url: "/creditsupport/reportTemplet/query"});
}
//查询
function creditReportModelSelect() {
  var modelName=$("#modelName").val();
  var modelNumber=$("#modelNumber").val();
  var params = {"name":modelName,"number":modelNumber};
  $.ajax({
    url: "/creditsupport/reportTemplet/query",
    type:"post",
    dataType:"json",
    cache:"false",
    data:params,
    success: function(responseText){
   	 $('#modelTable').bootstrapTable('load', responseText);
    }
  });
};

//新增、编辑页面树
function createReportModel() {
	var checkboxs = $("#checkboxs input[type=checkbox]");
	var module_list="";
	for(var i=0;i<checkboxs.length;i++){
		if(checkboxs[i].checked==true){
			module_list+="\""+checkboxs[i].name+"\""+":1,";
		}else{
			module_list+="\""+checkboxs[i].name+"\""+":0,"
		}
	}
	module_list="{"+module_list.substring(0,module_list.length-1)+"}";
	var modelName = $.trim($("#creditReportModelModal input[name=modelName]").val());
	var modelNumber = $.trim($("#creditReportModelModal input[name=modelNumber]").val());
	var declare = $.trim($("#creditReportModelModal textarea[name=declare]").val());
	var radioType = $('#creditReportModelModal input:radio[name="type"]:checked').val();
    if(modelNumber == ""){
        window.wxc.xcConfirm("模板编号不能为空", window.wxc.xcConfirm.typeEnum.info);
        return false
    }
    if(!checkNumber(modelNumber, '模板编号')) {
        return false;
    }
	if(modelName == ""){
	    window.wxc.xcConfirm("模板名称不能为空", window.wxc.xcConfirm.typeEnum.info);
	    return false;
	}
	if(!checkNameString(modelName, '模板名称')) {
	    return false
	}
	if(!checkLength(modelName, '模板名称', 20)){
		return false;
	}
    if(!radioType) {
	  window.wxc.xcConfirm("报告类别不能为空！", window.wxc.xcConfirm.typeEnum.info);
	  return false;
    }
    if(declare == ""){
      window.wxc.xcConfirm("重要声明不能为空", window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if(!checkLength(declare, '重要声明', 400)){
		return false;
	}
	$.ajax({
		url : "/creditsupport/reportTemplet/update",
		type : "post",
		dataType : "json",
		data : {
			"moduleList" : module_list,
			"name":modelName,
			"number":modelNumber,
			"declare":declare,
			"id":$("#modelId").val(),
			"type": radioType
		},
		cache : "false",
		success : function(responseText) {
			if(responseText.code == 0) {
			 $("#creditReportModelModal").modal("hide");
			 $('#modelTable').bootstrapTable('refresh', "/creditsupport/reportTemplet/query");
			 window.wxc.xcConfirm(responseText.message, window.wxc.xcConfirm.typeEnum.info);		 
			} else {
        window.wxc.xcConfirm(responseText.message, window.wxc.xcConfirm.typeEnum.info);
      }
		}
	});
}

