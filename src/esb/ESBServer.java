package esb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liangzhan on 18-3-16.
 * esb服务，用于设置socket‘连接
 */
public class ESBServer {
    private int port = 8888;//定义socket的端口
    private ServerSocket serverSocket = null;

    public ESBServer() {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("start ESBServer!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //启动监听
    public void esbServerListener() {
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            try {
                //Socket是阻塞机制
                Socket socket = serverSocket.accept();
                System.out.println("accept serverSocket!");
                //把socket交给多线程处理，然后接着监听（这里采用的是线程池）...
                executorService.submit(new ESBListener(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
