package sample;

import javafx.scene.image.Image;

public class FlagZombie extends Zombie {
    public FlagZombie(int hp,int damage){
        super(hp,damage,new Image("/Photos/flag.png"));

    }
    @Override
    public void attack(Character c){

    }

}
