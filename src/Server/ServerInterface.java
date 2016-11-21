public class ServerInterface {
    
    private static final int NUMBER_OF_TILES = 72;
    String playerID;
    String opponentID;
    
    public ServerInterface() {
        playerID = "";
        opponentID = "";
    }
    
    public Tile getStartingTile() {
        Tile startTile = new Tile();
        
        return startTile;
    }
    
    public Tile[] getTileStack() {
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
}
