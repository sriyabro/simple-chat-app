package com.company.server;

import java.io.*;
import java.net.Socket;

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

            //Continuous reading data from client
            String inputData;
            while ((inputData = bufferedReader.readLine()) != null) {

                System.out.println("Client says: " + inputData);
                //send data to client
                switch (inputData) {
                    case "Hello from Client!!":
                        outputStream.writeBytes("Hello from Server..\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("I am fine. How are you? \n");
                        break;
                    case "I am fine":
                        outputStream.writeBytes("Okay! good to know \n");
                        break;
                    case "Thank you":
                        outputStream.writeBytes("You are welcome \n");
                        break;
                    default:
                        outputStream.writeBytes("Sorry I can't understand \n");

                }

                if (inputData.equals("exit")) {
                    break;
                }
            }
            this.client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
