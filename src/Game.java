
public class Game {

	private Ship[][] board = new Ship[8][8];
	/*
	 * Board is randomly generated with Ships being the object
	 * If the ship exists at spot, inputs the Ship's object
	 * Else, inputs null object
	 */
	private int numOfHoles = 17;
	/*
	 * Total number of Ship holes used to determine when the game ends
	 */
	private int row,col;

	public void createBoard(){
		/* Create board with Math.random
		 * 	1	Carrier		5
			2	Battleship	4
			3	Cruiser		3
			4	Submarine	3
			5	Destroyer	2
		 * Ships cannot overlap or go out of bounds
		 */
		int[] shipSpace = new int[]{5, 4, 3, 3, 2};
		String[] shipName = new String[]{"Carrier","Battleship","Cruiser","Submarine","Destroyer"};
		int counter = 0;
		while(counter < 5){
			int x = (int)Math.random()*8;
			int y = (int)Math.random()*8;
			//true == vertical, false == horizontal
			boolean orien = (int)Math.random()*2 == 1;
			if(board[x][y]==null){
				if(orien){
					if(shipSpace[counter]+x < 8){
						boolean passed = true;
						for(int i = x; i < x + shipSpace[counter]; i++){
							if(boards[i][y] != null)
								passed = false;
						}
						if(passed){
							Ship temp = new Ship(shipName[counter],shipSpace[counter]);
							for (int i = x; i < x + shipSpace[counter]; i++){
								board[i][y] = temp;
							}
							counter++;
						}
					}
				}
				else{
					if(shipSpace[counter]+y < 8){
						boolean passed = true;
						for(int i = y; i < y + shipSpace[counter]; i++){
							if(boards[x][i] != null)
								passed = false;
						}
						if(passed){
							Ship temp = new Ship(shipName[counter],shipSpace[counter]);
							for (int i = y; i < y + shipSpace[counter]; i++){
								board[x][i] = temp;
							}
							counter++;

						}
							//create object
					}
				}
			}
		}
	}

	public boolean checkHit(int x, int y){
		/*
		 * Checks if the ship has been hit. Returns the ship that was hit
		 * If the shot was a miss, returns null
		 * If shot was a hit, updates the board and numOfHoles accordingly
		 */
		if (board[x][y] == null){
			return false;
		}
		else{
			numOfHoles--;
			board[x][y].setHoles(board[x][y].getHoles()-1);
			board[x][y] = null;
			return true;
		}
	}

	public void printBoard(){
		/*
		 * OPTIONAL:
		 * If time permits, implement the method to print the board after every shot
		 */
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		createBoard();
		System.out.println("Enter x between 0 to 7: ");
		int x = scan.nextInt();
		System.out.println("Enter y between 0 to 7: ");
		int y = scan.nextInt();
		
	}

}
