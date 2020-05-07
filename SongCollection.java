import java.util.*;
/*
DescriptionX
Authors: Xavier Williams (C3329774), Riley Lane (C)
Last Edited: 08/05/2020
*/

public class SongCollection {
	private Album album1, album2, album3;
	Scanner console = new Scanner(System.in);
	int albumCount=0,exit=0;

	// MAIN METHOD
	public static void main(String[] args) {
		SongCollection sg = new SongCollection();
		System.out.print("Welcome to Terminal Music \n");
		sg.run();
	}

	// MAIN MENU METHOD
	// WHILE LOOP MAKES PROGRAM ALWAYS RETURN TO MAIN MENU UNTIL exit VALUE IS SET TO 1, WHEN USER REQUESTS TO EXIT
	public void run() {
		initialiseAlbums();
		while(exit==0) {
			String mainMenu = ("____________Main Menu___________\n"
					+ "1: Add album       "
					+ "3: Song search\n"
					+ "2: View albums     "
					+ "4: Exit program\n");
			System.out.print(mainMenu);

			// USER INPUT TO SELECT MENU OPTION
			String input = console.nextLine();
			switch (Integer.parseInt(input)) {
				case 1:
					albumCreate();
					break;
				case 2:
					albumView();
					break;
				case 3:
					searchMenu();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					rebootFunction();
					break;
			}
		}
	}

	//###########################################################################//
	//////////////////////User Input Functions/////////////////////////////////////

	//#############################################//

