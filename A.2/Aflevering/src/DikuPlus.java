import java.util.ArrayList;

public class DikuPlus
{
    ArrayList<Person> network;

    public DikuPlus()
    {
        network = new ArrayList<Person>();
    }
    
    public void addPerson(Person person)
    {
        network.add(person);
    }
    
    /*
     * removes a person from the network with the given name
     * @param name the name of the person
     */
    
    public void removePersonWithName(String name)
    {
        Person remove = null;
        for (Person p : network)            
                if (remove == null && p.getName().equals(name))
                    remove = p;

        if (remove != null)
            network.remove(network.indexOf(remove));    
    }
    
    /**
     * prints a report of the network to the console. The report shows all people in the network, and each persons wall
     * friends and enemies.
     */
    
    public void report()
    {
        for (Person p : network){
            System.out.println(p.getName() + "'s Wall\n");
            for ( Messages m : p.wall)
                System.out.println("        " + m.getAuthor().getName() + ": wrote " + m.getBody());    

            System.out.println("\n" + p.getName() + "'s Enemies\n");
            for ( Person e : p.enemies)
                System.out.println("        " + e.getName());   
            
            System.out.println(p.getName() + "'s Friends\n");
            for ( Person f : p.friends)
                System.out.println("        " + f.getName());   
            System.out.println("_____________________________________________");

         }    
    }
}