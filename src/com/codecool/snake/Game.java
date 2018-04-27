package com.codecool.snake;

import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.LinkedList;

public class Game extends Pane {


    private static final int NUMBER_OF_ENEMIES_AND_POWERUPS = 4;

    public void start() {

        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
            }
        });

        Globals.gameLoop = new GameLoop();
        initializeGame();
        Globals.gameLoop.start();
    }

    private void initButtons() {
        Button restartBtn = new Button("Restart");
        restartBtn.setLayoutY(0);
        restartBtn.setLayoutX(0);
        restartBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                reset();
                initializeGame();
                Globals.gameLoop.start();
            }
        });
        getChildren().add(restartBtn);
    }
    private void initializeGame() {
        new SnakeHead(this, 500, 500);

        for (int i = 1; i <= NUMBER_OF_ENEMIES_AND_POWERUPS; i++) {
            new SimpleEnemy(this);
            new SimplePowerup(this);
        }

        Globals.game = this;
        initButtons();

    }
    private static void reset(){
        Globals.gameLoop.stop();
        Globals.game.getChildren().clear();
        Globals.gameObjects = new LinkedList<>();
        Globals.newGameObjects = new LinkedList<>();
        Globals.oldGameObjects = new LinkedList<>();
        SnakeHead.score = 0;
    }


}
