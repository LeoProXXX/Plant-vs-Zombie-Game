package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Walnut extends Plant
{
    public Walnut(int x,int y) {
        super(500,0,7,new ImageView(new Image("/Photos/walnut.png")),x,y,new ImageView(new Image("/Photos/walnut_full_life.gif")));
    }

    @Override
    public void attack(Character c)
    {
        c.dechp(0);
    }

    @Override
    public void animate() {

    }
}