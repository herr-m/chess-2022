package g59795.chess.model;

import g59795.chess.model.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * Représentation d'un plateau d'échecs.
 */
public class Board {
    private final  Square[][] squares;
    
    /**
     * Construit les 64 cases (vides) du plateau.
     */
    public Board() { 
        squares = new Square[8][8]; 
        for(int i=0;i<squares.length;++i)
            for(int j=0;j<squares[0].length;++j)
                squares[i][j] = new Square(null);
    }

    /**
     * Verifie si la position donée existe sur le plateau.
     * @param pos : La position
     * @return true si la position existe, false sinon
     */
    public boolean contains(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < squares.length &&
               pos.getColumn() >= 0 && pos.getColumn() < squares[0].length;
    }

    /**
     * Place la pièce dans la case à la position donée.
     * @param piece : La pièce à placer
     * @param position : La position
     */
    public void setPiece(Piece piece, Position position) {
        if(!contains(position))
            throw new IllegalArgumentException("Cette position n'existe pas");
        
        squares[position.getRow()][position.getColumn()].setPiece(piece);
    }

    /**
     * Renvoie la pièce dans la case à la position donée.
     * @param position : La position
     * @return La pièce dans la case.
     */
    public Piece getPiece(Position position) {
        if(!contains(position))
            throw new IllegalArgumentException("Cette position n'existe pas");
        
        return squares[position.getRow()][position.getColumn()].getPiece();
    }

    /**
     * Renvoie la ligne de départ des pieces de la couleur donée.
     * @param color : La couleur
     * @return 1 pour blanc, 6 pour noir
     */
    public int getInitialPawnRow(Color color) 
        { return color == Color.WHITE ? 1 : 6; }

    /**
     * Enlève la pièce de la case à la position donée.
     * @param pos : La position
     */
    public void dropPiece(Position pos) {
        if(!contains(pos))
            throw new IllegalArgumentException("Cette position n'existe pas");
        
        squares[pos.getRow()][pos.getColumn()].setPiece(null);
    }

    /**
     * Vérifie si la case à la position donée est vide.
     * @param pos : La position
     * @return true si la case est vide, false sinon
     */
    public boolean isFree(Position pos) {
        if(!contains(pos))
            throw new IllegalArgumentException("Cette position n'existe pas");
        
        return squares[pos.getRow()][pos.getColumn()].isFree();
    }

    /**
     * Vérifie si la case à la position donnée est occupée par une pièce de 
     * la couleur opposée.
     * @param pos : La position
     * @param col : La couleur
     * @return true si la case est occupée par une pièce de couleur opposée, 
     * false sinon ou si la case est vide
     */
    public boolean containsOppositeColor(Position pos, Color col) {
        if(!contains(pos))
            throw new IllegalArgumentException("Cette position n'existe pas");
        if(squares[pos.getRow()][pos.getColumn()].isFree())
            return false;
        
        return col.opposite() == squares[pos.getRow()][pos.getColumn()].getPiece().getColor();
    }

    /**
     * Renvoie une liste de positions des pièces du joueur donné.
     * @param player : Le joueur
     * @return Liste de position
     */
    public List<Position> getPositionsOccupiedBy(Player player) {
        List result = new ArrayList<Position>();
        for(int row=0; row<squares.length; ++row) {
            for(int col=0; col<squares[0].length; ++col) {
                if(!squares[row][col].isFree())
                    if(squares[row][col].getPiece().getColor() == player.getColor())
                        result.add(new Position(row, col));
            }
        }
        
        return result;
    }
    
    /**
     * Renvoie la position de la pièce donnée en paramètre..
     * @param piece : La pièce
     * @return La position de la pièce si la piece se trouve sur le plateau, sinon null
     */
    public Position getPiecePosition (Piece piece) {
        for(int row=0; row<squares.length; ++row) {
            for(int col=0; col<squares[0].length; ++col) {
                if(!squares[row][col].isFree() && squares[row][col].getPiece() == piece)
                    return new Position(row, col);
            }
        }
        
        return null;
    }
 }
