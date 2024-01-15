package com.app.vds3.classes.ComposedClasses;

import com.app.vds3.classes.AbstractClasses.ObjectList;
import com.app.vds3.classes.AbstractClasses.SerializableObject;
import com.app.vds3.classes.BaseClasses.Vehicle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class VehicleList extends ObjectList {
    private ArrayList<Vehicle> list;
    public VehicleList() {
        this.list = new ArrayList<Vehicle>();
    }



    public boolean add(Vehicle vehicle){
        try {
            this.list.add(vehicle);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
    private int count=0;

    public ArrayList<Vehicle> getList() {
        return list;
    }

    public void setList(ArrayList<Vehicle> list) {
        this.list = list;
    }

    @Override
    public Iterator<SerializableObject> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if (count < list.size()){
            return true;
        }
        return false;
    }

    @Override
    public SerializableObject next() {
        if (count == list.size())
            throw new NoSuchElementException();
        count++;
        return list.get(count - 1);
    }

    public void removeAtIndex(int index) {
        list.remove(index);
    }
}
