package com.app.vds3.classes.BaseClasses;

import com.app.vds3.classes.AbstractClasses.SerializableObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends SerializableObject {
    @Column(name = "fullName")
    String fullName;
    @Column(name = "age")
    Integer age;
    @Column(name = "salary")
    Double salary;
    @Column(name = "SSN")
    String SSN;
    @Id
    @Column(name = "id")
    private Long id;

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Person(String fullName, Integer age, Double salary, String SSN) {
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
        this.SSN = SSN;
    }

    public Person() {
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String[] serialize() {
        String[] serializedObject = new String[3];
        serializedObject[0] = this.fullName;
        serializedObject[1] = String.valueOf(this.age);
        serializedObject[2] = String.valueOf(this.salary);
        return serializedObject;
    }

    @Override
    public void unSerialize(String[] serializedObject) {
        this.fullName= serializedObject[0];
        this.age= Integer.valueOf(serializedObject[1]);
        this.salary = Double.valueOf(serializedObject[2]);
    }

    public static Person staticUnserialize(String[] serializedObject) {
        Person person = new Person();
        person.fullName= serializedObject[0];
        person.age= Integer.valueOf(serializedObject[1]);
        person.salary = Double.valueOf(serializedObject[2]);
        return person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
