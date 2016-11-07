<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="row" id="modelContainer">
  <div class="col-xs-12 overflow nonePaddingLeft">
		<div class="hideBtn">
			<button class="btn closeLeft">
				<i class="icon-angle-left"></i>     <!--   icon-angle-right  -->
			</button>
		</div>
		<div class="oneHeader">
			<!--<p class="title">指标体系</p>-->
			<p class="sumTitle"><a href="./person-score-manage.jsp">评分模型</a> > 征信报告模板</p>
		</div>
	</div>
	<div class="col-xs-12 marginLeft marginTop">
	  <div class="searchInput overflow">
	    <div class="pull-left">
	      <label>模板名称：</label>
	      <input id="modelName" class="form-control" type="text" placeholder="请输入模版名称"/>
	    </div>
	    <div class="pull-left">
	      <label>模板编号：</label>
	      <input id="modelNumber" class="form-control" type="text" placeholder="请输入模版编号"/>
	      <button class="btn" style="margin-left: 35px;" onclick="creditReportModelSelect()">搜索</button>
	      <button class="btn" onclick="clearSearch()">重置</button>
	    </div>
	  </div>
	  <button class="btn marginTop" id="addModel" data-toggle="modal" data-target="#creditReportModelModal">
	    <span class="icon-plus" ></span>&nbsp;&nbsp;新增
	  </button>
		<div class="tableContainer">
			<div>
				<table id="modelTable" class="table table-striped"></table>
			</div>
		</div>
	</div>
</div>

