package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

public class SimpleEnemy extends GameEntity implements Animatable, Interactable {

    private Point2D heading;
    private static final int DAMAGE = 10;
    private int speed = 1;
    private boolean isSpawning;


    public SimpleEnemy(Pane pane) {
        super(pane);
        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
        isSpawning = true;
        randomPositionAndDirection(getRandom().nextDouble() * Globals.WINDOW_WIDTH,
                getRandom().nextDouble() * Globals.WINDOW_HEIGHT);
    }

    private void randomPositionAndDirection(double positionX, double positionY) {
        setX(positionX);
        setY(positionY);

        double direction = getRandom().nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
        }

    @Override
    public void step() {
        isSpawning = false;
        if (isOutOfBounds()) {
            randomPositionAndDirection(getX() - heading.getX(),
                    getY() - heading.getY());
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {
        if (!isSpawning) {
            player.changeHealth(-DAMAGE);
        }
        randomPositionAndDirection(getRandom().nextDouble() * Globals.WINDOW_WIDTH,
                getRandom().nextDouble() * Globals.WINDOW_HEIGHT);
    }

    private Random getRandom() {
        return new Random();
    }

}
