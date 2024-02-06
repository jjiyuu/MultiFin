
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
		const gradientFill = KOSPI.createLinearGradient(0, 0, -5, 85);
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



/*main_KOSPI*/
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



/*main_SS*/
$.ajax({
	method:'get',
	url:'/stock/stockRest/SS',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;

		var SS = document.getElementById('SS').getContext('2d');
		const gradientFill_SAMSUNG = SS.createLinearGradient(0,0,0,150);
		gradientFill_SAMSUNG.addColorStop(0, 'rgba(110, 184, 110,0.5)');
		gradientFill_SAMSUNG.addColorStop(1, 'rgba(110, 184, 110,0)');
				for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: gradientFill_SAMSUNG,
					borderColor: 'rgb(110, 184, 110)',
					data: dataList,
					lineTension: 0,
					fill: origin,
					borderWidth: 3,
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
			            min:44000
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
		var myStock = new Chart(SS, {
			type: 'line',
			data: data,
			options: options
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});





/*main_SK*/
$.ajax({
	method:'get',
	url:'/stock/stockRest/SK',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;

		var SK = document.getElementById('SK').getContext('2d');
		const sk_fill = SK.createLinearGradient(0,0,0,150);
		sk_fill.addColorStop(0, 'rgba(110, 184, 110,0.5)');
		sk_fill.addColorStop(1, 'rgba(110, 184, 110,0)');
				for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: sk_fill,
					borderColor: 'rgb(110, 184, 110)',
					data: dataList,
					lineTension: 0,
					fill: origin,
					borderWidth: 3,
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
			            min:72000
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
		var myStock = new Chart(SK, {
			type: 'line',
			data: data,
			options: options
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});


/*main_LG*/
$.ajax({
	method:'get',
	url:'/stock/stockRest/LG',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;

		var LG = document.getElementById('LG').getContext('2d');
		const LG_fill = LG.createLinearGradient(0,0,0,150);
		LG_fill.addColorStop(0, 'rgba(110, 184, 110,0.5)');
		LG_fill.addColorStop(1, 'rgba(110, 184, 110,0)');
				for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: LG_fill,
					borderColor: 'rgb(110, 184, 110)',
					data: dataList,
					lineTension: 0,
					fill: origin,
					borderWidth: 3,
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
			            min:400000
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
		var myStock = new Chart(LG, {
			type: 'line',
			data: data,
			options: options
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});
















