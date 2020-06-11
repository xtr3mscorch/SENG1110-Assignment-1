/*
Stores variables for individual album objects
Authors: Xavier Williams (C3329774), Riley Lane (C3339143)
Last Edited: 11/06/2020
*/

public class Album
{
    // INSTANCE VARIABLES
    private String name,defaultName="Empty Slot";
    private int totalTime,songCount;
    private final int MAX_TIME = 720; // 12 minutes

    private final int MAX_SONGS = 5;
    private Song songs[] = new Song[MAX_SONGS];

    // ALBUM CONSTRUCTOR
    public Album()
    {
        setAlbumName(defaultName);
        initialiseSongs();
        songCount=0;
    }

    // SET ALBUM NAME
    public void setAlbumName (String newName)
    {
        name = newName;
    }

    // RETURN ALBUM NAME
    public String getAlbumName()
    {
        return(name);
    }

    // SET SONG COUNT VALUE
    public void setSongCount(int newSongCount){
            songCount = newSongCount;
    }

    // RETURN SONG COUNT VALUE
    public int getSongCount(){
        return (songCount);
    }

    // SET ALBUM TOTAL TIME VALUE
    public void setTotalTime(int newTotalTime){
        totalTime = newTotalTime;
    }

    // RETURN ALBUM TOTAL TIME VALUE
    public int getTotalTime()
    {
        return (totalTime);
    }

    // RETURN SET MAX TIME FOR ALBUM
    public int getMaxTime(){
        return (MAX_TIME);
    }

    // RETURN MAX SONGS ALLOWED
    public int getMaxSongs()
    {
        return(MAX_SONGS);
    }

    // INITIALISE SONGS
    private void initialiseSongs() {
        for (int i = 0;i<songs.length;i++)
        {
            songs[i] = new Song();
        }
    }

    // GET SONG NAME
    public String getSongName(int songIndex)
    {
        return (songs[songIndex].getName());
    }

    // RESET SONGS
    public void resetSong(int songIndex)
    {
        setTotalTime(getTotalTime() - songs[songIndex].getDuration());
        songs[songIndex].resetSong();
    }

    // LISTS ALL SONGS OF AN ALBUM THROUGH getName METHOD
    String listSongs(boolean isDeleting){
        String songList = "";
        for (int i=0;i<songs.length;i++){
            if (songs[i].getName() != "Empty song") {
                if (!isDeleting) {
                    songList += songs[i].getAllDetails();
                } else {
                    songList += i + 1 + ": ";
                    songList += songs[i].getName() + "\n";
                }
            }
        }
        return songList;
    }

    String listSongsGenre(int genre){
        String songList = " ";
        songList += ("______ '" + name + "'  _______\n");

        for (int i=0;i<songs.length;i++){
            if (songs[i].getGenre()==genre){
                songList += songs[i].getAllDetails()+"\n";
            }
        }
        return songList;
    }

    // USES IF STATEMENTS TO CHECK IF EACH SONG IS UNDER INPUT DURATION AND ADDS TO STRING IS TRUE
    String listSongsDuration(int durationMinute){
        int duration=durationMinute*60;
        String songList = "";
        songList += ("______ '" + name + "'  _______\n");

        for (int i=0;i<songs.length;i++){
            if (songs[i].getDuration()<duration && songs[i].getDuration()!=0) {
                songList += songs[i].getAllDetails()+"\n";
            }
        }
        return songList;
    }

    String listSongsName(String songName){
        String songList = "";
        songList += ("______ '" + name + "'  _______\n");

        for (int i=0;i<songs.length;i++){
            if (songs[i].getName().equals(songName)) {
                songList += songs[i].getAllDetails()+"\n";
            }
        }
        return songList;
    }

    // DELETE ALBUM METHOD CALLS resetSong() METHOD FOR EACH SONG OF ALBUM
    public void resetAlbum(){
        setAlbumName(defaultName);

        for (int i = 0;i<songs.length;i++)
        {
            songs[i].resetSong();
        }
        songCount = 0;
    }

    // RETURNS IF ALBUM NAME MATCHES ONE ALREADY MADE
    public boolean albumNameMatches(String newName)
    {
        if(newName.equals(name))
        {
            return true;
        } else {
            return false;
            }
    }

    void createNewSong(String newSongName,String newArtist,int duration,int genre){
        // Checks if under song limit (getSongCount()) < max song limit
        if(getSongCount() < getMaxSongs())
        {
            // Checks if album duration is less than the maximum when song is added.

            if(getTotalTime()+duration<=getMaxTime())
            {
                // Checks if song exists already in album
                if(songs[0].songMatches(newSongName,newArtist,duration) || songs[1].songMatches(newSongName,newArtist,duration) ||
                        songs[2].songMatches(newSongName,newArtist,duration) || songs[3].songMatches(newSongName,newArtist,duration) ||
                        songs[4].songMatches(newSongName,newArtist,duration))
                {
                    System.out.println("Song already exists.");
                }
                else
                {
                    setSongCount(getSongCount() + 1);

                    for (int i = 0; i < songs.length; i++)
                    {
                        if (songs[i].getName().matches("Empty song")){
                            songs[i].create(newSongName,newArtist,duration,genre);
                            break;
                        }

                    }
                    setTotalTime(0);
                    for (int i = 0; i <songs.length; i++)
                    {
                        setTotalTime(getTotalTime() + songs[i].getDuration());
                    }
                    System.out.println(getTotalTime());


                    System.out.println(newSongName + " has been added to " + getAlbumName());
                }
            }
            else{
                System.out.println("Failed to create song, duration of album exceeds limit.");
            }

        }else{
            System.out.println("Failed to create song, album is full. Please delete a song.");
        }
    }

    String songNameMatch(String songName){
        String songList = "";

        for (int i=0;i<songs.length;i++){
            if (songs[i].getName().equals(songName)){
                songList += ("______ '" + name + "'  _______\n");
                songList += songs[i].getAllDetails()+"\n";
            }
        }
        return songList;
    }
}