<!--模板报告页面-->
<div class="modal fade" id="creditReportModelModal" tabindex="-1" role="dialog" aria-labelledby="creditReportModelModal" aria-hidden="true">
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
							<input  id="modelId" type="hidden" name="id" />
						<div style="width: 100%;">
							<label for=""><span>*</span>模板编号：</label>
							<input class="form-control" name="modelNumber"  placeholder="请输入模板编号"/>
						</div>
						<div class="marginTop" style="width: 100%">
							<label for=""><span>*</span>模版名称：</label>
							<input class="form-control"  type="text" name="modelName" value="sdhas"  placeholder="请输入模版名称"/>
						</div>
					  </div>
					  <div class="pull-right leftModal">
					    <div class="pull-left">
					      <label style="margin-top: 13px;margin-right: 5px;">报告类别：</label>
					    </div>
					    <div class="radioInput pull-left">	
					      <label class="checkbox-inline">
					        <input type="radio" name="type" id="" value="1"/>授信
					      </label>
					     <!--  <label class="checkbox-inline">
					        <input type="radio" name="type" id="" value="2"/>贷款
					      </label> -->
					      <label class="checkbox-inline">
					        <input type="radio" name="type" id="" value="3"/>交易
					      </label>
					    </div>
				      </div>
				    </div>
					<div class="text-center creditReportDetailTitle marginTop" style="padding-bottom: 0;margin-top: 15px;">XXX征信报告</div>
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
											信用得分：<span class="textColor">83&nbsp;分</span>
										</div>
									</div>
								</div>
							</div>
							<div>
								<div class="marginTop">
									<label>报告内容：</label>
								</div>
								<div id="checkboxs" class="spans checkboxInput" style="padding-left: 80px;">
									<label class="checkbox-inline">
										<input  type="checkbox" name="perbasic" checked disabled style="background-color: #ccc;"/>基本信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="driverLicence" checked/>驾驶证信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="persxbzxr" checked/>失信被执行人信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perbzxr" checked/>被执行人信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perqyfddbr" checked/>企业法定代表人信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perglry" checked/>管理人员信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perqygd" checked/>企业股东信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="persffgbg" checked/>司法风控报告信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perbgt" checked/>曝光台信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="percpws" checked/>裁判文书信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="persxgg" checked/>失信公告信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perwdhmd" checked/>网贷黑名单信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perzxgg" checked/>执行公告信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="peralqd" checked/>阿里欠贷信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perylsys" checked/>银联三要素验证信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perzczkjyxw" checked/>资产状况及交易行为
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perxfdlfb" checked/>消费大类分布信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="percsxfzk" checked/>城市消费状况信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="permyxfzk" checked/>每月消费状况信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perxfxw" checked/>消费行为信息
									</label>
									<label class="checkbox-inline">
										<input class="controlShow" type="checkbox" name="perxyxgjytj" checked/>信用相关交易统计
									</label>
								</div>
							</div>
						</div>
					</div>
					
					<!-- 基本信息 -->
					<div>
					<div id="perbasic" class="isShow tables" >
						<div class="basicText">
							<div class="pull-left">1、基本信息</div>
						</div>
						<div class="">
				          <div class="row">
				            <div class="col-xs-6">
				              <div class="row basicText2">
				                <div class="col-xs-3 nonePaddingRight">
				                  <label>
				                    姓名
				                  </label>
				                </div>
				                <div class="col-xs-9 nonePaddingLeft">
				                  <input type="text" value="" placeholder=""/>
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
				                  <input class="noneBorderRight" type="text" value=''/>
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
				                  <input type="text" value=''/>
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
				                  <input class="noneBorderRight" type="text" value=""/>
				                </div>
				              </div>
				            </div>
				          </div>
				          <div class="row lastInputLabel">
				            <div class="col-xs-6">
				              <div class="row basicText2">
				                <div class="col-xs-3 nonePaddingRight">
				                  <label>
				                    验证结果
				                  </label>
				                </div>
				                <div class="col-xs-9 nonePaddingLeft">
				                  <input type="text" value=''/>
				                </div>
				              </div>
				            </div>
				            <div class="col-xs-6">
				              <div class="row basicText2 ">
				                <div class="col-xs-3 nonePaddingRight">
				                  <label>
				                    验证结果描述
				                  </label>
				                </div>
				                <div class="col-xs-9 nonePaddingLeft">
				                  <input class="noneBorderRight" type="text" value=""/>
				                </div>
				              </div>
				            </div>
				          </div>
				          </div>
        
         <!-- 银行卡号和手机号码显示 -->
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
              <tbody>
              	<tr>
              		<td>1</td>
              		<td></td>
              		<td></td>
              	</tr>
              </tbody>
            </table>
      </div>
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
              </thead>
              <tbody>
              	<tr>
              		<td>1</td>
              		<td></td>
              		<td></td>
              	</tr>
              </tbody>
            </table>
      </div>
        
        </div>
      </div>
 
					<div id="driverLicence" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">2、驾驶证信息</div>
						</div>
						<div>
							<div class="tableContainer"> 
								<table class="table table-striped">
									<thead>
									<tr>
										<th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
						                <th data-field="cardId" data-width='' data-align="left">身份证号</th>
						                <th data-field="name" data-width='' data-align="left">姓名</th>
						                <th data-field="xm" data-width='' data-align="left">驾驶证号匹配结果</th>
						                <th data-field="zt" data-width='' data-align="left">状态</th>
									</tr>
									</thead>
									<tbody>
									  <tr>
											<td>1</td>
											<td>513426199105133520</td>
											<td>杨在梅</td>
											<td>-1</td>
											<td>Z</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="persxbzxr" class="tables isShow" >
						<div class="basicText">
							<div class="pull-left">3、失信被执行人信息</div>
						</div>
						<div class="tableContainer" style="">
							<table class="table table-striped">
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
								</thead>
								<tbody>
								 <tr><td colspan = "22" align="center" >没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div>
					<div id="perbzxr" class="tables isShow" >
						<div class="basicText">
							<div class="pull-left">4、被执行人信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								</thead>
								<tbody>
								   <tr><td colspan = "13" align="center" >没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div>
					<div id="perqyfddbr" class="tables isShow" >
						<div class="basicText">
							<div class="pull-left">5、企业法定代表人信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table  class="table table-striped">
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
								<tbody>
								   <tr><td colspan = "8" align="center" >没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div>
					<div id="perglry" class="tables isShow" >
						<div class="basicText">
							<div class="pull-left">6、管理人员信息</div>
						</div>
							<div class="tableContainer">
								<table  class="table table-striped">
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
									<tbody>
									  <tr>
											<td>1</td>
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
					
					<div id="perqygd" class="tables isShow" >
						<div class="basicText">
							<div class="pull-left">7、企业股东信息</div>
						</div>
							<div class="tableContainer">
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
								<table class="table table-striped">
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
									<tbody>
									  <tr>
											<td>1</td>
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
						
 					<div id="persffgbg" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">8、司法风控报告信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
								<thead>
								<tr>
								    <th data-field="" data-width='' data-align="left" data-formatter="indexFormatter">序号</th>
					                <th data-field="" data-width='' data-align="center">身份证号</th>
					                <th data-field="" data-width='' data-align="center">姓名</th>
					                <th data-field="" data-width='' data-align="center">数据条数</th>
								</tr>
								</thead>
								<tbody>
								  <tr>
								        <td>1</td>
										<td></td>
										<td></td>
										<td></td>
										
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					
					<div id="perbgt" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">9、曝光台信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								<tbody>
								  <tr>
										<td>1</td>
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
				    
				    <div id="percpws" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">10、裁判文书信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								</thead>
								<tbody>
								  <tr>
										<td>123</td>
										<td></td>
										<td></td>
										<td></td>
										<td>123</td>
										<td></td>
										<td></td>
										<td></td>
										<td>123</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div> 
					
				    <div id="persxgg" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">11、失信公告信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								</thead>
								<tbody>
								  <tr><td colspan = "18" align="center">没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div> 
				    <div id="perwdhmd" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">12、网贷黑名单信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								</thead>
								<tbody>
								  <tr><td colspan = "20" align="center">没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div> 
				    
				    <div id="perzxgg" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">13、执行公告信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								</thead>
								<tbody>
								  <tr><td colspan = "13" align="center">没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div> 
					
					<div id="peralqd" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">14、阿里欠贷信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								</thead>
								<tbody>
								  <tr><td colspan = "13" align="center">没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div> 
					
					<div id="perylsys" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">15、银联三要素验证信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								<tbody>
								  <tr>
								  	<td>1</td>
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
					
					<div id="perzczkjyxw" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">16、资产状况及交易行为</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								</thead>
								<tbody>
								  <tr><td colspan = "12" align="center">没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div> 
					
					<div id="perxfdlfb" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">17、消费大类分布信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								<tbody>
								  <tr>
								  	<td>123</td>
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
					
					<div id="percsxfzk" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">18、城市消费状况信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								<tbody>
								  <tr>
								  	<td>123</td>
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
					
					<div id="permyxfzk" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">19、每月消费状况信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								<tbody>
								  <tr><td colspan = "8" align="center">没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div> 
					
					<div id="perxfxw" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">20、消费行为信息</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								</thead>
								<tbody>
								  <tr><td colspan = "12" align="center">没有记录</td></tr>
								</tbody>
							</table>
						</div>
					</div> 
					
					<div id="perxyxgjytj" class="tables isShow">
						<div class="basicText">
							<div class="pull-left">21、信用相关交易统计</div>
						</div>
						<div class="tableContainer"  style="">
							<table class="table table-striped">
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
								<tbody>
								  <tr>
								  	<td >123</td>
								  	<td ></td>
								  	<td ></td>
								  	<td ></td>
								  	<td ></td>
								  	<td ></td>
								  </tr>
								</tbody>
							</table>
						</div>
					</div> 
					
					<div>
						<span style="color:red;font-weight: bold;">重要声明：</span>
						<div>
							<textarea name="declare" id="" cols="30" rows="10" style="width: 100%; height: 80px;"></textarea>
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


<script src="${pageContext.request.contextPath}/js/person/person-creditReport-model.js"></script>