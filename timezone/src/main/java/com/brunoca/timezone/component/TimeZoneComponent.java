package com.brunoca.timezone.component;

import com.brunoca.timezone.AppLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class TimeZoneComponent extends HBox implements AppLoader {
    @FXML
    public Label timeLabel;
    @FXML
    public Label regionLabel;
    @FXML
    public Label countryLabel;

    public TimeZoneComponent() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getTimeZoneComponentLocation());
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setRegionLabel(String zoneString) {
        final String[] regionCountry = zoneString.split("/");
        regionLabel.setText(regionCountry[0]);
        countryLabel.setText(regionCountry[1]);
    }

    public void setTimeLabel(String time) {
        timeLabel.setText(time);
    }
}
