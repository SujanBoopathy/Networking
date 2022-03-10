import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class arp_client{
    public static void main(String[] args) {
        try{

            Socket s=new Socket("localhost",4999);
            DataInputStream in=new DataInputStream(s.getInputStream());
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter IP address : ");
            String ip=sc.nextLine();

            out.writeUTF(ip);

            String mac=in.readUTF();
            if(!mac.equals("Address not found"))
                System.out.println("MAC address is : "+mac);
            else
                System.out.println(mac);

            s.close();
            in.close();
            out.close();
            sc.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}