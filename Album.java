/*

Authors: Xavier Williams, Riley Lane
Version: 30/04/2020
*/
import java.util.*;
public class Album
{
    // Instance variables
    private String albumName,defaultName="Empty Slot";
    public Song song1, song2, song3, song4;
    private int totalTime,songCount;
    private final int MAX_TIME = 720; //12 minutes
    Scanner console = new Scanner(System.in);

    // Constructor
    public Album()
    {
        setAlbumName(defaultName);
        initialiseSongs();
        songCount=0;
    }

    // Set Get Methods
    public void setAlbumName (String newAlbumName)
    {
        albumName = newAlbumName;
    }
    public String getAlbumName()
    {
        return(albumName);
    }

    //new code for deleting album and copying songs
    public int getSongCount(){
        return (songCount);
    }
    public void setSongCount(int newSongCount){
        songCount = newSongCount;
    }

    public int getTotalTime()
    {
        return (totalTime);
    }
    public void setTotalTime(int newTotalTime){
        totalTime = newTotalTime;
    }
    public int getMaxTime(){
        return (MAX_TIME);
    }



    // Initialise Songs
    private void initialiseSongs() {
        song1 = new Song();
        song2 = new Song();
        song3 = new Song();
        song4 = new Song();
    }

    // List all songs in album
    // **ADD SONG DETAILS (artist, duration, genre)**
    String listSongs(){
        String songList = albumName + "\n"
        +"- " +song1.getName()
        +"- " +song2.getName()
        +"- " +song3.getName()
        +"- " +song4.getName();
        return songList;
    }

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



    // Reset album name and calls resetSong method from Song.java
    // **Will be used to for 'Delete album'**
    public void resetAlbum(){
        setAlbumName(defaultName);
        song1.resetSong();
        song2.resetSong();
        song3.resetSong();
        song4.resetSong();
        songCount = 0;
    }




   /* void createSong(){
        // Prompt users for input values
        String newSongName;String newArtist;String newDuration;String newGenre;int duration;
        System.out.println("Name: ");
        newSongName = console.nextLine();
        System.out.println("Artist: ");
        newArtist = console.nextLine();
        System.out.println("Duration: ");
        newDuration = console.nextLine();
        // **NEED TO MAKE NEW MENU FOR GENRE WHERE THEY SELECT FROM A LIST**
        System.out.println("Genre: ");
        newGenre = console.nextLine();

        // Had to add this because it would make errors when users input both strings and ints, they had to all be strings I worked out.
        duration = Integer.parseInt(newDuration);

        /* CHECKING SYSTEM: Checks if enough space in album, checks duration, calls songMatches method from Song.java to
        check if song already exists in album */
        /*
        if(songCount<4){

            if(totalTime+duration<MAX_TIME){
                if(song1.songMatches(newSongName,newArtist,duration) ||
                        song2.songMatches(newSongName,newArtist,duration) ||
                        song3.songMatches(newSongName,newArtist,duration) ||
                        song4.songMatches(newSongName,newArtist,duration)){
                    System.out.println("Song already exists.");
                } else{
                    songCount+=1;
                    switch (songCount){
                        case 1:
                            song1.create(newSongName,newArtist,duration,newGenre);
                            break;
                        case 2:
                            song2.create(newSongName,newArtist,duration,newGenre);
                            break;
                        case 3:
                            song3.create(newSongName,newArtist,duration,newGenre);
                            break;
                        case 4:
                            song4.create(newSongName,newArtist,duration,newGenre);
                            break;
                    }
                    totalTime+=duration;
                    // **FIX OUTPUT TO SHOW SONG NAME ADDED TO x ALBUM ETC.**
                    System.out.println("Created song!!!!!!");
                }

            } else{
                System.out.println("Failed to create song, duration of album exceeds limit.");
            }
        } else {
            System.out.println("Failed to create song, album is full. Please delete a song.");
        }
    } */

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
