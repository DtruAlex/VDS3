
package com.app.vds3.classes.BaseClasses;

import com.app.vds3.classes.ComposedClasses.PersonList;
import com.app.vds3.classes.ComposedClasses.VehicleList;


public class Dealership {
    private VehicleList vehicleList;
    private PersonList personList;
    private Person director;

    public Dealership() {
        this.vehicleList = new VehicleList();
        this.personList = new PersonList();
        this.director = new Person();
    }

    public VehicleList getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(VehicleList vehicleList) {
        this.vehicleList = vehicleList;
    }

    public PersonList getPersonList() {
        return personList;
    }

    public void setPersonList(PersonList personList) {
        this.personList = personList;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }
}
