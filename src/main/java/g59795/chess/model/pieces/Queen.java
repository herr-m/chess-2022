/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Direction;
import g59795.chess.model.Position;
import java.util.List;

/**
 * Reoresentation d'une reine.
 */
public class Queen extends Piece {

    /**
     * Construit une reine de couleur color.
     * @param color : couleur de la reine
     */
    public Queen(Color color) { super(color); }
    
    /**
     * Renvoie une liste de position de déplacements possibles pour une reine.
     * @param position : La position de la reine
     * @param board : Le plateau
     * @return La liste de positions de déplacements possibles.
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        return getLineMoves(position, board, Direction.values());
    }
    
}
