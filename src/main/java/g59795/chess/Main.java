package g59795.chess;

import g59795.chess.controller.Controller;
import g59795.chess.model.Game;
import g59795.chess.model.Model;
import g59795.chess.model.Position;
import g59795.chess.view.TextView;
import g59795.chess.view.View;


public class Main {
    
    public static void main(String argv[]) {
        Model game = new Game();
        Controller controller = new Controller(game, new TextView(game));
        
        controller.play();
        
        // Defense
        /*
            Model game = new Game();
            game.start();
            View view = new TextView(game);
            Position[][] moves = {
                {new Position(1, 4), new Position(2, 4)},
                {new Position(6, 0), new Position(4, 0)},
                {new Position(0, 3), new Position(4, 7)},
                {new Position(7, 0), new Position(5, 0)},
                {new Position(4, 7), new Position(4, 0)},
                {new Position(6, 7), new Position(4, 7)},
                {new Position(1, 7), new Position(3, 7)},
                {new Position(5, 0), new Position(5, 7)},
                {new Position(4, 0), new Position(6, 2)},
                {new Position(6, 5), new Position(5, 5)},
                {new Position(6, 2), new Position(6, 3)},
                {new Position(7, 4), new Position(6, 5)},
                {new Position(6, 3), new Position(6, 1)},
                {new Position(7, 3), new Position(2, 3)},
                {new Position(6, 1), new Position(7, 1)},
                {new Position(2, 3), new Position(6, 7)},
                {new Position(7, 1), new Position(7, 2)},
                {new Position(6, 5), new Position(5, 6)},
                {new Position(7, 2), new Position(5, 4)}
            };
        
        for(Position[] move : moves) {
            game.movePiecePosition(move[0], move[1]); 
            view.displayBoard();
        }
        
        System.out.println(game.getState());
        */
    }
}
