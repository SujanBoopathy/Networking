import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server{
    public static void main(String[] args) {
        try{
            ServerSocket ss=new ServerSocket(4999);
            Socket s=ss.accept();
            DataInputStream in=new DataInputStream(s.getInputStream());
            DataOutputStream out=new DataOutputStream(s.getOutputStream());

            Scanner sc=new Scanner(System.in);

            while(true){
                System.out.print("Enter msg to client:");
                String msg1=sc.nextLine();
                out.writeUTF(msg1);
                if(msg1.equals("STOP")) break;

                String msg2=in.readUTF();
                if(msg2.equals("STOP"))  break;
                System.out.println("Client says: "+msg2);
            }
            ss.close();
            s.close();
            in.close();
            out.close();
            sc.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}