package filemanager.exceptions;

public class FileFormatException extends Exception{
    Integer lineNumber;
    String lineContent;
    String exceptionString;

    public FileFormatException(int lineNumber, String lineContent, String exceptionString){
        this.lineContent = lineContent;
        this.lineNumber = lineNumber;
        this.exceptionString = exceptionString;

    }
    //todo more
    @Override
    public String toString(){
        return "Found an error at line "+ lineNumber.toString()+": \""+ lineContent + "\"\n" + exceptionString;
    }
}
