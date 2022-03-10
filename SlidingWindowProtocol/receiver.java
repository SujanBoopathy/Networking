import java.io.*;
import java.net.*;
import java.util.*;

public class receiver{
	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);
		Socket s=new Socket("localhost",6666);
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		
		int frame=Integer.parseInt((String)in.readUTF());
		String data[]=new String[frame];
		
		for(int i=0;i<frame;){
			int a=Integer.parseInt((String)in.readUTF());
			for(int j=0;j<a;j++){
				data[i]=in.readUTF();
				System.out.println("Data in the "+i+" frame :"+data[i]);
				i++;
			}
			System.out.println("Acknowledgement sent for "+a+" frames ");
			out.writeUTF(Integer.toString(i));
		}
	}
}
