import java.util.*;
import java.net.*;
import java.io.*;
public class third
{
        public static void main(String args[]) throws Exception
        {
                Socket s=new Socket("localhost",Integer.parseInt(args[0]));
                DataOutputStream out=new DataOutputStream(s.getOutputStream());
                Scanner in=new Scanner(s.getInputStream());

                System.out.println(in.nextLine());
                in.close();
                s.close();
        }
};

