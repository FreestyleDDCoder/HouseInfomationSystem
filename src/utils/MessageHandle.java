package utils;

import com.alibaba.fastjson.JSON;
import dao.daoFactory.DaoFactory;
import dao.daoImpl.AdminLoginDaoImpl;
import dao.daoImpl.HouseKindsImpl;
import dao.daoImpl.MenuDaoImpl;
import dao.daoImpl.UserInformationImpl;
import entity.AdminLogin;
import entity.Menu;
import entity.StationInformation;
import entity.UserInformation;
import entity.HouseKinds;
import entity.jsonType.JsonTransportType;

import java.text.SimpleDateFormat;
import java.util.List;

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
        System.out.println("serviceName:" + serviceName);
        //处理对应的业务
        if (serviceName.equals("AdminLogin")) {//管理员登录业务
            goAdminLogin(jsonTransportType);
        }
        if (serviceName.equals("menuList")) {//获取菜单
            goMenuList(jsonTransportType);
        }
        if (serviceName.equals("pushStationInformation")) {//站内消息推送业务
            goPushMessage(jsonTransportType);
        }
        if (serviceName.equals("getStationInformation")) {//获取站内消息业务
            goGetMessage(jsonTransportType);
        }
        if (serviceName.equals("getUserInformation")) {//获取单个用户信息业务
            goGetUserInformation(jsonTransportType);
        }
        if (serviceName.equals("getUserInformations")) {//获取所有用户信息业务
            goGetUserInformations(jsonTransportType);
        }
        if (serviceName.equals("userDelete")) {//站内消息推送业务
            goUserDelete(jsonTransportType);
        }
        if (serviceName.equals("houseKindsDelete")) {//楼房类型删除业务
            goHouseKindsDelete(jsonTransportType);
        }
        if (serviceName.equals("houseKindsUpdate")) {//楼房类型修改业务
            goHouseKindsUpdate(jsonTransportType);
        }
        if (serviceName.equals("houseKindsAdd")) {//楼房类型增加业务
            goHouseKindsAdd(jsonTransportType);
        }
        if (serviceName.equals("houseKindsQuery")) {//楼房类型查询业务
            goHouseKindsQuery(jsonTransportType);
        }
    }
    /**
     * 查询楼房类型信息
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goHouseKindsQuery(JsonTransportType jsonTransportType) {
        HouseKindsImpl houseKindsImpl = DaoFactory.getHouseKindsImpl();
        List<HouseKinds> houseKinds = houseKindsImpl.housekindsQuery();
        String result = JSON.toJSONString(houseKinds);
        //返回执行成功消息
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(result, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }

    /**
     * 添加楼房类型
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goHouseKindsAdd(JsonTransportType jsonTransportType) {
        HouseKinds houseKinds = JSON.parseObject(jsonTransportType.getObject().toString(), HouseKinds.class);
        HouseKindsImpl houseKindsImpl = DaoFactory.getHouseKindsImpl();
        String result = houseKindsImpl.housekindsAdd(houseKinds.getKindsId(), houseKinds.getHouseKinds());
        //返回执行成功消息
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(result, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }

    /**
     * 更新该楼房类型
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goHouseKindsUpdate(JsonTransportType jsonTransportType) {
        HouseKinds houseKinds = JSON.parseObject(jsonTransportType.getObject().toString(), HouseKinds.class);
        HouseKindsImpl houseKindsImpl = DaoFactory.getHouseKindsImpl();
        String result = houseKindsImpl.housekindsUpdate(houseKinds.getKindsId(), houseKinds.getHouseKinds());
        //返回执行成功消息
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(result, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }

    /**
     * 删除该楼房类型
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goHouseKindsDelete(JsonTransportType jsonTransportType) {
        HouseKinds houseKinds = JSON.parseObject(jsonTransportType.getObject().toString(), HouseKinds.class);
        String kindsId = houseKinds.getKindsId();
        HouseKindsImpl houseKindsImpl = DaoFactory.getHouseKindsImpl();
        String result = houseKindsImpl.houseKindsDeleteById(kindsId);
        //返回执行成功消息
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(result, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }

    /**
     * 删除该用户所有信息
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goUserDelete(JsonTransportType jsonTransportType) {
        UserInformation userInformation = JSON.parseObject(jsonTransportType.getObject().toString(), UserInformation.class);
        String userId = userInformation.getUserId();
        UserInformationImpl userInformationImpl = DaoFactory.getUserInformationImpl();
        String result = userInformationImpl.deleteUserInformationById(userId);
        //返回执行成功消息
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(result, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }

    /**
     * 查询单个用户信息的方法块
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goGetUserInformation(JsonTransportType jsonTransportType) {
        UserInformation userInformation = JSON.parseObject(jsonTransportType.getObject().toString(), UserInformation.class);
        UserInformationImpl userInformationImpl = DaoFactory.getUserInformationImpl();
        UserInformation userInformationById = userInformationImpl.getUserInformationById(userInformation.getUserId());
        String result = JSON.toJSONString(userInformationById);
        //返回执行成功消息
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(result, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }

    /**
     * 查询所有用户信息的方法块
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goGetUserInformations(JsonTransportType jsonTransportType) {
        UserInformationImpl userInformationImpl = DaoFactory.getUserInformationImpl();
        List<UserInformation> userInformations = userInformationImpl.getUserInformations();
        String result = JSON.toJSONString(userInformations);
        //返回执行成功消息
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(result, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }

    /**
     * 查询站内消息方法块
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goGetMessage(JsonTransportType jsonTransportType) {
        List<StationInformation> stationInformation = DaoFactory.getStationInformationImpl().getStationInformation();
        String result = JSON.toJSONString(stationInformation);
        //返回执行成功消息
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(result, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }

    /**
     * 站内消息推送处理方法块
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goPushMessage(JsonTransportType jsonTransportType) {
        StationInformation stationInformation = JSON.parseObject(jsonTransportType.getObject().toString(), StationInformation.class);
        System.out.println("MessageHandle:stationInformation:" + stationInformation.getAdminId() + "," + stationInformation.getInformationContent() + "," + stationInformation
                .getPushTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = simpleDateFormat.format(stationInformation.getPushTime());
        String result = DaoFactory.getStationInformationImpl().RmpushMessage(stationInformation.getAdminId(), stationInformation.getInformationContent(), dateTime);
        //返回执行成功消息
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(result, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());

    }

    /**
     * 处理菜单信息的方法
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goMenuList(JsonTransportType jsonTransportType) {
        AdminLogin adminLogin = JSON.parseObject(jsonTransportType.getObject().toString(), AdminLogin.class);
        System.out.println("MessageHandle:getAdminPermission:" + adminLogin.getAdminPermission());
        MenuDaoImpl menuDaoImpl = DaoFactory.getMenuDaoImpl();
        List<Menu> rank1list = menuDaoImpl.findRank1Menus(adminLogin.getAdminPermission());
        String jsonString = JSON.toJSONString(new JsonTransportType(rank1list, "", "", "menuList"));
        System.out.println("MessageHandle:MessageName and MessageID:" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(jsonString, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }

    /**
     * 处理管理员登录的方法
     *
     * @param jsonTransportType 处理的消息类型
     */
    private void goAdminLogin(JsonTransportType jsonTransportType) {
        AdminLogin adminLogin = JSON.parseObject(jsonTransportType.getObject().toString(), AdminLogin.class);
        System.out.println("MessageHandle:AdminId:" + adminLogin.getAdminId());
        AdminLoginDaoImpl adminDaoImpl = DaoFactory.getAdminDaoImpl();
        AdminLogin adminMes = adminDaoImpl.findAdminMes(adminLogin.getAdminId());
        String adminLoginJson = new JsonHandle().toJson(new JsonTransportType(adminMes, "", "", "AdminLogin"));
        System.out.println("MessageHandle:MessageName and MessageID:" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        amqpMessageHandle.sendMessage(adminLoginJson, "CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
        System.out.println("MessageHandle:Success put message to queue \"CORETOESB\":" + jsonTransportType.getMessageName() + "   " + jsonTransportType.getMessageId());
    }
}
