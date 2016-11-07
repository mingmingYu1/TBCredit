$(document).ready(function () {
		 
  $.ajax({
    url: '/creditsupport/ticketDetal/grossProfit',
    data: {
      id: oddId
    },
    dataType: 'json',
    success: function (data) {
      if(data.code == 1 ){
        setChart('#grossProfitChart',data.capital,data.growth);
      }
    }
  });
		  
  function setChart(o,capital,growth){
    var dom = o.replace(/#/,"");
    new Highcharts.Chart({
      chart: {
        type: 'column',
        renderTo: dom
      },
      colors: ['#80DEEA', '#FF8A65', '#7986CB'],
      title: {
        text: '毛利额',
        style:{
          color:'#000',
          fontSize:'20px',
          fontWeight: 'bold'
        }
      },
      subtitle: {
      	text: "单位："+compName,
      	floating: true,
      	align: "left",
      	x: 70,
        y: 20,
        style: {
          fontSize: "14px"
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
        	  text: '(万元)',
        	  align: 'high',
              offset: 0,
              y: -20,
              rotation: 0,
              style: {
                 color: '#89A54E',
                 fontSize: "18px"
              }
          },
          labels: {
            formatter: function() {
              return this.value
            }
          },
          gridLineColor: '#D8D8D8',
          gridLineWidth: 1,
          min: 0
        },{
          title: {
            text: '',
            style: {
              color: '#4572A7'
            }
          },
          gridLineColor: '#D8D8D8',
          gridLineWidth: 0,
          opposite:true,
          min: getMInMax(growth).min,
          max: getMInMax(growth).max,
          labels : {
            formatter : function () {
              return this.value*100 +'%' ;
            }
          }
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
          if(this.shapeType === 'rect'){
            return this.options.y+'万元';
          }else{
            return (Math.round((this.options.y)* 10000)/100).toFixed(2) + '%'
          }
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
            //控制图标的图例legend不允许切换
            legendItemClick: function (event){
              return false; //return  true 则表示允许切换
            }
          }
        },
        column: {
          stacking: 'normal'
        }
      },
      series: [{
        name: '毛利额',
        type: 'column',
        yAxis: 0,
        data: capital
      },{
        name: '增长率',
        type: 'spline',
        yAxis: 1,
        data:growth
      }]
    }).render();
  }
		
  function getMInMax(array){
    var _array = [];
    for(var k in array) _array.push(array[k].y);
    return {
      min:Math.floor(Math.min.apply(null, _array)),
      max: Math.ceil(Math.max.apply(null, _array))
    }
  }

  $(".returnAs").on("click",function (e) {
    e.preventDefault();
    if(isIndexReport === "indexReport") {
	      $("#score-report").load("./index-report.jsp",{regId: oddId,compName: compName, algorithmType: algorithmType},function () {
	  	    //alert("成功！！")
	  	  });
	    } else {
	      $("#score-report").load("./index-report-attr.jsp",{regId: oddId,compName: compName, algorithmType: algorithmType},function () {
	      	//alert("成功！！")
	      });
	    }
  });

});