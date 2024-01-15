module com.app.vds3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jakarta.persistence;
    requires com.opencsv;

    opens com.app.vds3 to javafx.fxml;
    exports com.app.vds3;
}