package sample;

import javafx.scene.image.Image;

public class Sunflower extends Plant
{
    public Sunflower()
    {
        super(100,0,2,new Image("/Photos/sunflower.png"));
    }
    @Override
    public void attack(Character c)
    {
        c.dechp(0);
    }
}
