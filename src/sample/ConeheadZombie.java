package sample;

import javafx.scene.image.Image;

public class ConeheadZombie extends Zombie {
    public ConeheadZombie(int hp,int damage){
        super(hp,damage,new Image("/Photos/conehead.png"));

    }

    @Override
    public void attack(Character c) {

    }
}
