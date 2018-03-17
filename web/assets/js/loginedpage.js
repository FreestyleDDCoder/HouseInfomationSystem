/**
 * Created by liangzhan on 18-3-17.
 * 在登录页面用的js
 */
$(document)
    .ready(
        function () {
            $('.inactive')
                .click(
                    function () {
                        if ($(this).siblings('ul').css(
                                'display') == 'none') {
                            $(this).parent('li').siblings(
                                'li').removeClass(
                                'inactives');
                            $(this).addClass('inactives');
                            $(this).siblings('ul')
                                .slideDown(100)
                                .children('li');
                            if ($(this).parents('li')
                                    .siblings('li')
                                    .children('ul').css(
                                        'display') == 'block') {
                                $(this)
                                    .parents('li')
                                    .siblings('li')
                                    .children('ul')
                                    .parent('li')
                                    .children('a')
                                    .removeClass(
                                        'inactives');
                                $(this).parents('li')
                                    .siblings('li')
                                    .children('ul')
                                    .slideUp(100);

                            }
                        } else {
                            //控制自身变成+号
                            $(this)
                                .removeClass(
                                    'inactives');
                            //控制自身菜单下子菜单隐藏
                            $(this).siblings('ul').slideUp(
                                100);
                            //控制自身子菜单变成+号
                            $(this).siblings('ul')
                                .children('li')
                                .children('ul').parent(
                                'li').children(
                                'a').addClass(
                                'inactives');
                            //控制自身菜单下子菜单隐藏
                            $(this).siblings('ul')
                                .children('li')
                                .children('ul')
                                .slideUp(100);

                            //控制同级菜单只保持一个是展开的（-号显示）
                            $(this).siblings('ul')
                                .children('li')
                                .children('a')
                                .removeClass(
                                    'inactives');
                        }
                    })
        });

//这是主页面的ajax
function createXMLHttp(url, path, rank2) {
    var xmlHttp;//声明xmlHttp变量
    var myurl = url;//声明url
    var mypath = path;
    var myrank2 = rank2;
    try {//如果是火狐，欧朋，苹果浏览器就可以创建
        xmlHttp = new XMLHttpRequest;
    } catch (e) {
        try {
            //ie 6.0+
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                //ie 5.0+
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                //不支持AJAX
                alert("您的浏览器不支持AJAX");
                return false;
            }
        }
    }
    //响应处理
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4) {//响应完全接收
            document.getElementById("form").innerHTML = "/" + myrank2 + "页面";
            document.getElementById("includePage").innerHTML = xmlHttp.responseText;
        }
    }
    //跳转到对应页面(xmlHttp.responseText响应的页面)
    if (myurl != mypath) {
        xmlHttp.open("GET", myurl, true);
        xmlHttp.send(null);
    }
}

