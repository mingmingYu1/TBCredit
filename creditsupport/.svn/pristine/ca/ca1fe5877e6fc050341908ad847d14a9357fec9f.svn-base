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
      <p class="sumTitle"><a href="company-manage.jsp" class="returnIndex">企业管理</a>
        <a class="backA" href="javascript:void(0)">< 征信报告列表</a> < 征信报告</p>
    </div>
    <div class="basicContainer">
      <div style="overflow: hidden;margin-top: -10px;padding-bottom: 0;">
        <p class="link pull-left">
          <a class="backA" href="javascript:void(0)">&lt; 返回征信报告列表</a>
        </p>
        <div class="pull-right aIcon">
          <mrp:p rId="21231">
            <a class="pdf_btn" id="viewReport"
               href="/creditsupport/js/pdfjs/generic/web/viewer.html?file=/creditsupport/company${filePath}"
               target="_blank" title="预览/打印"><span class="icon-eye-open"></span></a>
          </mrp:p>
          <mrp:p rId="21232">
            <a class="pdf_btn" href="/creditsupport/company${filePath}" title="下载PDF"><span class="icon-file-alt"></span></a>
          </mrp:p>
        </div>
      </div>
      <div class="text-center creditReportDetailTitle" style="padding-bottom: 0;">${data.compName}征信报告</div>
      <div class="text-center" style="margin-top: 10px;padding-bottom: 0">
        <div class="leftModal overflow" style="display: inline-block;">
          <div class="pull-left">
            <label style="margin-top: 3px">报告类别：</label>
          </div>
          <div class="radioInput pull-left">
            <label class="checkbox-inline">
              <input type="radio" name="type" disabled ${reportType== 1 ? "checked" : ""}/>授信
            </label>
            <label class="checkbox-inline">
				      <input type="radio" name="type" disabled ${reportType == 2 ? "checked" : ""}/>贷款
			      </label>
            <label class="checkbox-inline" style="margin-right: 0;">
              <input type="radio" name="type" disabled ${reportType== 3 ? "checked" : ""}/>交易
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
            报告编号：<span>${data.regId}</span>
          </div>
        </div>
        <%--
        <div class="col-xs-4 col-xs-offset-8">
          <div class="pull-right reportNumber">
            生成时间：<span><fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd HH:mm"/></span>
          </div>
        </div>
        --%>
      </div>
      <div class="creditReportListTitle">
      <div style="padding: 0 13px;">
        <div style="padding: 14px 0;border-bottom: 1px solid #dfe8f1">
          <div class="row">
            <div class="col-xs-6">
              <div class="dengJi pull-right">
                信用等级：<span class="textColor">${data.level}${data.levelDesc}</span>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="deFen">
                信用得分：<span class="textColor">${data.score}分</span>
              </div>
            </div>
          </div>
        </div>
        <div>
          <div class="marginTop">
            <label>报告内容：</label>
          </div>
          <div id="detailTitle"></div>
        </div>
        <div style="padding-bottom: 20px;">
          <div>
            <label>评分简述：</label>
          </div>
          <div class="scoreDetail">
            <span>征信报告总评分由通用信息评分和行业信息评分组成：</span>
          </div>
          <div class="scoreDetail">
            <span>通用信息占总评分权重：</span><span class="red">${data.score1Weight}</span><span>在总评分中计分：</span><span
              class="red">${data.score1}</span><span>按百分制单独评分：</span><span class="red">${data.score1Per}</span>
          </div>
          <div class="scoreDetail">
            <span>行业信息占总评分权重：</span><span class="red">${data.score2Weight}</span><span>在总评分中计分：</span><span
              class="red">${data.score2}</span><span>按百分制单独评分：</span><span class="red">${data.score2Per}</span>
          </div>
          <div class="scoreDetail">
            <span>(详见评分报告)</span>
          </div>
        </div>
      </div>
    </div>

      <!--一、基本信息-->
