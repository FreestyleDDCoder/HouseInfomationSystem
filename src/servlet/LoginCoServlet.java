package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.AdminLogin;
import entity.jsonType.JsonTransportType;
import utils.ClientSocketHandle;
import utils.JsonHandle;

public class LoginCoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);//因为提交的是post
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置文本类型
        response.setContentType("text/html");
        //设置传递和接收参数的编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 账号&密码
        String adminId = request.getParameter("adminId");
        String adminPassword = request.getParameter("adminPassword");
        System.out.println(adminId + adminPassword);
        if (!adminId.isEmpty() && !adminPassword.isEmpty()) {
            //这里向服务器发送Socket
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setAdminId(adminId);
            JsonTransportType jsonTransportType = new JsonTransportType(adminLogin, null, adminId, "AdminLogin");
            JsonHandle jsonHandle = new JsonHandle();
            String message = jsonHandle.toJson(jsonTransportType);
            String result = new ClientSocketHandle().sendMessage(message);
            //由上向下强转不安全，无法得到具体类
            JsonTransportType attResult = (JsonTransportType) jsonHandle.goParseJsonObject(result, JsonTransportType.class);
            AdminLogin adminLogin1 = (AdminLogin) jsonHandle.goParseJsonObject(attResult.getObject().toString(), AdminLogin.class);
            System.out.println("adminLogin getUserpassword()" + adminLogin1.getAdminPassword());

            if (adminLogin1.getAdminPassword().equals(adminPassword)) {
                //登录成功
                // 登录成功的操作;接着进行判断账号权限，进入相应的界面
                String adminPermission = adminLogin1.getAdminPermission();
                System.out.println("登录成功!");
                request.getSession().setAttribute("adminId", adminId);
                request.getSession().setAttribute("adminPermission", adminPermission);
                //resp.sendRedirect("../LoginedPage.jsp");
                //登录成功后需要对签到表进行登记（后面有需求则进行添加或者直接在loginCheakImpl中实现）
                request.getRequestDispatcher("../LoginedPage.jsp").forward(request, response);
            } else {
                // 密码有误
                request.getRequestDispatcher("../index.jsp?result=" + "密码有误！").forward(request, response);
            }
        } else {
            // 如果账号密码或者网点号为空，返回
            System.out.println("账号密码为空");
            request.getRequestDispatcher("../index.jsp?result=" + "账号或密码不能为空！").forward(request, response);
        }
    }
}
