package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Game game = new Game();
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();

        Button restartButton = new Button("Restart");
        restartButton.setMinSize(30, 10);
        restartButton.setVisible(true);
        restartButton.setOnAction(actionEvent ->  {
            game.deleteIfRestart();
            //start(primaryStage);
            //Game game2 = new Game();
        });
        game.getChildren().addAll(restartButton);

        game.start();


    }
}
