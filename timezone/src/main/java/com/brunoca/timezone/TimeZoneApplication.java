package com.brunoca.timezone;

import com.gluonhq.ignite.spring.SpringContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan({
        "com.gluonhq.ignite.spring"
        , "com.brunoca.timezone.service"
})
public class TimeZoneApplication extends Application implements AppLoader {
    @Autowired
    private FXMLLoader loader;

    private final SpringContext context = new SpringContext(this);

    @Override
    public void start(Stage stage) throws IOException {
        context.init(() -> SpringApplication.run(TimeZoneApplication.class));
        loader.setLocation(getMainLocation());
        Parent mainView = loader.load();
        stage.setTitle("Timezone Converter");
        stage.setScene(new Scene(mainView));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TimeZoneApplication.class, args);
    }
}