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
                                'display') === 'none') {
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
                                        'display') === 'block') {
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
//这是引入相应页面的ajax
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
        if (xmlHttp.readyState === 4) {//响应完全接收
            document.getElementById("includePage").innerHTML = xmlHttp.responseText;
        }
    };
    //跳转到对应页面(xmlHttp.responseText响应的页面)
    if (myurl !== mypath) {
        xmlHttp.open("GET", myurl, true);
        xmlHttp.send(null);
    }
}
//这是消息推送的js方法
function pushStationInformation() {
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
        if (xmlHttp2.readyState === 4) {//响应完全接收(加载成功)
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState === 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    }
    //这里获取页面数据信息
    var pushMessage = document.getElementById("pushMessage").value;
    if (pushMessage === "") {
        alert("*推送消息内容不能为空!");
    } else {
        xmlHttp2.open("post", "PushStationInformationServlet", true);
        xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
        //xmlHttp2.setRequestHeader("Content-length", "para")
        xmlHttp2.send("pushMessage=" + pushMessage);
    }
}