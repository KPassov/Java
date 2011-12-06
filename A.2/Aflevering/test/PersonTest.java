import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest
{
    Person[] person;
    Messages[] messages;
    public PersonTest()
    {
    }

    @Before
    public void setUp()
    {
        person = new Person[3];
        person[0] = new Person("Kasper");
        person[1] = new Person("Erik");
        person[2] = new Person("Oleks");
    }

    @After
    public void tearDown()
    {
    }
    
    private void makeFriends()
    {
        person[0].requestFriendship(person[1]);
        person[2].requestFriendship(person[0]);
        person[2].requestFriendship(person[1]);
    }

    @Test
    public void testNamePerson()
    {
        assertEquals(person[0].getName().equals("Kasper"),true);
        assertEquals(person[1].getName().equals("Jens"), false);
        assertEquals(person[2].getName().equals("Oleks"),true);
    }
    
    @Test
    public void testPhotographPerson()
    {
        String[] strings = new String[4];
        strings[0]="_O/   ";
        strings[1]="  \\   ";
        strings[2]="  /\\_ ";
        strings[3]="  \\   ";
        Photograph photo = new Photograph(strings);
        assertEquals(person[0].getPhoto() == null, true);
        person[0].changePhoto(photo);
        assertEquals(person[0].getPhoto() == photo, true);
        assertEquals(person[0].getPhoto().getLine(3).equals("  \\   "), true);
        assertEquals(person[0].getPhoto().getLine(2).equals("  \\   "), false);
    } 
    
    @Test
    public void testFriendsEnemies()
    {
        for (Person p : person){
            assertEquals(p.friends.size() == 0, true);
            assertEquals(p.enemies.size() == 0, true);}
        
        makeFriends();
            
        assertEquals(person[0].friends.contains(person[1]), true);
        assertEquals(person[1].friends.contains(person[0]), true);
        assertEquals(person[1].friends.contains(person[2]), false);
        
        assertEquals(person[0].enemies.contains(person[2]), true);
        assertEquals(person[2].enemies.contains(person[1]), true);
        assertEquals(person[0].enemies.contains(person[1]), false);
    }
    
    @Test
    public void sendMessage()
    {
        makeFriends();
        
        for (Person p : person)
            assertEquals(p.wall.size() == 0, true);
        
        person[0].sendMessage(person[1], "Dude :D"); //friends
        person[0].sendMessage(person[2], "Dude!"); //enemies
        person[1].sendMessage(person[0], "Dude?"); //friends
        person[2].sendMessage(person[0], "Dude :("); //enemies
        
        assertEquals(person[1].wallToString()[0].equals("Dude :D"), true); //første besked
        assertEquals(person[2].wall.size() == 0, true); // person 2 er stadig enermies med 0 og 1
        assertEquals(person[0].wallToString()[0].equals("Dude?"), true);
        assertEquals(person[0].wallToString()[0].equals("Dude :("), false); // da de er enermies skal message 3 ikke op
    }
}
