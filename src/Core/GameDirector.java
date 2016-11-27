package Core;

import Board.*;
import Player.*;
import Server.*;
import UI.GameWindow;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;



/*
 * The purpose of GameDirector is facilitate high level game flow, such as turns, scoring, and player control 
 */
public class GameDirector {
	boolean endOfGame = false;
        
        public void run() throws InterruptedException{
            StartingInfo start = new StartingInfo();
            start.setVisible(true);
            while(!(start.confirmed)){
                TimeUnit.SECONDS.sleep(1);
            }
            ServerInterface server = new ServerInterface(start.getIP(), start.getPort(), start.getTPass(),
                                                         start.getUser(), start.getPass());
            start = null;
            //Tile tiles[] = server.getTileStack();
            Coordinates gameA = new Coordinates();
            Coordinates gameB = new Coordinates();
            gameA.addTile(71, 71, TileConvertor.serverStringToTile("TLTJ-")); //This puts the start tile on the board
            gameB.addTile(71, 71, TileConvertor.serverStringToTile("TLTJ-")); //This puts the start tile on the board
            
            AI player1 = new AI();
            int turn = 0;
            
        }
        
}
