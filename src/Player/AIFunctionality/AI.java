package Player.AIFunctionality;
import java.util.List;

import Player.*;
import Board.*;


public class AI extends Player {
	public BoardSpace makeNextMove(Tile[] tiles, Coordinates coor, BoardSpace[] validSpaces) {
		int numMoves = tiles.length;
		if (tiles.isEmpty()) {
			if (tigers > 0) {
				// check finished lakes for 1 opponent meeple and 1 owned meeple
				// place a meeple
				//else check roads place meeple there
			}
			else
				//pass
		} 
		else if (numMoves == 1) {
			if(tile[0].middleFeature==8){
				// return single move w/ tiger
			}
			else
			// return single move
		} 
		else {// numMoves is numerous and must be chosen carefully
			if(tile[0].middleFeature==8){//if tile has a den
				//count number of adjacent tiles for each valid space, return legal move with most adjacent tiles
			}
			else if(tile[0].l==1||tile[0].r==1||tile[0].t==1||tile[0].b==1){//priority1:lakes if tile has lake 
					//look for unfinished lake w/o opponent tiger or croc
					
			}
			else if(tile[0].l==3||tile[0].r==3||tile[0].t==3||tile[0].b==3){//priority2:game trails if tile has lake 
					//look for unfinished game trail w/o opponent tiger or croc
					
			}
			else if(tile[0].l==2||tile[0].r==2||tile[0].t==2||tile[0].b==2){//priority3:jungles if tile has jungle 
					//look for unfinished w/o opponent tiger or croc
					
			}
		//priority==dens(while up), lakes,  game trails, jungles
		//finish the unfinished->start new 
		}
	}
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
