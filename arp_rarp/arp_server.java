import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.Scanner;

public class arp_server{
    public static void main(String[] args) {
        try{
            ServerSocket ss=new ServerSocket(4999);
            Socket s=ss.accept();
            DataInputStream in=new DataInputStream(s.getInputStream());
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            //Scanner sc=new Scanner(System.in);

            int flag=0;
            String ip[]={"192.168.43.1","192.168.43.4"};
            String mac[]={"0a:40:57:63:17:8a","70:66:55:0e:98:33"};

            String ip_address=in.readUTF();

            for(int i=0;i<ip.length;i++){
                if(ip_address.equals(ip[i]))
                {
                    flag=1;
                    out.writeUTF(mac[i]);
                }
            }
            if(flag==0){
                out.writeUTF("Address not found");
            }

            ss.close();
            s.close();
            in.close();
            out.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}