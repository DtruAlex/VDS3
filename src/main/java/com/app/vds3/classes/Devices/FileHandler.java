package com.app.vds3.classes.Devices;

import com.app.vds3.classes.AbstractClasses.SerializableObject;
import com.app.vds3.classes.BaseClasses.Person;
import com.app.vds3.classes.BaseClasses.Vehicle;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

//    public boolean overwriteToFile(String filename, ObjectList text) {
//        try {
//            FileWriter myWriter = new FileWriter(filename);
//            CSVWriter csvWriter = new CSVWriter(myWriter);
//            for (SerializableObject serializableObject : text) {
//                System.out.println(Arrays.toString(serializableObject.serialize()));
//                csvWriter.writeNext(serializableObject.serialize());
//            }
//            csvWriter.close();
//            return true;
//        } catch (IOException e) {
//            System.out.printf("Writing to file %s failed! \n", filename);
//            return false;
//        }
//    }
//
//    public boolean writeToFile(String filename, ArrayList<SerializableObject> text) {
//        try {
//            FileWriter myWriter = new FileWriter(filename, true);
//            CSVWriter csvWriter = new CSVWriter(myWriter);
//            for (SerializableObject serializableObject : text) {
//                csvWriter.writeNext(serializableObject.serialize());
//            }
//            csvWriter.close();
//            return true;
//        } catch (IOException e) {
//            System.out.printf("Writing to file %s failed! \n", filename);
//            return false;
//        }
//    }

    public ArrayList<SerializableObject> readFromFile(String filename) {
        ArrayList<SerializableObject> list = new ArrayList<>();

        try {
            FileReader reader = new FileReader(filename);
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                try {
                    Integer.parseInt(row[1]);
                    list.add(Person.staticUnserialize(row));
                } catch (NumberFormatException nfe) {
                    list.add(Vehicle.staticUnserialize(row));
                }
            }
            csvReader.close();
            return list;
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToFilePersons(String filename, ArrayList<Person> list) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            for (Person obj : list) {
                writer.writeNext(obj.serialize());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFileVehicles(String filename, ArrayList<Vehicle> list) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            for (Vehicle obj : list) {
                writer.writeNext(obj.serialize());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

