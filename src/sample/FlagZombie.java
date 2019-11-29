package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FlagZombie extends Zombie {
    public FlagZombie(int x,int y){
        super(100,40,new ImageView(new Image("/Photos/flag.png")),x,y);

    }
    @Override
    public void attack(Character c){

    }

}