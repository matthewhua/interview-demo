package episode3.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException{
        ServerSocket server =new ServerSocket(8923);
        System.out.println("服务端程序启动，等待连接");
        Socket s = server.accept(); //执行到此时，会进入到阻塞状态
        System.out.println("IP地址为"+s.getInetAddress().getHostAddress()+"客户端连接");
        //基于客户端对象获取客户端的输入流
        InputStream inputStream = s.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=inputStream.read(bytes))!=-1){ //接收客户端发送的数据
            String str = new String(bytes,0,len);
            System.out.println("客户端发送的数据为："+str);
        }
        inputStream.close();
        s.close();
        server.close();
    }
}
