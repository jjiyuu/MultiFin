

$(document).ready(function() {
	$('ul.tabs li').click(function() {
		var tab_id = $(this).attr('data-tab');
		var tab_check = $(this).attr('data-tab') + 2;
		var tab_check_second = $(this).attr('data-tab') + 3;
		var tab_third = $(this).attr('data-tab') + 4;

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
		$('.stock_tab_sub').removeClass('current');
		$('.stock_details').removeClass('current');
		$('.stock_description_detail_container').removeClass('current');

		$(this).addClass('current');
		$("#" + tab_id).addClass('current');
		$("#" + tab_check).addClass('current');
		$("#" + tab_check_second).addClass('current');
		$("#" + tab_third).addClass('current');
	})

});


$(function() {
	if (location.hash == "#tab_second") {
		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
		$('.stock_tab_sub').removeClass('current');
		$('.stock_details').removeClass('current');
		$('.stock_description_detail_container').removeClass('current');

		var check = $('.tabs').find('li').eq(1);
		var tab_id = $(check).attr('data-tab');
		var tab_check = $(check).attr('data-tab') + 2;
		var tab_check_second = $(check).attr('data-tab') + 3;
		var tab_third = $(check).attr('data-tab') + 4;

		$(check).addClass('current');
		$("#" + tab_id).addClass('current');
		$("#" + tab_check).addClass('current');
		$("#" + tab_check_second).addClass('current');
		$("#" + tab_third).addClass('current');
	}
	
		if (location.hash == "#tab_third") {
		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
		$('.stock_tab_sub').removeClass('current');
		$('.stock_details').removeClass('current');
		$('.stock_description_detail_container').removeClass('current');

		var check = $('.tabs').find('li').eq(2);
		var tab_id = $(check).attr('data-tab');
		var tab_check = $(check).attr('data-tab') + 2;
		var tab_check_second = $(check).attr('data-tab') + 3;
		var tab_third = $(check).attr('data-tab') + 4;

		$(check).addClass('current');
		$("#" + tab_id).addClass('current');
		$("#" + tab_check).addClass('current');
		$("#" + tab_check_second).addClass('current');
		$("#" + tab_third).addClass('current');
	}
	
	
})





/*주가 그래프*/
/*kospi */
$.ajax({
	method: 'get',
	url: '/stock/stockRest/kospi',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;
		var KOSPI = document.getElementById('KOSPI').getContext('2d');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: 'rgba(255,150,150,0.5)',
					borderColor: 'rgb(255,150,150)',
					data: dataList,
					lineTension: 0,
					fill: origin,
					borderWidth: 2,
					pointRadius: 0,
				}
			]
		};
		let options_now = {
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
						min: 2100
					}
				}]
			},
			legend: {
				display: false,
			}
		}
		var myStock = new Chart(KOSPI, {
			type: 'line',
			data: data,
			options: options_now
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});


/*kosdaq */
$.ajax({
	method: 'get',
	url: '/stock/stockRest/kosdaq',
	contentType: 'application/json',
	dataType: 'json',
	success: (result) => {
		var lds = [];
		var dataList = [];
		dataList = result;
		var KOSDAQ = document.getElementById('KOSDAQ').getContext('2d');
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: 'rgba(255,150,150,0.5)',
					borderColor: 'rgb(255,150,150)',
					data: dataList,
					lineTension: 0,
					fill: origin,
					borderWidth: 2,
					pointRadius: 0,
				}
			]
		};
		let options_now = {
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
						min: 650
					}
				}]
			},
			legend: {
				display: false,
			}
		}
		var myStock = new Chart(KOSDAQ, {
			type: 'line',
			data: data,
			options: options_now
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
		for (var i = 0; i < dataList.length; i++) {
			lds.push(i);
		}
		var data = {
			labels: lds,
			datasets: [
				{
					backgroundColor: 'rgba(255,150,150,0.5)',
					borderColor: 'rgb(255,150,150)',
					data: dataList,
					lineTension: 0,
					fill: origin,
					borderWidth: 2,
					pointRadius: 0,
				}
			]
		};
		let options_now = {
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
						min: 9000
					}
				}]
			},
			legend: {
				display: false,
			}
		}
		var myStock = new Chart(Nasdaq, {
			type: 'line',
			data: data,
			options: options_now
		});
	},
	error: (e) => {
		alert('전송 실패!!');
	}
});




/*stock-graph(주가동향)*/

graphItems = document.getElementsByClassName('stock_graph'); 
for (i = 0; i < graphItems.length; i++) {
	stockID = graphItems[i].getAttribute('value');
	callAJAX(stockID);
}

function callAJAX(stockID){
	$.ajax({
		method: 'get',
		url:'/stock/stockRest/'+ stockID,
		contentType: 'application/json',
		dataType: 'json',
		success: (result) => {
			var lds = [];
			var dataList = [];
			dataList = result;
	
			var stock = document.getElementById(stockID).getContext('2d');
			const stock_Fill = stock.createLinearGradient(0, 0, 0, 150);
			stock_Fill.addColorStop(0, 'rgba(110, 184, 110,0.5)');
			stock_Fill.addColorStop(1, 'rgba(110, 184, 110,0)');
			for (var i = 0; i < dataList.length; i++) {
				lds.push(i);
			}
			var data = {
				labels: lds,
				datasets: [
					{
						backgroundColor: stock_Fill,
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
				            min:53000
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
}