<c:if test="${templetMap.basicInfo != null}">
      <div>
        <div class="basicText">
          <c:set var="titleIndexFather" value="${titleIndexFather+1}" scope="page"></c:set>
          <div id="basicInfo" class="pull-left"><font size="5px">${titleIndexFather}、基本信息</font></div>
        </div>
    <c:if test="${templetMap.basic != null}">
        <div id="basic">   <!--agent-base-->
          <div class="basicText">
            <div class="pull-left">${templetMap.basic}</div>
          </div>
          <div class="">
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label class="col-xs-3">
                      企业名称
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value="${data.compName}" placeholder=""/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      企业状态
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderLeft" type="text" value='${entStatus}'/>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      注册资本
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value='${data.regAssetsStr}万元'/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      开业日期
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${data.openDate}" pattern="yyyy-MM-dd"/>"/>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      货币种类
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value="${data.curTypeName}"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      经营期限
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" value="${data.opePeriod}"/>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      社会信用代码
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value="${data.orgCode}"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      代码证有效期
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${data.validDate}" pattern="yyyy-MM-dd"/>"/>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      工商注册号
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value="${data.regId}"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      最后年检年度
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" value="${data.lastYear}"/>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      企业类型
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value="${data.typeEnt}"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      最后年检日期
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft ">
                    <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${data.lastDate}" pattern="yyyy-MM-dd"/>"/>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      机构类型
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value="${data.typeOrg}"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      注销日期
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${data.cancelledDate}" pattern="yyyy-MM-dd"/>"/>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      员工人数
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value="${data.emps}"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      吊销日期
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${data.revokDate}" pattern="yyyy-MM-dd"/>"/>
                  </div>
                </div>
              </div>
            </div>

            <!-- jason 添加 start -->
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      行业门类代码
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value="${data.industryCode}"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      原注册号
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" value="${data.originalRegId}"/>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      营业有效开始日期
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" value="<fmt:formatDate value="${data.operatingStartTime}" pattern="yyyy-MM-dd"/>"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      营业有效结束日期
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${data.operatingEndTime}" pattern="yyyy-MM-dd"/>"/>
                  </div>
                </div>
              </div>
            </div>

            <div class="row basicText3">
              <div class="col-xs-2">
                <label>
                  行业分类名称
                </label>
              </div>
              <div class="col-xs-10">
                <input type="text" value="${data.industryName} "/>
              </div>
            </div>

            <!-- jason 添加End -->

            <div class="row basicText3">
              <div class="col-xs-2">
                <label>企业网址</label>
              </div>
              <div class="col-xs-10">
                <input type="text" value="${data.webSite}"/>
              </div>
            </div>
            <div class="row basicText3">
              <div class="col-xs-2">
                <label>
                  工商登记机关
                </label>
              </div>
              <div class="col-xs-10">
                <input type="text" value="${data.regAuth}"/>
              </div>
            </div>
            <div class="row basicText3">
              <div class="col-xs-2">
                <label>所属行业</label>
              </div>
              <div class="col-xs-10">
                <input type="text" value="${data.industry}"/>
              </div>
            </div>
            <div class="row basicText3">
              <div class="col-xs-2">
                <label>特殊标识</label>
              </div>
              <div class="col-xs-10">
                <input type="text" value="${data.speMark}"/>
              </div>
            </div>
            <div class="row basicText3">
              <div class="col-xs-2">
                <label class="textareaLabel borderBottomColor">经营范围</label>
              </div>
              <div class="col-xs-10 textareaContainer">
                <textarea class="borderBottomColor">${data.busCope}</textarea>
              </div>
            </div>
          </div>
        </div>
    </c:if>
        &nbsp;
    <c:if test="${templetMap.addr != null}">
          <div id="addr" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.addr}</div>
            </div>
            <div>
              <div class="tableContainer">
                <table id="detailTable1" data-toggle="" data-cache="false" data-pagination="true"
                       data-side-pagination="server" data-url=""
                       class="table table-striped">
                  <thead>
                  <tr>
                    <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                    <th data-field="typeName" data-width='12%' data-align="left">类型</th>
                    <th data-field="district" data-width='18%' data-align="left">行政区域</th>
                    <th data-field="addr" data-width='27%' data-align="left" data-title-tooltip="">地址</th>
                    <th data-field="tel" data-width='22%' data-align="left">电话</th>
                    <th data-field="post" data-width='15%' data-align="left">邮政编码</th>
                  </tr>
                  </thead>
                </table>
              </div>
            </div>
          </div>
    </c:if>
        &nbsp;
    <c:if test="${templetMap.stockH != null}">
          <div id="stockH" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.stockH}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTable2" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="name" data-width='15%' data-align="left" data-title-tooltip="">股东名称</th>
                  <th data-field="identifyType" data-width='5%' data-align="left" data-title-tooltip="">证件类型</th>
                  <th data-field="identifyNo" data-width='10%' data-align="left" data-title-tooltip="">证件号码</th>
                  <th data-field="country" data-width='5%' data-align="left">国别</th>
                  <th data-field="address" data-width='10%' data-align="left" data-title-tooltip="">股东地址</th>
                  <th data-field="cashConStr" data-width='5%' data-align="left">认缴出资额（万元）</th>
                  <th data-field="cashRateStr" data-width='5%' data-align="left">出资比例（%）</th>
                  <th data-field="curTypeName" data-width='5%' data-align="left" data-formatter="stockFormatter">出资币种
                  </th>
                  <th data-field="conDateStr" data-width='5%' data-align="right" data-title-tooltip="">出资日期</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
    <c:if test="${templetMap.topM != null}">
          <div id="topM" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.topM}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTable3" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="name" data-width='' data-align="left">姓名</th>
                  <th data-field="sex" data-width='' data-align="left">性别</th>
                  <th data-field="identifyType" data-width='' data-align="left">证件名称</th>
                  <th data-field="identifyNo" data-width='' data-align="left">证件号码</th>
                  <th data-field="phone" data-width='' data-align="left">联系电话</th>
                  <th data-field="position" data-width='' data-align="left">职务</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
    <c:if test="${templetMap.othEnt != null}">
          <div id="othEnt" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.othEnt}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTable4" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="name" data-width='' data-align="left">企业名称</th>
                  <th data-field="regAssetsStr" data-width='' data-align="left">注册资本（万元）</th>
                  <th data-field="cashRateStr" data-width='' data-align="right">出资比例</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
    <c:if test="${templetMap.legPerPo != null}">
          <div id="legPerPo" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.legPerPo}</div>
            </div>
            <div class="tableContainer">
              <table id="detailTable5" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="orgName" data-width='' data-align="left" data-title-tooltip="">机构名称</th>
                  <th data-field="regNo" data-width='' data-align="left">工商注册号</th>
                  <th data-field="position" data-width='' data-align="left">担任职务</th>
                  <th data-field="orgSta" data-width='' data-align="left">机构状态</th>
                  <th data-field="regAssetsStr" data-width='' data-align="left">注册资本(万元)</th>
                  <th data-field="entType" data-width='' data-align="left" data-title-tooltip="">企业类型</th>
                  <th data-field="regAuth" data-width='' data-align="right" data-title-tooltip="">登记机关</th>
                </tr>
                </thead>
              </table>
            </div>
            <div id="office6">
              <div>
                <c:forEach items="${legPer1}" var="leg1">
                  <div class="row basicText3 marginTopSmall">
                    <div class="col-xs-2">
                      <label>任职机构信息</label>
                    </div>
                    <div class="col-xs-10">
                      <input type="text"/>
                    </div>
                  </div>
                  <div class="row basicText3">
                    <div class="col-xs-2">
                      <label>机构名称</label>
                    </div>
                    <div class="col-xs-10">
                      <input type="text" value="${leg1.orgName}"/>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            工商注册号
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input type="text" value="${leg1.regNo}"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            担任职务
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input class="noneBorderRight" type="text" value="${leg1.position}"/>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            注册资本(万元)
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input type="text" value="${leg1.regAssetsStr}"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            企业类型
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input class="noneBorderRight" type="text" value="${leg1.entType}"/>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row lastInputLabel">
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            机构状态
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input type="text" value="${leg1.orgSta}"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            登记机关
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input class="noneBorderRight" type="text" value="${leg1.regAuth}"/>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:forEach>
              </div>
            </div>
          </div>
    </c:if>
        &nbsp;
    <c:if test="${templetMap.legPerSt != null}">
          <div id="legPerSt" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.legPerSt}</div>
            </div>
            <div class="tableContainer">
              <div class="row" style="margin-bottom: 0;">
                <div class="col-xs-8 labelInput">
                  <div class="row">
                    <div class="col-xs-2 nonePaddingRight investmentTotal">
                      <label style="">积累投资总数</label>
                    </div>
                    <div class="col-xs-4 nonePaddingLeft nonePaddingRight investmentTotalInput">
                      <input type="text" value='${legPer2Count}'/>
                    </div>
                    <div class="col-xs-3 nonePaddingLeft nonePaddingRight moneyTotal">
                      <label>积累投资金额（万元）</label>
                    </div>
                    <div class="col-xs-3 nonePaddingLeft nonePaddingRight moneyTotalInput">
                      <input type="text" value='${legPer2Total}'/>
                    </div>
                  </div>
                </div>
                <div class="col-xs-4 nonePaddingLeft nullInput">
                  <div></div>
                </div>
              </div>
              <table id="detailTable6" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='6%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="entName" data-width='22%' data-align="left" data-title-tooltip="">被投资机构名称</th>
                  <th data-field="regAssetsStr" data-width='13%' data-align="left">注册资本（万元）</th>
                  <th data-field="cashConStr" data-width='13%' data-align="left">认缴出资</th>
                  <th data-field="cashRate" data-width='9%' data-align="left">出资比例</th>
                  <th data-field="curTypeName" data-width='10%' data-align="left">币种</th>
                  <th data-field="entStatus" data-width='16%' data-align="right">机构状态</th>
                </tr>
                </thead>
              </table>
            </div>


            <div id="Investment7">
              <div class="alignment ">
                <c:forEach items="${legPer2}" var="leg2">
                  <div class="row basicText3 marginTopSmall">
                    <div class="col-xs-2 nonePaddingRight">
                      <label>被投资机构概要信息</label>
                    </div>
                    <div class="col-xs-10 nonePaddingLeft">
                      <input type="text"/>
                    </div>
                  </div>
                  <div class="row basicText3">
                    <div class="col-xs-2">
                      <label>机构名称</label>
                    </div>
                    <div class="col-xs-10">
                      <input type="text" value="${leg2.entName}"/>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            注册资本(万元)
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input type="text" value="${leg2.regAssetsStr}"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            币种
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input class="noneBorderRight" type="text" value="${leg2.curTypeName}"/>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            工商注册号
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input type="text" value="${leg2.regNo}"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            企业类型
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input class="noneBorderRight" type="text" value="${leg2.entType}"/>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row lastInputLabel">
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            机构状态
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input type="text" value="${leg2.entStatus}"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            登记机关
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input class="noneBorderRight" type="text" value="${leg2.regOrg}"/>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:forEach>
              </div>
            </div>
          </div>
    </c:if>
        &nbsp;
    <c:if test="${templetMap.score != null}">
          <div id="score" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.score}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableQybg" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="regId" data-width='' data-align="center">企业注册号</th>
                  <th data-field="conDateStr" data-width='10%' data-align="center">变更日期</th>
                  <th data-field="changeItem" data-width='' data-align="center" data-title-tooltip="">变更项</th>
                  <th data-field="preChange" data-width='' data-align="center" data-title-tooltip="">变更前</th>
                  <th data-field="postChange" data-width='' data-align="center" data-title-tooltip="">变更后</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
        <!-- 分支机构 -->
    <c:if test="${templetMap.fzjg != null}">
          <div id="fzjg" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.fzjg}</div>
            </div>
            <c:choose>
              <c:when test="${fenzhiInfo == null || fn:length(fenzhiInfo) == 0}">
                <div class="tableContainer">
                  <!--  <table data-cache="false" data-pagination="true"class="table table-striped"> -->
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="left">机构名称</th>
                      <th data-align="left">一般经营项目</th>
                      <th data-align="left">企业注册号</th>
                      <th data-align="left">注册所在工商管理局</th>
                      <th data-align="center">分支机构地址</th>
                      <th data-align="center">分支机构负责人</th>
                    </tr>
                    <tr>
                      <td colspan="7" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${fenzhiInfo}" var="fzi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>
                              机构名称
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fzi.brName}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>一般经营项目</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fzi.cbuItem}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>企业注册号</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fzi.brRegNo}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>注册所在工商管理局</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${fzi.localAdministration}" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>分之机构地址 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fzi.brAddr}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>分之机构负责人</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fzi.brPrincipal}"/>
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
        <!-- 清算信息 -->
    <c:if test="${templetMap.qingsuan != null}">
          <div id="qingsuan" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.qingsuan}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableQingsuan" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="entity" data-width='' data-align="center">清算责任人</th>
                  <th data-field="endDate" data-width='' data-align="center">清算完结日期</th>
                  <th data-field="principal" data-width='' data-align="center">清算负责人</th>
                  <th data-field="debtTranee" data-width='' data-align="center">债务承接人</th>
                  <th data-field="member" data-width='' data-align="center" data-title-tooltip="">清算组成员</th>
                  <th data-field="clainTranee" data-width='' data-align="center">债权承接人</th>
                  <th data-field="ligst" data-width='' data-align="center" data-title-tooltip="">清算完结情况</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
        <!-- 动产抵押信息 -->
    <c:if test="${templetMap.dcdy != null}">
          <div id="dcdy" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.dcdy}</div>
            </div>
            <c:choose>
              <c:when test="${agentMortgageInfo == null || fn:length(agentMortgageInfo) == 0}">
                <div class="">
                  <div class="tableContainer">
                    <table data-toggle="" data-cache="false" data-pagination="true"
                           data-side-pagination="server" data-url=""
                           class="table table-striped">
                      <thead>
                      <tr>
                        <th data-align="left" data-formatter="indexFormatter">序号</th>
                        <th data-align="center">抵押ID</th>
                        <th data-align="center">登记证号</th>
                        <th data-align="center">抵押人</th>
                        <th data-align="center">申请抵押原因</th>
                        <th data-align="center">抵押权人</th>
                        <th data-align="center">被担保主债权种类</th>
                        <th data-align="center">登记机关</th>
                        <th data-align="center">登记日期</th>
                        <th data-align="center">履约起始日期</th>
                        <th data-align="center">履约截止日期</th>
                        <th data-align="center">状态标识</th>
                        <th data-align="center">注销日期</th>
                      </tr>
                      <tr>
                        <td colspan="13" align="center">没有记录</td>
                      </tr>
                      </thead>
                    </table>
                  </div>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentMortgageInfo}" var="dcdyi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>
                              抵押ID
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${dcdyi.morRegId }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>登记证号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${dcdyi.morRegcNo }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>抵押人</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${dcdyi.morgagor }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>申请抵押原因</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${dcdyi.appRegRea }" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>抵押权人 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${dcdyi.more }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>被担保主债权种类</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${dcdyi.priClaSecKind }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>登记机关 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${dcdyi.regOrg }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>被担保主债权数额</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${dcdyi.priClaSecAm }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>登记日期 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="<fmt:formatDate value="${dcdyi.regiDate}" pattern="yyyy-MM-dd"/>"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>履约起始日期</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${dcdyi.pefperFrom}" pattern="yyyy-MM-dd"/>"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>状态标识 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${dcdyi.morType }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>履约截止日期</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${dcdyi.pefperTo}" pattern="yyyy-MM-dd"/>"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>注销日期 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="<fmt:formatDate value="${dcdyi.canDate}" pattern="yyyy-MM-dd"/>"/>
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
        <!-- 动产抵押物信息 -->
    <c:if test="${templetMap.dcdyw != null}">
          <div id="dcdyw" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.dcdyw}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableDcdyw" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="morRegId" data-width='' data-align="center">抵押ID</th>
                  <th data-field="guaName" data-width='' data-align="center" data-title-tooltip="">抵押物名称</th>
                  <th data-field="quan" data-width='' data-align="center">数量</th>
                  <th data-field="value" data-width='' data-align="center">价值</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
        <!-- 股权冻结历史信息 -->
    <c:if test="${templetMap.gqdjls != null}">
          <div id="gqdjls" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.gqdjls}</div>
            </div>
            <c:choose>
              <c:when test="${agentSharesInfo == null || fn:length(agentSharesInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">冻结文号</th>
                      <th data-align="center">冻结机关</th>
                      <th data-align="center">解冻文号</th>
                      <th data-align="center">解冻机关</th>
                      <th data-align="center">冻结起始日期</th>
                      <th data-align="center">冻结截止日期</th>
                      <th data-align="center">解冻日期</th>
                      <th data-align="center">解冻说明</th>
                      <th data-align="center">冻结金额(元)</th>
                    </tr>
                    <tr>
                      <td colspan="10" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentSharesInfo}" var="gpdj">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>
                              冻结文号
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${gpdj.froDocNo}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>冻结机关</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${gpdj.froAuth }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>解冻文号</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${gpdj.thawDocNo }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>解冻机关</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${gpdj.thawAuth}" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>冻结起始日期 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="<fmt:formatDate value="${gpdj.froFrom}" pattern="yyyy-MM-dd"/>"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>冻结截止日期</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${gpdj.froTo}" pattern="yyyy-MM-dd"/>"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>解冻日期 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="<fmt:formatDate value="${gpdj.thawDate}" pattern="yyyy-MM-dd"/>"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>解冻说明</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${gpdj.thawCommodsEnt}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>冻结金额(元) </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${gpdj.froAM}"/>
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
        <!-- 股权出质历史信息 -->
    <c:if test="${templetMap.gqczls != null}">
          <div id="gqczls" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.gqczls}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableGqczls" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="impOrg" data-width='' data-align="center">质权人姓名</th>
                  <th data-field="impExaeep" data-width='' data-align="center">出质审批部门</th>
                  <th data-field="impOrgType" data-width='' data-align="center">出质人类别</th>
                  <th data-field="impSanDate" data-width='' data-align="center">出质批准日期</th>
                  <th data-field="impAm" data-width='' data-align="center">出质金额(元)</th>
                  <th data-field="impTo" data-width='' data-align="center">出质截止日期</th>
                  <th data-field="imponRecDate" data-width='' data-align="center">出备案日期</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
      </div>
