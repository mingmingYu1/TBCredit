<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<style type="text/css">
  .noneRole {
    color: red;
    font-size: 16px;
    display: inline-block;
    margin-top: 6px;
    padding-left: 10px;
  }
</style>
<div class="row" id="userManage">
  <div class="col-xs-12 overflow" style="padding-left: 0;">
    <div class="hideBtn">
      <button class="btn closeLeft">
        <i class="icon-angle-left"></i> <!--   icon-angle-right  -->
      </button>
    </div>
    <div class="oneHeader">
      <!--<p class="title">指标体系</p>-->
      <p class="sumTitle"><a href="./system.jsp">系统管理</a> > 用户管理</p>
    </div>
  </div>
  <div class="col-xs-12 marginLeft">
    <div class="marginTop overflow">
      <div class="pull-left">
        <label for="user_query_type">类别：</label>
        <select class="form-control" id="user_query_type">
          <option value="0">全部</option>
          <option value="1">按部门</option>
          <option value="2">按角色</option>
          <option value="3">按姓名</option>
        </select>
      </div>
      <div class="pull-left" style="margin-left: 5%">
        <label for="user_condition">关键字：</label>
        <input type="text" class="form-control" id="user_condition" placeholder="请输入关键字">
        <button id="search_user_btn" class="btn" style="margin-left: 30px;">搜索</button>
        <button id="reset_user_btn" class="btn">重置</button>
      </div>
    </div>
    <div class="marginTop">
      <mrp:p rId="412">
        <button class="btn" data-toggle="modal" data-target="#userModal" onclick="toaddUser()">
          <span class="icon-plus"></span>&nbsp;&nbsp;新增
        </button>
      </mrp:p>
    </div>
    <div class="tableContainer">
      <div>
        <table id="cimc_user" data-toggle="table" data-cache="false" data-pagination=true data-side-pagination="server"
               data-url="/creditsupport/user/query" data-query-params="productQueryParams"
               class="table table-striped templatemo-user-table">
          <thead>
          <tr>
            <th data-field="userId" data-visible=false>主键</th>
            <th data-field="realName" data-width='20%' data-align="left">姓名</th>
            <th data-field="userName" data-width='20%' data-align="left">账户</th>
            <th data-field="deptName" data-width='20%' data-align="left">所属部门</th>
            <th data-field="roleName" data-title-tooltip="" data-width='20%' data-align="left">所属角色</th>
            <th data-field="status" data-visible=false>状态</th>
            <th data-field="operate_user" data-width='20%' data-align="right" data-formatter="operateFormatterUser"
                data-events="operateEventsUser">操作
            </th>
          </tr>
          </thead>
        </table>
      </div>
    </div>
  </div>
</div>


<!-- 用户添加页面 -->
<div class="modal fade" data-backdrop="static" id="userModal" tabindex="-1" role="dialog" aria-labelledby="userModalLabel" aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="userModalLabel">添加用户</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="user_form" action="/creditsupport/user/addUser" method="post">
          <div class="modalInput">
            <div>
              <label for="realName"><span>*</span>姓名：</label>
            </div>
            <div>
              <input type="text" class="form-control" id="addrealname" maxlength=20 name="realName" placeholder="不可含有除点以外的特殊字符且长度不可超过20位">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="userName"><span>*</span>用户名：</label>
            </div>
            <div>
              <input type="text" class="form-control" id="addusername" maxlength=20 name="userName"
                     placeholder="数字或字母或点号的组合，不能以点号开头，长度不超过20位">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="addpassword"><span>*</span>密码：</label>
            </div>
            <div>
              <input type="password" class="form-control" id="addpassword" maxlength="16" name="password"
                     placeholder="数字和字母的组合,长度8-16位" value="">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="adddid"><span>*</span>部门：</label>
            </div>
            <div>
              <select class="form-control" id="adddid" name="deptId">
                <option value="-1">请选择</option>
              </select>
            </div>
          </div>
          <div class="lastModalInput">
            <input type="hidden" id="adduserroleIds" name="roleIds" value=""/>
            <div class="onlyLabel">
              <label><span>*</span>角色：</label>
            </div>
            <div class="checkboxInput" id="addrolecodition">
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button id="save_user_btn" type="button" class="btn">创建</button>
        <button type="button" class="btn" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>

