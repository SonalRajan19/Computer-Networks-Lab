/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_Application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Sonal L R
 */
public class ChatServer {
    public static void main(String[] args)throws Exception
    {
       ServerSocket ss=new ServerSocket(2000);
       Socket sk=ss.accept();
       BufferedReader cin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
       PrintStream cout=new PrintStream(sk.getOutputStream());
       BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
       String s;
       while(true)
       {
           s=cin.readLine();
           if(s.equalsIgnoreCase("End"))
           {
               cout.println("Bye");
               break;
           }
           System.out.println("Client: "+s);
           System.out.print("Server: ");
           s=stdin.readLine();
           cout.println(s);
       }
       ss.close();
       sk.close();
       cin.close();
       cout.close();
    }
}