/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_Application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Sonal L R
 */
public class ChatClient {
    public static void main(String[] args)throws Exception
    {
        Socket sk=new Socket("127.0.0.1",2000);
        BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream sout=new PrintStream(sk.getOutputStream());
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(true)
        {
            System.out.print("Client: ");
            s=stdin.readLine();
            sout.println(s);
            s=sin.readLine();
            System.out.println("Server: "+s);
            if(s.equalsIgnoreCase("Bye"))
                break;
        }
        sk.close();
        sin.close();
        sout.close();
        stdin.close();
    }
}