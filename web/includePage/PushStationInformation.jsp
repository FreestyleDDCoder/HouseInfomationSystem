<%--
  Created by IntelliJ IDEA.
  User: liangzhan
  Date: 18-3-19
  Time: 下午11:17
  To change this template use File | Settings | File Templates.
  这是站内消息推送页面
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>推送消息</title>
</head>
<body class="body">
<div class="am-g  ">
    <br>

    </br>
    <br>

    </br>
    <div class="am-u-md-2 am-text-right">
        推送内容：
    </div>
    <div class="am-input-group am-input-group-sm am-u-md-6">
        <input type="text" id="pushMessage" class="am-form-field" placeholder="推送内容">
    </div>
    <div class="am-u-md-2 am-u-end">
        <button type="button" onclick="pushStationInformation()"
                class="am-btn am-btn-primary am-btn-sm">
            点击推送
        </button>
    </div>
</div>
</body>
</html>
