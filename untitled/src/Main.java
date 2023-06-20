
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

public class Main {
    private static final String FORMAT = "windows-1251";
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Server is listening on port 8081");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connect to client");
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(FORMAT)));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, Charset.forName(FORMAT)), true);
            printWriter.println("Hello");
            String message;

            if ((message = bufferedReader.readLine()) != null) {
                if (checkRussiansCharacter(message)) {
                    printWriter.println("Що таке паляниця");
                    message = bufferedReader.readLine().toLowerCase();
                    if (message.equals("хліб") || message.equals("хлеб")) {
                        printWriter.println(LocalDateTime.now());
                        printWriter.println("На все добре");
                        clientSocket.close();
                    } else {
                        printWriter.println("Йди за русским кораблем");
                        clientSocket.close();
                    }
                } else {
                    printWriter.println(LocalDateTime.now());
                    printWriter.println("Всього найкращого");
                    clientSocket.close();
                }
            }
            System.out.println("Client has been disconnected. Server was stop.");
        } catch (IOException e) {
            System.out.println("Error during try to listen");
            e.printStackTrace();
        }
    }
    public static boolean checkRussiansCharacter (String message){
        String convert = message.toLowerCase();
        char[] russianChars = {'ё','ы','э','ъ'};
        for (char russian : russianChars ) {
            if( convert.contains(String.valueOf(russian))){
                return true;
            }
        }
        return false;
    }

}