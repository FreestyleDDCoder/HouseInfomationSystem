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

/**
 * Created by liangzhan on 18-4-1.
 * 这是楼房类型删除的Servlet
 */
@WebServlet(name = "HouseKindsDeleteServlet")
public class HouseKindsDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // 设置传递和接收的字符编码参数
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String adminId = (String) request.getSession().getAttribute("adminId");
        String kindsId = request.getParameter("kindsId");
        HouseKinds houseKinds = new HouseKinds();
        houseKinds.setKindsId(kindsId);
        //发出获取请求
        String jsonString = JSON.toJSONString(new JsonTransportType(houseKinds, "", adminId, "houseKindsDelete"));
        String result = new ClientSocketHandle().sendMessage(jsonString);
        PrintWriter out = response.getWriter();
        if (result.equals("success")) {
            out.println("当前操作成功！");
        } else {
            out.println("当前操作失败！" + result);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
