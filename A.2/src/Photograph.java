public class Photograph
{
	int	photoWidth, photoHeight;
	String[] photo = new String[];

	public Photograph(String[] photograph)
	{
		if (photograph == null)
			photograph = new String[] { };
		photo = photograph;
		photoWidth = photo[0].length;
		photoHeight = photo.length;
		// ...
	}

  public int getWidth()
	{
    return photoWidth;
	}

	public int getHeight()
	{
    return photoHeigth;
	}

	/**
	 * @null if the index is out of bounds.
	 */
	public String getLine(int index)
	{
		if (index < 0 || index >= this.photograph.length)
			return null;
		return photo.[index];
  }
}
