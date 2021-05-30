package com.company.client;

import java.io.IOException;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        
        Client client = new Client();
        client.start();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        String message;

        while (true) {
            System.out.print("[" + name + "]: ");
            message = scanner.nextLine();
            client.sendMessage(message, name);
            if (message.equals("exit")) {
                System.out.println("Exiting application..");
                break;
            }

        }

        System.out.println("Client finished execution");

    }
}
