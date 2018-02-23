import java.util.*;
import java.io.*;
import java.net.*;
public class FifthClient{
	public static void main(String[] args)throws Exception{
		Socket s = new Socket("localhost",7);
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		Scanner scan = new Scanner(System.in);
		Thread send = new Thread(){
			public void run(){
				try{
				String send_message = scan.nextLine();
				while(!send_message.equals("Terminate")){
					out.writeUTF(send_message);
					send_message = scan.nextLine();
				}
			}catch(Exception e){ System.out.println("ERROR"); }
			}
		};
		Thread recieve = new Thread(){
			public void run(){
				try{
					while(true){
					String recieved_message = in.readUTF();
					System.out.println("Server: "+recieved_message);
				}
				}catch(Exception e){System.out.println("ERROR IN RECIEVING");}
			}
		};
		send.start();
		recieve.start(); 
	}
}
