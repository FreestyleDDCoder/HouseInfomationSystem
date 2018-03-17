<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>取款</title>
</head>
<body class="body">
<center>
			<div id="registResult" class="am-u-sm-centered">
			<form class="am-form" name="registRorm">
				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right"> 
						客户编号： 
					</div>
					<div class="am-u-sm-4 am-u-md-3">
						<input type="text" class="am-input-sm" id="clientNumberCCM">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						  
					</div>
					<div class="am-u-sm-4 am-u-md-3 am-text-right"> 
						证件号码： 
					</div>
					<div class="am-u-sm-4 am-u-md-3">
						<input type="text" class="am-input-sm" id="paperNumberCCM">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						  
					</div>
				</div>


				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						存款方式：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<select data-am-selected="{btnSize: 'sm'}" id="depositKindsCCM">
							<option>
							选择存款方式
							</option>
							<option value="活期">
								活期
							</option>
							<option value="定期">
								定期
							</option>
						</select>
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						
					</div>
					<div class="am-u-sm-4 am-u-md-3 am-text-right">
						取款金额：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="getMoney">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						
					</div>
				</div>
			</form>
			<div class="am-margin">
				<button type="button" onclick="clientGetMoney()"
					class="am-btn am-btn-primary am-btn-xs">
					点击取款
				</button>
			</div>
		</div>
		</center>
</body>
</html>