//这是客户注册页面的ajax
//定义全局变量
var clientNumber;
var clientPaper;
var paperNumber;
var paperStates;
var confPaperNumber;
var sex;
var clientKinds;
var Kinds;
var chineseName;
var englishName;
var phoneNumber;
var States;
var province;
var city;
var mail;
var address;
var addressNumber;
var callPhone;
var clientNick;
function registXMLHttp() {
    var xmlHttp2;//声明xmlHttp变量
    try {//如果是火狐，欧朋，苹果浏览器就可以创建
        xmlHttp2 = new XMLHttpRequest;
    } catch (e) {
        try {
            //ie 6.0+
            xmlHttp2 = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                //ie 5.0+
                xmlHttp2 = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                //不支持AJAX
                alert("您的浏览器不支持AJAX");
                return false;
            }
        }
    }
    //响应处理
    xmlHttp2.onreadystatechange = function () {
        if (xmlHttp2.readyState == 4) {//响应完全接收(加载成功)
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState == 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    }
    xmlHttp2.open("post", "RegistCCServlet", true);
    xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
    //xmlHttp2.setRequestHeader("Content-length", "para")
    xmlHttp2.send("clientNumber=" + clientNumber + "&clientPaper=" + clientPaper + "&paperNumber=" + paperNumber + "&paperStates=" + paperStates + "&sex=" + sex + "&clientKinds=" + clientKinds + "&Kinds=" + Kinds + "&chineseName=" + chineseName + "&englishName=" + englishName + "&phoneNumber=" + phoneNumber + "&States=" + States + "&province=" + province + "&city=" + city + "&mail=" + mail + "&address=" + address + "&addressNumber=" + addressNumber + "&callPhone=" + callPhone + "&clientNick=" + clientNick);
}
function check() {
    //获取相应的值
    clientNumber = document.getElementById("clientNumber").value;
    clientPaper = document.getElementById("clientPaper").value;
    paperNumber = document.getElementById("paperNumber").value;
    paperStates = document.getElementById("paperStates").value;
    confPaperNumber = document.getElementById("confPaperNumber").value;
    sex = document.getElementById("sex").value;
    clientKinds = document.getElementById("clientKinds").value;
    Kinds = document.getElementById("Kinds").value;
    chineseName = document.getElementById("chineseName").value;
    englishName = document.getElementById("englishName").value;
    phoneNumber = document.getElementById("phoneNumber").value;
    States = document.getElementById("States").value;
    province = document.getElementById("province").value;
    city = document.getElementById("city").value;
    mail = document.getElementById("mail").value;
    address = document.getElementById("address").value;
    addressNumber = document.getElementById("addressNumber").value;
    callPhone = document.getElementById("callPhone").value;
    clientNick = document.getElementById("clientNick").value;

    if (clientPaper == "" || paperNumber == "" || paperStates == "" || confPaperNumber == "" || clientKinds == "" || Kinds == "" || chineseName == "" || englishName == "" || phoneNumber == "" || States == "" || province == "" || city == "" || address == "" || callPhone == "") {
        alert("*必填项不能为空!");
    } else {
        if (paperNumber != confPaperNumber) {
            alert("两次输入的证件号码不一致，请检查！");
        } else {
            registXMLHttp();
        }
    }
}
//js方法未定位的原因有：某些元素写错。

//这是账户开户界面的ajax
function accountOpening() {
    var xmlHttp2;//声明xmlHttp变量
    try {//如果是火狐，欧朋，苹果浏览器就可以创建
        xmlHttp2 = new XMLHttpRequest;
    } catch (e) {
        try {
            //ie 6.0+
            xmlHttp2 = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                //ie 5.0+
                xmlHttp2 = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                //不支持AJAX
                alert("您的浏览器不支持AJAX");
                return false;
            }
        }
    }
    //响应处理
    xmlHttp2.onreadystatechange = function () {
        if (xmlHttp2.readyState == 4) {//响应完全接收(加载成功)
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState == 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    }
    //这里获取页面数据信息
    var clientNumberAO = document.getElementById("clientNumberAO").value;
    var clientManagerNumber = document.getElementById("clientManagerNumber").value;
    var clientKindsAO = document.getElementById("clientKindsAO").value;
    var moneyKinds = document.getElementById("moneyKinds").value;
    var balanceKinds = document.getElementById("balanceKinds").value;
    var openTime = document.getElementById("openTime").value;
    var depositKindsAO = document.getElementById("depositKindsAO").value;

    if (clientNumber == "" || clientManagerNumber == "" || clientKinds == "" || moneyKinds == "" || balanceKinds == "" || openTime == "" || depositKindsAO == "") {
        alert("*必填项不能为空!");
    } else {
        xmlHttp2.open("post", "AccountOpenServlet", true);
        xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
        //xmlHttp2.setRequestHeader("Content-length", "para")
        xmlHttp2.send("clientNumberAO=" + clientNumberAO + "&clientManagerNumber=" + clientManagerNumber + "&clientKindsAO=" + clientKindsAO + "&moneyKinds=" + moneyKinds + "&balanceKinds=" + balanceKinds + "&openTime=" + openTime + "&depositKindsAO=" + depositKindsAO);
    }
}

//这里是客户存款的Ajax

