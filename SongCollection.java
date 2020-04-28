import java.util.*;
/*

Authors: Xavier Williams, Riley Lane
Version: 28/04/2020
*/

//////////////////////////////////////////////////////////////////////////////////////////////
public class SongCollection
{
	//private Album album1, album2, album3;
	private Album album1;
	Scanner console = new Scanner(System.in);

	public static void main(String[] args) //////////initial function
	{
		SongCollection sg = new SongCollection();
		System.out.print("Welcome to spotify \n");
		sg.run();
	}

	/////////////////////////////////////////////////run function
	public void run()
	{
		// Have main menu as string so we can easily 'return to previous menu'
		String mainMenu = ("Select a choice from the menu: \n"
			+ "1: New album\n"
			+ "2: View albums\n"
			+ "3: Song search\n"
			+ "4: Exit program\n");

		System.out.print(mainMenu);
		String action1 = console.nextLine();
        switch (Integer.parseInt(action1))
		{
			case 1:
				//Here we will create an album
				albumCreate();
			case 2:
				//Here we will view all albums
				albumView();
			case 3:
				//Here we will search songs
				System.out.print("You have no songs!\n\n");
				run();
			case 4:
				//Here we will exit program
				System.exit(0);
			default:
				System.out.print("Fatal Error... Re booting \n\n");
			    run();
		}
	}

	void albumCreate()
	{
		System.out.print("What is the name of the album?\n");
		String name = console.nextLine();
		album1 = new Album();
		album1.setAlbumName(name);
		System.out.print(name + " has been successfully added\n\n");
		run();
	}
	void albumView()
	{
		System.out.print("These are your albums: \n");
		System.out.print(album1.getAlbumName() + "\n\n");
		run();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
}

