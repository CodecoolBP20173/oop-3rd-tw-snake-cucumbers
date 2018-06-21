package com.codecool.snake.entities;

import com.codecool.snake.Globals;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class GameEntity extends ImageView {

    protected Pane pane;

    protected GameEntity(Pane pane) {
        this.pane = pane;
        Globals.addGameObject(this);
    }

    protected boolean isOutOfBounds() {
        if (getX() > Globals.WINDOW_WIDTH - 30 || getX() < 0 ||
                getY() > Globals.WINDOW_HEIGHT - 30 || getY() < 0) {
            return true;
        }
        return false;
    }
}
