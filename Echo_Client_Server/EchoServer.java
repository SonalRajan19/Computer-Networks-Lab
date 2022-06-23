/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn_lab_2;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Sonal L R
 */
public class EchoServer {
    private Socket socket=null;
    private ServerSocket server=null;
    private DataInputStream in=null;
    public EchoServer(int port){
        try{
            server=new ServerSocket(port);
            System.out.println("Server started.");
            System.out.println("Waiting for a client.....");
            socket=server.accept();
            System.out.println("Client accepted: ");
            in=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line="";
            while(!line.equals("Over"))
            {
                try{
                    line=in.readUTF();
                    System.out.println(line);
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
            System.out.println("Closing connection.");
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        EchoServer server=new EchoServer(5000);
    }
}