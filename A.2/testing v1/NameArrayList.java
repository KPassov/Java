import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class NameArrayList illustrates different ways of searching an ArrayList.
 * Used to show how to test a class and its methods.
 * 
 * @author Ole Monrad 
 * @version 2011.11.15
 */
public class NameArrayList
{
    // array of names 
    private ArrayList<String> names;

    /**
     * Constructor for objects of class StructureTest
     */
    public NameArrayList()
    {
        names = new ArrayList<String>();
    }
    
    /**
     * Initialise with names
     */
    
    public void initialise()
    {
        names.add("Knud"); names.add("Ole"); names.add("Kasper");
        names.add("Oleks"); names.add("Henrik"); names.add("Jeppe");
    }
    
    /**
     * Initialise with duplicate names
     */
    public void initialiseDuplicates()
    {
        names.add("Knud"); names.add("Jeppe"); names.add("Kasper");
        names.add("Oleks"); names.add("Henrik"); names.add("Jeppe");    
    }
    
    
    /**
     * Add a name to the array list
     * @param name The name to be added
     */

    
    public void addName(String name)
    {
        names.add(name);
    }

    
    /**
     * Find the position where a given name is placed in the array
     * @param name The name to find in the array
     * @return The position of a name, -1 if it is not found.
     */
    
    public int getIndexOf(String name)
    {
        boolean found = false;
        int index = 0;
        while (index < names.size() && !found) {
            if (names.get(index).equals(name)) {
                found = true;
            }
            else {
                index++;
            }
        }
        if (!found) index = -1;
        return index;
    }
    
    /**
     * Search the array to see if a name is in the collection.
     * @param name The name to search for in the collection.
     * @return The result (true or false) of looking up a name.
     */
    public boolean isMember(String name)
    {
        boolean member = false;
        int index = 0;
        while (index < names.size() && !member) {
            if (names.get(index).equals(name)) {
                member = true;
            }
            else {
                index++;
            }
        }
        return member;
    }

    /**
     * Find the position where the longest name is placed in the array.
     * @return The position of the longest name.
     */
    public int findIndexOfLongest()
    {
        if (names.size() == 0) return -1;
        String candidate = names.get(0);
        int longest = 0;
        for(int index = 1; index < names.size(); index++) {
            if (names.get(index).length() > candidate.length()) {
                candidate = names.get(index);
                longest = index;
            }
        }
        return longest;
    }
    
    /**
     * Finds a string starting with startText, deletes it and returns it
     * @param startText the String that should be deletet
     * @return returns the deleted string or an empty string
     */
    public String deleteWith(String startText) 
    {
        boolean found = false;
        Iterator<String> it = names.iterator();
        String nameDeleted = new String("");
        while (it.hasNext() && !found) {
            if (it.next().startsWith(startText)) {
                nameDeleted = it.next();
                it.remove(); 
                found = true;
            }
        }
        return nameDeleted;
    }
}
