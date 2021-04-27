package board;

public class Cell {
    private State state;
    Cell(State state){
        this.state = state;
    }
    State getState(){
        return this.state;
    }
    void setState(State state){
        this.state = state;
    }

}
