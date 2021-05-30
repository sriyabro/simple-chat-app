package com.company.client;

import java.io.IOException;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        
        Client client = new Client();
        client.start();

        Scanner scanner = new Scanner(System.in);
        String message = null;

        while (true) {
            System.out.print("Enter Message (Client): ");
            message = scanner.nextLine();
            if (message ==   "exit") {
                break;
            }
            client.sendMessage(message);
        }

        System.out.println("Client finished execution");

    }
}
