package Server;

import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.Scanner;

class ServerStarter {
    public static void main(String[] args) {
        TestServer test = new TestServer();
        test.startServer();
    }
}

public class TestServer {  

String lastServerReception;
boolean connected;

    public void startServer(){  
        connected = false;
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
                dos.writeUTF("THIS IS SPARTA!");
                while((msg = dis.readUTF()) != null){
                    while(!connected) {
                        if(msg.substring(0,4).equals("JOIN")) {
                            dos.writeUTF("HELLO!");
                        }
                        connected = true;
                    }
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
