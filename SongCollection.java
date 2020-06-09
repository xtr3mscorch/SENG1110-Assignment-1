import java.util.*;
import java.io.*;
/*
Authors: Xavier Williams (C3329774), Riley Lane (C3339143)
Last Edited: 08/05/2020
*/

public class SongCollection {
	private Album album1, album2, album3;
	Scanner console = new Scanner(System.in);
	int albumCount=0,exit=0;
	final int MAX_ALBUMS = 4;
	Album albums[] = new Album[MAX_ALBUMS];

	// MAIN METHOD
	public static void main(String[] args) {
		SongCollection sg = new SongCollection();
		System.out.print("    Welcome to Terminal Music \n");
		sg.run();
	}

	/// <summary>
	/// Displays main menu
	/// </summary>
	/// <param name=""></param>
	/// <returns></returns>
	public void run() {
		initialiseAlbums();

		// WHILE LOOP MAKES PROGRAM ALWAYS RETURN TO MAIN MENU UNTIL exit VALUE IS SET TO 1, WHEN USER REQUESTS TO EXIT
		while(exit==0) {
			String mainMenu = (
					"________________________________\n"
					+ "____________Main Menu___________\n"
					+ "1: Add album       "
					+ "3: Song search\n"
					+ "2: View albums     "
					+ "4: Exit program\n");
			System.out.print(mainMenu);

			// USER INPUT TO SELECT MENU OPTION
			String input = console.nextLine();
			switch (Integer.parseInt(input)) {
				case 1:
					System.out.println("Album name: ");
					String newAlbumName = console.nextLine();
					albumCreate(newAlbumName);
					break;
				case 2:
					albumView();
					break;
				case 3:
					searchMenu();
					break;
				case 4:
					exit=1;
					break;
				case 5:
					importAlbum();
				default:
					rebootFunction();
					break;
			}
		}
	}

	//#####################################################################################################//
	/////////////////////////////////////////User Input Functions////////////////////////////////////////////


