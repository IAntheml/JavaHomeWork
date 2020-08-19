import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @ClassName AdvertisementSend
 * @Description 发送Advertisement报文
 * @Author smb_llh
 * @Date 2020/8/19 22:49
 * @Version 1.0
 */
public class AdvertisementSend {

    /*
    *@author smb_llh
    *@Description  发送Advertisement报文的方法
    *@Date 22:50 2020/8/19
    *@Param [data] 报文字节数组
    *@return void
    **/
    public void sendAdvertisement(DatagramChannel datagramChannel, SocketAddress socketAddress,byte[] data){
        //创建ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
        byteBuffer.put(data).flip();
        try {
            datagramChannel.send(byteBuffer,socketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
