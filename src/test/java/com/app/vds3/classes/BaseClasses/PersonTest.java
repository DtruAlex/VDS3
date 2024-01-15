package com.app.vds3.classes.BaseClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testEmptyConstructor() {
        Person person = new Person();
        assertInstanceOf(Person.class,person);
    }

    @Test
    void testFullConstructor() {
        Person person = new Person("Ramesh Haddi",23,523.421,"M123123");
        assertEquals("Ramesh Haddi",person.getFullName());
    }
}