<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="row" id="basicdetail" >
  <div class="col-xs-12 marginLeft marginTop">
    <p class="sumTitle"><a href="company-manage.jsp" class="returnIndex">企业管理</a> > 基本信息</p>
  </div>
  <div class="col-xs-12 marginLeft">
    <div class="basicContainer kuang" style="margin-bottom: 20px;">
      <div style="padding-bottom: 30px;">
        <p class="link marginTopSmall">
          <a href="./company-manage.jsp" class="returnIndex">< 返回企业列表</a>
        </p>
        <div class="text-center basicTitle">${data.compName}基本信息</div>
        <div class="text-center as" style="border-bottom: 1px solid #e3ebf3;">
          <a href="#anchor1" class="btn btnColor btnPadding" target="_self">工商注册信息</a>
          <a href="#anchor2" class="btn btnColor btnPadding" target="_self">联系地址</a>
          <a href="#anchor3" class="btn btnColor btnPadding" target="_self">股东信息</a>
          <a href="#anchor4" class="btn btnColor btnPadding" target="_self">高管信息</a>
          <a href="#anchor5" class="btn bgBtn" style="padding-top: 10px;" target="_self">对外股权投资信息</a>
          <a href="#anchor6" class="btn bgBtn" target="_self">法定代表人在其他机构任职信息</a>
          <a href="#anchor7" class="btn bgBtn" target="_self">法定代表人股权投资信息</a>
          <a href="#anchor8" class="btn bgBtn" target="_self">被投资机构概要信息</a>
          <a href="#anchor9" class="btn btnColor btnPadding" target="_self">企业变更信息</a>
          <a href="#anchor10" class="btn btnColor btnPadding" target="_self">分支机构信息</a>
          <a href="#anchor11" class="btn btnColor btnPadding" target="_self">清算信息</a>
          <a href="#anchor12" class="btn btnColor btnPadding" target="_self">动产抵押信息</a>
          <a href="#anchor13" class="btn btnColor btnPadding" target="_self">动产抵押物信息</a>
          <a href="#anchor14" class="btn btnColor btnPadding" target="_self">股权冻结历史信息</a>
          <a href="#anchor15" class="btn btnColor btnPadding" target="_self">股权出质历史信息</a>
          <a class="btn" id="iconBtn" title="全部展开/收起">
            <span class="icon-double-angle-up"></span> <!--icon-double-angle-down  icon-double-angle-up  -->
          </a>
        </div>
        <div id="anchor1">
          <div class="basicText">
            <div class="pull-left">工商注册信息</div>
            <span class="pull-right" >收起 >></span>
          </div>
          <div class="isShow">
            <div class="row">
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight">
                    <label>
                      法人姓名
                      <span>*</span>
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" name="" placeholder="" value="${data.lperName}"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft" >
                    <label>
                      企业状态
                      <span>*</span>
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" value="${entStatus}"/>
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
                      <span>*</span>
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" name="" value="${data.regAssetsStr}（万元）"/>
                  </div>
                </div>
              </div>
              <div class="col-xs-6">
                <div class="row basicText2">
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                    <label>
                      开业日期
                      <span>*</span>
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft">
                    <input type="text" name="" value="<fmt:formatDate value="${data.openDate}" pattern="yyyy-MM-dd"/>" style="border-right:none;"/>
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
                    <input type="text" name="" value="${data.curTypeName}"/>
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
                    <input type="text" name="" value="${data.opePeriod}" style="border-right:none;"/>
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
                    <input type="text" name="" value="${data.orgCode}"/>
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
                    <input class="noneBorderRight" type="text" name="" value="<fmt:formatDate value="${data.validDate}" pattern="yyyy-MM-dd"/>"/>
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
                      <span>*</span>
                    </label>
                  </div>
                  <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                    <input type="text" name="" value="${data.regId}"/>
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
                    <input class="noneBorderRight" type="text" name="" value="${data.lastYear}"/>
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
                    <input type="text" name="" value="${data.typeEnt}"/>
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
                  <div class="col-xs-9 nonePaddingLeft">
                    <input class="noneBorderRight" type="text" name="" value="<fmt:formatDate value="${data.lastDate}" pattern="yyyy-MM-dd"/>"/>
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
                    <input type="text" name="" value="${data.typeOrg}"/>
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
                    <input class="noneBorderRight" type="text" name="" value="<fmt:formatDate value="${data.cancelledDate}" pattern="yyyy-MM-dd"/>"/>
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
                    <input type="text" name="" value="${data.emps}"/>
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
                    <input class="noneBorderRight" type="text" name="" value="<fmt:formatDate value="${data.revokDate}" pattern="yyyy-MM-dd"/>"/>
                  </div>
                </div>
              </div>
            </div>
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
            <div class="row basicText3">
              <div class="col-xs-2">
                <label>企业网址</label>
              </div>
              <div class="col-xs-10">
                <input type="text" value="${data.webSite}" />
              </div>
            </div>
            <div class="row basicText3">
              <div class="col-xs-2">
                <label>
                                       工商登记机关
                </label>
              </div>
              <div class="col-xs-10">
                <input type="text" value="${data.regAuth}" />
              </div>
            </div>
            <div class="row basicText3">
              <div class="col-xs-2">
                <label>所属行业</label>
              </div>
              <div class="col-xs-10">
                <input type="text" value="${data.industry}" />
              </div>
            </div>
            <div class="row basicText3">
              <div class="col-xs-2">
                <label>特殊标识</label>
              </div>
              <div class="col-xs-10">
                <input type="text" value="${data.speMark}" />
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
       
        <div class="tables " id="anchor2">
          <div class="basicText">
            <div class="pull-left">联系地址</div>
            <span class="pull-right">展开 >></span>
          </div>
          <div class="tableContainer isShow" style="display: none;">
            <div>
              <table id="basicTable1" data-toggle="" data-cache="false" data-pagination="true"
                     data-side-pagination="server" data-url=""
                     class="table table-striped">
                <thead>
                <tr>
                  <th data-field="id" data-visible=false>主键</th>
                  <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                  <th data-field="typeName" data-width='10%' data-align="left">类型</th>
                  <th data-field="district" data-width='14%' data-align="left">行政区域</th>
                  <th data-field="addr" data-width='30%' data-align="left" data-title-tooltip="">联系地址</th>
                  <th data-field="tel" data-width='22%' data-align="left">联系电话</th>
                  <th data-field="post" data-width='18%' data-align="right">邮政编码</th>
                </tr>
                </thead>
              </table>
            </div>
          </div>
        </div>
      
        <div class="tables" id="anchor3">
          <div class="basicText">
            <div class="pull-left">股东信息</div>
            <span class="pull-right">展开 >></span>
          </div>
          <div class="tableContainer isShow" style="display: none;">
            <table id="basicTable2" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="id" data-visible=false>主键</th>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="name" data-width='' data-align="left" data-title-tooltip="">股东名称</th>
                <th data-field="identifyType" data-width='' data-align="left">证件类型</th>
                <th data-field="identifyNo" data-width='' data-align="left">证件号码</th>
                <th data-field="country" data-width='' data-align="left">国别</th>
                <th data-field="address" data-width='' data-align="left">股东地址</th>
                <th data-field="cashConStr" data-width='' data-align="left">认缴出资额（万元）</th>
                <th data-field="cashRateStr" data-width='' data-align="left">出资比例（%）</th>
                <th data-field="curTypeName" data-width='' data-align="left" data-formatter="stockFormatter">出资币种</th>
                <th data-field="conDate" data-width='' data-align="right" data-formatter="dateFormatter">出资日期</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
        <div class="tables" id="anchor4">
          <div class="basicText">
            <div class="pull-left">高管信息</div>
            <span class="pull-right">展开 >></span>
          </div>
          <div class="tableContainer isShow"  style="display: none;">
            <table id="basicTable3" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="id" data-visible=false>主键</th>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="name" data-width='' data-align="center">姓名</th>
                <th data-field="sex" data-width='' data-align="center">性别</th>
                <th data-field="identifyType" data-width='' data-align="center">证件名称</th>
                <th data-field="identifyNo" data-width='' data-align="center">证件号码</th>
                <th data-field="phone" data-width='' data-align="center">联系电话</th>
                <th data-field="position" data-width='' data-align="center">职务</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
        <div class="tables" id="anchor5">
          <div class="basicText">
            <div class="pull-left">对外股权投资信息</div>
            <span class="pull-right">展开 >></span>
          </div>
          <div class="tableContainer isShow"  style="display: none;">
            <table id="basicTable4" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
	             <tr>
	              <th data-field="id" data-visible=false>主键</th>
	              <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
	              <th data-field="name" data-width='40%' data-align="left">企业名称</th>
	              <th data-field="regAssetsStr" data-width='15%' data-align="left">注册资本（万元）</th>
	              <th data-field="cashRateStr" data-width='15%	' data-align="right">出资比例</th>
	            </tr>
              </thead>
            </table>
          </div>
        </div>
        <div class="tables" id="anchor6">
          <div class="basicText">
            <div class="pull-left">法定代表人在其他机构任职信息</div>
            <span class="pull-right">展开 >></span>
          </div>
          <div class="tableContainer isShow"  style="display: none;">
            <table id="basicTable5" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="id" data-visible=false>主键</th>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="orgName" data-width='20%' data-align="left" data-title-tooltip="">机构名称</th>
                <th data-field="regNo" data-width='18%' data-align="left">工商注册号</th>
                <th data-field="position" data-width='10%' data-align="left">担任职务</th>
                <th data-field="orgSta" data-width='10%' data-align="left">机构状态</th>
                <th data-field="regAssetsStr" data-width='12%' data-align="left">注册资本(万元)</th>
                <th data-field="entType" data-width='17%' data-align="left" data-title-tooltip="">企业类型</th>
                <th data-field="regAuth" data-width='17%' data-align="left" data-title-tooltip="">登记机关</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
        <div class="tables" id="anchor7">
          <div class="basicText">
            <div class="pull-left">法定代表人股权投资信息</div>
            <span class="pull-right">展开 >></span>
          </div>
          <div class="tableContainer isShow"  style="display: none;">
            <div class="row">
              <div class="col-xs-8 labelInput">
                <div class="row">
                  <div class="col-xs-2 nonePaddingRight investmentTotal">
                    <label>积累投资总数</label>
                  </div>
                  <div class="col-xs-4 nonePaddingRight nonePaddingLeft investmentTotalInput">
                    <input type="text" value='${legPer2Count}'/>
                  </div>
                  <div class="col-xs-3 moneyTotal">
                    <label>积累投资金额(万元)</label>
                  </div>
                  <div class="col-xs-3 nonePaddingRight nonePaddingLeft moneyTotalInput">
                    <input type="text" value='${legPer2Total}'/>
                  </div>
                </div>
              </div>
              <div class="col-xs-4 nonePaddingLeft nullInput">
                <div></div>
              </div>
            </div>
            <table id="basicTable6" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="id" data-visible=false>主键</th>
                <th data-field="" data-width='6%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="entName" data-width='22%' data-align="left" data-title-tooltip="">被投资机构名称</th>
                <th data-field="isLegalName" data-width='9%' data-align="left">是否为法人</th>
                <th data-field="regAssetsStr" data-width='13%' data-align="left">注册资本（万元）</th>
                <th data-field="cashConStr" data-width='13%' data-align="left">认缴出资(万元)</th>
                <th data-field="cashRate" data-width='13%' data-align="left">出资比例（%）</th>
                <th data-field="curTypeName" data-width='10%' data-align="left">币种</th>
                <th data-field="orgSta" data-width='14%' data-align="right">机构状态</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
        <div class="tables" id="anchor8">
          <div class="basicText">
            <div class="pull-left">被投资机构概要信息</div>
            <span class="pull-right">展开 >></span>
          </div>
          <div class="tableContainer isShow"  style="display: none;">
            <table id="basicTable7" data-toggle="" data-cache="false" data-pagination="true"
                   data-side-pagination="server" data-url=""
                   class="table table-striped">
              <thead>
              <tr>
                <th data-field="id" data-visible=false>主键</th>
                <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                <th data-field="entName" data-width='25%' data-align="left" data-title-tooltip="">机构名称</th>
                <th data-field="regNo" data-width='12%' data-align="left">工商注册号</th>
                <th data-field="regAssetsStr" data-width='12%' data-align="left">注册资本(万元)</th>
                <th data-field="curTypeName" data-width='8%' data-align="left">币种</th>
                <th data-field="orgSta" data-width='10%' data-align="left">机构状态</th>
                <th data-field="entType" data-width='10%' data-align="left" data-title-tooltip="">企业类型</th>
                <th data-field="regAuth" data-width='17%' data-align="right" data-title-tooltip="">登记机关</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
        
        <!-- 企业变更信息 -->
      <div class="tables" id="anchor9">
        <div class="basicText">
          <div class="pull-left">企业变更信息</div>
          <span class="pull-right">展开 >></span>
        </div>
        <div class="tableContainer isShow"  style="display: none;">
          <table id="detailTableQybgBasic" data-toggle="" data-cache="false" data-pagination="true"
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
      
      <!-- 分支机构信息 -->
        <div id="anchor10">
        <div class="basicText">
          <div class="pull-left">分支结构信息</div>
          <span class="pull-right">展开 >></span>
        </div>
        <c:choose>
		   <c:when test="${fenzhiInfo == null || fn:length(fenzhiInfo) == 0}">
	         <div class="tableContainer isShow"  style="display: none;">
		            <table data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-align=center data-formatter="indexFormatter">序号</th>
              <th data-align="center">机构名称</th>
              <th data-align="center">一般经营项目</th>
              <th data-align="center">企业注册号</th>
              <th data-align="center">注册所在工商管理局</th>
              <th data-align="center">分支机构地址</th>
              <th data-align="center">分支机构负责人</th>
            </tr>
            </thead>
            <tbody>
            <tr><td colspan="7" align="center">没有记录</td></tr>
            </tbody>
          </table>
          </div>
		       </c:when>
		       <c:otherwise>
		 <div style="display: none;">
        <c:forEach items="${fenzhiInfo}" var="fzi">
        <div class="marginTopSmall fenzhi">
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight">
                  <label>
                    机构名称
                  </label>
                </div>
                <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                  <input type="text" value="${fzi.brName}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingLeft nonePaddingRight">
                  <label>一般经营项目</label>
                </div>
                <div class="col-xs-9 nonePaddingLeft">
                  <input class="nonePaddingLeft" type="text" value="${fzi.cbuItem}"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight">
                  <label>企业注册号</label>
                </div>
                <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                  <input type="text" value="${fzi.brRegNo}"/> 
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                  <label>注册所在工商管理局</label>
                </div>
                <div class="col-xs-9 nonePaddingLeft">
                  <input class="nonePaddingLeft" type="text" value="${fzi.localAdministration}" style="border-right:none;"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight">
                  <label>分支机构地址 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight nonePaddingLeft">
                  <input type="text" value="${fzi.brAddr}"/>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                  <label>分支机构负责人</label>
                </div>
                <div class="col-xs-9 nonePaddingLeft">
                  <input class="nonePaddingLeft" type="text" value="${fzi.brPrincipal}"/>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        </div>
        	 </c:otherwise>
		</c:choose>
      </div>
      
    <!-- 清算信息 -->
      <div class="tables" id="anchor11">
        <div class="basicText">
          <div class="pull-left">清算信息</div>
           <span class="pull-right">展开 >></span>
        </div>
        <div class="tableContainer isShow"  style="display: none;">
          <table id="detailTableQingsuanBasic" data-toggle="" data-cache="false" data-pagination="true"
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
              <th data-field="ligst" data-width='' data-align="center">清算完结情况</th>
            </tr>
            </thead>
          </table>
        </div>
      </div>
    
    <!-- 动产抵押信息 -->
      <div id="anchor12">
        <div class="basicText">
          <div class="pull-left">动产抵押信息</div>
           <span class="pull-right">展开 >></span>
        </div>
        <c:choose>
		       <c:when test="${agentMortgageInfo == null || fn:length(agentMortgageInfo) == 0}">
		         <div class="tableContainer isShow"  style="display: none;">
		      		<table data-toggle="" data-cache="false" data-pagination="true"
                		 data-side-pagination="server" data-url=""class="table table-striped">
			            <thead>
				            <tr>
				              <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
				              <th data-align="center">抵押ID</th>
				              <th data-align="center">登记证号</th>
				              <th data-align="center">抵押人</th>
				              <th data-align="center">申请抵押原因</th>
				              <th data-align="center">抵押权人</th>
				              <th data-align="center">被担保主债权种类</th>
				              <th data-align="center">登记机关</th>
				              <th data-align="center">被担保主债权数额</th>
				              <th data-align="center">登记日期</th>
				              <th data-align="center">履约起始日期</th>
				              <th data-align="center">履约截止日期</th>
				              <th data-align="center">状态标识</th>
				              <th data-align="center">注销日期</th>
				            </tr>
				            <tr><td colspan="14" align="center">没有记录</td></tr>
			            </thead>
         		  </table>
          		</div>
		       </c:when>
		       <c:otherwise>
		<div style="display: none;">
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
        </div>
        	 </c:otherwise>
		</c:choose>
      </div>
      
    <!-- 动产抵押物信息 -->
      <div class="tables" id="anchor13">
        <div class="basicText">
          <div class="pull-left">动产抵押物信息</div>
           <span class="pull-right">展开 >></span>
        </div>
        <div class="tableContainer isShow"  style="display: none;">
          	<table id="detailTableDcdywBasic" data-toggle="" data-cache="false" data-pagination="true"
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
    
    <!-- 股权冻结历史信息 -->
        <div id="anchor14">
        <div class="basicText">
          <div class="pull-left">股权冻结历史信息</div>
           <span class="pull-right">展开 >></span>
        </div>
        <c:choose>
		       <c:when test="${agentSharesInfo == null || fn:length(agentSharesInfo) == 0}">
	              <div class="tableContainer isShow"  style="display: none;">
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
              <th data-align="center">冻结金额</th>
            </tr>
            <tr><td colspan="10" align="center">没有记录</tr>
            </thead>
          </table>
		          </div>
		       </c:when>
		       <c:otherwise>
		<div style="display: none;">
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
                  <input type="text" value="${gpdj.froDocNo }"/>
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
                  <input type="text" value="${gpdj.thawAuth }" style="border-right:none;"/>
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
                  <input class="noneBorderRight" type="text" value="${gpdj.thawCommodsEnt }"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6">
              <div class="row basicText2">
                <div class="col-xs-3">
                  <label>冻结金额 </label>
                </div>
                <div class="col-xs-9 nonePaddingRight">
                  <input type="text" value="${gpdj.froAM }"/>
                </div>
              </div>
            </div>
          </div>
          
        </div>
        </c:forEach>
        </div>
        	 </c:otherwise>
		</c:choose>
      </div>
    
    <!-- 股权出质历史信息 -->
      <div class="tables" id="anchor15">
        <div class="basicText">
          <div class="pull-left">股权出质历史信息</div>
           <span class="pull-right">展开 >></span>
        </div>
        <div class="tableContainer isShow"  style="display: none;">
          <table id="detailTableGqczlsBasic" data-toggle="" data-cache="false" data-pagination="true"
                 data-side-pagination="server" data-url=""
                 class="table table-striped">
            <thead>
            <tr>
              <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
              <th data-field="impOrg" data-width='' data-align="center" data-title-tooltip="">质权人姓名</th>
              <th data-field="impExaeep" data-width='' data-align="center" data-title-tooltip="">出质审批部门</th>
              <th data-field="impOrgType" data-width='' data-align="center">出质人类别</th>
              <th data-field="impSanDate" data-width='' data-align="center">出质批准日期</th>
               <th data-field="impAm" data-width='' data-align="center">出质金额</th>
              <th data-field="impTo" data-width='' data-align="center">出质截止日期</th>
               <th data-field="imponRecDate" data-width='' data-align="center">出备案日期</th>
            </tr>
            </thead>
          </table>
        </div>
      </div>
      
    </div>
  </div>
</div>
<a href="#header" class="btn top" target="_self" title="回到顶部">
  <span class="icon-angle-up"></span>
</a>
<a href="#bottom" class="btn bottom" target="_self" title="回到底部">
  <span class="icon-angle-down"></span>
</a>
<script>
  var id = '${data.regId}';
  //列表索引
  function indexFormatter(value, row, index) {
    return index + 1;
  }
  function mFormatter(value, row, index) {
	  return value + " (" + row.curTypeName + ")";
  }
  function stockFormatter(value, row, index) {
	  if(value) {
		  value = value.replace(new RegExp(/\s/g),'');
		  if(value) return value;
	  }
	  return "${data.curTypeName}";
  }
  
  //日期格式化
  function dateFormatter(value, row, index) {
    if (value) {
      var date = new Date(value);
	  return date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate();
    } else {
      return "";
    }
	  
  }
  
</script>
<script src="${pageContext.request.contextPath}/js/basic.js"></script>
