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

/* 주가 돈 */
$(function(){
  $('.selling-amount-able').on('click', function(e) {
    let nomValue = $(".selling-amount-able").attr("value")
    console.log(nomValue);
      var sum = parseInt(nomValue || 0);
      var stockPrice=$('.total_money').attr("id");
      var here = $('#selling-able-amount').attr("value");
      var sellAmount = parseInt(here || 0);
      var money= sellAmount*stockPrice;
      var money2= -(sellAmount*stockPrice);
      
     

      $("#selling-able-amount").val(sum);
      $("#total_money").val(money.toLocaleString());
      $("#allMoney").val(money2);
    });
}); 


function printName()  {
  const name = document.getElementById('selling-able-amount').value;
  const cost = name * 63000;
  const cost2 = -(name * 63000);
  document.getElementById("total_money").innerText = cost.toLocaleString();
  document.getElementById("allMoney").value = cost2;
}
