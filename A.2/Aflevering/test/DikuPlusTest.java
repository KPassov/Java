

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DikuPlusTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DikuPlusTest
{
    DikuPlus dikuPlus;
    public DikuPlusTest()
    {
    }

    @Before
    public void setUp()
    {
        dikuPlus = new DikuPlus();        
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void addPerson()
    {
        Person kasper = new Person("Kasper");
        Person jens = new Person("Jens");
        
        dikuPlus.addPerson(kasper);
        
        assertEquals(dikuPlus.network.contains(kasper),true);
        assertEquals(dikuPlus.network.contains(jens),false);
    }
    
    @Test
    public void deletePerson()
    {
        Person kasper = new Person("Kasper");
        
        assertEquals(dikuPlus.network.contains(kasper),false);
        dikuPlus.addPerson(kasper);
        System.out.println("1");
        assertEquals(dikuPlus.network.contains(kasper),true);
        dikuPlus.removePersonWithName("Jens");
        System.out.println("1");
        assertEquals(dikuPlus.network.contains(kasper),true);
        dikuPlus.removePersonWithName("Kasper");
        System.out.println("1");
        assertEquals(dikuPlus.network.contains(kasper),false);
    }

}
