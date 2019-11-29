package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BucketheadZombie extends Zombie {
    public BucketheadZombie(int x,int y){
        super(100,40,new ImageView(new Image("/Photos/buckethead.png")),x,y);

    }
    @Override
    public void attack(Character c){

    }


}