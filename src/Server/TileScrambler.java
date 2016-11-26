package Server;

//This class gives a random set of tiles as a string for testing purposes.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TileScrambler {
    public static final int TILE_TYPES = 28;
    ArrayList<String> tiles;
    int[] numberOfEach;
    String[] tileTypes;
    
    public TileScrambler(){
       tileTypes = new String[] {"JJJJ-","JJJJX","JJTJX","TTTT-","TJTJ-","TJJT-","TJTT-","LLLL-",
                                 "JLLL-","LLJJ-","JLJL-","LJLJ-","LJJJ-","JLLJ-","TLJT-","TLJTP",
                                "JLTT-","JLTTB","TLTJ-","TLTJD","TLLL-","TLTT-","TLTTP","TLLT-",
                                "TLLTB","LJTJ-","LJTJD","TLLLC",};
       
       numberOfEach = new int[] {1,4,2,1,8,9,4,1,4,5,3,3,5,2,1,2,1,2,2,2,1,1,2,3,2,1,2,2};
       tiles = new ArrayList();
       
       for(int i = 0; i < TILE_TYPES; i++) {
           for(int j = 0; j < numberOfEach[i]; j++){
               tiles.add(tileTypes[i]);
           }
       }
       
       Collections.shuffle(tiles);
    }
    
    

    public String getTileString() {
       String result = "";
       String[] tileTemp = tiles.toArray(new String[tiles.size()]);
       for(int i = 0; i < tileTemp.length; i++) {
           result += tileTemp[i] + " ";
       }
       return result;
    }
    
}
