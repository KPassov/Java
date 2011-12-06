import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NameArrayTest.
 *
 * @author  Ole Monrad
 * @version 2011.11.15
 */
public class NameArrayTest
{
    private NameArray names;

    /**
     * Default constructor for test class NameArrayTest
     */
    public NameArrayTest()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        names = new NameArray();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void nameFound()
    {
        names.initialise();
        assertEquals(3, names.getIndexOf("Oleks"));
    }

    @Test
    public void nameNotFound()
    {
        names.initialise();
        assertEquals(-1, names.getIndexOf("Peter"));
    }

    @Test
    public void findFirstName()
    {
        names.initialise();
        assertEquals(0, names.getIndexOf("Knud"));
    }

    @Test
    public void findLastName()
    {
        names.initialise();
        assertEquals(5, names.getIndexOf("Jeppe"));
    }

    @Test
    public void noNames()
    {
        assertEquals(-1, names.getIndexOf("Knud"));
    }

    @Test
    public void duplicateName()
    {
        names.initialiseDuplicates();
        assertEquals(1, names.getIndexOf("Jeppe"));
        assertEquals(false, 5 == names.getIndexOf("Jeppe"));
    }
    
    @Test
    public void sparseNames()
    {
        names.addName(1, "Anna");  names.addName(4, "Karen");
        names.addName(2, "Carla"); names.addName(5, "Ulla");
        assertEquals(-1, names.getIndexOf("Bente"));
        assertEquals(1, names.getIndexOf("Anna"));
        assertEquals(4, names.getIndexOf("Karen"));
        assertEquals(5, names.getIndexOf("Ulla"));
    }    

    @Test
    public void sparseNamesWithArrayLiteral()
    {
        String[] arrayLiteral =
            { null, "Anna", "Carla", null, "Karen", "Ulla" };
        for (int i = 0; i < arrayLiteral.length; i++) {
            if (arrayLiteral[i] != null) {
                names.addName(i, arrayLiteral[i]);
            }
        }
        assertEquals(-1, names.getIndexOf("Bente"));
        assertEquals(1, names.getIndexOf("Anna"));
        assertEquals(4, names.getIndexOf("Karen"));
        assertEquals(5, names.getIndexOf("Ulla"));
    }
    
    @Test
    public void firstIsMember()
    {
        names.initialise();
        assertEquals(true, names.isMember("Knud"));
    }
    
    @Test
    public void lastIsMember()
    {
        names.initialise();
        assertEquals(true, names.isMember("Jeppe"));        
    }
    
    @Test
    public void middleIsMember()
    {
        names.initialise();
        assertEquals(true, names.isMember("Ole"));        
    }
    
    @Test
    public void newIsMember()
    {
        names.initialise();
        names.addName(5, "Dovahkiin");
        assertEquals(true, names.isMember("Dovahkiin"));
    }
    
    @Test
    public void isNotMember()
    {
        names.initialise();
        assertEquals(false, names.isMember("Kirstine"));
    }

    @Test
    public void emptryStringIsMember()
    {
        names.addName(1, "");        
        assertEquals(true, names.isMember(""));        
    }
    
    @Test
    public void longStringisMemeber()
    {
        names.addName(1,                  "aasdjskadjlksdjljskldjsjsfsjlsjssdasjdljssdsakdjljsasdjaskdjskladjsdl");        
        assertEquals(true, names.isMember("aasdjskadjlksdjljskldjsjsfsjlsjssdasjdljssdsakdjljsasdjaskdjskladjsdl"));
    }
    
    @Test
    public void isMemberEmpty()
    {
        assertEquals(false, names.isMember("Knud"));
    }
    
    @Test
    public void isMemberDublicate()
    {
        names.initialiseDuplicates();
        assertEquals(true, names.isMember("Jeppe"));
    }
    
    @Test
    public void nullStringisMemeber()
    {
        names.addName(1,null);
        names.addName(2,                  "aasdjskadjlksdjljskldjsjsfsjlsjssdasjdljssdsakdjljsasdjaskdjskladjsdl");        
        assertEquals(true, names.isMember("aasdjskadjlksdjljskldjsjsfsjlsjssdasjdljssdsakdjljsasdjaskdjskladjsdl"));
    }
    
    @Test
    public void getLongestIndexOfInitialise()
    {
        names.initialise();
        assertEquals(true, 2 == names.findIndexOfLongest());
    }
    
    @Test
    public void newLongestIndex()
    {
        names.initialise();
        names.addName(5, "Dovahkiin");
        assertEquals(false, 2 == names.findIndexOfLongest());
        assertEquals(true, 5 == names.findIndexOfLongest());
    }
    
    @Test
    public void emptyStringLongestIndex()
    {
        names.addName(0, "");
        assertEquals(true, 0 == names.findIndexOfLongest());
    }
    
}










