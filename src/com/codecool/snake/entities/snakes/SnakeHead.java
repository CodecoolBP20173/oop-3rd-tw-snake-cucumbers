package com.codecool.snake.entities.snakes;

import com.codecool.snake.*;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;

public class SnakeHead extends GameEntity implements Animatable {

    private static final float speed = 2;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    public static int health;
    public static int score = 0;
    Text healthText = new Text();

    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);
        setX(xc);
        setY(yc);
        health = 50;
        tail = this;
        healthText.setLayoutX(900);
        healthText.setLayoutY(15);
        healthText.setVisible(true);
        healthText.setText("Health: "+ Integer.toString(health*2) + '%');
        healthText.setFill(Color.BLACK);

        setImage(Globals.snakeHead);
        pane.getChildren().add(this);
        pane.getChildren().add(healthText);

        addPart(4);
    }

    public void step() {
        double dir = getRotate();
        if (Globals.leftKeyDown) {
            dir = dir - turnRate;
        }
        if (Globals.rightKeyDown) {
            dir = dir + turnRate;
        }
        // set rotation and position
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds() || health <= 0) {
            GameOver.GameOver();
        }
    }

    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart = new SnakeBody(pane, tail);
            tail = newPart;
            score += 1;
        }
    }

    public void setTextHealth(int health) {
        this.healthText.setText("Health: " + String.valueOf(health*2) + '%');
    }

    public void changeHealth(int diff) {
        health += diff;
        setTextHealth(health);
    }
}
