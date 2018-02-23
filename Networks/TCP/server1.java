import java.io.*;
import java.util.*;
import java.net.*;

public class server{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        try{
            ServerSocket socket = new ServerSocket(1234);
            Socket s = socket.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            Thread t1 = new Thread(){
                public void run(){
                    try{
                        String str = in.nextLine();
                        while(!str.equals("Thanks")){
                            dos.writeUTF("Vikraman :: "+str);
                            str=in.nextLine();
                        }
                        dos.writeUTF(str);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            };
            Thread t2 = new Thread(){
                public void run(){
                    try{
                        String str = (String) dis.readUTF();
                        while(!str.equals("Thanks")){
                            System.out.println(str);
                            str = (String) dis.readUTF();
                        }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            };
            t1.start();
            t2.start();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
