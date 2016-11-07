import java.util.List;

/*
 * Player is the parent class of the AI and Human 
 * 
 * @author Jason Owens
 */
public abstract class Player {
	
	protected List<BoardSpace> getFreeBoardSpaces(){
		//get from Game Director?
	}
	protected Tile getNextTile(){
		//request Tile from GameDirector
	}
}
