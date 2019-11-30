package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NormalZombie extends Zombie {
    public NormalZombie(int x,int y) {
        super(100, 40, x, y, new ImageView(new Image("/Photos/normal_zombie_moving.gif",100,100,false,false)), new ImageView(new Image("/Photos/normal_zombie_moving.gif",100,100,false,false)), 1);

    }
    @Override
    public void attack(Characters c){

    }
    @Override
    public void animate(){
        gifimage.setTranslateX(gifimage.getTranslateX()-getSpeed());
        if(gifimage.getLayoutX()+gifimage.getTranslateX()<200){
            setSpeed(0);
        }

    }
}
