import
import java.io.IOException;
import java.net.*;
import java.util.HashMap;

public class info_server {
    final int port = 8000;
    private HashMap<String, Pair<InetSocketAddress,Integer>> clients_info;    //注册客户端信息

    info_server() {
        clients_info = new HashMap<>();
    }

    public boolean Sign_Up(String user,InetSocketAddress address, int port){        //注册时
        String msg;
        boolean occupied;

        occupied = clients_info.containsKey(user);
        if (!occupied) {
            clients_info.put(user, new Pair<>(address,port));
            msg = "New User Signed";
        } else {
            msg = "User Name Occupied";
        }

        System.out.println(msg);
        return !occupied;
    }

    public boolean Login_Check(String user, InetSocketAddress address, int port) {
        if (!clients_info.containsKey(user)) {
            return false;
        } else {
            clients_info.forEach((s, inetSocketAddressIntegerPair) -> {
                if (s.equals(user)) {
                    inetSocketAddressIntegerPair.s
                }
            });
        }
    }

    public void On_Service()throws Exception{
        System.out.println("Server Actvated");
        try {
            DatagramSocket socket = new DatagramSocket(port);
        } catch (IOException e) {
            System.out.println("ERROR::SOCKET_INIT_FAILED");
            System.exit(1);
        }

        while(true){
            DatagramPacket request = new DatagramPacket(new byte[12], 12);
            socket.receive(request);

        }
    }




    public static void main(String[] args)throws IOException,Exception{
        new info_server().server();
    }
}
