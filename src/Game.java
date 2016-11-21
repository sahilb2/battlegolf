import java.util.Scanner; // Used to import Scanner to read user's inputs

public class Game{
    
	public static void main(String[] args){

		System.out.println("Welcome to BattleGolf!"); // Intro to BattleGolf!
		Scanner scan = new Scanner(System.in); // Used to read user's input
		int coorx = -1,coory = -1; // initializing board coordinates to -1 (invalid number)
		int counter = 0; // counter that counts number of tries
		Board board = new Board(); // Calls Board class to create the board
		System.out.println("The board is randomly set up! Lets begin the game!");
		while (board.numholes>0) // While more than 0 ships are alive. (17 holes in this game).
		{	
			System.out.println("Pick your lucky point! For example, A-3 or B-4 (Ranging from A through H for x coordinates and 1 to 8 for y-coordinates)");
			boolean isValid = false;
			while(!isValid) // checks validity of inputs
			{
				String input = scan.nextLine();
				if (input.length() == 3){
					/*
					 * The next lines of code directs inputs to coordinates in our 2d dimension.
					 * It works for both uppercase and lowercase characters.
					 * For example, A-1 => (0,0), A-2 => (0,1), and so on...
					 */
					if (input.charAt(0) == 'a' || input.charAt(0) == 'A') coorx = 0;
					if (input.charAt(0) == 'b' || input.charAt(0) == 'B') coorx = 1;
					if (input.charAt(0) == 'c' || input.charAt(0) == 'C') coorx = 2;
					if (input.charAt(0) == 'd' || input.charAt(0) == 'D') coorx = 3;
					if (input.charAt(0) == 'e' || input.charAt(0) == 'E') coorx = 4;
					if (input.charAt(0) == 'f' || input.charAt(0) == 'F') coorx = 5;
					if (input.charAt(0) == 'g' || input.charAt(0) == 'G') coorx = 6;
					if (input.charAt(0) == 'h' || input.charAt(0) == 'H') coorx = 7;
					if (input.charAt(2) == '1') coory = 0;
					if (input.charAt(2) == '2') coory = 1;
					if (input.charAt(2) == '3') coory = 2;
					if (input.charAt(2) == '4') coory = 3;
					if (input.charAt(2) == '5') coory = 4;
					if (input.charAt(2) == '6') coory = 5;
					if (input.charAt(2) == '7') coory = 6;
					if (input.charAt(2) == '8') coory = 7;					
				}
				if (coorx != -1 && coory != -1){
					isValid = true; // Gets out of the isValid loop if the coordinates are valid
				}
				else{ // Asks user to input correctly formatted coordinates until they input them
					System.out.println("Please insert the coordinate in correct format. For example, A-3 or B-4 (Ranging from A through H for x coordinates and 1 to 8 for y-coordinates)");
				}
			}
			// Calls Board class to determine if hit or miss
			if (board.hit(coorx, coory)){
				System.out.println("HIT!!!");
			}
			else{
				System.out.println("Miss :( Try Again!");
			}
			// Resets coordinates to invalid value and count of tries increases by 1
			coorx = -1;
			coory = -1;
			counter++;
		}
		// Game over! Prints the number of tries it took to finish the game!
		System.out.println("All ships have been sunk! Total number of shots taken: " + counter);
    }
}
