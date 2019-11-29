package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FlagZombie extends Zombie {
    public FlagZombie(int hp,int damage){
        super(hp,damage,new ImageView(new Image("/Photos/flag.png")));

    }
    @Override
    public void attack(Character c){

    }

}
