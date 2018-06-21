package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;
import java.util.Random;

public class SimplePowerup extends GameEntity implements Interactable {

    public SimplePowerup(Pane pane) {
        super(pane);
        setImage(Globals.powerupBerry);
        pane.getChildren().add(this);
        setToRandomPosition();
    }

    private void setToRandomPosition() {
        Random rnd = new Random();
        setX(rnd.nextDouble() * (Globals.WINDOW_WIDTH - 30));
        setY(rnd.nextDouble() * (Globals.WINDOW_HEIGHT - 30));
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(2);
        setToRandomPosition();
    }


}
