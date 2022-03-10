import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client{
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",4999);
            DataInputStream in=new DataInputStream(s.getInputStream());
            DataOutputStream out=new DataOutputStream(s.getOutputStream());

            Scanner sc=new Scanner(System.in);

            while(true){
                String msg1=in.readUTF();
                if(msg1.equals("STOP"))  break;
                System.out.println("Server says: "+msg1);

                System.out.print("Enter msg to server :");
                String msg2=sc.nextLine();
                out.writeUTF(msg2);
                if(msg2.equals("STOP")) break;
                

            }

            s.close();
            in.close();
            out.close();
            sc.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}