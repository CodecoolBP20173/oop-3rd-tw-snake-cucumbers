package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class GameOver extends Application {

    public static void GameOver() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("GAME OVER!");
        alert.setHeaderText(null);
        alert.setContentText("I have a great message for you!");
        alert.show();
        Globals.gameLoop.stop();
    }
}
