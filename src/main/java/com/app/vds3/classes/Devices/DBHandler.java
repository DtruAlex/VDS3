package com.app.vds3.classes.Devices;

import com.app.vds3.classes.BaseClasses.Person;
import com.app.vds3.classes.BaseClasses.Vehicle;
import com.app.vds3.classes.ComposedClasses.PersonList;
import com.app.vds3.classes.ComposedClasses.VehicleList;

import java.sql.*;

public class DBHandler {

    private Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager deviceManager;
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hwdb","root","root");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean insertPerson(Person person) throws SQLException {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO `hwdb`.`person`" +
                    " (`fullname`,`age`,`salary`,`SSN`) VALUES (? ,?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, person.getFullName());
            preparedStatement.setInt   (2, person.getAge());
            preparedStatement.setDouble(3, person.getSalary());
            preparedStatement.setString(4, person.getSSN());
            return preparedStatement.execute();
        }catch (Exception exception) {
        return false;
        }
    }

    public boolean deletePersonBySSN(String ssn) throws SQLException {
        Connection connection = getConnection();
        String query = "DELETE FROM `hwdb`.`person`" +
                "WHERE SSN = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,ssn);
        return preparedStatement.execute();
    }

    public Person getPersonBySSN(String ssn) throws SQLException{
        Connection connection = getConnection();
        String query = "SELECT * FROM `hwdb`.`person` WHERE SSN=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,ssn);
        ResultSet rs = preparedStatement.executeQuery();
        Person person = new Person();
        if(rs.next()) {
            person.setFullName(rs.getString("fullName"));
            person.setAge(rs.getInt("age"));
            person.setSalary(rs.getDouble("salary"));
            person.setSSN(rs.getString("SSN"));
            person.setId(rs.getLong("id"));
            connection.close();
        }
        return person;
    }

    public PersonList getPeople() throws SQLException{
        Connection connection = getConnection();
        String query = "SELECT * FROM `hwdb`.`person`";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        PersonList personList = new PersonList();
        if(rs.next()) {
            Person person = new Person();
            person.setFullName(rs.getString("fullName"));
            person.setAge(rs.getInt("age"));
            person.setSalary(rs.getDouble("salary"));
            person.setSSN(rs.getString("SSN"));
            person.setId(rs.getLong("id"));
            personList.add(person);
            connection.close();
        }
        return personList;
    }

    public boolean insertVehicle(Vehicle vehicle) throws SQLException {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO `hwdb`.`vehicles` (`VIN`,`Make`,`Model`,`Year`,`Mileage`,`Price`) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vehicle.getVIN());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setInt(4, vehicle.getYear());
            preparedStatement.setDouble(5, vehicle.getMileage());
            preparedStatement.setDouble(6, vehicle.getPrice());
            return preparedStatement.execute();
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean deleteVehicleByVIN(String vin) throws SQLException {
        Connection connection = getConnection();
        String query = "DELETE FROM `hwdb`.`vehicles`" +
                "WHERE VIN = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,vin);
        return preparedStatement.execute();
    }

    public Vehicle getVehicleByVIN(String VIN) throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT * FROM `hwdb`.`vehicles` WHERE VIN = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, VIN);
        ResultSet rs = preparedStatement.executeQuery();
        Vehicle vehicle = new Vehicle();
        if (rs.next()) {
            vehicle.setVIN(rs.getString("VIN"));
            vehicle.setMake(rs.getString("Make"));
            vehicle.setModel(rs.getString("Model"));
            vehicle.setYear(rs.getInt("Year"));
            vehicle.setMileage(rs.getDouble("Mileage"));
            vehicle.setPrice(rs.getDouble("Price"));
        }
        connection.close();
        return vehicle;
    }

    public VehicleList getVehicles() throws SQLException{
        Connection connection = getConnection();
        String query = "SELECT * FROM `hwdb`.`vehicles`";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        VehicleList vehicles = new VehicleList();
        while (rs.next()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVIN(rs.getString("VIN"));
            vehicle.setMake(rs.getString("Make"));
            vehicle.setModel(rs.getString("Model"));
            vehicle.setYear(rs.getInt("Year"));
            vehicle.setMileage(rs.getDouble("Mileage"));
            vehicle.setPrice(rs.getDouble("Price"));
            vehicles.add(vehicle);
        }
        connection.close();
        return vehicles;
    }
}




