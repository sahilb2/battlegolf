public class Board{

	protected int holes = 17;
    protected Ship[] ships = new Ship[]
    	{
    		new Ship("Carrier", 5),
    		new Ship("Battleship", 4),
    		new Ship("Cruiser", 3),
    		new Ship("Submarine", 3),
    		new Ship("Destroyer", 2),
    	};
    protected Ship[][] boards = new Ship[8][8];

    public Board(){
    	createBoard();
    }

    public boolean hit(int x, int y){
		if(boards[x][y]!=null){
		    boards[x][y].setHoles(boards[x][y].getHoles()-1);
		    boards[x][y]=null;
		    return true;
		}
		return false;
	}

    public boolean shipDestroyed(int shipNum){
    	if (ships[shipNum].getHoles() == 0){
    		return true;
    	}
    	return false;
    }

    public void printBoard(){
    	for (int i = 0; i < boards.length; i++){
    		for (int j = 0; j < boards[i].length; j++){
    			if (boards[i][j] == null){
    				System.out.print("0 ");
    			}
    			else{
    				System.out.print("1 ");
    			}
    		}
    		System.out.println();
    	}
    }
    public Ship[][] createBoard(){
		int counter = 0, x = 0, y = 0;
		while(counter < 5){
		    x = (int)(Math.random()*8);
		    y = (int)(Math.random()*8);
		    boolean dir = (int)(Math.random()*2) == 0;
		    if(dir){
				if(y + ships[counter].getHoles() <= 8){
				    boolean empty = true;
				    for(int i = y; i < y + ships[counter].getHoles(); i++){
				    	if(boards[x][i] != null)
				    		empty = false;
				    }
				    if(empty){
				    	for(int i=y; i < y + ships[counter].getHoles(); i++){
				    		boards[x][i] = ships[counter];
				    	}
				    	counter++;
				    }
				}
		    }
		    else{
				if(x + ships[counter].getHoles() <= 8){
				    boolean empty = true;
				    for(int i = x; i < x + ships[counter].getHoles(); i++){
						if(boards[i][y] != null)
						    empty = false;
				    }
				    if(empty){
						for(int i=x; i < x + ships[counter].getHoles(); i++){
						    boards[i][y] = ships[counter];
						}
						counter++;
				    }
				}
		    }
		}
		return boards;
    }
}
