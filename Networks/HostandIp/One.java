import java.util.*;
import java.io.*;
import java.net.*;
public class One {
	public static void main(String[] args) throws SocketException {
		ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
		for (NetworkInterface iface : interfaces) {
			if (iface.isUp()&&iface.getDisplayName().equals("eth0")) {
				for (InterfaceAddress addr : iface.getInterfaceAddresses()) {
					if( addr.getAddress().toString().indexOf(":")==-1)
					System.out.println("IP Address : " + addr.getAddress().toString());
					}
				}
			}
			try{
				InetAddress ip = InetAddress.getLocalHost();
				System.out.println("Host Name : "+ip.getHostName() );
			}catch(Exception e){ System.out.println("Error"); }
		}
	}