/*
Stores variables for individual song objects
Authors: Xavier Williams (C3329774), Riley Lane (C3339143)
Last Edited: 08/05/2020
*/

public class Song {
	private String name, artist;
	private int duration, genre;

	// SONG CONSTRUCTOR
	public Song() {
		setName("Empty song");
	}

	// SET SONG NAME
	public void setName(String n) {
		name = n;
	}

	// RETURN SONG NAME
	public String getName() {
		return name;
	}

	// SET SONG ARTIST
	public void setArtist(String a) {
		artist = a;
	}

	// RETURN SONG ARTIST
	public String getArtist() {
		return artist;
	}

	// SET SONG GENRE
	public void setGenre(int g) {
		genre = g;
	}

	// RETURN SONG GENRE
	public int getGenre() {
		return genre;
	}

	// SET SONG DURATION
	public void setDuration(int d) {
		duration = d;
	}

	// RETURN SONG DURATION
	public int getDuration() {
		return duration;
	}

	// DELETE SONG METHOD CHANGES NAME TO 'Empty song' WHERE IT WILL NO LONGER BE RETURNED IN LISTS
	public void resetSong() {
		setName("Empty song");
	}

	// CHECK SOMETHING IDK EXACTLY
	public boolean songMatches(String newSongName, String newArtist, int newDuration) {
		if (newSongName.equals(name) && newArtist.equals(artist) && newDuration == duration) {
			return true;
		} else {
			return false;
		}
	}

	// RETURNS ALL DETAILS OF SONG
	public String getAllDetails() {
		String allDetails =
		getName() + "\n"
				+ " - By: " + getArtist() + "\n"
				+ " - Duration: " + getDuration() + " (s) \n"
				+ " - Genre: " + getGenreName();
		return allDetails;
	}

	// CREATE METHOD TAKES USER INPUTS AND USES SET FUNCTIONS FOR EACH SONG VARIABLE
	public void create(String newSongName, String newArtist, int newDuration, int newGenre) {
		setName(newSongName);
		setArtist(newArtist);
		setDuration(newDuration);
		setGenre(newGenre);
	}

	public String getGenreName() {
		String genreName = "";
		switch (getGenre()) {
			case 1:
				genreName = "Rock \n";
				break;
			case 2:
				genreName = "Pop \n";
				break;
			case 3:
				genreName = "Hip-Hop \n";
				break;
			case 4:
				genreName = "Bossa Nova \n";
				break;
		}
		return genreName;
	}
}