</c:if>
      <!-- 二、财务信息 -->
<c:if test="${templetMap.financialInfo != null}">
      <div>
        <div id="financialInfo" class="basicText">
          <div class="pull-left"><font size="5px">${templetMap.financialInfo}</font></div>
        </div>
	<c:if test="${templetMap.balanceSheet != null}">
        <div id="balanceSheet" class="tables">
          <div class="basicText">
            <div class="pull-left">${templetMap.balanceSheet}</div>
          </div>
          <div class="tableContainer" style="">
            <table id="detailTableZcfz" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="item" data-width='' data-align="left" data-title-tooltip="">项目</th>
                <th data-field="lastYear" data-width='' data-align="left">年初余额(元)</th>
                <th data-field="endingBalance" data-width='' data-align="left">期末余额(元)</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
	</c:if>
        &nbsp;
    <c:if test="${templetMap.profitStatemen != null}">
        <div id="profitStatemen" class="tables">
          <div class="basicText">
            <div class="pull-left">${templetMap.profitStatemen}</div>
          </div>
          <div class="tableContainer" style="">
            <table id="detailTableProfit" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="item" data-width='' data-align="left" data-title-tooltip="">项目</th>
                <th data-field="preAmount" data-width='' data-align="left">上期金额(元)</th>
                <th data-field="curAmount" data-width='' data-align="left">本期金额(元)</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
	</c:if>
      </div>
</c:if>
      <!-- 三、税务信息 -->
<c:if test="${templetMap.taxInfo != null}">
      <div>
        <div id="taxInfo" class="basicText">
          <div class="pull-left"><font size="5px">${templetMap.taxInfo}</font></div>
        </div>
	<c:if test="${templetMap.sysl != null}">
        <div id="sysl" class="tables">
          <div class="basicText">
            <div class="pull-left">${templetMap.sysl}</div>
          </div>
          <div class="tableContainer" style="">
            <table id="detailTableSyl" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="addedValueTaxRate" data-width='' data-align="left">增值税</th>
                <th data-field="incomeTaxRate" data-width='' data-align="left">企业所得税</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
	</c:if>
        &nbsp;
    <c:if test="${templetMap.fsl != null}">
        <div id="fsl" class="tables">
          <div class="basicText">
            <div class="pull-left">${templetMap.fsl}</div>
          </div>
          <div class="tableContainer" style="">
            <table id="detailTableFsl" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="annualTax" data-width='' data-align="left">年应税额(元)</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
	</c:if>
        &nbsp;
        
    <c:if test="${templetMap.zzsybnarsb != null}">
        <div id="zzsybnarsb" class="tables">
          <div class="basicText">
            <div class="pull-left">${templetMap.zzsybnarsb}</div>
          </div>
          <div class="tableContainer" style="">
            <table id="detailTableZzsybnsr" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="taxableGoodsSales" data-width='' data-align="left">按适用税率计税销售额(元)</th>
                <th data-field="taxableLaberServiceSales" data-width='' data-align="left">按简易办法计税销售额(元)</th>
                <th data-field="ajustedSales" data-width='' data-align="left">免、抵、退办法出口销售额(元)</th>
                <th data-field="taxExemptSales" data-width='' data-align="left">免税销售额(元)</th>
                <th data-field="taxSum" data-width='' data-align="left">合计(元)</th>
                <th data-field="outputVat" data-width='' data-align="left">销项税额(元)</th>
                <th data-field="inputVat" data-width='' data-align="left">进项税额(元)</th>
                <th data-field="overpaidVat" data-width='' data-align="left">上期留底税额(元)</th>
                <th data-field="totalAmountOfTax" data-width='' data-align="left">应纳税额合计</th>
                <th data-field="taxCreditToStay" data-width='' data-align="left">期末留底金额(元)</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
	</c:if>
        &nbsp;
    <c:if test="${templetMap.yxse != null}">
        <div id="yxse" class="tables">
          <div class="basicText">
            <div class="pull-left">${templetMap.yxse}</div>
          </div>
          <div class="tableContainer" style="">
            <table id="detailTableYxse" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="annualTaxableSales" data-width='' data-align="left">年应税销售额(元)</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
	</c:if>
        &nbsp;
    <c:if test="${templetMap.zrse != null}">
        <div id="zrse" class="tables">
          <div class="basicText">
            <div class="pull-left">${templetMap.zrse}</div>
          </div>
          <div class="tableContainer" style="">
            <table id="detailTableZrsmoney" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="incomeTax" data-width='' data-align="left">企业所得税</th>
                <th data-field="addedValueTax" data-width='' data-align="left">增值税</th>
                <th data-field="otherTax" data-width='' data-align="left">其他税种</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
	</c:if>
      </div>
</c:if>
      <!-- 4、交易信息 -->
