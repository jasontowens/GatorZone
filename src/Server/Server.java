import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.Scanner;

public class Server {  

String lastServerReception;
      
    public void startServer(){  
        try {  
            //listening 
            ServerSocket ss = new ServerSocket(9999);  
            System.out.println("server is listening...");  
            while(true){  
                //return information when server catch client
                Socket s = ss.accept();  
                System.out.println("a client has connected!");  
                //connected 
                new CommunicateThread(s).start();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public class CommunicateThread extends Thread{  
          
        Socket socket;  
        DataInputStream dis;  
        DataOutputStream dos;  
          
        public CommunicateThread(Socket socket){  
            this.socket = socket;  
            try {  
                dis = new DataInputStream(socket.getInputStream());  
                dos = new DataOutputStream(socket.getOutputStream());  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
          
        @Override  
        public void run() {  
            super.run();  
            //read information  
            String msg = null;  
            try {  
                while((msg = dis.readUTF()) != null){  
                    System.out.println("client send msg ：" + msg);  
                    String replyMsg = "server reply ： " + msg;  
                    dos.writeUTF(replyMsg);  
                    System.out.println("server reply msg ：" + replyMsg);  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
}  
