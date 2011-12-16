import java.lang.Math;

public class King extends Piece
{
    public King(Color color)
    {
        super(color);
    }

    public boolean isLegalMove(Position start, Position end, Board board)
    {
        if (!super.isLegalMove(start, end, board))
            return false;
        int xDif, yDif;
        xDif = Math.abs(start.getX() - end.getX());
        yDif = Math.abs(start.getY() - end.getY());
        if (!(0 == xDif || xDif == 1 &&
              0 == yDif || yDif == 1)) //checks if the move is a legal move for a King 
             return false;
        return true;
    }
 
    
    public char key()
    {
        return 'K';
    }
}