<c:if test="${templetMap.transactionInfo != null}">
      <div>
        <div id="transactionInfo" class="basicText">
          <div class="pull-left"><font size="5px">${templetMap.transactionInfo}</font></div>
        </div>

        <!-- 核心经营信息 -->
	<c:if test="${templetMap.hxjy != null}">
          <div id="hxjy" class=" tables alignment">
            <div class="basicText">
              <div class="pull-left">${templetMap.hxjy}</div>
            </div>
            <c:choose>
              <c:when test="${merchantTradeInfo == null || fn:length(merchantTradeInfo) == 0}">
                <div class=" tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped ">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">商户名称</th>
                      <th data-align="center">商户编号</th>
                      <th data-align="center">营业执照注册编号</th>
                      <th data-align="center">负责人姓名</th>
                      <th data-align="center">负责人手机号码</th>
                      <th data-align="center">负责人身份证</th>
                      <th data-align="center">月还债能力区间</th>
                      <th data-align="center">首次交易日期</th>
                      <th data-align="center">交易总金额(元)</th>
                      <th data-align="center">交易总笔数</th>
                      <th data-align="center">交易总人数</th>
                      <th data-align="center">周均交易金额(元)</th>
                      <th data-align="center">周均交易笔数</th>
                      <th data-align="center">月均交易天数</th>
                      <th data-align="center">笔单价(元)</th>
                      <th data-align="center">客单价(元)</th>
                    </tr>
                    <tr>
                      <td colspan="17" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${merchantTradeInfo}" var="hxjy">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>
                              商户名称
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${hxjy.mName}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft nonePaddingRight">
                            <label>商户编号</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="${hxjy.mid}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>营业执照注册编号</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${hxjy.busincessCode}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft nonePaddingRight">
                            <label>负责人姓名</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input type="text" value="${hxjy.name}" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>负责人手机号码 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${hxjy.mobile}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft nonePaddingRight">
                            <label>负责人身份证号码</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="${hxjy.cid}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>月还贷能力区间 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${hxjy.repaymentAbility}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft nonePaddingRight">
                            <label>首次交易日期</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${hxjy.firstTransDate}" pattern="yyyy-MM-dd"/>"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>交易总金额(元) </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${hxjy.transAmountTotal}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft nonePaddingRight">
                            <label>交易总笔数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="${hxjy.transCount}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>交易总人数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${hxjy.transPersonCount}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft nonePaddingRight">
                            <label>周均交易金额(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="${hxjy.weekTransAmountAvg}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>周均交易笔数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${hxjy.weekTransCountAvg}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft nonePaddingRight">
                            <label>月均交易天数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="${hxjy.monthDaysAvg}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row lastInputLabel">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>笔单价(元) </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${hxjy.countPrice}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft nonePaddingRight">
                            <label>客单价(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="${hxjy.personPrice}"/>
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
        <!-- 异常交易指标信息 -->
    <c:if test="${templetMap.yycjy != null}">
          <div id="yycjy" class="tables alignment transFailed">
            <div class="basicText">
              <div class="pull-left">${templetMap.yycjy}</div>
            </div>
            <c:choose>
              <c:when test="${merchantTradeAbormalInfo == null || fn:length(merchantTradeAbormalInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">反向交易金额(元)</th>
                      <th data-align="center">反向交易笔数</th>
                      <th data-align="center">交易金额前五客户的金额占比</th>
                      <th data-align="center">交易金额前五客户的笔数占比</th>
                      <th data-align="center">贷记卡的交易总金额(元)</th>
                      <th data-align="center">贷记卡的交易总笔数</th>
                      <th data-align="center">借记卡的交易总笔数</th>
                      <th data-align="center">借记卡的交易总金额(元)</th>
                      <th data-align="center">非正常时间的交易总笔数</th>
                      <th data-align="center">非正常时间的交易总金额(元)</th>
                      <th data-align="center">交易失败金额(元)</th>
                      <th data-align="center">交易失败笔数</th>
                    </tr>
                    <tr>
                      <td colspan="13" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${merchantTradeAbormalInfo}" var="ycjyi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-5 nonePaddingRight">
                            <label>
                              反向交易金额(元)
                            </label>
                          </div>
                          <div class="col-xs-7 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${ycjyi.revrseTransAmount}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-5 nonePaddingLeft nonePaddingRight">
                            <label>反向交易笔数</label>
                          </div>
                          <div class="col-xs-7 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="${ycjyi.peverseTransCount}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-5 nonePaddingRight">
                            <label>交易金额前五客户的金额占比</label>
                          </div>
                          <div class="col-xs-7 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${ycjyi.top5TransAmountStr}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-5 nonePaddingRight nonePaddingLeft">
                            <label>交易金额前五客户的笔数占比</label>
                          </div>
                          <div class="col-xs-7 nonePaddingLeft">
                            <input type="text" value="${ycjyi.top5TransCountPropStr}" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-5 nonePaddingRight">
                            <label>贷记卡的交易总金额(元) </label>
                          </div>
                          <div class="col-xs-7 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${ycjyi.creditCardTransAmount}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-5 nonePaddingLeft nonePaddingRight">
                            <label>贷记卡的交易总笔数</label>
                          </div>
                          <div class="col-xs-7 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="${ycjyi.creditCardTransCount}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-5 nonePaddingRight">
                            <label>非正常时间的交易总笔数 </label>
                          </div>
                          <div class="col-xs-7 nonePaddingRight nonePaddingLeft">
                            <input type="text" value="${ycjyi.abnormalTimeTransCount}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-5 nonePaddingLeft nonePaddingRight">
                            <label>交易失败金额(元)</label>
                          </div>
                          <div class="col-xs-7 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="${ycjyi.abnormalTimeTransAmout}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row lastInputLabel ">
                      <div class="col-xs-12">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>交易失败笔数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input type="text" value="${ycjyi.transFailedCount}"/>
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
        <!-- 经营稳定性指标信息 -->
    <c:if test="${templetMap.jywdxzb != null}">
          <div id="jywdxzb" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.jywdxzb}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableJywdxzb" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="weekLowThanAvgCount" data-width='' data-align="center">低于周均交易金额的周数</th>
                  <th data-field="weekLatelyLowThanAvgCount" data-width='' data-align="center">最近的连续低于周均交易金额的周数</th>
                  <th data-field="transAmountHighestTenDays" data-width='' data-align="center">交易额峰值常见旬</th>
                  <th data-field="weekTransAmountMedian" data-width='' data-align="center">周交易额中值</th>
                  <th data-field="weekTransAmountAvgCv" data-width='' data-align="center">周均交易金额变异系数</th>
                  <th data-field="weekTransCountAvgCv" data-width='' data-align="center">周均交易笔数变异系数</th>
                  <th data-field="weekTransDaysAvgCv" data-width='' data-align="center">月均交易天数变异系数</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
        <!-- 经营变化趋势信息（周） -->
    <c:if test="${templetMap.jybhqs != null}">
          <div id="jybhqs" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.jybhqs}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableJybhqs" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="weekTransAmountGrowthRateStr" data-width='' data-align="center">交易金额周均增长率</th>
                  <th data-field="weekTransCountGrowthRateStr" data-width='' data-align="center">交易笔数周均增长率</th>
                  <th data-field="weekTransAmounts" data-width='' data-align="center">每周交易金额(元)</th>
                  <th data-field="weekTransCounts" data-width='' data-align="center">每周交易笔数</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
        <!-- 本市同行信息对比信息（月） -->
    <c:if test="${templetMap.bsthxxdb != null}">
          <div id="bsthxxdb" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.bsthxxdb}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableBsthdb" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="monthAmount" data-width='' data-align="center">月交易金额(元)</th>
                  <th data-field="monthAmountRank" data-width='' data-align="center">月交易金额在本市同行业中的排名</th>
                  <th data-field="monthCount" data-width='' data-align="center">月交易笔数</th>
                  <th data-field="monthCountRank" data-width='' data-align="center">月交易笔数在本市同行业中的排名</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
        <!-- 客户地域分布 -->
    <c:if test="${templetMap.khdyfb != null}">
          <div id="khdyfb" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.khdyfb}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableKhdyfb" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="customerType" data-width='' data-align="center">客户类型</th>
                  <th data-field="amountPropStr" data-width='' data-align="center">金额占比</th>
                  <th data-field="countPropStr" data-width='' data-align="center">交易笔数占比</th>
                  <th data-field="personPropStr" data-width='' data-align="center">交易人数占比</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
        <!-- 客户忠诚度 -->
    <c:if test="${templetMap.khzcd != null}">
          <div id="khzcd" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.khzcd}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableKhzcd" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="customerType" data-width='' data-align="center">客户类型</th>
                  <th data-field="amountPropStr" data-width='' data-align="center">金额占比</th>
                  <th data-field="countPropStr" data-width='' data-align="center">交易笔数占比</th>
                  <th data-field="personPropStr" data-width='' data-align="center">交易人数占比</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
        <!-- 供应商信息 -->
    <c:if test="${templetMap.gys != null}">
          <div id="gys" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.gys}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableGys" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="" data-width='' data-align="center" data-title-tooltip="">供应商名称</th>
                  <th data-field="" data-width='' data-align="center">年采购金额(元)</th>
                  <th data-field="" data-width='' data-align="center">采购占比</th>
                  <th data-field="" data-width='' data-align="center">前十名供应商金额合计(元)</th>
                  <th data-field="" data-width='' data-align="center">前十名供应商金额占比</th>
                  <th data-field="" data-width='' data-align="center">年关联交易金额(元)</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>
        &nbsp;
        <!-- 客户信息 -->
    <c:if test="${templetMap.kh != null}">
          <div id="kh" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.kh}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableKh" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="" data-width='' data-align="center" data-title-tooltip="">客户名称</th>
                  <th data-field="" data-width='' data-align="center">年购买金额(元)</th>
                  <th data-field="" data-width='' data-align="center">金额占比</th>
                  <th data-field="" data-width='' data-align="center">前十名供应商金额合计(元)</th>
                  <th data-field="" data-width='' data-align="center">前十名供应商金额占比</th>
                  <th data-field="" data-width='' data-align="center">年关联交易金额(元)</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
    </c:if>

      </div>
</c:if>
      <!-- 5、高管商旅信息 -->
