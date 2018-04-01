<%--
  Created by IntelliJ IDEA.
  User: liangzhan
  Date: 18-3-30
  Time: 下午10:59
  To change this template use File | Settings | File Templates.
  这是用户管理下的用户查询界面
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户查询</title>
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
        <input type="text" id="userId" class="am-form-field" placeholder="输入用户的ID号">
    </div>
    <div class="am-u-md-2 am-u-end">
        <button type="button" onclick="userManageQuery('1')"
                class="am-btn am-btn-primary am-btn-sm">
            通过用户ID查询
        </button>
    </div>
    <div class="am-u-md-2 am-u-end">
        <button type="button" onclick="userManageQuery('2')"
                class="am-btn am-btn-primary am-btn-sm">
            查询所有用户
        </button>
    </div>
</div>
</body>
</html>
