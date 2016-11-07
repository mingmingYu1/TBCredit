<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<div class="" id="capitalGrowth">
	<div class="col-xs-12 marginLeft marginTop">
		<p class="sumTitle"> <a href="company-manage.jsp" class="returnIndex">企业管理</a> > <a class="returnAs" href="javascript:viod(0)">评分报告</a>  > 指标评分</p>
		<p class="link marginTop">
			 <a class="returnAs" href="javascript:viod(0)">< 返回评分报告</a>
		</p>		
		<div id="capitalGrowthChart"></div>		
	</div>
</div>

<div id="alert" class="alert alert-info" style="display: none">提示： 注册资金不存在！</div>

<script>
	var compName = '<%=request.getParameter("compName")%>';
	var oddId = <%=request.getParameter("id")%>;
	var algorithmType = '<%=request.getParameter("algorithmType")%>';
	var isIndexReport = '<%=request.getParameter("isIndexReport")%>';
</script>
<script src="${pageContext.request.contextPath}/js/capital-growth.js"></script>

 