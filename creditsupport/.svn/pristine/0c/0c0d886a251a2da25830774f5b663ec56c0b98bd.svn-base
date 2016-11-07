<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="" id="grossProfit">
	<div class="col-xs-12 marginLeft marginTop">
		<p class="sumTitle"> <a href="company-manage.jsp" class="returnIndex">企业管理 </a><a href="#" class="returnAs"> > 评分报告</a> > 指标评分</p>
		<p class="link marginTop">
			<a class="returnAs" href="#"> < 返回评分报告</a>
		</p>		
		<div id="grossProfitChart"></div>		
	</div>
</div>
<script>
  var compName = '<%=request.getParameter("compName")%>';
  var oddId = <%=request.getParameter("id")%>;
  var algorithmType = '<%=request.getParameter("algorithmType")%>';
  var isIndexReport = '<%=request.getParameter("isIndexReport")%>';
</script>
<script src="${pageContext.request.contextPath}/js/gross-profit.js"></script>