import java.net.*;
import java.util.*;

public class arp{
	public static void main(String args[]) throws SocketException,UnknownHostException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter IP address: ");
		String ip=sc.nextLine();
		InetAddress address=InetAddress.getByName(ip);

		NetworkInterface ni=NetworkInterface.getByInetAddress(address);

		if(ni!=null){
			byte[] mac=ni.getHardwareAddress();
			if(mac !=null){
				for(int i=0;i<mac.length;i++){
					System.out.format("%02X%s",mac[i],(i<mac.length-1)?"-":"");
				}
			}
			else{
				System.out.println("Mac address is not accessible");
			}
		}
		else{
			System.out.println("Network interface for the specified address is not found");
		}
	}
}
