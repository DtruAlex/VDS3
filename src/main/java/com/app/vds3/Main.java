package com.app.vds3;

import com.app.vds3.classes.Devices.InputDevice;
import com.app.vds3.classes.Devices.OutputDevice;
import com.app.vds3.classes.Exceptions.NotEnoughArgumentsException;
import com.app.vds3.classes.Exceptions.WrongFormatException;

import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws NotEnoughArgumentsException, WrongFormatException, SQLException {


        OutputDevice od = new OutputDevice();
        InputDevice id = new InputDevice();
        App application = new App();
        application.appInitalizer();

        int choice = id.UI();
        while (choice<8) {
            switch (choice) {
                case 1: {
                    application.addVehicleToList();
                    application.appSaver();
                    break;
                }
                case 2: {
                    application.addPersonToList();
                    application.appSaver();
                    break;
                }
                case 3: {
                    application.showAllVehicles();
                    application.appSaver();
                    break;
                }
                case 4: {
                    application.showAllPeople();
                    application.appSaver();
                    break;
                }
                case 5: {
                    application.deleteAVehicle();
                    application.appSaver();
                    break;
                }
                case 6: {
                    application.deleteAPerson();
                    application.appSaver();
                    break;
                }
                case 7: {
                    return;
                }
                default:
                    od.printMessage("Wrong Choice");
                    break;
            }
            choice = id.UI();
        }
    }
}