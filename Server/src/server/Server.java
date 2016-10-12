package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        String answer;
        int count = 0;
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    
                    
                    out.println("What is the YEAR of Independence of Bangladesh?");
                    answer = input.readLine();
                    if(answer.equals("1971")) count++;
                    
                    out.println("What is our National Language?");
                    answer = input.readLine();
                    if(answer.equals("bangla") || answer.equals("bengali")) count++;
                    
                    out.println("Which country do you live in?");
                    answer = input.readLine();
                    if(answer.equals("bangladesh")) count++;
                    
                    out.println("Captain of BD team?");
                    answer = input.readLine();
                    if(answer.equals("mashrafi")) count++;
                    
                    
                    out.println("END");
                    out.println("Your result is, " + count + "/4");
                    count = 0;
                } 
                finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}