/**
 * Created by liangzhan on 18-4-1.
 */
//这是用户管理查询界面的ajax
function userManageQuery(queryType) {
    var xmlHttp2;//声明xmlHttp变量
    var myQueryType = queryType;//声明传进来的参数
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
        if (xmlHttp2.readyState === 4) {//响应完全接收
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState === 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    };
    //跳转到对应页面(xmlHttp.responseText响应的页面)
    //这里获取页面数据信息
    var userId = document.getElementById("userId").value;
    if (myQueryType === "1") {
        if (userId === "") {
            alert("该查询下用户ID不能为空！");
        } else {
            xmlHttp2.open("post", "UserManageServlet", true);
            xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            //xmlHttp2.setRequestHeader("Content-length", "para")
            xmlHttp2.send("userId=" + userId + "&queryType=" + myQueryType);
        }
    } else if (myQueryType === "2") {
        xmlHttp2.open("post", "UserManageServlet", true);
        xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        //xmlHttp2.setRequestHeader("Content-length", "para")
        xmlHttp2.send("userId=" + userId + "&queryType=" + myQueryType);
    }
}
//这是用户删除界面js
function userManageDelete() {
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
        if (xmlHttp2.readyState === 4) {//响应完全接收
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState === 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    };
    //跳转到对应页面(xmlHttp.responseText响应的页面)
    //这里获取页面数据信息
    var userId = document.getElementById("userId").value;
    if (userId === "") {
        alert("该操作下用户ID不能为空！");
    } else {
        if (confirm("确定删除该用户的所有资料吗？")) {
            xmlHttp2.open("post", "UserManageDeleteServlet", true);
            xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            xmlHttp2.send("userId=" + userId);
        }
    }
}

//这是楼房类型删除界面js
function houseKindsDelete() {
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
        if (xmlHttp2.readyState === 4) {//响应完全接收
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState === 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    };
    //跳转到对应页面(xmlHttp.responseText响应的页面)
    //这里获取页面数据信息
    var kindsId = document.getElementById("kindsId").value;
    if (kindsId === "") {
        alert("该操作下楼房类型ID不能为空！");
    } else {
        if (confirm("确定删除该楼房类型的所有资料吗？")) {
            xmlHttp2.open("post", "HouseKindsDeleteServlet", true);
            xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            xmlHttp2.send("kindsId=" + kindsId);
        }
    }
}

//这是楼房类型删除界面js
function houseKindsUpdate() {
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
        if (xmlHttp2.readyState === 4) {//响应完全接收
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState === 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    };
    //跳转到对应页面(xmlHttp.responseText响应的页面)
    //这里获取页面数据信息
    var kindsId = document.getElementById("kindsId").value;
    var houseKinds = document.getElementById("houseKinds").value;
    if (kindsId === "" || houseKinds === "") {
        alert("输入框不能为空！");
    } else {
        if (confirm("确定更新该楼房类型的资料吗？")) {
            xmlHttp2.open("post", "HouseKindsUpdateServlet", true);
            xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            xmlHttp2.send("kindsId=" + kindsId + "&houseKinds=" + houseKinds);
        }
    }
}

//这是楼房类型删除界面js
function houseKindsAdd() {
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
        if (xmlHttp2.readyState === 4) {//响应完全接收
            document.getElementById("includePage").innerHTML = xmlHttp2.responseText;
        }
        if (xmlHttp2.readyState === 1) {//点击界面则立即转到
            document.getElementById("includePage").innerHTML = "<div class=" + "am-u-sm-centered" + ">正在等待处理结果：" + "</div>";
        }
    };
    //跳转到对应页面(xmlHttp.responseText响应的页面)
    //这里获取页面数据信息
    var kindsId = document.getElementById("kindsId").value;
    var houseKinds = document.getElementById("houseKinds").value;
    if (kindsId === "" || houseKinds === "") {
        alert("输入框不能为空！");
    } else {
        if (confirm("确定增加该楼房类型的资料吗？")) {
            xmlHttp2.open("post", "HouseKindsAddServlet", true);
            xmlHttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            xmlHttp2.send("kindsId=" + kindsId + "&houseKinds=" + houseKinds);
        }
    }
}