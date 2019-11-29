package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Walnut extends Plant
{
    public Walnut(int x,int y) {
        super(500,0,7,new ImageView(new Image("/Photos/walnut.png")),x,y,new ImageView(new Image("/Photos/walnut_full_life.gif")),0);
    }

    @Override
    public void attack(Characters c)
    {
        c.dechp(0);
    }

    @Override
    public void animate() {

    }
}