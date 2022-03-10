import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class crc{
    public static void main(String[] args) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Data :");
        String data=in.readLine();

        System.out.println("Enter Divisor : ");
        String divisor=in.readLine();

        String code=data;

        while(code.length() < (data.length()+divisor.length()-1)){
            code+="0";
        }

        code=data+div(code,divisor);

        System.out.println("The transmitted code is :"+code);

        System.out.println("Enter the receiving code : ");
        String rec=in.readLine();

        if(Integer.parseInt(div(rec,divisor))==0)
            System.out.println("No Error found in receiving code");
        else
            System.out.println("Error found in receiving code");
    }

    public static String div(String n1,String n2){

        int ptr=n2.length();
        String res=n1.substring(0,ptr);
        String rem="";

        for(int i=0;i<n2.length();i++){
            if(res.charAt(i)==n2.charAt(i))
                rem+='0';
            else
                rem+='1';
        }

        while(ptr<n1.length()){
            if(rem.charAt(0)=='0'){
                rem=rem.substring(1,rem.length());
                rem+=String.valueOf(n1.charAt(ptr));
                ptr++;
            }

            res=rem;
            rem="";
            for(int i=0;i<n2.length();i++){
                if(res.charAt(i)==n2.charAt(i))
                    rem+='0';
                else
                    rem+='1';
            }
        }


        System.out.println(rem);
        return rem.substring(1,rem.length());
    }
}