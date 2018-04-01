<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="entity.Menu" %>
<%@page import="dao.daoImpl.MenuDaoImpl" %>
<%@ page import="dao.daoFactory.DaoFactory" %>
<%@ page import="entity.AdminLogin" %>
<%@ page import="entity.jsonType.JsonTransportType" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="utils.ClientSocketHandle" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>房地产楼盘信息系统管理界面</title>
    <meta name="description" content="这是一个form页面">
    <meta name="keywords" content="form">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${path}assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed"
          href="${path}assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${path}assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${path}assets/css/admin.css">

    <script type="text/javascript" src="${path}assets/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${path}assets/js/loginedpage.js"></script>
    <script type="text/javascript" src="${path}assets/js/myStyle.js"></script>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <strong>房地产公司楼盘信息系统管理端</strong>
        <small>管理界面</small>
    </div>
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <%
            String adminPermission = (String) request.getSession().getAttribute("adminPermission");
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setAdminPermission(adminPermission);
            String jsonString = JSON.toJSONString(new JsonTransportType(adminLogin, "", "", "menuList"));
            String result = new ClientSocketHandle().sendMessage(jsonString);
            JsonTransportType jsonTransportTypes = JSON.parseObject(result, JsonTransportType.class);
            List<Menu> rank1list = JSON.parseArray(jsonTransportTypes.getObject().toString(), Menu.class);
            List rank1 = new ArrayList();
            List rank2 = new ArrayList();
            String temp = "";
            MenuDaoImpl menuDaoImpl = DaoFactory.getMenuDaoImpl();
            for (Menu menu1 : rank1list) {
                String r1 = menu1.getRank1();
                if (!r1.equals(temp)) {
                    rank1.add(r1);
                    rank2.add(menuDaoImpl.finR2andUrl(r1));
                    temp = r1;
                }
            }
            session.setAttribute("rank1", rank1);
            session.setAttribute("rank2", rank2);
        %>
        <ul
                class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle
                   href="javascript:;"> <span class="am-icon-users"></span> <c:choose>
                    <c:when test="${adminPermission=='1'}">
                        <c:out value="管理员1"></c:out>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${adminPermission=='2'}">
                                <c:out value="管理员2"></c:out>
                            </c:when>
                            <c:otherwise>
                                <c:out value="管理员3"></c:out>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose> <span class="am-icon-caret-down"></span> </a>
                <ul class="am-dropdown-content">
                    <li>
                        <a href="#"><span class="am-icon-user"></span> 资料</a>
                    </li>
                    <li>
                        <a href="#"><span class="am-icon-cog"></span> 设置</a>
                    </li>
                    <li>
                        <a href="<%=path %>/index.jsp"><span class="am-icon-power-off"></span> 退出</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</header>
<div class="am-cf admin-main">
    <!-- sidebar start -->
    <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
        <div class="am-offcanvas-bar admin-offcanvas-bar">
            <ul class="am-list admin-sidebar-list">
                <li>
                    <a href="javascript:void(0)"
                       onclick="createXMLHttp('<%=path %>/includePage/FristPage.jsp','<%=path %>','')"><span
                            class="am-icon-home"></span> 首页</a>
                </li>
                <c:forEach var="r1" items="${sessionScope.rank1}"
                           varStatus="status1">
                <li>
                    <a href="#" class="inactive"><c:out value="${r1}"></c:out><span
                            class="am-icon-angle-right am-fr am-margin-right"></span> </a>
                    <c:forEach var="r2" items="${sessionScope.rank2}"
                               varStatus="status2">
                        <c:if test="${status1.index==status2.index}">
                            <c:forEach var="r3" items="${r2}">
                                <ul style="display: none">
                                    <li>
                                        <a href="javascript:void(0)"
                                           onclick="createXMLHttp('<%=path %>/${r3.rankUrl}','<%=path %>/','${r3.rank2}')"
                                           class="inactive active">
                                            <c:out value="${r3.rank2}"></c:out> </a><%--注意，js方法传入字符串时添加单引号！！！ --%>
                                    </li>
                                </ul>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </li>
                </c:forEach>
                <div class="am-panel am-panel-default admin-sidebar-panel">
                    <div class="am-panel-bd">
                        <p>
                            <span class="am-icon-bookmark"></span> 公告
                        </p>
                        <p>
                            时光静好，与君语；细水流年，与君同。
                        </p>
                    </div>
                </div>
        </div>
    </div>
    <!-- sidebar end -->

    <!-- content start 内容开始部分（右边栏）-->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding am-padding-bottom-0">
                <div class="am-fl am-cf">
                    <strong class="am-text-primary am-text-lg">欢迎进入房地产公司楼盘信息管理系统</strong>
                </div>
                <small id="form" class="am-text-primary am-text-lg"></small>
            </div>

            <hr>

            <div id="includePage">
                <jsp:include page="includePage/FristPage.jsp"/>
            </div>

        </div>

        <footer class="admin-content-footer">
            <hr>
            <p class="am-padding-left">
                © 2014 AllMobilize, Inc. Licensed under MIT license.
            </p>
        </footer>
    </div>
    <!-- content end -->

</div>

<a href="#"
   class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
   data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<footer>
    <hr>
    <p class="am-padding-left">
        © 2014 AllMobilize, Inc. Licensed under MIT license.
    </p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${path}assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="${path}assets/js/amazeui.min.js"></script>
<script src="${path}assets/js/app.js"></script>
</body>
</html>

