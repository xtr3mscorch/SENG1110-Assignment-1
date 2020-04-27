
/**
 * Write a description of class Album here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Album
{
    // instance variables 
    private String name;
    private Song song1, song2, song3, song4;
    private int totalTime;
    private final int MAX_TIME = 720; //12 minutes

    /**
     * Constructor for objects of class Album
     */
    public Album()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setName (String inputName)
    {
        name = inputName;
    }
}
