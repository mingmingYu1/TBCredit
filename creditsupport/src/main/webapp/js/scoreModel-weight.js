$(document).ready(function () {
  
  if($("#leftNav").css("display") === "none") {
	  checkHeight("#scoreModelWeight");
  }

//  隐藏按钮
  $("#scoreModelWeight").find(".closeLeft").on("click", function () {
	hideLeft();
	checkHeight("#scoreModelWeight");
	loadLine()
  });
  
  $(".returnModel").on("click", function (e) {
	e.preventDefault();
	var href = $(this).attr("href");
	$("#content").load(href);
  })
  
  loadLine()
  
  function loadLine(){        
      $.ajax({        
        url: '/creditsupport/scoreModel/weight',
        data: {
        	modelCode: modelCode
        },
        dataType: 'json',
        type: "POST",
        success: function (data) {                   
          setLineChart('#scoreModelLine', data);
        }           
    });           
  }
  function setLineChart(o,array){
    var dom = o.replace(/#/,"");
    if($(o).highcharts()) {
      $(o).highcharts().destroy();
    }
    new Highcharts.Chart({
      chart: {
        //alignTicks: false,
        type: 'column',
        renderTo: dom
      },
      colors: ['#80DEEA', '#FF8A65', '#7986CB'],
      title: {
        text: modelName+"权重",
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
              return this.value*100+"%";
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
          return (Math.round((this.options.y)* 10000)/100).toFixed(2) + '%'
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
        name: '权重',
        type: 'column',
        yAxis: 0,
        data: array
      }]
  }).render();
  }
  
  
})