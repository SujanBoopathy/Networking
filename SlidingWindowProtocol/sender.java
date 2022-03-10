import java.io.*;
import java.net.*;
import java.util.*;

public class sender{
	public static void main(String args[]) throws Exception{
		
		ServerSocket ser=new ServerSocket(6666);
        Socket s=ser.accept();
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		
		Scanner sc=new Scanner(System.in);
		
		int window , frame,ack ;
				
		System.out.println("Enter Window size : ");
		window = sc.nextInt();
		
		System.out.println("Enter frame size : ");
		frame = sc.nextInt();
		
		out.writeUTF(Integer.toString(frame));
		String data[]=new String[frame];
		sc.nextLine();
		for(int index=0;index<frame;index++){
			data[index]=sc.nextLine();
		}
		
		for(int i=0;i<frame;i=ack){
			if(window+i >= frame ){
				System.out.println("Sending "+(frame-i)+" frames...");
				out.writeUTF(Integer.toString(frame-i));
				for(;i<frame;i++){
					out.writeUTF(data[i]);
				}
			}
			else{
				System.out.println("Sending "+window+" frames...");
				out.writeUTF(Integer.toString(window));
				for(int j=0;j<window;j++){
					out.writeUTF(data[i]);
					i++;
				}
			}
			ack=Integer.parseInt((String)in.readUTF());
			System.out.println("Acknowledgement receiver for "+ack+" frames ");
			
		}
	}
	
}	
		
