package book.Lesson18.traning;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMy {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket client;
        try{
            serverSocket = new ServerSocket(4000);
            System.out.println("Сервер запущен");
            while (true){
                client = serverSocket.accept();

                try(BufferedReader inbound = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    BufferedOutputStream outbound = new BufferedOutputStream(client.getOutputStream());
                ){
                    String messageFromClient = inbound.readLine();
                    String price = (new Double(Math.random()*100).toString());

                    outbound.write(("Price of the " + messageFromClient + " = " + price + "\n").getBytes());
                    System.out.println("Ответ на запрос отправлен");
                    outbound.write(("End\n").getBytes());
                    System.out.println("Жду новый запрос");
                }catch (IOException e1){
                 System.out.println("Проблема в стримах");
                }
            }
        }catch (IOException e){
            System.out.println("Проблема с запуском сервера");
        }
    }
}
