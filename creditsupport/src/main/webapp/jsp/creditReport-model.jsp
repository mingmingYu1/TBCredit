<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<div class="row" id="modelContainer">
  <div class="col-xs-12 overflow nonePaddingLeft">
    <div class="hideBtn">
      <button class="btn closeLeft">
        <i class="icon-angle-left"></i> <!--   icon-angle-right  -->
      </button>
    </div>
    <div class="oneHeader">
      <!--<p class="title">指标体系</p>-->
      <p class="sumTitle"><a href="./score-manage.jsp">评分模型</a> > 征信报告模板</p>
    </div>
  </div>
  <div class="col-xs-12 marginLeft marginTop">
    <div class="searchInput overflow">
      <div class="pull-left">
        <label>模板编号：</label>
        <input id="modelNumber" class="form-control" type="text" placeholder="请输入模版编号"/>
      </div>
      <div class="pull-left">
        <label>模板名称：</label>
        <input id="modelName" class="form-control" type="text" placeholder="请输入模版名称"/>
        <button class="btn" style="margin-left: 35px;" onclick="creditReportModelSelect()">搜索</button>
        <button class="btn" onclick="clearSearch()">重置</button>
      </div>
    </div>
    <mrp:p rId="341">
      <button class="btn marginTop" id="addModel" data-toggle="modal" data-target="#creditReportModelModal">
        <span class="icon-plus"></span>&nbsp;&nbsp;新增
      </button>
    </mrp:p>
    <div class="tableContainer">
      <div>
        <table id="modelTable" class="table table-striped"></table>
      </div>
    </div>
  </div>
</div>

