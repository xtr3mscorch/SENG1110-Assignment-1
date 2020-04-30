import java.util.*;
/*

Authors: Xavier Williams, Riley Lane
Version: 29/04/2020
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

	// MAIN MENU //
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

	// SONG SEARCH MENU //
	void searchMenu() {
		String mainMenu = ("___________Search By:___________\n"
				+ "1: Genre       "
				+ " 3: View all\n"
				+ "2: Duration     "
				+ "4: Exit program\n");
		System.out.print(mainMenu);

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

	void albumMenu(Album currentAlbum) {
		System.out.println("Menu");
		System.out.println("1: List songs");
		System.out.println("2: Add song");
		System.out.println("3: Delete song");
		System.out.println("4: Back/exit thing");

		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				currentAlbum.listSongs();
				break;
			case 2:
				currentAlbum.createSong();
				break;
		}
	}

	////////////////////////User Input Functions/////////////////////////////////////////////

	////create album ... renames empty slots to user input
	void albumCreate() {
		System.out.println("Album name: ");
		String newAlbumName = console.nextLine();

		if (albumCount<3)
		{
			if(album1.albumNameMatches(newAlbumName) || album2.albumNameMatches(newAlbumName) || album3.albumNameMatches(newAlbumName))
			{
				System.out.println("Album already exists. ");
			}
			else{
				albumCount += 1;
				switch(albumCount)
				{
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
		//OBSOLETE
		/*
		System.out.print("Which album slot would you like to overwrite?\n");
		System.out.print("1: " + album1.getAlbumName() + "\n");
		System.out.print("2: " + album2.getAlbumName() + "\n");
		System.out.print("3: " + album3.getAlbumName() + "\n");
		System.out.print("----------------\n4: Back\n");

		//USER INPUT//
		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				renameAlbum(1);
			case 2:
				renameAlbum(2);
			case 3:
				renameAlbum(3);
			case 4:
				run();
			default:
				rebootFunction();
		}*/

	}

	//view album function.. work in progress / testing
	void albumView() {
		System.out.print("_________Albums: select one_________\n");
		System.out.print("1: " + album1.getAlbumName() + "\n");
		System.out.print("2: " + album2.getAlbumName() + "\n");
		System.out.print("3: " + album3.getAlbumName() + "\n");
		System.out.print("----------------\n4: Back\n");

		//USER INPUT//
		//**Add check if album exists feature**
		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				albumMenu(album1);
				break;
			case 2:
				albumMenu(album2);
				break;
			case 3:
				albumMenu(album3);
				break;
			case 4:
				run();
				break;
			default:
				rebootFunction();
		}
	}

	///////////////Secondary Functions (these get called from a user input function)//////////////////////

	void renameAlbum(int selection) {
		System.out.print("What is the name of the album?\n");
		switch (selection) {
			case 1:
				album1.setAlbumName(console.nextLine());
				System.out.print(album1.getAlbumName() + " has been successfully added to slot 1\n\n");
				run();
				break;
			case 2:
				album2.setAlbumName(console.nextLine());
				System.out.print(album2.getAlbumName() + " has been successfully added to slot 2\n\n");
				run();
				break;
			case 3:
				album3.setAlbumName(console.nextLine());
				System.out.print(album3.getAlbumName() + " has been successfully added to slot 3\n\n");
				run();
				break;
			case 4:
				run();
				break;
			default:
				rebootFunction();
				break;
		}
	}

    // Method to view all songs, calls listing method from Album.java
    void viewAllSong() {
        album1.listSongs();
        album2.listSongs();
        album3.listSongs();
    }


	/////////////////////////Background Functions//////////////////////////////////
	void rebootFunction() {
		System.out.print("Fatal Error... rebooting \n\n");
		run();
	}

	// Initialise new albums
	void initialiseAlbums() {
		albumCount = 0;
		album1 = new Album();
		album2 = new Album();
		album3 = new Album();
	}
}



