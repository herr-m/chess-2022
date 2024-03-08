/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g59795.chess;

import g59795.chess.model.Game;
import g59795.chess.model.Model;
import g59795.chess.model.Position;
import g59795.chess.view.TextView;
import g59795.chess.view.View;

/**
 *
 * @author mk
 */
public class Defense {
    public static void main(String argv[]) {
        Model game = new Game();
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
    }
}
