package filemanager.exceptions;

public class NumberOfParamsException extends Exception{
    public NumberOfParamsException(){}
    @Override
    public String toString(){
        return "Wrong number of parameters.";
    }
}
