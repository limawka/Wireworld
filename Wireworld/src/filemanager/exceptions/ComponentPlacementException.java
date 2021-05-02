package filemanager.exceptions;

public class ComponentPlacementException extends Exception{
    private int x;
    private int y;
    private String name;

    public ComponentPlacementException(){}
    public ComponentPlacementException(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String toString(){
        return "The component exceeds board's boundaries: " + this.name + ", placet at: " + this.x + ", " + this.y;
    }
}
