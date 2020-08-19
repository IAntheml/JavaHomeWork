import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @ClassName ChannelTest
 * @Description TODO
 * @Author 世界很美好
 * @Date 2020/8/19 21:28
 * @Version 1.0
 */
public class ChannelTest {

    public static void main(String[] args) {
//        SocketChannel socketChannel;
//        ServerSocketChannel serverSocketChannel;
//        try {
//            DatagramChannel datagramChannel = DatagramChannel.open();
//            datagramChannel.configureBlocking(false);
//            Object blockingLock = datagramChannel.blockingLock();
//
//            serverSocketChannel = ServerSocketChannel.open();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        DatagramChannel datagramChannel = null;
        try {
            datagramChannel = DatagramChannel.open();
            datagramChannel.bind(new InetSocketAddress(5051));
            ByteBuffer receivedData = ByteBuffer.allocate(2048);
            SocketAddress remoteSocketAddress = datagramChannel.receive(receivedData);
            if (remoteSocketAddress != null){
                receivedData.flip();
                while(receivedData.hasRemaining()){
                    short type = receivedData.getShort();
                    short length = receivedData.getShort();
                    int anInt = receivedData.getInt();
                    ByteBuffer byteBuffer = receivedData.get(new byte[8]);
                    byte b = receivedData.get(receivedData.position());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
