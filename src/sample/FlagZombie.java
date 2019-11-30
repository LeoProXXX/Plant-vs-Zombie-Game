package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FlagZombie extends Zombie {
    public FlagZombie(int x,int y){
        super(150,1,x,y,new ImageView(new Image("/Photos/flag.png",100,100,false,false)),new ImageView(new Image("/Photos/flag.png",100,100,false,false)),0.2,"/Photos/flag.png");

    }

}