<!--模板报告页面-->
<div class="modal fade" data-backdrop="static" id="creditReportModelModal" tabindex="-1" role="dialog" aria-labelledby="creditReportModelModal"
     aria-hidden="true">
  <div class="modal-dialog " style="width: 1100px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="addScoreModelTitle">新增</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="creditReportModelForm" action="" method="post">
          <div class="overflow">
            <div class="modalOne overflow pull-left" style="width: 60%;">
              <input id="modelId" type="hidden" name="id"/>
              <div style="width: 100%;">
                <label for=""><span>*</span>模板编号：</label>
                <input class="form-control" maxlength=20 name="modelNumber" placeholder="只能为数字，字母与“_”且长度不超过20位"/>
              </div>
              <div class="marginTop" style="width: 100%">
                <label for=""><span>*</span>模版名称：</label>
                <input class="form-control" maxlength=20 type="text" name="modelName" value="sdhas" placeholder="不可含有点以外的特殊字符且长度不超过20位"/>
              </div>
            </div>
            <div class="pull-right leftModal">
              <div class="pull-left">
                <label style="margin-top: 13px;margin-right: 5px;"><span>*</span>报告类别：</label>
              </div>
              <div class="radioInput pull-left" id="reportCategory"></div>
            </div>
          </div>
          <div class="text-center creditReportDetailTitle marginTop" style="padding-bottom: 0;margin-top: 15px;">
            XXX征信报告
          </div>
          <div class="row" style="padding-bottom: 15px;">
            <div class="col-xs-4 col-xs-offset-8">
              <div class="pull-right reportNumber">
                报告编号：<span>xxxxxxxxxxxxxxx-xxxxxxxx-xxx</span>
              </div>
            </div>
          </div>
          <div class="creditReportListTitle ">
            <div style="padding: 0 13px;">
              <div style="padding: 14px 0;border-bottom: 1px solid #dfe8f1">
                <div class="row">
                  <div class="col-xs-6">
                    <div class="dengJi pull-right">
                      信用等级：<span class="textColor">B&nbsp;良好</span>
                    </div>
                  </div>
                  <div class="col-xs-6">
                    <div class="deFen">
                      信用得分：<span class="textColor">80&nbsp;分</span>
                    </div>
                  </div>
                </div>
              </div>
              <div>
                <div class="marginTop">
                  <label>报告内容：</label>
                </div>
                <div id="checkboxs" class="checkboxInput"></div>
              </div>
            </div>
          </div>
          <div id="concentModel">
            <!-- 一 基本信息 -->
            <div>
              <div id="basicInfo" class="isShow">
                <span class="oneTitle">1、基本信息</span>
              </div>
              <div id="basic" class="isShow">
                <span class="threeTitle">1.1、工商注册信息</span>
                <div>
                  <div class="row">
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            企业名称
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                          <input type="text" value="深圳市永信国际物流集团有限公司" placeholder=""/>
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
                          <input class="noneBorderRight" type="text" value='申请中'/>
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
                          <input type="text" value='2000.0万元'/>
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
                          <input class="noneBorderRight" type="text" value="2004-04-16"/>
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
                          <input type="text" value="人民币"/>
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
                          <input class="noneBorderRight" type="text" value=""/>
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
                          <input type="text" value=""/>
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
                          <input class="noneBorderRight" type="text" value=""/>
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
                          <input type="text" value="440301103402682"/>
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
                          <input class="noneBorderRight" type="text" value="2012"/>
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
                          <input type="text" value="有限责任公司(外商投资企业合资)"/>
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
                          <input class="noneBorderRight" type="text" value="2012-01-01"/>
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
                          <input type="text" value=""/>
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
                          <input class="noneBorderRight" type="text" value=""/>
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
                          <input type="text" value=""/>
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
                          <input class="noneBorderRight" type="text" value=""/>
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
                          <input type="text" value=""/>
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
                          <input class="noneBorderRight" type="text" value=""/>
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
                          <input type="text" value=""/>
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
                          <input class="noneBorderRight" type="text" value=""/>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div class="row basicText3">
                    <div class="col-xs-2">
                      <label>行业分类名称</label>
                    </div>
                    <div class="col-xs-10">
                      <input type="text" value=""/>
                    </div>
                  </div>

                  <!-- jason 添加End -->

                  <div class="row basicText3">
                    <div class="col-xs-2">
                      <label>企业网址</label>
                    </div>
                    <div class="col-xs-10">
                      <input type="text" value=""/>
                    </div>
                  </div>
                  <div class="row basicText3">
                    <div class="col-xs-2">
                      <label>
                        工商登记机关
                      </label>
                    </div>
                    <div class="col-xs-10">
                      <input type="text" value="广东省深圳市罗湖区工商行政管理局"/>
                    </div>
                  </div>
                  <div class="row basicText3">
                    <div class="col-xs-2">
                      <label>所属行业</label>
                    </div>
                    <div class="col-xs-10">
                      <input type="text" value="交通运输、仓储和邮政业"/>
                    </div>
                  </div>
                  <div class="row basicText3">
                    <div class="col-xs-2">
                      <label>特殊标识</label>
                    </div>
                    <div class="col-xs-10">
                      <input type="text" value=""/>
                    </div>
                  </div>
                  <div class="row basicText3">
                    <div class="col-xs-2">
                      <label class="textareaLabel borderBottomColor">经营范围</label>
                    </div>
                    <div class="col-xs-10 textareaContainer">
                      <textarea class="borderBottomColor">承办海运、陆运、空运进出口货物的国际运输代理业务，包括：揽货、托运、订舱、中转、集装箱拼装拆箱、结算运杂费、报关、报验、保险、相关的短途运输服务及运输咨询业务</textarea>
                    </div>
                  </div>
                </div>
              </div>
              <div id="addr" class="isShow">
                <span class="threeTitle">1.2、联系地址和电话信息</span>
                <div>
                  <div class="tableContainer">
                    <table class="table table-striped">
                      <thead>
                      <tr>
                        <th data-width='' data-align="left">序号</th>
                        <th data-width='' data-align="left">类型</th>
                        <th data-width='' data-align="left">行政区域</th>
                        <th data-width='' data-align="left">地址</th>
                        <th data-width='' data-align="left">电话</th>
                        <th data-width='' data-align="right">邮政编码</th>
                      </tr>
                      </thead>
                      <tbody>
                      <tr>
                        <td>1</td>
                        <td>注册</td>
                        <td>福田区</td>
                        <td>6号</td>
                        <td>0394-7096236</td>
                        <td>450000</td>
                      </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <div id="stockH" class="isShow">
                <span class="threeTitle">1.3、股东信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">序号</th>
                      <th data-width='' data-align="left">股东名称</th>
                      <th data-field="" data-align="left">证件类型</th>
                      <th data-field="" data-align="left">证件号码</th>
                      <th data-field="" data-align="left">国别</th>
                      <th data-field="" data-align="left">股东地址</th>
                      <th data-width='' data-align="left">认缴出资额（万元）</th>
                      <th data-width='' data-align="left">出资比例（%）</th>
                      <th data-width='' data-align="left">出资币种</th>
                      <th data-width='' data-align="right">出资日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>1</td>
                      <td>缪伟</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td>300</td>
                      <td>0.1%</td>
                      <td>人民币</td>
                      <td>2015-2-12</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="topM" class="isShow">
                <span class="threeTitle">1.4、高管信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">序号</th>
                      <th data-width='' data-align="left">姓名</th>
                      <th data-field="" data-align="center">性别</th>
                      <th data-field="" data-align="center">证件名称</th>
                      <th data-field="" data-align="center">证件号码</th>
                      <th data-field="" data-align="center">联系电话</th>
                      <th data-width='' data-align="right">职务</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>1</td>
                      <td>董军</td>
                      <td>男</td>
                      <td>身份证</td>
                      <td></td>
                      <td></td>
                      <td>执行（常务）董事、总经理</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="othEnt" class="isShow">
                <span class="threeTitle">1.5、对外股权投资信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">序号</th>
                      <th data-width='' data-align="left">企业名称</th>
                      <th data-width='' data-align="left">注册资本（万元）</th>
                      <th data-width='' data-align="right">出资比例</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>1</td>
                      <td>深圳鹏运业务部</td>
                      <td>233</td>
                      <td>12%</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="legPerPo" class="tables isShow">
                <span class="threeTitle">1.6、法定代表人在其机构任职信息</span>
                <div class="tableContainer">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='' data-align="left">序号</th>
                      <th data-width='30%' data-align="left">机构名称</th>
                      <th data-width='12%' data-align="left">工商注册号</th>
                      <th data-width='' data-align="left">担任职务</th>
                      <th data-width='' data-align="left">机构状态</th>
                      <th data-width='12%' data-align="left">注册资本(万元)</th>
                      <th data-width='' data-align="left">企业类型</th>
                      <th data-width='12%' data-align="right">登记机关</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>1</td>
                      <td>华宁博思科技(深圳)有限公司</td>
                      <td>440301503323871</td>
                      <td>其他人员</td>
                      <td>吊销</td>
                      <td>2500</td>
                      <td>有限责任公司(台港澳法人独资)</td>
                      <td>广东省深圳市福田区工商行政管理局</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <div id="office6">
                  <div>
                    <div class="row basicText3 marginTopSmall">
                      <div class="col-xs-2">
                        <label>任职机构概要</label>
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
                        <input type="text" value="华宁博思科技(深圳)有限公司"/>
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
                            <input type="text" value="440301503323871"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>
                              担任职务
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="其他人员"/>
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
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value="2500.0"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>
                              企业类型
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="有限责任公司(台港澳法人独资)"/>
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
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>
                              登记机关
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="广东省深圳市福田区工商行政管理局"/>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div id="legPerSt" class="tables isShow">
                <span class="threeTitle">1.7、法定代表人股权投资信息</span>
                <div>
                  <div class="row" style="margin-bottom: 0;">
                    <div class="col-xs-8 labelInput">
                      <div class="row">
                        <div class="col-xs-2 nonePaddingRight investmentTotal">
                          <label style="">积累投资总数</label>
                        </div>
                        <div class="col-xs-4 nonePaddingLeft nonePaddingRight investmentTotalInput">
                          <input type="text" value="1"/>
                        </div>
                        <div class="col-xs-3 nonePaddingLeft nonePaddingRight moneyTotal">
                          <label>积累投资金额（万元）</label>
                        </div>
                        <div class="col-xs-3 nonePaddingLeft nonePaddingRight moneyTotalInput">
                          <input type="text" value="256.0"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-4 nonePaddingLeft nullInput">
                      <div></div>
                    </div>
                  </div>
                  <div class="tableContainer">
                    <table class="table table-striped">
                      <thead>
                      <tr>
                        <th data-width='' data-align="left">序号</th>
                        <th data-width='35%' data-align="left">被投资机构名称</th>
                        <th data-width='' data-align="left">注册资本（万元）</th>
                        <th data-width='' data-align="left">认缴出资</th>
                        <th data-width='' data-align="left">出资比例</th>
                        <th data-width='' data-align="left">币种</th>
                        <th data-width='' data-align="right">机构状态</th>
                      </tr>
                      </thead>
                      <tbody>
                      <tr>
                        <td>1</td>
                        <td>深圳市鹏运国际旅行社有限公司地王大夏营业部</td>
                        <td>256</td>
                        <td>16</td>
                        <td>100.00%</td>
                        <td>CNY</td>
                        <td>经营</td>
                      </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div id="Investment7">
                  <div>
                    <div class="row basicText3 marginTopSmall">
                      <div class="col-xs-2">
                        <label>被投资机构概要</label>
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
                        <input type="text" value="深圳市鹏运国际旅行社有限公司地王大夏营业部"/>
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
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value="256.0"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>
                              币种
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="CNY"/>
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
                            <input type="text" value="440301104240935"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>
                              企业类型
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="合资"/>
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
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>
                              登记机关
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value="深圳市"/>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div id="score" class="tables isShow">
                <span class="threeTitle">1.8、企业变更信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">企业注册号</th>
                      <th data-width='' data-align="left">变更日期</th>
                      <th data-width='' data-align="left">变更项</th>
                      <th data-width='' data-align="left">变更前</th>
                      <th data-width='' data-align="left">变更后</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>36.64%</td>
                      <td>36.64%</td>
                      <td>18.33%</td>
                      <td>16.03%</td>
                      <td>19.86%</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="fzjg" class="isShow alignment tables">
                <span class="threeTitle">1.9、分支机构信息</span>
                <div>
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>
                              机构名称
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value="ABC"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>一般经营项目</label>
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
                            <label>企业注册号</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>注册所在工商管理局</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row lastInputLabel">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>分支机构地址</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>分支机构负责人</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div id="qingsuan" class="tables isShow">
                <span class="threeTitle">1.10、清算信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">清算责任人</th>
                      <th data-width='' data-align="left">清算完结日期</th>
                      <th data-width='' data-align="left">清算负责人</th>
                      <th data-width='' data-align="left">债务承接人</th>
                      <th data-width='' data-align="left">清算组成员</th>
                      <th data-width='' data-align="left">债权承接人</th>
                      <th data-width='' data-align="left">清算完结情况</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>李四</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td>完结</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="dcdy" class="isShow tables">
                <span class="threeTitle">1.11、动产抵押信息</span>
                <div>
                  <div class="marginTopSmall">
                    <div class="row">
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight">
                            <label>
                              抵押ID
                            </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value="陈新能"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>登记证号</label>
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
                            <label>抵押人</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>申请抵押原因</label>
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
                            <label>抵押权人 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>被担保主债权种类</label>
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
                            <label>登记机关</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>被担保主债权数额</label>
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
                            <label>登记日期 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>履约起始日期</label>
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
                            <label>状态标识 </label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                            <input type="text" value=""/>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-6">
                        <div class="row basicText2">
                          <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                            <label>履约截止日期</label>
                          </div>
                          <div class="col-xs-9 nonePaddingLeft">
                            <input class="noneBorderRight" type="text" value=""/>
                          </div>
                        </div>
                      </div>

                    </div>
                    <div class="row ">
                      <div class="col-xs-12">
                        <div class="row basicText2">
                          <div class="col-xs-2 nonePaddingRight" style="height: 40px;">
                            <label class="borderBottomColor">注销日期</label>
                          </div>
                          <div class="col-xs-10 nonePaddingLeft">
                            <input class="borderBottomColor" type="text"/>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div id="dcdyw" class="tables isShow">
                <span class="threeTitle">1.12、动产抵押物信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">抵押ID</th>
                      <th data-width='' data-align="left">抵押物名称</th>
                      <th data-width='' data-align="left">数量</th>
                      <th data-width='' data-align="left">价值</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>123</td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="gqdjls" class="isShow tables">
                <span class="threeTitle">1.13、股权冻结历史信息</span>
                <div class="marginTopSmall">
                  <div class="row">
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            冻结文号
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                          <input type="text" value=""/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                          <label>冻结机关</label>
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
                          <label>解冻文号</label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                          <input type="text" value=""/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                          <label>解冻机关</label>
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
                          <label>冻结起始日期</label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                          <input type="text" value=""/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                          <label>冻结截止日期</label>
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
                          <label>解冻日期</label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                          <input type="text" value=""/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                          <label>解冻说明</label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input class="noneBorderRight" type="text" value=""/>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row lastInputLabel">
                    <div class="col-xs-12">
                      <div class="row basicText2">
                        <div class="col-xs-2 nonePaddingRight">
                          <label>冻结金额 </label>
                        </div>
                        <div class="col-xs-10 nonePaddingLeft">
                          <input type="text" value=""/>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div id="gqczls" class="tables isShow">
                <span class="threeTitle">1.14、股权出质历史信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">质权人姓名</th>
                      <th data-width='' data-align="left">出质审批部门</th>
                      <th data-width='' data-align="left">出质人类别</th>
                      <th data-width='' data-align="left">出质批准日期</th>
                      <th data-width='' data-align="left">出质金额</th>
                      <th data-width='' data-align="left">出质截止日期</th>
                      <th data-width='' data-align="left">出质备案日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>14</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>


            <!-- 二 财务信息 空缺-->
            <div>
              <div id="financialInfo" class="isShow">
                <span class="oneTitle">二、财务信息</span>
              </div>
              <div id="balanceSheet" class="isShow">
                <span class="threeTitle">2.1</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">序号</th>
                      <th data-width='' data-align="left">项目</th>
                      <th data-width='' data-align="left">年初余额（元）</th>
                      <th data-width='' data-align="left">期末余额(元)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>1</td>
                      <td>货币资金</td>
                      <td>-</td>
                      <td>-</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="profitStatemen" class="isShow">
                <span class="threeTitle">2.2</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">序号</th>
                      <th data-width='' data-align="left">项目</th>
                      <th data-width='' data-align="left">上期余额（元）</th>
                      <th data-width='' data-align="left">本期余额(元)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>1</td>
                      <td>一、营业收入</td>
                      <td>-</td>
                      <td>-</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>


            <!-- 三 税务信息 -->
            <div>
              <div id="taxInfo" class="isShow">
                <span class="oneTitle">三、税务信息</span>
              </div>
              <div id="sysl" class="tables isShow">
                <span class="threeTitle">3.1、适用税率</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-width='' data-align="left">增值税</th>
                      <th data-width='' data-align="left">企业所得税</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>15</td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="fsl" class="tables isShow">
                <span class="threeTitle">3.2、负税率</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-width='' data-align="left">年应税额(元)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>16</td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="zzsybnarsb" class="tables isShow">
                <span class="threeTitle">3.3、增值税一般纳税人申报表</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-align="left">序号</th>
                      <th data-width='' data-align="left">按适用税率计税销售额(元)</th>
                      <th data-width='' data-align="left">按简易办法计税销售额(元)</th>
                      <th data-width='' data-align="left">免、抵、退办法出口销售额(元)</th>
                      <th data-width='' data-align="left">免税销售额(元)</th>
                      <th data-width='' data-align="left">合计(元)</th>
                      <th data-width='' data-align="left">销项税额(元)</th>
                      <th data-width='' data-align="left">进项税额(元)</th>
                      <th data-width='' data-align="left">上期留底税额(元)</th>
                      <th data-width='' data-align="left">应纳税额合计</th>
                      <th data-width='' data-align="left">期末留底金额(元)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>17</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="yxse" class="tables isShow">
                <span class="threeTitle">3.4、应税销售额</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">序号</th>
                      <th data-width='' data-align="left">年应税销售额(元)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>18</td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="zrse" class="tables isShow">
                <span class="threeTitle">3.5、总纳税额</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-width='' data-align="left">序号</th>
                      <th data-width='' data-align="left">企业所得税</th>
                      <th data-width='' data-align="left">增值税</th>
                      <th data-width='' data-align="left">其他税种</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>19</td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>


            <!-- 四 交易信息 -->
            <div>
              <div id="transactionInfo" class="isShow">
                <span class="oneTitle">四、交易信息</span>
              </div>
              <div id="hxjy" class="tables isShow">
                <span class="threeTitle">4.1、核心经营信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>20</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="yycjy" class="tables isShow">
                <span class="threeTitle">4.2、月异常交易信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>21</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="jywdxzb" class="tables isShow">
                <span class="threeTitle">4.3、经营稳定性指标信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>22</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="jybhqs" class="tables isShow">
                <span class="threeTitle">4.4、经营变化趋势信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-field="" data-width='' data-align="center">交易金额周均增长率</th>
                      <th data-field="" data-width='' data-align="center">交易笔数周均增长率</th>
                      <th data-field="" data-width='' data-align="center">每周交易金额(元)</th>
                      <th data-field="" data-width='' data-align="center">每周交易笔数</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>23</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="bsthxxdb" class="tables isShow">
                <span class="threeTitle">4.5、本市同行信息对比信息（月）</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-width='' data-align="center">月交易金额(元)</th>
                      <th data-width='' data-align="center">月交易金额在本市同行业中的排名</th>
                      <th data-width='' data-align="center">月交易笔数</th>
                      <th data-width='' data-align="center">月交易笔数在本市同行业中的排名</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>24</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="khdyfb" class="tables isShow">
                <span class="threeTitle">4.6、客户地域分布</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-field="" data-width='' data-align="center">客户类型</th>
                      <th data-field="" data-width='' data-align="center">金额占比</th>
                      <th data-field="" data-width='' data-align="center">交易笔数占比</th>
                      <th data-field="" data-width='' data-align="center">交易人数占比</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>25</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="khzcd" class="tables isShow">
                <span class="threeTitle">4.7、客户忠诚度</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter">序号</th>
                      <th data-field="" data-width='' data-align="center">客户类型</th>
                      <th data-field="" data-width='' data-align="center">金额占比</th>
                      <th data-field="" data-width='' data-align="center">交易笔数占比</th>
                      <th data-field="" data-width='' data-align="center">交易人数占比</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>26</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="gys" class="tables isShow">
                <span class="threeTitle">4.8、供应商信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="">序号</th>
                      <th data-field="" data-width='' data-align="center" data-title-tooltip="">供应商名称</th>
                      <th data-field="" data-width='' data-align="center">年采购金额(元)</th>
                      <th data-field="" data-width='' data-align="center">采购占比</th>
                      <th data-field="" data-width='' data-align="center">前十名供应商金额合计(元)</th>
                      <th data-field="" data-width='' data-align="center">前十名供应商金额占比</th>
                      <th data-field="" data-width='' data-align="center">年关联交易金额(元)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>27</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="kh" class="tables isShow">
                <span class="threeTitle">4.9、客户信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    <tbody>
                    <tr>
                      <td>28</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>


            <!-- 五  高管商旅信息-->
            <div>
              <div id="executivesBusinessInfo" class="isShow">
                <span class="oneTitle">五、高管商旅信息</span>
              </div>
              <div id="legalFly" class="isShow">
                <span class="twoTitle">5.1、法人代表乘机</span>
              </div>
              <div id="frdbcjztcx" class="alignment isShow traval tables">
                <span class="threeTitle">5.1.1、法人代表总体出行</span>
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
              </div>
              <div id="frdbcjswcx" class="tables isShow">
                <span class="threeTitle">5.1.2、法人代表商务出行</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    <tbody>
                    <tr>
                      <td>30</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="shareholderFly" class="isShow">
                <span class="twoTitle">5.2、控股股东乘机</span>
              </div>
              <div id="kggdztcxfx" class="isShow alignment traval tables">
                <span class="threeTitle">5.2.1、股东总体出行</span>
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
                        <div class="col-xs-3  nonePaddingRight nonePaddingLeft">
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
              </div>
              <div id="kggdswcx" class="tables isShow">
                <span class="threeTitle">5.2.2、股东商务出行</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    <tbody>
                    <tr>
                      <td>32</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>


            <!--六、特殊事项信息-->
            <div>
              <div id="specialEventInfo" class="isShow">
                <span class="oneTitle">六、特殊事项信息</span>
              </div>
              <!--6.1-->
              <div id="wfwg" class="isShow">
                <span class="twoTitle">6.1。1、违法违规</span>
              </div>
              <div id="wfwgcpws" class="tables isShow">
                <span class="threeTitle">6.1、违法违规裁判文书</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>33</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="wfwgzxgg" class="tables isShow">
                <span class="threeTitle">6.1.2、违法违规执行公告</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>34</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>

              <!--6.2-->
              <div id="fddbrsx" class="isShow">
                <span class="twoTitle">6.2</span>
              </div>
              <div id="fdrsxcpws" class="tables isShow">
                <span class="threeTitle">6.2.1</span>
                <div class="tableContainer">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>35</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="fdrsxzxgg" class="tables isShow">
                <span class="threeTitle">6.2.2</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>36</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="fdrsxsxgg" class="tables isShow">
                <span class="threeTitle">6.2.3</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>37</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="fdrsxwdhmd" class="tables isShow">
                <span class="threeTitle">6.2.4</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>38</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="fdrsxbgt" class="tables isShow">
                <span class="threeTitle">6.2.5</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>39</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>

              <!--6.3-->
              <div id="kggdsx" class="isShow">
                <span class="twoTitle">6.3</span>
              </div>
              <div id="kggdsxcpws" class="tables isShow">
                <span class="threeTitle">6.3.1</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>40</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="kggdsxzxgg" class="tables isShow">
                <span class="threeTitle">6.3.2</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>41</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="kggdsxsxgg" class="tables isShow">
                <span class="threeTitle">6.3.3</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>42</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="kggdsxwdhmd" class="tables isShow">
                <span class="threeTitle">6.3.4</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>43</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>

              <!--6.4-->
              <div id="qtbl" class="isShow">
                <span class="twoTitle">6.4</span>
              </div>
              <div id="qtblalqd" class="tables isShow">
                <span class="threeTitle">6.4.1</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>44</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div id="qtblwdhmd" class="tables isShow">
                <span class="threeTitle">6.4.2</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
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
                    </thead>
                    <tbody>
                    <tr>
                      <td>45</td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>


            <!--七、法院信息-->
            <div>
              <div id="courtInfo" class="isShow">
                <span class="oneTitle">七、法院信息</span>
              </div>
              <div id="special" class="isShow tables">
                <span class="threeTitle">7.1、法院被执行信息</span>
                <div class="marginTopSmall">
                  <div class="row">
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>
                            被执行人
                          </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                          <input type="text" value="陈新能"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                          <label>执行标的</label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input class="noneBorderRight" type="text" value=""/>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-xs-6 ">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight">
                          <label>执行法院</label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                          <input type="text" value=""/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                          <label>案件状态</label>
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
                          <label>案号 </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                          <input type="text" value="(2014)深宝法执字第00623号"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                          <label>立案时间</label>
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
                        <div class="col-xs-3 nonePaddingRight" style="height: 40px;">
                          <label class="borderBottomColor"> </label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft nonePaddingRight">
                          <input class="borderBottomColor" type="text"/>
                        </div>
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div class="row basicText2">
                        <div class="col-xs-3 nonePaddingRight nonePaddingLeft">
                          <label class="borderBottomColor">信息获取日期</label>
                        </div>
                        <div class="col-xs-9 nonePaddingLeft">
                          <input class="noneBorderRight borderBottomColor" type="text" value=""/>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>


            <!--八、评分信息-->
            <div>
              <div id="scoreInfo" class="isShow">
                <span class="oneTitle">八、评分信息</span>
              </div>
              <div id="pfzb" class="tables isShow">
                <span class="threeTitle">8.1、评分指标信息</span>
                <div class="tableContainer" style="">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th data-field="" data-width='4%' data-align="left" data-formatter="indexFormatter"></th>
                      <th data-align="center">基本信息</th>
                      <th data-align="center">交易行为</th>
                      <th data-align="center">履约能力</th>
                      <th data-align="center">特殊事项</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>权重</td>
                      <td>36.64%</td>
                      <td>18.33%</td>
                      <td>19.86%</td>
                      <td>7.63%</td>
                    </tr>
                    <tr>
                      <td>得分</td>
                      <td>41.0</td>
                      <td>19.0</td>
                      <td>12.0</td>
                      <td>-8.0</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <!-- 重要声明 -->
          <div>
            <span style="color:red;font-weight: bold;"><span style="padding-right: 5px;">*</span>重要声明：</span>
            <div>
              <textarea name="declare" placeholder="长度不可超出400位"  maxlength=400 cols="30" rows="10" style="width: 100%; height: 80px;"></textarea>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button id="subModel" type="button" class="btn" onclick="createReportModel();">创建</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>

