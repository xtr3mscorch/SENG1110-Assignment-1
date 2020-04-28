import java.util.*;
/**
 * Write a description of class Album here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SongCollection
{
	//private Album album1, album2, album3;
	
	int action1;

	public void run()
	{
		Scanner console = new Scanner(System.in);
			
		System.out.print("Please choose an action \n");
		
		System.out.print("1 - View Albums: \n");	
		System.out.print("2 - Song search: \n");
		System.out.print("3 - Exit program: \n");

		
		action1 = console.nextInt();	
        switch (action1)		
		{
			case 1:
			System.out.print("You have no albums!");
			run();
			case 2:
			System.out.print("You have no songs!");
			run();
			case 3:
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

