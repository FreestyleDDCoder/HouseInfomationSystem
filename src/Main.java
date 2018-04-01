import core.CoreServer;
import dao.daoFactory.DaoFactory;
import dao.daoImpl.UserInformationImpl;
import entity.UserInformation;
import esb.ESBServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liangzhan on 18-3-12.
 * 这是主类，用于启动和加载服务
 */
public class Main {
    public static void main(String args[]) {
        //启动core监听和ESB监听
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> new CoreServer().coreListener());
        executorService.submit(() -> new ESBServer().esbServerListener());
        System.out.println("Success start CoreServer and ESBServer");

////测试menudao
//        for (Menu m : DaoFactory.getMenuDaoImpl().findRank1Menus("1")) {
//            System.out.println("MenuDaoImpl Rank1:" + m.getRank1());
//            for (Menu m1 : DaoFactory.getMenuDaoImpl().finR2andUrl(m.getRank1())) {
//                System.out.println("MenuDaoImpl Rank2 and url:" + m1.getRank2() + "   " + m1.getRankUrl());
//            }
//        }

//        //测试Json工具类
//        AdminLogin admin1 = new AdminLogin();
//        admin1.setAdminId("我是管理员1");
//        admin1.setAdminPassword("我是密码1");
//        admin1.setAdminPermission("我是权限1");
//        AdminLogin admin2 = new AdminLogin();
//        admin2.setAdminId("我是管理员2");
//        admin2.setAdminPassword("我是密码2");
//        admin2.setAdminPermission("我是权限2");
//        List<AdminLogin> admins = new ArrayList<>();
//        admins.add(admin1);
//        admins.add(admin2);
//        JsonHandle jsonHandle = new JsonHandle();
//        String s = jsonHandle.toJson(admin1);
//        System.out.println("Object to JsonString:" + s);
//        AdminLogin o = (AdminLogin) jsonHandle.goParseJsonObject(s, AdminLogin.class);
//        System.out.println("JsonString to Object:" + o.getAdminId() + ";" + o.getAdminPassword() + ";" + o.getAdminPermission());
//        String s1 = jsonHandle.toJson(admins);
//        System.out.println("List to JsonString:" + s1);

//        List list = jsonHandle.goParseJsonArray(s1, AdminLogin.class);
//        AdminLogin o1 = (AdminLogin) list.get(0);
//        System.out.println("JsonString to List:" + o1.getAdminId() + ";" + o1.getAdminPassword() + ";" + o1.getAdminPermission());
//        AdminLogin o2 = (AdminLogin) list.get(1);
//        System.out.println("JsonString to List:" + o2.getAdminId() + ";" + o2.getAdminPassword() + ";" + o2.getAdminPermission());
        //测试分块
//        AdminLogin adminLogin = new AdminLogin();
//        adminLogin.setAdminId("001");
//        adminLogin.setAdminPermission("002");
//        adminLogin.setAdminPassword("003");
//        JsonTest jsonTest = new JsonTest();
//        jsonTest.setAge(18);
//        jsonTest.setName("jsonTest");
//        jsonTest.setObject(adminLogin);
//        JsonHandle jsonHandle = new JsonHandle();
//        String s2 = jsonHandle.toJson(jsonTest);
//        System.out.println("jsonTest to JsonString:" + s2);
//        JsonTest jsonTest1 = (JsonTest) jsonHandle.goParseJsonObject(s2, JsonTest.class);
//        System.out.println(" jsonTest1.getObject().toString():" +  jsonTest1.getObject().toString());
//        AdminLogin adminLogin1 = (AdminLogin) jsonHandle.goParseJsonObject(jsonTest1.getObject().toString(), AdminLogin.class);
//        System.out.println("JsonString to jsonTest:" + jsonTest1.getName() + ";" +adminLogin1.getAdminId()+"   "+adminLogin1.getAdminPermission()+" "+adminLogin1.getAdminPassword());

        //测试amqp和mqtt协议
        //amqp
//        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
//        amqpMessageHandle.sendMessage("这是我发送的amqp信息1","ESBTOCORE","","");
//        while (true){
//            amqpMessageHandle.receiveMessage("ESBTOCORE","","");
//            amqpMessageHandle.sendMessage("这是我发送的amqp信息2","ESBTOCORE","","");
//        }


        //mqtt
//        MQTTMessageHandle mqttMessageHandle = new MQTTMessageHandle();
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                    mqttMessageHandle.receiveMessage("zhanneixiaoxi");
//                    System.out.println("测试循环次数");
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                    mqttMessageHandle.receiveMessage("zhanneixiaoxi");
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                    mqttMessageHandle.receiveMessage("zhanneixiaoxi");
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                    mqttMessageHandle.receiveMessage("zhanneixiaoxi");
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                for (int i = 0; i < 10; i++) {
//                    mqttMessageHandle.sendMessage("zhanneixiaoxi", "这是我发布的mqtt主题" + i);
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//        //测试数据库连接
//        Connection connect = MysqlConnect.getConnect();
//        try {
//            Statement statement = connect.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM `Student`");
//            if (resultSet != null) {
//                while (resultSet.next()) {
//                    String string1 = resultSet.getString(1);
//                    String string2 = resultSet.getString(2);
//                    String string3 = resultSet.getString(3);
//                    String string4 = resultSet.getString(4);
//                    System.out.println(string1+"   "+string2+"    "+string3+"   "+string4);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
