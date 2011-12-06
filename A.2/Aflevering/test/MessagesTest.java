import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessagesTest
{
    Person person;
    public MessagesTest()
    {
    }

    @Before
    public void setUp()
    {
        person = new Person("Kasper");
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void createMessage()
    {
        String s = "This is a message";
        Messages message = new Messages(person,s);
        assertEquals(message.getBody() == s, true);
        assertEquals(message.getBody() == "other string", false);
        assertEquals(message.getAuthor() == person, true);
        assertEquals(message.getAuthor() == new Person("OtherPerson"), false);
    }
    
    @Test
    public void nullMessage()
    {
        Messages message = new Messages(null, null);
        assertEquals(message.getBody() == null, true);
        assertEquals(message.getAuthor() == null, true);
    }
}