<!-- 用户编辑页面 -->
<div class="modal fade" data-backdrop="static" id="userEditModal" tabindex="-1" role="dialog" aria-labelledby="userEditModalLabel"
     aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="userEditModalLabel">编辑用户</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="user_edit_form" action="/creditsupport/user/updateUser"
              method="post">
          <input type="hidden" id="uid" name="userId" value="">

          <div class="modalInput">
            <div>
              <label for="realname"><span>*</span>姓名：</label>
            </div>
            <div>
              <input type="text" class="form-control" id="realname" maxlength=20 name="realName" placeholder="不可含有除点以外的特殊字符且长度不可超过20位">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="userName"><span>*</span>用户名：</label>
            </div>
            <div>
              <input type="text" class="form-control" id="username" name="userName" readonly="true">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="did"><span>*</span>部门：</label>
            </div>
            <div>
              <select class="form-control" id=did name="deptId">
                <option value="-1">请选择</option>
              </select>
            </div>
          </div>
          <div class="lastModalInput">
            <div class="onlyLabel">
              <label><span>*</span>角色：</label>
            </div>
            <div class="checkboxInput" id="rolecodition"></div>
            <input type="hidden" id="roleIds" name="roleIds" value=""/>
          </div>
          <div class="lastModalInput">
            <div class="onlyLabel">
              <label><span>*</span>状态：</label>
            </div>
            <div class="radioInput">
              <label class="checkbox-inline">
                <input type="radio" name="status" id="no-activate" value="0"> 冻结
              </label>
              <label class="checkbox-inline">
                <input type="radio" name="status" id="activate" checked="checked" value="1"> 激活
              </label>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button id="save_edit_user_btn" type="button" class="btn">保存</button>
        <button type="button" class="btn" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  var userId
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
        userId = data.data.userId
      }
    }
  });
  window.operateFormatterUser = function (value, row, index) {
    var arrHtml
    if(row.userId === 1 || row.userId === userId) {
      arrHtml = [
        '<mrp:p rId="411"><span class="disabledColor">重置密码</span></mrp:p>',
        '<mrp:p rId="413"><span class="disabledColor">&nbsp;&nbsp;编辑</span></mrp:p>',
        '<mrp:p rId="414"><span class="disabledColor">&nbsp;&nbsp;删除</span></mrp:p>'
      ]
    } else {
      arrHtml = [
        '<mrp:p rId="411"><a href="javascript:void(0)" class="user_resetPword" title="重置密码">重置密码</a></mrp:p>',
        '<mrp:p rId="413"><a href="javascript:void(0)" class="user_edit _edit" title="编辑">&nbsp;&nbsp;编辑</a></mrp:p>',
        '<mrp:p rId="414"><a href="javascript:void(0)" class="user_remove _remove" title="删除">&nbsp;&nbsp;删除</a></mrp:p>'
      ]
    }
    return arrHtml.join('');
  }
  window.operateEventsUser = {
    //编辑用户
    'click .user_edit': function (e, value, row, index) {
      var editdeptname = row.deptName;
      var editrolename = row.roleName;
      var status = row.status;
      if (status == 1) {
        $("#activate").attr("checked", true);
        $("#no-activate").attr("checked", false);
      } else {
        $("#no-activate").attr("checked", true);
        $("#activate").attr("checked", false);
      }
      jQuery("#did").empty();
      jQuery("#did").append("<option value='-1'>请选择</option>");
      //部门
      $.ajax({
        url: "/creditsupport/user/deptshow",
        type: "post",
        dataType: "json",
        cache: "false",
        success: function (responseText) {
          var result = responseText.result;
          if (-2 == result) {
            window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
            return false;
          }
          if (1 == result) {
            var deptList = responseText.deptList;
            if (deptList.length > 0) {
              for (var i = 0; i < deptList.length; i++) {
                var id = deptList[i].deptId;
                var deptname = deptList[i].deptName;
                if (editdeptname == deptname) {
                  jQuery("#did").append("<option selected = 'selected' value='" + id + "'>" + deptname + "</option>");
                } else {
                  jQuery("#did").append("<option value='" + id + "'>" + deptname + "</option>");
                }
              }
            }
          }
          if (-1 == result) {
          }
          return false;
        }
      });
      $("#rolecodition").text("");
      //角色
      $.ajax({
        url: "/creditsupport/user/roleshow",
        type: "post",
        dataType: "json",
        cache: "false",
        success: function (responseText) {

          var rolenames = editrolename.split(" | ");
          var result = responseText.result;

          if (-2 == result) {
            window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
            return false;
          }
          if (1 == result) {
            var roleList = responseText.roleList;
            var count = roleList.length;
            var links = "";
            if (count > 0) {
              for (var i = 0; i < count; i++) {
                if (row.userId !== 1 && roleList[i].roleId === 1) {
                  continue;
                }
                if (contain(rolenames, roleList[i].roleName))
                  links = links + "<label class='checkbox-inline'><input checked='checked' type='checkbox' name='roleId' value='" + roleList[i].roleId + "'>" + roleList[i].roleName + "</label> ";
                else
                  links = links + "<label class='checkbox-inline'><input type='checkbox' name='roleId' value='" + roleList[i].roleId + "'>" + roleList[i].roleName + "</label> ";
               
              }
            }
            jQuery("#rolecodition").append(links);
            $("#userEditModal").modal("show");
          }

          if (-1 == result) {
          }
          return false;
        },
        error: function () {
          $("#userEditModal").modal("show");
        }
      });
      $("#user_edit_form").autofill(row);
      $("#realname").val(htmlDecode(row.realName));
    },

    //删除用户
    'click .user_remove': function (e, value, row, index) {
      var txt = "您确定删除用户“" + row.userName + "”吗 ?";
      var option = {
        btn: parseInt("0011", 2),
        onOk: function () {
          var id = row.userId;
          var params = {'userId': id};
          $.ajax({
            url: "/creditsupport/user/deluser",
            type: "post",
            dataType: "json",
            cache: "false",
            data: params,
            success: function (responseText) {
              var result = responseText.result;
              if (-2 == result) {
                window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
                return false;
              }
              if (-1 == result) {
                window.wxc.xcConfirm(responseText.message, window.wxc.xcConfirm.typeEnum.info);
                return false;
              }
              if (1 == result) {
                var txt = "删除用户成功!";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
                setTimeout("finduser()", 500);
              } else {
                var txt = "删除出现异常!";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
              }
              return false;
            }
          });
        }
      }
      window.wxc.xcConfirm(txt, "custom", option);
    },
    //密码重置
    'click .user_resetPword': function (e, value, row, index) {
      //checkSession();
      var userid = row.userId;
      if (userid === 1) {
        var txt = "不能重置管理用户的密码!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      var option = {
			btn : parseInt("0011", 2),
			onOk : function() {
				$.ajax({
					url: '/creditsupport/user/resetPword',
					data: {userId: userid},
					dataType: 'json',
					success: function (data) {
						if(data.result == 1 ){
							window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
							return true;
						}
						if(data.result == -2 ){
							window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
					        return false;
						}
						if(data.result == -1 ){
							window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
							return false;
						}
					}
			   });
			}
		};
		window.wxc.xcConfirm("确定重置用户“" + row.userName + "”的密码吗？", "custom", option);      
	}//02069cd51a9535990d944faa83ee94b8
  };

  //      添加用户方法
  function add_user() {
	  $("#user_form").ajaxSubmit(function (data) {
      if (1 == data.result) {
        var txt = "保存新的用户成功!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        setTimeout("finduser()", 500);
        $("#userModal").modal("hide");
        document.getElementById("user_form").reset();
        return false;
      }
      if (-2 == data.result) {
        window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
        return false;
      }
      if (-1 == data.result) {
        window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
    });
  }

  //        修改用户的方法
  function edit_user() {
    $("#user_edit_form").ajaxSubmit(function (data) {
      if (1 == data.result) {
        var txt = "更新用户成功!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        setTimeout("finduser()", 500);
        $("#userEditModal").modal("hide");
        document.getElementById("user_edit_form").reset();
        return false;
      }
      if (-2 == data.result) {
        window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
        return false;
      }
      if (-1 == data.result) {
        window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
    });
  }

  //  前端验证
  function webCheck(realNameId, userNameId, passwordId, didNameId, checkboxName, checkboxId, states) {

    var regPassword = /^(?!\d+$)(?![a-zA-Z]+$)[0-9A-Za-z]+$/
    var regUserName = /^[0-9A-Za-z][0-9A-Za-z\.]*$/
    var w = /^([\u4E00-\u9FFF]|[\w]|[\.])+$/
    var realNameValue = $(realNameId).val()
    var userNameValue = $(userNameId).val()
    var passwordValue = $(passwordId).val()
    var didValue = $(didNameId).val()
    //  姓名验证
    if (realNameValue === "") {
      var txt = "姓名不能为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if (realNameValue.length > 20) {
      var txt = '姓名长度不可超过20位！';
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if (!w.test(realNameValue)) {
      var txt = '姓名不可含有除点号以外的特殊字符！';
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }

    //  用户名验证
    if (userNameValue === "") {
      var txt = "用户名不能为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if (userNameValue.length > 20) {
      var txt = '用户名长度不可大于20位！';
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if (!regUserName.test(userNameValue)) {
      var txt = '用户名必须为字母或数字或点号的组合且不能以点号开头！';
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }

    //  密码验证
    if (passwordValue === "") {
      var txt = "密码不能为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if (states === '新增') {
      if (passwordValue.length > 16 || passwordValue.length < 8) {
        var txt = '密码的长度为8-16位！';
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (!regPassword.test(passwordValue)) {
        var txt = '密码必须为字母和数字的组合！';
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if(passwordValue === userNameValue) {
        var txt = '用户名和密码不能相同！';
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
    }
    
    //  部门不可为空
    if (didValue == -1) {
      var txt = "部门不可为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    //   角色名称不可为空
    var roleId = "";
    $('input:checkbox[name="'+checkboxName+'"]:checked').each(function () {
      roleId += "," + $(this).val();
    });
    if (roleId == "") {
      var txt = "角色不可为 空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    roleId = roleId.substring(1);
    $(checkboxId).val(roleId);
  }

  //添加用户
  $("#save_user_btn").on('click', function () {
    if (webCheck('#addrealname', '#addusername', '#addpassword', '#adddid', 'addroleId', '#adduserroleIds', '新增') == false) {
      return false;
    }
    add_user();
  });

  //修改用户
  $("#save_edit_user_btn").on('click', function () {
    if (webCheck('#realname', '#username', '#password', '#did', 'roleId', '#roleIds', '编辑') == false) {
      return false;
    }
    edit_user()
  });

  //查询
  $("#search_user_btn").on("click", function () {
    finduser();
  });
  $("#user_condition").keydown(function (e) {
    if ($("#user_condition").val() !== "") {
      if (e.keyCode === 13) {
        e.preventDefault();
        finduser();
      }
    }
  });
  function finduser() {
    var query_type = $("#user_query_type").val();
    var condition = encodeURI($("#user_condition").val());
    var params = {query_type: query_type, condition: condition};
    $.ajax({
      url: "/creditsupport/user/query",
      type: "post",
      dataType: "json",
      cache: "false",
      data: params,
      success: function (responseText) {
        var result = responseText.result;
        if (-2 == result) {
          window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
          return false;
        }
        if (-1 == result) {
          var txt = "用户查询出现异常!";
          window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
          return false;
        }
        if (1 == result) {
          $('#cimc_user').bootstrapTable('getOptions').pageNumber = 1;
          $('#cimc_user').bootstrapTable('load', responseText);
        }
        return false;
      }
    });
  }
  $("#reset_user_btn").on("click", function () {
    $("#user_query_type").val(0);
    $("#user_condition").val("");
    finduser();
  });
  function productQueryParams(params) {
    params.query_type = $("#user_query_type").val();
    params.condition = $("#user_condition").val();
    return params;
  }
  function toaddUser() {
    var $addDid = $("#adddid")
    document.getElementById("user_form").reset();
    $addDid.empty();
    $addDid.append("<option value='-1'>请选择</option>");
    //部门
    $.ajax({
      url: "/creditsupport/user/deptshow",
      type: "post",
      dataType: "json",
      cache: "false",
      success: function (responseText) {
        var result = responseText.result;
        if (-2 == result) {
          window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
          return false;
        }
        if (1 == result) {
          var deptList = responseText.deptList;
          if (deptList.length > 0) {
            for (var i = 0; i < deptList.length; i++) {
              var id = deptList[i].deptId;
              var deptname = deptList[i].deptName;
              $addDid.append("<option value='" + id + "'>" + deptname + "</option>");
            }
          }
        }
        if (-1 == result) {}
        return false;
      }
    });

    $("#addrolecodition").text("");
    //角色
    $.ajax({
      url: "/creditsupport/user/roleshow",
      type: "post",
      dataType: "json",
      cache: "false",
      success: function (responseText) {
        var result = responseText.result;
        if (-2 == result) {
          window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
          return false;
        }
        if (1 == result) {
          var roleList = responseText.roleList;
          var count = roleList.length;
          var links = "";
          if (count > 0) {
            for (var i = 0; i < count; i++) {
              if (roleList[i].roleId == 1) {
                continue;
              }
              links = links + "<label class='checkbox-inline'><input type='checkbox' name='addroleId' value='" + roleList[i].roleId + "'>" + roleList[i].roleName + "</label> ";
            }
          }
          if(!links) {
            links = '<span class="noneRole">暂无可用角色，请去角色管理添加！</span>'
          }
          $("#addrolecodition").append(links);
        }
        if (-1 == result) {}
        return false;
      }
    });
  }
  function contain(array, obj) {
    var i = array.length;
    while (i--) {
      if (array[i] === obj) {
        return true;
      }
    }
    return false;
  }

  $('#cimc_user').bootstrapTable().on('post-body.bs.table', function () {
    pageHeight();
  });
  $(document).keydown(function (e) {
    if (e.keyCode === 13) {
      if ($('.xcConfirm').length == 0) {
        if ($('#userModal').css('display') === 'block') {
          e.preventDefault();
          if (addusercheck() == false) {
            return false;
          }
          add_user();
        }
        if ($('#userEditModal').css('display') === 'block') {
          e.preventDefault();
          if (editusercheck() == false) {
            return false;
          }
          edit_user()
        }
      }
    }
  });
  $(".modal.fade").modal({show: false, keyboard: false});
  //  左侧按钮
  $(".btn.closeLeft").on("click", function () {
    hideLeft();
    checkHeight("#userManage")
  });
</script>
