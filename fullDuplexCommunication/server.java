import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

            Thread sender=new Thread(new Runnable() {
                String msg;
                @Override
                public void run(){
                    try{
                        while(true){                            
                            msg=sc.nextLine();
                            out.writeUTF(msg);
                        }
                    }catch(IOException ie){
                        ie.printStackTrace();
                    }
                }
            });
            sender.start();

            Thread receiver=new Thread(new Runnable() {
                String msg;
                @Override
                public void run(){
                    try{
                        msg=in.readUTF();
                        while(msg!=null){
                            System.out.println("Client says: "+msg);
                            msg=in.readUTF();                            
                        }
                        System.out.println("Server out of services");
                    }catch(IOException ie){
                        ie.printStackTrace();
                    }
                }
            });
            receiver.start();

            s.close();
            ss.close();
            sc.close();
            in.close();
            out.close();

           
        }
        catch(IOException ie){
            ie.printStackTrace();
        }
    }
}