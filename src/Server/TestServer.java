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
//TEST Variables
private static final int NUM_OF_ROUNDS = 3;
private static final int NUM_OF_MATCHES = 2;

private int matchOn = 0;
private int roundOn = 0;
String lastServerReception;

    public void startServer(){
        try {  
            //listening 
            ServerSocket ss = new ServerSocket(9999);
            while(true){  
                //return information when server catch client
                Socket s = ss.accept();  
                System.out.println("THIS IS SPARTA!");  
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
                        if(msg.substring(0,4).equals("JOIN")) {
                            dos.writeUTF("HELLO!");
                        }
                        if(msg.substring(0,4).equals("I AM")) {
                            int endSpace = msg.length();
                            for(int i = 5; i < msg.length(); i++){
                                if(msg.charAt(i) == ' '){
                                    endSpace = i;
                                    break;
                                }
                            }
                            String name = "WELCOME" + msg.substring(5, endSpace + 1) + "PLEASE WAIT FOR NEXT CHALLENGE";
                            dos.writeUTF(name);
                            dos.writeUTF("");
                            dos.writeUTF("");
                            dos.writeUTF("");
                            dos.writeUTF("");
                        }
                    System.out.println("CLIENT：" + msg);  
                    //String replyMsg = "server reply ： " + msg;  
                    //dos.writeUTF(replyMsg);  
                    //System.out.println("server reply msg ：" + replyMsg);  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  
