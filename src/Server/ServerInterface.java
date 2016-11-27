package Server;

import Board.BoardSpace;
import Board.Tile;
import static Core.TileConvertor.serverStringToTile;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
public class ServerInterface {
    
    private static final int NUMBER_OF_TILES = 72;
    Client client;
    String playerID;
    String opponentID;
    String startingTile;
    String tileStack;
    
    public String IP;
    public int port;
    public String tpass;
    public String username;
    public String password;
    
    public ServerInterface(String IP, int port, String tpass, String username, String password) {
        this.IP = IP;
        this.port = port;
        this.tpass = tpass;
        this.username = username;
        this.password = password;
        
        client = new Client();
        client.startClient(IP, port);
        startingTile = "";
        tileStack = "";
        playerID = "";
        opponentID = "";
        try {
            client.sendMSG("JOIN " + tpass);
        } catch (IOException ex) {
            Logger.getLogger(ServerInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            client.sendMSG("I AM " + username + " " + password);
        } catch (IOException ex) {
            Logger.getLogger(ServerInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Tile getStartingTile(){
        while(startingTile.equals("")) {
            String msg = client.lastMSG;
            if(msg.substring(0, 16).equals("STARTING TILE IS")) {
                
            }
        }
        
        Tile startTile = serverStringToTile(startingTile);
        return startTile;
        
    }
    
    public Tile[] getTileStack(){
        while(tileStack.equals("")) {
        
        }
        
        Tile[] tiles = new Tile[NUMBER_OF_TILES];
        return tiles;
        
    }
    
    public void joinServer(String tournamentPassword, String username, String password) {
        
    }
    
    public void placeTile(Tile tile, int locationX, int locationY, int degreesRotation, boolean crocodile, int tigerZone) { //Use "-1" If No Tiger
        
    }
    
    public void placeTile(BoardSpace space) {
        
    }
    
    public void notPlaceable(Tile tile) { //If no other arguments, assume pass turn
        
    }
    
    public void notPlaceable(Tile tile, boolean retrieveTiger, int locationX, int locationY) { //retrieveTiger true means retrieve, retrieveTiger false means place Tiger
    
    }
}
