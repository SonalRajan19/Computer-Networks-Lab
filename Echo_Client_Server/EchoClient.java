/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn_lab_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Sonal L R
 */
public class EchoClient {
    private Socket socket=null;
    private DataInputStream input=null;
    private DataOutputStream out=null;
    public EchoClient(String address,int port)
    {
        try
        {
            socket=new Socket(address,port);
            System.out.println("Connected with server");
            input=new DataInputStream(System.in);
            out=new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        String line="";
        while(!line.equals("Over"))
        {
            try
            {
                line=input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        EchoClient client=new EchoClient("127.0.0.1",5000);
    }
}