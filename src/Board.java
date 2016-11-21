public class Board{
    // Protected instance variables in order to gain accessibility throughout this package
	protected int numholes = 17;
	protected int[] shipSize = new int[]{5,4,3,3,2};
    protected int[][] boards = new int[8][8];
    
    public Board(){
    	// Constructor calls createBoard() method
    	createBoard();
    }
    
    public boolean hit(int x, int y){
		if(boards[x][y] == 1){ // if there is a ship,
		    boards[x][y] = 0; // change it to no ship
		    numholes--; // decrease number of ship holes by 1
		    return true; // return true for hit
		}
		return false; // else, return false for hit
	}
    
    public void printBoard(){
    	// Not used in main, used for debugging purposes only!
    	for (int i = 0; i < boards.length; i++){
    		for (int j = 0; j < boards[i].length; j++){
    			System.out.print(boards[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    public int[][] createBoard(){
    	// Most tricky part of the project
		int counter = 0, x = 0, y = 0; // Instantiating variable
		while(counter < 5){ // Until 5 ships are placed,
		    x = (int)(Math.random()*8); // x-coordinate randomly selected
		    y = (int)(Math.random()*8); // y-coordinate randomly selected
		    boolean dir = (int)(Math.random()*2) == 1; // direction randomly selected
		    	// Used boolean since it can only be horizontal or vertical
		    if(dir){ // If random dir is vertical,
				if(y + shipSize[counter] <= 8){ // Checks if it fits inside the box
				    boolean empty = true;
				    for(int i = y; i < y + shipSize[counter]; i++){ // Checks if all those spaces are empty
				    	if(boards[x][i] == 1)
				    		empty = false;
				    }
				    if(empty){ // If spaces are empty,
				    	for(int i=y; i < y + shipSize[counter]; i++){
				    		boards[x][i] = 1; // Places ships (1) inside the box
				    	}
				    	counter++; // Ship has been added!
				    }
				}
		    }
		    else{ // Goes through the same exact algorithm (with different orientation of coordinates) if the random dir is horizontal
				if(x + shipSize[counter] <= 8){
				    boolean empty = true;
				    for(int i = x; i < x + shipSize[counter]; i++){
						if(boards[i][y] == 1)
						    empty = false;
				    }
				    if(empty){
						for(int i=x; i < x + shipSize[counter]; i++){
						    boards[i][y] = 1;
						}
						counter++;
				    }
				}
		    }
		}
		return boards; // Returns completed board with 0 meaning no ships and 1 meaning ship spot
    }
} 
