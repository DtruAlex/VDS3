package com.app.vds3.classes.ComposedClasses;

import com.app.vds3.classes.AbstractClasses.ObjectList;
import com.app.vds3.classes.AbstractClasses.SerializableObject;
import com.app.vds3.classes.BaseClasses.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PersonList extends ObjectList {
    private ArrayList<Person> list;
    public PersonList() {
        this.list = new ArrayList<Person>();
    }



    public boolean add(Person person){
        try {
            this.list.add(person);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    public Person getAtIndex(int index){
        return this.list.get(index);
    }


    private int count=0;

    public ArrayList<Person> getList() {
        return list;
    }

    public void setList(ArrayList<Person> list) {
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
