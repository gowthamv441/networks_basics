
import java.net.*;
import java.io.*;
import java.util.*;

class DateServer
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket s=new ServerSocket(7);
        System.out.println("Waiting For Connection ...");
        Socket soc=s.accept();
        DataOutputStream out=new DataOutputStream(soc.getOutputStream());
        long time = System.currentTimeMillis();
        out.writeLong(time);
        out.close();
        soc.close();
    }
}