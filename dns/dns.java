import java.util.*;
import java.net.InetAddress;
//import java.util.Scanner;

public class dns{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n;
        do{
            System.out.println("1.DNS \n2.Exit \nEnter your choice : ");
            n=Integer.parseInt(System.console().readLine());
            if(n==1){
                try{
                    System.out.println("Enter host name: ");
                    String hostName=sc.nextLine();
                    InetAddress address= InetAddress.getByName(hostName);

                    System.out.println("\nHost Name : "+address.getHostName());
                    System.out.println("Host Address : "+address.getHostAddress());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }while(n==1);

        sc.close();
    }
}
