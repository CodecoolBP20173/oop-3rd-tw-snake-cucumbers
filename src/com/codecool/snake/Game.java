package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Game extends Pane {

    public Game() {
        /*new SnakeHead(this, 500, 500);

        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);

        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);*/


    }

    public void deleteIfRestart() {
        for (GameEntity entity : Globals.getGameObjects()){
            entity.destroy();
        }
    }

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

    public void initButtons() {
        Button restartBtn = new Button("Restart");
        restartBtn.setLayoutY(0);
        restartBtn.setLayoutX(0);
        restartBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("Restart button pressed");
                reset();
                initializeGame();
                Globals.gameLoop.start();

            }
        });
        getChildren().add(restartBtn);
    }
    public void initializeGame() {
        new SnakeHead(this, 500, 500);

        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);


        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);

        Globals.game = this;
        initButtons();

    }
    public static void reset(){
        Globals.gameLoop.stop();
        Globals.game.getChildren().clear();
        Globals.gameObjects = new LinkedList<>();
        Globals.newGameObjects = new LinkedList<>();
        Globals.oldGameObjects = new LinkedList<>();
        SnakeHead.score = 0;
    }


}
