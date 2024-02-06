
/*main_SS*/
var MY_ACCOUNT = document.getElementById('MY_ACCOUNT').getContext('2d');
const MY_ACCOUNTFill = MY_ACCOUNT.createLinearGradient(0,0,0,10);
		
var lds=[];
for (var i=0; i<10; i++){lds.push(i);}
var data = {
                    labels : lds,
                    datasets: [
                      {
                        backgroundColor: 'transparent',
                        borderColor: 'rgb(255,150,150)',
                        data: [1500, 1200,1700,1800,1900,1500,1700,1900,2200, 2300],
                        lineTension : 0,  
                        fill: origin,
                        borderWidth:2,
                        pointRadius: 0,
                      }
                    ]
            };
   let options = {
                scales: {
                  xAxes: [{
					display: false,
                    gridLines: {
                      lineWidth: 0,
                      color: 'rgb(240, 239, 239)',
                    },
                  }],
                  
                  yAxes: [{
                    gridLines: {
                      lineWidth: 0,
                      color: 'rgb(240, 239, 239)',
                    },
                    ticks: {
                      beginAtZero: false,
                       min:1000
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
    var myStock = new Chart(MY_ACCOUNT, {
                type: 'line',
                data: data,
                options: options
    });
   