import java.util.*;
/*

Authors: Xavier Williams, Riley Lane
Version: 28/04/2020
*/

//////////////////////////////////////////////////////////////////////////////////////////////
public class SongCollection
{
	//private Album album1, album2, album3;
	//private Album album1;
	Scanner console = new Scanner(System.in);

	//////////////////////////////////////////////////////////////////////////////////////////////
	public void run()
	{
		// Have main menu as string so we can easily 'return to previous menu'
		String mainMenu = ("Select a choice from the menu: \n"
			+ "1: New album\n"
			+ "2: View albums\n"
			+ "3: Song search\n"
			+ "4: Exit program\n");

		System.out.print(mainMenu);
		int action1 = console.nextInt();
		console.nextLine(); // without this, console will skip any NextLine() input.. weird
        switch (action1)		
		{
			case 1:
				//Here we will create an album
				System.out.print("Here we will create an album\n");
			case 2:
				//Here we will view all albums
				System.out.print("Here we will view all album\n");
			case 3:
				//Here we will search songs
				System.out.print("You have no songs!\n");
				run();
			case 4:
				//Here we will exit program
				System.exit(0);
			default:
				System.out.print("Fatal Error... Re booting \n");
			    run();
		}
		System.out.print("End \n");
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) 
	{
		SongCollection sg = new SongCollection();
		System.out.print("Welcome to spotify \n");
		sg.run();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
}

