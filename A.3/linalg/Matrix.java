import java.lang.Math;

public class Matrix
{
    /*
    private int[][] matrix;
    private int heigth;
    
    public Matrix(int m, int n, int value)
    {
        heigth = m;
        matrix = new int[m][];
        int i = 0;
        int j = 0;
        while(i < n){
            int[] row = new int[n];
            row[i] = value;
            matrix[j] = row;
            i++;
            j++;
        }
    }
    
    public int[] getRow(int index)
    {
        if (matrix[index] != null)
            return matrix[index];
        return null;
    }
    
    public int[] getColoumn(int index)
    {
        int[] coloumn = new int[heigth];
        if (index <= heigth){
            int i = 0;
            for (int[] row : matrix)
            {
                coloumn[i] = row[index];
            } 
        }
        return coloumn;
    }

    Jeg har lavet en metode der kan håndtere ikke kvadratiske matricer, arrays i arrays gjenere dog bluej gevaltigt så jeg 
    har udkommenteret den, er ret stolt af den så havde ikke lyst til at fjerne den.    
    */

    private int[] matrix;
    private int size;
    
    public Matrix(int size, int value)
    {
        matrix = new int[size * size];
        this.size = size;
        int i = 0;
        while (i < size * size){
            matrix[i] = value;
            i += size + 1;
        }
    }
    
    public Matrix(int size, int[] values)
    {
        matrix = new int[size * size];
        if (values.length == matrix.length){
            matrix = values;
        }
    }
    
    public int[] getRow(int index)
    {
        int[] array = new int[size];
        if (index <= size){
            int i = index * size;
            int j = 0;
            while (j < size){
                array[j] = matrix[i];
                i++; j++;
            }
        }
        return array;
    }
    
    public int[] getColoumn(int index)
    {
        int[] array = new int[size];
        if (index <= size){
            int i = index;
            int j = 0;
            while (j < size){
                array[j] = matrix[i];
                j++;
                i += size;
            }
        }
        return array;
    }
}
