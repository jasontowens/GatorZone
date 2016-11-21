class NotReceivedYetException extends Exception {
        public NotReceivedYetException(String msg) {
            super(msg);
        }
}

public class ServerInterface {
    
    private static final int NUMBER_OF_TILES = 72;
    Client client;
    String playerID;
    String opponentID;
    String startingTile;
    String tileStack;
    
    public ServerInterface() {
        client = new Client();
        client.startClient();
        startingTile = "";
        tileStack = "";
        playerID = "";
        opponentID = "";
    }
    
    public Tile getStartingTile() throws NotReceivedYetException{
        if (startingTile == "") {
            throw new NotReceivedYetException("Server hasn't sent starting tile yet!");
        } else {
        
        Tile startTile = new Tile();
        return startTile;
        
        }
    }
    
    public Tile[] getTileStack() throws NotReceivedYetException{
        if (tileStack == "") {
            throw new NotReceivedYetException("Server hasn't sent tile stack yet!");
        } else {
        
        Tile[] tiles = new Tile[NUMBER_OF_TILES];
        return tiles;
        
        }
    }
    
    public void joinServer(String tournamentPassword, String username, String password) {
        
    }
    
    public void placeTile(Tile tile, int locationX, int locationY, int degreesRotation, boolean crocodile, int tigerZone) { //Use "-1" If No Tiger
        
    }
    
    public void notPlaceable(Tile tile) { //If no other arguments, assume pass turn
        
    }
    
    public void notPlaceable(Tile tile, boolean retrieveTiger, int locationX, int locationY) { //retrieveTiger true means retrieve, retrieveTiger false means place Tiger
    
    }
}
