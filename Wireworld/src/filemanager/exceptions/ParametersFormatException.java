package filemanager.exceptions;

public class ParametersFormatException extends Exception{
    public ParametersFormatException(){}

    @Override
    public String toString(){
        return "Wrong parameters format";
    }
}