	/// <summary>
	/// Displays search menu and prompts user for input
	/// </summary>
	/// <param name="param"></param>
	/// <returns></returns>
	void searchMenu() {
		String mainMenu = (
				"__________________________________\n"
				+"___________ Search By: ___________\n"
				+ "1: Genre       "
				+ " 3: View all\n"
				+ "2: Duration     "
				+ "4: Back\n")
				+ "\n"
				+ "_____________________\n"
				+ "5: Exit program\n";
		System.out.print(mainMenu);

		// USER INPUT TO SELECT MENU OPTION
		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				// DISPLAYS GENRE OPTIONS AND CALLS genreSearch METHOD WITH USERS INPUT VALUE
				if (albumCount==0){
					System.out.println("No albums to search, please add an album.");
				} else {
					System.out.println("________________________________________");
					System.out.println("___________ Search by genre: ___________");
					System.out.println("1: Rock");
					System.out.println("2: Pop");
					System.out.println("3: Hip-Hop");
					System.out.println("4: Bossa Nova");
					System.out.println("_____________________\n");
					System.out.println("5: Exit program");
					genreSearch(Integer.parseInt(console.nextLine()));
				}
				break;
			case 2:
				// CALLS durationSearch METHOD WITH USERS INPUT VALUE
				if (albumCount==0){
					System.out.println("No albums to search, please add an album.");
				} else {
					System.out.println("____________________________________________________________");
					System.out.println("________ Search by duration shorter than: (minutes) ________");
					durationSearch(Integer.parseInt(console.nextLine()));
				}
				break;
			case 3:
				if (albumCount==0){
					System.out.println("No albums to search, please add an album.");
				} else {
					viewAllSong();
				}
				break;
			case 4:
				break;
			case 5:
				exit = 1;
				break;
			default:
				rebootFunction();
				break;
		}
	}

	/// <summary>
	/// Searches all songs for particular genre. Outputs a list of albums and songs.
	/// </summary>
	/// <param name="genreID"> Identifier of the genre to search for </param>
	/// <returns></returns>
	void genreSearch(int genreID){
		if (album1.getSongCount()+album2.getSongCount()+album3.getSongCount()==0){
			System.out.println("No songs available to search.\n");
		} else
		{
			String searchResult = "";
			if (album1.getAlbumName() != "Empty Slot") {
				searchResult += album1.listSongsGenre(genreID);
			}
			if (album2.getAlbumName() != "Empty Slot") {
				searchResult += album2.listSongsGenre(genreID);
			}
			if (album3.getAlbumName() != "Empty Slot") {
				searchResult += album3.listSongsGenre(genreID);
			}
			System.out.println(searchResult);
		}
	}

	/// <summary>
	/// Searches all songs under particular duration. Outputs a list of albums and songs.
	/// </summary>
	/// <param name="durationTime"> Upper limit of song duration </param>
	/// <returns></returns>
	void durationSearch(int durationTime){
		if (album1.getSongCount()+album2.getSongCount()+album3.getSongCount()==0){
			System.out.println("No songs available to search.\n");
		} else
		{
			String searchResult = "";
			if (album1.getAlbumName() != "Empty Slot") {
				searchResult += album1.listSongsDuration(durationTime);
			}
			if (album2.getAlbumName() != "Empty Slot") {
				searchResult += album2.listSongsDuration(durationTime);
			}
			if (album3.getAlbumName() != "Empty Slot") {
				searchResult += album3.listSongsDuration(durationTime);
			}
			System.out.println(searchResult);
		}
	}

	//#####################################################################//
	///////////////////////// ALBUM OPTIONS MENU ////////////////////////////

	/// <summary>
	/// Gives the user choices such as list songs, add songs and delete songs.
	/// </summary>
	/// <param name="currentAlbum"> The album object to search within </param>
	/// <returns></returns>
	void albumMenu(int currentAlbum) {
		System.out.println("___________________________");
		System.out.println("______Album: " + albums[currentAlbum].getAlbumName() + "_______");
		System.out.println("1: List songs");
		System.out.println("2: Add song");
		System.out.println("3: Delete song");
		System.out.println("______________________________\n");
		System.out.println("4: Back       5: Exit program");

		//USER INPUT//
		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				if (albums[currentAlbum].getSongCount() > 0) {
					System.out.println(albums[currentAlbum].listSongs(false));
					System.out.println("----------------------------");
					String back = console.nextLine();
				}
				else{
					System.out.println("You have not added any songs.");
				}
				albumMenu(currentAlbum);
				break;
			case 2:
				createNewSong(albums[currentAlbum]);
				albumMenu(currentAlbum);
				break;
			case 3:
				songDeleteMenu(albums[currentAlbum]);
				albumMenu(currentAlbum);
				break;
			case 4:
				break;
			case 5:
				exit = 1;
				break;
			default:
				rebootFunction();
				break;
		}


		/*
		System.out.println("___________________________");
		System.out.println("______Album: " + currentAlbum.getAlbumName() + "_______");
		System.out.println("1: List songs");
		System.out.println("2: Add song");
		System.out.println("3: Delete song");
		System.out.println("______________________________\n");
		System.out.println("4: Back       5: Exit program");

		//USER INPUT//
		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				if (currentAlbum.getSongCount() > 0) {
					System.out.println(currentAlbum.listSongs(false));
					System.out.println("----------------------------");
					String back = console.nextLine();
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
				break;
			case 5:
				exit = 1;
				break;
			default:
				rebootFunction();
				break;
		}

		 */
	}



	//#####################################################################//
	///////////////////////// ALBUM CREATE MENU /////////////////////////////

	/// <summary>
	/// If not full, allows user to create a new album
	/// </summary>
	/// <param name="newAlbumName"> Name of new album </param>
	/// <returns></returns>
	int albumCreate(String newAlbumName) {
		int albumIndex=0;

		if (albumCount < MAX_ALBUMS)
		{
			for (int i = 0; i<albums.length;i++)
			{
				if (albums[i].getAlbumName() == "Empty Slot")
				{
					System.out.println("overwriting slot " + i);
					// System.out.println("Album name: ");
					// String newAlbumName = console.nextLine();
					// Check if album name already exists
					if (!albumCheckName(newAlbumName)) {
						albums[i].setAlbumName(newAlbumName);
						System.out.println(newAlbumName + " has been successfully added.");
						albumCount += 1;
					}
					else{
						System.out.println("Album already exists. ");
					}
					albumIndex=i;
					break;
				}
			}
		}
		else{
			System.out.println("Album slots are full.");
			albumIndex=-1;
		}
		return albumIndex;
		/*
		// If slots not full
		if(albumCount<3) {
			System.out.println("Album name: ");

			String newAlbumName = console.nextLine();
			// Check if album name already exists
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
				System.out.println(newAlbumName + " has been successfully added.");
			}
		}
		else{
			System.out.println("Album slots are full.");
		}

		 */
	}

	//#####################################################################//
	///////////////////////// ALBUM VIEW MENU ///////////////////////////////

	/// <summary>
	/// Displays main album menu
	/// </summary>
	/// <param name=""></param>
	/// <returns></returns>
	void albumView() {
		if (albumCount > 0)
		{
			System.out.println("__________________________");
			System.out.println("_________ Albums _________");
			System.out.println("Select one to make changes: ");

			for (int i = 0; i < albums.length; i++)
			{
				if (albums[i].getAlbumName() != "Empty Slot")
				{
					System.out.println((i + 1) + ": " + albums[i].getAlbumName());
				}
			}

			System.out.print("----------------\n5: Delete an album\t\t6: Back\n");

			String input = console.nextLine();


			if (Integer.parseInt(input) > albumCount)
			{
				if (Integer.parseInt(input) == 5)
				{
					deleteAlbumMenu();
				}
				else if (Integer.parseInt(input) == 6)
				{
					//break;
				}
				else{
					rebootFunction();
				}
			}
			else{
				System.out.println("displaying info of " + albums[Integer.parseInt(input) - 1].getAlbumName());
				albumMenu(Integer.parseInt(input) - 1);
			}

		}
		else{
			System.out.print("You have not added any albums!\n");
		}

		/*
		if(albumCount > 0) {
			System.out.println("__________________________");
			System.out.println("_________ Albums _________");
			System.out.println("Select one to make changes: ");
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
			System.out.print("----------------\n4: Delete an album\t\t5: Back\n");

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
					}else
					{
						rebootFunction();
					}
					break;
				case 3:
					if (albumCount > 2)
					{
						albumMenu(album3);
					}
					else
					{
						rebootFunction();
					}
					break;
				case 4:
					deleteAlbumMenu();
					break;
				case 5:
					break;
				default:
					rebootFunction();
			}
		}
		else{
			System.out.print("You have not added any albums!\n");
		}

		 */
	}

	//#####################################################################//
	///////////////////////// ALBUM DELETE MENU /////////////////////////////

	/// <summary>
	/// Displays list of albums to delete
	/// </summary>
	/// <param name=""></param>
	/// <returns></returns>
	void deleteAlbumMenu(){
		System.out.println("_____________________________________________");
		System.out.println("___ Which album would you like to delete? ___");
		for (int i = 0; i < albums.length; i++)
		{
			if (albums[i].getAlbumName() != "Empty Slot")
			{
				System.out.println(i + 1 + ": " + albums[i].getAlbumName());
			}
		}

		String input = console.nextLine();
		deleteAlbum(Integer.parseInt(input) - 1);
		}



		/*
		System.out.println("_____________________________________________");
		System.out.println("___ Which album would you like to delete? ___");
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

		 */


	//#####################################################################//
	/////////////////////////// CREATE NEW SONG /////////////////////////////

	/// <summary>
	/// Asks the user for 4 inputs. name, artist, genre and duration
	/// </summary>
	/// <param name="selectedAlbum"> The album under which the song is created. </param>
	/// <returns></returns>
	void createNewSong(Album selectedAlbum) {
		// Checks if under song limit (getSongCount()) < 4
		if (selectedAlbum.getSongCount() < 4) {
			String genreMenu = (
					"___________________________________\n"
							+ "___________Select Genre:___________\n"
							+ "1: Rock\t\t"
							+ "3: Hip-Hop\n"
							+ "2: Pop\t\t"
							+ "4: Bossa Nova\n");
			String newSongName;
			String newArtist;
			String newDuration;
			String newGenre;
			int genre;
			int duration;
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
			selectedAlbum.createNewSong(newSongName, newArtist, duration, genre);
			/*
			// Checks if album duration is less than the maximum when song is added.
			if(selectedAlbum.getTotalTime()+duration<selectedAlbum.getMaxTime())
			{
				// Checks if song exists already in album
				if(selectedAlbum.song1.songMatches(newSongName,newArtist,duration) || selectedAlbum.song2.songMatches(newSongName,newArtist,duration) ||
						selectedAlbum.song3.songMatches(newSongName,newArtist,duration) || selectedAlbum.song4.songMatches(newSongName,newArtist,duration))
				{
					System.out.println("Song already exists.");
				}
				else
				{
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

					System.out.println(newSongName + " has been added to " + selectedAlbum.getAlbumName());
				}
			}
			else{
				System.out.println("Failed to create song, duration of album exceeds limit.");
			}

		}else{
			System.out.println("Failed to create song, album is full. Please delete a song.");
		} */
		}
	}

	//#####################################################################//
	/////////////////////////// SONG DELETE MENU ///////////////////////////

	/// <summary>
	/// Displays list of songs to delete.
	/// </summary>
	/// <param name="selectedAlbum"> The album under which the song is deleted. </param>
	/// <returns></returns>
	void songDeleteMenu(Album selectedAlbum){

		int tempSongCount = selectedAlbum.getSongCount();
		String tempSongName="";
		if (tempSongCount > 0) {
			System.out.println("____________________________________________");
			System.out.println("___ Which song would you like to delete? ___");
			System.out.println(selectedAlbum.listSongs(true));
			System.out.println("____________________________________________");

			String input = console.nextLine();
			switch (Integer.parseInt(input))
			{
				case 1:
					//delete song 1
					tempSongName = selectedAlbum.song1.getName();
					switch (tempSongCount){
						case 1:
							//if there is only 1 song in the album:
							deleteSong(selectedAlbum, 1);
							break;
						case 2:
							//take data from *song 2* and move it to *song 1* ... *song 2* gets deleted.
							selectedAlbum.song1.setName(selectedAlbum.song2.getName());
							selectedAlbum.song1.setArtist(selectedAlbum.song2.getArtist());
							selectedAlbum.song1.setDuration(selectedAlbum.song2.getDuration());
							selectedAlbum.song1.setGenre(selectedAlbum.song2.getGenre());
							deleteSong(selectedAlbum, 2);
							break;
						case 3:
							//take data from *song 3* and move it to *song 1* ... *song 3* gets deleted.
							selectedAlbum.song1.setName(selectedAlbum.song3.getName());
							selectedAlbum.song1.setArtist(selectedAlbum.song3.getArtist());
							selectedAlbum.song1.setDuration(selectedAlbum.song3.getDuration());
							selectedAlbum.song1.setGenre(selectedAlbum.song3.getGenre());
							deleteSong(selectedAlbum, 3);
							break;
						case 4:
							//take data from *song 4* and move it to *song 1* ... *song 4* gets deleted.
							selectedAlbum.song1.setName(selectedAlbum.song4.getName());
							selectedAlbum.song1.setArtist(selectedAlbum.song4.getArtist());
							selectedAlbum.song1.setDuration(selectedAlbum.song4.getDuration());
							selectedAlbum.song1.setGenre(selectedAlbum.song4.getGenre());
							deleteSong(selectedAlbum, 4);
							break;
					}
					break;
				case 2:
					//delete song 2
					tempSongName = selectedAlbum.song2.getName();
					switch (tempSongCount){
						case 2:
							//if there are only 2 songs in the album:
							deleteSong(selectedAlbum, 2);
							break;
						case 3:
							//take data from *song 3* and move it to *song 2* ... *song 3* gets deleted.
							selectedAlbum.song2.setName(selectedAlbum.song3.getName());
							selectedAlbum.song2.setArtist(selectedAlbum.song3.getArtist());
							selectedAlbum.song2.setDuration(selectedAlbum.song3.getDuration());
							selectedAlbum.song2.setGenre(selectedAlbum.song3.getGenre());
							deleteSong(selectedAlbum, 3);
							break;
						case 4:
							//take data from *song 4* and move it to *song 2* ... *song 4* gets deleted.
							selectedAlbum.song2.setName(selectedAlbum.song4.getName());
							selectedAlbum.song2.setArtist(selectedAlbum.song4.getArtist());
							selectedAlbum.song2.setDuration(selectedAlbum.song4.getDuration());
							selectedAlbum.song2.setGenre(selectedAlbum.song4.getGenre());
							deleteSong(selectedAlbum, 4);
							break;
					}
					break;
				case 3:
					//delete song 3
					tempSongName = selectedAlbum.song3.getName();
					switch (tempSongCount){
						case 3:
							//if there are only 3 songs in the album:
							deleteSong(selectedAlbum, 3);
							break;
						case 4:
							//take data from *song 4* and move it to *song 3* ... *song 4* gets deleted.
							selectedAlbum.song3.setName(selectedAlbum.song4.getName());
							selectedAlbum.song3.setArtist(selectedAlbum.song4.getArtist());
							selectedAlbum.song3.setDuration(selectedAlbum.song4.getDuration());
							selectedAlbum.song3.setGenre(selectedAlbum.song4.getGenre());
							deleteSong(selectedAlbum, 4);
							break;
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
		System.out.println(tempSongName + " deleted successfully");
		}
		else{
			System.out.println("* You have not added any songs yet! *");
		}
	}

	//###########################################################################//
	//////////////////////Secondary Functions//////////////////////////////////////
	//These contain no user input

	/// <summary>
	/// Displays all songs
	/// </summary>
	/// <param name=""></param>
	/// <returns></returns>
    void viewAllSong() {
		// Check if songs have been made
		if (album1.getSongCount()+album2.getSongCount()+album3.getSongCount()==0) {
			System.out.println("No songs available to search.\n");
		} else {
			if (album1.getAlbumName() != "Empty Slot") {
				System.out.println(album1.listSongs(false));
			}
			if (album2.getAlbumName() != "Empty Slot") {
				System.out.println(album2.listSongs(false));
			}
			if (album3.getAlbumName() != "Empty Slot") {
				System.out.println(album3.listSongs(false));
			}
		}
    }

	/// <summary>
	/// Displays error message
	/// </summary>
	/// <param name=""></param>
	/// <returns></returns>
	void rebootFunction() {
		System.out.println("Invalid input\n");
	}

	/// <summary>
	/// Initialise album objects
	/// </summary>
	/// <param name=""></param>
	/// <returns></returns>
	void initialiseAlbums() {
		for (int i = 0; i<albums.length;i++)
		{
			albums[i] = new Album();
		}
		/*
		albumCount = 0;
		album1 = new Album();
		album2 = new Album();
		album3 = new Album();

		 */
	}

	/// <summary>
	/// Deletes song
	/// </summary>
	/// <param name="selectedAlbum"> Album where song is deleted </param>
	/// <param name="selectedSong"> Song being deleted </param>
	/// <param name="tempName"> </param>
	/// <returns></returns>
	//delete song function ... called from "songDeleteMenu()"... resetsSong and reduces songCount value by 1.
	void deleteSong(Album selectedAlbum, int selectedSong)
	{
		switch (selectedSong)
		{
			case 1:
				selectedAlbum.song1.resetSong();
				selectedAlbum.setSongCount(selectedAlbum.getSongCount() - 1);
				break;
			case 2:
				selectedAlbum.song2.resetSong();
				selectedAlbum.setSongCount(selectedAlbum.getSongCount() - 1);
				break;
			case 3:
				selectedAlbum.song3.resetSong();
				selectedAlbum.setSongCount(selectedAlbum.getSongCount() - 1);
				break;
			case 4:
				selectedAlbum.song4.resetSong();
				selectedAlbum.setSongCount(selectedAlbum.getSongCount() - 1);
				break;
		}
	}

	/// <summary>
	/// Deletes album
	/// </summary>
	/// <param name=""></param>
	/// <returns></returns>
	void deleteAlbum(int selectedAlbum){

		String tempName = albums[selectedAlbum].getAlbumName();
		albums[selectedAlbum].resetAlbum();
		albumCount -= 1;
		System.out.println(tempName + " has been successfully deleted");
		if(albumCount > 0) {
			albumView();
		}
	}

	// album data switch. will take song data from *albumFrom* and set to *albumTo*
	// this is called from "albumDeleteMenu()" and allows albums to switch places
	// to prevent any display errors within the menu functionality.
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
				//no songs.. do nothing.
				break;
		}

		albumFrom.resetAlbum();
		albumCount -= 1;
		System.out.println(tempName + " has been successfully deleted");
		albumView();
	}

	boolean albumCheckName(String newName){
		for (int i = 0; i < albums.length; i++)
		{
			if (albums[i].albumNameMatches(newName))
			{
				return true;
			}
			else{
				return false;
			}
		}
		return false;

	}

	//#####################################################################//
	/////////////////////////// IMPORT ALBUM ///////////////////////////

	/// <summary>
	/// Imports details of album and songs and creates object
	/// </summary>
	/// <param></param>
	/// <returns></returns>
	void importAlbum() {
		String path;
		String lastToken,currentToken;
		int currentAlbumIndex=0;

		Scanner inputStream = null;
		int lines = 0;

		System.out.println("Please type the name of the file you want to import (from same folder): ");
		path = console.nextLine();

		try {
			inputStream = new Scanner (new File(path));
		} catch(FileNotFoundException e){
			System.out.println("Error opening the file "+path);
		}

		String contextToken = "";

		while(inputStream.hasNextLine()){
			String currentLine;
			String tokenValue;
			lines+=1;
			currentLine = inputStream.nextLine();
			if(currentLine.length()==0){
				continue;
			}
			int tokenEnd = 0;
			if(currentLine.indexOf(" ") == -1) {
				tokenEnd = currentLine.length();
				tokenValue = " ";
			} else {
				tokenEnd = currentLine.indexOf(" ");
				tokenValue = currentLine.substring(currentLine.indexOf(" ")+1,currentLine.length());
			}
			currentToken = currentLine.substring(0,tokenEnd);
			if(currentToken.equals("Album")){
				currentAlbumIndex = albumCreate(tokenValue);
				if(currentAlbumIndex==-1){
					System.out.println("error blah");
				}
				contextToken="Album";
			} else if (currentToken.equals("Songs")){
				contextToken="Songs";
			}
			else if (contextToken.equals("Songs")){
				String name = currentLine.substring(currentLine.indexOf(" ")+1,currentLine.length());
				currentLine = inputStream.nextLine();
				String artist = currentLine.substring(currentLine.indexOf(" ")+1,currentLine.length());
				currentLine = inputStream.nextLine();
				String duration = currentLine.substring(currentLine.indexOf(" ")+1,currentLine.length());
				currentLine = inputStream.nextLine();
				String genre = "1";
				//String genre = currentLine.substring(currentLine.indexOf(" ")+1,currentLine.length());
				albums[currentAlbumIndex].createNewSong(name,artist,Integer.parseInt(duration),Integer.parseInt(genre));
			}
		}
	}

	//###########################################################################//
}



