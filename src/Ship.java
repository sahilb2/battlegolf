
public class Ship {
	
	private String name;
	private int row,col,holes;

	public Ship(String name, int row, int col){
		this.name = name;
		this.row = row;
		this.col = col;
	}
	public boolean check(int x, int y){
		return x == row && y == col ? true : false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getrow() {
		return row;
	}
	public void setrow(int row) {
		this.row = row;
	}
	public int getcol() {
		return col;
	}
	public void setcol(int col) {
		this.col = col;
	}
	public int getHoles() {
		return holes;
	}
	public void setHoles(int holes) {
		this.holes = holes;
	}
	
}
