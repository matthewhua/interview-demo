package episode3.websocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
    /**
     * TCP客户端
     * @param args
     * @throws UnknownHostException
     * @throws IOException
     */
    public static void main(String[] args) throws UnknownHostException,IOException{
        Socket client = new Socket("192.168.1.5", 8923);

        //基于客户端对象，获取客户端的输出流对象
        OutputStream out = client.getOutputStream();
        out.write("💊酱死了吗ma".getBytes());

        out.close();
        client.close();
    }
}