<c:if test="${templetMap.executivesBusinessInfo != null}">
      <div>
        <div id="executivesBusinessInfo" class="basicText">
          <div class="pull-left"><font size="5px">${templetMap.executivesBusinessInfo}</font></div>
        </div>
    <c:if test="${templetMap.legalFly != null}">    
        <div id="legalFly" class="basicText">
          <div class="pull-left"><font size="4.5px">${templetMap.legalFly}</font></div>
        </div>
        <!-- 总体出行分析信息 -->
        <c:if test="${templetMap.frdbcjztcx != null}">
          <div id="frdbcjztcx" class="alignment tables traval">
            <div class="basicText">
              <div class="pull-left">${templetMap.frdbcjztcx}</div>
            </div>
            <c:choose>
              <c:when test="${test == null || fn:length(test) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">年飞行次数</th>
                      <th data-align="center">飞行月数</th>
                      <th data-align="center">最繁忙月份乘机X次</th>
                      <th data-align="center">年均折扣</th>
                      <th data-align="center">商务舱乘机次数</th>
                      <th data-align="center">公共舱乘机次数</th>
                      <th data-align="center">经济舱乘机次数</th>
                      <th data-align="center">最频繁乘机出发城市</th>
                      <th data-align="center">最频繁乘机到达城市</th>
                      <th data-align="center">最频繁使用天数</th>
                      <th data-align="center">国内飞行次数</th>
                      <th data-align="center">国外飞行次数</th>
                      <th data-align="center">免费次数</th>
                      <th data-align="center">平均票价</th>
                      <th data-align="center">延误时间</th>
                      <th data-align="center">平均延误时间</th>
                      <th data-align="center">平均提前多少天出票</th>
                      <th data-align="center">最后飞行时间</th>
                      <th data-align="center">最后起飞时间</th>
                      <th data-align="center">最后起飞城市</th>
                      <th data-align="center">飞行的总里数</th>
                    </tr>
                    <tr>
                      <td colspan="22" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${test}" var="fdztcxi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>1年飞行次数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>飞行月数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>最繁忙月份乘机次数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>1年平均折扣</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>商务舱乘机次数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>公共舱乘机次数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>经济舱乘机次数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>最频繁乘机出发城市</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight ">
                            <label>最频繁乘机到达城市 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>最频繁使用天数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>国内飞行次数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>国外飞行次数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>免费次数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>平均票价</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>延误时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>平均延误时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>平均提前出票天数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>最后飞行时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>最后起飞时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>最后起飞城市</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-12">
                        <div class="row basicText2">
                          <div class="col-xs-2">
                            <label>飞行总理数 </label>
                          </div>
                          <div class="col-xs-10 nonePaddingRight">
                            <input type="text" value=""/>
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
        <!-- 商务出行分析 -->
        <c:if test="${templetMap.frdbcjswcx != null}">
          <div id="frdbcjswcx" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.frdbcjswcx}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableFdswcx" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="" data-width='' data-align="center">常乘出舱位</th>
                  <th data-field="" data-width='' data-align="center">城市广泛度</th>
                  <th data-field="" data-width='' data-align="center">飞行次数</th>
                  <th data-field="" data-width='' data-align="center">主要活动城市</th>
                  <th data-field="" data-width='' data-align="center">占总体比</th>
                  <th data-field="" data-width='' data-align="center">飞行总里程</th>
                  <th data-field="" data-width='' data-align="center">国内飞行次数</th>
                  <th data-field="" data-width='' data-align="center">国外飞行次数</th>
                  <th data-field="" data-width='' data-align="center">平均折扣</th>
                  <th data-field="" data-width='' data-align="center">平均票价</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
        </c:if>
	</c:if>
        &nbsp;
    <c:if test="${templetMap.shareholderFly != null}"></c:if>
        <div  class="basicText">
          <div class="pull-left"><font size="4.5px">${templetMap.shareholderFly}</font></div>
        </div>
        <!-- 总体出行分析信息 -->
        <c:if test="${templetMap.kggdztcxfx != null}">
          <div id="kggdztcxfx" class="alignment tables traval">
            <div class="basicText">
              <div class="pull-left">${templetMap.kggdztcxfx}</div>
            </div>
            <c:choose>
              <c:when test="${test == null || fn:length(test) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">年飞行次数</th>
                      <th data-align="center">飞行月数</th>
                      <th data-align="center">最繁忙月份乘机X次</th>
                      <th data-align="center">年均折扣</th>
                      <th data-align="center">商务舱乘机次数</th>
                      <th data-align="center">公共舱乘机次数</th>
                      <th data-align="center">经济舱乘机次数</th>
                      <th data-align="center">最频繁乘机出发城市</th>
                      <th data-align="center">最频繁乘机到达城市</th>
                      <th data-align="center">最频繁使用天数</th>
                      <th data-align="center">国内飞行次数</th>
                      <th data-align="center">国外飞行次数</th>
                      <th data-align="center">免费次数</th>
                      <th data-align="center">平均票价</th>
                      <th data-align="center">延误时间</th>
                      <th data-align="center">平均延误时间</th>
                      <th data-align="center">平均提前多少天出票</th>
                      <th data-align="center">最后飞行时间</th>
                      <th data-align="center">最后起飞时间</th>
                      <th data-align="center">最后起飞城市</th>
                      <th data-align="center">飞行的总里数</th>
                    </tr>
                    <tr>
                      <td colspan="22" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${test}" var="kggdztcxi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>1年飞行次数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>飞行月数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>最繁忙月份乘机次数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>1年平均折扣</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft ">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>商务舱乘机次数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>公共舱乘机次数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>经济舱乘机次数 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>最频繁乘机出发城市</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>最频繁乘机到达城市 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>最频繁使用天数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>国内飞行次数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>国外飞行次数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>免费次数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>平均票价</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>延误时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>平均延误时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>平均提前出票天数</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>最后飞行时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft ">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight ">
                            <label>最后起飞时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>最后起飞城市</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-12">
                        <div class="row basicText2">
                          <div class="col-xs-2">
                            <label>飞行总理数 </label>
                          </div>
                          <div class="col-xs-10 nonePaddingRight">
                            <input type="text" value=""/>
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
        <!-- 商务出行分析 -->
        <c:if test="${templetMap.kggdswcx != null}">
          <div id="kggdswcx" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.kggdswcx}</div>
            </div>
            <div class="tableContainer" style="">
              <table id="detailTableKggdsw" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="" data-width='' data-align="center">常乘出舱位</th>
                  <th data-field="" data-width='' data-align="center">城市广泛度</th>
                  <th data-field="" data-width='' data-align="center">飞行次数</th>
                  <th data-field="" data-width='' data-align="center">主要活动城市</th>
                  <th data-field="" data-width='' data-align="center">占总体比</th>
                  <th data-field="" data-width='' data-align="center">飞行总里程</th>
                  <th data-field="" data-width='' data-align="center">国内飞行次数</th>
                  <th data-field="" data-width='' data-align="center">国外飞行次数</th>
                  <th data-field="" data-width='' data-align="center">平均折扣</th>
                  <th data-field="" data-width='' data-align="center">平均票价</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
        </c:if>
      </div>
</c:if>
      <!-- 6、特殊事项 -->
