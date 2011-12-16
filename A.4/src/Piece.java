import java.lang.String;

public abstract class Piece
{
    public enum Color {WHITE, BLACK}

    private Color color;
    
    public Piece (Color color)
    {
        this.color = color;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public String toString ()
    {
        return color.toString().substring(0, 0) + key();
    }
    
    public boolean isLegalMove(Position start, Position end, Board board)
    {
        if (end.getY() == start.getY() && end.getX() == start.getX()) //checks if start and end is the same position
            return false;
            
        if (end.getY() > 7 || end.getX() > 7 || 
            end.getY() < 0 || end.getX() < 0) // checks if end is outside the board
            return false;
            
        return (board.getPiece(end) == null || 
                board.getPiece(end).getColor() != board.getPiece(start).getColor()); // checks if the space is empty or a friendly piece is standing there
    }
    
    /**
     * Either P, R, N, B, Q, or K.
     */
    public abstract char key();
}
