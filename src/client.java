import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class client {
    /*图形化界面类
    *
    *
    *
    * */
    private HashMap<String, Pair<InetAddress,Integer>> client_map;   //在线客户端信息(?)
    private String personal_user;           //当前客户端名
    private InetAddress personal_ip_address;      //当前客户端IP地址
    private int personal_port;
    private InetAddress server_ip_address;
    private final int server_port=8000;
    client(byte[] addr) throws UnknownHostException {                                //addr为服务器端ip地址
        client_map=new HashMap<String,Pair<InetAddress,Integer>>();
        server_ip_address=InetAddress.getByAddress(addr);
    }


    private void send_login_info(DatagramSocket socket)throws IOException{                     //向服务器发送登录\注册信息
        String ttt="用户名+ip地址";
        byte[] msg= ttt.getBytes(StandardCharsets.UTF_8);
        DatagramPacket dp_post=new DatagramPacket(msg, msg.length,server_ip_address,8000);
        socket.send(dp_post);


    }

    private void send_check_info(DatagramSocket socket,String aim_user) throws IOException {                    //向服务器发送确认其他client消息
        byte[] msg=aim_user.getBytes(StandardCharsets.UTF_8);
        DatagramPacket dp_post=new DatagramPacket(msg, msg.length,server_ip_address,8000);
        socket.send(dp_post);
    }

    private void get_check_info(DatagramSocket socket) throws IOException {                      //得到并解析服务器传回的clien信息
        DatagramPacket dp_get=new DatagramPacket(new byte[1024],1024);
        socket.receive(dp_get);



    }



    private void chatting(DatagramSocket socket)throws IOException{                                //聊天ing
        DatagramPacket dp_get=new DatagramPacket(new byte[1024],1024);
        socket.receive(dp_get);
        /*解析得到的数据包并且显示在界面上
        *
        *
        *
        * */
        //发送
        InetAddress aim_ip=dp_get.getAddress();
        int aim_port=dp_get.getPort();


       /* 得到要发送的消息并转化成byte[]数组*/
        String ttt="testing..";
        byte[] msg=ttt.getBytes(StandardCharsets.UTF_8);


        DatagramPacket dp_post=new DatagramPacket(msg, msg.length,aim_ip,aim_port);

        socket.send(dp_post);

    }

    public void client_running() throws IOException{
        System.out.println("客户端以启动。。。");
        DatagramSocket socket=new DatagramSocket(0);
        socket.setSoTimeout(4000);
        this.personal_ip_address=socket.getInetAddress();
        this.personal_port=socket.getPort();

    }
}
