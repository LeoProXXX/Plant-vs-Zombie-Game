package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BucketheadZombie extends Zombie {
    public BucketheadZombie(int x,int y){
        super(100,40,x,y,new ImageView(new Image("/Photos/buckethead.png",100,100,false,false)),new ImageView(new Image("/Photos/zombie_football.gif",100,100,false,false)),0.2);

    }
    @Override
    public void attack(Characters c){

    }


}