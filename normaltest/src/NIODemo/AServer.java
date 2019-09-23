package NIODemo;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * NIO服务端代码
 *
 * @author http://
 * @author ZX
 * 监听客户端连接，接收、发送消息
 */
public class AServer {
    public static void main(String[] args) throws Exception {
        System.out.println("=================");
        //创建选择器
        Selector selector = Selector.open();
        //创建打开服务端的监听
        ServerSocketChannel sChannel = ServerSocketChannel.open();
        //绑定本地地址
        sChannel.socket().bind(new InetSocketAddress(9999));
        //设置非阻塞模式
        sChannel.configureBlocking(false);
        //将通道绑定到选择器，非阻塞通道才能注册到选择器,第二个参数好像是方式或者操作吧
        sChannel.register(selector, SelectionKey.OP_ACCEPT);

        TcpProtocal protocol = new TcpProtocal();
        //循环监听等待
        while (true) {
            //
            if (selector.select(3000) == 0) {
                System.out.println("继续等待");
                continue;
            }
            //间听到的可操作集合
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            while (keyIter.hasNext()) {
                SelectionKey key = keyIter.next();
                //这是干嘛的？获取下下个？一点用没有啊？？？
                /*  SelectionKey key1;
                if(keyIter.hasNext()){
                    key1 = keyIter.next();
                }*/
                try {
                    //如果有客户端连接请求
                    if (key.isAcceptable()) {
                        protocol.handleAccept(key);
                    }
                    //如果有数据发送
                    if (key.isReadable()) {
                        protocol.handleRead(key);
                        protocol.handleWrite(key);
                    }
                    //是否有效，是否可发送给客户端
                    if (key.isValid() && key.isWritable()) {
                        //protocol.handleWriteMsg(key,"我服务端在这里说点事情");
                    }
                } catch (IOException e) {
                    keyIter.remove();
                    e.printStackTrace();
                    continue;
                }
                //删除处理过的键
                keyIter.remove();


            }

        }

    }
}