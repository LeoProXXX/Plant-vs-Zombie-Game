package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sunflower extends Plant
{
    public Sunflower(int x,int y)
    {
        super(100,0,2,new ImageView(new Image("/Photos/sunflower.png")),x,y);
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