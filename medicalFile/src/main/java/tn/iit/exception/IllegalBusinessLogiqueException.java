package tn.iit.exception;


public class IllegalBusinessLogiqueException extends RuntimeException {
    private String message;
    
    public IllegalBusinessLogiqueException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}