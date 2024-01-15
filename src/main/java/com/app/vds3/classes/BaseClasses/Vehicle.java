package com.app.vds3.classes.BaseClasses;

import com.app.vds3.classes.AbstractClasses.SerializableObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle extends SerializableObject implements Comparable<Vehicle> {
    @Column(name = "VIN")
    String VIN;
    @Column(name = "make")
    String make;
    @Column(name = "model")
    String model;
    @Column(name = "year")
    Integer year;
    @Column(name = "mileage")
    Double mileage;
    @Column(name = "price")
    Double price;
    @Id
    @Column(name = "id")
    private Long id;


    public Vehicle(String VIN, String make, String model, Integer year, Double mileage, Double price) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public Vehicle() {

    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Vehicle o) {
        //TODO: implement compareTo
        return 0;
    }

    @Override
    public String[] serialize() {
        String[] serializedObject = new String[6];
        serializedObject[0] = this.VIN;
        serializedObject[1] = this.make;
        serializedObject[2] = this.model;
        serializedObject[3] = String.valueOf(this.year);
        serializedObject[4] = String.valueOf(this.mileage);
        serializedObject[5] = String.valueOf(this.price);
        return serializedObject;
    }

    @Override
    public void unSerialize(String[] serializedObject) {
        this.VIN=serializedObject[0];
        this.make = serializedObject[1];
        this.model = serializedObject[2];
        this.year = Integer.valueOf(serializedObject[3]);
        this.mileage = Double.valueOf(serializedObject[4]);
        this.price = Double.valueOf(serializedObject[5]);
    }

    public static SerializableObject staticUnserialize(String[] serializedObject) {
        Vehicle vehicle = new Vehicle();
        vehicle.VIN=serializedObject[0];
        vehicle.make = serializedObject[1];
        vehicle.model = serializedObject[2];
        vehicle.year = Integer.valueOf(serializedObject[3]);
        vehicle.mileage = Double.valueOf(serializedObject[4]);
        vehicle.price = Double.valueOf(serializedObject[5]);

        return vehicle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