<c:if test="${templetMap.specialEventInfo != null}">
      <div>
        <div id="specialEventInfo" class="basicText">
          <div class="pull-left"><font size="5px">${templetMap.specialEventInfo}</font></div>
        </div>
    <c:if test="${templetMap.wfwg != null}">
        <div id="wfwg" class="basicText">
          <div class="pull-left"><font size="4.5px">${templetMap.wfwg}</font></div>
        </div>

        <!-- 裁判文书信息 -->
        <c:if test="${templetMap.wfwgcpws != null}">
          <div id="wfwgcpws" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.wfwgcpws}</div>
            </div>
            <c:choose>
              <c:when test="${wfwgcpInfo == null || fn:length(wfwgcpInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">裁判文书ID</th>
                      <th data-align="center">审结时间</th>
                      <th data-align="center">文书类型</th>
                      <th data-align="center">内容</th>
                      <th data-align="center">法院名称</th>
                      <th data-align="center">案由编码</th>
                      <th data-align="center">标题</th>
                      <th data-align="center">审判员</th>
                      <th data-align="center">案号</th>
                    </tr>
                    <tr>
                      <td colspan="10" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${wfwgcpInfo}" var="wfwgcpi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>裁判文书ID</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${wfwgcpi.cpwsId}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>审结时间</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${wfwgcpi.endTime}"/>
                          </div>
                          en
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>内容</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${wfwgcpi.content}" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>标题 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${wfwgcpi.title}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>法院名称 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${wfwgcpi.court}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案由编码</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${wfwgcpi.caseNo}"/>
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
        <c:if test="${templetMap.wfwgzxgg != null}">
          <div id="wfwgzxgg" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.wfwgzxgg}</div>
            </div>
            <c:choose>
              <c:when test="${agentCoutEnforceInfo == null || fn:length(agentCoutEnforceInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
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
                    <tr>
                      <td colspan="13" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentCoutEnforceInfo}" var="wfwgzxggi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>执行公告ID</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${wfwgzxggi.exeId }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>立案时间</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${wfwgzxggi.caseDate }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>内容</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${wfwgzxggi.content }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>标题</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${wfwgzxggi.title }" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>执行状态 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${wfwgzxggi.status }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>被执行人姓名</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${wfwgzxggi.executee }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>执行法院名称 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${wfwgzxggi.court }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>申请人</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${wfwgzxggi.applicant }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>案号 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${wfwgzxggi.caseNo }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案件状态</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${wfwgzxggi.caseStatus }"/>
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
                            <input type="text" value="${wfwgzxggi.idCardNo}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行标的</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${wfwgzxggi.execMoney}"/>
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
	</c:if>
        &nbsp;
    <c:if test="${templetMap.fddbrsx != null}">
        <div id="fddbrsx" class="basicText">
          <div class="pull-left"><font size="4.5px">${templetMap.fddbrsx}</font></div>
        </div>

        <!-- 裁判文书信息 -->
        <c:if test="${templetMap.fdrsxcpws != null}">
          <div id="fdrsxcpws" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.fdrsxcpws}</div>
            </div>
            <c:choose>
              <c:when test="${agentTopLeaderJudgentDocInfo == null || fn:length(agentTopLeaderJudgentDocInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">审结时间</th>
                      <th data-align="center">案件类型</th>
                      <th data-align="center">案由</th>
                      <th data-align="center">标题</th>
                      <th data-align="center">审理程序</th>
                      <th data-align="center">当事人ID</th>
                      <th data-align="center">匹配度</th>
                      <th data-align="center">法院名称</th>
                      <th data-align="center">裁判文书ID</th>
                      <th data-align="center">案号</th>
                    </tr>
                    <tr>
                      <td colspan="11" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentTopLeaderJudgentDocInfo}" var="fdrsxcpi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>审结时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrsxcpi.date}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>文书类型</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxcpi.caseType}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>案由</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrsxcpi.caseCauseCode}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>审判员</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${fdrsxcpi.judger}" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>法院名称</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxcpi.court }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxcpi.caseNo }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>裁判文书ID </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrsxcpi.docId }"/>
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
        <c:if test="${templetMap.fdrsxzxgg != null}">
          <div id="fdrsxzxgg" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.fdrsxzxgg}</div>
            </div>
            <c:choose>
              <c:when test="${fdrsxzxInfo == null || fn:length(fdrsxzxInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
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
                    <tr>
                      <td colspan="13" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${fdrsxzxInfo}" var="fdrsxzxi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>审结时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrsxzxi.endTime }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>内容</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxzxi.content }"/>
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
                            <input type="text" value="${fdrsxzxi.status }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行法院名称</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${fdrsxzxi.court }" style="border-right:none;"/>
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
                            <input type="text" value="${fdrsxzxi.applicant }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>身份证</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxzxi.identCardNo }"/>
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
                            <input type="text" value="${fdrsxzxi.statement }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>数据类型</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxzxi.caseType }"/>
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
                            <input type="text" value="${fdrsxzxi.title }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>匹配度</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxzxi.matchDegree }"/>
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
                            <input type="text" value="${fdrsxzxi.name }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxzxi.caseCod }"/>
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
                            <input type="text" value="${fdrsxzxi.caseStatus }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行标的</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxzxi.execMony }"/>
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
        <c:if test="${templetMap.fdrsxsxgg != null}">
          <div id="fdrsxsxgg" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.fdrsxsxgg}</div>
            </div>
            <c:choose>
              <c:when test="${agentTopLeaderDishonourInfo == null || fn:length(agentTopLeaderDishonourInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
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
                      <th data-align="center">省份</th>
                      <th data-align="center">案号</th>
                      <th data-align="center">发布时间</th>
                    </tr>
                    <tr>
                      <td colspan="18" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentTopLeaderDishonourInfo}" var="fdrsxggi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>立案时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrsxggi.caseTime }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>性别</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxggi.dishonourSex }"/>
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
                            <input type="text" value="${fdrsxggi.proformanceStatus }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>失信公告ID</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${fdrsxggi.dishounrNoticeId }" style="border-right:none;"/>
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
                            <input type="text" value="${fdrsxggi.documentId }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行法院名称</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxggi.court }"/>
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
                            <input type="text" value="${fdrsxggi.identityId }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行依据单位</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxggi.enforceBasisUnit }"/>
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
                            <input type="text" value="${fdrsxggi.caseType }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>失信人行为具体情形</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxggi.behivourDescrible }"/>
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
                            <input type="text" value="${fdrsxggi.obligition }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>年龄</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxggi.dishonourAge }"/>
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
                            <input type="text" value="${fdrsxggi.matchDegree }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>姓名</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxggi.dishonourName }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>省份</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrsxggi.caseProvince }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrsxggi.caseNo }"/>
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
                            <input type="text" value="${fdrsxggi.noticeTime }"/>
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
        <c:if test="${templetMap.fdrsxwdhmd != null}">
          <div id="fdrsxwdhmd" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.fdrsxwdhmd}</div>
            </div>
            <c:choose>
              <c:when test="${agentTopLeaderNetloanInfo == null || fn:length(agentTopLeaderNetloanInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">网贷黑名单ID</th>
                      <th data-align="center">贷款时间</th>
                      <th data-align="center">内容</th>
                      <th data-align="center">性别</th>
                      <th data-align="center">居住电话</th>
                      <th data-align="center">信息更新时间</th>
                      <th data-align="center">执行法院</th>
                      <th data-align="center">相关当事人</th>
                      <th data-align="center">未还/罚息</th>
                      <th data-align="center">身份证号</th>
                      <th data-align="center">籍贯地址</th>
                      <th data-align="center">本金/本息(元)</th>
                      <th data-align="center">案号</th>
                      <th data-align="center">居住地址</th>
                      <th data-align="center">邮箱地址</th>
                      <th data-align="center">来源单位名称</th>
                      <th data-align="center">姓名</th>
                      <th data-align="center">年龄</th>
                      <th data-align="center">数据源</th>
                      <th data-align="center">已还金额(元)</th>
                    </tr>
                    <tr>
                      <td colspan="21" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentTopLeaderNetloanInfo}" var="fdrwdhmdi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>贷款时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrwdhmdi.loanTime}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>内容</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrwdhmdi.content}"/>
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
                            <input type="text" value="${fdrwdhmdi.ownerSex}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>居住电话</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${fdrwdhmdi.ownerHomePhone}" style="border-right:none;"/>
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
                            <input type="text" value="${fdrwdhmdi.ownerInforUpdateTime}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行法院</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrwdhmdi.court}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>相关当事人</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrwdhmdi.litigant}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>未还</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrwdhmdi.debt}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>省份证号 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrwdhmdi.ownerIdentityNo}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>籍贯地址</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrwdhmdi.ownerHomeTownAddress}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>本金(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrwdhmdi.principle}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrwdhmdi.caseNo}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>居住地址</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrwdhmdi.ownerAddress}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>邮箱地址</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrwdhmdi.ownerPostAddress}"/>
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
                            <input type="text" value="${fdrwdhmdi.ownerUnit}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>年龄</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrwdhmdi.ownerAge}"/>
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
                            <input type="text" value="${fdrwdhmdi.ownerName}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>数据源</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrwdhmdi.source}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>已还金额(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrwdhmdi.paidMoney}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>手机号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrwdhmdi.ownerMobileNumber}"/>
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
        <!-- 曝光台 -->
        <c:if test="${templetMap.fdrsxbgt != null}">
          <div id="fdrsxbgt" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.fdrsxbgt}</div>
            </div>
            <c:choose>
              <c:when test="${agentTopLeaderCourtExposInfo == null || fn:length(agentTopLeaderCourtExposInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">曝光台ID</th>
                      <th data-align="center">立案时间</th>
                      <th data-align="center">内容</th>
                      <th data-align="center">曝光时间</th>
                      <th data-align="center">当事人类型</th>
                      <th data-align="center">法院名称</th>
                      <th data-align="center">申请人</th>
                      <th data-align="center">身份证/组织机构代码</th>
                      <th data-align="center">案由</th>
                      <th data-align="center">未执行金额(元)</th>
                      <th data-align="center">地址</th>
                      <th data-align="center">当事人</th>
                      <th data-align="center">案号</th>
                      <th data-align="center">依据</th>
                      <th data-align="center">标的金额(元)</th>
                    </tr>
                    <tr>
                      <td colspan="16" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentTopLeaderCourtExposInfo}" var="fdrbgti">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>曝光台ID</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrbgti.exposureId }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>立案日期</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrbgti.caseDate }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>内容</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrbgti.content }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>曝光日期</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${fdrbgti.exposureDate }" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>当事人类型 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrbgti.ownerType }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>法院名称</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrbgti.court }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>申请人</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrbgti.applicant }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>身份证</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrbgti.ownerIdentCardNo }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>身份证 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrbgti.ownerIdentCardNo }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案由</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrbgti.caseCause }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>未执行金额(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrbgti.ownedMoney }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>地址</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrbgti.ownerAddress }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>当事人</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrbgti.litigant }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrbgti.caseNo }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>依据 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${fdrbgti.basis }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>标的金额(元)</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${fdrbgti.applyMoney }"/>
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
    </c:if>
        &nbsp;
    <c:if test="${templetMap.kggdsx != null}">
        <div id="kggdsx" class="basicText">
          <div class="pull-left"><font size="4.5px">${templetMap.kggdsx}</font></div>
        </div>
        <!-- 裁判文书信息 -->
        <c:if test="${templetMap.kggdsxcpws != null}">
          <div id="kggdsxcpws" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.kggdsxcpws}</div>
            </div>
            <c:choose>
              <c:when
                  test="${agentStockHolderJudgentDocInfo == null || fn:length(agentStockHolderJudgentDocInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">审结时间</th>
                      <th data-align="center">文书类型</th>
                      <th data-align="center">内容</th>
                      <th data-align="center">法院名称</th>
                      <th data-align="center">案由编码</th>
                      <th data-align="center">标题</th>
                      <th data-align="center">审判员</th>
                      <th data-align="center">案号</th>
                    </tr>
                    <tr>
                      <td colspan="9" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentStockHolderJudgentDocInfo}" var="kggdcpi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>审结时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdcpi.date }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>文书类型</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdcpi.caseType }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>内容</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdcpi.content }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>法院名称</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${kggdcpi.court }" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>案由编码 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdcpi.caseCauseCode }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>标题</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdcpi.title }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>审判员</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdcpi.judger }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdcpi.caseNo }"/>
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
        <c:if test="${templetMap.kggdsxzxgg != null}">
          <div id="kggdsxzxgg" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.kggdsxzxgg}</div>
            </div>
            <c:choose>
              <c:when test="${agentStockHolderEexdocInfo == null || fn:length(agentStockHolderEexdocInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
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
                    <tr>
                      <td colspan="13" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentStockHolderEexdocInfo}" var="kggdzxi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>审结时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdzxi.endTime }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>内容</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdzxi.content }"/>
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
                            <input type="text" value="${kggdzxi.status }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行法院名称</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${kggdzxi.court }" style="border-right:none;"/>
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
                            <input type="text" value="${kggdzxi.applicant }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>身份证</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdzxi.identCardNo }"/>
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
                            <input type="text" value="${kggdzxi.statement }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>数据类型</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdzxi.caseType }"/>
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
                            <input type="text" value="${kggdzxi.title }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>匹配度</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdzxi.matchDegree }"/>
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
                            <input type="text" value="${kggdzxi.name }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdzxi.caseCod }"/>
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
                            <input type="text" value="${kggdzxi.caseStatus }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行标的</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdzxi.execMony }"/>
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
        <c:if test="${templetMap.kggdsxsxgg != null}">
          <div id="kggdsxsxgg" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.kggdsxsxgg}</div>
            </div>
            <c:choose>
              <c:when test="${agentStockHolderDishonourInfo == null || fn:length(agentStockHolderDishonourInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
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
                      <th data-align="center">省份</th>
                      <th data-align="center">案号</th>
                      <th data-align="center">发布时间</th>
                    </tr>
                    <tr>
                      <td colspan="18" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentStockHolderDishonourInfo}" var="kggdsxi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>立案时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdsxi.caseTime }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>性别</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdsxi.dishonourSex }"/>
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
                            <input type="text" value="${kggdsxi.proformanceStatus }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>失信公告ID</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${kggdsxi.dishounrNoticeId }" style="border-right:none;"/>
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
                            <input type="text" value="${kggdsxi.documentId }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行法院名称</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdsxi.court }"/>
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
                            <input type="text" value="${kggdsxi.identityId }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行依据单位</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdsxi.enforceBasisUnit }"/>
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
                            <input type="text" value="${kggdsxi.caseType }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>失信人行为具体情形</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdsxi.behivourDescrible }"/>
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
                            <input type="text" value="${kggdsxi.obligition }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>年龄</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdsxi.dishonourAge }"/>
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
                            <input type="text" value="${kggdsxi.matchDegree }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>姓名</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdsxi.dishonourName }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>省份</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdsxi.caseProvince }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdsxi.caseNo }"/>
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
                            <input type="text" value="${kggdsxi.noticeTime }"/>
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
        <c:if test="${templetMap.kggdsxwdhmd != null}">
          <div id="kggdsxwdhmd" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.kggdsxwdhmd}</div>
            </div>
            <c:choose>
              <c:when test="${agentStockHolderNetloanInfo == null || fn:length(agentStockHolderNetloanInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-align="center">网贷黑名单ID</th>
                      <th data-align="center">贷款时间</th>
                      <th data-align="center">内容</th>
                      <th data-align="center">性别</th>
                      <th data-align="center">居住电话</th>
                      <th data-align="center">信息更新时间</th>
                      <th data-align="center">执行法院</th>
                      <th data-align="center">相关当事人</th>
                      <th data-align="center">未还/罚息</th>
                      <th data-align="center">身份证号</th>
                      <th data-align="center">籍贯地址</th>
                      <th data-align="center">本金/本息(元)</th>
                      <th data-align="center">案号</th>
                      <th data-align="center">居住地址</th>
                      <th data-align="center">邮箱地址</th>
                      <th data-align="center">来源单位名称</th>
                      <th data-align="center">姓名</th>
                      <th data-align="center">年龄</th>
                      <th data-align="center">数据源</th>
                      <th data-align="center">已还金额(元)</th>
                    </tr>
                    <tr>
                      <td colspan="20" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentStockHolderNetloanInfo}" var="kggdwd">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>贷款时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdwd.loanTime }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>内容</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdwd.content }"/>
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
                            <input type="text" value="${kggdwd.ownerSex }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>居住电话</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${kggdwd.ownerHomePhone }" style="border-right:none;"/>
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
                            <input type="text" value="${kggdwd.ownerInforUpdateTime }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行法院</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdwd.court }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>相关当事人</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdwd.litigant }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>未还</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdwd.debt }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>省份证号 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdwd.ownerIdentityNo }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>籍贯地址</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdwd.ownerHomeTownAddress }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>本金(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdwd.principle }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdwd.caseNo }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>居住地址</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdwd.ownerAddress }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>邮箱地址</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdwd.ownerPostAddress }"/>
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
                            <input type="text" value="${kggdwd.ownerUnit }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>年龄</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdwd.ownerAge }"/>
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
                            <input type="text" value="${kggdwd.ownerName }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>数据源</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdwd.source }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>已还金额(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${kggdwd.paidMoney }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>手机号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${kggdwd.ownerMobileNumber }"/>
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
	</c:if>
        &nbsp;
    <c:if test="${templetMap.qtbl != null}">
        <div id="qtbl" class="basicText">
          <div class="pull-left"><font size="4.5px">${templetMap.qtbl}</font></div>
        </div>
        <!-- 阿里欠贷 -->
        <c:if test="${templetMap.qtblalqd != null}">
          <div id="qtblalqd" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.qtblalqd}</div>
            </div>
            <c:choose>
              <c:when test="${agentAliloadBreakInfo == null || fn:length(agentAliloadBreakInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-align="center">省份</th>
                      <th data-align="center">发布时间</th>
                      <th data-align="center">欠款额度(元)</th>
                      <th data-align="center">违约情况</th>
                      <th data-align="center">货到款时间</th>
                      <th data-align="center">淘宝账户</th>
                      <th data-align="center">法定代表人</th>
                      <th data-align="center">贷款期限</th>
                      <th data-align="center">被执行姓名</th>
                      <th data-align="center">性别</th>
                      <th data-align="center">年龄</th>
                      <th data-align="center">身份证/工商注册号</th>
                    </tr>
                    <tr>
                      <td colspan="12" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentAliloadBreakInfo}" var="qtali">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>省份</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtali.province }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>发布时间</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtali.exposureTime }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>欠款额度(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtali.ownedMoney }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>违约情况</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${qtali.brief }" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>贷款到期时间 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtali.loanDate }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>淘宝账户</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtali.taobaoAccount }"/>
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
                            <input type="text" value="${qtali.juridicalPerson }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>贷款期限</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtali.loanDueTime }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>被执行人姓名 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtali.ownedName }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>性别</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtali.ownerSex }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>身份证号码</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtali.ownerIdentityCardId }"/>
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
        <c:if test="${templetMap.qtblwdhmd != null}">
          <div id="qtblwdhmd" class="tables">
            <div class="basicText">
              <div class="pull-left">${templetMap.qtblwdhmd}</div>
            </div>
            <c:choose>
              <c:when test="${agentotherNetloanInfo == null || fn:length(agentotherNetloanInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">网贷黑名单ID</th>
                      <th data-align="center">贷款时间</th>
                      <th data-align="center">内容</th>
                      <th data-align="center">性别</th>
                      <th data-align="center">居住电话</th>
                      <th data-align="center">信息更新时间</th>
                      <th data-align="center">执行法院</th>
                      <th data-align="center">相关当事人</th>
                      <th data-align="center">未还/罚息</th>
                      <th data-align="center">身份证号</th>
                      <th data-align="center">籍贯地址</th>
                      <th data-align="center">本金/本息(元)</th>
                      <th data-align="center">案号</th>
                      <th data-align="center">居住地址</th>
                      <th data-align="center">邮箱地址</th>
                      <th data-align="center">来源单位名称</th>
                      <th data-align="center">姓名</th>
                      <th data-align="center">年龄</th>
                      <th data-align="center">数据源</th>
                      <th data-align="center">已还金额(元)</th>
                    </tr>
                    <tr>
                      <td colspan="21" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${agentotherNetloanInfo}" var="qtwdi">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>贷款时间</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtwdi.loanTime }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>内容</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtwdi.content }"/>
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
                            <input type="text" value="${qtwdi.ownerSex }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>居住电话</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${qtwdi.ownerHomePhone }" style="border-right:none;"/>
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
                            <input type="text" value="${qtwdi.ownerInforUpdateTime }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行法院</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtwdi.court }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>相关当事人</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtwdi.litigant }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>未还</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtwdi.debt }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>省份证号 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtwdi.ownerIdentityNo }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>籍贯地址</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtwdi.ownerHomeTownAddress }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>本金(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtwdi.principle }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtwdi.caseNo }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>居住地址</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtwdi.ownerAddress }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>邮箱地址</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtwdi.ownerPostAddress }"/>
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
                            <input type="text" value="${qtwdi.ownerUnit }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>年龄</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtwdi.ownerAge }"/>
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
                            <input type="text" value="${qtwdi.ownerName }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>数据源</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtwdi.source }"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3">
                            <label>已还金额(元)</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${qtwdi.paidMoney }"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>手机号</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${qtwdi.ownerMobileNumber }"/>
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
    </c:if>
      </div>
