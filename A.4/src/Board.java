import java.lang.StringBuilder;

public class Board 
{
    private Piece[][] board = new Piece[8][8];
    
    public Board()
    {
        initialize();        
    }
    
    public String humanReadableState () 
    { 
        StringBuilder builder = new StringBuilder ();
        for (Piece[] pieceArray : board){
            for (Piece piece : pieceArray){
                if (piece != null)
                    builder.append(" " + piece.toString());
                else
                    builder.append(" OO");
            }
            builder.append("\n");
        }
        String result = builder.toString();
        System.out.println(result);
        return result;
    }

    private void initialize () 
    {
        int i = 0;
        for (Piece p : board[1]){
            board[1][i] = new Pawn(Piece.Color.WHITE);
            i++;}
        board[0][4] = new King(Piece.Color.WHITE);
            
        i = 0;
        for (Piece p : board[6]){
          board[6][i] = new Pawn(Piece.Color.BLACK);
          i++;}  
        board[7][4] = new King(Piece.Color.BLACK);
    }
    
    public Piece getPiece(Position position)
    {
        return board[position.getY()][position.getX()];
    }
    
    public boolean allPositionsAreEmpty ( Position [] positions )
    {
        for (Position p : positions)
            {
                if (getPiece(p) != null)
                    return false;
            }
        return true;
    }
    
    public boolean gameOver()
    {
        int twoKings = 0;
        for (Piece[] pieceArray : board){
            for (Piece piece : pieceArray){
                if (piece != null && piece.key() == 'K')
                    twoKings++;
            }
        }
        return twoKings != 2;
    }
    
    public boolean tryMovePiece ( Piece.Color playerColor , Position start , Position end ) 
    {
        if (getPiece(start) != null && 
                (gameOver() || getPiece(start).getColor() != playerColor || 
                !getPiece(start).isLegalMove(start, end, this)))
            return false;
        board[end.getY()][end.getX()] = board[start.getY()][start.getX()];
        board[start.getY()][start.getX()] = null;
        return true;
    }

}

