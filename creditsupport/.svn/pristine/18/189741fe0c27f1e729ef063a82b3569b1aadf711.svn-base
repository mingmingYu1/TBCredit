<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="row" id="scoreModelWeight">
  <div class="col-xs-12 overflow nonePaddingLeft">
    <div class="hideBtn">
      <button class="btn closeLeft">
        <i class="icon-angle-left"></i>     <!--   icon-angle-right  -->
      </button>
    </div>
    <div class="oneHeader">
      <p class="sumTitle"><a href="./person-score-manage.jsp">评分模型</a><a class="returnModel" href="./scoreModel-manage.jsp"> > 评分模型管理</a> > 算法展示</p>
    </div>
  </div>
  <div class="col-xs-12">
    <div class="scoreModelLine marginTop">
      <div id="scoreModelLine"></div>
    </div>
  </div>
</div>
<script>
  var modelCode = '<%=request.getParameter("modelCode")%>';
  var modelName = '<%=request.getParameter("modelName")%>';
</script>
<script src="${pageContext.request.contextPath}/js/scoreModel-weight.js"></script>