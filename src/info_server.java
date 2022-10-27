
import javafx.util.Pair;

import java.io.IOException;

import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class info_server {
    private static final int port=8000;
    private HashMap<String, Pair<InetSocketAddress,Integer>> client_info;    //注册客户端信息

    info_server() throws IOException {
        client_info=new HashMap<>();
    }

    public boolean sign_up(String user,InetSocketAddress address, int port){        //注册时
    /*  Iterator<Map.Entry<String, InetSocketAddress>> iterator=client_info.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, InetSocketAddress> entry = iterator.next();
            if (entry.getKey()==user){
                System.out.println("注册失败，该用户名已被注册。");
                return false;
            }
        }
        client_info.put(user,address);
        System.out.println("注册成功。");
        return true;*/

        boolean occuad = client_info.containsValue(user);
        if (!occuad) {
            client_info.put(user,new Pair<InetSocketAddress,Integer>(address,port));
        }
        return occuad;



    }

    public boolean is_in_info(String user,InetSocketAddress address){       //登录判断该用户名和ip是否以被注册
   /*     Iterator<Map.Entry<String, InetSocketAddress>> iterator=client_info.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, InetSocketAddress> entry = iterator.next();
            if (entry.getKey()==user){
                if(entry.getValue()==address){
                    return true;
                }
            }
        }
        return false;*/


    }





    public void server()throws Exception{
        System.out.println("信息服务器已启动.....");
        DatagramSocket socket = new DatagramSocket(port);
        while(true){
            DatagramPacket request = new DatagramPacket(new byte[12], 12);
            socket.receive(request);



        }
    }




    public static void main(String[] args)throws IOException,Exception{
        new info_server().server();
    }
}
