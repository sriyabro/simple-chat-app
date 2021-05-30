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
            String message;

            //Continuous reading data from client
            String inputData;
            while ((inputData = bufferedReader.readLine()) != null) {

                System.out.println("Client says: " + inputData);

                if (inputData.equals("exit")) {
                    break;
                }
                else { //send data to client
                    System.out.print("Enter Message (Server):");
                    message = scanner.nextLine();
                    outputStream.writeBytes(message + "\n");
                }
            }
            this.client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
