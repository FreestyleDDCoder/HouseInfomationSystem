package servlet;

import com.alibaba.fastjson.JSON;
import entity.HouseKinds;
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
 * Created by liangzhan on 18-4-1.
 * 这是楼房类型查询的Servlet
 */
@WebServlet(name = "HouseKindsQueryServlet")
public class HouseKindsQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // 设置传递和接收的字符编码参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String adminId = (String) request.getSession().getAttribute("adminId");
        String jsonString = JSON.toJSONString(new JsonTransportType(null, "", adminId, "houseKindsQuery"));
        String result = new ClientSocketHandle().sendMessage(jsonString);
        PrintWriter out = response.getWriter();
        //先输出顶端的标题包含消息编号，管理员ID，消息内容，发布时间
        out.println("<div class=\"am-g\">");
        out.println("<div class=\"am-u-sm-12\">");
        out.println(" <form class=\"am-form\">");
        out.println("<table class=\"am-table am-table-striped am-table-hover table-main\">");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th class=\"table-title\">编号</th><th class=\"table-author am-hide-sm-only\">楼盘类型ID</th><th class=\"table-title\">楼盘类型</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        int i = 1;
        List<HouseKinds> houseKinds = JSON.parseArray(result, HouseKinds.class);
        for (HouseKinds hks : houseKinds) {
            out.println("<tr>");
            out.println("<td>" + i + "</td>");
            out.println("<td>" + hks.getKindsId() + "</td>");
            out.println("<td>" + hks.getHouseKinds() + "</td>");
            out.println("</tr>");
            i++;
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<div class=\"am-cf\">");
        out.println("共" + houseKinds.size() + "条记录");
        out.println("</div >");
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
