<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="row" id="creditReportDetail">
  <div class="col-xs-12 marginLeft marginTop">
    <div>
      <p class="sumTitle"><a href="person-manage.jsp" class="returnIndex">个人管理</a> <a class="backA" href="javascript:void(0)">&lt;征信报告列表</a> &lt;征信报告</p>
    </div>
    <div class="basicContainer">
      <div style="overflow: hidden;margin-top: -10px;padding-bottom: 0;">
        <p class="link pull-left" >
          <a class="backA" href="javascript:void(0)">&lt; 返回征信报告列表</a>
        </p>
        <div class="pull-right aIcon">
          <a class="pdf_btn" href="/creditsupport/js/pdfjs/generic/web/viewer.html?file=/creditsupport/person${filePath}" target="_blank" title="预览/打印"><span class="icon-eye-open" ></span></a>
          <a class="pdf_btn" href="/creditsupport/person${filePath}" title="下载PDF"><span class="icon-file-alt" ></span></a>
        </div>
      </div>
      <div class="text-center creditReportDetailTitle" style="padding-bottom: 0;">${data.name}征信报告 </div>
      <div class="text-center" style="margin-top: 10px;padding-bottom: 0">
        <div class="leftModal overflow" style="display: inline-block;">
			<div class="pull-left">
			<label style="margin-top: 3px">报告类别：</label>
			</div>
			<div class="radioInput pull-left">	
			  <label class="checkbox-inline">
				<input type="radio" name="type" disabled ${reportType == 1?"checked" : ""}/>授信
			  </label>
			 <!--  <label class="checkbox-inline">
				 <input type="radio" name="type" disabled ${reportType == 2 ? "checked" : ""}/>贷款
			 </label> -->
			  <label class="checkbox-inline" style="margin-right: 0;">
			  
				<input type="radio" name="type" disabled ${reportType == 3 ? "checked" : ""}/>交易
			</label>
		 </div>
		</div>
      </div>
      <div class="text-center marginTopSmall" style="padding-bottom:0">
        <label>算法名称:</label><span>&nbsp;&nbsp;${algor}</span>
      </div>
      <div class="row" style="padding-bottom: 15px;">
        <div class="col-xs-4 col-xs-offset-8">
          <div class="pull-right reportNumber">
            报告编号：<span>${data.cardId}</span>
          </div>
        </div>
         <%-- <div class="col-xs-4 col-xs-offset-8">
          <div class="pull-right reportNumber">
            生成时间：<span><fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd HH:mm"/></span>
          </div>
        </div> --%>
      </div>
      <div class="creditReportListTitle">
        
        <div style="padding: 0 13px;">
          
         <div style="padding: 14px 0;border-bottom: 1px solid #dfe8f1">
            <div class="row">
              <div class="col-xs-6">
                <div class="dengJi pull-right">
                  信用等级：<span class="textColor"></span>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="deFen">
                  信用得分：<span class="textColor"> </span>
                </div>
              </div>
            </div>
          </div> 
       
        
          <div>
            <div class="marginTop">
              <label>报告内容：</label>
            </div>
            <div class="spans" style="padding-left: 80px;padding-bottom: 15px;">
           <%--  <c:forEach items="${repItemList}" var="item" varStatus="status">
            	<span>${item}</span>
            </c:forEach> --%>
            <span>一、基本信息</span>
            <br />
            <span>二、驾驶证信息</span>
            <br />
            <span>三、个人对外投资信息</span>
            <br />
             &nbsp;&nbsp;<span>3.1、失信被执行人</span><span>3.2、被执行人</span> <span>3.3、企业法定代表人</span><span>3.4、管理人员</span>
             <span>3.5、企业股东</span>  
            <br />
            <span>四、个人司法信息</span>
            <br/>
             &nbsp;&nbsp;<span>4.1、曝光台</span><span>4.2、裁判文书</span> <span>4.3、失信公告</span><span>4.4、网贷黑名单</span>
             <span>4.5、执行公告</span>  
             <br />
            <span>五、阿里欠贷信息</span>
            <br/>
            <span>六、银联三要素验证信息</span>
            <br />
            <span>七、个人消费信息</span>
            <br />
             &nbsp;&nbsp;<span>7.1、资产状况及交易行为</span><span>7.2、消费大类分布</span> <span>7.3、城市消费状况</span><span>7.4、每月消费状况</span>
             <span>7.5、消费行为</span> <span>7.6、信用相关交易统计</span>  
             <br />
            </div>
          </div>
         
         <%--  <div  style="padding-bottom: 20px;">
            <div>
              <label>评分简述：</label>
            </div>
            <div class="scoreDetail">
              <span>征信报告总评分由通用信息评分和行业信息评分组成：</span>
            </div>
            
            <c:choose>
            	<c:when test="${score != null}">
            <div class="scoreDetail">
              <span>通用信息占总评分权重：</span><span class="red">${score.score1Weight}</span><span>在总评分中计分：</span><span class="red">${score.score1}</span><span>按百分制单独评分：</span><span class="red">${score.score1Per}</span>
            </div>
            <div class="scoreDetail">
              <span>行业信息占总评分权重：</span><span class="red">${score.score2Weight}</span><span>在总评分中计分：</span><span class="red">${score.score2}</span><span>按百分制单独评分：</span><span class="red">${score.score2Per}</span>
            </div>
            	</c:when>
            	<c:otherwise>
            <div class="scoreDetail">
              <span>通用信息占总评分权重：</span><span class="red">${data.score1Weight}</span><span>在总评分中计分：</span><span class="red">${data.score1}</span><span>按百分制单独评分：</span><span class="red">${data.score1Per}</span>
            </div>
            <div class="scoreDetail">
              <span>行业信息占总评分权重：</span><span class="red">${data.score2Weight}</span><span>在总评分中计分：</span><span class="red">${data.score2}</span><span>按百分制单独评分：</span><span class="red">${data.score2Per}</span>
            </div>
            	</c:otherwise>
            </c:choose>
            <div class="scoreDetail">
              <span>(详见评分报告)</span>
            </div>
          </div> --%>
        
        </div>
      </div>
      
      <div class="tables">
       <div class="basicText">
          <c:set var="titleIndexFather" value="${titleIndexFather+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}、基本信息</div>
        </div>
      
      <div id="agent-base" >
        <div class="tableContainer">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight">
                  <label>
                    姓名
                  </label>
                </div>
                <div class="col-xs-9 nonePaddingLeft">
                  <input type="text" value="${data.name}" placeholder=""/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight">
                  <label>
                    身份证号
                  </label>
                </div>
                <div class="col-xs-9 nonePaddingLeft">
                  <input class="noneBorderRight" type="text" value='${data.cardId}'/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight">
                  <label>
                    性别
                  </label>
                </div>
                <div class="col-xs-9 nonePaddingLeft">
                  <input type="text" value='${data.sex}'/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight">
                  <label>
                    地址
                  </label>
                </div>
                <div class="col-xs-9 nonePaddingLeft">
                  <input class="noneBorderRight" type="text" value="${data.address}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight">
                  <label>
                    验证结果
                  </label>
                </div>
                <div class="col-xs-9 nonePaddingLeft">
                  <input type="text" value='${data.compStatus}'/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight">
                  <label>
                    验证结果描述
                  </label>
                </div>
                <div class="col-xs-9 nonePaddingLeft">
                  <input class="noneBorderRight" type="text" value="${data.compResult}"/>
                </div>
              </div>
            </div>
          </div>
          </div>
        
         <!-- 银行卡号和手机号码显示 -->
        <div class="tables">
        <div class="tableContainer">
            <table id="bankTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="accountno" data-width='' data-align="center">银行卡号</th>
                <th data-field="message" data-width='' data-align="center">验证结果</th>
              </tr>
              </thead>
            </table>
          </div>
      </div>
        
        <div class="tables">
          <div class="tableContainer">
            <table id="phoneTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='%5' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="phoneNo" data-width='' data-align="center">手机号</th>
                <th data-field="message" data-width='' data-align="center">验证结果</th>
              </tr>
              <tr><td colspan = "3" align="center" >没有记录</td></tr>
              </thead>
            </table>
         </div>
      </div>
        
        </div>
      </div>
      
     <c:if test="${compStatus == 1}">

    <!-- 二、驾驶证信息 -->
    <c:if test="${templetMap.driverLicence == 1}">
    <div>
       <div class="basicText">
          <c:set var="titleIndexFather" value="${titleIndexFather+1}" scope="page"></c:set>
          <div class="pull-left"><font size = "5px">${titleIndexFather}、驾驶证信息</font></div>
        </div>
        
      <div class="tables" >
        <div class="tableContainer"  style="">
          <table id="driverLinceTable" data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-field="cardId" data-width='' data-align="left">身份证号</th>
              <th data-field="name" data-width='' data-align="left">姓名</th>
              <th data-field="xm" data-width='' data-align="left">驾驶证号匹配结果</th>
              <th data-field="zt" data-width='' data-align="left">状态</th>
            </tr>
            </thead>
          </table>
        </div>
      </div>
    </div>
    </c:if>
    
    <!-- 三、个人对外投资信息 -->
    <div>
    <c:if test="${templetMap.persxbzxr == 1 || templetMap.perbzxr == 1 || templetMap.perqyfddbr == 1 || templetMap.perglry == 1 || templetMap.perqygd == 1}" >
     <div class="basicText">
          <c:set var="titleIndexFather" value="${titleIndexFather+1}" scope="page"></c:set>
          <div class="pull-left"><font size = "5px">${titleIndexFather}、个人对外投资信息</font></div>
        </div>
    </c:if>
        
     <c:if test="${templetMap.persxbzxr == 1}">
      <div class="tables">
        <div class="basicText">
        <c:set var="titleIndex" value="${titleIndex+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex}、失信被执行人信息</div>
        </div>
        <c:choose>
		       <c:when test="${punishBreakInfo == null || fn:length(punishBreakInfo) == 0}">
	              <div class="tableContainer">
		             <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-align="center">身份证号</th>
              <th data-align="center">案号</th>
              <th data-align="center">被执行姓名</th>
              <th data-align="center">失信类型</th>
              <th data-align="center">性别</th>
              <th data-align="center">年龄</th>
              <th data-align="center">身份证原始发地</th>
              <th data-align="center">法定代表人</th>
              <th data-align="center">立案时间</th>
              <th data-align="center">公布时间</th>
              <th data-align="center">执行法院</th>
              <th data-align="center">身份</th>
              <th data-align="center">执行文号</th>
              <th data-align="center">做出执行依据单位</th>
              <th data-align="center">生效法律文书确定的义务</th>
              <th data-align="center">失信被执行人为具体情形</th>
              <th data-align="center">被执行人的履情况</th>
              <th data-align="center">已履行</th>
              <th data-align="center">未履行</th>
              <th data-align="center">关注次数</th>
            </tr>
            <tr><td colspan = "22" align="center" >没有记录</td></tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
        <c:forEach items="${punishBreakInfo}" var="hxjy">
        <div class="marginTopSmall">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label> 身份证号</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.cardId}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>案号</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.caseNo}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>被执行人姓名</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.name}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>失信类型</label>
                </div>
                <div class="col-xs-9">
                  <input type="text" value="${hxjy.type}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>性别</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.sex}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>年龄</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.age}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>身份证号</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.cardNumber}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>身份证原始发地</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.identityDeparture}" pattern="yyyy-MM-dd"/>"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>法定代表人</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.head}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>立案时间</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.filingDate}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>公布时间</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.publishDate}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>执行法院</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.executeCourt}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>身份</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.province}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>执行文号</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.executeDocumentnumber}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>做出执行依据单位</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.gistunit}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>生效法律文书确定的义务</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.duty}"/>
                </div>
              </div>
            </div>
          </div>
           <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>失信被执行人为具体情形</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.disrupttypename}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>被执行人的履情况</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.performance}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>已履行</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.performedpart}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>未履行</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.unperformpart}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>关注次数</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.focusNumber}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        	 </c:otherwise>
		</c:choose>
      </div>
    </c:if>
        
      &nbsp;
     <c:if test="${templetMap.perbzxr == 1}">
      <div class="tables">
        <div class="basicText">
        <c:set var="titleIndex" value="${titleIndex+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex}、被执行人信息</div>
        </div>
        <c:choose>
		       <c:when test="${punishedInfo == null || fn:length(punishedInfo) == 0}">
	              <div class="tableContainer">
		             <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-align="center">身份证号</th>
              <th data-align="center">案号</th>
              <th data-align="center">被执行人姓名</th>
              <th data-align="center">性别</th>
              <th data-align="center">年龄</th>
              <th data-align="center">身份证原始发地</th>
              <th data-align="center">立案时间</th>
              <th data-align="center">执行标的</th>
              <th data-align="center">身份</th>
              <th data-align="center">关注次数</th>
              <th data-align="center">案件状态</th>
              <th data-align="center">执行法院</th>
            </tr>
            <tr><td colspan = "13" align="center" >没有记录</td></tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
        <c:forEach items="${punishedInfo}" var="hxjy">
        <div class="marginTopSmall">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label> 身份证号</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.cardId}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>案号</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.caseNo}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>被执行人姓名</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.name}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>性别</label>
                </div>
                <div class="col-xs-9">
                  <input type="text" value="${hxjy.sex}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>年龄 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.age}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>身份证号</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.cardNumber}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>身份证原始发地</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.identityDeparture}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>立案时间</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${hxjy.filingDate}" pattern="yyyy-MM-dd"/>"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>执行标的</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.executeTarget}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>身份</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.province}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>关注次数</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.focusNumber}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>案件状态</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.caseState}"/>
                </div>
              </div>
            </div>
          </div>
           <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>执行法院</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.courtName}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
           
        	 </c:otherwise>
		</c:choose>
      </div>
    </c:if>
     
     &nbsp;
    <c:if test="${templetMap.perqyfddbr == 1}">
      <div class="tables">
        <div class="basicText">
          <c:set var="titleIndex" value="${titleIndex+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex}、企业法定代表人</div>
        </div>
        <div>
          <div class="tableContainer">
            <table id="ryporsfrTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="cardId" data-width='' data-align="center">身份证号</th>
                <th data-field="name" data-width='' data-align="center">查询人姓名</th>
                <th data-field="entName" data-width='' data-align="center">企业名称</th>
                <th data-field="entNo" data-width='' data-align="center">企业注册号</th>
                <th data-field="regcapital" data-width='' data-align="right">注册资本</th>
                 <th data-field="currency" data-width='' data-align="center">币种</th>
                <th data-field="status" data-width='' data-align="right">企业状态</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if>
        
     &nbsp;
    <c:if test="${templetMap.perglry == 1}">
      <div class="tables">
        <div class="basicText">
          <c:set var="titleIndex" value="${titleIndex+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex}、管理人员</div>
        </div>
        <div>
          <div class="tableContainer">
            <table id="ryposperTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="cardId" data-width='' data-align="center">身份证号</th>
                <th data-field="" data-width='' data-align="center">企业名称</th>
                <th data-field="" data-width='' data-align="center">企业注册号</th>
                <th data-field="" data-width='' data-align="center">企业类型</th>
                <th data-field="" data-width='' data-align="right">注册资本</th>
                <th data-field="" data-width='' data-align="center">币种</th>
                <th data-field="" data-width='' data-align="right">企业状态</th>
                <th data-field="" data-width='' data-align="right">职务</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if>
     
       &nbsp;
    <c:if test="${templetMap.perqygd == 1}">
      <div class="tables">
        <div class="basicText">
          <c:set var="titleIndex" value="${titleIndex+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex}、企业股东</div>
        </div>
        <div>
          <div class="tableContainer">
            <table id="ryposshaTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="" data-width='' data-align="center">身份证号</th>
                <th data-field="" data-width='' data-align="center">查询人姓名</th>
                <th data-field="" data-width='' data-align="center">企业名称</th>
                <th data-field="" data-width='' data-align="center">企业注册号</th>
                <th data-field="" data-width='' data-align="center">企业类型</th>
                <th data-field="" data-width='' data-align="right">注册资本</th>
                <th data-field="" data-width='' data-align="center">币种</th>
                <th data-field="" data-width='' data-align="right">企业状态</th>
                <th data-field="" data-width='' data-align="right">认缴出资额</th>
                <th data-field="" data-width='' data-align="right">职务</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if>
        
    </div>
    
   <!-- 四、个人司法信息 -->
    <div>
    <c:if test="${templetMap.perbgt == 1 || templetMap.percpws == 1 || templetMap.persxgg == 1 || templetMap.perwdhmd == 1 || templetMap.perzxgg == 1}">
       <div class="basicText">
          <c:set var="titleIndexFather" value="${titleIndexFather+1}" scope="page"></c:set>
          <div class="pull-left"><font size = "5px">${titleIndexFather}、个人司法信息</font>
          </div>
        </div>
       </c:if>
        
    <%-- <c:if test="${templetMap.persffgbg == 1}">
      <div class="tables">
        <div class="basicText">
          <c:set var="titleIndex" value="${titleIndex2+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex2}、司法风控报告信息</div>
        </div>
        <div>
          <div>
            <table id="Table1" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="" data-width='' data-align="center">身份证号</th>
                <th data-field="" data-width='' data-align="center">姓名</th>
                <th data-field="" data-width='' data-align="center">数据条数</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if> --%>
     
    <c:if test="${templetMap.perbgt == 1}">
      <div class="tables">
        <div class="basicText">
          <c:set var="titleIndex2" value="${titleIndex2+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex2}、曝光台信息</div>
        </div>
        <div>
          <div class="tableContainer">
            <table id="riskBgtTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="cardId" data-width='' data-align="center">身份证号</th>
                <th data-field="bgtid" data-width='' data-align="center">曝光台ID</th>
                <th data-field="sorttime" data-width='' data-align="center">立案日期</th>
                <th data-field="datatype" data-width='' data-align="center">数据类型</th>
                <th data-field="matchratio" data-width='' data-align="center">匹配度</th>
                <th data-field="pname" data-width='' data-align="center">当事人</th>
                <th data-field="court" data-width='' data-align="center">法院名称</th>
                <th data-field="caseno" data-width='' data-align="center">案号</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if>
     
     &nbsp;
    <c:if test="${templetMap.percpws == 1}">
      <div class="tables">
        <div class="basicText">
        <c:set var="titleIndex2" value="${titleIndex2+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex2}、裁判文书信息</div>
        </div>
        <c:choose>
		       <c:when test="${riskCpwsInfo == null || fn:length(riskCpwsInfo) == 0}">
	              <div class="tableContainer">
		             <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-align="center">身份证号</th>
              <th data-align="center">裁判文书ID</th>
              <th data-align="center">审结时间</th>
              <th data-align="center">数据类型</th>
              <th data-align="center">案由</th>
              <th data-align="center">标题</th>
              <th data-align="center">审理程序</th>
              <th data-align="center">当事人ID</th>
              <th data-align="center">匹配度</th>
              <th data-align="center">法院名称</th>
              <th data-align="center">案号</th>
            </tr>
            <tr><td colspan = "12" align="center" >没有记录</td></tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
        <c:forEach items="${riskCpwsInfo}" var="hxjy">
        <div class="marginTopSmall">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label> 身份证号</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.cardId}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>裁判文书ID</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.cpwsid}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>审结时间</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.sorttime}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>数据类型</label>
                </div>
                <div class="col-xs-9">
                  <input type="text" value="${hxjy.datatype}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>案由 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.casecause}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>标题</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.title}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>审理程序</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.trialprocedure}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>当事人ID</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.partyid}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>匹配度</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.matchratio}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>法院名称</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.court}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>案号</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.caseno}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
           
        	 </c:otherwise>
		</c:choose>
      </div>
    </c:if>
     
     &nbsp;
      <!-- 失信公告 -->
     <c:if test="${templetMap.persxgg == 1}">
      <div class="tables">
        <div class="basicText">
        <c:set var="titleIndex2" value="${titleIndex2+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex2}、失信公告信息</div>
        </div>
        <c:choose>
		       <c:when test="${riskDishonerInfo == null || fn:length(riskDishonerInfo) == 0}">
	              <div class="tableContainer">
		            <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-align="center">立案时间</th>
              <th data-align="center">性别</th>
              <th data-align="center">被执行人的履历情况</th>
              <th data-align="center">失信公告ID</th>
              <th data-align="center">执行依据文号</th>
              <th data-align="center">执行法院名称</th>
              <th data-align="center">身份证/组织结构代码</th>
              <th data-align="center">做出执行依据单位</th>
              <th data-align="center">数据类型</th>
              <th data-align="center">失信被执行人行为具体情形</th>
              <th data-align="center">生效法律文书确定的义务</th>
              <th data-align="center">年龄</th>
              <th data-align="center">匹配度</th>
              <th data-align="center">姓名</th>
              <th data-align="center">身份</th>
              <th data-align="center">案号</th>
              <th data-align="center">发布时间</th>
            </tr>
            <tr><td colspan = "18" align="center" >没有记录</td></tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
        <c:forEach items="${riskDishonerInfo}" var="fdrsxggi">
        <div class="marginTopSmall">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>立案时间</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrsxggi.sorttime}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>性别</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrsxggi.sex}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>被执行人的履行情况</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrsxggi.lxqk}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>失信公告ID</label>
                </div>
                <div class="col-xs-9">
                  <input type="text" value="${fdrsxggi.shixinid}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>执行依据文号 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrsxggi.yjcode}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>执行法院名称</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrsxggi.court}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>身份证</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrsxggi.cardId}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>执行依据单位</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrsxggi.yjdw}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>数据类型 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrsxggi.datatype}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>失信人行为具体情形</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrsxggi.jtqx}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>生效法律文书确定的义务</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrsxggi.yiwu}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>年龄</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrsxggi.age}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>匹配度</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrsxggi.matchratio}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>姓名</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrsxggi.pname}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>身份</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrsxggi.province}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>案号</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrsxggi.caseno}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>发布时间</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrsxggi.posttime}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        	 </c:otherwise>
		</c:choose>
      </div>
    </c:if>
         
      &nbsp;
      <!-- 网贷黑名单 -->
     <c:if test="${templetMap.perwdhmd == 1}">
      <div class="tables">
        <div class="basicText">
        <c:set var="titleIndex2" value="${titleIndex2+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex2}、网贷黑名单信息</div>
        </div>
        <c:choose>
		       <c:when test="${riskNetloadInfo == null || fn:length(riskNetloadInfo) == 0}">
	              <div class="tableContainer">
		            <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-align="center">网贷黑名单ID</th>
              <th data-align="center">身份证号</th>
              <th data-align="center">贷款时间</th>
              <th data-align="center">性别</th>
              <th data-align="center">居住电话</th>
              <th data-align="center">信息更新时间</th>
              <th data-align="center">执行法院</th>
              <th data-align="center">匹配度</th>
              <th data-align="center">未还/罚息</th>
               <th data-align="center">籍贯地址</th>
              <th data-align="center">本金/本息</th>
              <th data-align="center">案号</th>
              <th data-align="center">居住地址</th>
              <th data-align="center">邮箱地址</th>
              <th data-align="center">来源单位名称</th>
              <th data-align="center">姓名</th>
              <th data-align="center">年龄</th>
               <th data-align="center">数据源</th>
              <th data-align="center">已还金额</th>
            </tr>
            <tr><td colspan = "20" align="center" >没有记录</td></tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
        <c:forEach items="${riskNetloadInfo}" var="fdrwdhmdi">
        <div class="marginTopSmall">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>身份证号 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.cardId}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>贷款时间</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.sorttime}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>性别</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.sex}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>居住电话</label>
                </div>
                <div class="col-xs-9">
                  <input type="text" value="${fdrwdhmdi.phone}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>信息更新时间 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.updatetime}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>执行法院</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrwdhmdi.execcourt}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>匹配度</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.matchratio}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>未还/罚息</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrwdhmdi.whfx}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
             <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>手机号</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrwdhmdi.mobile}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>居住地址</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrwdhmdi.address}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>本金/本息</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.bjbx}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>案号</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrwdhmdi.casecode}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>数据类型</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.datatype}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>邮箱地址</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrwdhmdi.email}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>来源单位名称</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.sourcename}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>年龄</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${fdrwdhmdi.age}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>姓名</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.pname}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>已还金额</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${fdrwdhmdi.yhje}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        	 </c:otherwise>
		</c:choose>
      </div>
    </c:if>
      
        &nbsp;
     <!-- 执行公告信息 -->
    <c:if test="${templetMap.perzxgg == 1}">
      <div class="tables">
        <div class="basicText">
        <c:set var="titleIndex2" value="${titleIndex2+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex2}、执行公告信息</div>
        </div>
        <c:choose>
		       <c:when test="${riskExecuteDocInfo == null || fn:length(riskExecuteDocInfo) == 0}">
	              <div class="tableContainer">
		            <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-align="center">执行公告ID</th>
              <th data-align="center">立案时间</th>
              <th data-align="center">内容</th>
              <th data-align="center">标题</th>
              <th data-align="center">执行状态</th>
              <th data-align="center">被执行人姓名</th>
              <th data-align="center">执行法院名称</th>
              <th data-align="center">申请人</th>
              <th data-align="center">案号</th>
              <th data-align="center">案件状态</th>
              <th data-align="center">身份证/组织结构代码</th>
              <th data-align="center">执行标的</th>
            </tr>
            <tr><td colspan = "13" align="center" >没有记录</td></tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
        <c:forEach items="${riskExecuteDocInfo}" var="kggdzxi">
        <div class="marginTopSmall">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>审结时间</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${kggdzxi.sorttime}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>内容</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${kggdzxi.body}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>执行状态</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${kggdzxi.status}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>执行法院名称</label>
                </div>
                <div class="col-xs-9">
                  <input type="text" value="${kggdzxi.court}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>申请人 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${kggdzxi.proposer}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>身份证</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${kggdzxi.cardId}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>执行公告ID </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${kggdzxi.zxggid}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>数据类型</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${kggdzxi.datatype}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>标题 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${kggdzxi.title}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>匹配度</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${kggdzxi.matchratio}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>姓名</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${kggdzxi.pname}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>案号</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${kggdzxi.caseno}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>案件状态</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${kggdzxi.casestate}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>执行标的</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${kggdzxi.execmoney}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        	 </c:otherwise>
		</c:choose>
      </div>
    </c:if>
        
    </div>
    

   <!-- 五、阿里欠贷信息 -->
    <div class="tables">
      <c:if test="${templetMap.peralqd == 1}">
      <div class="basicText">
          <c:set var="titleIndexFather" value="${titleIndexFather+1}" scope="page"></c:set>
          <div class="pull-left"><font size = "5px">${titleIndexFather}、阿里欠贷信息</font></div>
        </div>
      <div>
        <c:choose>
		       <c:when test="${invesAlidebtInfo == null || fn:length(invesAlidebtInfo) == 0}">
	              <div class="tableContainer">
		             <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-align="center">身份证号</th>
              <th data-align="center">欠款额度（元）</th>
              <th data-align="center">违约情况</th>
              <th data-align="center">贷款到期时间</th>
              <th data-align="center">淘宝账户</th>
              <th data-align="center">法定代表人</th>
              <th data-align="center">贷款期限</th>
              <th data-align="center">被执行姓名</th>
              <th data-align="center">性别</th>
              <th data-align="center">年龄</th>
              <th data-align="center">身份证原始发地</th>
              <th data-align="center">身份</th>
            </tr>
            <tr><td colspan = "13" align="center" >没有记录</td></tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
        <c:forEach items="${invesAlidebtInfo}" var="hxjy">
        <div class="marginTopSmall">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label> 身份证号</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.cardId}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>欠款额度(元)</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.arrears}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>违约情况</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.isBreach}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>贷款到期时间</label>
                </div>
                <div class="col-xs-9">
                  <input type="text" value="${hxjy.loanDate}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>淘宝账户 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.taobaoAccount}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>法定代表人</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.legalPerson}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>贷款期限 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.loanTimelimit}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>被执行人姓名</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.name}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>性别</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.sex}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>年龄</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.age}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>身份证源始发地</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.identityDeparture}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>身份 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.province}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
           
        	 </c:otherwise>
		</c:choose>
      </div>
    </c:if>
        
    </div>
    
     <!-- 六、银联三要素验证 -->
    <div>
     
    <c:if test="${templetMap.perylsys == 1}">
     <div class="basicText">
          <c:set var="titleIndexFather" value="${titleIndexFather+1}" scope="page"></c:set>
          <div class="pull-left"><font size = "5px">${titleIndexFather}、银联三要素验证信息</font></div>
        </div>
      <div class="tables">
        <div>
          <div class="tableContainer">
            <table id="bankCardlTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="name" data-width='' data-align="center">姓名</th>
                <th data-field="accountno" data-width='' data-align="center">银行账户</th>
                <th data-field="idcardnum" data-width='' data-align="center">身份证号</th>
                <th data-field="bankpremobile" data-width='' data-align="center">银行预留手机号</th>
                <th data-field="result" data-width='' data-align="center">认证结果</th>
                <th data-field="message" data-width='' data-align="center">描述信息</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if>
        
    </div>
    
     <!-- 七、个人消费信息 -->
    <div>
       <c:if test="${templetMap.perzczkjyxw == 1 || templetMap.perxfdlfb == 1 || templetMap.perxfdlfb == 1 || templetMap.permyxfzk == 1 || templetMap.perxfxw == 1 || templetMap.perxyxgjytj == 1}">
       <div class="basicText">
          <c:set var="titleIndexFather" value="${titleIndexFather+1}" scope="page"></c:set>
          <div class="pull-left"><font size = "5px">${titleIndexFather}、个人消费信息</font></div>
        </div>
        </c:if>
        
    <c:if test="${templetMap.perzczkjyxw == 1}">
      <div class="tables">
        <div class="basicText">
        <c:set var="titleIndex3" value="${titleIndex3+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex3}、资产状况信息及交易行为特征信息</div>
        </div>
        <c:choose>
		       <c:when test="${reportBasicInfo == null || fn:length(reportBasicInfo) == 0}">
	              <div class="tableContainer">
		             <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-align="center">身份证号</th>
              <th data-align="center">姓名</th>
              <th data-align="center">手机号码</th>
              <th data-align="center">银行卡号</th>
              <th data-align="center">每月还贷能力</th>
              <th data-align="center">依照相关交易行为判定个人是否有房</th>
              <th data-align="center">房产预估购买时间</th>
              <th data-align="center">房产估值</th>
              <th data-align="center">有无汽车</th>
              <th data-align="center">汽车预估购买时间</th>
              <th data-align="center">汽车估值</th>
            </tr>
            <tr><td colspan = "12" align="center" >没有记录</td></tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
        <c:forEach items="${reportBasicInfo}" var="hxjy">
        <div class="marginTopSmall">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label> 身份证号</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.cardId}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>姓名</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.name}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>手机号码</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.mobile}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>银行卡号</label>
                </div>
                <div class="col-xs-9">
                  <input type="text" value="${hxjy.card}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>每月还贷能力 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.repaymentAbility}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>个人是否有房</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.hasHouse}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>房产预估购买时间</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.housePurTime}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>房产估值（万元）</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.houseValue}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>有无汽车</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.hasCar}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>汽车预估购买时间</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.carPurTime}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>汽车估值（万元）</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.carValue}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
           
        	 </c:otherwise>
		</c:choose>
      </div>
    </c:if>
    </div>
     
    <c:if test="${templetMap.perxfdlfb == 1}">
      <div class="tables">
        <div class="basicText">
          <c:set var="titleIndex3" value="${titleIndex3+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex3}、消费大类分布信息</div>
        </div>
        <div>
          <div class="tableContainer">
            <table id="consumeCategroyTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="cardId" data-width='' data-align="center">身份证号</th>
                <th data-field="card" data-width='' data-align="center">银行卡号</th>
                <th data-field="name" data-width='' data-align="center">行业</th>
                <th data-field="amount" data-width='' data-align="center">消费金额</th>
                <th data-field="count" data-width='' data-align="right">消费笔数</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if>


    <c:if test="${templetMap.percsxfzk == 1}">
      <div class="tables">
        <div class="basicText">
          <c:set var="titleIndex3" value="${titleIndex3+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex3}、城市消费状况信息</div>
        </div>
        <div>
          <div class="tableContainer">
            <table id="consumeCityTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="cardId" data-width='' data-align="center">身份证号</th>
                <th data-field="card" data-width='' data-align="center">银行卡号</th>
                <th data-field="name" data-width='' data-align="center">消费地域</th>
                <th data-field="amount" data-width='' data-align="center">消费金额</th>
                <th data-field="count" data-width='' data-align="right">消费笔数</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if>
     

    <c:if test="${templetMap.permyxfzk == 1}">
      <div class="tables">
        <div class="basicText">
          <c:set var="titleIndex3" value="${titleIndex3+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex3}、每月消费状况信息</div>
        </div>
        <div>
          <div class="tableContainer">
            <table id="monthConsumeTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="cardId" data-width='' data-align="center">身份证号</th>
                <th data-field="card" data-width='' data-align="center">银行卡号</th>
                <th data-field="month" data-width='' data-align="center">消费月</th>
                <th data-field="amount" data-width='' data-align="center">每月消费金额</th>
                <th data-field="amountranking" data-width='' data-align="right">消费金额在本市排名</th>
                <th data-field="count" data-width='' data-align="right">每月消费笔数</th>
                <th data-field="countranking" data-width='' data-align="right">消费笔数在本市排名</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if>
     

    <c:if test="${templetMap.perxfxw == 1}">
      <div class="tables">
        <div class="basicText">
        <c:set var="titleIndex3" value="${titleIndex3+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex3}、消费行为信息</div>
        </div>
        <c:choose>
		       <c:when test="${reportTransBehivorInfo == null || fn:length(reportTransBehivorInfo) == 0}">
	              <div class="tableContainer">
		             <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-align="center">身份证号</th>
              <th data-align="center">银行卡号</th>
              <th data-align="center">有无出差</th>
              <th data-align="center">有无婚庆消费</th>
              <th data-align="center">有无家庭特征</th>
              <th data-align="center">有无夜消费</th>
              <th data-align="center">是否就业</th>
              <th data-align="center">常住城市</th>
              <th data-align="center">工作时间消费区域</th>
              <th data-align="center">非工作时间消费区域</th>
              <th data-align="center">是否失业</th>
            </tr>
            <tr><td colspan = "12" align="center" >没有记录</td></tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
        <c:forEach items="${reportTransBehivorInfo}" var="hxjy">
        <div class="marginTopSmall">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label> 身份证号</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.cardId}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>银行卡号</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.card}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>有无出差</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.businesstrip}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>有无婚庆消费</label>
                </div>
                <div class="col-xs-9">
                  <input type="text" value="${hxjy.marriageconsume}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>有无家庭特征</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.childinvest}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>有无夜消费</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.nightconsume}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>是否就业</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.employed}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>常住城市</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.city}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>工作时间消费区域</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.workregion}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft">
                  <label>非工作时间消费区域</label>
                </div>
                <div class="col-xs-9">
                  <input class="noneBorderRight" type="text" value="${hxjy.freeregion}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>是否失业</label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${hxjy.unemployed}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
           
        	 </c:otherwise>
		</c:choose>
      </div>
    </c:if>
     

    <c:if test="${templetMap.perxyxgjytj == 1}">
      <div class="tables">
        <div class="basicText">
          <c:set var="titleIndex3" value="${titleIndex3+1}" scope="page"></c:set>
          <div class="pull-left">${titleIndexFather}.${titleIndex3}、信用相关交易统计信息</div>
        </div>
        <div>
          <div class="tableContainer">
            <table id="tranCreditTable" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="cardId" data-width='' data-align="center">身份证号</th>
                <th data-field="card" data-width='' data-align="center">银行卡号</th>
                <th data-field="name" data-width='' data-align="center">消费地域</th>
                <th data-field="amount" data-width='' data-align="center">消费金额（元）</th>
                <th data-field="count" data-width='' data-align="right">消费笔数</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
    </c:if>
     
     </c:if>
     
    </div>
      

      
      <div>
        <span style="color:red;font-weight: bold;">重要声明：</span>
        <ul class="marginTopSmall" style="padding-left: 15px;list-style: none;margin-left: -10px;">
          <c:forEach items="${declareList}" var="declare">
          	<li>${declare}</li>
          </c:forEach>
         </ul>
      </div>
    </div>
  </div>

