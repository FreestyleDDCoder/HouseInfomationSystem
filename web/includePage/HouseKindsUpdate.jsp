<%--
  Created by IntelliJ IDEA.
  User: liangzhan
  Date: 18-4-1
  Time: 下午8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>楼房类型更新</title>
</head>
<body class="body">
<br>

</br>
<div class="am-g  ">
    <div class="am-u-md-2 am-text-right">
        楼房类型ID：
    </div>
    <div class="am-input-group am-input-group-sm am-u-md-6 am-u-end">
        <input type="text" id="kindsId" class="am-form-field" placeholder="输入楼房类型的ID号">
    </div>
</div>
<br>

</br>
<div class="am-g  ">
    <div class="am-u-md-2 am-text-right">
        修改内容：
    </div>
    <div class="am-input-group am-input-group-sm am-u-md-6 ">
        <input type="text" id="houseKinds" class="am-form-field" placeholder="输入修改后的内容！">
    </div>

    <div class="am-u-md-2 am-u-end">
        <button type="button" onclick="houseKindsUpdate()"
                class="am-btn am-btn-primary am-btn-md">
            点击更新
        </button>
    </div>
</div>
</body>
</html>
