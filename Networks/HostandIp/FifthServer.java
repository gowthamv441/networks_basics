import java.util.*;
import java.io.*;
import java.net.*;
public class FifthServer{
	public static void main(String[] args)throws Exception{
		ServerSocket ss = new ServerSocket(7);
		Socket s = ss.accept();
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		Scanner scan = new Scanner(System.in);
		
		Thread recieve = new Thread(){
			public void run(){
				try{
					while(true){
					String send_message=null;					
					String recieved_message = in.readUTF();
					send_message=recieved_message;
					out.writeUTF(send_message);
				}
				}catch(Exception e){System.out.println("ERROR IN RECIEVING");}
			}
		};
		recieve.start(); 
	}
}
