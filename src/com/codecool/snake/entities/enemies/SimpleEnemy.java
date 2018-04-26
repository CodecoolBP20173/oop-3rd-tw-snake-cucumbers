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

// a simple enemy TODO make better ones.
public class SimpleEnemy extends GameEntity implements Animatable, Interactable {

    private Point2D heading;
    private static final int DAMAGE = 10;
    private int speed = 1;
    private boolean isNotSpawning;


    public SimpleEnemy(Pane pane) {
        super(pane);

        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
        randomPositionAndDirection();
    }

    private void randomPositionAndDirection() {
        isNotSpawning = false;
        if (!isNotSpawning) {
            Random rnd = new Random();
            setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
            setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

            double direction = rnd.nextDouble() * 360;
            setRotate(direction);
            heading = Utils.directionToVector(direction, speed);
        }
        }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        isNotSpawning = true;
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {
        if (isNotSpawning) {
            player.changeHealth(-DAMAGE);
        }
        randomPositionAndDirection();
    }

    @Override
    public String getMessage() {
        return "10 DAMAGE";
    }
}
