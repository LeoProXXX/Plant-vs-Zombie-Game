package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Zombie extends Character {

    public Zombie(int hp, int damage, int x, int y, ImageView image, ImageView gifimage){

        super(hp,damage,image,x,y,gifimage);
    }

    public void moving(){

    }

    @Override
    public void attack(Character c){

        c.dechp(getDamage());
    }

    @Override
    public void animate() {

        imageView.setTranslateX(10);
    }
}