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
          <li><a href="./person-manage.jsp">个人信息管理</a></li>
        </mrp:p>
       <mrp:p rId="3">
          <li><a href="./person-score-manage.jsp">评分模型</a></li>
        </mrp:p>
        <mrp:p rId="4">
          <li><a href="./system.jsp">系统管理</a></li>
        </mrp:p>
      </ul>
    </div>
    <div class="pull-right navText">
      <p>
        欢迎您 ，${sessionUser.realName} &nbsp;&nbsp; |  &nbsp;&nbsp;<a href="javascript:void(0)" class="logout">安全退出</a>
<!-- <span class="icon-cogs"></span> -->
      </p>
    </div>
  </div>
</div>
<script>
  var global = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/js/header/perHeader.js"></script>
