/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RARP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Sonal L R
 */
public class RARPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket server=new DatagramSocket(1309);
            while(true) {
                byte[] sendbyte=new byte[1024];
                byte[] receivebyte=new byte[1024];
                DatagramPacket receiver=new DatagramPacket(receivebyte, receivebyte.length);
                server.receive(receiver);
                String str=new String(receiver.getData());
                String s=str.trim();
                InetAddress addr=receiver.getAddress();
                int port=receiver.getPort();
                String ip[]={"165.165.80.80", "165.165.79.1"};
                String mac[]={"68:08:AA:C2", "8A:BC:E3:FA"};
                for(int i=0; i<ip.length; i++) {
                    if(s.equals(mac[i])) {
                        sendbyte=ip[i].getBytes();
                        DatagramPacket sender=new DatagramPacket(sendbyte, sendbyte.length, addr, port);
                        server.send(sender);
                        break;
                    }
                }
                break;
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}