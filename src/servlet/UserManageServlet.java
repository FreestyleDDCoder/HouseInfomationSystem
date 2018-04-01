package servlet;

import com.alibaba.fastjson.JSON;
import entity.UserInformation;
import entity.jsonType.JsonTransportType;
import utils.ClientSocketHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by liangzhan on 18-3-30.
 * 这是用户管理Servlet
 */
@WebServlet(name = "UserManageServlet")
public class UserManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // 设置传递和接收的字符编码参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String userId = request.getParameter("userId");
        String queryType = request.getParameter("queryType");
        String adminId = (String) request.getSession().getAttribute("adminId");
        System.out.println("UserManageServlet:userId=" + userId + ",queryType=" + queryType);
        //ajax响应相应的HTML页面
        PrintWriter out = response.getWriter();
        out.println("<div class=\"am-g\">");
        out.println("<div class=\"am-u-sm-12\">");
        out.println(" <form class=\"am-form\">");
        out.println("<table class=\"am-table am-table-striped am-table-hover table-main\">");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th class=\"table-title\">编号</th><th class=\"table-title\">帐号</th><th class=\"table-author am-hide-sm-only\">邮箱</th><th class=\"table-title\">性别</th><th class=\"table-title\">个性签名</th><th class=\"table-title\">VIP</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        if (queryType.equals("1")) {//只是查询单个用户的界面
            UserInformation userInformation = new UserInformation();
            userInformation.setUserId(userId);
            String jsonString = JSON.toJSONString(new JsonTransportType(userInformation, "", adminId, "getUserInformation"));
            String result = new ClientSocketHandle().sendMessage(jsonString);
            UserInformation userInformation1 = JSON.parseObject(result, UserInformation.class);
            System.out.println("UserManageServlet result" + result);
            if (result == null | result.equals("")) {
                out.println("没有查询到ID号为：" + userId + "的用户，请核对后再进行本操作！");
            } else {
                out.println("<tr>");
                out.println("<td>" + "1" + "</td>");
                out.println("<td>" + userInformation1.getUserId() + "</td>");
                out.println("<td>" + userInformation1.getUserMail() + "</td>");
                if (userInformation1.getUserSex().equals("m")) {
                    out.println("<td>" + "男" + "</td>");
                } else {
                    out.println("<td>" + "女" + "</td>");
                }
                out.println("<td>" + userInformation1.getUserMotto() + "</td>");
                out.println("<td>" + userInformation1.getUserVip() + "</td>");
                out.println("</tr>");
            }
        } else if (queryType.equals("2")) {//查询所有用户的界面
            String jsonString = JSON.toJSONString(new JsonTransportType(null, "", adminId, "getUserInformations"));
            String result = new ClientSocketHandle().sendMessage(jsonString);
            List<UserInformation> userInformations = JSON.parseArray(result, UserInformation.class);
            int i = 1;
            for (UserInformation uin : userInformations) {
                out.println("<tr>");
                out.println("<td>" + i + "</td>");
                out.println("<td>" + uin.getUserId() + "</td>");
                out.println("<td>" + uin.getUserMail() + "</td>");
                if (uin.getUserSex().equals("m")) {
                    out.println("<td>" + "男" + "</td>");
                } else {
                    out.println("<td>" + "女" + "</td>");
                }
                out.println("<td>" + uin.getUserMotto() + "</td>");
                out.println("<td>" + uin.getUserVip() + "</td>");
                out.println("</tr>");
                i++;
            }
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("</form >");
        out.println("</div >");
        out.println(" </div >");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
