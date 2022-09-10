//create new exception type "IntException"

public class IntException extends Exception {
    private String message = null;

    public IntException(){
        this.message = ("Input is out of bounds!");
    }

    public IntException(String arg){
        this.message = arg;
        
    }

    public String getException(){
        return this.message;

    }
}


    
