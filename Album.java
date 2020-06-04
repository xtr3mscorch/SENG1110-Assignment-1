/*
Stores variables for individual album objects
Authors: Xavier Williams (C3329774), Riley Lane (C3339143)
Last Edited: 08/05/2020
*/

public class Album
{
    // INSTANCE VARIABLES
    private String albumName,defaultName="Empty Slot";
    public Song song1, song2, song3, song4;
    private int totalTime,songCount;
    private final int MAX_TIME = 720; //12 minutes

    final int MAX_SONGS = 5;
    Song songs[] = new Song[MAX_SONGS];

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
        for (int i = 0;i<songs.length;i++)
        {
            songs[i] = new Song();
        }


        /*
        song1 = new Song();
        song2 = new Song();
        song3 = new Song();
        song4 = new Song();

         */
    }

    // LISTS ALL SONGS OF AN ALBUM THROUGH getName METHOD
    String listSongs(boolean isDeleting){
        String songList = "";
        if (!isDeleting)
        {
            songList = ("______ '" + albumName + "' song list: _______\n");
        }
        switch (songCount)
        {
            case 1:
                songList += "1. " +song1.getAllDetails();

                break;
            case 2:
                songList += "1. " +song1.getAllDetails()+ "\n";
                songList += "2. " +song2.getAllDetails();
                break;
            case 3:
                songList += "1. " +song1.getAllDetails()+ "\n";
                songList += "2. " +song2.getAllDetails()+ "\n";
                songList += "3. " +song3.getAllDetails();
                break;
            case 4:
                songList += "1. " +song1.getAllDetails()+ "\n";
                songList += "2. " +song2.getAllDetails()+ "\n";
                songList += "3. " +song3.getAllDetails()+ "\n";
                songList += "4. " +song4.getAllDetails();
                break;
        }
        return songList;
    }

    // USES IF STATEMENTS TO CHECK IF EACH SONG MATCHES THE SELECTED GENRE AND ADDS TO STRING IF TRUE
    String listSongsGenre(int genre){
        String songList = "";
        if (song1.getGenre()==genre || song2.getGenre()==genre || song3.getGenre()==genre || song4.getGenre()==genre)
        {
            songList += ("______ '" + albumName + "'  _______\n");
        }
        switch (songCount)
        {
            case 1:
                if (song1.getGenre()==genre){
                    songList=songList+"1. " +song1.getName()+"\n";}
                break;
            case 2:
                if (song1.getGenre()==genre){
                    songList=songList+"1. " +song1.getName()+"\n";}
                if (song2.getGenre()==genre){
                    songList=songList+"2. " +song2.getName()+"\n";}
                break;
            case 3:
                if (song1.getGenre()==genre){
                    songList=songList+"1. " +song1.getName()+"\n";}
                if (song2.getGenre()==genre){
                    songList=songList+"2. " +song2.getName()+"\n";}
                if (song3.getGenre()==genre){
                    songList=songList+"3. " +song3.getName()+"\n";}
                break;
            case 4:
                if (song1.getGenre()==genre){
                    songList=songList+"1. " +song1.getName()+"\n";}
                if (song2.getGenre()==genre){
                    songList=songList+"2. " +song2.getName()+"\n";}
                if (song3.getGenre()==genre){
                    songList=songList+"3. " +song3.getName()+"\n";}
                if (song4.getGenre()==genre){
                    songList=songList+"4. " +song4.getName()+"\n";}
                break;
        }
        return songList;
    }

    // USES IF STATEMENTS TO CHECK IF EACH SONG IS UNDER INPUT DURATION AND ADDS TO STRING IS TRUE
    String listSongsDuration(int durationMinute){
        int duration=durationMinute*60;

        String songList = "";
        if (song1.getName()!="Empty song" && song1.getDuration()<duration || song2.getName()!="Empty song" && song1.getDuration()<duration ||
                song3.getName()!="Empty song" && song1.getDuration()<duration || song4.getName()!="Empty song" && song1.getDuration()<duration)
        {songList += ("______ '" + albumName + "'  _______\n");}

        switch(songCount)
        {
            case 1:
                if (song1.getName()!="Empty song" && song1.getDuration()<duration){
                    songList=songList+"1. " +song1.getName()+"\n";}
                break;
            case 2:
                if (song1.getName()!="Empty song" && song1.getDuration()<duration){
                    songList=songList+"1. " +song1.getName()+"\n";}
                if (song2.getName()!="Empty song" && song2.getDuration()<duration){
                        songList=songList+"2. " +song2.getName()+"\n";}
                break;
            case 3:
                if (song1.getName()!="Empty song" && song1.getDuration()<duration){
                    songList=songList+"1. " +song1.getName()+"\n";}
                if (song2.getName()!="Empty song" && song2.getDuration()<duration){
                    songList=songList+"2. " +song2.getName()+"\n";}
                if (song3.getName()!="Empty song" && song3.getDuration()<duration){
                    songList=songList+"3. " +song3.getName()+"\n";}
                break;
            case 4:
                if (song1.getName()!="Empty song" && song1.getDuration()<duration){
                    songList=songList+"1. " +song1.getName()+"\n";}
                if (song2.getName()!="Empty song" && song2.getDuration()<duration){
                    songList=songList+"2. " +song2.getName()+"\n";}
                if (song3.getName()!="Empty song" && song3.getDuration()<duration){
                    songList=songList+"3. " +song3.getName()+"\n";}
                if (song4.getName()!="Empty song" && song4.getDuration()<duration){
                    songList=songList+"4. " +song4.getName()+"\n";}
                break;
        }
        return (songList);
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
    public boolean albumNameMatches(String newAlbumName)
    {
        if(newAlbumName.equals(albumName))
        {
            return true;
        } else {
            return false;
            }
    }
}
