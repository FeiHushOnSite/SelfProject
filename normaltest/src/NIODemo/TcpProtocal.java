package NIODemo;


import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 定义一个协议传输信息
 */
public class TcpProtocal {
    private int bufferSize = 1024;

    /**
     * 接受一个SocketChannel处理
     */
    public void handleAccept(SelectionKey key) throws Exception {
        //返回创建此键的通道，接收客户端建立连接的请求，并返回socketChannel对象
        SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
        //设置非阻塞
        clientChannel.configureBlocking(false);
        //注册到selector
        clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));

    }

    /**
     * 从一个一个SocketChannel读取信息
     */
    public void handleRead(SelectionKey key) throws Exception {
        //获得与客户端通信的通道
        SocketChannel clientChannel = (SocketChannel) key.channel();
        //得到并清空缓冲区并清空缓冲区
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        //读取信息获得的字节数
        int byteRead = clientChannel.read(buffer);
        if (byteRead == -1) {
            clientChannel.close();
        } else {
            //将缓冲区准备为数据传状态
            buffer.flip();
            //将字节转换为UTF-16
            String receivedStr = Charset.forName("UTF-8").newDecoder().decode(buffer).toString();
            System.out.println("接收到来自" + clientChannel.socket().getRemoteSocketAddress() + "信息" + receivedStr);
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            /*String sendStr ="已收到信息";
            buffer=ByteBuffer.wrap(sendStr.getBytes("UTF-8"));
            clientChannel.write(buffer);
            //设置为下依稀读取写入做准备
            key.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);*/
        }


    }

    /**
     * 向一个一个SocketChannel写入信息
     */
    public void handleWrite(SelectionKey key) throws Exception {
        handleWriteMsg(key, null);

    }

    /**
     * 向一个一个SocketChannel写入信息
     */
    public void handleWriteMsg(SelectionKey key, String msg) throws Exception {
        if (msg == null || "".equals(msg)) {
            msg = "服务器主动说：已收到建立请求消息";
        }
        //获得与客户端通信的通道
        SocketChannel clientChannel = (SocketChannel) key.channel();
        //得到并清空缓冲区并清空缓冲区
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        String sendStr = msg;
        buffer = ByteBuffer.wrap(sendStr.getBytes("UTF-8"));
        clientChannel.write(buffer);
        //设置为下依稀读取写入做准备
        key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);

    }
}
