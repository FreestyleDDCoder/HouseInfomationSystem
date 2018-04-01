<%--
  Created by IntelliJ IDEA.
  User: liangzhan
  Date: 18-4-1
  Time: 下午7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>楼房类型删除</title>
</head>
<body class="body">
<div class="am-g  ">
    <br>

    </br>
    <br>

    </br>
    <div class="am-u-md-2 am-text-right">
        楼房类型ID：
    </div>
    <div class="am-input-group am-input-group-sm am-u-md-6">
        <input type="text" id="kindsId" class="am-form-field" placeholder="输入需要删除的楼房类型ID号">
    </div>
    <div class="am-u-md-2 am-u-end">
        <button type="button" onclick="houseKindsDelete()"
                class="am-btn am-btn-primary am-btn-sm">
            删除
        </button>
    </div>
</div>
</body>
</html>
