<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>账户开户</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<center>
			<div class="am-text-primary am-text-1g">
				<strong> 客户编号信息 </strong>
			</div>
			<div id="registResult" class="am-u-sm-centered">
				<form class="am-form" name="registRorm">
					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">
							客户编号：
						</div>
						<div class="am-u-sm-4 am-u-md-3">
							<input type="text" class="am-input-sm" id="clientNumberAO">
						</div>
						<div class="am-hide-sm-only am-u-md-1">
							*必填
						</div>
						<div class="am-u-sm-4 am-u-md-2 am-text-right">			
						</div>
						<div class="am-u-sm-8 am-u-md-3">
						</div>
						<div class="am-hide-sm-only am-u-md-1">
						</div>
					</div>

					<div class="am-text-primary am-text-1g">
						<br>
						<strong>账户明细</strong>
					</div>
					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">
							客户经理编号：
						</div>
						<div class="am-u-sm-8 am-u-md-3 am-u-end col-end">
							<input type="text" class="am-input-sm" id="clientManagerNumber">
						</div>
						<div class="am-hide-sm-only am-u-md-1">
							*必填
						</div>
						<div class="am-u-sm-4 am-u-md-2 am-text-right">
							客户类型：
						</div>
						<div class="am-u-sm-8 am-u-md-3">
							<select data-am-selected="{btnSize: 'sm'}" id="clientKindsAO">
								<option>
									请选择
								</option>
								<option value="普通客户">
									普通客户
								</option>
								<option value="VIP客户">
									VIP客户
								</option>
							</select>
						</div>
						<div class="am-hide-sm-only am-u-md-1">
							*必填
						</div>
					</div>

					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">
							账户币种：
						</div>
						<div class="am-u-sm-8 am-u-md-3">
							<select data-am-selected="{btnSize: 'sm'}" id="moneyKinds">
								<option>
									请选择
								</option>
								<option value="人民币">
									人民币
								</option>
								<option value="外币">
									外币
								</option>
							</select>
						</div>
						<div class="am-hide-sm-only am-u-md-1">
							*必填
						</div>

						<div class="am-u-sm-4 am-u-md-2 am-text-right">
							余额类型：
						</div>
						<div class="am-u-sm-8 am-u-md-3">
							<select data-am-selected="{btnSize: 'sm'}" id="balanceKinds">
								<option>
									请选择
								</option>
								<option value="可用">
									可用
								</option>
								<option value="不可用">
									不可用
								</option>
							</select>
						</div>
						<div class="am-hide-sm-only am-u-md-1">
							*必填
						</div>
					</div>
					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">
							开户时间：
						</div>
						<div class="am-u-sm-8 am-u-md-3">
							<div class="am-form-group am-form-icon">
								<i class="am-icon-calendar"></i>
								<input type="date" class="am-form-field am-input-sm"
									placeholder="日期" id="openTime">
							</div>
						</div>
						<div class="am-hide-sm-only am-u-md-1">
							*必填
						</div>
						<div class="am-u-sm-4 am-u-md-2 am-text-right">
							存款类型：
						</div>
						<div class="am-u-sm-8 am-u-md-3">
							<select data-am-selected="{btnSize: 'sm'}" id="depositKindsAO">
								<option>
									请选择
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
							*必填
						</div>
					</div>
				</form>
				<div class="am-margin">
					<button type="button" onclick="accountOpening()"
						class="am-btn am-btn-primary am-btn-xs">
						点击这里提交保存
					</button>
				</div>
			</div>
		</center>
	</body>
</html>
