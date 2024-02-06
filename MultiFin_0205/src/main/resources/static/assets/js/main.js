/*main_KOSPI*/
$.ajax({
	method: 'get',
	url:'/stock/stockRest/kospi',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;

		var KOSPI = document.getElementById('KOSPI').getContext('2d');
		const gradientFill = KOSPI.createLinearGradient(0, -5, -20, 205);
		gradientFill.addColorStop(0, 'rgba(231,76,60,0.5)');
		gradientFill.addColorStop(1, 'rgba(225,255,255,0)');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: gradientFill,
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
			          gridLines: { //A축 gridLines 지우는 옵션
			            display: false,
			            drawBorder: false,
			          },
			          ticks: {
			            fontSize: 0,
			            fontColor: 'rgba(0,0,0,0)'
			    	    }
		      	 	}],
			        yAxes: [{
			          display: false,
			          gridLines: { //Y축 gridLines 지우는 옵션
			            drawBorder: false,
			            display: false,
			          },
			          ticks: {
			            beginAtZero: true,
			            min:2100
			          }
		       		}]
		      	},
                legend: {
                  display: false,
              	},
		     	tooltips: {
		       	 	backgroundColor: '#1e90ff'
		      	}
            }
			var myStock = new Chart(KOSPI, {
				type: 'line',
				data: data,
				options: options
			});
		},
		error: (e) => {
			alert('전송 실패!!');
		}
	});




/*main_KOSDAQ*/
$.ajax({
	method: 'get',
	url:'/stock/stockRest/kosdaq',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;

		var KOSDAQ = document.getElementById('KOSDAQ').getContext('2d');
		const kosdaq_fill = KOSDAQ.createLinearGradient(0, 0, -5, 85);
		kosdaq_fill.addColorStop(0, 'rgba(231,76,60,0.5)');
		kosdaq_fill.addColorStop(1, 'rgba(225,255,255,0)');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: kosdaq_fill,
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
			          gridLines: { //A축 gridLines 지우는 옵션
			            display: false,
			            drawBorder: false,
			          },
			          ticks: {
			            fontSize: 0,
			            fontColor: 'rgba(0,0,0,0)'
			    	    }
		      	 	}],
			        yAxes: [{
			          display: false,
			          gridLines: { //Y축 gridLines 지우는 옵션
			            drawBorder: false,
			            display: false,
			          },
			          ticks: {
			            beginAtZero: true,
			            min:650
			          }
		       		}]
		      	},
                legend: {
                  display: false,
              	},
		     	tooltips: {
		       	 	backgroundColor: '#1e90ff'
		      	}
            }
		var myStock = new Chart(KOSDAQ, {
			type: 'line',
			data: data,
			options: options
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});


/*nasdaq */
$.ajax({
	method: 'get',
	url: '/stock/stockRest/nasdaq',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;
		
		var Nasdaq = document.getElementById('NASDAQ').getContext('2d');
		const Nasdaq_fill = Nasdaq.createLinearGradient(0, 0, -5, 85);
		Nasdaq_fill.addColorStop(0, 'rgba(231,76,60,0.5)');
		Nasdaq_fill.addColorStop(1, 'rgba(225,255,255,0)');
		
		
		var Nasdaq = document.getElementById('NASDAQ').getContext('2d');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: Nasdaq_fill,
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
			          gridLines: { //A축 gridLines 지우는 옵션
			            display: false,
			            drawBorder: false,
			          },
			          ticks: {
			            fontSize: 0,
			            fontColor: 'rgba(0,0,0,0)'
			    	    }
		      	 	}],
			        yAxes: [{
			          display: false,
			          gridLines: { //Y축 gridLines 지우는 옵션
			            drawBorder: false,
			            display: false,
			          },
			          ticks: {
			            beginAtZero: true,
			            min:9500
			          }
		       		}]
		      	},
                legend: {
                  display: false,
              	},
		     	tooltips: {
		       	 	backgroundColor: '#1e90ff'
		      	}
            }
			var myStock = new Chart(Nasdaq, {
			type: 'line',
			data: data,
			options: options
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});


/*main_USD*/
$.ajax({
	method: 'get',
	url:'/stock/stockRest/USD',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;

		var USD = document.getElementById('USD').getContext('2d');
		const USD_fill = USD.createLinearGradient(0, 0, -5, 85);
		USD_fill.addColorStop(0, 'rgba(231,76,60,0.5)');
		USD_fill.addColorStop(1, 'rgba(225,255,255,0)');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: USD_fill,
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
			          gridLines: { //A축 gridLines 지우는 옵션
			            display: false,
			            drawBorder: false,
			          },
			          ticks: {
			            fontSize: 0,
			            fontColor: 'rgba(0,0,0,0)'
			    	    }
		      	 	}],
			        yAxes: [{
			          display: false,
			          gridLines: { //Y축 gridLines 지우는 옵션
			            drawBorder: false,
			            display: false,
			          },
			          ticks: {
			            beginAtZero: true,
			            min:1200
			          }
		       		}]
		      	},
                legend: {
                  display: false,
              	},
		     	tooltips: {
		       	 	backgroundColor: '#1e90ff'
		      	}
            }
		var myStock = new Chart(USD, {
			type: 'line',
			data: data,
			options: options
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});


/*main_JPY*/
$.ajax({
	method: 'get',
	url:'/stock/stockRest/JPY',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;

		var JPY = document.getElementById('JPY').getContext('2d');
		const JPY_fill = JPY.createLinearGradient(0, 0, -5, 85);
		JPY_fill.addColorStop(0, 'rgba(231,76,60,0.5)');
		JPY_fill.addColorStop(1, 'rgba(225,255,255,0)');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: JPY_fill,
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
			          gridLines: { //A축 gridLines 지우는 옵션
			            display: false,
			            drawBorder: false,
			          },
			          ticks: {
			            fontSize: 0,
			            fontColor: 'rgba(0,0,0,0)'
			    	    }
		      	 	}],
			        yAxes: [{
			          display: false,
			          gridLines: { //Y축 gridLines 지우는 옵션
			            drawBorder: false,
			            display: false,
			          },
			          ticks: {
			            beginAtZero: true,
			            min:920
			          }
		       		}]
		      	},
                legend: {
                  display: false,
              	},
		     	tooltips: {
		       	 	backgroundColor: '#1e90ff'
		      	}
            }
		var myStock = new Chart(JPY, {
			type: 'line',
			data: data,
			options: options
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});

