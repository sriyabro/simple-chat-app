package com.company.client;

import java.io.IOException;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        
        Client client = new Client();
        client.start();

        
        client.sendMessage("Hello from Client!!");
        client.sendMessage("How are you?");
        client.sendMessage("I am fine");
        client.sendMessage("Thank you");
        client.sendMessage("exit");

        System.out.println("Client finished execution");

    }
}
