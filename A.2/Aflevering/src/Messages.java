public class Messages
{
    private Person author;
    private String body;
    
    public Messages(Person author, String body)
    {
        this.author = author;
        this.body = body;
    }
    
    public String getBody()
    {
        return body;
    }
    
    public Person getAuthor()
    {
        return author;
    }
}
