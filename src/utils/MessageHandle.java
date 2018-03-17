package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dao.daoFactory.DaoFactory;
import dao.daoImpl.AdminLoginDaoImpl;
import entity.AdminLogin;
import entity.jsonType.JsonTransportType;

/**
 * Created by liangzhan on 18-3-16.
 * 这是消息队列消息处理的类
 */
public class MessageHandle {
    //处理该消息的方法
    public void handle(String message) {
        //这里进行解析处理
        System.out.println("handle:" + message);
        JsonTransportType jsonTransportType = (JsonTransportType) new JsonHandle().goParseJsonObject(message, JsonTransportType.class);
        String serviceName = jsonTransportType.getServiceName();
        //处理对应的业务
        if (serviceName.equals("AdminLogin")) {//管理员登录业务
            goAdminLogin(jsonTransportType);
        }
    }

    private void goAdminLogin(JsonTransportType jsonTransportType) {
        AdminLogin adminLogin = JSON.parseObject(jsonTransportType.getObject().toString(), AdminLogin.class);
        System.out.println("MessageHandle:AdminId:" + adminLogin.getAdminId());
        AdminLoginDaoImpl adminDaoImpl = DaoFactory.getAdminDaoImpl();
        AdminLogin adminMes = adminDaoImpl.findAdminMes(adminLogin.getAdminId());
        String adminLoginJson = new JsonHandle().toJson(new JsonTransportType(adminMes, "AdminLogin"));
        System.out.println("MessageHandle:MessageName and MessageID:" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(adminLoginJson, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }
}
