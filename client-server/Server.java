package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;

public class Server
{
    static class Connection extends Thread {
        private final Socket clientSocket;
        private long lastSentMessageMillis;

        public Connection(Socket clientSocket)
        {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run()
        {
            try(ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream()))
            {
                while (clientSocket.isConnected())
                {
                    if (System.currentTimeMillis() - lastSentMessageMillis > 10000)
                    {
                        System.out.println(Instant.now() + " Sending the notification to client");
                        output.writeObject("Notification");
                        lastSentMessageMillis = System.currentTimeMillis();
                    }

                    // Seems that input.available() is not reliable?
                    boolean clientHasData = clientSocket.getInputStream().available() > 0;
                    if (clientHasData) {
                        String msg = (String) input.readObject();
                        System.out.println(Instant.now() + " Got from client: " + msg);

                        System.out.println(Instant.now() + " Sending response: ACK");
                        output.writeObject("ACK");
                    }

                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println(Instant.now() + " Client disconnected?");
            }
            catch (IOException | ClassNotFoundException e)
            {
                e.printStackTrace();
            }

            // cleanup
            try
            {
                clientSocket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        try (ServerSocket socket = new ServerSocket(3000))
        {
            while (true)
            {
                System.out.println(Instant.now() + " Waiting for client...");
                Socket clientSocket = socket.accept();
                new Connection(clientSocket).start();
            }
        }
    }
}

