package tn.iit.exception;

public class PrescriptionNotFoundException extends RuntimeException {
    private String message;

    public PrescriptionNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}