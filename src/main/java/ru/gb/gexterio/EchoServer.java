package ru.gb.gexterio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class EchoServer {

    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
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
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String msg = scanner.nextLine();
                    try {
                        out.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

//            Thread checker =  new Thread(() -> {
//                try {
//                    String msg = in.readUTF();
//                    if ("/end".equalsIgnoreCase(msg)) {
//
//
//
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });


            readerAndEcho.start();
            sender.start();
//            checker.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


        }
//        private  void closer () {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
    }

