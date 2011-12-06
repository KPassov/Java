import java.util.ArrayList;

public class Person
{
    public ArrayList<Person> enemies, friends;
    private String name;
    private Photograph photo;    
    public ArrayList<Messages> wall;
    
    public Person(String name)
    {
        this.name = name;
        photo = null;
        friends = new ArrayList<Person>();
        enemies = new ArrayList<Person>();
        wall = new ArrayList<Messages>();
    }
   
    public void changePhoto(Photograph photo)
    {
        this.photo = photo;
    }
    
    public Photograph getPhoto()
    {
        return photo;
    }
    
    public String getName()
    {
        return name;
    }

    /**
     * takes every message on the wall and returns it as an array of strings
     * @return all the messages on the wall as an array of strings
     */
    public String[] wallToString()
    {
        String[] s = new String[wall.size()];
        int i = 0;
        for (Messages m : wall){
            s[i] = m.getBody();
            i++;}
        return s;
    }
    
    /**
     * sends a receiver a message
     * @param receiver the Person object the Messages object is for
     * @param message a string with the body of the message
     * 
     * @return returns a boolean that shows true if the message was accepted by the reciever.
     */
    public boolean sendMessage ( Person receiver , String message ) 
    { 
        Messages m = new Messages(this, message);
        return receiver.receiveMessage(m);
    }
    
    /**
     * sends a request for friendship from this Person object to another Person object
     * @param otherPerson the person the request is for
     * @return returns a boolean that shows if the request was accepted
     */

    public boolean requestFriendship ( Person otherPerson ) 
    {
        return this.sendMessage(otherPerson, "/friend");
    }

    /**
     * private method that's used by the sendMessage to judge if the request was succesfull and add friendships and
     * messages to the Person
     */
    
    private boolean receiveMessage ( Messages message ) 
    {
        if (friends.contains(message.getAuthor()))
            return wall.add(message);
            else if (!enemies.contains(message.getAuthor()) && message.getBody() == "/friend"){
                if (message.getAuthor().getName() != "Oleks"){
                    this.friends.add(message.getAuthor());
                    message.getAuthor().friends.add(this);
                    return true;}
                this.enemies.add(message.getAuthor());
                message.getAuthor().enemies.add(this);        
                return false;}
        return false;
    }    
}