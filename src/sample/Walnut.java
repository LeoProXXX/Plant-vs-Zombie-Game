package sample;

import javafx.scene.image.Image;

public class Walnut extends Plant
{
    public Walnut() {
        super(500,0,7,new Image("/Photos/walnut.png"));
    }

    @Override
    public void attack(Character c)
    {
        c.dechp(0);
    }
}
