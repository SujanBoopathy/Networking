import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class client{
    public static void main(String[] args) {
        try{

            Socket s=new Socket("localhost",4999);
            DataInputStream in=new DataInputStream(s.getInputStream());
            DataOutputStream out=new DataOutputStream(s.getOutputStream());

            String msg=in.readUTF();

            System.out.println("Message from server :"+msg);

            s.close();
            in.close();
            out.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}