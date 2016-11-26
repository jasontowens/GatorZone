package Core;

import Board.BoardSpace;
import Board.Coordinates;
import Board.Tile;
import Player.AIFunctionality.AI;
import Player.Player;
import Server.ServerInterface;
import UI.GameWindow;



/*
 * The purpose of GameDirector is facilitate high level game flow, such as turns, scoring, and player control 
 */
public class GameDirector {
	boolean endOfGame = false;
        
        public void run(){
            GameWindow window = new GameWindow();
            ServerInterface server = new ServerInterface();
            Tile tiles[] = server.getTileStack();
            Coordinates gameA = new Coordinates();
            Coordinates gameB = new Coordinates();
            gameA.addTile(71, 71, TileConvertor.serverStringToTile("TLTJ-")); //This puts the start tile on the board
            gameB.addTile(71, 71, TileConvertor.serverStringToTile("TLTJ-")); //This puts the start tile on the board
            
            AI player1 = new AI();
            int turn = 0;
            while(!endOfGame) {
                BoardSpace[] validSpaces = gameA.getValidSpaces(tiles[turn]);
                player1.makeNextMove(tiles, gameA, validSpaces);
                turn++;
                endOfGame = true;
            }
            
        }
        
}
