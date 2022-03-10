import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
//Http content retrieving;


public class client{
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",4999);
            DataInputStream in=new DataInputStream(s.getInputStream());
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            Scanner sc=new Scanner(System.in);

            String str;
            System.out.println("Enter url : ");
            str=sc.nextLine();

            out.writeUTF(str);

            str=in.readUTF();

            System.out.println("The http content of the given url page is : \n"+str);

            s.close();
            sc.close();
            in.close();
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}