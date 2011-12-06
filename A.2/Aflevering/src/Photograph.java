public class Photograph
{
    String[] photo;

    public Photograph(String[] photograph)
    {
        if (photograph == null)
            photograph = new String[]{};
        photo = photograph;
    }

    /**
       * getWidth returns the width of the photo
     * @return the width of the photo
     */
    
    public int getWidth()
    {
        if (photo.length == 0)
            return 0;
        return photo[0].length();
    }

    /**
     * getHeight returns the height of the photo
     * @return the height of the photo
     */ 
    
    public int getHeight()
    {
        return photo.length;
    }

    /**
     * getLine returns the index line of the photo
     * @param index the index of the line
     * @return return the string at the index line
     * @null if the index is out of bounds.
     */
    public String getLine(int index)
    {
        if (index < 0 || index >= this.photo.length)
            return null;
        return photo[index];
  }
}