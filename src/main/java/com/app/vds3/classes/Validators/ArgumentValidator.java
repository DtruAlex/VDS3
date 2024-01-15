package com.app.vds3.classes.Validators;

import com.app.vds3.classes.Exceptions.NotEnoughArgumentsException;

public class ArgumentValidator {
    public void validateNumberOfArguments(String[] arguments) throws NotEnoughArgumentsException {
        if (arguments.length == 0) {
            throw new NotEnoughArgumentsException("No Argument Added");
        }
    }
}
