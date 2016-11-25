package Board;

public class Coordinates {
	private static final int NUM_TILES = 144;

	public BoardSpace[][] boardSpace = new BoardSpace[NUM_TILES][NUM_TILES];
	public Coordinates(){
		
	}
	public void addTile(int x, int y, Tile tile){
                if(validMove(x, y, tile))
                    boardSpace[x][y].addTile(tile);
                else
                    System.out.println("Invalid placement location");
        }
	
	// Looks at every tile adjacent to input tile and location to see if it is valid. 
	public boolean validMove(int x, int y, Tile tile){ 
		if (boardSpace[x][y].hasTile){
			System.out.println("There is already a tile here");
			return false;
		}
		if(x != 0 && boardSpace[x-1][y].hasTile && boardSpace[x-1][y].tile.r.edgeType != tile.l.edgeType){
			return false;
		}
		if(x != (NUM_TILES - 1) && boardSpace[x+1][y].hasTile && boardSpace[x+1][y].tile.l.edgeType != tile.r.edgeType){
			return false;
		}
		if(y != 0 && boardSpace[x][y-1].hasTile && boardSpace[x][y-1].tile.b.edgeType != tile.t.edgeType){
			return false;
		}
		if(y != (NUM_TILES - 1) && boardSpace[x][y+1].hasTile && boardSpace[x][y+1].tile.t.edgeType != tile.b.edgeType){
			return false;
		}
		return true;
	}
	
	public String toString(){
	String a = "";
	for (int i = 0; i < NUM_TILES; i++){
		for (int j = 0; j < NUM_TILES; j++ ){
			if (boardSpace[j][i].hasTile != false){
				a += "# ";
			}
			else{
				a += "O ";
			}
		}
		a += "\n";
	}
	return a;
	}
}

