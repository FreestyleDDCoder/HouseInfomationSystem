<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--这是登陆界面的首页 --%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Login Page | Welcome!</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="alternate icon" type="image/png"
          href="${path}assets/i/favicon.png">
    <link rel="stylesheet" href="${path}assets/css/amazeui.min.css"/>
    <style>
        .header {
            text-align: center;
        }

        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }

        .header p {
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="am-g">
        <h1>
            房地产公司楼盘信息系统管理端
        </h1>
        <p>
            BEAST HOUSE!
            <br/>
            提供最好的楼盘信息
        </p>
    </div>
    <hr/>
</div>
<div class="am-g">
    <%
        String result = request.getParameter("result");
        if (result == null)
            result = "";
    %>
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <a><%=result%>
        </a>
    </div>
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <form action="<%=path%>/servlet/LoginCoServlet" method="post"
              class="am-form">

            <label for="text">
                管理员账号:
            </label>
            <input type="text" name="adminId">

            <label for="password">
                账号密码:
            </label>
            <input type="password" name="adminPassword">

            <label for="remember-me">
                <input id="remember-me" type="checkbox">
                记住密码
            </label>
            <div class="am-cf">
                <input type="submit" name="" value="登 录"
                       class="am-btn am-btn-primary am-btn-sm am-fl">
                <input type="reset" name="" value="重 置"
                       class="am-btn am-btn-default am-btn-sm am-fr">
            </div>
        </form>
        <hr>
        <p>
            © 2014 AllMobilize, Inc. Licensed under MIT license.
        </p>
    </div>
</div>
</body>
</html>

