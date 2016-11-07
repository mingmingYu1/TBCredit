<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <!-- AB 绿色   CD 黄色  EF 红色 -->
  <div class="row" id="score-report">
        
  </div>
    <script>
      var compName = '<%=request.getParameter("compName")%>';
      var regId = <%=request.getParameter("regId")%>;
      var algorithmType = '<%=request.getParameter("algorithmType")%>';
    </script>
<script src="${pageContext.request.contextPath}/js/score-report.js"></script>

