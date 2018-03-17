package core;

import utils.AMQPMessageHandle;
import utils.MessageHandle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liangzhan on 18-3-16.
 * 这是核心端，与数据库挂勾
 */
public class CoreServer {
    //这是核心监听
    public void coreListener() {
        AMQPMessageHandle amqpMessageHandle = new AMQPMessageHandle();
        //创建无线大小线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            //阻塞机制
            String receiveMessage = amqpMessageHandle.receiveMessage("ESBTOCORE", "", "");
            System.out.println("CoreServer:Success get message from queue \"ESBTOCORE\":" + receiveMessage);
            //这里把ESBTOCORE的消息取出来，交由子线程处理,然后接着监听消息队列ESBTOCORE的消息
            executorService.submit(() -> new MessageHandle().handle(receiveMessage));
        }
    }
}
