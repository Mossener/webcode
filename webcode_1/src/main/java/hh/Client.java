package hh;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("已连接到服务器，输入消息发送：");
            String message;
            while ((message = userInput.readLine()) != null) {
                output.println(message);
                System.out.println("服务器: " + input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}