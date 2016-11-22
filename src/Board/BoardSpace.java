package board;

public class BoardSpace {
    boolean hasTile;
    Tile tile;
    
    public BoardSpace() {
        hasTile = false;
    }
    
    public void addTile(Tile tileToAdd){
        tile = tileToAdd;
        hasTile = true;
    }
}
