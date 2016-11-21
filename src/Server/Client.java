import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.net.Socket;  
import java.util.Scanner;  
  
public class Client {  
      
    public static void main(String[] args) {  
        new Client().startClient();
    }  
      
    public void startClient(){  
        try {  
            Socket socket = new Socket("localhost", 9999);  
            DataInputStream input = new DataInputStream(socket.getInputStream());  
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());   
            String line = null;  
            listenServerReply(input);  
            Scanner scanner = new Scanner(System.in);
            while((line = scanner.nextLine()) != null){//read from keyboard
                output.writeUTF(line);//sending to server 
                System.out.println("client send msg : " + line);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    //listening message from server
    public void listenServerReply(final DataInputStream dis){  
        new Thread(){  
            @Override  
            public void run() {  
                super.run();  
                String line = null;  
                try {  
                    while((line = dis.readUTF()) != null){  
                        System.out.println("client receive msg from server: " + line);  
                    }  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }.start();  
    }  
  
}  
