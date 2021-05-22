package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        System.out.println("Client running");

        Socket socket = new Socket("localhost", 6000);
        System.out.println("Client accepted");

        //Get data form the server
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String recievedData =  bufferedReader.readLine();

        System.out.println("Data received form the server:" + recievedData);

    }
}
