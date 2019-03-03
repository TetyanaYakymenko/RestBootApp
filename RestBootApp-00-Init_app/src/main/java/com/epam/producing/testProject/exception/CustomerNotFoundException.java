package com.epam.producing.testProject.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id){
        super("Couldn't find Customer by id = " + id );
    }
}
