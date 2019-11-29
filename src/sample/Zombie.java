package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Zombie extends Character {

    public Zombie(int hp, int damage, ImageView image,int x,int y){
        super(hp,damage,image,x,y);
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