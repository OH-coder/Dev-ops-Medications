package tn.iit.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MedicationNotFoundException extends RuntimeException {
    String message;

}
