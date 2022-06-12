package ru.gb.gexterio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean isEnd;

    public static void main(String[] args) {
        new EchoClient().start();
    }

    private void start() {
        try {
            openConnection();
            Scanner scanner = new Scanner(System.in);

            while (!isEnd) {
                sendMessage(scanner.nextLine());
                getMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        try {
            if (message.equalsIgnoreCase("/end")) {
                out.writeUTF(message);
                closeConnection();
                System.exit(0);
            } else {
                out.writeUTF(message);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        String host = "127.0.0.1";
        int port = 8888;
        socket = new Socket(host, port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    private void getMessage() {
        new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    if ("/end".equalsIgnoreCase(message)) {
                        break;
                    }
                    System.out.println("Сообщение от сервера: " + message);
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }).start();
    }

    private void closeConnection() {
        if (in !=null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket !=null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}