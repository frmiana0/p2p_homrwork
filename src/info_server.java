import java.io.IOException;
import java.net.*;
import java.util.HashMap;

public class info_server {
    final InetAddress IP = InetAddress.getByName("localhost");
    final int port = 8000;
    private HashMap<String, Pair<InetAddress,Integer>> clients_info;    //注册客户端信息

    info_server() throws UnknownHostException {
        clients_info = new HashMap<>();
    }

    public boolean Sign_Up(String user,InetAddress address, int port){        //注册时
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

    public boolean Login_Check(String user, InetAddress address, int port) {
        if (!clients_info.containsKey(user)) {
            return false;
        } else {
            clients_info.forEach((s, inetSocketAddressIntegerPair) -> {
                if (s.equals(user)) {
                    inetSocketAddressIntegerPair.first = address;
                    inetSocketAddressIntegerPair.second = port;
                }
            });
            return true;
        }
    }

    public Pair<InetAddress, Integer> Find_User_Address (String target) {
        if (!clients_info.containsKey(target)) {
            return null;
        } else {
            return clients_info.get(target);
        }
    }

    public void On_Service()throws Exception{
        System.out.println("Server Activated");
        DatagramSocket socket = new DatagramSocket(port);

        System.out.println("HostIP:" + IP + '\n' + "Port:" + port);

        final int package_size = 512;
        while(true){
            DatagramPacket request = new DatagramPacket(new byte[package_size], package_size);
            socket.receive(request);

//            request.
        }
    }




    public static void main(String[] args)throws IOException,Exception{
        new info_server().On_Service();
    }
}
