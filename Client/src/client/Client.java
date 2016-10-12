
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Sazid
 */
public class Client {

  public static void main(String[] args) throws IOException {
        String serverAddress = JOptionPane.showInputDialog(
            "Enter IP Address of a machine that is\n" +
            "running the date service on port 9090:");
        Socket s = new Socket(serverAddress, 9090);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String ques;
        while(true){
            
            ques = input.readLine();
            if(ques.equals("END")) break;
            String reply = JOptionPane.showInputDialog(ques);
            out.println(reply);
        }
        

        ques = input.readLine();
        JOptionPane.showMessageDialog(null, ques);
        
        
        System.exit(0);
    }
}

