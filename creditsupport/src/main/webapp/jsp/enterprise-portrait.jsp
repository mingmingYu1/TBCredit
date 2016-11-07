<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="mrp" uri="http://www.baifendian.com/mrp" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="warpper">
  <div id="header" class="container-fluid"></div>
  <div class="container-fluid">
    <div class="row" id="score-report">
      <div class="col-xs-12 marginLeft marginTop">
        <p class="sumTitle"><a href="company-manage.jsp" class="returnIndex">企业管理</a> > 评分报告</p>
      </div>
      <div class="col-xs-12 marginLeft">
        <div class="basicContainer">
          <div>
            <div class="overflow">
              <p class="link marginTopSmall pull-left">
                <a href="./company-manage.jsp" class="returnIndex">< 返回企业列表</a>
              </p>
              <div class="pull-right marginTopSmall">
                <label>算法类型：</label>
                <select class="form-control" id="algorithmType"></select>
              </div>
            </div>
            <div class="text-center scoreReportTitle" id="score-title" style="margin-top: -15px;"><%=request.getParameter("compName")%>评分报告</div>
            <div id="scoreReportBtn1" class="text-right titleBtns" style="border-bottom: 1px solid #e3ebf3;margin-top: -5px;">
              <mrp:p rId="2131">
                <a href="javascript:void(0)" class="btn marginTopSmall">企业画像</a>
              </mrp:p>
              <mrp:p rId="2132">
                <a href="./index-report.jsp" class="btn load  active marginTopSmall">指标评分</a>
              </mrp:p>
              <mrp:p rId="2133">
                <a href="./index-report-attr.jsp" class="btn load active marginTopSmall">行业属性分类</a>
              </mrp:p>
            </div>
            <div id="scoreReportShow">
              <div>
                <div class="row" style="margin-left: 40px;margin-right: 40px;" id="enterprisePortrait">
                  <div class="col-xs-12 text-center" style="margin-top: 10px;">
                    <div>
                      <span class="dengFen">
                        <span>
                          <span class="icon-credit-card"></span> <span>信用得分</span>
                        </span>
                        <span class="zhi">
                          ${score }分
                        </span>
                      </span>
                      <span class="dengFen">
                        <span>
                          <span class="icon-thumbs-up"></span> <span>评分等级</span>
                        </span>
                        <span class="zhi">${level }（${desc }）</span>
                      </span>
                    </div>
                  </div>
                  <div class="col-xs-12" style="margin-top: 15px;">
                    <div class="row">
                      <div class="pull-left" style="width:31%">
                        <div>
                          <div class="overflow likeTables">
                            <div class="clickTitle pull-left active" data-key="1" style="background-color:#4dd0e1">
                              <div>基本信息</div>
                              <div>
                                <span>权重:</span><span>${basicInfo_weight }</span>
                              </div>
                              <div>
                                <span>得分:</span><span>${basicInfo_score}</span>
                              </div>
                            </div>
                            <div class="pull-left">
                              <div>
                                <span>经营时长(年)</span>
                              <span>
                                    ${basicInfo_dbsiOperatingYear}
                              </span>
                              </div>
                              <div>
                                <span>股东数量(人)</span>
                                <span>${basicInfo_dbsiShareholderNum}</span>
                              </div>
                              <div>
                                <span>法人股份占比(%)</span>
                                <span>${basicInfo_dbsiLegalStock}</span>
                              </div>
                            </div>
                          </div>
                          <div class="overflow likeTables" style="margin-top: 60px;" >
                            <div class="pull-left clickTitle" data-key="3" style="background-color:#EAD956">
                              <div>特殊事项</div>
                              <div>
                                <span>权重:</span><span>${specialInfo_weight }</span>
                              </div>
                              <div>
                                <span>得分:</span><span>${specialInfo_score }</span>
                              </div>
                            </div>
                            <div class="pull-left">
                              <div>
                                <span> 法院裁决违约(次)</span>
                                <span>${specialInfo_dsmiBreachNum}</span>
                              </div>
                              <div>
                                <span>法院裁决失信(次)</span>
                                <span>${specialInfo_dsmiCreditbreakNum}</span>
                              </div>
                              <div>
                                <span></span>
                                <span></span>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="pull-left" style="width:39%">
                        <div class="row">
                          <div class="col-lg-7">
                            <div id="scoreReportPie" style="height: 250px;width: 100%;"></div>
                          </div>
                          <div class="col-lg-5">
                            <div id="branchPie" style="height: 250px;width: 100%;"></div>
                          </div>
                        </div>
                      </div>
                      <div class="pull-left" style="width:30%">
                        <div class="overflow likeTables">
                          <div class="pull-left clickTitle" data-key="2" style="background-color:#BF7CFF">
                            <div>交易行为</div>
                            <div>
                              <span>权重:</span><span>${trInfo_weight }</span>
                            </div>
                            <div>
                              <span>得分:</span><span>${trInfo_score }</span>
                            </div>
                          </div>
                          <div class="pull-left">
                            <div>
                              <span>月出票量(张)</span>
                            <span>
                                    ${trInfo_dtdbOrderAvgNum}
                            </span>
                            </div>
                            <div>
                              <span>月销售额(万元)</span>
                              <span>${trInfo_dtdbOrderAmount}</span>
                            </div>
                            <div>
                              <span>月出票增长率(%)</span>
                              <span>${trInfo_dtdbOrderAvgRate}</span>
                            </div>
                          </div>
                        </div>
                        <!--   <div class="overflow likeTables" style="margin-top: 60px;">
                          <div class="pull-left clickTitle" data-key="5" style="background-color:#337AB7">
                            <div>信用历史</div>
                            <div>
                              <span>权重:</span><span>${creditInfo_weight }</span>
                            </div>
                            <div>
                              <span>得分:</span><span>${creditInfo_score }</span>
                            </div>
                          </div>
                          <div class="pull-left">
                            <div>
                              <span>贷款信息</span>
                              <span>${creditInfo_entCreRec }</span>
                            </div>
                            <div>
                              <span>信用卡信息</span>
                              <span>${creditInfo_lperCrecardRec }</span>
                            </div>
                            <div>
                              <span>逾期信息</span>
                              <span>${creditInfo_ryxBusOverdueRec }</span>
                            </div>
                          </div>
                        </div> -->
                        <div class="overflow likeTables" style="margin-top: 60px;">
                          <div class="pull-left clickTitle" data-key="4" style="background-color:#328C34">
                            <div>履约能力</div>
                            <div>
                              <span>权重:</span><span>${capacityInfo_weight }</span>
                            </div>
                            <div>
                              <span>得分:</span><span>${capacityInfo_score }</span>
                            </div>
                          </div>
                          <div class="pull-left">
                            <div>
                              <span>流动资产总额(万元)</span>
                              <span>${capacityInfo_dfncCurrentAssets}</span>
                            </div>
                            <div>
                              <span>流动负债总额(万元)</span>
                              <span>${capacityInfo_dfncCurrentLiability}</span>
                            </div>
                            <div>
                              <span>货币资金(万元)</span>
                              <span>${capacityInfo_dfncBankCash}</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- <div class="row">
                      <div class="overflow likeTables">
                        <div class="pull-left clickTitle" data-key="4" style="background-color:#328C34">
                          <div>履约能力</div>
                          <div>
                            <span>权重:</span><span>${capacityInfo_weight }</span>
                          </div>
                          <div>
                            <span>得分:</span><span>${capacityInfo_score }</span>
                          </div>
                        </div>
                        <div class="pull-left">
                          <div>
                            <span>流动资产总额(万元)</span>
                            <span>${capacityInfo_dfncCurrentAssets}</span>
                          </div>
                          <div>
                            <span>流动负债总额(万元)</span>
                            <span>${capacityInfo_dfncCurrentLiability}</span>
                          </div>
                          <div>
                            <span>货币资金(万元)</span>
                            <span>${capacityInfo_dfncBankCash}</span>
                          </div>
                        </div>
                      </div>
                    </div> -->
                    <div class="row" style="margin-top: 30px;">
                      <div class="col-xs-12">
                        <div class="creditScore">
                          <div id="creditScore" style="height: 315px;"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<script>
  $('#header').load("${pageContext.request.contextPath}/jsp/header.jsp?time="+new Date().getTime(),function(){
    $(".navUl li").eq(0).addClass("active");
  });

  var titleBtn = $("#scoreReportBtn1").find(".btn.load");
  var marginTopSmall = $("#scoreReportBtn1").find(".btn.marginTopSmall");
  if(marginTopSmall.length <= 0) {
    $('#score-report').html('<div class="col-xs-12 noPermissions">您无权限访问此页面!</div>')
  } else {

    var score = 0
    var scoreCode = '${level}';
    var id = '${regId}';
    var compName = '${compName}';
    var algorithmType = '${algorithmType }';
    var params = {regId: id, compName: compName, algorithmType: algorithmType};
    marginTopSmall.each(function(index, dom) {
      if($(this).text() === '企业画像') {
        score += 1
      }
    })
    if (score <= 0) {
      var href = titleBtn.eq(0).attr('href')
      $("#score-report").load(href,{regId: regId, compName: compName, algorithmType: algorithmType});
    } else {
      //判断是否已生成报告
      <c:if test="${isNotExist == true}">
        var option = {
          closeBtn:false,
          btn: parseInt("0011",2),
          onOk: function(){
            /*$("#content1").css("display", "block");
            $("#content").css("display", "none").html(""); */
            returnIndex()
          },
          onClose:function(){}
        }
        var txt = "此企业数据尚未使用" + '${algorithmType }' + "生成评分报告, 是否返回企业列表页面？";
        window.wxc.xcConfirm(txt, "custom", option);
      </c:if>
      //算法类型下拉列表
      $.ajax({
        url : "/creditsupport/scoreModel/queryAlgorithmType",
        type : "post",
        dataType : "json",
        cache : "false",
        success : function(responseText) {
          $("#algorithmType").html('');
          var result = responseText;
          if (result.length > 0) {
            for (var i = 0; i < result.length; i++) {
              var value = result[i].value;
              var name = result[i].name;
              if(value == algorithmType){
                $("#algorithmType").append("<option selected value='"+value+"'>" + name+ "</option>");
              } else {
                $("#algorithmType").append("<option value='"+value+"'>" + name+ "</option>");
              }
            }
          }
        }
      });

      $("#algorithmType").on('change', function () {
        var old = algorithmType;
        algorithmType = $("#algorithmType").val();
        //判断是否已生成评分报告，如果未生成，给出提示，否则，保存企业算法关联关系
        $.ajax({
          url : "/creditsupport/company-figure/checkAgentAlgor",
          type : "post",
          data: {
            regId: params.regId,
            algorithmType: algorithmType
          },
          dataType : "json",
          cache : "false",
          success : function(responseText) {
            var result = responseText;
            //选择的算法尚未生成评分报告，是否确定选择此算法
            if (result.code == 1) {
              var option = {
                closeBtn:false,
                btn: parseInt("0011",2),
                onOk: function(){
                  saveAgentAlgor(params.regId, algorithmType);
                  loadCompScore(algorithmType);
                },
                onCancel:function(){
                  $("#algorithmType").val(old);
                  algorithmType = old;
                }
              }
              window.wxc.xcConfirm(result.message, "custom", option);
            } else if (result.code == 2){
              //保存关联关系
              saveAgentAlgor(params.regId, algorithmType)
              //有算法时显示新的算法结果
              loadCompScore(algorithmType);
            } else {
              //提示异常信息
              window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.info);
            }
          }
        });
      });

      //显示新的算法结果
      function loadCompScore(algorithmType){
        $("#score-report").load('/creditsupport/company-figure/queryCompScore',
            {regId:params.regId, compName: params.compName, algorithmType: algorithmType},
            function () {}
        );
      }
      //保存新的算法企业关联关系
      function saveAgentAlgor(regId, algorithmType){
        $.ajax({
          url : "/creditsupport/company-figure/saveAgentAlgor",
          type : "post",
          data: {
            regId: regId,
            algorithmType: algorithmType
          },
          dataType : "json",
          cache : "false",
          success : function(responseText) {
            var result = responseText;
            if (result.code == 0) {
              window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.info);
            }
          }
        });
      }

      titleBtn.on("click", function (e) {
        e.preventDefault();
        var href = $(this).attr("href");
        $("#score-report").load(href,{regId: regId, compName: compName, algorithmType: algorithmType});
      });

      $(".clickTitle").on("click", function () {
        $(".clickTitle").removeClass("active");
        $(this).addClass("active");
        loadBasePie($(this).data('key'));
        loadBranchPie({regId:id,type:$(this).data('key'), algorithmType: algorithmType});
      });

      loadBasePie(1);
      loadBranchPie({regId:id,type:1, algorithmType: algorithmType});
      loadLine();

      function loadBasePie(key){
        $.ajax({
          url: '/creditsupport/company-figure/queryBasicIndWeight',
          data: {
            regId:id,
            algorithmType: algorithmType
          },
          dataType: 'json',
          success: function (data) {

            if(data.code == 1 ){
              switch (key) {
                case 1:
                  setBasePieChart('#scoreReportPie',getArray(data.indiWeight,'基本信息'));
                  break;
                case 2:
                  setBasePieChart('#scoreReportPie',getArray(data.indiWeight,'交易行为'));
                  break;
                case 3:
                  setBasePieChart('#scoreReportPie',getArray(data.indiWeight,'特殊事项'));
                  break;
                case 4:
                  setBasePieChart('#scoreReportPie',getArray(data.indiWeight,'履约能力'));
                  break;
//			  case 5:
//				setBasePieChart('#scoreReportPie',getArray(data.indiWeight,'履约能力'));
//				break;
                default:
                  break;
              }
            }
          }
        });
      }

      checkColor(scoreCode, ".zhi");

      function getArray(arr,str){
        var array = arr;
        for(var i=0;i<array.length;i++){
          if(array[i][0] == str){
            array[i] = {
              name: array[i][0],
              y: array[i][1],
              sliced: true,
              selected: true
            }
          }
        }
        return array;
      }

      function loadBranchPie(pieParams){
        $.ajax({
          url: '/creditsupport/company-figure/queryIndWeight',
          data: pieParams,
          dataType: 'json',
          success: function (data) {
            if(data.code == 1 ){
              setChartBranchPie('#branchPie',data.indiWeight);
              return;
            }
          }
        });
      }

      function setBasePieChart(o,array){
        var dom = o.replace(/#/,"");
        new Highcharts.Chart({
          chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            renderTo: dom
          },
          // 交易行为        信用历史           基本信息       履约能力     	    特殊事项
          colors: ['#BF7CFF',   /*'#337AB7',*/   '#4dd0e1',  '#328C34',   '#EAD956'],
          title: {
            text: '  '
          },
          tooltip:{
            pointFormat: '<b>{point.percentage:.1f}%</b>',
            backgroundColor:'#607D8B',
            borderColor:'#607D8B',
            style:{
              color:'#fff'
            }
          },
          legend: {
            enabled: false
          },
          credits:{
            enabled: false
          },
          plotOptions: {
            pie: {
              allowPointSelect: true,
              cursor: 'pointer',
              showInLegend: true,
              dataLabels: {
                enabled: true,
                color: '#fff',
                fontSize:'12px',
                connectorColor: '#fff',
                distance: -35,
                style: {
                  textShadow: "0 0 0px contrast, 0 0 0px contrast"
                },
                format: '{point.percentage:.1f} %'
              },
              point:{
                events:{
                  click:function(){
                    $(".clickTitle").removeClass("active");
                    switch (this.name) {
                      case '基本信息':
                        !this.selected && loadBranchPie({regId:id,type:1, algorithmType: algorithmType});
                        addActive(1);
                        break;
                      case '交易行为':
                        !this.selected && loadBranchPie({regId:id,type:2, algorithmType: algorithmType});
                        $(this).addClass('active');
                        addActive(2);
                        break;
                      case '特殊事项':
                        !this.selected && loadBranchPie({regId:id,type:3, algorithmType: algorithmType});
                        $(this).addClass('active');
                        addActive(3);
                        break;
                      case '履约能力':
                        !this.selected && loadBranchPie({regId:id,type:4, algorithmType: algorithmType});
                        $(this).addClass('active');
                        addActive(4);
                        break;
                      /*case '履约能力':
                       !this.selected && loadBranchPie({regId:id,type:5, algorithmType: algorithmType});
                       $(this).addClass('active');
                       addActive(5);
                       break;*/
                      default:
                        break;
                    }
                  }
                }
              }
            }
          },
          series: [{
            type: 'pie',
            data: array
          }]
        }).render();
      }

      function addActive(key){
        $(".clickTitle").each(function(){
          if($(this).data('key') == key){
            $(this).addClass('active');
          }
        });
      }

      function setChartBranchPie(o,array){
        var dom = o.replace(/#/,"");
        new Highcharts.Chart({
          chart: {
            type: 'pie',
            renderTo: dom
          },
          title :{
            text:' '
          },
          credits:{
            enabled:false
          },
          legend: {
            enabled:false
          },
          tooltip:{
            pointFormat: '<b>{point.percentage:.1f}%</b>',
            backgroundColor:'#607D8B',
            borderColor:'#607D8B',
            style:{
              color:'#fff'
            }
          },
          plotOptions: {
            pie: {
              allowPointSelect: true,
              cursor: 'pointer',
              showInLegend: true,
              dataLabels: {
                crop: false,
                enabled: true,
                color: '#fff',
                connectorColor: '#fff',
                distance: -35,
                style: {
                  textShadow: "0 0 0px contrast, 0 0 0px contrast"
                },
                format: '{point.percentage:.1f} %'
              }
            }
          },
          series: [{
            data: array
          }]
        }).render();
      }

      function loadLine(){
        $.ajax({
          url: '/creditsupport/company-figure/queryCreditScore',
          data: {
            regId:id,
            algorithmType: algorithmType
          },
          dataType: 'json',
          success: function (data) {
            if (data.code == 1 ){
              setLineChart('#creditScore',data.creditScore);
            }
            //此处不做提示，企业画像页面只做一次提示
//        else {
//          window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info);
//        }
          }
        });
      }

      function setLineChart(o,array){
        var dom = o.replace(/#/,"");
        new Highcharts.Chart({
          chart: {
            //alignTicks: false,
            type: 'column',
            renderTo: dom
          },
          colors: ['#80DEEA', '#FF8A65', '#7986CB'],
          title: {
            text: '近6个月信用得分',
            style:{
              color:'#000',
              fontSize:'20px',
              fontWeight: 'bold'
            }
          },
          xAxis: {
            type: 'category',
            gridLineColor: '#D8D8D8',
            gridLineWidth: 1,
            tickLength:0
          },
          yAxis: [
            {
              title: {
                text: '',
                style: {
                  color: '#89A54E'
                }
              },
              labels: {
                formatter: function() {
                  return this.value  + '分';
                }
              },
              gridLineColor: '#D8D8D8',
              gridLineWidth: 1,
              min: 0
            }
          ],
          legend: {
            align: 'right', //水平方向位置
            verticalAlign: 'top', //垂直方向位置
            x: -40, //距离x轴的距离
            y: 0 ,//距离Y轴的距离
            align:'right',
            shadow:false,
            floating:false,
            enabled:true
          },
          tooltip:{
            backgroundColor:'#607D8B',
            borderColor:'#607D8B',
            style:{
              color:'#fff'
            },
            pointFormatter:function(){
              return this.options.y +'分'
            }
          },
          credits:{
            enabled:false
          },
          plotOptions: {
            areaspline: {
              fillOpacity: 0.5
            },
            series: {
              events: {
                //控制图标的图例legend不允许切�?
                legendItemClick: function (event){
                  return false; //return  true 则表示允许切�?
                }
              }
            },
            column: {
              stacking: 'normal'
            }
          },
          series: [{
            name: '信用得分',
            type: 'column',
            yAxis: 0,
            data: array
          }]
        }).render();
      }
    }
  }

</script>
<script src="${pageContext.request.contextPath}/js/enterprise-portrait.js"></script>