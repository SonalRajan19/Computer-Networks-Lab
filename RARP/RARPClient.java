/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RARP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Sonal L R
 */
public class RARPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket client=new DatagramSocket();
            InetAddress addr=InetAddress.getByName("127.0.0.1");
            byte[] sendbyte=new byte[1024];
            byte[] receivebyte=new byte[1024];
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the physical address: ");
            String str=in.readLine();
            sendbyte=str.getBytes();
            DatagramPacket sender=new DatagramPacket(sendbyte, sendbyte.length, addr, 1309);
            client.send(sender);
            DatagramPacket receiver=new DatagramPacket(receivebyte, receivebyte.length);
            client.receive(receiver); 
            String s=new String(receiver.getData());
            System.out.println("The IP address is "+s.trim());
            client.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}