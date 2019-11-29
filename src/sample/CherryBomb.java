package sample;

import javafx.scene.image.Image;

public class CherryBomb extends Plant
{
    public CherryBomb()
    {
        super(100,1000,5,new Image("/Photos/Cherrybomb.jpeg"));
    }
    @Override
    public void attack(Character c)
    {
        c.dechp(1000);
    }
}
