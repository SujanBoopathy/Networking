import java.io.*;
import java.net.*;
import java.util.*;

public class sender{
	public static void main(String args[]) {
		try{
			Scanner sc=new Scanner(System.in);
			String h="localhost";
			int p=8000,q=9000;
			int frames;
			System.out.println("Enter count of frames : ");
			frames=sc.nextInt();

			if(frames==0){
				System.out.println("No Frames can be sent");
			}
			else{
				Socket s=new Socket(h,p);
				DataOutputStream out=new DataOutputStream(s.getOutputStream());
				out.write(frames);
			}

			String msg;

			for(int i=0;i<frames;i++){
				System.out.println("Enter message :");
				msg=sc.next();
				System.out.println("Frame "+i+" is sent");

				Socket s2=new Socket(h,q+i);
				DataOutputStream out2=new DataOutputStream(s2.getOutputStream());

				out2.writeUTF(msg);

				DataInputStream in2=new DataInputStream(s2.getInputStream());

				int number=in2.read();
				System.out.println("Acknowledgement for "+number+" is received");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
