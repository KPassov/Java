import java.lang.Math;

public class Pawn extends Piece
{
    private boolean hasNotMoved = true;
    
    public Pawn(Color color)
    {
        super(color);
    }

    public boolean isLegalMove(Position start, Position end, Board board)
    {
        if (!super.isLegalMove(start, end, board))
            return false;
            
        int xDif, yDif;
        
        xDif = Math.abs(start.getX() - end.getX()); 
        
        if (board.getPiece(start).getColor() == Piece.Color.WHITE)
            yDif = end.getY() - start.getY(); // i do not take the absolute value as a pawn will never move backwards
        else
            yDif = start.getY() - end.getY();
            
        if (hasNotMoved && yDif == 2){
            return true;}    //can move 2 forward on the pawns first move
        
        if (xDif == 1 && yDif == 1 && //the move is diagonally
            board.getPiece(end) != null && // the end position is occupied
            getColor() != board.getPiece(end).getColor()) // it's occupied by an enermy piece
                return true; 
             
        //To DO
        //The En passant move as descriped here "http://en.wikipedia.org/wiki/En_passant"
        
                
        return (yDif == 1 && board.getPiece(end) == null); //normal 1 forward move
    }
 
    
    public char key()
    {
        return 'P';
    }
}
