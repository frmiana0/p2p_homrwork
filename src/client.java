import javafx.util.Pair;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.HashMap;

public class client {
    /*图形化界面类
    *
    *
    *
    * */
    private HashMap<String, Pair<InetSocketAddress,Integer>> online_client;   //在线客户端信息(?)
    client(){


    }


    private void send_login_info(){                     //向服务器发送登录信息

    }

    private void send_signup_info(){                    //向服务器发送注册信息

    }

    private void up_date_online_info(){                 //刷新在线客户端信息类

    }

    private void chat_request(){                        //发送聊天请求

    }

    private void chat_response(){                        //回应聊天请求

    }


    private void chatting(){                                //聊天ing

    }

    public void client_running() throws IOException{
        System.out.println("客户端以启动。。。");
        DatagramSocket socket=new DatagramSocket(0);
        DatagramSocket 
    }
}
