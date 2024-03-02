package com.brunoca.timezone.controller;

import com.brunoca.timezone.service.TimezoneService;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
    private Instant myInstant;
    private LocalDateTime myLocalDateTime;
    private String myZone;
    @FXML
    public Label timeLabel;
    @FXML
    public Label regionLabel;
    @FXML
    public Label countryLabel;
    @FXML
    public Slider mySlider;
    @FXML
    public Button currentTimeButton;
    @Autowired
    private TimezoneService timezoneService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myZone = timezoneService.getMyZones().getFirst().getZone();
        final String[] regionCountry = myZone.split("/");
        regionLabel.setText(regionCountry[0]);
        countryLabel.setText(regionCountry[1]);

        myInstant = Instant.now();
        adjustTimeLabel(myInstant);

        mySlider.valueProperty().addListener((ObservableValue<? extends Number> num, Number oldValue, Number newValue) -> {
            long delta = newValue.longValue() - oldValue.longValue();
            myInstant = myInstant.plus(delta, ChronoUnit.MINUTES);
            adjustTimeLabel(myInstant);
        });
    }

    private void adjustTimeLabel(Instant instant) {
        myLocalDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(myZone));
        timeLabel.setText(myLocalDateTime.format(formatter));
    }

    public void onCurrentTime(ActionEvent actionEvent) {
        double midValue = (mySlider.getMax() - mySlider.getMin()) / 2.0;
        mySlider.setValue(midValue);
        myInstant = Instant.now();
        adjustTimeLabel(myInstant);
    }
}