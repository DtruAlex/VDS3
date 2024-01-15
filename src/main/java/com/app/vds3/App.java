package com.app.vds3;

import com.app.vds3.classes.AbstractClasses.SerializableObject;
import com.app.vds3.classes.BaseClasses.Dealership;
import com.app.vds3.classes.BaseClasses.Person;
import com.app.vds3.classes.BaseClasses.Vehicle;
import com.app.vds3.classes.ComposedClasses.PersonList;
import com.app.vds3.classes.ComposedClasses.VehicleList;
import com.app.vds3.classes.Devices.DBHandler;
import com.app.vds3.classes.Devices.FileHandler;
import com.app.vds3.classes.Devices.InputDevice;
import com.app.vds3.classes.Devices.OutputDevice;
import com.app.vds3.classes.Exceptions.WrongFormatException;

import java.sql.SQLException;

public class App {
    private VehicleList vehicleList;
    private PersonList personList;
    private InputDevice inputDevice;
    private OutputDevice outputDevice;
    private FileHandler fileHandler;
    private Dealership dealership;
    private DBHandler dbHandler;

    public App() {
        this.vehicleList = new VehicleList();
        this.personList = new PersonList();
        this.fileHandler = new FileHandler();
        this.outputDevice = new OutputDevice();
        this.inputDevice = new InputDevice();
        this.dealership = new Dealership();
        this.dbHandler = new DBHandler();
    }

    public void appInitalizer() throws SQLException {
        dealership.setVehicleList(dbHandler.getVehicles());
        dealership.setPersonList(dbHandler.getPeople());
    }

    public void addVehicleToList() throws WrongFormatException {
        Vehicle vehicle;
        vehicle = inputDevice.readVehicle();
        VehicleList temp = this.dealership.getVehicleList();
        temp.add(vehicle);
        this.dealership.setVehicleList(temp);
    }

    public void addPersonToList() throws WrongFormatException {
        Person person;
        person = inputDevice.readPerson();
        PersonList temp = this.dealership.getPersonList();
        temp.add(person);
        this.dealership.setPersonList(temp);
    }

    public void showAllPeople(){
        int count=1;
        for (SerializableObject x:this.dealership.getPersonList()) {
            System.out.printf("%d.%n", count);
            this.outputDevice.showPerson((Person) x);
            count++;
        }

    }

    public void showAllVehicles(){
        int count=1;
        for (SerializableObject x:this.dealership.getVehicleList()) {
            System.out.printf("%d.%n", count);
            this.outputDevice.showVehicle((Vehicle) x);
            count++;
        }
        ;
    }

    public void deleteAPerson() throws SQLException {
        showAllPeople();
        outputDevice.printMessage("Which id to delete: ");
        int index = Integer.parseInt(inputDevice.readALine());
        PersonList temp = this.dealership.getPersonList();
        temp.removeAtIndex(index-1);
        this.dealership.setPersonList(temp);

    }

    public void deleteAVehicle(){
        showAllVehicles();
        outputDevice.printMessage("Which id to delete: ");
        int index = Integer.parseInt(inputDevice.readALine());
        VehicleList temp = this.dealership.getVehicleList();
        temp.removeAtIndex(index-1);
        this.dealership.setVehicleList(temp);
    }



    public void appSaver() throws SQLException {
        for (Vehicle x : dealership.getVehicleList().getList()) {
            this.dbHandler.insertVehicle(x);


            for (Person y : dealership.getPersonList().getList()) {
                this.dbHandler.insertPerson(y);


            }
        }
    }
// UNUSED CODE
//    public void read1VehiclesAndSaveToFile() {
//        Vehicle vehicle;
//        vehicle = inputDevice.readVehicle();
//        this.vehicleList.add(vehicle);
//        this.fileHandler.writeToFile("vehicles.csv", vehicleList);
//    }
//
//    public void read3PersonAndSaveToFile() {
//        Person person;
//        person = inputDevice.readPerson();
//        this.personList.add(person);
//        person = inputDevice.readPerson();
//        this.personList.add(person);
//        person = inputDevice.readPerson();
//        this.personList.add(person);
//        this.fileHandler.writeToFile("people.csv", personList);
//    }
//
//    public void readFromFile(){
//        System.out.println("Atlsetat is here");
//        ArrayList< SerializableObject> listFromFile = this.fileHandler.readFromFile("D:\\College\\Year 2\\P3\\HW-Project-Maven\\people.csv");
//        for(SerializableObject person:listFromFile){
//            Person personToInsertInList = (Person) person;
//            this.personList.add(personToInsertInList);
//        }
//        for(SerializableObject x:this.personList){
//            this.outputDevice.showPerson(((Person) x));
//
//
}
