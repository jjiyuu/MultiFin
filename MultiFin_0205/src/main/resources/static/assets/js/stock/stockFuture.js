/*메인주가 */
graphItems = $('.now_graph').attr('id');
$.ajax({
	method: 'get',
	url:'/stock/stockRest/'+graphItems,
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;

		var stock = document.getElementById(graphItems).getContext('2d');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: 'rgb(255,150,150,0.5)',
					borderColor: 'rgb(255,150,150)',
					data: dataList,
					lineTension: 0,
					fill: origin,
					borderWidth: 2,
					pointRadius: 0,
				}
			]
		};
		let options = {
			scales: {
				xAxes: [{
					display: false,
				}],
				yAxes: [{
					gridLines: {
						lineWidth: 0,
						color: 'rgb(238, 236, 236)',
					},
					ticks: {
						beginAtZero: true,
						min: 55000
					}
				}]
			},
			legend: {
				display: false,
			}
		}
		var myStock = new Chart(stock, {
			type: 'line',
			data: data,
			options: options
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});






/*주가동향 */

$.ajax({
	method: 'get',
	url:'/stock/stockRest/'+graphItems,
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;

		var stock_future = document.getElementById('future_stock_graph').getContext('2d');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					label: '현재주가',
					backgroundColor: 'transparent',
					borderColor: 'rgb(255,150,150)',
					data: dataList,
					lineTension: 0,
					fill: origin,
					borderWidth: 2,
					pointRadius: 0,
					
				},
				/*
				{ label: '주가동향',
                  spanGaps: true,
                  backgroundColor: 'transparent',
                  borderColor: 'rgb(52, 152, 219)',
                  lineTension: 0.1,
                  borderWidth:1.5,
                  pointRadius: 0,
                  data: ,
                }*/
			]
		};
		let options = {
                scales: {
                  xAxes: [{
                    display: false,
                  }],
                  yAxes: [{
                    gridLines: {
                      lineWidth: 0,
                      color: 'rgb(238, 236, 236)',
                    },
                    ticks: {
                      beginAtZero: false,
                       min: 50000
                    }
                  }]
                },
                legend: {
                  display: false,
              },
              plugins: {
                tooltip:{
                  mode:'y',
                  enabled:true,
                  intersect:false
                }
              }
            }
		var myStock = new Chart(stock_future, {
			type: 'line',
			data: data,
			options: options
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});




















































var lds=[];
//create time span
for (var i=0; i<200; i++){lds.push(i);}
//console.log(lds);
var data = {
            labels : lds,
            datasets: [
              { label: '현재주가',
                spanGaps: true,
                backgroundColor: 'transparent',
                borderColor: 'rgb(255,150,150)',
                lineTension: 0,  
                borderWidth:1,
                pointRadius: 0,
                data: [163, 164, 151, 153,143,144,154,156,153,
                  143,146,148,146,135,146,136,138,136,146,149,
                  156,153,156,156,159,149,149,149,139,139,135,
                  135,135,134,130,132,125,122,123,123,123,124,126,125,
                  123,146,148,156,150,151,152,158,156,156,149,
                  156,153,156,150,159,160,159,165,167,165,165,
                  153, 154, 153, 153,143,124,164,156,123,
                  123,156,178,156,145,156,156,178,156,146,189,
                  156,123,156,156,159,159,169,159,165,164,165,
                  160,165,156,165,164,162,160,165,154,153,154,158,156,156,188,
                  178,175,176,175,145,131,143,143,142,140,141,141,142,143,
                  143,143,142,140,141,141,142,143,156,145,145,132,131,130,121,120,121,
                  124,120,120,123,123,124,125,123,124,120,119,118,123,134,125,
                  111,110,119,109,109,108,105,109,108,107,106,106,105,106,105,105,
                  110,115,120,125,125,125,123,123,124,125,123,125,128,129,129,
                  130,130,132,135,135,130,134,135,133],
                },
                { label: '주가동향',
                  spanGaps: true,
                  backgroundColor: 'transparent',
                  borderColor: 'rgb(52, 152, 219)',
                  lineTension: 0.1,
                  borderWidth:1.5,
                  pointRadius: 0,
                  data: [ 156,153,156,156,159,149,149,149,139,139,135,
                    135,135,134,130,132,125,122,123,123,123,124,126,125,
                    135,135,134,130,132,125,122,123,123,123,124,126,125,
                    123, 121,123,124,123,123,123,124,123,
                    143,146,148,146,135,146,136,138,136,146,149,
                    143,146,148,146,135,146,136,138,136,146,149,
                    121,135,135,134,130,132,125,122,123,123,123,124,126,125,
                    133,123,124,144,156,133,124,120,156,156,156,159,159,169,159,165,164,165,
                    154,153,154,158,156,156,188,154,153,154,158,156,156,188,
                    124,120,120,123,123,124,125,123,124,120,119,118,123,134,125,
                    111,110,119,109,109,108,105,109,108,107,106,106,105,106,105,105,
                    110,115,120,125,125,125,123,123,124,125,123,125,128,129,129,
                    124,120,120,123,123,124,125,123,124,120,119,118,123,134,125,
                    111,110,119,109,109,108,105,109,108,107,
                    110,115,120,125,125,125,123,123,124,125,
                    130,130,132,135],
                }
            ]
        };
let options = {
                scales: {
                  xAxes: [{
                    display: false,
                  }],
                  yAxes: [{
                    gridLines: { //A축 gridLines 지우는 옵션
                      lineWidth: 0,
                      color: 'rgb(238, 236, 236)',
                    },
                    ticks: {
                      beginAtZero: false,
                       min: 0
                    }
                  }]
                },
                legend: {
                  display: false,
              },
              plugins: {
                tooltip:{
                  mode:'y',
                  enabled:true,
                  intersect:false
                },
                zoom: {
                  pan: { // 마우스로 잡아서 그래프 이동
                      enabled: true,
                      mode: 'x'
                  },
                  zoom: {
                      wheel: {
                          enabled: true
                      }
                  }
              }
              }
            }
var myChart = new Chart(context, {
        type: 'line',
        data: data,
        options: options
});
   











