public class Board{
    protected int holes;
    protected Ship[] ships = new Ship[]{};
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
    public void printBoard(){

    }
    public void createBoard(){
	int counter = 0;
	whiel(counter < ships.length){
	    int x = (int)Math.random()*8;
	    int y = (int)Math.random()*8;
	    //if true: dir is vertical; else dir is horizontal;
	    boolean dir = (int)Math.random()*2 == 1;
	    if(dir){
		if(y+ships[counter] < 8){
		    boolean empty = true;
		    for(int i=0; i < y+ships[counter]; i++){
			if(boards[i][x] != null)
			    empty = false;
		    }
		    if(empty){
			for(int i=0; i < y+ships[counter]; i++)
			    boards[i][x] = ships[counter];
			counter++;
		    }
		}
	    }
	    else{
		if(x+ships[counter] < 8){
		    boolean empty = true;
		    for(int i=0; i < x+ships[counter]; i++){
			if(boards[y][x] != null)
			    empty = false;
		    }
		    if(empty){
			for(int i=0; i < x+ships[counter]; i++)
			    boards[y][i] = ships[counter];
			counter++;
		    }
		}
	    }
	}
    }
} 
