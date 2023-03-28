var map;
var zoom = 12;

function onLoad() {
    map = new T.Map('map', {
        projection: 'EPSG:4326'
    });
    map.centerAndZoom(new T.LngLat(120.224761, 28.758507), zoom);

    //创建河道水闸图标对象
    var iconSz = new T.Icon({
        iconUrl: "../img/shuizha.png",
        iconSize: new T.Point(35, 35),
        iconAnchor: new T.Point(3, 45)
    });
    //创建雨量站图标对象
    var iconYlz = new T.Icon({
        iconUrl: "../img/yuliangzhan.png",
        iconSize: new T.Point(35, 35),
        iconAnchor: new T.Point(3, 45)
    });


    //向地图上添加水闸图标
    var markerJy = new T.Marker(new T.LngLat(120.096411, 28.65491), {
        icon: iconSz
    });
    var markerXd = new T.Marker(new T.LngLat(120.111824, 28.690073), {
        icon: iconSz
    });
    var markerDf = new T.Marker(new T.LngLat(120.180133, 28.75534), {
        icon: iconSz
    });
    var markerHz = new T.Marker(new T.LngLat(120.251923, 28.797696), {
        icon: iconSz
    });
    //向地图上添加雨量站图标
    var markerBq = new T.Marker(new T.LngLat(120.336251, 28.824267), {
        icon: iconYlz
    });
    var markerCy = new T.Marker(new T.LngLat(120.299456, 28.826292), {
        icon: iconYlz
    });
    var markerBs = new T.Marker(new T.LngLat(120.264962, 28.847049), {
        icon: iconYlz
    });
    var markerSf = new T.Marker(new T.LngLat(120.230467, 28.774383), {
        icon: iconYlz
    });
    var markerPl = new T.Marker(new T.LngLat(120.1747, 28.779448), {
        icon: iconYlz
    });
    var markerZs = new T.Marker(new T.LngLat(120.152853, 28.768304), {
        icon: iconYlz
    });
    var markerMas = new T.Marker(new T.LngLat(120.193044, 28.709029), {
        icon: iconYlz
    });
    var markerXy = new T.Marker(new T.LngLat(120.10525, 28.725063), {
        icon: iconYlz
    });
    var markerBx = new T.Marker(new T.LngLat(120.13633, 28.667764), {
        icon: iconYlz
    });
    //添加河道水闸图标
    map.addOverLay(markerJy);
    map.addOverLay(markerXd);
    map.addOverLay(markerDf);
    map.addOverLay(markerHz);
    //添加雨量站图标
    map.addOverLay(markerBq);
    map.addOverLay(markerCy);
    map.addOverLay(markerBs);
    map.addOverLay(markerSf);
    map.addOverLay(markerPl);
    map.addOverLay(markerZs);
    map.addOverLay(markerMas);
    map.addOverLay(markerXy);
    map.addOverLay(markerBx);

    var chartDom = document.getElementById('charts');
    var myChart = echarts.init(chartDom);
    var option;

    //获取元素
    var close = document.getElementById('close');
    var closeBtn = document.querySelector('#closeBtn');
    var chartsBox = document.querySelector('.chartsBox');

    // 点击 closeBtn 就隐藏
    closeBtn.addEventListener('click', function() {
        chartsBox.style.display = 'none';
    })

    // (1) 当我们鼠标按下， 就获得鼠标在盒子内的坐标
    close.addEventListener('mousedown', function(e) {
        map.disableDrag();
        var x = e.pageX - chartsBox.offsetLeft;
        var y = e.pageY - chartsBox.offsetTop;
        // (2) 鼠标移动的时候，把鼠标在页面中的坐标，减去 鼠标在盒子内的坐标就是模态框的left和top值
        document.addEventListener('mousemove', move)

        function move(e) {
            chartsBox.style.left = e.pageX - x + 'px';
            chartsBox.style.top = e.pageY - y + 'px';
        }
        // (3) 鼠标弹起，就让鼠标移动事件移除
        document.addEventListener('mouseup', function() {
            document.removeEventListener('mousemove', move);
            map.enableDrag();
        })
    })

    //添加闸道点击事件 生成数据表
    var chartsBox = document.querySelector('.chartsBox');

    markerJy.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日缙云河道站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/jyselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} m³",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerXd.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日仙都河道站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/xdselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} m³",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerDf.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日东方河道站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/dfselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} m³",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerHz.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日壶镇河道站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/hzselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} m³",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })

    //添加雨量站点击事件 生成数据表
    markerBq.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日八桥雨量站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/bqselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} ㎜",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerCy.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日赤羊雨量站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/cyselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} ㎜",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerBs.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日北山雨量站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/bsselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} ㎜",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerSf.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日双丰雨量站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/sfselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} ㎜",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerPl.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日盘龙雨量站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/plselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} ㎜",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerZs.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日中山雨量站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/zsselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} ㎜",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerMas.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日马鞍山雨量站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/masselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} ㎜",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerXy.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日仙源雨量站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/xyselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} ㎜",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })
    markerBx.addEventListener('click', function() {
        var a=[];
        var chartsTitle='';
        chartsTitle='2021年7月26日白象雨量站';
        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/data/bxselect",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    for(var i=0;i<result.dataList.length;i++){
                        a.push(result.dataList[i]);    //挨个取出类别并填入类别数组
                    }
                    myChart.clear();
                    myChart.hideLoading();    //隐藏加载动画
                    //图表
                    option = {
                        xAxis: {
                            type: 'category',
                            data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23']
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                //这种做法就是在y轴的数据的值旁边拼接单位，貌似也挺方便的
                                formatter: "{value} ㎜",
                            },
                        },
                        series: [{
                            data: a,
                            type: 'line',
                            smooth: true,
                        }],
                        title: [{
                            top: '0',
                            left: 'center',
                            text: chartsTitle,
                        }, {
                            top: '90%',
                            left: 'center',
                            text: '24h内雨量数据'
                        }]
                    };
                    option && myChart.setOption(option);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
        chartsBox.style.display = 'block';
    })

    //防洪调度模拟按钮事件
    var simulation = document.getElementById('simulation');
    var simulationBox = document.querySelector('.simulationBox');
    var simulationClose = document.getElementById('simulationClose');
    simulation.addEventListener('click', function() {
        simulationBox.style.display = 'block';
    })

    simulationClose.addEventListener('click', function() {
        simulationBox.style.display = 'none';
    })

    //雨量下载事件
    var download = document.getElementById('download');
    download.addEventListener('click', function() {
        alert("下载成功！")
    })


}