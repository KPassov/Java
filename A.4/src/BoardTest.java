import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest
{
    Board board;
    public BoardTest()
    {
    }

    @Before
    public void setUp()
    {
        board = new Board();
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testPosition()
    {
        Position start = Position.fromRepresentation("B2");
        Position end = Position.fromRepresentation("B4");
        assertEquals(start.getX() == 1 && start.getY() == 1, true);
        assertEquals(end.getX() == 1 && end.getY() == 3, true);
    }
    
    @Test
    public void testIsLegalMove()
    {
        Position start = Position.fromRepresentation("B2");
        Position end = Position.fromRepresentation("B4");
        
        assertEquals(board.tryMovePiece(Piece.Color.BLACK, start, end), false);//tries to move a opponents piece
        assertEquals(board.tryMovePiece(Piece.Color.WHITE, start, end), true);//moves own piece
        assertEquals(board.tryMovePiece(Piece.Color.WHITE, end, start), false);//tries to move pawn back
    }

}
