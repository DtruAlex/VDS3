package com.app.vds3.classes.Exceptions;

public class NotEnoughArgumentsException extends Exception{
    public NotEnoughArgumentsException(String errorMessage){
        super(errorMessage);
    }
}
