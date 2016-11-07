package Player.AIFunctionality;
import java.util.List;

import Player.*;
import Board.*;


public class AI extends Player {

	/*
	 * Ideas:
	 * 
	 * 1. use a breadth first search to search from each tile, through nearby BoardSpaces, to other tiles, 
	 * to find potential "connections" that are worth many points 
	 * 
	 * 2. use remaining tiles to determine whether a road/city is "closeable", meaning there are enough tiles of the
	 * correct type to close off
	 * 
	 * 3. use stored meeple count as a variable to affect decision making
	 * 
	 * 4. watch farms with adjacent cities so you know where to place farmers
	 * 
	 * 5. if there are more than 2 players, calculate whether it's possible for you to tie with the existing amount of meeples
	 *
	 * 6. Learn how to disable enemy meeples (i.e. place Tiles in a way such that
	 * 
	 * 7. do occasional random shit to disarm enemy AIs
	 */
	
	List<PotentialConnection> potentialConnections;
	
	/*
	 * if recently placed tile is within 3 tiles of any existing potential connection, 
     * update potential connection
     * 
     * @author Jason Owens
     * @param Tile recently placed tile
	 */
	public void updatePotentialConnections(Tile t){
		
	}
}
