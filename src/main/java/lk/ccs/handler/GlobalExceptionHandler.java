package lk.ccs.handler;

import lk.ccs.error.ErrorDetails;
import lk.ccs.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleRecordNotFoundException(StudentNotFoundException ex) {
        return new ResponseEntity<ErrorDetails>(
                new ErrorDetails(LocalDateTime.now(), ex.getMessage(),"Record not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleOtherException(StudentNotFoundException ex) {
        return new ResponseEntity<ErrorDetails>(
                new ErrorDetails(LocalDateTime.now(), ex.getMessage(),"Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
