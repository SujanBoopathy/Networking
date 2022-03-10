import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class server{
    public static void main(String[] args) {
         
        try{
            ServerSocket ss=new ServerSocket(4999);
            Socket s=ss.accept();

            DataInputStream in=new DataInputStream(s.getInputStream());
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            Scanner sc=new Scanner(System.in);

            System.out.println("Connection done! \nEnter message:");
            String msg=sc.nextLine();

            out.writeUTF(msg);

            s.close();
            in.close();
            out.close();
            sc.close();
            ss.close();

        }catch(Exception e){
            System.out.println(e);
        }        



    }
}