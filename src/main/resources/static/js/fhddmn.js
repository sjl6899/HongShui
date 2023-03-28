var mySelect = document.getElementById('mySelect');
var message = document.getElementById('message');
var index = mySelect.selectedIndex;
var download3h = document.getElementById('download3h');
var forecast = document.getElementById('forecast');
var hz = document.getElementById('hz');
var df = document.getElementById('df');
var xd = document.getElementById('xd');
var overall = document.getElementById('overall');
var smtBtn = document.getElementById('smtBtn');
forecast.value = 0;
hz.value = 0;
df.value = 0;
xd.value = 0;

function downloadEvt(url) {
    window.location.href = url;
}

function check() {
    if (mySelect.value == '201907') {

        message.innerHTML = '当3小时面降雨量: 101.7542857毫米, 201.5427143毫米, 349.3822222毫米 缙云河道3小时内流量 :13.0456立方米,15.3975立方米, 10.0356立方米';
    } else if (mySelect.value == '202006') {

        message.innerHTML = '当3小时面降雨量: 265.8423333毫米, 323.4735619毫米, 334.9384984毫米缙云河道3小时内流量 :0.7618立方米,0.9817立方米, 0.9921立方米';
    } else if (mySelect.value == '202106') {

        message.innerHTML = '当3小时面降雨量: 133.648毫米, 183.0938413毫米, 229.5022222毫米缙云河道3小时内流量 :2.8275立方米,0.1623立方米, 1.7809立方米';
    }
}


function download(filename, text) {
    var pom = document.createElement("a");
    pom.setAttribute(
        "href",
        "data:text/plain;charset=utf-8," + encodeURIComponent(text)
    );
    pom.setAttribute("download", filename);
    if (document.createEvent) {
        var event = document.createEvent("MouseEvents");
        event.initEvent("click", true, true);
        pom.dispatchEvent(event);
    } else {
        pom.click();
    }
}


download3h.addEventListener('click', function() {
    if (mySelect.value == '201907') {
        download("201907.txt", "201907");
    } else if (mySelect.value == '202006') {
        download("202006.txt", "202006");
    } else if (mySelect.value == '202106') {
        download("202106.txt", "202106");
    }
})


hz.addEventListener('input', function() {
    var num = ((parseFloat(hz.value) + parseFloat(df.value) + parseFloat(xd.value)) / 90) * 100;
    overall.innerHTML = Number(num.toString().match(/^\d+(?:\.\d{0,2})?/)) + '%';
})

df.addEventListener('input', function() {
    var num = ((parseFloat(hz.value) + parseFloat(df.value) + parseFloat(xd.value)) / 90) * 100;
    overall.innerHTML = Number(num.toString().match(/^\d+(?:\.\d{0,2})?/)) + '%';
})

xd.addEventListener('input', function() {
    var num = ((parseFloat(hz.value) + parseFloat(df.value) + parseFloat(xd.value)) / 90) * 100;
    overall.innerHTML = Number(num.toString().match(/^\d+(?:\.\d{0,2})?/)) + '%';
})