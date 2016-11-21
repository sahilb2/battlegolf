public class Ship{

    private String name;
    private int holes;

    public Ship(String name, int holes){
    	this.name = name;
    	this.holes = holes;
    }

    public void setHoles(int holes){
    	this.holes = holes;
    }
    public int getHoles(){
    	return this.holes;
    }
    public String getName(){
    	return this.name;
    }
}
