package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Szerver {

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8080);
            Socket kapcsolat = socket.accept();
            DataInputStream klienstol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream kliensnek = new DataOutputStream(kapcsolat.getOutputStream());
            InetAddress kliens = kapcsolat.getInetAddress();
            System.out.println("Az ügyfél neve: " + kliens.getHostName());
            System.out.println("Az ügyfél címe: " + kliens.getHostAddress());
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

}
