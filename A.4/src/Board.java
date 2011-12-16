public class Board 
{
    private Piece[][] board = new Piece[7][7];
    Color color;
    
    public Board()
    {
        initialize();
    }

    private void initialize () 
    {
        color = WHITE;
        int i = 0;
        for (Piece p : board[1]){
            board[1][i] = new Pawn(color);
            i++;}
        board[0][4] = new King(color);
            
        color = BLACK;   
        int i = 0;
        for (Piece p : board[6]){
          board[6][i] = new Pawn(color);
          i++;}  
        board[7][4] = new King(color);
    }
    
    public Piece getPiece(Position position)
    {
        return board[position.getY()][position.getX()];
    }
    
    public boolean allPositionsAreEmpty ( Position [] positions )
    {
        for (Position p : positions)
            {
                if (getPiece(p) != null){
                    return false;}
            }
        return true;
    }
}

