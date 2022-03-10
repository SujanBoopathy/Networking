import java.io.*;
import java.net.*;
import java.util.*;

public class receiver{
	public static void main(String args[]){
		try{

			int p=8000,q=9000;

			ServerSocket ss1=new ServerSocket(p);
			Socket s1=ss1.accept();

			DataInputStream in1=new DataInputStream(s1.getInputStream());
			int frames=in1.read();

			for(int i=0;i<frames;i++){
				ServerSocket ss3=new ServerSocket(q+i);
				Socket s3=ss3.accept();

				DataInputStream in3=new DataInputStream(s3.getInputStream());
				String msg=in3.readUTF();

				System.out.println("The message received is :"+msg);

				DataOutputStream out3=new DataOutputStream(s3.getOutputStream());
				out3.write(i);

				System.out.println("Acknowledgement for frame "+i+" is sent");
				
			}
		}	
		catch(Exception e){
			System.out.println(e);
		}		
	}
}
