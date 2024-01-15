package com.app.vds3.classes.BaseClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    @Test
    void testConstructor() {
        Dealership dealership = new Dealership();
        assertInstanceOf(Person.class,dealership.getDirector());
    }
}