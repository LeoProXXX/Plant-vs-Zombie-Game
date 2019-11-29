package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LawnMover extends Character {
    public LawnMover(){
        super(new ImageView(new Image("/Photos/lawn_mower.gif")));
    }

    @Override
    public void attack(Character c) {

    }

    @Override
    public void animate() {

    }
}
