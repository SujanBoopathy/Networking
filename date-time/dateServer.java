import java.io.*;
import java.net.*;
import java.util.*;

public class dateServer{
	public static void main(String args[]) throws Exception{
		ServerSocket ss=new ServerSocket(5217);
		Socket s=ss.accept();

		DataOutputStream out=new DataOutputStream(s.getOutputStream());

		out.writeUTF("Server Date : "+(new Date()).toString()+"\n");

	}
}
