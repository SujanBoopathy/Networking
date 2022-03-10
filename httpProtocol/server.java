import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;
//Http content retrieving;


public class server{
    public static void main(String[] args) {
        try{
            ServerSocket ss=new ServerSocket(4999);
            Socket s=ss.accept();
            DataInputStream in=new DataInputStream(s.getInputStream());
            DataOutputStream out=new DataOutputStream(s.getOutputStream());

            String str=in.readUTF();
            URL url=new URL(str);
            Scanner sc=new Scanner(url.openStream());
            StringBuffer sb=new StringBuffer();

            while(sc.hasNext()){
                sb.append(sc.next());
            }

            String res=sb.toString();
            res.replaceAll(">", ">\n");

            out.writeUTF(res);            

            ss.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}