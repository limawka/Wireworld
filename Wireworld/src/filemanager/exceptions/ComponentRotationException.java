package filemanager.exceptions;

public class ComponentRotationException extends Exception{
    public ComponentRotationException(){}

    @Override
    public String toString(){
        return "Wrong rotation value (can be either 0, 90, 180 or 270";
    }

}
