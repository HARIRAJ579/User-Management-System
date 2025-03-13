package com.Zylentrix.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> findingUserFailedException(FindingUserFailedException fx){
        ErrorStructure<String> es=new ErrorStructure<>();
        es.setErrorStatusCode(HttpStatus.NOT_FOUND.value());
        es.setErrorMessage(fx.getMessage());
        es.setErrorData("Finding user failed..");
        return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> userNotFoundByIdException(UserNotFoundByIdException un){
        ErrorStructure<String> es=new ErrorStructure<>();
        es.setErrorStatusCode(HttpStatus.NO_CONTENT.value());
        es.setErrorMessage(un.getMessage());
        es.setErrorData("Non-existent User");
        return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> userUpdateFailureException(UserUpdateFailureException ue){
        ErrorStructure<String> es=new ErrorStructure<>();
        es.setErrorStatusCode(HttpStatus.NOT_MODIFIED.value());
        es.setErrorMessage(ue.getMessage());
        es.setErrorData("Update Failed");
        return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_MODIFIED);
    }

}
