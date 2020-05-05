/* 
Stores details and features of individual songs
Authors: Xavier Williams, Riley Lane
Version: 30/04/2020
*/

public class Song
{
	private String name,artist,genre;
	private int duration;
	
	public Song(){
		setName("Empty song");
	}

	// Set and return name of song.
	public void setName(String n)
	{
		 name = n;
	}	
	public String getName()
	{
		return name;
	}
	
	// Set and return name of artist.
	public void setArtist(String a)
	{
		artist = a;
	}
	public String getArtist()
	{
		return artist;
	}

	// Set and return genre of song.
	public void setGenre(String g){
		genre = g;
	}
	public void genreInput(int g) {
		switch (g) {
			case 1:
				setGenre("Rock");
				break;
			case 2:
				setGenre("Pop");
				break;
			case 3:
				setGenre("Hip-Hop");
				break;
			case 4:
				setGenre("Bossa Nova");
				break;
		}
	}

	public String getGenre()
	{
		return genre;
	}

	// Set and return duration of song.
	public void setDuration(int d)
	{
		duration = d;
	}
	public int getDuration()
	{
		return duration;
	}

	public void resetSong(){
		setName("Empty song");
}
	// Copy this for duration search and genre search
	public boolean songMatches(String newSongName,String newArtist,int newDuration){
		if(newSongName==name && newArtist==artist && newDuration==duration){
			return true;
		} else{
			return false;
		}
	}

	public void create(String newSongName,String newArtist,int newDuration,int newGenre){
		setName(newSongName);
		setArtist(newArtist);
		setDuration(newDuration);
		genreInput(newGenre);
	}

}
