import java.util.HashMap;

public class Program
{
    private HashMap<String, Matrix> matrices = new HashMap<String, Matrix>();

    public static void main(String[] args)
    {
    }

    public Matrix createMatrix(String matrixName, int size, int value)
    {
        return matrices.put(matrixName,new Matrix(size,value));
    }
    
    public Matrix createMatrix(String matrixName, int size, int[] values)
    {
        return matrices.put(matrixName,new Matrix(size,values));
    }
    
    public Matrix removeMatrix(String matrixName)
    {
        return matrices.remove(matrixName);
    }
    
    public Matrix getMatrix(String matrixName)
    {
        return matrices.get(matrixName);
    }
    
    public void printMatrix(String matrixName)
    {
    
    }
    
    public Program()
    {
    }
}
