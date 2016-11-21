import java.util.Scanner;

public class Game{

	public static void main(String[] args){

		System.out.println("Welcome to BattleGolf!");
		Scanner scan = new Scanner(System.in);
		int coorx = -1,coory = -1;
		Board board = new Board();
		board.printBoard();
		System.out.println("The board is randomly set up! Lets begin the game!");

		while (board.numholes>0) // while game not done...
		{
			System.out.println("Pick your lucky point! For example, A-3 or B-4 (Ranging from A through H for x coordinates and 1 to 8 for y-coordinates)");
			boolean isValid = false;
			while(!isValid) // checks validity of
			{
				String input = scan.nextLine();
				if (input.length() == 3){
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
					isValid = true;
				}
				else{
					System.out.println("Please insert the coordinate in correct format. For example, A-3 or B-4 (Ranging from A through H for x coordinates and 1 to 8 for y-coordinates)");
				}
			}
			if (board.hit(coorx, coory) != null){
				System.out.println("HIT!!!");
				String shipName = board.hit(coorx, coory).getName();
				int shipHoles = board.hit(coorx, coory).getHoles();
				System.out.println("You hit " + shipName + " and it now has " + shipHoles + " holes remaining!");
				board.setNull(coorx, coory);
				coorx = -1;
				coory = -1;
			}
			else{
				System.out.println("Miss :( Try Again!");
			}
			board.printBoard();
		}
    }
}
