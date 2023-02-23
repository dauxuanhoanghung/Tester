package com.dxhh.bmiapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class PrimaryController {
    @FXML private TextField txtWeight;
    @FXML private TextField txtHeight;
    @FXML private Label lblResult; 

    @FXML private void BMIHandler(ActionEvent aEv) {
        try {
            double w = Double.parseDouble(this.txtWeight.getText());
            double h = Double.parseDouble(this.txtHeight.getText());
            double bmi = w / Math.pow(h, 2);
            if(bmi < 18.5) {
                this.lblResult.setText("Under weight");
                this.lblResult.setTextFill(Color.RED);
            } else if (bmi <= 25) {
                this.lblResult.setText("Normal");
                this.lblResult.setTextFill(Color.GOLD);
            } else if (bmi <= 30) {
                this.lblResult.setText("Over weight");
                this.lblResult.setTextFill(Color.ORANGE);
            } else {
                this.lblResult.setText("OBESE");
                this.lblResult.setTextFill(Color.ORANGERED);
            }
            this.lblResult.setVisible(true);
        }
        catch (Exception e) {
            
        }
    }
}
