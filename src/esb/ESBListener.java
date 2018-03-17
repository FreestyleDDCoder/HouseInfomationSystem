package esb;

import entity.jsonType.JsonTransportType;
import utils.AMQPMessageHandle;
import utils.JsonHandle;

import java.io.*;
import java.net.Socket;

/**
 * Created by liangzhan on 18-3-16.
 * 这是对服务器socket连接的监听
 */
public class ESBListener implements Runnable {
    private Socket socket;

    public ESBListener(Socket socket) {
        this.socket = socket;
    }

    //进行块处理
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8")), true);
            //客户端发来的数据
            String readLine = br.readLine();
            AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
            amqpMessageHandle.sendMessage(readLine, "ESBTOCORE", "", "");
            System.out.println("ESBListener:Success put message to queue \"ESBTOCORE\":" + readLine);
            //取出的信息messageName和messageId定义为userID和对应编号
            JsonTransportType jsonTransportType = (JsonTransportType) new JsonHandle().goParseJsonObject(readLine, JsonTransportType.class);
            String receiveMessage = amqpMessageHandle.receiveMessage("CORETOESB", jsonTransportType.getMessageName(), jsonTransportType.getMessageId());
            System.out.println("ESBListener:Success get message from queue \"CORETOESB\":" + receiveMessage);
            pw.println(receiveMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
