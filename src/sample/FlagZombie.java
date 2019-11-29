package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FlagZombie extends Zombie {
    public FlagZombie(int x,int y){
        super(100,40,x,y,new ImageView(new Image("/Photos/flag.png")),new ImageView(new Image("/Photos/flag.png")),10);

    }
    @Override
    public void attack(Characters c){

    }

}