<script>
  var $table = $('#modelTable');
  $table.bootstrapTable({
    columns: [{
      field: 'index',
      title: '序号',
      width: '6%',
      formatter: function (value, row, index) {
        return index+1
      }
    },{
      field: 'id',
      title: '主键',
      visible: false
    },{
      field: 'number',
      title: '模板编号',
      align: "left"
    },{
      field: 'name',
      title: '模板名称',
      align: "left"
    },{
      field: 'type',
      title: '报告类别',
      align: "left",
      formatter: function (value,row,index) {
        if(value === 1) {
          return "授信";
        }
        if(value === 2) {
          return "贷款";
        }
        if(value === 3) {
          return "交易";
        }
        return "";
      }
    },{
      field: 'declare',
      title: '声明',
      visible: false
    },{
      field: 'createTime',
      title: '生成模板时间',
      align: "left",
      sortable: true,
      sortOrder: "desc",
      formatter: function (value, row, index) {
        if(value !== null) {
          var date = new Date(value);
          return date.getFullYear() + "-" + (date.getMonth()+1)+ "-" + date.getDate();
        }
      }
    },{
      field: 'operation',
      title: '操作',
      align: "right",
      formatter: function(value,row,index){
    	if(row.status == 2){
    	  return  [
    		'<mrp:p rId="342"><span class="disabledColor" title="编辑">编辑&nbsp;&nbsp;</span></mrp:p>',
    		'<mrp:p rId="343"><span class="disabledColor" title="删除">删除</span></mrp:p>'
    	  ].join("");
    	} else {
          return  [
            '<mrp:p rId="342"><a href="javascript:void(0)"  class="modelEdit" title="编辑">编辑&nbsp;&nbsp;</a></mrp:p>',
            '<mrp:p rId="343"><a href="javascript:void(0)"  class="modelRemove" title="删除">删除</a></mrp:p>'
          ].join("");
    	}
      },
      events: 'creditReportEvents'
    }],
    sortOrder: "desc",
    sortName: 'create_time',
    pagination: true,
    sidePagination: 'server',
    pageNumber: 1,
    pageSize: 10,
    cache: false,
    pageList: [5, 10, 20],
    queryParams: function (params) {
      return {
        limit: params.limit,
        offset: params.offset,
        order: params.order,
        sort: params.sort,
        name: $("#modelName").val(),
        number: $("#modelNumber").val()
      }
    },
    url: '/creditsupport/reportTemplet/query'
  });
</script>
<script src="${pageContext.request.contextPath}/js/creditReport-model.js"></script>