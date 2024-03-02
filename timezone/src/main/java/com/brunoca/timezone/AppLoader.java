package com.brunoca.timezone;

import java.net.URL;

public interface AppLoader {
    default URL getMainLocation() {
        return getClass().getResource("/mainView.fxml");
    }

    default URL getTimeZoneComponentLocation() {
        return getClass().getResource("/timeZone.fxml");
    }
}
