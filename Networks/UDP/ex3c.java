import java.net.*;
import java.util.*;

public class ex3c
{
	public static void main(String args[]) throws Exception
	{
		Scanner in=new Scanner(System.in);
		DatagramSocket ds=new DatagramSocket();
		String message=in.nextLine();
		DatagramPacket dp=new DatagramPacket(message.getBytes(),message.length(),InetAddress.getLocalHost(),5000);
		ds.send(dp);
		byte[] buff=new byte[1024];
		DatagramPacket dp2=new DatagramPacket(buff,1024);
		ds.receive(dp2);
		System.out.println(new String(buff,0,dp2.getLength()));
	}
}