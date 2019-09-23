package NIODemo;


import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TcpClientReadThread implements Runnable {
    private Selector selector;

    public TcpClientReadThread(Selector selector) {
        this.selector = selector;
        new Thread(this).start();
    }

    public void run() {
        try {
            //select()方法只能使用一次，用过之后就会删除，每个连接到服务器的选择器都是独立的
            while (selector.select() > 0) {
                //遍历所有可以IO操作做的Channel对应的selectionKey
                for (SelectionKey sk : selector.selectedKeys()) {
                    //如果数据可读
                    if (sk.isReadable()) {
                        //使用NIO读取Channel中可读数据
                        //获取通道信息
                        SocketChannel sc = (SocketChannel) sk.channel();
                        //创建缓冲区
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //读取数据到缓冲区
                        sc.read(buffer);
                        //吊用此方法为读取写入做准备
                        buffer.flip();

                        String receiveStr = Charset.forName("UTF-8").newDecoder().decode(buffer).toString();
                        System.out.println("收到服务器" + sc.socket().getRemoteSocketAddress() + "信息" + receiveStr);
                        //为下一次读取做准备
                        sk.interestOps(SelectionKey.OP_READ);
                        //删除正在处理的selectionKey
                        selector.selectedKeys().remove(sk);


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
