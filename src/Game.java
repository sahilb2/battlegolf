
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
	
	public int[][] createBoard(){
		/* Create board with Math.random
		 * 	1	Carrier		5
			2	Battleship	4
			3	Cruiser		3
			4	Submarine	3
			5	Destroyer	2
		 * Ships cannot overlap or go out of bounds
		 */
	}
	
	public Ship checkHit(int x, int y){
		/*
		 * Checks if the ship has been hit. Returns the ship that was hit
		 * If the shot was a miss, returns null
		 * If shot was a hit, updates the board and numOfHoles accordingly
		 */
	}
	
	public void printBoard(){
		/*
		 * OPTIONAL:
		 * If time permits, implement the method to print the board after every shot
		 */
	}
	
	public static void main(String[] args) {

	}

}
