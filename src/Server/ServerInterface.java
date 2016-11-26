package Server;

import Board.Tile;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerInterface {
    
    private static final int NUMBER_OF_TILES = 72;
    Client client;
    String playerID;
    String opponentID;
    String startingTile;
    String tileStack;
    
    public ServerInterface(String IP, int port) {
        client = new Client();
        client.startClient(IP, port);
        System.out.println("Test");
        startingTile = "";
        tileStack = "";
        playerID = "";
        opponentID = "";
        try {
            client.sendMSG("HI THERE!");
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
    
    public void notPlaceable(Tile tile) { //If no other arguments, assume pass turn
        
    }
    
    public void notPlaceable(Tile tile, boolean retrieveTiger, int locationX, int locationY) { //retrieveTiger true means retrieve, retrieveTiger false means place Tiger
    
    }
    
    public String tileToServerString(Tile tile) {
        String result = "";
        result += featureIntToString(tile.t.getEdge());
        result += featureIntToString(tile.r.getEdge());
        result += featureIntToString(tile.b.getEdge());
        result += featureIntToString(tile.l.getEdge());
        result += featureIntToString(tile.getMiddle());
        return result;
    }
    
    public Tile serverStringToTile(String serverString){
        
        int top = featureCharToInt(serverString.charAt(0));
        int right = featureCharToInt(serverString.charAt(1));
        int bottom = featureCharToInt(serverString.charAt(2));
        int left = featureCharToInt(serverString.charAt(3));
        int middle = featureCharToInt(serverString.charAt(4));
        
        return new Tile(right, top, left, bottom, middle);     
    }
    
    public String featureIntToString(int feature) {
        if (feature == 2)
            return "J";
        if (feature == 1)
            return "L";
        if (feature == 3)
            return "T";
        if (feature == 0)
            return "-";
        if (feature == 4)
            return "B";
        if (feature == 5)
            return "C";
        if (feature == 6)
            return "D";
        if (feature == 7)
            return "P";
        if (feature == 8)
            return "X";
        
       System.out.println("Invalid Feature Specified");
        return "E";
    }
    
    public int featureCharToInt(char feature){
        if (feature == 'J')
            return 2;
        if (feature == 'L')
            return 1;
        if (feature == 'T')
            return 3;
        if (feature == '-')
            return 0;
        if (feature == 'B')
            return 4;
        if (feature == 'C')
            return 5;
        if (feature == 'D')
            return 6;
        if (feature == 'P')
            return 7;
        if (feature == 'X')
            return 8;
      
        System.out.println("Invalid Feature Specified");
        return -1;
        
    }
}
