import java.net.*;

public class ex2s
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket dS=new DatagramSocket(5000);
		byte[] message=new byte[1024];
		DatagramPacket dP=new DatagramPacket(message,1024);
		dS.receive(dP);
		String rcvMsg=new String(message,0,dP.getLength());
		System.out.println(rcvMsg);
	}
}