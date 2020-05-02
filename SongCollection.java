import java.util.*;
/*

Authors: Xavier Williams, Riley Lane
Version: 30/04/2020
*/

public class SongCollection {
	private Album album1, album2, album3;
	Scanner console = new Scanner(System.in);
	int albumCount;

	public static void main(String[] args) {
		SongCollection sg = new SongCollection();
		sg.initialiseAlbums();
		System.out.print("Welcome to spotify \n");
		sg.run();
	}

	//###########################################################################//
	//////////////////////////////Main Menu////////////////////////////////////////
	public void run() {
		String mainMenu = ("____________Main Menu___________\n"
				+ "1: Add album       "
				+ "3: Song search\n"
				+ "2: View albums     "
				+ "4: Exit program\n");
		System.out.print(mainMenu);

		///USER INPUT///
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

	//###########################################################################//
	//////////////////////User Input Functions/////////////////////////////////////

	//#############################################//
	// SONG SEARCH MENU //
	void searchMenu() {
		String mainMenu = ("___________Search By:___________\n"
				+ "1: Genre       "
				+ " 3: View all\n"
				+ "2: Duration     "
				+ "4: Exit program\n");
		System.out.print(mainMenu);

		//USER INPUT//
		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				// Genre search feature
				break;
			case 2:
				// Song length feature
				break;
			case 3:
				viewAllSong();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				rebootFunction();
				break;
		}
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
				currentAlbum.listSongs();
				albumMenu(currentAlbum);
				break;
			case 2:
				currentAlbum.createSong();
				albumMenu(currentAlbum);
				break;
			case 3:
				//delete song function
				run();
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
			run();
		}
		else{
			System.out.println("album slots are full.");
			run();
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
					run();
					break;
				default:
					rebootFunction();
			}
		}
		else{
			System.out.print("You have not added any albums!\n");
			run();
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
			case 1:
				//delete album 1

				//if album count == 2
				    //album 2 data -> album 1
				//if album count == 3
				    //album 3 data -> album 1
				break;
			case 2:
				if (albumCount > 1)
				{
					//delete album 2
					// if album count == 3
					    //move album 3 data -> album 2
				}
				else{
					rebootFunction();
				}
				break;
			case 3:
				if (albumCount > 2){
					deleteAlbum(album3);
				}
				else{
					rebootFunction();
				}
				break;
			case 4:
				albumView();
				break;
			default:
				rebootFunction();
				break;
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
		System.out.println("Fatal Error... rebooting\n");
		run();
	}

	// Initialise new albums
	void initialiseAlbums() {
		albumCount = 0;
		album1 = new Album();
		album2 = new Album();
		album3 = new Album();
	}

	void deleteAlbum(Album selectedAlbum){
		String tempName = selectedAlbum.getAlbumName();
		selectedAlbum.resetAlbum();
		albumCount -= 1;
		System.out.println(tempName + " has been successfully deleted");
		albumView();
	}
	//###########################################################################//
}



