<%--
  Created by IntelliJ IDEA.
  User: liangzhan
  Date: 18-3-30
  Time: 下午11:00
  To change this template use File | Settings | File Templates.
  这是用户管理下的用户删除界面
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>用户删除</title>
</head>
<body class="body">
<div class="am-g  ">
    <br>

    </br>
    <br>

    </br>
    <div class="am-u-md-2 am-text-right">
        用户ID：
    </div>
    <div class="am-input-group am-input-group-sm am-u-md-6">
        <input type="text" id="userId" class="am-form-field" placeholder="输入需要删除的用户ID号">
    </div>
    <div class="am-u-md-2 am-u-end">
        <button type="button" onclick="userManageDelete()"
                class="am-btn am-btn-primary am-btn-sm">
            删除
        </button>
    </div>
</div>
</body>
</html>
