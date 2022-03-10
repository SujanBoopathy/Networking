import java.io.*;
import java.util.*;
import java.net.*;

public class ftpClient{
	public static void main(String args[]) throws Exception{
		Socket s=new Socket("localhost",5000);
		Scanner sc=new Scanner(System.in);
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		do{
			int choice;
			String filename;
			
			System.out.println("1.Send File \t2.Exit \nEnter choice:");
			choice = sc.nextInt();
			out.writeUTF(Integer.toString(choice));
			System.out.println("Enter file name:");
			filename=sc.next();
			
			switch(choice){
				case 1:
				{					
					try{
						File file=new File(filename);
					
						FileInputStream fis=new FileInputStream(file);
						BufferedInputStream bis=new BufferedInputStream(fis);
						OutputStream os=s.getOutputStream();
						
						byte[] contents;
						long fileLength=file.length();
						int size=10000;
						
						if(fileLength >= 10000){
							fileLength=size;
						}else{
							size=(int)fileLength;
						}
						contents=new byte[size];
						bis.read(contents,0,size);
						os.write(contents);
						
						os.flush();
						System.out.println("File sent succcessfully");
						s.close();
					}
					catch(Exception e){
					   System.out.println(e);
					}
					
				}
				case 2:
				   System.exit(1);break;
				default:
					System.out.println("Plz enter right choice");
			}
		}while(true);
	}
}
