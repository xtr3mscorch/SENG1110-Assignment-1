/* 
Stores details and features of individual songs
Authors: Xavier Williams, Riley Lane
Version: 28/04/2020
*/

 * @version (a version number or a date)
public class Song
{
	private String name,artist,genre;
	private int duration;
	
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
		arist = a;
	}
	public String getArtist()
	{
		return arist;
	}

	// Set and return genre of song.
	public void setGenre(String g)
	{
		genre = g;
	}
	public String getGenre()
	{
		return genre;
	}

	// Set and return duration of song.
	public void setDuraction(int d)
	{
		duration = d;
	}
	public int getDuration()
	{
		return duration;
	}

}
