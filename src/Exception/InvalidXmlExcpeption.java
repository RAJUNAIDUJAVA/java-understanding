package Exception;

public class InvalidXmlExcpeption extends RuntimeException{

    public InvalidXmlExcpeption(String message){
        super(message);
    }

    public InvalidXmlExcpeption (String message, Throwable cause){
        super(message, cause);
    }
}
