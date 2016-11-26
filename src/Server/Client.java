package Server;

import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.net.InetAddress;
import java.net.Socket;  
import java.util.Scanner;  
  
public class Client {  
     
    String lastMSG; 
    Socket socket;
    DataInputStream input;
    DataOutputStream output;
    public void startClient(String IP, int port){
        lastMSG = "";
        try {  
            socket = new Socket(InetAddress.getByName(IP), port);  
            input = new DataInputStream(socket.getInputStream());  
            output = new DataOutputStream(socket.getOutputStream());   
            String line = null;  
            listenServerReply(input);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    public void listenServerReply(final DataInputStream input){  
        new Thread(){  
            @Override  
            public void run() {  
                super.run();  
                String line = null;  
                try {  
                    while((line = input.readUTF()) != null){  
                       lastMSG = line.toString();
                    }  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }.start();  
    }
    
    public String getLastMSG() {
        return lastMSG;
    }
 
    public void sendMSG(String message) throws IOException {
        try{    
            output.writeUTF(message);
        } catch (IOException e) {
            
        }
    }
}
