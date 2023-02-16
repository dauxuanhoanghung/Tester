module com.dxhh.bmiapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dxhh.bmiapp to javafx.fxml;
    exports com.dxhh.bmiapp;
}
