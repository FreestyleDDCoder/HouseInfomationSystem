package servlet;

import com.alibaba.fastjson.JSON;
import entity.StationInformation;
import entity.jsonType.JsonTransportType;
import utils.ClientSocketHandle;
import utils.MQTTMessageHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by liangzhan on 18-3-19.
 * 这是处理站内消息推送的Servlet
 */
@WebServlet(name = "PushStationInformationServlet")
public class PushStationInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // 设置传递和接收的字符编码参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String pushMessage = request.getParameter("pushMessage");
        String adminId = (String) request.getSession().getAttribute("adminId");
        System.out.println("PushStationInformationServlet:pushMessage:" + pushMessage + "," + "adminId:" + adminId);
        //这里进行推送操作
        MQTTMessageHandle mqttMessageHandle = new MQTTMessageHandle();
        mqttMessageHandle.sendMessage("stationInformation", pushMessage);
        //然后把推送的消息记录到数据库对应的表格中
        // 配置 StationInformation实体属性
        StationInformation stationInformation = new StationInformation();
        stationInformation.setAdminId(adminId);
        stationInformation.setInformationContent(pushMessage);
        stationInformation.setPushTime(new Date());

        //配置传送属性
        String jsonString = JSON.toJSONString(new JsonTransportType(stationInformation, "", adminId, "pushStationInformation"));
        String result = new ClientSocketHandle().sendMessage(jsonString);

        PrintWriter writer = response.getWriter();
        if (result.equals("success")) {
            writer.println("<div class=" + "am-u-sm-centered" + ">消息推送成功！" + "</div>");
        } else {
            writer.println("<div class=" + "am-u-sm-centered" + ">消息推送失败！" + "</div>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
