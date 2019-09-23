package NIODemo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class AClient {

    private Selector selector;
    private SocketChannel socketChannel;

    private String hostIp;
    private int hostPort;

    public AClient(String hostIp, int hostPort) throws Exception {
        this.hostIp = hostIp;
        this.hostPort = hostPort;
        init();

    }

    public void init() throws Exception {
        socketChannel = SocketChannel.open(new InetSocketAddress(hostIp, hostPort));
        socketChannel.configureBlocking(false);
        //打开并注册选择器信道、
        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_READ);
        //启动读取线程
        new TcpClientReadThread(selector);


    }

    /**
     * 发送字符串到服务器
     */
    public void sendMsg(String msgg) throws Exception {
        ByteBuffer writeBuffer = ByteBuffer.wrap(msgg.getBytes("UTF-8"));
        socketChannel.write(writeBuffer);
    }

    static AClient aClient;
    static boolean mFlag = true;

    public static void main(String[] args) throws Exception {
        aClient = new AClient("127.0.0.1", 9999);


        new Thread() {
            @Override
            public void run() {
                try {
                    aClient.sendMsg("客户端======");
                    while (mFlag) {
                        Scanner sc = new Scanner(System.in);
                        String next = sc.next();
                        aClient.sendMsg(next);
                    }
                } catch (Exception e) {
                    mFlag = false;
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
