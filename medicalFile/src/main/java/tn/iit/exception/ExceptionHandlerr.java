package tn.iit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerr {
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorForm> mapException(PatientNotFoundException ex) {
        ErrorForm error = new ErrorForm(ex.getMessage());
        return new ResponseEntity<ErrorForm>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MedicationNotFoundException.class)
    public ResponseEntity<ErrorForm> medexeption(MedicationNotFoundException ex) {
        ErrorForm error = new ErrorForm(ex.getMessage());
        return new ResponseEntity<ErrorForm>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
