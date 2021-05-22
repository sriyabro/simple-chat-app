package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Server running..");
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server socket created..");

        serverSocket.accept();
        System.out.println("Server accepted a client..");

        //send some data to the client
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
        outputStream.writeBytes("hello from the server...\n");



    }
}
