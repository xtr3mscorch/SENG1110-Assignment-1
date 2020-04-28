import java.util.*;
/*

Authors: Xavier Williams, Riley Lane
Version: 28/04/2020
*/


public class SongCollection
{
	//private Album album1, album2, album3;
	
	int action1;

	public void run()
	{
		Scanner console = new Scanner(System.in);
		
		// Have main menu as string so we can easily 'return to previous menu'
		String mainMenu = ("Select a choice from the menu: "
			+ "1: New album\n"
			+ "2: View albums\n"
			+ "3: Song search\n"
			+ "4: Exit program\n");

		System.out.print(mainMenu);
		action1 = console.nextInt();	

        switch (action1)		
		{
			case 1:
				System.out.print("Here we will create an album");
			    run();
			case 2:
				System.out.print("You have no albums!");
				run();
			case 3:
				System.out.print("You have no songs!");
				run();
			case 4:
				System.exit(0);
			default:
				System.out.print("Fatal Error... Re booting \n");
			    run();
		}
		
		
	}
	public static void main(String[] args) 
	{
		SongCollection sg = new SongCollection();
		System.out.print("Welcome to spoofify \n");
		sg.run();
	}
}

