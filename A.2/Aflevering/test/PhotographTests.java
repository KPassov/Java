import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PhotographTests
{
    private static final int NUMBER_OF_TESTS = 100;
    private static final int RANDOMNESS_MAGNITUDE = 100;
    
    private Random random;
    
    @Before
    public void initializeRandom()
    {
        this.random = new Random();
    }
    
    @Test
    public void emptyPhotographTest()
    {
        Photograph photograph = new Photograph(null);
        assertEquals(0, photograph.getHeight());
        assertEquals(0, photograph.getWidth());
        assertNull(photograph.getLine(0));
        assertNull(photograph.getLine(random.nextInt(PhotographTests.RANDOMNESS_MAGNITUDE)));
    }
    
    @Test
    public void scalarPhotographTest()
    {
        String row = this.randomRow(1);
        String[] actualPhotograph = new String[] { row };
        Photograph photograph = new Photograph(actualPhotograph);
        assertEquals(1, photograph.getHeight());
        assertEquals(1, photograph.getWidth());
        assertEquals(row, photograph.getLine(0));
        assertNull(photograph.getLine(random.nextInt(PhotographTests.RANDOMNESS_MAGNITUDE) + 1));
    }
    
    @Test
  public void rowPhotographTest()
  {
    String row = this.randomRow(random.nextInt(PhotographTests.RANDOMNESS_MAGNITUDE));
    String[] actualPhotograph = new String[] { row };
    Photograph photograph = new Photograph(actualPhotograph);
    assertEquals(1, photograph.getHeight());
    assertEquals(row.length(), photograph.getWidth());
    assertEquals(row, photograph.getLine(0));
    assertNull(photograph.getLine(random.nextInt(PhotographTests.RANDOMNESS_MAGNITUDE) + 1));
  }
    
    @Test
  public void columnPhotographTest()
  {
      int columns = random.nextInt(PhotographTests.RANDOMNESS_MAGNITUDE) + 2;
    
    String[] actualPhotograph = new String[columns];
    for (int i = 0; i < columns; ++i)
      actualPhotograph[i] = this.randomRow(1);
    
    Photograph photograph = new Photograph(actualPhotograph);
    assertEquals(columns, photograph.getHeight());
    assertEquals(1, photograph.getWidth());
    
    for (int i = 0; i < columns; ++i)
      assertEquals(actualPhotograph[i], photograph.getLine(i));  
    
    assertNull(photograph.getLine(random.nextInt(PhotographTests.RANDOMNESS_MAGNITUDE) + columns));
  }
    
    @Test
    public void runAFewPhotographTests()
    {
        for (int i = 0; i < PhotographTests.NUMBER_OF_TESTS; ++i)
        {
            GeneratedPhotograph generatedPhotograph = randomPhotograph();
            this.runAPhotographTest(generatedPhotograph);
        }
    }
    
    public void runAPhotographTest(GeneratedPhotograph generatedPhotograph)
    {
        Photograph photograph = new Photograph(generatedPhotograph.photograph);
        
        assertEquals(generatedPhotograph.height, photograph.getHeight());
        assertEquals(generatedPhotograph.width, photograph.getWidth());
        for (int i = 0; i < generatedPhotograph.photograph.length; ++i)
            assertEquals(generatedPhotograph.photograph[i], photograph.getLine(i));
    }
    
    private GeneratedPhotograph randomPhotograph()
    {
        GeneratedPhotograph generatedPhotograph = new GeneratedPhotograph();
        
        int width = this.random.nextInt(PhotographTests.RANDOMNESS_MAGNITUDE) + 2;
        int height = this.random.nextInt(PhotographTests.RANDOMNESS_MAGNITUDE) + 2;
        
        generatedPhotograph.width = width;
        generatedPhotograph.height = height;
        
        String[] photograph = new String[height];
        
        while (height-- != 0)
            photograph[height] = this.randomRow(width);
        
        generatedPhotograph.photograph = photograph;
        return generatedPhotograph;
    }
    
    private String randomRow(int width)
    {
        StringBuilder rowBuilder = new StringBuilder();
        while (width-- != 0)
            rowBuilder.append(this.randomChar());
        
        return rowBuilder.toString();
    }
    
    private char randomChar()
    {
        char value = (char)(this.random.nextInt(226) + 30);
        return value == '\n' ? this.randomChar() : value;
    }

    private class GeneratedPhotograph
    {
        public String[] photograph;
        public int width, height;
    }
}