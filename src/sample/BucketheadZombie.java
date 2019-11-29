package sample;

import javafx.scene.image.Image;

public class BucketheadZombie extends Zombie {
    public BucketheadZombie(int hp,int damage){
        super(hp,damage,new Image("/Photos/buckethead.png"));

    }
    @Override
    public void attack(Character c){

    }

}
