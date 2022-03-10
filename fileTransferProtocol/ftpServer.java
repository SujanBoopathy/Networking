import java.io.*;
import java.util.*;
import java.net.*;

public class ftpServer{
	public static void main(String args[]) throws Exception{
		while(true){
			ServerSocket ss=new ServerSocket(5000);
			Socket s=ss.accept();
			
			DataInputStream in = new DataInputStream(s.getInputStream());
			int choice=Integer.parseInt(in.readUTF());
			
			if(choice==2){
				System.out.println("Connection closed");
				break;
			}
			else{
				byte contents[]=new byte[10000];
				
				FileOutputStream fos=new FileOutputStream("output.txt");
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				
				InputStream is=s.getInputStream();
				
				int byteReader=0;
				
				while((byteReader=is.read(contents))!=-1)
					bos.write(contents,0,byteReader);
				System.out.println("File saved successfully");
				
				bos.flush();
				ss.close();
				s.close();
			}
		}
	}
}
