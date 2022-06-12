package ru.gb.gexterio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.System.out;

public class EchoServer {

    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            AtomicBoolean isEnd = new AtomicBoolean(false);

            Thread readerAndEcho = new Thread(() -> {
                while (true) {
                    String message = null;
                    try {
                        message = in.readUTF();
                        if ("/end".equalsIgnoreCase(message)) {
                            isEnd.set(true);
                            break;
                        }
                        System.out.println("Сообщение от клиента: " + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.writeUTF("Эхо: " + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            Thread sender = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String msg = scanner.nextLine();
                    try {
                        out.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            sender.setDaemon(!isEnd.get());  //Очень чудно получилось, но ведь работает )))
            readerAndEcho.start();
            sender.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

