package com.app.vds3;

import com.app.vds3.classes.BaseClasses.Dealership;
import com.app.vds3.classes.BaseClasses.Person;
import com.app.vds3.classes.BaseClasses.Vehicle;
import com.app.vds3.classes.ComposedClasses.PersonList;
import com.app.vds3.classes.ComposedClasses.VehicleList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    Dealership dealership = new Dealership();

    @Test
    void addVehicleToList() {
        Vehicle vehicle = new Vehicle("ABB-125", "WV", "GOLF", 2003, 0.0, 23000.0);
        VehicleList vehicleList = new VehicleList();
        vehicleList.add(vehicle);
        assertEquals(vehicleList.getList().get(0),vehicle);
    }

    @Test
    void addPersonToList() {
        Person person = new Person("Ramesh Haddi", 23, 523.421, "M123123");
        PersonList personList = new PersonList();
        personList.add(person);
        assertEquals(personList.getList().get(0),person);
    }

    @Test
    void deleteAPerson() {
        Person person = new Person("Ramesh Haddi", 23, 523.421, "M123123");
        PersonList personList = new PersonList();
        personList.add(person);
        personList.removeAtIndex(0);
        assertEquals(personList.getList().size(),0);
    }

    @Test
    void deleteAVehicle() {
        Vehicle vehicle = new Vehicle("ABB-125", "WV", "GOLF", 2003, 0.0, 23000.0);
        VehicleList vehicleList = new VehicleList();
        vehicleList.add(vehicle);
        vehicleList.removeAtIndex(0);
        assertEquals(vehicleList.getList().size(),0);
    }
}