package servlet;

import com.alibaba.fastjson.JSON;
import dao.daoFactory.DaoFactory;
import entity.StationInformation;
import entity.jsonType.JsonTransportType;
import utils.ClientSocketHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by liangzhan on 18-3-20.
 * 这是执行获取站内推送消息的Servlet
 */
@WebServlet(name = "GetStationInformationServlet")
public class GetStationInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // 设置传递和接收的字符编码参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String adminId = (String) request.getSession().getAttribute("adminId");
        //发出获取请求
        String jsonString = JSON.toJSONString(new JsonTransportType(null, "", adminId, "getStationInformation"));
        String result = new ClientSocketHandle().sendMessage(jsonString);
        List<StationInformation> stationInformations = JSON.parseArray(result, StationInformation.class);
        PrintWriter out = response.getWriter();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //先输出顶端的标题包含消息编号，管理员ID，消息内容，发布时间
        out.println("<div class=\"am-g\">");
        out.println("<div class=\"am-u-sm-12\">");
        out.println(" <form class=\"am-form\">");
        out.println("<table class=\"am-table am-table-striped am-table-hover table-main\">");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th class=\"table-title\">编号</th><th class=\"table-author am-hide-sm-only\">管理员ID</th><th class=\"table-date am-hide-sm-only\">发布时间</th><th class=\"table-title\">发布内容</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        int i = 1;
        for (StationInformation stationInformation : stationInformations) {
            System.out.println("GetStationInformationServlet：stationInformation" + stationInformation.getAdminId() + " " + stationInformation.getInformationContent() + " " + stationInformation.getPushTime());
            //打印出传回的数据(以具体的页面显示)
            //out.println("管理员：" + stationInformation.getAdminId() + "," + "推送的消息：" + stationInformation.getInformationContent() + "," + "推送的时间：" + simpleDateFormat.format(stationInformation.getPushTime()));
            out.println("<tr>");
            out.println("<td>" + i + "</td>");
            out.println("<td>" + stationInformation.getAdminId() + "</td>");
            out.println("<td>" + simpleDateFormat.format(stationInformation.getPushTime()) + "</td>");
            out.println("<td>" + stationInformation.getInformationContent() + "</td>");
            out.println("</tr>");
            i++;
        }

        out.println("</tbody>");
        out.println("</table>");
        out.println("<div class=\"am-cf\">");
        out.println("共" + stationInformations.size() + "条记录");
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
