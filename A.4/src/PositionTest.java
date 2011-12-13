import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PositionTest
{
    private Random random;

    private static final int NUMBER_OF_INVALID_POSITION_TESTS = 20;

    @Before
    public void initializeRandom()
    {
        this.random = new Random();
    }

    @Test
    public void testAllValidPositions()
    {
        for (char i = 'A'; i < 'I'; ++i)
        {
            for (char j = '1'; j < '8'; ++j)
            {
                this.representationTest(Character.toString(i) + j, i - 'A', j - '1');
            }
        }
    }

    private void representationTest(String representation, int expectedX, int expectedY)
    {
        Position position = Position.fromRepresentation(representation);
        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
    }

    @Test
    public void testManyRandomInvalidPositions()
    {
        for (int i = 0; i < NUMBER_OF_INVALID_POSITION_TESTS; ++i)
        {
            this.testRandomInvalidPosition();
        }
    }

    private void testRandomInvalidPosition()
    {
        char i = randomChar('A', 'H');
        char j = randomChar('1', '8');
        Position position = Position.fromRepresentation(Character.toString(i) + j);
        assertNull(position);
    }

    private char randomChar(char startInvalidRange, char endInvalidRange)
    {
        char randomChar;
        do
        {
            randomChar = (char)this.random.nextInt(256);
        }
        while(randomChar >= startInvalidRange && randomChar <= endInvalidRange);
        return randomChar;
    }
}