package com.company.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {

        try {
            //Thread.sleep(20000); //wait for 20 secs before executing the rest of the code

            //Receive data
            InputStream inputStream = this.client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(this.client.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            String serverMessage;

            //Continuous reading data from client
            String inputData;
            String name;
            while ((inputData = bufferedReader.readLine()) != null) {

                name = bufferedReader.readLine();
                System.out.println("[" + name + "]: " + inputData);

                if (inputData.equals("exit")) {
                    System.out.println("Exiting...");
                    break;
                }
                else { //send data to client
                    System.out.print("[Server]: ");
                    serverMessage = scanner.nextLine();
                    outputStream.writeBytes(serverMessage + "\n");
                }
            }
            this.client.close();
            System.out.println("Client closed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
