import java.util.*;
/*

Authors: Xavier Williams, Riley Lane
Version: 29/04/2020
*/

public class SongCollection {
	private Album album1, album2, album3;
	Scanner console = new Scanner(System.in);

	public static void main(String[] args)
	{
		SongCollection sg = new SongCollection();
		sg.initialiseAlbums();
		System.out.print("Welcome to spotify \n");
		sg.run();
	}

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
			case 2:
				albumView();
			case 3:
				//Here we will search songs
				System.out.print("You have no songs!\n\n");
				run();
			case 4:
				System.exit(0);
			default:
				rebootFunction();
		}
	}
	////////////////////////User Input Functions/////////////////////////////////////////////

	////create album ... renames empty slots to user input (gets send to "rename album" function)
	void albumCreate() {
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
		}
	}

	//view album function.. work in progress / testing
	void albumView() {
		System.out.print("_________Albums_________\n");
		System.out.print("1: " + album1.getAlbumName() + "\n");
		System.out.print("2: " + album2.getAlbumName() + "\n");
		System.out.print("3: " + album3.getAlbumName() + "\n");
		System.out.print("----------------\n4: Back\n");

		//USER INPUT//
		String input = console.nextLine();
		switch (Integer.parseInt(input)) {
			case 1:
				//views songs? another menu of album options?
			case 2:
				//views songs? another menu of album options?
			case 3:
				//views songs? another menu of album options?
			case 4:
				run();
			default:
				rebootFunction();
		}

	}

	///////////////Secondary Functions (these get called from a user input function)//////////////////////

	void renameAlbum(int selection)
	{
		System.out.print("What is the name of the album?\n");
		switch (selection)
		{
			case 1:
				album1.setAlbumName(console.nextLine());
				System.out.print(album1.getAlbumName() + " has been successfully added to slot 1\n\n");
				run();
			case 2:
				album2.setAlbumName(console.nextLine());
				System.out.print(album2.getAlbumName() + " has been successfully added to slot 2\n\n");
				run();
			case 3:
				album3.setAlbumName(console.nextLine());
				System.out.print(album3.getAlbumName() + " has been successfully added to slot 3\n\n");
				run();
			case 4:
				run();
			default:
				rebootFunction();
		}
	}

	/////////////////////////Background Functions//////////////////////////////////
	void rebootFunction()
	{
		System.out.print("Fatal Error... rebooting \n\n");
		run();
	}
	/////This is called on program start... assigns each name to empty slot
	void initialiseAlbums() {
		album1 = new Album();
		album2 = new Album();
		album3 = new Album();
		album1.setAlbumName("Empty Slot");
		album2.setAlbumName("Empty Slot");
		album3.setAlbumName("Empty Slot");
	}
}