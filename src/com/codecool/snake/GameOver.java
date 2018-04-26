package com.codecool.snake;

import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public abstract class GameOver extends Application {

    public static void GameOver() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("GAME OVER!");
        alert.setHeaderText(null);
        alert.setContentText("Score: " + Integer.toString((SnakeHead.score)-4));
        alert.show();
        Globals.gameLoop.stop();
    }
}
