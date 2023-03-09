module com.dxhh.englishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.dxhh.englishapp to javafx.fxml;
    exports com.dxhh.englishapp;
    exports com.dxhh.pojo;
    exports com.dxhh.services;
}
