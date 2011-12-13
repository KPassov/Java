import java.lang.String;

public abstract class Piece
{
    public enum Color {WHITE, BLACK}
    public enum Type {P, R, N, B, Q, K}

    private Type type;
    private Color color;
    
    public Piece (Color color, Type type)
    {
        this.type = type;
        this.color = color;
    }
    
    public String toString ()
    {
        return color.toString().substring(0, 0) + type;
    }
    /**
     * Either P, R, N, B, Q, or K.
     */
    public abstract char key();
}
