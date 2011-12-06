
/**
 * Class NameArray illustrates different ways of searching an array.
 * Used to show how to test a class and its methods.
 * 
 * @author Ole Monrad 
 * @version 2011.11.15
 */
public class NameArray
{
    // array of names 
    private String[] names;

    /**
     * Constructor for objects of class StructureTest
     */
    public NameArray()
    {
        names = new String[6];
    }
    
    /**
     * Initialise with names
     */
    public void initialise()
    {
        names[0] = "Knud";  names[1] = "Ole";    names[2] = "Kasper";
        names[3] = "Oleks"; names[4] = "Henrik"; names[5] = "Jeppe";
    }
    
    /**
     * Initialise with duplicate names
     */
    public void initialiseDuplicates()
    {
        names[0] = "Knud";  names[1] = "Jeppe";  names[2] = "Kasper";
        names[3] = "Oleks"; names[4] = "Henrik"; names[5] = "Jeppe";
    }
    
    /**
     * Add a name to the array at a specific index
     * @param index The place to add the new name
     * @param name The name to be added
     */
    public void addName(int index, String name)
    {
        if (index >=0 && index < names.length) {
            names[index] = new String(name);
        }
    }

    /**
     * Find the position where a given name is placed in the array.
     * @param name The name to find in the array.
     * @return The position of a name, -1 if it is not found.
     */
    public int getIndexOf(String name)
    {
        boolean found = false;
        int index = 0;
        while (index < names.length && !found) {
            if (names[index] != null && names[index].equals(name)) {
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
        while (index < names.length && !member) {
            if (names[index] != null && names[index].equals(name)) {
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
        String candidate = names[0];
        int longest = 0;
        for(int index = 0/*skal starte på 0*/; index < names.length; index++) {
            if (names[index] != null/*skal tjekke imod null*/ && names[index].length() > candidate.length()) {
                candidate = names[index];
                longest = index;
            }
        }
        return longest;
    }
}
