public class Game{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	int option;
	int x,y = -1;
	Board board = new Board();
	do{
	    System.out.println("1. Play\n2. Quit\n3. Print board");
	    play = scan.nextInt();
	    System.out.println("Enter x between 0 to 7: ");
	    x = scan.nextInt();
	    System.out.println("Enter y between 0 to 7: ");
	    y = scan.nextInt();
	    if(board.hit(x,y)){
		System.out.println("Success. You hit " + board.boards[x][y].getName() + " and left " + board.boards[x][y].getHoles() + " holes");
	    }
	    else{
		System.out.println("Failed to hit");
	    }
	}while(!(play==2));
    }
}