</c:if>
      <!-- 7、法院信息 -->
<c:if test="${templetMap.courtInfo != null}">
      <div>
      	<div id="courtInfo" class="basicText">
          <div class="pull-left"><font size="5px">${templetMap.courtInfo}</font></div>
        </div>
        <!-- 法院被执行信息 -->
        <c:if test="${templetMap.special != null}">
          <div id="special" class="tables">
            <div class="basicText">
              <div class="pull-left"><font size="5px">${templetMap.special}</font></div>
            </div>
            <c:choose>
              <c:when test="${specialInfo == null || fn:length(specialInfo) == 0}">
                <div class="tableContainer">
                  <table data-toggle="" data-cache="false" data-pagination="true"
                         data-side-pagination="server" data-url=""
                         class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-align="center">被执行人</th>
                      <th data-align="center">执行标的</th>
                      <th data-align="center">执行法院</th>
                      <th data-align="center">案件状态</th>
                      <th data-align="center">案号</th>
                      <th data-align="center">立案时间</th>
                      <th data-align="center">性别</th>
                      <th data-align="center">年龄</th>
                      <th data-align="center">省份证号</th>
                      <th data-align="center">省份证始发地</th>
                      <th data-align="center">法定代表人</th>
                      <th data-align="center">省份</th>
                      <th data-align="center">信息获取时间</th>
                    </tr>
                    <tr>
                      <td colspan="14" align="center">没有记录</td>
                    </tr>
                    </thead>
                  </table>
                </div>
              </c:when>
              <c:otherwise>
                <c:forEach items="${specialInfo}" var="spec">
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>
                              被执行人
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${spec.name}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行标的</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${spec.object}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>执行法院</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${spec.court}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案件状态</label>
                          </div>
                          <div class="col-xs-9">
                            <input type="text" value="${spec.statuName}" style="border-right:none;"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>案号 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${spec.num}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>立案时间</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="<fmt:formatDate value="${spec.caseDate}" pattern="yyyy-MM-dd"/>"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>性别</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${spec.sex}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>年龄</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${spec.ageStr}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>省份证号</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${spec.cardNumber}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>身份证始发地</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight" type="text" value="${spec.indentityDepature}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>法定代表人</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${spec.head}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label>省份</label>
                          </div>
                          <div class="col-xs-9 nonePaddingRight">
                            <input type="text" value="${spec.province}"/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingLeft">
                            <label class="borderBottomColor">信息获取日期</label>
                          </div>
                          <div class="col-xs-9">
                            <input class="noneBorderRight borderBottomColor" type="text" value="<fmt:formatDate value="${spec.getinfoDate}" pattern="yyyy-MM-dd"/>"/>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:forEach>
                <div class="marginTopSmall">
                  <span style="color: red;font-weight: bold;">备注：</span>
                  <ul style="list-style: none;margin-left: -35px;" class="marginTopSmall">
                    <li>1、执行状态分未执行完毕、不予执行、执行完毕、终结执行四种；</li>
                    <li>2、案件是否执行完毕以"执行状态"为准，"执行状态"标记为"执行完毕"表示该案件已结案；</li>
                    <li>3、本报告保留案件的历史信息，标记为"执行完毕"的案件，"未执行标的"仍将显示；</li>
                    <li>4、"未执行标的"显示为1元的，表示该案件申请的是行为执行。</li>
                  </ul>
                </div>
              </c:otherwise>
            </c:choose>
          </div>
        </c:if>
      </div>
