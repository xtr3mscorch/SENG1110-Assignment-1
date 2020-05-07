/*
Stores variables for individual album objects
Authors: Xavier Williams (C3329774), Riley Lane (C)
Last Edited: 08/05/2020
*/

public class Album
{
    // INSTANCE VARIABLES
    private String albumName,defaultName="Empty Slot";
    public Song song1, song2, song3, song4;
    private int totalTime,songCount;
    private final int MAX_TIME = 720; //12 minutes

    // ALBUM CONSTRUCTOR
    public Album()
    {
        setAlbumName(defaultName);
        initialiseSongs();
        songCount=0;
    }

    // SET ALBUM NAME
    public void setAlbumName (String newAlbumName)
    {
        albumName = newAlbumName;
    }

    // RETURN ALBUM NAME
    public String getAlbumName()
    {
        return(albumName);
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

    // INITIALISE SONGS
    private void initialiseSongs() {
        song1 = new Song();
        song2 = new Song();
        song3 = new Song();
        song4 = new Song();
    }

    // LISTS ALL SONGS OF AN ALBUM THROUGH getName METHOD
    /////////////////////////////////////////////////////// **ADD SONG DETAILS (artist, duration, genre) its in the marking guideline**
    String listSongs(){
        String songList = albumName + "\n"
        +"- " +song1.getName()
        +"- " +song2.getName()
        +"- " +song3.getName()
        +"- " +song4.getName();
        return songList;
    }

    // USES IF STATEMENTS TO CHECK IF EACH SONG MATCHES THE SELECTED GENRE AND ADDS TO STRING IF TRUE
    String listSongs(int genre){
        String songList = albumName + "\n";
        if (song1.getGenre()==genre){
                    songList=songList+"- " +song1.getName()+"\n";
                }
        if (song2.getGenre()==genre){
            songList=songList+"- " +song2.getName()+"\n";
        }
        if (song3.getGenre()==genre){
            songList=songList+"- " +song3.getName()+"\n";
        }
        if (song4.getGenre()==genre){
            songList=songList+"- " +song4.getName()+"\n";
        }
        return songList;
    }

    // USES IF STATEMENTS TO CHECK IF EACH SONG IS UNDER INPUT DURATION AND ADDS TO STRING IS TRUE
    String listSongsDuration(int duration){
        String songList = albumName + "\n";
        if (song1.getName()!="Empty song" && song1.getDuration()<duration){
            songList=songList+"- " +song1.getName()+"\n";
        }
        if (song2.getName()!="Empty song" && song2.getDuration()<duration){
            songList=songList+"- " +song2.getName()+"\n";
        }
        if (song3.getName()!="Empty song" && song3.getDuration()<duration){
            songList=songList+"- " +song3.getName()+"\n";
        }
        if (song4.getName()!="Empty song" && song4.getDuration()<duration){
            songList=songList+"- " +song4.getName()+"\n";
        }
        return songList;
    }

    // DELETE ALBUM METHOD CALLS resetSong() METHOD FOR EACH SONG OF ALBUM
    public void resetAlbum(){
        setAlbumName(defaultName);
        song1.resetSong();
        song2.resetSong();
        song3.resetSong();
        song4.resetSong();
        songCount = 0;
    }

    // RETURNS IF ALBUM NAME MATCHES ONE ALREADY MADE? DOES IT? IDK
    public boolean albumNameMatches(String newAlbumName)
    {
        if(newAlbumName == albumName)
        {
            return true;
        }
        else
            {
               return false;
            }
    }
}
