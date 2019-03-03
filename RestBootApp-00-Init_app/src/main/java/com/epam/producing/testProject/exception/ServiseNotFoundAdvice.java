package com.epam.producing.testProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ServiseNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler({CustomerNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String customerNotFoundHandler(CustomerNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({AddressNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String addressNotFoundHandler(AddressNotFoundException ex ){
        return ex.getMessage();
    }
}
