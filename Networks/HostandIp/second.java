import java.io.*;
import java.net.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class second{
    static Scanner in = new Scanner(System.in);
    
    static boolean check(String a){
    	for(int i=0;i<a.length();i++){
    		if(!(a.charAt(i)>='0' && a.charAt(i)<='9') && !(a.charAt(i)=='.'))	return false;
    	}
    	for(int i=0;i<a.length();i++){
    		int val=0;
    		for(;i<a.length();i++){
    			if(a.charAt(i)=='.')	break;
    			val=(val*10)+(a.charAt(i)-'0');
    		}
    		if(!(val>=0 && val<=255)){
    			return false;
    		}
    	}
    	return true;
    }
    public static void main(String[] args){
        System.out.println();
        try{
            FileInputStream fin = new FileInputStream("a.txt");
            while(fin.available()>0){
                String a = "";
                char x='?';
                do{
                    if(x!='?')
                        a=a+x;
                    x=(char) fin.read();
                }while(x!='\n');
                System.out.println("INPUT :: "+a);
                if(a.equals("exit")){      break;  }
                if(check(a)){
                    System.out.println("this is ip address");
                    InetAddress add = InetAddress.getByName(a);
                    System.out.println("HOST NAME :: "+add.getHostName());
                }else{
                    System.out.println("this is hostname");
                    InetAddress add = InetAddress.getByName(a);
                    System.out.println("HOST ADDRESS :: "+add.getHostAddress());
                }
                System.out.println();
            }
            fin.close();
        }catch(IOException e){
            System.out.print(e);
        }
    }
}
