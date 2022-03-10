import java.io.*;
import java.net.*;
import java.util.*;

public class dateClient{
	public static void main(String args[]) throws Exception{
		Socket s=new Socket(InetAddress.getLocalHost(),5217);
		DataInputStream in=new DataInputStream(s.getInputStream());
		System.out.println(in.readUTF());
	}
}