</c:if>
	<!-- 8、评分信息 -->
<c:if test="${templetMap.scoreInfo != null}">
      <div>
      	<div id="scoreInfo" class="basicText">
          <div class="pull-left"><font size="5px">${templetMap.scoreInfo}</font></div>
        </div>
        <c:if test="${templetMap.pfzb != null}">
          <div id="pfzb" class="tables">
            <div class="basicText">
              <div class="pull-left"><font size="5px">${templetMap.pfzb}</font></div>
            </div>
            <div class="tableContainer" style="">
              <table id="pfzbTable" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="id" data-visible=false>主键</th>
                  <th data-field="itemName" data-width='10%' data-align="left"></th>
                  <th data-field="base" data-width='18%' data-align="center">基本信息</th>
                  <th data-field="special" data-width='18%' data-align="center">特殊事项</th>
                  <!-- <th data-field="history" data-width='18%' data-align="center">信用历史</th>  -->
                  <th data-field="behavior" data-width='18%' data-align="center">交易行为</th>
                  <th data-field="capacity" data-width='15%' data-align="right">履约能力</th>
                </tr>
                </thead>
              </table>
            </div>
            <div class="marginTopSmall">
              <span style="color: red;font-weight: bold;"> 备注：</span> 详细信息请参考评分指标报告
            </div>
          </div>
        </c:if>
      </div>
</c:if>
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
</div>
<a href="#top" class="btn top" title="回到顶部">
  <span class="icon-angle-up"></span>
</a>
<a href="#bottom" class="btn bottom" title="回到底部">
  <span class="icon-angle-down"></span>
</a>
<script>
  // Delphi RF

  //   动态生成标题方法
  function creactTitle(titleData) {
      var strContainer = ''
    	$(titleData).each(function(i, dom) {
			  var str = ''
        str += '<div><div><a href="#'+this.key+'" >'+this.name+'</a></div><div>'
        if(dom.children) {
      	  $(dom.children).each(function(j, childDom) {
            if(childDom.children) {
          	  //  此为三级
          	  str += '<div><div><a href="#'+this.key+'" >'+this.name+'</a></div><div>'
          	  $('#'+this.key).children().eq(0).html(this.name)
      		    $(childDom.children).each(function(n, childChildDom) {
      		  	  if(dom.children.length === j+1) {
                  if(childDom.children.length === n+1) {
      		  		    str += '<a href="#'+this.key+'" >'+this.name+'</a></div></div></div></div>'
      		  	      $('#'+this.key).children().eq(0).html(this.name)
      		  	    } else {
      		  		    str += '<a href="#'+this.key+'" >'+this.name+'</a>'
      		  	    }
          	    } else {
          	    	if(childDom.children.length === n+1) {
      		  	      str += '<a href="#'+this.key+'" >'+this.name+'</a></div></div>'
      		  	    } else {
      		  		    str += '<a href="#'+this.key+'" >'+this.name+'</a>'
      		  	    }
          	    }
      		    })
      	    } else {
      	  	  //    此为只有二级
      	  	  if(dom.children.length === j+1) {
      	  		  str += '<a href="#'+this.key+'" >'+this.name+'</a></div></div>'
      	  	  } else {
      	  		  str += '<a href="#'+this.key+'" >'+this.name+'</a>'
      	  	  }
      	    }
      	  })
        }
        strContainer += str
		  })
    	$('#detailTitle').append(strContainer)
    }
  var templetList = '${templetList}';
  creactTitle(JSON.parse(templetList))
  
  var dengji = "${data.level}";
  var algorCode = "${algorithmType}";
  checkColor(dengji, ".textColor");
  var baseUrl = "${pageContext.request.contextPath}/creditReport/";
  $("#creditReportDetail input,textarea").attr("readonly", "readonly");

  $("a.backA").on("click", function (e) {
    if (!$(this).hasClass("pdf_btn")) {//pdf预览和下载不做ajax请求
      $("#content").load("./credit-report.jsp", {id: "${regId}", algorithmType: algorCode});
    }
  });
  
  $("#viewReport").on("click", function(e){
	  e.preventDefault()
	    var _self = this
	    $.ajax({
	      url: "/creditsupport/login/checkSession?_time"+new Date().getTime(),
	      type:"post",
	      dataType:"json",
	      async: false,
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
	        } else {
	          newWin(_self.href, 'viewReport')
	        }
	      }
	    });
	});

  //列表索引
  function indexFormatter(value, row, index) {
    return index + 1;
  }
  function mFormatter(value, row, index) {
    return value + " (" + row.curTypeName + ")";
  }
  function stockFormatter(value, row, index) {
    if (value) {
      value = value.replace(new RegExp(/\s/g), '');
      if (value) return value;
    }
    return "${data.curTypeName}";
  }

  $('#detailTable5').bootstrapTable({data: jQuery.parseJSON('${legPerJson1}')});
  $('#detailTable6').bootstrapTable({data: jQuery.parseJSON('${legPerJson2}')});
  $('#detailTable1').bootstrapTable({data: jQuery.parseJSON('${entAttrInfo}')});
  $('#detailTable2').bootstrapTable({data: jQuery.parseJSON('${stockholderInfo}')});
  $('#detailTable3').bootstrapTable({data: jQuery.parseJSON('${topManagerInfo}')});
  $('#detailTable4').bootstrapTable({data: jQuery.parseJSON('${othEntInvestsInfo}')});
  $('#detailTableQybg').bootstrapTable({data: jQuery.parseJSON('${agentChangeInfo}')});
  $('#detailTableQingsuan').bootstrapTable({data: jQuery.parseJSON('${liquidationInfo}')});
  $('#detailTableDcdyw').bootstrapTable({data: jQuery.parseJSON('${mortgageItemInfo}')});
  $('#detailTableGqczls').bootstrapTable({data: jQuery.parseJSON('${agentSharesImpawInfo}')});
  $('#detailTableJywdxzb').bootstrapTable({data: jQuery.parseJSON('${merchantStabilityInfo}')});
  $('#detailTableSyl').bootstrapTable({data: jQuery.parseJSON('${agentTaxAccountInfo}')});
  $('#detailTableFsl').bootstrapTable({data: jQuery.parseJSON('${agentTaxAccountInfo}')});
  $('#detailTableZzsybnsr').bootstrapTable({data: jQuery.parseJSON('${agentTaxAccountInfo}')});
  $('#detailTableYxse').bootstrapTable({data: jQuery.parseJSON('${agentTaxAccountInfo}')});
  $('#detailTableZrsmoney').bootstrapTable({data: jQuery.parseJSON('${agentTaxAccountInfo}')});
  $('#detailTableJybhqs').bootstrapTable({data: jQuery.parseJSON('${merchantTrandeReportChangeInfo}')});
  $('#detailTableBsthdb').bootstrapTable({data: jQuery.parseJSON('${merchantTrandeReportConstrastInfo}')});
  $('#detailTableKhdyfb').bootstrapTable({data: jQuery.parseJSON('${merchantTrandeReportAreaInfo}')});
  $('#detailTableKhzcd').bootstrapTable({data: jQuery.parseJSON('${merchantTrandeReportLoyaltyInfo}')});
  $('#detailTableZcfz').bootstrapTable({data: jQuery.parseJSON('${balanceSheetInfo}')});
  $('#detailTableProfit').bootstrapTable({data: jQuery.parseJSON('${profitInfo}')});
  $('#pfzbTable').bootstrapTable({data: jQuery.parseJSON('${basicIndiScore}')});
  /* 一下6项没有数据库表，所以暂时放在这，以后决定是否删除
   * 在表ods_templet_dict里的对应记录如下
   * 409	客户信息		kh			4.9
   * 408	供应商信息		gys			4.8
   * 50101	法人代表总体出行	frdbcjztcx	5.1.1		
   * 50102	法人代表商务出行	frdbcjswcx	5.1.2		
   * 50201	股东总体出行	kggdztcxfx	5.2.1		
   * 50202	股东商务出行	kggdswcx	5.2.2
   * 还有两项不是用bootstrapTable来显示的
   */
   $('#detailTableGys').bootstrapTable({data: jQuery.parseJSON('${test}')});
   $('#detailTableKh').bootstrapTable({data: jQuery.parseJSON('${test}')});
   $('#detailTableFdswcx').bootstrapTable({data: jQuery.parseJSON('${test}')});
   $('#detailTableKggdsw').bootstrapTable({data: jQuery.parseJSON('${test}')});
</script>