<a href="#top" class="btn top" title="回到顶部">
  <span class="icon-angle-up"></span>
</a>
<a href="#bottom" class="btn bottom" title="回到底部">
  <span class="icon-angle-down"></span>
</a>
<script>
// Delphi RF
  var dengji = "${data.level}";''
  var algorCode = "${algorithmType}";
  checkColor(dengji, ".textColor");
  var baseUrl = "${pageContext.request.contextPath}/creditReport/";
  $("#creditReportDetail input,textarea").attr("readonly", "readonly");
  
  $("a.backA").on("click",function (e) {
	  if(!$(this).hasClass("pdf_btn")){//pdf预览和下载不做ajax请求
	    $("#content").load("./person-credit-report.jsp", {id:"${cardId}",algorithmType:algorCode});
	  }
  });
  
  //列表索引
  function indexFormatter(value, row, index) {
	  return index + 1;
  }
  
  $('#bankTable').bootstrapTable({data: jQuery.parseJSON('${verifyBankCardInfo}')});
  $('#driverLinceTable').bootstrapTable({data: jQuery.parseJSON('${driverInfo}')});
  $('#ryporsfrTable').bootstrapTable({data: jQuery.parseJSON('${ryposfrInfo}')});
  $('#ryposperTable').bootstrapTable({data: jQuery.parseJSON('${ryposperInfo}')});
  $('#ryposshaTable').bootstrapTable({data: jQuery.parseJSON('${ryposshaInfo}')});
  $('#riskBgtTable').bootstrapTable({data: jQuery.parseJSON('${riskBgtInfo}')});
  $('#bankCardlTable').bootstrapTable({data: jQuery.parseJSON('${verifyBankCardInfo}')});
  $('#consumeCategroyTable').bootstrapTable({data: jQuery.parseJSON('${reportConsumeCategoryInfo}')});
  $('#consumeCityTable').bootstrapTable({data: jQuery.parseJSON('${reportConsumeCityInfo}')});
  $('#monthConsumeTable').bootstrapTable({data: jQuery.parseJSON('${reportMonthConsumeInfo}')});
  $('#tranCreditTable').bootstrapTable({data: jQuery.parseJSON('${reportTransCreditInfo}')});
  
  
</script>