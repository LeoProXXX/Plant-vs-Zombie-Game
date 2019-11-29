package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BucketheadZombie extends Zombie {
    public BucketheadZombie(int hp,int damage){
        super(hp,damage,new ImageView(new Image("/Photos/buckethead.png")));

    }
    @Override
    public void attack(Character c){

    }


}
