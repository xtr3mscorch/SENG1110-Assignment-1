import java.awt.desktop.SystemSleepEvent;
import java.util.*;
import java.io.*;
/*
Authors: Xavier Williams (C3329774), Riley Lane (C3339143)
Last Edited: 11/06/2020
*/

public class SongCollection {
	Scanner console = new Scanner(System.in);
	private int albumCount=0,exit=0;
	private final int MAX_ALBUMS = 4;
	private Album albums[] = new Album[MAX_ALBUMS];

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
					+ "4: Import album\n")
					+ "________________________________\n"
					+ "5: Exit program\n";
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
					importAlbum();
					break;
				case 5:
					exit=1;
					break;
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
				+ "4: Name\n")
				+ "5: Back"
				+ "\n"
				+ "_____________________\n"
				+ "6: Exit program\n";
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
				if (albumCount==0){
					System.out.println("No albums to search, please add an album.");
				} else {
					System.out.println("______________________________________");
					System.out.println("________ Search by song name: ________");
					nameSearch(console.nextLine());
				}
				break;
			case 5:
				break;
			case 6:
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
		if (!totalSongCountZero())
		{
			String searchResult = "";
			for (int i=0;i<albums.length;i++){
				if (albums[i].getAlbumName()!="Empty Slot" && albums[i].getSongCount() != 0)
				{
					searchResult += albums[i].listSongsGenre(genreID);
				}
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

		if (!totalSongCountZero())
		{
			String searchResult = "";
			for (int i=0;i<albums.length;i++){
				if (albums[i].getAlbumName() != "Empty Slot" && albums[i].getSongCount() != 0){
					searchResult += albums[i].listSongsDuration(durationTime);
				}
			}
			System.out.println(searchResult);
		}
	}

	void nameSearch(String name){
		if (!totalSongCountZero())
		{
			String searchResult = "";
			for (int i=0;i<albums.length;i++){
				if (albums[i].getAlbumName() != "Empty Slot" && albums[i].getSongCount() != 0)
				{
					searchResult += albums[i].listSongsName(name);
				}
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
					System.out.println("4: Back");
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


			if (Integer.parseInt(input) > 0 && Integer.parseInt(input) < MAX_ALBUMS)
			{
				if (albums[Integer.parseInt(input) - 1].getAlbumName() != "Empty Slot")
				{
					System.out.println("displaying info of " + albums[Integer.parseInt(input) - 1].getAlbumName());
					albumMenu(Integer.parseInt(input) - 1);
				}
				else{
					rebootFunction();
				}
			}
			else if(Integer.parseInt(input) == 5){
				deleteAlbumMenu();
			}
			else if(Integer.parseInt(input) == 6){
				//break
			}
			else{
				rebootFunction();
			}

		}
		else{
			System.out.print("You have not added any albums!\n");
		}
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


	//#####################################################################//
	/////////////////////////// CREATE NEW SONG /////////////////////////////

	/// <summary>
	/// Asks the user for 4 inputs. name, artist, genre and duration
	/// </summary>
	/// <param name="selectedAlbum"> The album under which the song is created. </param>
	/// <returns></returns>
	void createNewSong(Album selectedAlbum) {
		// Checks if under song limit (getSongCount()) < album MAX_SONGS
		if (selectedAlbum.getSongCount() <= selectedAlbum.getMaxSongs()) {
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
			if (sameName(newSongName).equals("Y") || sameName(newSongName).equals(""))
			{
				System.out.println("Artist: ");
				newArtist = console.nextLine();
				System.out.println("Duration (s): ");
				newDuration = console.nextLine();
				System.out.print(genreMenu);
				newGenre = console.nextLine();

				genre = Integer.parseInt(newGenre);
				duration = Integer.parseInt(newDuration);

				if (genre > 0 && genre < 5) {
					selectedAlbum.createNewSong(newSongName, newArtist, duration, genre);
				} else {
					System.out.println("Invalid genre selection, please create again.");
				}
			} else {
				System.out.println("Song creation cancelled");
			}
		} else {
			System.out.println("Error: Album is full");
		}
	}

	String sameName(String songName){
		String userInput = "";
		String searchResult = "";
		for (int i=0;i<albums.length;i++){
			if (albums[i].getAlbumName() != "Empty Slot"){
				searchResult += albums[i].songNameMatch(songName);
			}
		}
		if (!searchResult.equals("")){
			System.out.println("Song(s) with the same name: ");
			System.out.println(searchResult);
			System.out.println("Would you like to continue? (Y/N): ");
			userInput = console.nextLine();
		}
		return userInput;
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

			tempSongName = selectedAlbum.getSongName(Integer.parseInt(input) - 1);

			if(!tempSongName.matches("Empty song"))
			{
				deleteSong(selectedAlbum, Integer.parseInt(input) - 1);
				System.out.println(tempSongName + " has been deleted successfully");
			}

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
		if(!totalSongCountZero())
		{
			for (int i = 0; i < albums.length; i++)
			{
				if (albums[i].getAlbumName() != "Empty Slot" && albums[i].getSongCount() != 0)
				{
					System.out.println("______ '" + albums[i].getAlbumName() + "' ______");
					System.out.println(albums[i].listSongs(false));
				}
			}
		}
    }

    boolean totalSongCountZero(){

		int totalSongCount = 0;
		for (int i = 0; i < albums.length; i++)
		{
			totalSongCount += albums[i].getSongCount();
		}
		if(totalSongCount == 0)
		{
			System.out.println("No songs available to search.\n");
			return(true);
		}
		else
		{
			return (false);
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
	}

	/// <summary>
	/// Deletes song
	/// </summary>
	/// <param name="selectedAlbum"> Album where song is deleted </param>
	/// <param name="selectedSong"> Song being deleted </param>
	/// <param name="tempName"> </param>
	/// <returns></returns>
	//delete song function ... called from "songDeleteMenu()"... resets Song and reduces songCount value by 1.
	void deleteSong(Album selectedAlbum, int selectedSong)
	{
		selectedAlbum.resetSong(selectedSong);
		if (selectedAlbum.getSongCount() > 0) {
			selectedAlbum.setSongCount(selectedAlbum.getSongCount() - 1);
		}

	}

	/// <summary>
	/// Deletes album
	/// </summary>
	/// <param name=""></param>
	/// <returns></returns>
	void deleteAlbum(int selectedAlbum){
		String tempName = albums[selectedAlbum].getAlbumName();
		if (!tempName.matches("Empty Slot")) {

			albums[selectedAlbum].resetAlbum();
			if (albumCount >0) {
				albumCount -= 1;
			}
			System.out.println(tempName + " has been successfully deleted");
		}
		if(albumCount > 0) {
			albumView();
		}
	}

	// album data switch. will take song data from *albumFrom* and set to *albumTo*
	// this is called from "albumDeleteMenu()" and allows albums to switch places
	// to prevent any display errors within the menu functionality.

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
					System.out.println("error");
					break;
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
				//String genre = "1";
				String genre = currentLine.substring(currentLine.indexOf(" ")+1,currentLine.length());

				// GENRE SCANNER
				int genreID=0;
				switch (genre){
					case "rock":
						genreID = 1;
						break;
					case "pop":
						genreID = 2;
						break;
					case "hip-hop":
						genreID = 3;
						break;
					case "bossa nova":
						genreID = 4;
						break;
				}
				albums[currentAlbumIndex].createNewSong(name,artist,Integer.parseInt(duration),genreID);
			}
		}
	}

	//###########################################################################//
}



