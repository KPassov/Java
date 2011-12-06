import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class nameArrayListTest
{
    private NameArrayList names;

    /**
     * Default constructor for test class NameArrayTest
     */
    
    public nameArrayListTest()
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
        names = new NameArrayList();
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
        names.addName( "Dovahkiin");
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
        names.addName( "");        
        assertEquals(true, names.isMember(""));        
    }
    
    @Test
    public void longStringisMemeber()
    {
        names.addName(                  "aasdjskadjlksdjljskldjsjsfsjlsjssdasjdljssdsakdjljsasdjaskdjskladjsdl");        
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
    public void getLongestIndexOfInitialise()
    {
        names.initialise();
        assertEquals(true, 2 == names.findIndexOfLongest());
    }
    
    @Test
    public void newLongestIndex()
    {
        names.initialise();
        names.addName("Dovahkiin");
        assertEquals(false, 2 == names.findIndexOfLongest());
        assertEquals(true, 6 == names.findIndexOfLongest());
    }
    
    @Test
    public void emptyStringLongestIndex()
    {
        names.addName("");
        assertEquals(true, 0 == names.findIndexOfLongest());
    }
    
    @Test
    public void firstIsLongest()
    {
        names.addName("Kasper");
        names.addName("Lydia");
        assertEquals(0, names.findIndexOfLongest());
    }
    
    @Test
    public void lastIsLongest()
    {
        names.addName("Lydia");
        names.addName("Kasper");
        names.addName("Bannanatimes");
        assertEquals(2, names.findIndexOfLongest());
    }
    
    
}
