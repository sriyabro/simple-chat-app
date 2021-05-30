package com.company.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class Client {

    private DataOutputStream outputStream;

    private BufferedReader bufferedReader;

    public void start() throws IOException {
        System.out.println("Client running");
        Socket socket = new Socket("localhost", 6000);

        this.outputStream = new DataOutputStream(socket.getOutputStream());
        InputStream inputStream = socket.getInputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void sendMessage(String message, String name) throws IOException {
        this.outputStream.writeBytes(message + "\n" + name + "\n");
        String dataFromServer = this.bufferedReader.readLine();
        System.out.println("[Server]: " + dataFromServer);
    }
}
