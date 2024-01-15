package com.app.vds3.classes.BaseClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testEmptyConstructor() {
        Vehicle vehicle = new Vehicle();
        assertInstanceOf(Vehicle.class,vehicle);
    }

    @Test
    void testFullConstructor() {
        Vehicle vehicle = new Vehicle("ABB-125","WV","GOLF",2003,(double)0,(double)23000);
        assertEquals("ABB-125",vehicle.getVIN());
    }
}