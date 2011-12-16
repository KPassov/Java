public class Game
{
    Board board;
    private Piece.Color currentColor = Piece.Color.WHITE;

    public Game()
    {
          board = new Board();
    }
    
    public void Game()
    {
        while(!board.gameOver()){
            
            if (currentColor == Piece.Color.WHITE)
                currentColor = Piece.Color.BLACK;
            else currentColor = Piece.Color.WHITE;
        }
    }
    
    public void restart () 
    { 
        currentColor = Piece.Color.WHITE;
        board = new Board();
    }

    public boolean tryMovePiece ( Position start , Position end ) 
    {
        return board.tryMovePiece(currentColor, start, end);
    }

}
