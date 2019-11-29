package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ConeheadZombie extends Zombie {
    public ConeheadZombie(int x,int y){
        super(100,40,new ImageView(new Image("/Photos/conehead.png")),x,y);

    }

    @Override
    public void attack(Character c) {

    }
}