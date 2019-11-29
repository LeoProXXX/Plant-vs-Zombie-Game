package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ConeheadZombie extends Zombie {
    public ConeheadZombie(int hp,int damage){
        super(hp,damage,new ImageView(new Image("/Photos/conehead.png")));

    }

    @Override
    public void attack(Character c) {

    }
}