function clientSaving() {
    var xmlHttp2;//声明xmlHttp变量
    try {//如果是火狐，欧朋，苹果浏览器就可以创建
        xmlHttp2 = new XMLHttpRequest;
    } catch (e) {
        try {
            //ie 6.0+
            xmlHttp2 = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                //ie 5.0+
                xmlHttp2 = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                //不支持AJAX
                alert("您的浏览器不支持AJAX");
                return false;
            }
        }
    }
    //响应处理
    xmlHttp2.onreadystatechange = function () {
        if (xmlHttp2.readyState == 4) {//响应完全接收(加载成功)
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState == 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    }
    //这里获取页面数据信息
    var clientNumberCSM = document.getElementById("clientNumberCSM").value;
    var paperNumberCSM = document.getElementById("paperNumberCSM").value;
    var depositKindsCSM = document.getElementById("depositKindsCSM").value;
    var depositTimesCSM = document.getElementById("depositTimesCSM").value;
    var savingAmount = document.getElementById("savingAmount").value;

    if (clientNumberCSM == "" || paperNumberCSM == "" || depositKindsCSM == "选择存款方式" || savingAmount == "") {
        alert("选项不能为空！");
    } else {
        if (depositKindsCSM == "定期" && depositTimesCSM == "活期存款不用填") {
            alert("定期时长选项不能为空！");
        } else {
            if (depositTimesCSM == "活期存款不用填")
                depositTimesCSM == "";
            xmlHttp2.open("post", "SaveMoneyServlet", true);
            xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
            //xmlHttp2.setRequestHeader("Content-length", "para")
            xmlHttp2.send("clientNumberCSM=" + clientNumberCSM + "&paperNumberCSM=" + paperNumberCSM + "&depositKindsCSM=" + depositKindsCSM + "&depositTimesCSM=" + depositTimesCSM + "&savingAmount=" + savingAmount);
        }
    }
}

//这里是客户取款的AJAX

function clientGetMoney() {
    var xmlHttp2;//声明xmlHttp变量
    try {//如果是火狐，欧朋，苹果浏览器就可以创建
        xmlHttp2 = new XMLHttpRequest;
    } catch (e) {
        try {
            //ie 6.0+
            xmlHttp2 = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                //ie 5.0+
                xmlHttp2 = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                //不支持AJAX
                alert("您的浏览器不支持AJAX");
                return false;
            }
        }
    }
    //响应处理
    xmlHttp2.onreadystatechange = function () {
        if (xmlHttp2.readyState == 4) {//响应完全接收(加载成功)
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState == 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    }
    //这里获取页面数据信息
    var clientNumberCCM = document.getElementById("clientNumberCCM").value;
    var paperNumberCCM = document.getElementById("paperNumberCCM").value;
    var depositKindsCCM = document.getElementById("depositKindsCCM").value;
    var getMoney = document.getElementById("getMoney").value;

    if (clientNumberCCM == "" || paperNumberCCM == "" || depositKindsCCM == "选择存款方式" || getMoney == "") {
        alert("*必填项不能为空!");
    } else {
        xmlHttp2.open("post", "GetMoneyServlet", true);
        xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
        //xmlHttp2.setRequestHeader("Content-length", "para")
        xmlHttp2.send("clientNumberCCM=" + clientNumberCCM + "&paperNumberCCM=" + paperNumberCCM + "&depositKindsCCM=" + depositKindsCCM + "&getMoney=" + getMoney);
    }
}
//这里是账户余额的ajax
function clientSerachMoney() {
    var xmlHttp2;//声明xmlHttp变量
    try {//如果是火狐，欧朋，苹果浏览器就可以创建
        xmlHttp2 = new XMLHttpRequest;
    } catch (e) {
        try {
            //ie 6.0+
            xmlHttp2 = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                //ie 5.0+
                xmlHttp2 = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                //不支持AJAX
                alert("您的浏览器不支持AJAX");
                return false;
            }
        }
    }
    //响应处理
    xmlHttp2.onreadystatechange = function () {
        if (xmlHttp2.readyState == 4) {//响应完全接收(加载成功)
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState == 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    }
    //这里获取页面数据信息
    var clientNumberSM = document.getElementById("clientNumberSM").value;
    var depositSM = document.getElementById("depositSM").value;

    if (clientNumberSM == "" || depositSM == "选择账户") {
        alert("*必填项不能为空!");
    } else {
        xmlHttp2.open("post", "SerachMoneyServlet", true);
        xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
        //xmlHttp2.setRequestHeader("Content-length", "para")
        xmlHttp2.send("clientNumberSM=" + clientNumberSM + "&depositSM=" + depositSM);
    }
}