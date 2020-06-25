package book.Lesson18.traning;

import java.io.*;
import java.net.Socket;

public class ClientMy {
    public static void main(String[] args) {
        String messageToServer = "IBM";
        String messageFromServer;
        Socket client;
        try {
            client = new Socket("localhost", 4000);
            try (InputStream in = client.getInputStream();
                 InputStreamReader reader = new InputStreamReader(in);
                 BufferedReader inbound = new BufferedReader(reader);

                 OutputStream outbound = client.getOutputStream();
            ){
                outbound.write((messageToServer + "\n").getBytes());

                while (true) {
                    messageFromServer = inbound.readLine();
                    if (messageFromServer.equals("End"))
                        break;
                    System.out.println("Получено сообщение с серавера: " + messageFromServer);
                }

            }catch (IOException e1){
                System.out.println("646468787687676");
            }
        }catch (IOException e){
            System.out.println("Не могу подключиться к серверу");
        }
    }
}
