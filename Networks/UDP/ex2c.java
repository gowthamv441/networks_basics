import java.net.*;

public class ex2c
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket dS=new DatagramSocket();
		String message="Hello World";
		DatagramPacket dP=new DatagramPacket(message.getBytes(),message.length(),InetAddress.getLocalHost(),5000);
		dS.send(dP);
	}
}