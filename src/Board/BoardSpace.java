/*
 * BoardSpaces can contain tiles
 */
public class BoardSpace {

	private Tile myTile;//default is null
	
	public Tile getTile(){
		if(myTile)
			return myTile;
		else
			return null;
	}
}
