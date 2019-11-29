package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Zombie extends Characters {


    public Zombie(int hp, int damage, int x, int y, ImageView image, ImageView gifimage){

        super(hp,damage,image,x,y,gifimage);
    }
    public Zombie(int x,int y,ImageView image,ImageView gifimage)
    {
        super(100,10,image,x,y,gifimage);
        imageView.relocate(850,460);
    }

    public void moving(){

    }

    @Override
    public void attack(Characters c){

        c.dechp(getDamage());
    }

    @Override
    public void animate() {

        gifimage.setTranslateX(10);
    }
}