package com.app.vds3.classes.Validators;

import com.app.vds3.classes.Exceptions.WrongFormatException;

import java.util.regex.Pattern;

public class InputValidator {

    public String validateFormat(String VIN) throws WrongFormatException{
        if(!Pattern.matches("[A-Z]{3}-[0-9]{3}", VIN)){
            throw new WrongFormatException("VIN is in wrong format");
        }
        return VIN;
    }

    public int validateYear(int year) throws WrongFormatException {
        if (year < 1800)
            throw new WrongFormatException("No vehicle was produced that early");
        return year;
    }

    public double validateDoubles(double value) throws WrongFormatException {
        if (value < 0)
            throw new WrongFormatException("The value should not be negative");
        return value;
    }

    public int validateAge(int age) throws WrongFormatException {
        if (age < 0)
            throw new WrongFormatException("Age cannot be negative");

        else if (age > 150)
            throw new WrongFormatException("No one ever lived that long, contatct the owner if it actually happend");
        return age;

    }
}

