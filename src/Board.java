public class Board{
    
	protected int numholes = 17;
	protected int[] shipSize = new int[]{5,4,3,3,2};
    protected int[][] boards = new int[8][8];
    
    public Board(){
    	createBoard();
    }
    
    public boolean hit(int x, int y){
		if(boards[x][y] == 1){
		    boards[x][y] = 0;
		    numholes--;
		    return true;
		}
		return false;
	}
    
    public void printBoard(){
    	for (int i = 0; i < boards.length; i++){
    		for (int j = 0; j < boards[i].length; j++){
    			System.out.print(boards[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    public int[][] createBoard(){
		int counter = 0, x = 0, y = 0;
		while(counter < 5){
		    x = (int)(Math.random()*8);
		    y = (int)(Math.random()*8);
		    boolean dir = (int)(Math.random()*2) == 0;
		    if(dir){
				if(y + shipSize[counter] <= 8){
				    boolean empty = true;
				    for(int i = y; i < y + shipSize[counter]; i++){
				    	if(boards[x][i] == 1)
				    		empty = false;
				    }
				    if(empty){
				    	for(int i=y; i < y + shipSize[counter]; i++){
				    		boards[x][i] = 1;
				    	}
				    	counter++;
				    }
				}
		    }
		    else{
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
		return boards;
    }
} 
