import java.net.*;
import java.util.*;

public class ex3s
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket ds=new DatagramSocket(5000);
		byte[] buff=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buff,1024);
		ds.receive(dp);
		System.out.println(new String(buff,0,dp.getLength()));
		ds.send(dp);
		
	}
}