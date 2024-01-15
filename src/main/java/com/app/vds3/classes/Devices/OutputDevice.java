package com.app.vds3.classes.Devices;

import com.app.vds3.classes.BaseClasses.Person;
import com.app.vds3.classes.BaseClasses.Vehicle;

public class OutputDevice {


    public void printMessage(String x){
        System.out.print(x);
    }


    public void showVehicle(Vehicle vehicle){
        System.out.println("____VEHICLE______________________");
        System.out.printf("| Vin:    %s  \n",vehicle.getVIN());
        System.out.printf("| Model:  %s  \n",vehicle.getModel());
        System.out.printf("| Make:   %s  \n",vehicle.getMake());
        System.out.printf("| Year:   %s  \n",vehicle.getYear());
        System.out.printf("| Milage: %f  \n",vehicle.getMileage());
        System.out.printf("| Price:  %s  \n",vehicle.getPrice());
        System.out.println("_________________________________\n");
    }
    public void showPerson(Person person){
        System.out.println("____Person_______________________");
        System.out.printf("| Full Name:  %s\n",person.getFullName());
        System.out.printf("| Age:        %s\n",person.getAge());
        System.out.printf("| Salary:     %s\n",person.getSalary());
        System.out.printf("| SSN:        %s\n",person.getSSN());
        System.out.println("_________________________________\n");
    }
}
