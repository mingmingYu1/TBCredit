<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
isELIgnored="false"%>
<%@taglib prefix="mrp" uri="http://www.baifendian.com/mrp"%>
<%
String path = request.getContextPath(); String basePath =
request.getScheme() + "://" + request.getServerName() + ":" +
request.getServerPort() + path + "/";
%>
<div class="row navColor">
  <div class="col-xs-12">
    <div class="pull-left logo"></div>
    <div class="pull-left navUl">
      <ul>
        <mrp:p rId="2">
          <li><a href="company-manage.jsp">企业管理</a></li>
        </mrp:p>
        <mrp:p rId="3">
          <li><a href="score-manage.jsp">评分模型</a></li>
        </mrp:p>
        <mrp:p rId="4">
          <li><a href="system.jsp">系统管理</a></li>
        </mrp:p>
      </ul>
    </div>
    <div class="pull-right navText" style="margin-top: 6px;">
      <p>
        欢迎您 ，${sessionUser.realName}&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#" style="color: #fff" data-toggle="modal" data-target="#updatePassword" onclick="updatePassword()">修改密码</a>&nbsp;&nbsp;<a href="javascript:void(0)" class="logout">安全退出</a>
<!-- <span class="icon-cogs"></span> -->
      </p>
    </div>
  </div>
</div>

<div class="modal fade" data-backdrop="static" id="updatePassword" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog" style="width: 660px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">修改密码</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="pwdForm" action="${pageContext.request.contextPath}/login/updatePassword" method="post">
          <div class="modalInput">
            <div>
              <label for="oldPasswordObj">原始密码：</label>
            </div>
            <div>
              <input type="password" class="form-control" maxlength="16" name="oldPassword"
                     id="oldPassword" placeholder="请输入原始密码" value="">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="newPasswordObj">新密码：</label>
            </div>
            <div>
              <input type="password" class="form-control" maxlength="16" name="newPassword"
                     id="newPassword" placeholder="8到16位字母（大小写都可）和数字的组合" value="">
            </div>
          </div>
          <div class="modalInput">
            <div>
              <label for="newPasswordObj2">确认密码：</label>
            </div>
            <div>
              <input type="password" class="form-control" maxlength="16" name="newPassword2"
                     id="newPassword2" placeholder="8到16位字母（大小写都可）和数字的组合" value="">
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn" onclick="submitPassword()">提交</button>
        <button type="button" class="btn" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>

<script>
  var global = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/js/header/header.js"></script>
