package g59795.chess.model;

import g59795.chess.model.pieces.Piece;
import java.util.List;

/**
 *
 * @author srexhep
 */
public interface Model {
    
    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    public void start();

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos  is not located on the board.
     */
    public Piece getPiece(Position pos);

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    public Player getCurrentPlayer();

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    public Player getOppositePlayer();

    /**
     * Check if the square at the given position is occupied
     * by a piece of the current player.
     *
     * @param pos the position
     * @return true if the position is occupied by a piece
     * of the current player, false otherwise.
     * @throws IllegalArgumentException if the position is not located on the board.
     */
    public boolean isCurrentPlayerPosition(Position pos);

    /**
     * Moves a piece from one position of the chess board to
     * another one. If the game is not over, change
     * the current player.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if
     *                                  1) oldPos or newPos are not located on the board, or
     *                                  2) oldPos does not contain a piece, or
     *                                  3) the piece does not belong to the current player, or
     *                                  4) the move is not valid for the piece located at position oldPos                                 
     */
    public void movePiecePosition(Position oldPos, Position newPos);

    /**
     * Get the possible moves for the piece located at
     * the specified position.
     *
     * @param position the position of the piece
     * @return the list of admissible positions.
     */
    public List<Position> getPossibleMoves(Position position);
    
    /**
     * Check if the given move is valid.
     *
     * @param oldPos : old position of the move
     * @param newPos : new position of the move
     * @return true if the move is valid, false otherwise
     * @throws IllegalArgumentException if the move is not possible.
     */
    public boolean isMoveValid(Position oldPos, Position newPos);
    
    /**
     * Getter for the game state.
     * 
     * @return the state of the game
     */
    public GameState getState();
}
