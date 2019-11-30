package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BucketheadZombie extends Zombie {
    public BucketheadZombie(int x,int y){
        super(300,3,x,y,new ImageView(new Image("/Photos/buckethead.png",100,100,false,false)),new ImageView(new Image("/Photos/BucketheadZombie.gif",100,100,false,false)),0.2,"/Photos/zombie_football.gif");

    }



}