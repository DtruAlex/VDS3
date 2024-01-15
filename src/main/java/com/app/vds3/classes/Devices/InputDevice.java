package com.app.vds3.classes.Devices;

import com.app.vds3.classes.BaseClasses.Person;
import com.app.vds3.classes.BaseClasses.Vehicle;
import com.app.vds3.classes.Exceptions.WrongFormatException;
import com.app.vds3.classes.Validators.InputValidator;

import java.util.Scanner;

public class InputDevice {

    public InputValidator validator = new InputValidator();

    public String readALine(){
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }


    public Vehicle readVehicle() throws WrongFormatException {
        System.out.println("------------------------NEW VEHICLE------------------------------");
        Scanner myObj = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();
        System.out.println("Enter VIN (Format ABC-123) ");
        vehicle.setVIN(validator.validateFormat(myObj.nextLine()));

        System.out.println("Enter Make");
        vehicle.setMake(myObj.nextLine());

        System.out.println("Enter Model");
        vehicle.setModel(myObj.nextLine());

        System.out.println("Enter Year (1800- )");
        vehicle.setYear(validator.validateYear(Integer.parseInt(myObj.nextLine())));

        System.out.println("Enter Mileage (0.0- ");
        vehicle.setMileage(validator.validateDoubles(Double.parseDouble(myObj.nextLine())));

        System.out.println("Enter Price (0.0-");
        vehicle.setPrice(validator.validateDoubles(Double.parseDouble(myObj.nextLine())));
        System.out.println('\n');
        return vehicle;
    }

    public Person readPerson() throws WrongFormatException {
        System.out.println("------------------------NEW PERSON------------------------------");
        Scanner myObj = new Scanner(System.in);
        Person person = new Person();
        System.out.println("Enter Full Name");
        person.setFullName(myObj.nextLine());

        System.out.println("Enter Age");
        person.setAge(validator.validateAge(Integer.parseInt(myObj.nextLine())));

        System.out.println("Enter Salary");
        person.setSalary(validator.validateDoubles(Double.parseDouble(myObj.nextLine())));

        System.out.println("Enter SSN");
        person.setSSN(myObj.nextLine());

        System.out.println('\n');
        return person;
    }

    public int UI(){
        Scanner sc =  new Scanner(System.in);
        System.out.println(" CHOOSE WHAT TO DO");
        System.out.println("1. Add a vehicles to stock");
        System.out.println("2. Hire a person");
        System.out.println("3. Show all the vehicles in the dealership");
        System.out.println("4. Show all employees of the dealership");
        System.out.println("5. Sell a vehicle");
        System.out.println("6. Fire an employee");
        System.out.println("7. Exit the app");
        return sc.nextInt();
    }
}
