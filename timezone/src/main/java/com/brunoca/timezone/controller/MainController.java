package com.brunoca.timezone.controller;

import com.brunoca.timezone.service.TimezoneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class MainController {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
    @Autowired
    private TimezoneService timezoneService;

    @FXML
    private Label welcomeText;

    public void onCurrentTimeHandler(ActionEvent actionEvent) {
        final Instant instant = Instant.now();
        final String zone = timezoneService.getMyZones().getFirst().getZone();
        LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.of(zone));
        welcomeText.setText(time.format(formatter));
    }
}