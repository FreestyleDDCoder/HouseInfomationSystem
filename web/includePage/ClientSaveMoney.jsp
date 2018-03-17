<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>客户存款</title>
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
						<input type="text" class="am-input-sm" id="clientNumberCSM">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						  
					</div>
					<div class="am-u-sm-4 am-u-md-3 am-text-right"> 
						证件号码： 
					</div>
					<div class="am-u-sm-4 am-u-md-3">
						<input type="text" class="am-input-sm" id="paperNumberCSM">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						  
					</div>
				</div>


				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						存款方式：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<select data-am-selected="{btnSize: 'sm'}" id="depositKindsCSM">
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
						存款时长：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<select data-am-selected="{btnSize: 'sm'}" id="depositTimesCSM">
							<option>
								活期存款不用填
							</option>
							<option value="1年">
								1年
							</option>
							<option value="2年">
								2年
							</option>
							<option value="3年">
								3年
							</option>
							<option value="4年">
								4年
							</option>
							<option value="5年">
								5年
							</option>
							<option value="6年">
								6年
							</option>
						</select>
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						
					</div>
				</div>

				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						存款金额：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="savingAmount">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						
					</div>
				</div>
			</form>
			<div class="am-margin">
				<button type="button" onclick="clientSaving()"
					class="am-btn am-btn-primary am-btn-xs">
					点击存款
				</button>
			</div>
		</div>
		</center>
	</body>
</html>