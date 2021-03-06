module com.boarding {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.fasterxml.jackson.databind;
    requires jackson.datatype.jsr310;
    requires org.apache.pdfbox;
    requires kernel;
    requires layout;
    requires com.google.zxing;
    requires java.desktop;

    opens com.boarding to javafx.fxml,com.fasterxml.jackson.databind;
    exports com.boarding;
    exports com.boarding.controllers;
    opens com.boarding.controllers to com.fasterxml.jackson.databind, javafx.fxml;
}
