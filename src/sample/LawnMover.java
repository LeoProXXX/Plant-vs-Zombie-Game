package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LawnMover extends Characters {
    public LawnMover(){
        super(new ImageView(new Image("/Photos/lawn_mower.gif")),new ImageView(new Image("/Photos/lawn_mower.gif")),10);
    }

    @Override
    public void attack(Characters c) {

    }

    @Override
    public void animate() {

    }
}