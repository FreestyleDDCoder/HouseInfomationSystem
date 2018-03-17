<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>

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
		<div id="registResult" class="am-u-sm-centered">
			<form class="am-form" name="registRorm">
				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right"> 
						客户编号： 
					</div>
					<div class="am-u-sm-4 am-u-md-3">
						<input type="text" class="am-input-sm" id="clientNumber">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						  
					</div>
					<div class="am-u-sm-4 am-u-md-3 am-text-right">
						证件类型：
					</div>
					<div class="am-u-sm-4 am-u-md-3">
						<select data-am-selected="{btnSize: 'sm'}" id="clientPaper">
							<option>
								请选择
							</option>
							<option value="大陆居民身份证">
								大陆居民身份证
							</option>
							<option value="港/澳/台胞证">
								港/澳/台胞证
							</option>
							<option value="其它证件">
								其它证件
							</option>
						</select>
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
				</div>


				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						证件号码：
					</div>
					<div class="am-u-sm-8 am-u-md-3 am-u-end col-end">
						<input type="text" class="am-input-sm" id="paperNumber">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						发证国家：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<select data-am-selected="{btnSize: 'sm'}" id="paperStates">
							<option>
								请选择
							</option>
							<option value="中国">
								中国
							</option>
							<option value="美国">
								美国
							</option>
							<option value="日本">
								日本
							</option>
							<option value="巴基斯坦">
								巴基斯坦
							</option>
							<option value="英国">
								英国
							</option>
							<option value="加拿大">
								加拿大
							</option>
						</select>
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
				</div>

				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						再输入证件号码：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="confPaperNumber">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						性别：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<select data-am-selected="{btnSize: 'sm'}" id="sex">
							<option>
								请选择
							</option>
							<option value="男">
								男
							</option>
							<option value="女">
								女
							</option>
						</select>
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						
					</div>
				</div>


				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						客户类型：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<select data-am-selected="{btnSize: 'sm'}" id="clientKinds">
							<option>
								请选择
							</option>
							<option value="一般用户">
								1 一般用户
							</option>
							<option value="企业用户">
								2 企业用户
							</option>
						</select>
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						客户分类：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<select data-am-selected="{btnSize: 'sm'}" id="Kinds">
							<option>
								请选择
							</option>
							<option value="贷款客户">
								1 贷款客户
							</option>
							<option value="储蓄客户">
								2 储蓄客户
							</option>
						</select>
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
				</div>



				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						中文名：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="chineseName">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						英文名：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="englishName">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
				</div>

				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						联系方式：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="phoneNumber">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						
					</div>
					<div class="am-u-sm-8 am-u-md-3"></div>
					<div class="am-hide-sm-only am-u-md-1">
						
					</div>
				</div>

				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						国家：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<select data-am-selected="{btnSize: 'sm'}" id="States">
							<option>
								
							</option>
							<option value="中国">
								中国
							</option>
							<option value="美国">
								美国
							</option>
							<option value="日本">
								日本
							</option>
							<option value="巴基斯坦">
								巴基斯坦
							</option>
							<option value="英国">
								英国
							</option>
							<option value="加拿大">
								加拿大
							</option>
						</select>
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						省份：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="province">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
				</div>



				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						城市：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="city">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						邮编：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="mail">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						
					</div>
				</div>



				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						地址信息：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="address">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						地区号码：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="addressNumber">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
					</div>
				</div>


				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						电话：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="callPhone">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
						*必填
					</div>
					<div class="am-u-sm-4 am-u-md-2 am-text-right">
						客户简称：
					</div>
					<div class="am-u-sm-8 am-u-md-3">
						<input type="text" class="am-input-sm" id="clientNick">
					</div>
					<div class="am-hide-sm-only am-u-md-1">
					</div>
				</div>
			</form>
			<div class="am-margin">
				<button type="button" onclick="check()"
					class="am-btn am-btn-primary am-btn-xs">
					点击这里提交保存
				</button>
			</div>
		</div>
</center>
	</body>
</html>
