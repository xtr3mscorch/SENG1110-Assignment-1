/*

Authors: Xavier Williams, Riley Lane
Version: 28/04/2020
*/

public class Album
{
    // instance variables 
    private String albumName;
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
    public void setAlbumName (String newAlbumName)
    {
        albumName = newAlbumName;
    }
    public String getAlbumName()
    {
        return(albumName);
    }
}
