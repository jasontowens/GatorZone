package Board;

import java.util.ArrayList;

public class Coordinates {
	private static final int NUM_TILES = 144;
        private static final int CENTER = 71;
        private ArrayList<BoardSpace> outerSpaces;
        private ArrayList<BoardSpace> placedSpaces;
	public BoardSpace[][] boardSpace = new BoardSpace[NUM_TILES][NUM_TILES];
        
        public Coordinates(){
            for (int i = 0; i < NUM_TILES; i++) {
                for (int j = 0; j < NUM_TILES; j++) {
                    boardSpace[i][j] = new BoardSpace();
                    boardSpace[i][j].x = i;
                    boardSpace[i][j].y = j;
                }
            }
	}
        
        public BoardSpace top(BoardSpace space){
            return boardSpace[space.x][space.y+1];
        }
        
        public BoardSpace bottom(BoardSpace space){
            return boardSpace[space.x][space.y-1];
        }
        
        public BoardSpace left(BoardSpace space){
            return boardSpace[space.x-1][space.y];
        }
        
        public BoardSpace right(BoardSpace space){
            return boardSpace[space.x+1][space.y];
        }
        
	public void addTile(int x, int y, Tile tile){
                if(validMove(x, y, tile))
                    boardSpace[x][y].addTile(tile);
                else
                    System.out.println("Invalid placement location");
                placedSpaces.add(boardSpace[x][y]);
        }
	
	//Returns Validity of "All, 0, 90, 180, 270" Rotations (If result[0] is true, one or more rotations are valid)
	public boolean[] checkAllRotations(int x, int y, Tile tile){ 
            boolean[] result = {false, false, false, false, false};
            for(int i = 1; i < 5; i++) {
                if ( validMove (x, y, tile) ) {
                    result[0] = true;
                    result[i] = true;
                }
                tile.rotate();
            }
            tile.rotate();
            return result;
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

        public void updateOuterSpaces() {
            for(int i = 0; i < placedSpaces.size(); i++) {//Checks For Blanks Around Already Placed Tiles
                if(!top(placedSpaces.get(i)).hasTile){
                    outerSpaces.add(top(placedSpaces.get(i)));
                }
                if(!bottom(placedSpaces.get(i)).hasTile){
                    outerSpaces.add(bottom(placedSpaces.get(i)));
                }
                if(!left(placedSpaces.get(i)).hasTile){
                    outerSpaces.add(left(placedSpaces.get(i)));
                }
                if(!right(placedSpaces.get(i)).hasTile){
                    outerSpaces.add(right(placedSpaces.get(i)));
                }
            }
        }
    
        public ArrayList<BoardSpace> getValidSpaces(Tile tile) {
            updateOuterSpaces();
            ArrayList<BoardSpace> valid = null;
            for(int i = 0; i < outerSpaces.size(); i++) {
                for(int j = 0; j < 4; j++) {
                    if(validMove(outerSpaces.get(i).x, outerSpaces.get(i).y, tile)) {
                        valid.add(outerSpaces.get(i));
                        break;
                    }
                    tile.rotate();
                }
            }
            return valid;
        }
        
        public void printBoard(){
            for (int i = 0; i < NUM_TILES; i++){
 		for (int j = 0; j < NUM_TILES; j++ ){
 			if (boardSpace[j][i].hasTile != false){
 				System.out.print("# ");
 			}
 			else{
 				System.out.print("O ");
 			}
 		}
            System.out.println();
            }
        }
}
