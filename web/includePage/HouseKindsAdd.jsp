<%--
  Created by IntelliJ IDEA.
  User: liangzhan
  Date: 18-4-1
  Time: 下午8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>楼房类型添加</title>
</head>
<body class="body">
<br>

</br>
<div class="am-g  ">
    <div class="am-u-md-2 am-text-right">
        设置楼房类型ID：
    </div>
    <div class="am-input-group am-input-group-sm am-u-md-6 am-u-end">
        <input type="text" id="kindsId" class="am-form-field" placeholder="输入想要设置的楼房类型ID号">
    </div>
</div>
<br>

</br>
<div class="am-g  ">
    <div class="am-u-md-2 am-text-right">
        楼房类型：
    </div>
    <div class="am-input-group am-input-group-sm am-u-md-6 ">
        <input type="text" id="houseKinds" class="am-form-field" placeholder="输入增加的楼房类型！">
    </div>

    <div class="am-u-md-2 am-u-end">
        <button type="button" onclick="houseKindsAdd()"
                class="am-btn am-btn-primary am-btn-md">
            点击增加
        </button>
    </div>
</div>
</body>
</html>
