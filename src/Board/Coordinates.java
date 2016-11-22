public class Coordinates {
	int numTiles = 144;

	public Tiles[][] boardSpace = new Tiles[numTiles][numTiles];
	public Coordinates(){
		
	}
	public void addTile(int x, int y, Tiles tile){
		boardSpace[x][y] = tile;
		return;
	}
	public void addTile(Tiles tile){
		boardSpace[tile.x][tile.y] = tile;
		return;
	}
	
	// Looks at every tile adjacent to input tile and location to see if it is valid. 
	public boolean checkValidMove(int x, int y, Tiles tile){ 
		if (boardSpace[x][y] != null){
			System.out.println("There is already a tile here");
			return false;
		}
		if(x != 0 && boardSpace[x-1][y] != null && boardSpace[x-1][y].r.edgeType != tile.l.edgeType){
			return false;
		}
		if(x != (numTiles-1) && boardSpace[x+1][y] != null && boardSpace[x+1][y].l.edgeType != tile.r.edgeType){
			return false;
		}
		if(y != 0 && boardSpace[x][y-1] != null && boardSpace[x][y-1].b.edgeType != tile.t.edgeType){
			return false;
		}
		if(y != (numTiles-1) && boardSpace[x][y+1] != null && boardSpace[x][y+1].t.edgeType != tile.b.edgeType){
			return false;
		}
		return true;
	}
	
	public String toString(){
	String a = "";
	for (int i = 0; i < numTiles; i++){
		for (int j = 0; j < numTiles; j++ ){
			if (boardSpace[j][i]!=null){
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
