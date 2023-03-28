 //Echarts表生成
 $(document).ready(function() {
     var chartDom = document.getElementById('charts');
     var myChart = echarts.init(chartDom);
     var option;

     option = {
         xAxis: {
             type: 'category',
             data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
         },
         yAxis: {
             type: 'value'
         },
         series: [{
             data: [
                 15, 23, 24, 21, 13, 14, 26, 15, 23, 22, 21, 13, 14, 26, 23, 22, 21, 13, 14, 26, 23, 22, 21, 13
             ],
             type: 'line',
             smooth: true,
         }],
         title: [{
             top: '0',
             left: 'center',
             text: '6月14日八桥雨量站'
         }, {
             top: '90%',
             left: 'center',
             text: '24h内雨量数据'
         }]
     };

     option && myChart.setOption(option);
 });