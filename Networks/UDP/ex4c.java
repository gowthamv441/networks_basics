import java.net.*;
import java.io.*;
import java.util.*;

public class ex4c
{
	public static void main(String args[])	throws Exception
	{
		DatagramSocket ds=new DatagramSocket();
		Scanner in=new Scanner(new FileInputStream("in.txt"));
		int count=0;
		//ds.setSoTimeout(1000);
		while(in.hasNext())
		{
			String s=in.nextLine();
			ByteArrayOutputStream out=new ByteArrayOutputStream();
			out.write(count);
			out.write(s.getBytes(),0,s.length());
			DatagramPacket dp=new DatagramPacket(out.toByteArray(),out.size(),InetAddress.getLocalHost(),5000);
			ds.send(dp);
			byte[] buff=new byte[1024];
			DatagramPacket dp2=new DatagramPacket(buff,1024);
			boolean flag=true;
			while(flag)
			{
				try
				{
					ds.receive(dp2);
					flag=false;
				}
				catch(Exception e)
				{
					System.out.println(count+"%n"+e);
					ds.send(dp);
				}
			}
			count++;
		}
	}
}