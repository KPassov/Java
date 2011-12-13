public class Position
{
    private final byte x, y;

    private Position(byte x, byte y)
    {
        this.x = x;
        this.y = y;
    }


    /**
     * @null if the representation is invalid.
     */
    public static Position fromRepresentation(String representation)
    {
        if (representation.length() != 2)
        {
            return null;
        }

        char[] elements = representation.toCharArray();

        boolean letterIsOutOfBounds = elements[0] < 'A' || elements [0] > 'H';
        boolean numberIsOutOfBounds = elements[1] < '1' || elements [1] > '8';

        if (letterIsOutOfBounds || numberIsOutOfBounds)
        {
            return null;
        }

        byte x = (byte)((elements[0]) - 65);
        byte y = (byte)((elements[1]) - 49);

        return new Position(x, y);
    }

    /**
     * @true if the x and y coordinates are equal.
     */
    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Position))
        {
            return false;
        }

        Position position = (Position)other;

        return position.x == this.x && position.y == this.y;
    }

    /**
     * x * 8 + y
     */
    @Override
    public int hashCode()
    {
        return (this.x << 3) + this.y;
    }
}
