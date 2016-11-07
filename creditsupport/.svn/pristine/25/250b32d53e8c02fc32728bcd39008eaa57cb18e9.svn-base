<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<style type="text/css">

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
      <button class="btn" data-toggle="modal" data-target="#userModal" onclick="toaddUser()">
        <span class="icon-plus"></span>&nbsp;&nbsp;新增
      </button>
    </div>
    <div class="tableContainer">
      <div>
        <table id="cimc_user" data-toggle="table" data-cache="false" data-pagination=true data-side-pagination="server"
               data-url="/creditsupport/personUser/query" data-query-params="productQueryParams"
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
<div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="userModalLabel" aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="userModalLabel">添加用户</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="user_form" action="/creditsupport/personUser/addUser" method="post">
          <div class="modalInput">
            <div>
              <label for="realName">姓名：</label>
            </div>
            <div>
              <input type="text" class="form-control" id="addrealname" maxlength=20 name="realName" placeholder="请输入姓名">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="userName">用户名：</label>
            </div>
            <div>
              <input type="text" class="form-control" id="addusername" maxlength=17 name="userName"
                     placeholder="请输入用户名">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="addpassword">密码：</label>
            </div>
            <div>
              <input type="password" class="form-control" id="addpassword" maxlength="16" name="password"
                     placeholder="请输入密码" value="">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="adddid">部门：</label>
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
              <label>角色：</label>
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
<div class="modal fade" id="userEditModal" tabindex="-1" role="dialog" aria-labelledby="userEditModalLabel"
     aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="userEditModalLabel">编辑用户</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="user_edit_form" action="/creditsupport/personUser/updateUser"
              method="post">
          <input type="hidden" id="uid" name="userId" value="">

          <div class="modalInput">
            <div>
              <label for="realname">姓名：</label>
            </div>
            <div>
              <input type="text" class="form-control" id="realname" maxlength=20 name="realName" placeholder="请输入姓名">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="userName">用户名：</label>
            </div>
            <div>
              <input type="text" class="form-control" id="username" name="userName" placeholder="请输入用户名"
                     readonly="true">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="did">部门：</label>
            </div>
            <div>
              <select class="form-control" id=did name="deptId">
                <option value="-1">请选择</option>
              </select>
            </div>
          </div>
          <div class="lastModalInput">
            <div class="onlyLabel">
              <label>角色：</label>
            </div>
            <div class="checkboxInput" id="rolecodition"></div>
            <input type="hidden" id="roleIds" name="roleIds" value=""/>
          </div>
          <div class="lastModalInput">
            <div class="onlyLabel">
              <label>状态：</label>
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
  function operateFormatterUser(value, row, index) {
    return [
          '<a href="javascript:void(0)"  class="user_edit _edit" title="编辑">编辑',
          '</a>&nbsp&nbsp',
          '<a href="javascript:void(0)"  class="user_remove _remove" title="删除">删除',
         '</a>'].join('');
//           <c:forEach items = "${roles}" var ="r" >
//     		</c:forEach>
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
        url: "/creditsupport/personUser/deptshow",
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
            ;

          }
          ;

          if (-1 == result) {
          }
          return false;
        }
      });

      $("#rolecodition").text("");
      //角色
      $.ajax({
        url: "/creditsupport/personUser/roleshow",
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
      
    },

    //删除用户
    'click .user_remove': function (e, value, row, index) {
      var txt = "您确定删除吗 ?";
      var option = {
        btn: parseInt("0011", 2),
        onOk: function () {
          var id = row.userId;
          var params = {'userId': id};
          $.ajax({
            url: "/creditsupport/personUser/deluser",
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
              if (0 == responseText.num) {
                var txt = "管理员角色不允许删除!";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
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
      checkSession();

      var userid = row.userId;
      if (userid === 1) {
        var txt = "不能重置管理用户的密码!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      document.getElementById("user_resetPword_form").reset();
      $("#user_resetPword_form").autofill(row);
      $("#resetPword").val("");
      $("#userResetPwordModal").modal("show");
    }
  };

  //      添加用户方法

  function add_user() {
    $("#user_form").ajaxSubmit(function (result) {

      
      if (-2 == result.result) {
        window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
        return false;
      }
      if (0 == result.num) {
        var txt = "密码不能为空!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (1 == result.num) {
        var txt = "密码不能小于6位!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (2 == result.num) {
        var txt = "用户名和密码不能相等!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (3 == result.num) {
        var txt = "用户名已经存在!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (4 == result.num) {
        var txt = "用户名不能为空!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (5 == result.num) {
        var txt = "建用户必须赋予角色!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (6 == result.num) {
        var txt = "普通用户不允许赋予管理员权限!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (7 == result.num) {
        var txt = "密码必须为数字和字母组合,且不能大于16位!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (8 == result.num) {
        var txt = "用户名必须为数字和字母开头,6到17位数字、字母或者下划线!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (9 == result.num) {
        var txt = "姓名不能为空!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }


      if (1 == result.result) {

        var txt = "保存新的用户成功!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        setTimeout("finduser()", 500);

        $("#userModal").modal("hide");
        document.getElementById("user_form").reset();

        return false;
      }

      if (-1 == result.result) {
        var txt = "保存新的用户信息异常!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }

    });
  }

  //        修改用户的方法
  function edit_user() {
    $("#user_edit_form").ajaxSubmit(function (result) {

      
      if (-2 == result.result) {
        window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
        return false;
      }

      if (1 == result.num) {
        var txt = "管理员用户不允许修改!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (0 == result.num) {
        var txt = "用户必须赋予角色!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (4 == result.num) {
        var txt = "用户名不能为空!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (6 == result.num) {
        var txt = "普通用户不允许赋予管理员权限!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (8 == result.num) {
        var txt = "用户名必须为数字和字母开头,6到17位数字、字母或者下划线!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (9 == result.num) {
        var txt = "姓名不能为空!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }

      if (1 == result.result) {
        var txt = "更新用户成功!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        setTimeout("finduser()", 500);

        $("#userEditModal").modal("hide");
        //$("#user_edit_form").reset();
        document.getElementById("user_edit_form").reset();

        return false;
      }

      if (-1 == result.result) {
        var txt = "更新用户信息异常!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }

    });
  }
  //      密码重置
  function pword_reset() {
    $("#user_resetPword_form").ajaxSubmit(function (result) {

      

      if (-2 == result.result) {
        window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
        return false;
      }

      if (3 == result.num) {
        var txt = "非管理员权限,不能重置密码!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }

      if (5 == result.num) {
        var txt = "不能重置管理用户的密码!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }

      if (4 == result.num) {
        var txt = "两次输入密码不一致!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (0 == result.num) {
        var txt = "密码不能为空!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (1 == result.num) {
        var txt = "密码不能小于6位!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (2 == result.num) {
        var txt = "用户名和密码不能相等!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
      if (7 == result.num) {
        var txt = "密码必须为数字和字母，且不能大于16位!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }


      if (1 == result.result) {
        var txt = "重置密码成功!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        setTimeout("finduser()", 500);

        $("#userResetPwordModal").modal("hide");
        document.getElementById("user_resetPword_form").reset();

        return false;
      }

      if (-1 == result.result) {
        var txt = "重置密码信息异常!";
        window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
        return false;
      }
    });
  }
  //添加用户
  $("#save_user_btn").on('click', function () {
    if (addusercheck() == false) {
      return false;
    }
    add_user();
  });

  //修改用户
  $("#save_edit_user_btn").on('click', function () {
    if (editusercheck() == false) {
      return false;
    }
    edit_user()
  });

  //提交重置密码
  $("#pword_reset_user_btn").on('click', function () {
    if (pword_reset_check() == false) {
      return false;
    }
    pword_reset()
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
  //   前端检验密码
  function pword_reset_check() {
    if ($("#resetPword1").val() == "" || $("#resetPword2").val() == "") {
      var txt = "重置密码不能为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }

    if ($("#resetPword1").val().length < 8 || $("#resetPword2").val().length < 8) {
      var txt = "密码不能少于8位!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }

    if ($("#resetPword1").val() != $("#resetPword2").val()) {
      var txt = "两次输入密码不同!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
  }
  function finduser() {
    var query_type = $("#user_query_type").val();
    var condition = $("#user_condition").val();
    var params = {query_type: query_type, condition: condition};
    $.ajax({
      url: "/creditsupport/personUser/query",
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

    document.getElementById("user_form").reset();
    jQuery("#adddid").empty();
    jQuery("#adddid").append("<option value='-1'>请选择</option>");
    //部门
    $.ajax({
      url: "/creditsupport/personUser/deptshow",
      type: "post",
      dataType: "json",
      cache: "false",
      success: function (responseText) {
        var result = responseText.result;
        if (-2 == result.result) {
          window.location.href = '${pageContext.request.contextPath}/jsp/login.jsp';
          return false;
        }
        if (1 == result) {

          var deptList = responseText.deptList;
          if (deptList.length > 0) {
            for (var i = 0; i < deptList.length; i++) {
              var id = deptList[i].deptId;
              var deptname = deptList[i].deptName;
              jQuery("#adddid").append("<option value='" + id + "'>" + deptname + "</option>");
            }
          }
          ;

        }
        ;

        if (-1 == result) {
        }
        return false;
      }
    });

    $("#addrolecodition").text("");
    //角色
    $.ajax({
      url: "/creditsupport/personUser/roleshow",
      type: "post",
      dataType: "json",
      cache: "false",
      success: function (responseText) {
        var result = responseText.result;
        if (-2 == result.result) {
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
          ;
          jQuery("#addrolecodition").append(links);

        }

        if (-1 == result) {
        }
        return false;
      },
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

  //编辑用户校验
  function editusercheck() {
    if ($("#realname").val() == "") {
      var txt = "姓名不能为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if ($("#username").val() == "") {
      var txt = "用户名不能为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if ($("#did").val() == -1) {
      var txt = "添加用户必须选择部门!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }

    var roleId = "";
    $('input:checkbox[name="roleId"]:checked').each(function () {
      roleId += "," + $(this).val();
    });
    if (roleId == "") {
      var txt = "添加用户必须选角色!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    roleId = roleId.substring(1);
    $("#roleIds").val(roleId);
  }

  function addusercheck() {
    if ($("#addrealname").val() == "") {
      var txt = "姓名不能为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if ($("#addusername").val() == "") {
      var txt = "用户名不能为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if ($("#addpassword").val() == "") {
      var txt = "密码不能为空!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if ($("#addpassword").val().length < 8) {
      var txt = "密码不能小于8位!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    if ($("#adddid").val() == -1) {
      var txt = "添加用户必须选择部门!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }

    var roleId = "";
    $('input:checkbox[name="addroleId"]:checked').each(function () {
      roleId += "," + $(this).val();
    });
    if (roleId == "") {
      var txt = "添加用户必须选角色!";
      window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
      return false;
    }
    roleId = roleId.substring(1);
    $("#adduserroleIds").val(roleId);
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
        if ($('#userResetPwordModal').css('display') === 'block') {
          e.preventDefault();
          if (pword_reset_check() == false) {
            return false;
          }
          pword_reset()
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