	// SONG SEARCH MENU
	void searchMenu() {
		String mainMenu = ("___________Search By:___________\n"
				+ "1: Genre       "
				+ " 3: View all\n"
				+ "2: Duration     "
				+ "4: Back\n");
		System.out.print(mainMenu);

		// USER INPUT TO SELECT MENU OPTION
		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				// DISPLAYS GENRE OPTIONS AND CALLS genreSearch METHOD WITH USERS INPUT VALUE
				System.out.println("Pick genre blah");
				System.out.println("1: Rock");
				System.out.println("2: Pop");
				System.out.println("3: Hip-Hop");
				System.out.println("4: Bossa Nova");
				genreSearch(Integer.parseInt(console.nextLine()));
				break;
			case 2:
				// CALLS durationSearch METHOD WITH USERS INPUT VALUE
				System.out.println("Find songs with duration (s) shorter than: ");
				durationSearch(Integer.parseInt(console.nextLine()));
				break;
			case 3:
				viewAllSong();
				break;
			case 4:
				//exit=1;
				break;
			default:
				rebootFunction();
				break;
		}
	}

	// CHECKS IF ALBUM HAS BEEN MADE THEN
	void genreSearch(int g){
	String searchResult="";
		if(album1.getAlbumName()!="Empty Slot") {
			searchResult+=album1.listSongs(g);
		}
		if(album2.getAlbumName()!="Empty Slot") {
			searchResult+=album2.listSongs(g);
		}
		if(album3.getAlbumName()!="Empty Slot") {
			searchResult+=album3.listSongs(g);
		}
		System.out.println(searchResult);
	}

	void durationSearch(int g){
		String searchResult="";
		if(album1.getAlbumName()!="Empty Slot") {
			searchResult+=album1.listSongsDuration(g);
		}
		if(album2.getAlbumName()!="Empty Slot") {
			searchResult+=album2.listSongsDuration(g);
		}
		if(album3.getAlbumName()!="Empty Slot") {
			searchResult+=album3.listSongsDuration(g);
		}
		System.out.println(searchResult);
		//run();
	}

	//#############################################//
	// ALBUM SONG VIEW // SECONDARY LAYER FOR ALBUM VIEW
	void albumMenu(Album currentAlbum) {
		System.out.println("______Album: " + currentAlbum.getAlbumName() + "_______");
		System.out.println("1: List songs");
		System.out.println("2: Add song");
		System.out.println("3: Delete song");
		System.out.println("----------------" + "\n4: Back");

		//USER INPUT//
		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				if (currentAlbum.getSongCount() > 0) {
					System.out.println(currentAlbum.listSongs());
					System.out.println("----------------" + "\n5: Back");
					String back = console.nextLine(); //maybe add delete song option here too
				}
				else{
					System.out.println("You have not added any songs.");
				}
				albumMenu(currentAlbum);
				break;
			case 2:
				createNewSong(currentAlbum);
				albumMenu(currentAlbum);
				break;
			case 3:
				songDeleteMenu(currentAlbum);
				albumMenu(currentAlbum);
				break;
			case 4:
				//go back
				albumView();
				break;
			default:
				rebootFunction();
				break;
		}
	}

	//#############################################//
	// SONG DELETE MENU //
	void songDeleteMenu(Album selectedAlbum){

		int tempSongCount = selectedAlbum.getSongCount();
		if (tempSongCount > 0) {
			System.out.println("Which song would you like to delete?");
			System.out.println(selectedAlbum.listSongs());
			System.out.println("----------------" + "\n5: Back");

			String input = console.nextLine();
			switch (Integer.parseInt(input))
			{
				case 1:
					//delete song 1
					if (tempSongCount == 1) //if this is the only song in the album... no data switching required.
					{
						deleteSong(selectedAlbum, 1);
					}
					break;
				case 2:
					//delete song 2
					if (tempSongCount > 1)
					{
						if (tempSongCount == 2) //if there are only two songs in the album.
						{
							deleteSong(selectedAlbum, 2);
						}

					}
					break;
				case 3:
					//delete song 3
					if (tempSongCount > 2)
					{
						if (tempSongCount == 3) //if there are 3 songs in the album.
						{
							deleteSong(selectedAlbum,3);
						}
					}
					break;
				case 4:
					if (tempSongCount > 3)
					{
						//delete song 4
						if (tempSongCount == 4) //if there are 4 songs in the album.
						{
							deleteSong(selectedAlbum,4);
						}
					}
					break;
				case 5:
					//go back

					break;
				default:
					rebootFunction();
					break;
			}
		}
		else{
			System.out.println("You have not added any songs.");
		}

	}

	//#############################################//
	// ALBUM CREATE MENU //
	void albumCreate() {
		if(albumCount<3) {
			System.out.println("Album name: ");

			//USER INPUT//
			String newAlbumName = console.nextLine();
			if (album1.albumNameMatches(newAlbumName) || album2.albumNameMatches(newAlbumName) || album3.albumNameMatches(newAlbumName)) {
				System.out.println("Album already exists. "); //check if name already exists
			} else {
				albumCount += 1;
				switch (albumCount) {
					case 1:
						album1.setAlbumName(newAlbumName);
						break;
					case 2:
						album2.setAlbumName(newAlbumName);
						break;
					case 3:
						album3.setAlbumName(newAlbumName);
						break;
				}
			}
			System.out.println(newAlbumName + " has been successfully added");
			//run();
		}
		else{
			System.out.println("Album slots are full.");
			//run();
		}
	}

	//#############################################//
	// ALBUM VIEW MENU //
	void albumView() {
		if(albumCount > 0) {
			System.out.println("_________Albums: select one_________");
			switch (albumCount) { //only display album based on albumCount value
				case 1:
					System.out.println("1: " + album1.getAlbumName());
					break;
				case 2:
					System.out.println("1: " + album1.getAlbumName());
					System.out.println("2: " + album2.getAlbumName());
					break;
				case 3:
					System.out.println("1: " + album1.getAlbumName());
					System.out.println("2: " + album2.getAlbumName());
					System.out.println("3: " + album3.getAlbumName());
					break;
				default:
					rebootFunction();
					break;
			}

			System.out.print("----------------\n4: Delete an album     5: Back\n");

			//USER INPUT//
			String input = console.nextLine();
			switch (Integer.parseInt(input)) {
				case 1:
					albumMenu(album1);
					break;
				case 2:
					if (albumCount > 1)
					{
						albumMenu(album2);
					}else {
						rebootFunction();
					}
					break;
				case 3:
					if (albumCount > 2)
					{
						albumMenu(album3);
					}
					else{
						rebootFunction();
					}
					break;
				case 4:
					DeleteAlbum();
					break;
				case 5:
					//run();
					break;
				default:
					rebootFunction();
			}
		}
		else{
			System.out.print("You have not added any albums!\n");
		}
	}

	//#############################################//
	// ALBUM DELETE //

	void DeleteAlbum(){
		System.out.println("Which album would you like to delete?");
		switch (albumCount) { //only display album based on albumCount value
			case 1:
				System.out.println("1: " + album1.getAlbumName());
				break;
			case 2:
				System.out.println("1: " + album1.getAlbumName());
				System.out.println("2: " + album2.getAlbumName());
				break;
			case 3:
				System.out.println("1: " + album1.getAlbumName());
				System.out.println("2: " + album2.getAlbumName());
				System.out.println("3: " + album3.getAlbumName());
				break;
			default:
				rebootFunction();
				break;
		}
		System.out.println("----------------\n4: Back");

		String input = console.nextLine();
		switch (Integer.parseInt(input)) {

			// DELETE ALBUM 1
			case 1:
				if(albumCount == 2) {//IF THERE ARE 2 ALBUMS
					//album 2 takes the spot of album 1 -> then gets deleted
					albumSwitchAndDelete(album2, album1);
				}
				else if(albumCount == 3) //IF THERE IS 3 ALBUMS
				{
					//album 3 takes the spot of album 1 -> then gets deleted
					albumSwitchAndDelete(album3, album1);
				}
				else{
					deleteAlbum(album1); //IF THERE IS ONLY 1 ALBUM
				}
				break;

			// DELETE ALBUM 2
			case 2:
				if (albumCount > 1)
				{
					//IF THERE ARE 3 ALBUMS
					if (albumCount == 3)
					{
						//album 3 takes the spot of album 2 -> then gets deleted
						albumSwitchAndDelete(album3, album2);
					}
					else{
						deleteAlbum(album2);
					}
				}
				else{
					rebootFunction();
				}
				break;

				// DELETE ALBUM 3
			case 3:
				if (albumCount > 2){
					deleteAlbum(album3);
				}
				else{
					rebootFunction();
				}
				break;

			default:
				rebootFunction();
				break;
		}

	}

	//#############################################//
	// NEW CREATE SONG ... Within SongCollection.java //
	void createNewSong(Album selectedAlbum){
		String genreMenu = ("___________Select Genre:___________\n"
				+ "1: Rock    "
				+ "3: Hip-Hop\n"
				+ "2: Pop     "
				+ "4: Bossa Nova\n");
		String newSongName;String newArtist;String newDuration;String newGenre;int genre;int duration;
		System.out.println("Name: ");
		newSongName = console.nextLine();
		System.out.println("Artist: ");
		newArtist = console.nextLine();
		System.out.println("Duration (s): ");
		newDuration = console.nextLine();
		System.out.print(genreMenu);
		newGenre = console.nextLine();

		genre = Integer.parseInt(newGenre);
		duration = Integer.parseInt(newDuration);

		if(selectedAlbum.getSongCount() < 4)
		{
			if(selectedAlbum.getTotalTime()+duration<selectedAlbum.getMaxTime())
			{
				if(selectedAlbum.song1.songMatches(newSongName,newArtist,duration) || selectedAlbum.song2.songMatches(newSongName,newArtist,duration) ||
						selectedAlbum.song3.songMatches(newSongName,newArtist,duration) || selectedAlbum.song4.songMatches(newSongName,newArtist,duration)){
					System.out.println("Song already exists.");
				}
				else{
					selectedAlbum.setSongCount(selectedAlbum.getSongCount() + 1);
					switch (selectedAlbum.getSongCount())
					{
						case 1:
							selectedAlbum.song1.create(newSongName,newArtist,duration,genre);
							break;
						case 2:
							selectedAlbum.song2.create(newSongName,newArtist,duration,genre);
							break;
						case 3:
							selectedAlbum.song3.create(newSongName,newArtist,duration,genre);
							break;
						case 4:
							selectedAlbum.song4.create(newSongName,newArtist,duration,genre);
							break;
					}
					selectedAlbum.setTotalTime(selectedAlbum.getTotalTime() + duration);

					// **FIX OUTPUT TO SHOW SONG NAME ADDED TO x ALBUM ETC.**
					System.out.println(newSongName + " has been added to " + selectedAlbum.getAlbumName());
				}
			}
			else{
				System.out.println("Failed to create song, duration of album exceeds limit.");
			}

		}else{
			System.out.println("Failed to create song, album is full. Please delete a song.");
		}
	}

	//###########################################################################//
	//////////////////////Secondary Functions//////////////////////////////////////

	//These contain no user input

    // Method to view all songs, calls listing method from Album.java
    void viewAllSong() {
        album1.listSongs();
        album2.listSongs();
        album3.listSongs();
    }

    //back to main menu with error message.. usually called when invalid input
	void rebootFunction() {
		System.out.println("Invalid input\n");
	}

	// Initialise new albums
	void initialiseAlbums() {
		albumCount = 0;
		album1 = new Album();
		album2 = new Album();
		album3 = new Album();
	}

	//delete song function ... called from "songDeleteMenu()"
	void deleteSong(Album selectedAlbum, int selectedSong)
	{
		String tempName = "";

		switch (selectedSong)
		{
			case 1:
				tempName = selectedAlbum.song1.getName();
				selectedAlbum.song1.resetSong();
				selectedAlbum.setSongCount(selectedAlbum.getSongCount() - 1);
				break;
			case 2:
				tempName = selectedAlbum.song2.getName();
				selectedAlbum.song2.resetSong();
				selectedAlbum.setSongCount(selectedAlbum.getSongCount() - 1);
				break;
			case 3:
				tempName = selectedAlbum.song3.getName();
				selectedAlbum.song3.resetSong();
				selectedAlbum.setSongCount(selectedAlbum.getSongCount() - 1);
				break;
			case 4:
				tempName = selectedAlbum.song4.getName();
				selectedAlbum.song4.resetSong();
				selectedAlbum.setSongCount(selectedAlbum.getSongCount() - 1);
				break;
		}

		System.out.println(tempName + " has been successfully deleted from " + selectedAlbum.getAlbumName());
		//albumMenu(selectedAlbum);
	}

	void deleteAlbum(Album selectedAlbum){
		String tempName = selectedAlbum.getAlbumName();
		selectedAlbum.resetAlbum();
		albumCount -= 1;
		System.out.println(tempName + " has been successfully deleted");
		albumView();
	}

	//big data switch... albumTo will get delete.
	void albumSwitchAndDelete(Album albumFrom, Album albumTo){
		String tempName = albumTo.getAlbumName(); //take temporary name for the album getting deleted
		albumTo.resetAlbum(); //clear album that is receiving data
		albumTo.setAlbumName(albumFrom.getAlbumName()); //set new name from old album name

		int newSongCount = albumFrom.getSongCount(); //check the song count from old album
		albumTo.setSongCount(newSongCount); //set the new song count
		switch (newSongCount)
		{
			case 1:
				//if 1 song
				albumTo.song1.setName(albumFrom.song1.getName());
				albumTo.song1.setArtist(albumFrom.song1.getArtist());
				albumTo.song1.setDuration(albumFrom.song1.getDuration());
				albumTo.song1.setGenre(albumFrom.song1.getGenre());
			case 2:
				//if 2 songs
				albumTo.song1.setName(albumFrom.song1.getName());
				albumTo.song1.setArtist(albumFrom.song1.getArtist());
				albumTo.song1.setDuration(albumFrom.song1.getDuration());
				albumTo.song1.setGenre(albumFrom.song1.getGenre());

				albumTo.song2.setName(albumFrom.song2.getName());
				albumTo.song2.setArtist(albumFrom.song2.getArtist());
				albumTo.song2.setDuration(albumFrom.song2.getDuration());
				albumTo.song2.setGenre(albumFrom.song2.getGenre());
				break;
			case 3:
				//if 3 songs
				albumTo.song1.setName(albumFrom.song1.getName());
				albumTo.song1.setArtist(albumFrom.song1.getArtist());
				albumTo.song1.setDuration(albumFrom.song1.getDuration());
				albumTo.song1.setGenre(albumFrom.song1.getGenre());

				albumTo.song2.setName(albumFrom.song2.getName());
				albumTo.song2.setArtist(albumFrom.song2.getArtist());
				albumTo.song2.setDuration(albumFrom.song2.getDuration());
				albumTo.song2.setGenre(albumFrom.song2.getGenre());

				albumTo.song3.setName(albumFrom.song3.getName());
				albumTo.song3.setArtist(albumFrom.song3.getArtist());
				albumTo.song3.setDuration(albumFrom.song3.getDuration());
				albumTo.song3.setGenre(albumFrom.song3.getGenre());
				break;
			case 4:
				//if 4 songs
				albumTo.song1.setName(albumFrom.song1.getName());
				albumTo.song1.setArtist(albumFrom.song1.getArtist());
				albumTo.song1.setDuration(albumFrom.song1.getDuration());
				albumTo.song1.setGenre(albumFrom.song1.getGenre());

				albumTo.song2.setName(albumFrom.song2.getName());
				albumTo.song2.setArtist(albumFrom.song2.getArtist());
				albumTo.song2.setDuration(albumFrom.song2.getDuration());
				albumTo.song2.setGenre(albumFrom.song2.getGenre());

				albumTo.song3.setName(albumFrom.song3.getName());
				albumTo.song3.setArtist(albumFrom.song3.getArtist());
				albumTo.song3.setDuration(albumFrom.song3.getDuration());
				albumTo.song3.setGenre(albumFrom.song3.getGenre());

				albumTo.song4.setName(albumFrom.song4.getName());
				albumTo.song4.setArtist(albumFrom.song4.getArtist());
				albumTo.song4.setDuration(albumFrom.song4.getDuration());
				albumTo.song4.setGenre(albumFrom.song4.getGenre());
				break;
			default:
				//no songs.. do nothing?
				break;
		}

		albumFrom.resetAlbum();
		albumCount -= 1;
		System.out.println(tempName + " has been successfully deleted");
		albumView();
	}

	//###########################################################################//
}



